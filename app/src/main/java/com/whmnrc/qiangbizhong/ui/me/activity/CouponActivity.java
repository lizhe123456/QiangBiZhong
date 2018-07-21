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
import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseActivity;
import com.whmnrc.qiangbizhong.base.adapter.BaseAdapter;
import com.whmnrc.qiangbizhong.base.adapter.BaseViewHolder;
import com.whmnrc.qiangbizhong.model.bean.CouponBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/21.
 */

public class CouponActivity extends BaseActivity {

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
        List<CouponBean> couponBeans = new ArrayList<>();
        couponBeans.add(new CouponBean("使用期限 2018.06.06-2018.06.15","抽奖抵用券","仅限于[限时抽奖]活动专属"));
        couponBeans.add(new CouponBean("使用期限 2018.06.06-2018.06.15","抽奖抵用券","仅限于[限时抽奖]活动专属"));
        mCouponAdapter.addFirstDataSet(couponBeans);
    }


    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        this.finish();
    }

    class CouponAdapter extends BaseAdapter<CouponBean> {

        public CouponAdapter(Context context) {
            super(context);
        }

        @Override
        protected void bindDataToItemView(BaseViewHolder holder, CouponBean item, int position) {
            holder.setText(R.id.tv_time,item.getTime()).setText(R.id.tv_name,item.getName()).setText(R.id.tv_limit,item.getLimit());
        }

        @Override
        protected int getItemViewLayoutId(int position, CouponBean item) {
            return R.layout.item_coupon_list;
        }
    }
}
