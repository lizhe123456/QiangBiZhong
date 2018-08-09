package com.whmnrc.qiangbizhong.ui.me.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseActivity;
import com.whmnrc.qiangbizhong.ui.me.fragment.order.shop.ShopOrder1Fragment;
import com.whmnrc.qiangbizhong.ui.me.fragment.order.shop.ShopOrder2Fragment;
import com.whmnrc.qiangbizhong.ui.me.fragment.order.shop.ShopOrder3Fragment;
import com.whmnrc.qiangbizhong.ui.me.fragment.order.shop.ShopOrder4Fragment;
import com.whmnrc.qiangbizhong.ui.me.fragment.order.shop.ShopOrder5Fragment;
import com.whmnrc.qiangbizhong.util.ViewPagerUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/23.
 * 商家管理
 */

public class ShopManageActivity extends BaseActivity {
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.vp_content)
    ViewPager vpContent;

    private int page;

    public static void start(Context context, int page) {
        Intent starter = new Intent(context, ShopManageActivity.class);
        starter.putExtra("page",page);
        context.startActivity(starter);
    }

    @Override
    protected int setLayout() {
        return R.layout.activity_shop_manage;
    }

    @Override
    protected void setData() {
        tvTitle.setText("商家管理");
        ivBack.setVisibility(View.VISIBLE);
        SparseArray<Fragment> fragments = new SparseArray<>();
        SparseArray<String> titles = new SparseArray<>();
        titles.append(0,"已支付");
        titles.append(1,"待收货");
        titles.append(2,"已完成");
        titles.append(3,"待退款");
        titles.append(4,"全部订单");
        fragments.append(0, ShopOrder1Fragment.newInstance());
        fragments.append(1, ShopOrder2Fragment.newInstance());
        fragments.append(2, ShopOrder3Fragment.newInstance());
        fragments.append(3, ShopOrder4Fragment.newInstance());
        fragments.append(4, ShopOrder5Fragment.newInstance());
        page = getIntent().getIntExtra("page",0);
        ViewPagerUtil.initViewPage(vpContent,tabLayout,this,fragments,titles,0,page);
    }


    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        this.finish();
    }
}
