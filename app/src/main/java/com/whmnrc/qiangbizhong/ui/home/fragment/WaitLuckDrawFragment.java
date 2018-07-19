package com.whmnrc.qiangbizhong.ui.home.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
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
import com.whmnrc.qiangbizhong.model.bean.LuckDrawBean;
import com.whmnrc.qiangbizhong.model.bean.LuckDrawGoodsBean;
import com.whmnrc.qiangbizhong.model.bean.LuckDrawGoodsBeanV2;
import com.whmnrc.qiangbizhong.presenter.home.LuckDrawPresenter;
import com.whmnrc.qiangbizhong.ui.home.activity.AwardDetailActivity;
import com.whmnrc.qiangbizhong.ui.shop.activity.FlashSaleDetailsActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/11.
 */

public class WaitLuckDrawFragment extends BaseFragment implements LuckDrawPresenter.LuckDrawCall2{


    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.refresh)
    SmartRefreshLayout refresh;
    @BindView(R.id.vs_empty)
    ViewStub vsEmpty;

    private LuckDrawPresenter luckDrawPresenter;
    private OpenLuckDrawAdapter adapter;

    @Override
    protected int setLayout() {
        return R.layout.fragment_wait_luck_draw;
    }

    @Override
    protected void initData() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),2);
        recyclerView.setLayoutManager(gridLayoutManager);
        adapter = new OpenLuckDrawAdapter(mContext);
        recyclerView.setAdapter(adapter);
        luckDrawPresenter = new LuckDrawPresenter(mContext);
        showLoading("加载中..");
        luckDrawPresenter.awardlist2(1,this,true);
        adapter.setOnItemClickListener(new BaseAdapter.OnItemClickListener() {
            @Override
            public void onClick(View view, Object item, int position) {
                LuckDrawGoodsBeanV2 luckDrawGoodsBean = (LuckDrawGoodsBeanV2) item;
                AwardDetailActivity.start(getContext(),luckDrawGoodsBean.getAwardId());
            }
        });

        refresh.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshLayout) {
                luckDrawPresenter.awardlist2(1, WaitLuckDrawFragment.this,true);
            }
        });

        refresh.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(RefreshLayout refreshLayout) {
                luckDrawPresenter.awardlist2(1, WaitLuckDrawFragment.this,false);
            }
        });
    }

    @Override
    public void luckDrawBack(List<LuckDrawGoodsBeanV2> luckDrawGoodsBeans) {
        if (luckDrawGoodsBeans.size() == 0){
            showEmpty();
            recyclerView.setVisibility(View.GONE);
        }else {
            if (vsEmpty.getParent() == null) {
                vsEmpty.setVisibility(View.GONE);
            }
            recyclerView.setVisibility(View.VISIBLE);
        }
        adapter.addFirstDataSet(luckDrawGoodsBeans);
        refresh.finishRefresh(true);
    }

    @Override
    public void loadMore(List<LuckDrawGoodsBeanV2> luckDrawGoodsBean) {
        adapter.addMoreDataSet(luckDrawGoodsBean);
        refresh.finishLoadMore(true);
    }

    @Override
    public void error() {
        refresh.finishRefresh(false);
        refresh.finishLoadMore(false);
    }


    class OpenLuckDrawAdapter extends BaseAdapter<LuckDrawGoodsBeanV2> {

        private int width;

        private OpenLuckDrawAdapter(Context context) {
            super(context);
            width = ((ScreenUtils.getScreenWidth() - 45) / 2);
        }

        @Override
        protected void bindDataToItemView(BaseViewHolder holder, LuckDrawGoodsBeanV2 item, int position) {
            holder.setText(R.id.tv_goods_name, item.getGoods_Name())
                    .setText(R.id.tv_time, "距离开奖："+item.getAwardTime())
                    .setText(R.id.tv_surplus, "已有"+item.getAwardPeopleCount()+"人抢购")
                    .setGlieuImage(R.id.iv_img, item.getGoods_ImaPath());

            ImageView imageView = holder.getView(R.id.iv_img);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) imageView.getLayoutParams();
            layoutParams.width = width;
            layoutParams.height = width;
            imageView.setLayoutParams(layoutParams);
        }

        @Override
        protected int getItemViewLayoutId(int position, LuckDrawGoodsBeanV2 item) {
            return R.layout.item_open_luch_open;
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
