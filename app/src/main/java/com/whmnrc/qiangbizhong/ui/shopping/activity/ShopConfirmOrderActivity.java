package com.whmnrc.qiangbizhong.ui.shopping.activity;

import android.content.Context;
import android.content.Intent;

import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseActivity;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/23.
 * 商城确认订单
 */

public class ShopConfirmOrderActivity extends BaseActivity{

    public static void start(Context context) {
        Intent starter = new Intent(context, ShopConfirmOrderActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected int setLayout() {
        return R.layout.activity_shop_confirm_order;
    }

    @Override
    protected void setData() {

    }
}
