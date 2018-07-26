package com.whmnrc.qiangbizhong.ui.home.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.blankj.utilcode.util.ScreenUtils;
import com.blankj.utilcode.util.SizeUtils;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseActivity;
import com.whmnrc.qiangbizhong.base.adapter.BaseAdapter;
import com.whmnrc.qiangbizhong.base.adapter.BaseViewHolder;
import com.whmnrc.qiangbizhong.model.bean.FlashSaleBean;
import com.whmnrc.qiangbizhong.model.bean.KillGoodsBean;
import com.whmnrc.qiangbizhong.presenter.home.FlashSalePresenter;
import com.whmnrc.qiangbizhong.ui.shop.activity.FlashSaleDetailsActivity;
import com.whmnrc.qiangbizhong.util.GlideuUtil;
import com.whmnrc.qiangbizhong.util.TimeUtils;
import com.whmnrc.qiangbizhong.util.UserManage;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/9.
 * 限时特价
 */

public class FlashSaleActivity extends BaseActivity implements FlashSalePresenter.FlashSaleCall,FlashSalePresenter.FlashSaleTimeCall{

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
    @BindView(R.id.refresh)
    SmartRefreshLayout refreshLayout;
    @BindView(R.id.vs_empty)
    ViewStub vsEmpty;
    @BindView(R.id.rl_layout)
    RelativeLayout relativeLayout;
    @BindView(R.id.rl_all)
    RelativeLayout rlAll;

    private TimeAdapter timeAdapter;

    /**
     * 记录目标项位置
     */
    private int mToPosition = 0;
    private KillGoodsBean killGoodsBeans;
    List<FlashSaleBean.TimeBean> strings;
    FlashSalePresenter flashSalePresenter;

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
        timeAdapter = new TimeAdapter(this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        rvNavigation.setLayoutManager(layoutManager);
        rvNavigation.setAdapter(timeAdapter);
        timeAdapter.setOnItemClickListener((view, item, position) -> {
            if (mToPosition != position) {
                FlashSaleBean.TimeBean timeBean = (FlashSaleBean.TimeBean) item;
                mToPosition = position;
                timeAdapter.setSelect(position);
                showLoading("加载中..");
                flashSalePresenter.getFlashSale(timeBean.getTime(), this, true);
            }
        });
        flashSalePresenter = new FlashSalePresenter(this);
        showLoading("加载中..");
        flashSalePresenter.goodsrushtimelist(this);
        refreshLayout.setOnRefreshListener(refreshLayout -> flashSalePresenter.goodsrushtimelist(FlashSaleActivity.this));

        refreshLayout.setOnLoadMoreListener(refreshLayout ->{
            if (strings != null) {
                flashSalePresenter.getFlashSale(strings.get(mToPosition).getTime(), FlashSaleActivity.this, false);
            }
        });
    }


    public void showEmpty() {
        if (vsEmpty.getParent() != null) {
            View view = vsEmpty.inflate();
            ImageView imageView = view.findViewById(R.id.iv_empty);
            TextView textView = view.findViewById(R.id.tv_text);
            imageView.setImageResource(R.drawable.ic_empty_order);
            textView.setText("暂无更多数据~");
            vsEmpty.setVisibility(View.VISIBLE);
            rvGoods.setVisibility(View.GONE);
        }
    }



    @OnClick({R.id.iv_back,R.id.tv_confirm})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                this.finish();
                break;
            case R.id.tv_confirm:
                if (killGoodsBeans != null) {
                    FlashSaleDetailsActivity.start(this, killGoodsBeans.getHotGoods().getRushId(), 0);
                }
                break;
        }

    }

    @Override
    public void onKillGoodsBack(KillGoodsBean killGoodsBeans) {
        this.killGoodsBeans = killGoodsBeans;
        initKill(killGoodsBeans);
        refreshLayout.finishRefresh(true);
    }

    @Override
    public void loadMore(KillGoodsBean killGoodsBean) {
        initKill(killGoodsBeans);
        refreshLayout.finishLoadMore(true);

    }

    @SuppressLint("SetTextI18n")
    private void initKill(KillGoodsBean killGoodsBeans) {
        GoodsAdapter goodsAdapter = new GoodsAdapter(this);
        rvGoods.setLayoutManager(new LinearLayoutManager(this));
        rvGoods.setAdapter(goodsAdapter);
        if (killGoodsBeans.getHotGoods() == null && killGoodsBeans.getGoods().size() == 0){
            showEmpty();
            rvGoods.setVisibility(View.GONE);
            rlAll.setVisibility(View.GONE);
        }else {
            goodsAdapter.addFirstDataSet(killGoodsBeans.getGoods());
            if (killGoodsBeans.getHotGoods() != null) {
                tvGoodsName.setText(killGoodsBeans.getHotGoods().getGoods_Name());
                tvPurchasedNum.setText("仅剩"+killGoodsBeans.getHotGoods().getGoodsPrice_Stock()+"件");
                tvPrice.setText(String.valueOf(killGoodsBeans.getHotGoods().getGoodsPrice_Price()));
                tvOldPrice.setText(String.valueOf(killGoodsBeans.getHotGoods().getGoodsPrice_VirtualPrice()));
                tvSurplus.setText("已抢" + String.valueOf(killGoodsBeans.getHotGoods().getRushNumber()) + "件");
                GlideuUtil.loadImageView(this, killGoodsBeans.getHotGoods().getGoods_ImaPath(), ivImg);
                if (killGoodsBeans.getHotGoods().getIsEnd() == 0){
                    tvConfirm.setText("立即预约");
                    tvConfirm.setBackgroundResource(R.drawable.bg_red_v2);
                }else if (killGoodsBeans.getHotGoods().getIsEnd() == 1){
                    tvConfirm.setText("立即抢购");
                    tvConfirm.setBackgroundResource(R.drawable.bg_red_v2);
                }else if (killGoodsBeans.getHotGoods().getIsEnd() == 2){
                    tvConfirm.setText("已结束");
                    tvConfirm.setBackgroundResource(R.drawable.bg_red_v3);
                }

            }
            if (vsEmpty.getParent() == null) {
                vsEmpty.setVisibility(View.GONE);
            }
            rvGoods.setVisibility(View.VISIBLE);
            rlAll.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void error() {
        refreshLayout.finishRefresh(false);
        refreshLayout.finishLoadMore(false);
    }

    @Override
    public void onFlashSaleTime(@NonNull List<FlashSaleBean.TimeBean> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getS() == 1){
                mToPosition = i;
                break;
            }
        }
        strings = list;
        if (strings.size() > 0) {
            flashSalePresenter.getFlashSale(list.get(mToPosition).getTime(), this,true);
            timeAdapter.addFirstDataSet(list);
            timeAdapter.setSelect(mToPosition);
            rvGoods.smoothScrollToPosition(mToPosition);
            if (vsEmpty.getParent() == null) {
                vsEmpty.setVisibility(View.GONE);
            }
            rvGoods.setVisibility(View.VISIBLE);
            rlAll.setVisibility(View.VISIBLE);
        }else {
            showEmpty();
            rvGoods.setVisibility(View.GONE);
            rlAll.setVisibility(View.GONE);
        }
        refreshLayout.finishRefresh(true);
    }


    class TimeAdapter extends BaseAdapter<FlashSaleBean.TimeBean> {
        private int width;


        private TimeAdapter(Context context) {
            super(context);
        }

        @Override
        protected void bindDataToItemView(final BaseViewHolder holder, FlashSaleBean.TimeBean item, int position) {
            holder.setText(R.id.tv_time, item.getTime()).setText(R.id.tv_name, item.getStatus());
            if (getDataSource().size() < 5){
                width = ScreenUtils.getScreenWidth()/getDataSource().size();
            }else {
                width = ScreenUtils.getScreenWidth()/5;
            }
            RelativeLayout imageView = holder.getView(R.id.rl_time);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) imageView.getLayoutParams();
            layoutParams.width = width;
            if (item.isSelect()) {
                holder.setBackgroundResource(R.id.rl_time, R.drawable.ic_time_bg);
                layoutParams.height = SizeUtils.dp2px((float) 65.2);
            } else {
                holder.setBackgroundResource(R.id.rl_time, R.drawable.bg_000);
                layoutParams.height = SizeUtils.dp2px(60);
            }
            imageView.setLayoutParams(layoutParams);
        }

        @Override
        protected int getItemViewLayoutId(int position, FlashSaleBean.TimeBean item) {
            return R.layout.item_list_time;
        }

        private void setSelect(int position){
            if (getDataSource().size() > 0) {
                for (FlashSaleBean.TimeBean timeBean : getDataSource()) {
                    timeBean.setSelect(false);
                }
                getDataSource().get(position).setSelect(true);
                notifyDataSetChanged();
            }
        }
    }

    class GoodsAdapter extends BaseAdapter<KillGoodsBean.GoodsBean> {

        private GoodsAdapter(Context context) {
            super(context);
        }

        @Override
        protected void bindDataToItemView(BaseViewHolder holder, KillGoodsBean.GoodsBean item, int position) {
            holder.setText(R.id.tv_goods_name,item.getGoods_Name())
                    .setText(R.id.tv_purchased_num, "仅剩"+item.getGoodsPrice_Stock()+"件")
                    .setText(R.id.tv_price,String.valueOf(item.getGoodsPrice_Price()))
                    .setText(R.id.tv_old_price,String.valueOf(item.getGoodsPrice_VirtualPrice()))
                    .setText(R.id.tv_surplus, "已抢"+item.getRushNumber()+"件")
                    .setGlieuImage(R.id.iv_img,item.getGoods_ImaPath());
            if (item.getIsEnd() == 0){
                holder.setText(R.id.tv_confirm, "立即预约");
                holder.setBackgroundResource(R.id.tv_confirm, R.drawable.bg_red_v2);
            }else if(item.getIsEnd() == 1){
                holder.setText(R.id.tv_confirm, "立即抢购");
                holder.setBackgroundResource(R.id.tv_confirm, R.drawable.bg_red_v2);
            }else if (item.getIsEnd() == 2){
                holder.setText(R.id.tv_confirm, "已结束");
                holder.setBackgroundResource(R.id.tv_confirm, R.drawable.bg_red_v3);
            }

            holder.setOnClickListener(R.id.tv_confirm, v -> FlashSaleDetailsActivity.start(getContext(),item.getRushId(),0));
        }

        @Override
        protected int getItemViewLayoutId(int position, KillGoodsBean.GoodsBean item) {
            return R.layout.item_list_goods;
        }
    }
}
