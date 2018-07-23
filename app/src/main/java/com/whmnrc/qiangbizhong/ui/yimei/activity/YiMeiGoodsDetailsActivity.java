package com.whmnrc.qiangbizhong.ui.yimei.activity;

import android.content.Context;
import android.content.Intent;

import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseActivity;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/23.
 * 医美详情
 */

public class YiMeiGoodsDetailsActivity extends BaseActivity{



    public static void start(Context context) {
        Intent starter = new Intent(context, YiMeiGoodsDetailsActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected int setLayout() {
        return R.layout.activity_yimei_goods_details;
    }

    @Override
    protected void setData() {

    }
}
