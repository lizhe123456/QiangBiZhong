package com.whmnrc.qiangbizhong.app;


import android.content.Context;
import android.os.Looper;
import android.util.Log;
import com.blankj.utilcode.util.AppUtils;
import com.blankj.utilcode.util.ToastUtils;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;


/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/5/25.
 */

public class CrashHandler implements Thread.UncaughtExceptionHandler {

    private static CrashHandler crashHandler;
    //程序的Context对象
    private Context mContext;
    //用来存储设备信息和异常信息
    private Map<String, String> infos = new HashMap<String, String>();

    //用于格式化日期,作为日志文件名的一部分
    private DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");

    /** 获取CrashHandler实例 */
    public static CrashHandler getInstance() {
        if (crashHandler == null)
            crashHandler = new CrashHandler();
        return crashHandler;
    }
    public void init(Context context) {
        Log.i("BaseActivity","init()");
        this.mContext = context;
        Thread.setDefaultUncaughtExceptionHandler(this);
    }
    /**
     * 当UncaughtException发生时会回调该函数来处理
     */
    @Override
    public void uncaughtException(Thread thread, Throwable ex) {
        if (!handleException(ex) && crashHandler != null) {
            //如果用户没有处理则让系统默认的异常处理器来处理
            crashHandler.uncaughtException(thread, ex);
        } else {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
//                Log.e(TAG, "error : ", e);
            }
            //退出程序
            ToastUtils.cancel();
            AppUtils.exitApp();
            //异常信息收集
        }
    }

    private boolean handleException(Throwable ex) {
        if (ex == null) {
            return false;
        }
        //使用Toast来显示异常信息
        new Thread() {
            @Override
            public void run() {
                Looper.prepare();
                ToastUtils.showShort("很抱歉,程序出现异常,即将退出.");
                Looper.loop();
            }
        }.start();
        //收集设备参数信息
        return true;
    }

}
