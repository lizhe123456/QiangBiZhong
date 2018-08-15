package com.whmnrc.qiangbizhong.ui.me.activity;

import android.content.Context;
import android.content.Intent;
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
import com.whmnrc.qiangbizhong.model.bean.CouponBean;
import com.whmnrc.qiangbizhong.presenter.me.CouponPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/21.
 */

public class CouponActivity extends BaseActivity implements CouponPresenter.CouponListCall{

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.refresh)
    SmartRefreshLayout refresh;
    @BindView(R.id.vs_empty)
    ViewStub vsEmpty;

    private CouponAdapter mCouponAdapter;
    private CouponPresenter couponPresenter;

    public static void start(Context context) {
        Intent starter = new Intent(context, CouponActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected int setLayout() {
        return R.layout.activity_coupon;
    }

    @Override
    protected void setData() {
        ivBack.setVisibility(View.VISIBLE);
        tvTitle.setText("我的抵用券");
        mCouponAdapter = new CouponAdapter(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(mCouponAdapter);
        couponPresenter = new CouponPresenter(this);
        couponPresenter.getcouponlist(true,this);

        refresh.setOnRefreshListener(refreshLayout -> {
            couponPresenter.getcouponlist(true,this);
        });
        refresh.setOnLoadMoreListener(refreshLayout -> {
            couponPresenter.getcouponlist(false,this);
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
    public void getcouponlist(List<CouponBean> couponBeans) {
        if (couponBeans.size() == 0){
            showEmpty();
        }else {
            vsEmpty.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);
        }
        mCouponAdapter.addFirstDataSet(couponBeans);
        refresh.finishRefresh(true);
    }

    @Override
    public void loadMore(List<CouponBean> couponBeans) {
        mCouponAdapter.addMoreDataSet(couponBeans);
        refresh.finishLoadMore(true);
    }

    public void showEmpty() {
        if (vsEmpty.getParent() != null) {
            View view = vsEmpty.inflate();
            ImageView imageView = view.findViewById(R.id.iv_empty);
            TextView textView = view.findViewById(R.id.tv_text);
            imageView.setImageResource(R.drawable.ic_empty_coupon);
            textView.setText("暂无更多抵用券~");
        }
        vsEmpty.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.GONE);
    }

    class CouponAdapter extends BaseAdapter<CouponBean> {

        public CouponAdapter(Context context) {
            super(context);
        }

        @Override
        protected void bindDataToItemView(BaseViewHolder holder, CouponBean item, int position) {
            holder.setText(R.id.tv_time,"使用期限 "+item.getStartDate()+"-"+item.getEndDate()).setText(R.id.tv_name,item.getName()).setText(R.id.tv_limit,item.getCondition_desc());
        }

        @Override
        protected int getItemViewLayoutId(int position, CouponBean item) {
            return R.layout.item_coupon_list;
        }
    }
}
