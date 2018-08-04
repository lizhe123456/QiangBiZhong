package com.whmnrc.qiangbizhong.ui.me.fragment.order;


import com.whmnrc.qiangbizhong.model.bean.OrderListBean;

/**
 * Created by lizhe on 2018/4/9.
 */

public interface OnOrderListener {

    //去使用
    void toUse(OrderListBean item);

    //确认收货
    void collectGoods(OrderListBean item);

    //去评价
    void evaluate(OrderListBean item);

    //申请售后
    void applyCustomerServiceClick(OrderListBean item);

    void refund(OrderListBean item);

    void qxRefund(OrderListBean item);

    //付款
    void payClick(OrderListBean item);

    //联系客服
    void customerServicePhoneClick(OrderListBean item);

    //查看物流
    void lookProgress(OrderListBean item);

    void toQiangGou(OrderListBean item);

    void cancel(OrderListBean item);
}
