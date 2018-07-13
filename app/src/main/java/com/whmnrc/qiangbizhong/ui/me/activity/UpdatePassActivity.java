package com.whmnrc.qiangbizhong.ui.me.activity;

import android.content.Context;
import android.content.Intent;

import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseActivity;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/12.
 */

public class UpdatePassActivity extends BaseActivity {


    public static void start(Context context) {
        Intent starter = new Intent(context, UpdatePassActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected int setLayout() {
        return R.layout.activity_update_pass;
    }

    @Override
    protected void setData() {

    }
}
