package com.whmnrc.qiangbizhong.ui.me.fragment.order;


import com.whmnrc.qiangbizhong.model.bean.OrderListBean;
import com.whmnrc.qiangbizhong.presenter.me.OrderPresenter;
import com.whmnrc.qiangbizhong.ui.shop.activity.FlashSaleDetailsActivity;

import cn.pedant.SweetAlert.SweetAlertDialog;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/11.
 */

public class Order4Fragment extends BaseOrderFragment implements OrderPresenter.CancelCall, OrderPresenter.CollectCall, OrderPresenter.PayBackS {


    @Override
    public void setClick() {
        mAdapter.setOnOrderListener(new OnOrderListenerAdapter() {
            @Override
            public void toQiangGou(OrderListBean item) {
                FlashSaleDetailsActivity.start(getContext(), item.getRushRecord().getRushId(), 0);
            }

            @Override
            public void cancel(OrderListBean item) {
                new SweetAlertDialog(mContext)
                        .setTitleText("提示")
                        .setContentText("确定要取消吗？")
                        .setCancelButton("取消", new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sweetAlertDialog) {
                                sweetAlertDialog.dismiss();
                            }
                        }).setConfirmButton("确认", new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sweetAlertDialog) {
                        sweetAlertDialog.dismiss();
                        showLoading("取消中..");
                        orderPresenter.abandon(item.getRushRecord().getRushId(), Order4Fragment.this);
                    }
                }).show();

            }

            @Override
            public void collectGoods(OrderListBean item) {
                new SweetAlertDialog(mContext)
                        .setTitleText("提示")
                        .setContentText("确定要收货吗？")
                        .setCancelButton("取消", new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sweetAlertDialog) {
                                sweetAlertDialog.dismiss();
                            }
                        }).setConfirmButton("确认", new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sweetAlertDialog) {
                        sweetAlertDialog.dismiss();
                        showLoading("收货中..");
                        orderPresenter.collectgoods(item.getOrder_ID(), Order4Fragment.this);
                    }
                }).show();

            }

            @Override
            public void payClick(OrderListBean item) {
                new SweetAlertDialog(mContext)
                        .setTitleText("提示")
                        .setContentText("确定要支付吗？")
                        .setCancelButton("取消", new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sweetAlertDialog) {
                                sweetAlertDialog.dismiss();
                            }
                        }).setConfirmButton("确认", new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sweetAlertDialog) {
                        sweetAlertDialog.dismiss();
                        showLoading("支付中..");
                        orderPresenter.payOrder(item.getAward().getGoodsAwardId(),Order4Fragment.this);
                    }
                }).show();
            }
        });
    }

    @Override
    public String request() {
        return "all";
    }

    @Override
    public void cancelS() {
        refresh.autoRefresh();
    }

    @Override
    public void collect() {
        refresh.autoRefresh();
    }

    @Override
    public void payS() {
        refresh.autoRefresh();
    }
}
