package com.whmnrc.qiangbizhong.util;

import android.text.TextUtils;
import android.util.Log;
import com.alibaba.fastjson.JSON;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.NetworkUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.whmnrc.qiangbizhong.BuildConfig;
import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.app.App;
import com.whmnrc.qiangbizhong.base.BaseResponse;
import com.whmnrc.qiangbizhong.model.bean.LodingBean;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.builder.PostFormBuilder;
import com.zhy.http.okhttp.callback.StringCallback;
import org.greenrobot.eventbus.EventBus;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import okhttp3.Call;
import okhttp3.MediaType;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/10.
 */

public class OkhttpUtil {


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


    public static void postString(String url, String gsonString, final BeanCallback objectCallback) {
        try {
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
                    EventBus.getDefault().post(new LodingBean());
                }

                @Override
                public void onResponse(String response, int id) {
                    if (response != null)
                        LogUtils.e("返回结果=", response);
                    if (objectCallback != null) {
                        if (!TextUtils.isEmpty(response)) {
                            BaseResponse baseResponse = JSON.parseObject(response, BaseResponse.class);
                            if (baseResponse.getStatus() == 1) {
                                UserManage.getInstance().setServerTime(baseResponse.getServerTime());
                                objectCallback.onSuccess(baseResponse.getResult());
                            } else if (baseResponse.getStatus() == 101) {
                                ToastUtils.showShort(baseResponse.getMessage());
                                //充值
                                objectCallback.onFailure(101, "101");
                            } else {
                                ToastUtils.showShort(baseResponse.getMessage());
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


    private static void upLoadToServer(final String url, final String img, final BeanCallback listener) {
        if (getIsConnected()) return;
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Disposition", "form-data;filename=enctype");
        PostFormBuilder builder = OkHttpUtils.post();
        builder.url(url);
        File file = new File(img);
        if (!file.exists()) {
            ToastUtils.showShort("文件不存在，请修改文件路径");
            return;
        }
        String filename = file.getName();
        builder.addFile("Image", filename, file);

        builder.headers(headers)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        listener.onFailure(id, e == null ? "" : e.getLocalizedMessage());
                        ToastUtils.showShort(App.getContext().getResources().getString(R.string.app_name).concat("：网络异常，请检查网络设置"));
                        EventBus.getDefault().post(new LodingBean());
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        if (listener != null) {
                            if (!TextUtils.isEmpty(response)) {
                                BaseResponse baseResponse = JSON.parseObject(response, BaseResponse.class);
                                if (baseResponse.getStatus() == 1) {
                                    UserManage.getInstance().setServerTime(baseResponse.getServerTime());
                                    listener.onSuccess(baseResponse.getResult());
                                } else {
                                    ToastUtils.showShort(baseResponse.getMessage());
                                }
                            }
                        }
                    }
                });

    }

    private static int num = 0;

    public static void uploadImages(String url, List<String> list, ImageCallback imageCallback) {
        List<String> list1 = new ArrayList<>();

        upLoadToServer(url, list.get(num), new BeanCallback() {
            @Override
            public void onSuccess(String data) {
                List<String> list2 = GsonUtil.changeGsonToList(data,String.class);
                list1.add(list2.get(0));
                num += 1;
                if (num < list.size()) {
                    upLoadToServer(url, list.get(num), this);
                } else {
                    num = 0;
                    imageCallback.onSuccess(list1);
                    EventBus.getDefault().post(new LodingBean());
                }

            }

            @Override
            public void onFailure(int code, String errorMsg) {
                EventBus.getDefault().post(new LodingBean());
                ToastUtils.showShort("上传失败");
            }
        });
    }


    public static void post(String url, Map<String, String> params, final BeanCallback callback) {
        try {
            if (getIsConnected()) return;
            if (BuildConfig.DEBUG)
                LogUtils.e("请求参数=", url + JSON.toJSONString(params));

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
                        if (response != null)
                            LogUtils.e("返回结果=", response);
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
        } catch (Exception e) {
//            e.printStackTrace();
            EventBus.getDefault().post(new LodingBean());
        }
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
                                if (responseString != null)
                                    LogUtils.e("返回结果=", responseString);

                            if (callback != null) {
                                callback.onSuccess(responseString);
                            }
                            EventBus.getDefault().post(new LodingBean());
                        }
                    });
        } catch (Exception e) {
//            e.printStackTrace();
            EventBus.getDefault().post(new LodingBean());
        }


    }

    public static void get(String url, Map<String, String> paramters,
                           final BeanCallback callback) {

        if (getIsConnected()) return;

        try {
            if (BuildConfig.DEBUG)
                LogUtils.e("请求参数=", url + GsonUtil.createGsonString(paramters));

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
                                if (responseString != null)
                                    LogUtils.e("返回结果=", responseString);

                            if (callback != null) {
                                if (!TextUtils.isEmpty(responseString)) {
                                    BaseResponse baseResponse = JSON.parseObject(responseString, BaseResponse.class);
                                    if (baseResponse.getStatus() == 1) {
                                        UserManage.getInstance().setServerTime(baseResponse.getServerTime());
                                        callback.onSuccess(baseResponse.getResult());
                                    } else if (baseResponse.getStatus() == 101) {
                                        ToastUtils.showShort(baseResponse.getMessage());
                                        //充值
                                        callback.onFailure(101, "101");
                                    } else {
                                        if (baseResponse.getMessage() != null) {
                                            ToastUtils.showShort(baseResponse.getMessage());
                                        } else {

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


    public interface ObjectCallback {
        void onSuccess(String st);

        void onFailure(int code, String errorMsg);

    }

    public interface BeanCallback {
        void onSuccess(String data);

        void onFailure(int code, String errorMsg);

    }

    public interface ImageCallback {
        void onSuccess(List<String> data);

        void onFailure(int code, String errorMsg);
    }


}
