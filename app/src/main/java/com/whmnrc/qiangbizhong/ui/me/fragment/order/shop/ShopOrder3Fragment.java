package com.whmnrc.qiangbizhong.ui.me.fragment.order.shop;

import android.os.Bundle;

import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseFragment;
import com.whmnrc.qiangbizhong.model.bean.OrderListBean;
import com.whmnrc.qiangbizhong.ui.me.fragment.order.BaseOrderFragment;
import com.whmnrc.qiangbizhong.ui.me.fragment.order.OnOrderListenerAdapter;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/23.
 * 交易取消
 */

public class ShopOrder3Fragment extends BaseOrderFragment {


    public static ShopOrder3Fragment newInstance() {
        Bundle args = new Bundle();
        ShopOrder3Fragment fragment = new ShopOrder3Fragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void setClick() {
    }

    @Override
    public String request() {
        return "10";
    }

    @Override
    public boolean isShop() {
        return true;
    }
}
