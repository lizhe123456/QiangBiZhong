package com.whmnrc.qiangbizhong.ui.me.goods.update;

import android.content.Context;
import android.content.Intent;

import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseActivity;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/8/7.
 * 编辑商品属性
 */

public class EditGoodsAttrActivity extends BaseActivity {

    public static void start(Context context) {
        Intent starter = new Intent(context, EditGoodsAttrActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected int setLayout() {
        return R.layout.activity_edit_goods_attr;
    }

    @Override
    protected void setData() {

    }
}
