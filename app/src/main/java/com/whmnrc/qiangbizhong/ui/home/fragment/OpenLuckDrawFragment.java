package com.whmnrc.qiangbizhong.ui.home.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.blankj.utilcode.util.ScreenUtils;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseFragment;
import com.whmnrc.qiangbizhong.base.adapter.BaseAdapter;
import com.whmnrc.qiangbizhong.base.adapter.BaseViewHolder;
import com.whmnrc.qiangbizhong.model.bean.LuckDrawGoodsBean;
import com.whmnrc.qiangbizhong.presenter.home.LuckDrawPresenter;
import com.whmnrc.qiangbizhong.ui.home.activity.AwardDetailActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/11.
 */

public class OpenLuckDrawFragment extends BaseFragment implements LuckDrawPresenter.LuckDrawCall{

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.refresh)
    SmartRefreshLayout refresh;
    @BindView(R.id.vs_empty)
    ViewStub vsEmpty;

    private LuckDrawPresenter luckDrawPresenter;
    private OpenLuckDrawAdapter openLuckDrawAdapter;

    public static OpenLuckDrawFragment newInstance(int type) {

        Bundle args = new Bundle();
        args.putInt("type", type);
        OpenLuckDrawFragment fragment = new OpenLuckDrawFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    protected int setLayout() {
        return R.layout.fragment_open_luck_draw;
    }

    @Override
    protected void initData() {
        openLuckDrawAdapter = new OpenLuckDrawAdapter(mContext);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(openLuckDrawAdapter);
        luckDrawPresenter = new LuckDrawPresenter(mContext);
        showLoading("加载中..");
        luckDrawPresenter.awardlist2(0, this,true);

        openLuckDrawAdapter.setOnItemClickListener(new BaseAdapter.OnItemClickListener() {
            @Override
            public void onClick(View view, Object item, int position) {
                LuckDrawGoodsBean luckDrawGoodsBean = (LuckDrawGoodsBean) item;
                AwardDetailActivity.start(getContext(),luckDrawGoodsBean.getGoodsAwardId(),luckDrawGoodsBean.getUserId());
            }
        });

        refresh.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshLayout) {
                luckDrawPresenter.awardlist2(0, OpenLuckDrawFragment.this,true);
            }
        });

        refresh.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(RefreshLayout refreshLayout) {
                luckDrawPresenter.awardlist2(0, OpenLuckDrawFragment.this,false);
            }
        });
    }
    @Override
    public void luckDrawBack(@NonNull List<LuckDrawGoodsBean> luckDrawGoodsBeans) {
        if (luckDrawGoodsBeans.size() == 0){
            showEmpty();
            recyclerView.setVisibility(View.GONE);
        }else {
            if (vsEmpty.getParent() == null) {
                vsEmpty.setVisibility(View.GONE);
            }
            recyclerView.setVisibility(View.VISIBLE);
        }
        openLuckDrawAdapter.addFirstDataSet(luckDrawGoodsBeans);
        refresh.finishRefresh(true);
    }

    @Override
    public void loadMore(@NonNull List<LuckDrawGoodsBean> luckDrawGoodsBean) {
        openLuckDrawAdapter.addMoreDataSet(luckDrawGoodsBean);
        refresh.finishLoadMore(true);
    }

    @Override
    public void error() {
        refresh.finishRefresh(false);
        refresh.finishLoadMore(false);
    }




    class OpenLuckDrawAdapter extends BaseAdapter<LuckDrawGoodsBean> {

        private int width;

        private OpenLuckDrawAdapter(Context context) {
            super(context);
            width = ((ScreenUtils.getScreenWidth() - 45)/2);
        }

        @Override
        protected void bindDataToItemView(BaseViewHolder holder, LuckDrawGoodsBean item, int position) {
            holder.setText(R.id.tv_time,item.getAwardTime()).setText(R.id.tv_name,item.getUserNick()).setGlieuImage(R.id.iv_img,item.getProduct_ImgPath());

            ImageView imageView = holder.getView(R.id.iv_img);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) imageView.getLayoutParams();
            layoutParams.width = width;
            layoutParams.height = width;
            imageView.setLayoutParams(layoutParams);
        }

        @Override
        protected int getItemViewLayoutId(int position, LuckDrawGoodsBean item) {
            return R.layout.item_open_luch_wait;
        }
    }

    public void showEmpty() {
        if (vsEmpty.getParent() != null) {
            View view = vsEmpty.inflate();
            ImageView imageView = view.findViewById(R.id.iv_empty);
            TextView textView = view.findViewById(R.id.tv_text);
            imageView.setImageResource(R.drawable.ic_empty_order);
            textView.setText("暂无更多数据~");
            vsEmpty.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.GONE);
        }
    }

}
