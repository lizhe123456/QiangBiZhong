package com.whmnrc.qiangbizhong.ui.home.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Size;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.blankj.utilcode.util.DeviceUtils;
import com.blankj.utilcode.util.ScreenUtils;
import com.blankj.utilcode.util.SizeUtils;
import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseActivity;
import com.whmnrc.qiangbizhong.base.adapter.BaseAdapter;
import com.whmnrc.qiangbizhong.base.adapter.BaseViewHolder;
import com.whmnrc.qiangbizhong.model.bean.FlashSaleBean;
import com.whmnrc.qiangbizhong.model.bean.KillGoodsBean;
import com.whmnrc.qiangbizhong.presenter.home.FlashSalePresenter;
import com.whmnrc.qiangbizhong.ui.shop.activity.FlashSaleDetailsActivity;
import com.whmnrc.qiangbizhong.ui.shop.fragment.GoodsDetailsFragment;
import com.whmnrc.qiangbizhong.util.GlideuUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/9.
 * 限时特价
 */

public class FlashSaleActivity extends BaseActivity implements FlashSalePresenter.FlashSaleCall{

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.rv_navigation)
    RecyclerView rvNavigation;
    @BindView(R.id.rv_goods)
    RecyclerView rvGoods;
    @BindView(R.id.tv_goods_name)
    TextView tvGoodsName;
    @BindView(R.id.tv_desc)
    TextView tvDesc;
    @BindView(R.id.tv_purchased_num)
    TextView tvPurchasedNum;
    @BindView(R.id.tv_price)
    TextView tvPrice;
    @BindView(R.id.tv_old_price)
    TextView tvOldPrice;
    @BindView(R.id.tv_surplus)
    TextView tvSurplus;
    @BindView(R.id.tv_confirm)
    TextView tvConfirm;
    @BindView(R.id.iv_img)
    ImageView ivImg;

    private TimeAdapter timeAdapter;
    private GoodsAdapter goodsAdapter;

    /**
     * 目标项是否在最后一个可见项之后
     */
    private boolean mShouldScroll;
    /**
     * 记录目标项位置
     */
    private int mToPosition;
    private KillGoodsBean killGoodsBeans;

    public static void start(Context context) {
        Intent starter = new Intent(context, FlashSaleActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected int setLayout() {
        return R.layout.activity_flash_sale;
    }

    @Override
    protected void setData() {
        ivBack.setVisibility(View.VISIBLE);
        tvTitle.setText("限时特价");
        FlashSaleBean flashSaleBean = new FlashSaleBean();
        flashSaleBean.initData();
        timeAdapter = new TimeAdapter(this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        rvNavigation.setLayoutManager(layoutManager);
        rvNavigation.setAdapter(timeAdapter);
        timeAdapter.addFirstDataSet(flashSaleBean.getTimeBeans());
        timeAdapter.setOnItemClickListener((view, item, position) -> {
            timeAdapter.setSelect(position);
            smoothMoveToPosition(rvNavigation,position);
        });
        FlashSalePresenter flashSalePresenter = new FlashSalePresenter(this);
        flashSalePresenter.getFlashSale("22:00",this);
    }

    private void smoothMoveToPosition(RecyclerView mRecyclerView, final int position) {
        // 第一个可见位置
        int firstItem = mRecyclerView.getChildLayoutPosition(mRecyclerView.getChildAt(0));
        // 最后一个可见位置
        int lastItem = mRecyclerView.getChildLayoutPosition(mRecyclerView.getChildAt(mRecyclerView.getChildCount() - 1));

        if (position < firstItem) {
            // 如果跳转位置在第一个可见位置之前，就smoothScrollToPosition可以直接跳转
            mRecyclerView.smoothScrollToPosition(position);
        } else if (position <= lastItem) {
            // 跳转位置在第一个可见项之后，最后一个可见项之前
            // smoothScrollToPosition根本不会动，此时调用smoothScrollBy来滑动到指定位置
            int movePosition = position - firstItem;
            if (movePosition >= 0 && movePosition < mRecyclerView.getChildCount()) {
                int top = mRecyclerView.getChildAt(movePosition).getTop();
                mRecyclerView.smoothScrollBy(0, top);
            }
        } else {
            // 如果要跳转的位置在最后可见项之后，则先调用smoothScrollToPosition将要跳转的位置滚动到可见位置
            // 再通过onScrollStateChanged控制再次调用smoothMoveToPosition，执行上一个判断中的方法
            mRecyclerView.smoothScrollToPosition(position);
            mToPosition = position;
            mShouldScroll = true;
        }
    }


    @OnClick({R.id.iv_back,R.id.tv_confirm})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                this.finish();
                break;
            case R.id.tv_confirm:
                FlashSaleDetailsActivity.start(this,killGoodsBeans.getHotGoods().getRushId());
                break;
        }

    }

    @Override
    public void onKillGoodsBack(KillGoodsBean killGoodsBeans) {
//        timeAdapter.addFirstDataSet(killGoodsBeans);
        this.killGoodsBeans = killGoodsBeans;
        initKill(killGoodsBeans);
    }

    private void initKill(KillGoodsBean killGoodsBeans) {
        goodsAdapter = new GoodsAdapter(this);
        rvGoods.setLayoutManager(new LinearLayoutManager(this));
        rvGoods.setAdapter(goodsAdapter);
        goodsAdapter.addFirstDataSet(killGoodsBeans.getGoods());
        tvGoodsName.setText(killGoodsBeans.getHotGoods().getGoods_Name());
        tvDesc.setText(killGoodsBeans.getHotGoods().getGoods_Name());
        tvPurchasedNum.setText("已抢购"+String.valueOf(killGoodsBeans.getHotGoods().getBond())+"件");
        tvPrice.setText(String.valueOf(killGoodsBeans.getHotGoods().getPrice()));
        tvOldPrice.setText(String.valueOf(killGoodsBeans.getHotGoods().getGoodsPrice_Price()));
        tvSurplus.setText("仅剩"+String.valueOf(killGoodsBeans.getHotGoods().getRushNumber())+"件");
        GlideuUtil.loadImageView(this,killGoodsBeans.getHotGoods().getGoods_ImaPath(),ivImg);
    }


    class TimeAdapter extends BaseAdapter<FlashSaleBean.TimeBean> {
        private int width;

        private int index;

        public TimeAdapter(Context context) {
            super(context);
            width = ScreenUtils.getScreenWidth()/5;
        }

        @Override
        protected void bindDataToItemView(final BaseViewHolder holder, FlashSaleBean.TimeBean item, int position) {
            holder.setText(R.id.tv_time, item.getTime()).setText(R.id.tv_name, item.getName());
            RelativeLayout imageView = holder.getView(R.id.rl_time);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) imageView.getLayoutParams();
            layoutParams.width = width;
            if (item.isSelect()) {
                holder.setBackgroundResource(R.id.rl_time, R.drawable.ic_time_bg);
                layoutParams.height = SizeUtils.dp2px((float) 65.2);
            } else {

                holder.setBackgroundResource(R.id.rl_time, R.drawable.bg_000);
                layoutParams.height = SizeUtils.dp2px(61);
            }
            imageView.setLayoutParams(layoutParams);
        }

        @Override
        protected int getItemViewLayoutId(int position, FlashSaleBean.TimeBean item) {
            return R.layout.item_list_time;
        }

        private void setSelect(int position){
            for (FlashSaleBean.TimeBean timeBean :getDataSource()) {
                timeBean.setSelect(false);
            }
            getDataSource().get(position).setSelect(true);
            notifyDataSetChanged();
        }
    }

    class GoodsAdapter extends BaseAdapter<KillGoodsBean.GoodsBean> {

        private GoodsAdapter(Context context) {
            super(context);
        }

        @Override
        protected void bindDataToItemView(BaseViewHolder holder, KillGoodsBean.GoodsBean item, int position) {
            holder.setText(R.id.tv_goods_name,item.getGoods_Name())
                    .setText(R.id.tv_desc, "")
                    .setText(R.id.tv_purchased_num, "已抢购"+item.getBond()+"件")
                    .setText(R.id.tv_price,String.valueOf(item.getGoodsPrice_Price()))
                    .setText(R.id.tv_old_price,String.valueOf(item.getGoodsPrice_Price()))
                    .setText(R.id.tv_surplus, "仅剩"+item.getRushNumber()+"件")
                    .setGlieuImage(R.id.iv_img,item.getGoods_ImaPath());

            holder.setOnClickListener(R.id.tv_confirm, new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    FlashSaleDetailsActivity.start(getContext(),item.getRushId());
                }
            });
        }

        @Override
        protected int getItemViewLayoutId(int position, KillGoodsBean.GoodsBean item) {
            return R.layout.item_list_goods;
        }
    }
}
