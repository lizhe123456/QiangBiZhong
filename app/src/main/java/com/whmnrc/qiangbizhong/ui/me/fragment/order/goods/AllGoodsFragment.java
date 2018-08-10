package com.whmnrc.qiangbizhong.ui.me.fragment.order.goods;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseFragment;
import com.whmnrc.qiangbizhong.base.adapter.BaseAdapter;
import com.whmnrc.qiangbizhong.model.bean.GoodsManageBean;
import com.whmnrc.qiangbizhong.model.bean.ShopDetailsBean;
import com.whmnrc.qiangbizhong.model.parameter.GoodsParam;
import com.whmnrc.qiangbizhong.presenter.shop.GoodsPresenter;
import com.whmnrc.qiangbizhong.ui.me.activity.GoodsManageActivity;
import com.whmnrc.qiangbizhong.ui.me.adapter.GoodManageAdapter;
import com.whmnrc.qiangbizhong.ui.shop.activity.ShopDetailsActivity;
import com.whmnrc.qiangbizhong.util.UserManage;
import com.whmnrc.qiangbizhong.widget.AlertDialog;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/23.
 */

public class AllGoodsFragment extends BaseFragment implements GoodsPresenter.GoodsListCall, GoodManageAdapter.OnGoodsManageListener,GoodsPresenter.GoodsGoupCall {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.refresh)
    SmartRefreshLayout refresh;
    @BindView(R.id.vs_empty)
    ViewStub vsEmpty;

    private GoodsPresenter goodsPresenter;

    private GoodManageAdapter goodManageAdapter;
    private String type;

    public static AllGoodsFragment newInstance(String type) {
        Bundle args = new Bundle();
        args.putString("type",type);
        AllGoodsFragment fragment = new AllGoodsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_all_goods;
    }


    @Override

    public void setUserVisibleHint(boolean isVisibleToUser) {

        super.setUserVisibleHint(isVisibleToUser);

        if (isVisibleToUser) {
            // 相当于onResume()方法--获取焦点
            if (goodsPresenter != null){
                goodsPresenter.getgoodslist(type, UserManage.getInstance().getLoginBean().getStoreInfo().getId(), true, this);
            }
        }

    }

    @Override
    protected void initData() {
        goodsPresenter = new GoodsPresenter(getContext());
        type = getArguments().getString("type");
        goodsPresenter.getgoodslist(type, UserManage.getInstance().getLoginBean().getStoreInfo().getId(), true, this);
        goodManageAdapter = new GoodManageAdapter(getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(goodManageAdapter);
        refresh.setOnRefreshListener(refreshLayout -> {
            goodsPresenter.getgoodslist(type, UserManage.getInstance().getLoginBean().getStoreInfo().getId(), true, this);
        });

        refresh.setOnLoadMoreListener(refreshLayout -> {
            goodsPresenter.getgoodslist(type, UserManage.getInstance().getLoginBean().getStoreInfo().getId(), false, this);
        });

        goodManageAdapter.setOnGoodsManageListener(this);

        goodManageAdapter.setOnItemClickListener(new BaseAdapter.OnItemClickListener() {
            @Override
            public void onClick(View view, Object item, int position) {
                GoodsManageBean goodsManageBean = (GoodsManageBean) item;
                ShopDetailsActivity.start(getContext(),goodsManageBean.getGoods_ID());
            }
        });


    }

    @Override
    public void error() {
        refresh.finishRefresh(false);
        refresh.finishLoadMore(false);
    }

    @Override
    public void getGoods(@NonNull List<GoodsManageBean> goodsParamList) {
        if (goodsParamList.size() == 0){
            showEmpty();
        }else {
            if (vsEmpty != null) {
                vsEmpty.setVisibility(View.GONE);
            }
            if (recyclerView != null) {
                recyclerView.setVisibility(View.VISIBLE);
            }
        }
        goodManageAdapter.addFirstDataSet(goodsParamList);
        if (refresh != null) {
            refresh.finishRefresh(true);
        }
    }

    public void showEmpty() {
        if (vsEmpty.getParent() != null) {
            View view = vsEmpty.inflate();
            ImageView imageView = view.findViewById(R.id.iv_empty);
            TextView textView = view.findViewById(R.id.tv_text);
            imageView.setImageResource(R.drawable.ic_empty_public);
            textView.setText("");
            textView.setTextColor(getResources().getColor(R.color.tv_navigation));
        }
        vsEmpty.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.GONE);
    }

    @Override
    public void loadMore(@NonNull List<GoodsManageBean> goodsParamList) {
        goodManageAdapter.addMoreDataSet(goodsParamList);
        refresh.finishLoadMore(true);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void update(GoodsManageActivity.Update update){
        goodsPresenter.getgoodslist(type, UserManage.getInstance().getLoginBean().getStoreInfo().getId(), true, this);
    }

    //下架商品
    @Override
    public void lowerFrame(GoodsManageBean item) {
        new AlertDialog(getContext()).builder().setMsg("本次商品确定下架吗？")
                .setNegativeButton("取消", new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        }).setPositiveButton("确认", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goodsPresenter.setgoodsgoup(item.getGoods_ID(),0,AllGoodsFragment.this);
            }
        }).show();
    }

    //上架商品
    @Override
    public void exhibitGoods(GoodsManageBean item) {
        new AlertDialog(getContext()).builder().setMsg("本次商品确定上架吗？")
                .setNegativeButton("取消", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                }).setPositiveButton("确认", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goodsPresenter.setgoodsgoup(item.getGoods_ID(),1,AllGoodsFragment.this);
            }
        }).show();
    }

    @Override
    public void goodsgoup() {
        goodsPresenter.getgoodslist(type, UserManage.getInstance().getLoginBean().getStoreInfo().getId(), true, this);
    }
}
