package com.whmnrc.qiangbizhong.app;

import android.app.Application;
import android.content.Context;

import com.blankj.utilcode.util.Utils;


/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/6.
 */

public class App extends Application {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        Utils.init(context);

    }

    public static Context getContext() {
        return context;
    }
}
