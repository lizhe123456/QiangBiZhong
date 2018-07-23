package com.whmnrc.qiangbizhong.ui.me.fragment.order.shop;

import android.os.Bundle;

import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseFragment;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/23.
 * 全部订单
 */

public class ShopOrder4Fragment extends BaseFragment{

    public static ShopOrder4Fragment newInstance() {
        Bundle args = new Bundle();
        ShopOrder4Fragment fragment = new ShopOrder4Fragment();
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
