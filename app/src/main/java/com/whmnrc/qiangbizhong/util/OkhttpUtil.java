package com.whmnrc.qiangbizhong.util;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.asm.Type;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.NetworkUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.google.gson.Gson;
import com.whmnrc.qiangbizhong.BuildConfig;
import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.app.App;
import com.whmnrc.qiangbizhong.base.BaseResponse;
import com.whmnrc.qiangbizhong.model.bean.LodingBean;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import org.greenrobot.eventbus.EventBus;

import java.lang.reflect.Method;
import java.util.Map;

import okhttp3.Call;
import okhttp3.MediaType;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/10.
 */

public class OkhttpUtil {

    public static void post(String url, Map<String, String> params, final ObjectCallback callback) {


        if (getIsConnected()) return;
        if (BuildConfig.DEBUG)
            Log.e("请求参数=", url + JSON.toJSONString(params));

        OkHttpUtils.post().url(url).params(params).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                callback.onFailure(id, e == null ? "" : e.toString());
                ToastUtils.showShort(App.getContext().getResources().getString(R.string.app_name).concat("：网络异常，请检查网络设置"));
            }

            @Override
            public void onResponse(String response, int id) {
                callback.onSuccess(response);
            }
        });


    }

    /**
     * 是否有网络
     *
     * @return
     */
    public static boolean getIsConnected() {
        if (!NetworkUtils.isConnected()) {
            ToastUtils.showShort(App.getContext().getResources().getString(R.string.app_name).concat("：网络异常，请检查网络设置"));
            return true;
        }
        return false;
    }

    public static void post(String url, Map<String, String> params, Map<String, String> headers, final ObjectCallback callback) {
        if (getIsConnected()) return;
        if (BuildConfig.DEBUG)
            Log.e("请求参数=", url + JSON.toJSONString(params));

        OkHttpUtils.post().url(url).headers(headers).params(params).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                callback.onFailure(id, e == null ? "" : e.toString());
                ToastUtils.showShort(App.getContext().getResources().getString(R.string.app_name).concat("：网络异常，请检查网络设置"));
            }

            @Override
            public void onResponse(String response, int id) {
                callback.onSuccess(response);

            }
        });


    }

    public static  void post(String url, Map<String, String> params, final BeanCallback callback) {
        try {
            if (getIsConnected()) return;
            if (BuildConfig.DEBUG)
                Log.e("请求参数=", url + JSON.toJSONString(params));

            OkHttpUtils.post().url(url).params(params).build().execute(new StringCallback() {
                @Override
                public void onError(Call call, Exception e, int id) {
                    callback.onFailure(id, e == null ? "" : e.toString());
                    ToastUtils.showShort(App.getContext().getResources().getString(R.string.app_name).concat("：网络异常，请检查网络设置"));
                    EventBus.getDefault().post(new LodingBean());
                }

                @Override
                public void onResponse(String response, int id) {
                    if (BuildConfig.DEBUG)
                        Log.e("返回结果=", response);
                    if (callback != null) {
                        if (!TextUtils.isEmpty(response)) {
                            BaseResponse baseResponse = JSON.parseObject(response, BaseResponse.class);
                            if (baseResponse.getStatus() == 1) {
                                UserManage.getInstance().setServerTime(baseResponse.getServerTime());
                                callback.onSuccess(baseResponse.getResult());
                            } else {
                                ToastUtils.showShort(baseResponse.getMessage());
                            }
                        }
                    }
                    EventBus.getDefault().post(new LodingBean());
                }
            });
        }catch (Exception e){
            e.printStackTrace();
            EventBus.getDefault().post(new LodingBean());
        }
    }

    //拼接完整url
    private static String getUrl(String url) {
        String baseUrl = App.getContext().getString(R.string.server_address);
        String result = baseUrl.concat(url);
        return result;
    }


    public static void get(String url, Map<String, String> paramters,
                           final ObjectCallback callback) {

        if (getIsConnected()) return;

        try {
            if (BuildConfig.DEBUG)
                Log.e("请求参数=", url + JSON.toJSONString(paramters));

            OkHttpUtils
                    .get()
                    .url(url)
                    .params(paramters)
                    .build()
                    .execute(new StringCallback() {
                        @Override
                        public void onError(Call call, Exception e, int id) {
                            callback.onFailure(id, e == null ? "" : e.toString());
                            ToastUtils.showShort(App.getContext().getResources().getString(R.string.app_name).concat("：网络异常，请检查网络设置"));
                            EventBus.getDefault().post(new LodingBean());
                        }

                        @Override
                        public void onResponse(String responseString, int id) {
                            if (BuildConfig.DEBUG)
                                Log.e("返回结果=", responseString);

                            if (callback != null) {
                                callback.onSuccess(responseString);
                            }
                            EventBus.getDefault().post(new LodingBean());
                        }
                    });
        } catch (Exception e) {
            e.printStackTrace();
            EventBus.getDefault().post(new LodingBean());
        }


    }

    public static void get(String url, Map<String, String> paramters,
                               final BeanCallback callback) {

        if (getIsConnected()) return;

        try {
            if (BuildConfig.DEBUG)
                Log.e("请求参数=", url + JSON.toJSONString(paramters));

            OkHttpUtils
                    .get()
                    .url(url)
                    .params(paramters)
                    .build()
                    .execute(new StringCallback() {
                        @Override
                        public void onError(Call call, Exception e, int id) {
                            callback.onFailure(id, e == null ? "" : e.toString());
                            ToastUtils.showShort(App.getContext().getResources().getString(R.string.app_name).concat("：网络异常，请检查网络设置"));
                            EventBus.getDefault().post(new LodingBean());
                        }

                        @Override
                        public void onResponse(String responseString, int id) {
                            if (BuildConfig.DEBUG)
                                Log.e("返回结果=", responseString);

                            if (callback != null) {
                                if (!TextUtils.isEmpty(responseString)) {
                                    BaseResponse baseResponse =  JSON.parseObject(responseString,BaseResponse.class);
                                    if (baseResponse.getStatus() == 1) {
                                        UserManage.getInstance().setServerTime(baseResponse.getServerTime());
                                        callback.onSuccess(baseResponse.getResult());
                                    }else if (baseResponse.getStatus() == 101){
                                        ToastUtils.showShort(baseResponse.getMessage());
                                        //充值
                                        callback.onFailure(101,"101");
                                    } else {
                                        if (baseResponse.getMessage() != null) {
                                            ToastUtils.showShort(baseResponse.getMessage());
                                        }else {

                                        }
                                    }
                                }
                            }
                            EventBus.getDefault().post(new LodingBean());
                        }
                    });
        } catch (Exception e) {
            e.printStackTrace();
            EventBus.getDefault().post(new LodingBean());
        }
    }


    //获得手机验证码
    public static void getCode(final String url, Map<String, String> paramters,
                               final ObjectCallback callback) {
        if (getIsConnected()) return;

        try {
            OkHttpUtils
                    .get()
                    .url(url)
                    .params(paramters)
                    .build()
                    .execute(new StringCallback() {
                        @Override
                        public void onError(Call call, Exception e, int id) {
                            callback.onFailure(id, e == null ? "" : e.toString());
                            ToastUtils.showShort(App.getContext().getResources().getString(R.string.app_name).concat("：网络异常，请检查网络设置"));
                        }

                        @Override
                        public void onResponse(String responseString, int id) {
                            if (BuildConfig.DEBUG)
                                LogUtils.e(url, responseString);

                            if (callback != null) {
                                callback.onSuccess(responseString);
                            }

                        }
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //上传文件
    public static void uploadFile(Map<String, String> params, final StringCallback callback) {

        if (getIsConnected()) return;

        String url = App.getContext().getString(R.string.server_address).concat("/api/Home/UploadFile");

        OkhttpUtil.postString(url, GsonUtil.createGsonString(params), new ObjectCallback() {
            @Override
            public void onSuccess(String st) {
                callback.onResponse(st, 0);
            }

            @Override
            public void onFailure(int code, String errorMsg) {
                ToastUtils.showShort(App.getContext().getResources().getString(R.string.app_name).concat("：网络异常，请检查网络设置"));
            }
        });
    }


    public static void postString(String url, String gsonString, final ObjectCallback objectCallback) {

        if (getIsConnected()) return;
        if (BuildConfig.DEBUG)
            Log.e("OkhttpUtil", url + gsonString);
        OkHttpUtils.postString().content(gsonString)
                .url(url)
                .mediaType(MediaType.parse("application/json; charset=utf-8"))
                .build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                objectCallback.onFailure(id, e == null ? "" : e.getLocalizedMessage());
                ToastUtils.showShort(App.getContext().getResources().getString(R.string.app_name).concat("：网络异常，请检查网络设置"));
            }

            @Override
            public void onResponse(String response, int id) {
                if (BuildConfig.DEBUG)
                    Log.e("返回结果=", response);
                objectCallback.onSuccess(response);

            }
        });
    }


    public interface ObjectCallback {
        void onSuccess(String st);

        void onFailure(int code, String errorMsg);

    }

    public interface BeanCallback {
        void onSuccess(String data);

        void onFailure(int code, String errorMsg);

    }


}
