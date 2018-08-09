package com.whmnrc.qiangbizhong.ui.me.fragment.order.shop;

import android.content.Intent;
import android.os.Bundle;

import com.whmnrc.qiangbizhong.model.bean.OrderListBean;
import com.whmnrc.qiangbizhong.ui.me.activity.ConfirmSendGoodsActivity;
import com.whmnrc.qiangbizhong.ui.me.fragment.order.BaseOrderFragment;
import com.whmnrc.qiangbizhong.ui.me.fragment.order.OnOrderListenerAdapter;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/23.
 * 交易中
 */

public class ShopOrder1Fragment extends BaseOrderFragment{

    public static ShopOrder1Fragment newInstance() {
        Bundle args = new Bundle();
        ShopOrder1Fragment fragment = new ShopOrder1Fragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void setClick() {
        mAdapter.setOnOrderListener(new OnOrderListenerAdapter(){
            @Override
            public void sendGoods(OrderListBean item) {
                ConfirmSendGoodsActivity.start(ShopOrder1Fragment.this,item.getOrder_ID());
            }
        });
    }

    @Override
    public String request() {
        return "1";
    }

    @Override
    public boolean isShop() {
        return true;
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
