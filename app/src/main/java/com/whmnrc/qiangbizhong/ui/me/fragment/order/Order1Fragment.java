package com.whmnrc.qiangbizhong.ui.me.fragment.order;


import com.whmnrc.qiangbizhong.model.bean.OrderListBean;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/11.
 */

public class Order1Fragment extends BaseOrderFragment {



    @Override
    public void setClick() {
        mAdapter.setOnOrderListener(new OnOrderListenerAdapter(){
            @Override
            public void customerServicePhoneClick(OrderListBean item) {

            }
        });
    }

    @Override
    public int request() {
        return 0;
    }
}
