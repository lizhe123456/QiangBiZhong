package com.whmnrc.qiangbizhong.ui.me.fragment.order;


/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/11.
 */

public class Order3Fragment extends BaseOrderFragment {

    @Override
    public void setClick() {
        mAdapter.setOnOrderListener(new OnOrderListenerAdapter());
    }

    @Override
    public String request() {
        return "2";
    }
}