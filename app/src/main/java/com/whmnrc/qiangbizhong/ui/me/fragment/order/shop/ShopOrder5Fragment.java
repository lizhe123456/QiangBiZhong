package com.whmnrc.qiangbizhong.ui.me.fragment.order.shop;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseFragment;
import com.whmnrc.qiangbizhong.model.bean.OrderListBean;
import com.whmnrc.qiangbizhong.presenter.me.OrderPresenter;
import com.whmnrc.qiangbizhong.ui.me.activity.ConfirmSendGoodsActivity;
import com.whmnrc.qiangbizhong.ui.me.fragment.order.BaseOrderFragment;
import com.whmnrc.qiangbizhong.ui.me.fragment.order.OnOrderListenerAdapter;
import com.whmnrc.qiangbizhong.widget.AlertDialog;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/23.
 * 全部订单
 */

public class ShopOrder5Fragment extends BaseOrderFragment implements OrderPresenter.OrderUpdateCall{

    public static ShopOrder5Fragment newInstance() {
        Bundle args = new Bundle();
        ShopOrder5Fragment fragment = new ShopOrder5Fragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void setClick() {
        mAdapter.setOnOrderListener(new OnOrderListenerAdapter(){


            @Override
            public void sendGoods(OrderListBean item) {
                ConfirmSendGoodsActivity.start(ShopOrder5Fragment.this,item.getOrder_ID());
            }

            @Override
            public void returnGoods(OrderListBean item) {
                new AlertDialog(getContext()).builder()
                        .setTitle("提示")
                        .setMsg("是否同意退款").setNegativeButton("取消", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                }).setPositiveButton("确认", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        showLoading("处理中..");
                        orderPresenter.returngoods(item.getOrder_ID(),ShopOrder5Fragment.this);
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
    public boolean isShop() {
        return true;
    }

    @Override
    public void updateData() {
        refresh.autoRefresh();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 101){
            if (resultCode == 105){
                refresh.autoRefresh();
            }
        }
    }
}
