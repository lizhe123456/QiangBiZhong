package com.whmnrc.qiangbizhong.ui.me.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseActivity;
import com.whmnrc.qiangbizhong.base.adapter.BaseAdapter;
import com.whmnrc.qiangbizhong.base.adapter.BaseViewHolder;
import com.whmnrc.qiangbizhong.model.bean.RechargeRrecordBean;
import com.whmnrc.qiangbizhong.presenter.me.RechargePresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/19.
 */

public class RechargeRActivity extends BaseActivity implements RechargePresenter.RechargeRCall{

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.refresh)
    SmartRefreshLayout refresh;
    @BindView(R.id.vs_empty)
    ViewStub vsEmpty;
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;

    RechargeRAdapter rechargeRAdapter;

    RechargePresenter rechargePresenter;

    public static void start(Context context) {
        Intent starter = new Intent(context, RechargeRActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected int setLayout() {
        return R.layout.activity_recharger;
    }

    @Override
    protected void setData() {
        ivBack.setVisibility(View.VISIBLE);
        tvTitle.setText("充值记录");
        rechargeRAdapter = new RechargeRAdapter(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(rechargeRAdapter);
        rechargePresenter = new RechargePresenter(this);
        showLoading("加载中..");
        rechargePresenter.recordquery(this,true);
        refresh.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(RefreshLayout refreshLayout) {
                rechargePresenter.recordquery(RechargeRActivity.this,false);
            }
        });

        refresh.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshLayout) {
                rechargePresenter.recordquery(RechargeRActivity.this,true);
            }
        });
    }




    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        this.finish();
    }

    @Override
    public void error() {
        refresh.finishLoadMore(false);
        refresh.finishRefresh(false);
    }

    @Override
    public void rechargeBack(List<RechargeRrecordBean> rechargeRrecordBeans) {
        if (rechargeRrecordBeans.size() == 0){
            showEmpty();
            recyclerView.setVisibility(View.GONE);
        }else {
            if (vsEmpty.getParent() == null) {
                vsEmpty.setVisibility(View.GONE);
            }
            recyclerView.setVisibility(View.VISIBLE);
        }
        rechargeRAdapter.addFirstDataSet(rechargeRrecordBeans);
        refresh.finishRefresh(true);
    }

    @Override
    public void loadMore(List<RechargeRrecordBean> rechargeRrecordBeans) {
        rechargeRAdapter.addMoreDataSet(rechargeRrecordBeans);
        refresh.finishLoadMore(true);
    }

    public class RechargeRAdapter extends BaseAdapter<RechargeRrecordBean> {

        public RechargeRAdapter(Context context) {
            super(context);
        }

        @Override
        protected void bindDataToItemView(BaseViewHolder holder, RechargeRrecordBean item, int position) {
            holder.setText(R.id.tv_title,"豆子充值").setText(R.id.tv_time,item.getCreateDate()).setText(R.id.tv_price,item.getExchangeNumber()+"");
        }

        @Override
        protected int getItemViewLayoutId(int position, RechargeRrecordBean item) {
            return R.layout.item_recharge_r;
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
