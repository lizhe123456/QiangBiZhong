package com.whmnrc.qiangbizhong.ui.shop.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseActivity;
import com.whmnrc.qiangbizhong.widget.RoundedImageView;
import com.whmnrc.qiangbizhong.widget.WrapContentHeightViewPager;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/11.
 */

public class ShopDetailsActivity extends BaseActivity {

    @BindView(R.id.iv_goods_img)
    ImageView ivGoodsImg;
    @BindView(R.id.iv_shop_car)
    ImageView ivShopCar;
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_old_price)
    TextView tvOldPrice;
    @BindView(R.id.tv_price)
    TextView tvPrice;
    @BindView(R.id.ll_now_moeny1)
    LinearLayout llNowMoeny1;
    @BindView(R.id.tv_sales_volume)
    TextView tvSalesVolume;
    @BindView(R.id.tv_comment_count)
    TextView tvCommentCount;
    @BindView(R.id.tv_no_comment)
    TextView tvNoComment;
    @BindView(R.id.rv_comment_list)
    RecyclerView rvCommentList;
    @BindView(R.id.iv_img)
    RoundedImageView ivImg;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_address)
    TextView tvAddress;
    @BindView(R.id.tv_collection)
    TextView tvCollection;
    @BindView(R.id.tv_shop_desc)
    TextView tvShopDesc;
    @BindView(R.id.rl_sort)
    RelativeLayout rlSort;
    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.vp_content)
    WrapContentHeightViewPager vpContent;
    @BindView(R.id.tv_price_title)
    TextView tvPriceTitle;
    @BindView(R.id.tv_now_moeny)
    TextView tvNowMoeny;

    @Override
    protected int setLayout() {
        return R.layout.activity_shop_details;
    }

    @Override
    protected void setData() {

    }


    @OnClick({R.id.iv_shop_car, R.id.iv_back, R.id.iv_coll, R.id.iv_customer_service, R.id.tv_shop_car, R.id.tv_buy})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_shop_car:
                break;
            case R.id.iv_back:
                break;
            case R.id.iv_coll:
                break;
            case R.id.iv_customer_service:
                break;
            case R.id.tv_shop_car:
                break;
            case R.id.tv_buy:
                break;
        }
    }
}
