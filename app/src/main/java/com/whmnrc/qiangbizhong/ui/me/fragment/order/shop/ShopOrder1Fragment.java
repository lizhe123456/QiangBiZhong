package com.whmnrc.qiangbizhong.ui.me.fragment.order.shop;

import android.os.Bundle;

import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseFragment;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/23.
 * 交易中
 */

public class ShopOrder1Fragment extends BaseFragment{


    public static ShopOrder1Fragment newInstance() {
        Bundle args = new Bundle();
        ShopOrder1Fragment fragment = new ShopOrder1Fragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_shop_order;
    }

    @Override
    protected void initData() {

    }
}
