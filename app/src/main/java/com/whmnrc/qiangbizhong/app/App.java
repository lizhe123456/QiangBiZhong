package com.whmnrc.qiangbizhong.app;

import android.app.Application;
import android.content.Context;

import com.blankj.utilcode.util.Utils;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheEntity;
import com.lzy.okgo.cache.CacheMode;

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
        OkGo.getInstance().init(this)
                .setCacheMode(CacheMode.NO_CACHE)
                .setRetryCount(3)
                .setCacheTime(30*24*60*1000);



    }

    public static Context getContext() {
        return context;
    }
}
