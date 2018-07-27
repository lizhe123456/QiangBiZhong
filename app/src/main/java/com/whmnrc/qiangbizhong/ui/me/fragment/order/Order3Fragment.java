package com.whmnrc.qiangbizhong.ui.me.fragment.order;


import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.model.bean.OrderListBean;
import com.whmnrc.qiangbizhong.presenter.me.OrderPresenter;
import com.whmnrc.qiangbizhong.widget.CustomerServiceDialog;

import cn.pedant.SweetAlert.SweetAlertDialog;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/11.
 */

public class Order3Fragment extends BaseOrderFragment implements OrderPresenter.CollectCall {

    @Override
    public void setClick() {
        mAdapter.setOnOrderListener(new OnOrderListenerAdapter(){
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
                        orderPresenter.collectgoods(item.getOrder_ID(), Order3Fragment.this);
                    }
                }).show();

            }

            @Override
            public void customerServicePhoneClick(OrderListBean item) {
                CustomerServiceDialog customerServiceDialog = new CustomerServiceDialog(mContext, R.style.AlertDialogStyle);
                customerServiceDialog.show();
            }
        });
    }

    @Override
    public String request() {
        return "10";
    }

    @Override
    public void collect() {
        refresh.autoRefresh();
    }
}
