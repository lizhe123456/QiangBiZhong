package com.whmnrc.qiangbizhong.app;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.blankj.utilcode.util.Utils;
import com.pgyersdk.crash.PgyCrashManager;
import com.pgyersdk.crash.PgyerCrashObservable;
import com.pgyersdk.crash.PgyerObserver;
import com.uuzuche.lib_zxing.activity.ZXingLibrary;


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
        PgyCrashManager.register();
        CrashHandler.getInstance().init(this);
        ZXingLibrary.initDisplayOpinion(this);
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    public static Context getContext() {
        return context;
    }
}
