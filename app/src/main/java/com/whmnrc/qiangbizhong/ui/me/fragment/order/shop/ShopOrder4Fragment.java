package com.whmnrc.qiangbizhong.ui.me.fragment.order.shop;

import android.os.Bundle;
import android.view.View;

import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseFragment;
import com.whmnrc.qiangbizhong.model.bean.OrderListBean;
import com.whmnrc.qiangbizhong.presenter.me.OrderPresenter;
import com.whmnrc.qiangbizhong.ui.me.fragment.order.BaseOrderFragment;
import com.whmnrc.qiangbizhong.ui.me.fragment.order.OnOrderListenerAdapter;
import com.whmnrc.qiangbizhong.widget.AlertDialog;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/23.
 * 全部订单
 */

public class ShopOrder4Fragment extends BaseOrderFragment implements OrderPresenter.OrderUpdateCall{

    public static ShopOrder4Fragment newInstance() {
        Bundle args = new Bundle();
        ShopOrder4Fragment fragment = new ShopOrder4Fragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void setClick() {
        mAdapter.setOnOrderListener(new OnOrderListenerAdapter(){


            @Override
            public void returnGoods(OrderListBean item) {
                new AlertDialog(getContext()).builder()
                        .setMsg("是否同意退款")
                        .setTitle("提示")
                        .setNegativeButton("取消", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                }).setPositiveButton("确认", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        showLoading("处理中..");
                        orderPresenter.returngoods(item.getOrder_ID(),ShopOrder4Fragment.this);
                    }
                }).show();
            }


        });
    }

    @Override
    public String request() {
        return "-5";
    }

    @Override
    public boolean isShop() {
        return true;
    }

    @Override
    public void updateData() {
        refresh.autoRefresh();
    }
}
