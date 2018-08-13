package com.whmnrc.qiangbizhong.ui.me.fragment.order;


import android.content.Intent;
import android.view.View;

import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.model.bean.OrderListBean;
import com.whmnrc.qiangbizhong.presenter.me.OrderPresenter;
import com.whmnrc.qiangbizhong.ui.shopping.activity.EvaluateActivity;
import com.whmnrc.qiangbizhong.widget.AlertDialog;
import com.whmnrc.qiangbizhong.widget.CustomerServiceDialog;

import cn.pedant.SweetAlert.SweetAlertDialog;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/11.
 */

public class Order5Fragment extends BaseOrderFragment implements OrderPresenter.CollectCall {


    @Override
    public void setClick() {
        mAdapter.setOnOrderListener(new OnOrderListenerAdapter(){
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
                    public void onClick(View sweetAlertDialog) {
                        showLoading("收货中..");
                        orderPresenter.collectgoods(item.getOrder_ID(), Order5Fragment.this);
                    }
                }).show();

            }

            @Override
            public void customerServicePhoneClick(OrderListBean item) {
                CustomerServiceDialog customerServiceDialog = new CustomerServiceDialog(mContext, R.style.AlertDialogStyle);
                customerServiceDialog.show();
            }

            @Override
            public void evaluate(OrderListBean item) {
                EvaluateActivity.start(Order5Fragment.this,item);
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 101){
            if (resultCode == 102){
                refresh.autoRefresh();
            }
        }

    }

    @Override
    public String request() {
        return "3";
    }

    @Override
    public boolean isShop() {
        return false;
    }

    @Override
    public void collect() {
        refresh.autoRefresh();
    }
}
