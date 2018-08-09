package com.whmnrc.qiangbizhong.ui.me.fragment.order.shop;

import android.os.Bundle;
import android.view.View;

import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseFragment;
import com.whmnrc.qiangbizhong.model.bean.OrderListBean;
import com.whmnrc.qiangbizhong.ui.me.fragment.order.BaseOrderFragment;
import com.whmnrc.qiangbizhong.ui.me.fragment.order.OnOrderListenerAdapter;
import com.whmnrc.qiangbizhong.widget.AlertDialog;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/23.
 * 交易成功
 */

public class ShopOrder2Fragment extends BaseOrderFragment {


    public static ShopOrder2Fragment newInstance() {
        Bundle args = new Bundle();
        ShopOrder2Fragment fragment = new ShopOrder2Fragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void setClick() {
        mAdapter.setOnOrderListener(new OnOrderListenerAdapter(){

            @Override
            public void collectGoods(OrderListBean item) {
                new AlertDialog(getContext()).builder().setMsg("确认要收货吗？")
                        .setNegativeButton("取消", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                            }
                        })
                        .setPositiveButton("确认", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                });
            }

        });
    }

    @Override
    public String request() {
        return "2";
    }

    @Override
    public boolean isShop() {
        return true;
    }
}
