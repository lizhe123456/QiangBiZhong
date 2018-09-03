package com.whmnrc.qiangbizhong.ui.me.fragment.order;


import android.text.InputType;
import android.view.View;

import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.model.bean.OrderListBean;
import com.whmnrc.qiangbizhong.presenter.me.OrderPresenter;
import com.whmnrc.qiangbizhong.ui.me.activity.AccountRechargeActivity;
import com.whmnrc.qiangbizhong.ui.shop.activity.ConfirmOrderActivity;
import com.whmnrc.qiangbizhong.ui.shop.activity.FlashSaleDetailsActivity;
import com.whmnrc.qiangbizhong.ui.shopping.activity.EvaluateActivity;
import com.whmnrc.qiangbizhong.widget.AlertDialog;
import com.whmnrc.qiangbizhong.widget.AlertEditTextDialog;
import com.whmnrc.qiangbizhong.widget.CustomerServiceDialog;
import com.whmnrc.qiangbizhong.widget.PayDialogUtil;


/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/11.
 */

public class Order4Fragment extends BaseOrderFragment implements OrderPresenter.CancelCall, OrderPresenter.CollectCall, OrderPresenter.PayBackS, OrderPresenter.PayPassCall, OrderPresenter.OrderUpdateCall {

    private OrderListBean orderListBean;

    @Override
    public void setClick() {
        mAdapter.setOnOrderListener(new OnOrderListenerAdapter() {

            @Override
            public void customerServicePhoneClick(OrderListBean item) {
                CustomerServiceDialog customerServiceDialog = new CustomerServiceDialog(mContext, R.style.AlertDialogStyle);
                customerServiceDialog.show();
            }

            @Override
            public void toQiangGou(OrderListBean item) {
                FlashSaleDetailsActivity.start(getContext(), item.getRushRecord().getRushId());
            }

            @Override
            public void cancel(OrderListBean item) {
                new AlertDialog(mContext).builder()
                        .setTitle("提示")
                        .setMsg("确定要取消吗？")
                        .setNegativeButton("取消", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                            }
                        }).setNegativeButton("确认", new View.OnClickListener() {
                    @Override
                    public void onClick(View sweetAlertDialog) {
                        showLoading("取消中..");
                        orderPresenter.abandon(item.getRushRecord().getRushId(), Order4Fragment.this);
                    }
                }).show();

            }

            @Override
            public void collectGoods(OrderListBean item) {

                new AlertDialog(mContext).builder()
                        .setTitle("提示")
                        .setMsg("确定要收货吗？")
                        .setNegativeButton("取消", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                            }
                        }).setNegativeButton("确认", new View.OnClickListener() {
                    @Override
                    public void onClick(View dialog) {
                        showLoading("收货中..");
                        orderPresenter.collectgoods(item.getOrder_ID(), Order4Fragment.this);
                    }
                }).show();

            }

            @Override
            public void payClick(OrderListBean item) {
                orderListBean = item;
                new AlertDialog(mContext).builder()
                        .setTitle("提示")
                        .setMsg("确定要支付吗？")
                        .setNegativeButton("取消", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                            }
                        }).setNegativeButton("确认", new View.OnClickListener() {
                    @Override
                    public void onClick(View dialog) {
                        PayDialogUtil.payDialogShow(mContext, new AlertEditTextDialog.ConfirmListenter() {

                            @Override
                            public void comfrim(String content) {
                                showLoading("支付中..");
                                orderPresenter.yzPass(content, Order4Fragment.this);
                            }
                        });
                    }
                }).show();
            }

            @Override
            public void qxRefund(OrderListBean item) {
                new AlertDialog(getContext()).builder()
                        .setTitle("提示")
                        .setMsg("确认要取消吗？")
                        .setPositiveButton("确认", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                orderPresenter.cannerrefund(item.getOrder_ID(), Order4Fragment.this);
                            }
                        }).show();

            }

            @Override
            public void refund(OrderListBean item) {
                new AlertEditTextDialog(mContext).builder().setTitle("是否确认申请退款")
                        .setTvFundZfPwd(false)
                        .setInputNume(20)
                        .setEidtMsg("请输入退款原因")
                        .setInputType(InputType.TYPE_CLASS_TEXT)
                        .setNegativeButton("取消", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                            }
                        })
                        .setPositive1Button("确认", new AlertEditTextDialog.ConfirmListenter() {
                            @Override
                            public void comfrim(String content) {
                                orderPresenter.submitrefund(item.getOrder_ID(), content, Order4Fragment.this);
                            }
                        }).show();

            }

            @Override
            public void evaluate(OrderListBean item) {
                EvaluateActivity.start(Order4Fragment.this, item);
            }
        });
    }

    @Override
    public String request() {
        return "all";
    }

    @Override
    public boolean isShop() {
        return false;
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

    @Override
    public void recharge() {
        new AlertDialog(mContext).builder()
                .setTitle("提示")
                .setMsg("余额不足,请充值！")
                .setNegativeButton("取消", new View.OnClickListener() {
                    @Override
                    public void onClick(View dialog) {
                    }
                }).setPositiveButton("确认", new View.OnClickListener() {
            @Override
            public void onClick(View dialog) {
                AccountRechargeActivity.start(mContext, 1);
            }
        }).show();
    }

    @Override
    public void payPassBack() {
        if (orderListBean != null) {
            orderPresenter.payOrder(orderListBean.getAward().getGoodsAwardId(), Order4Fragment.this);
        }
    }

    @Override
    public void updateData() {
        refresh.autoRefresh();
    }
}
