package com.whmnrc.qiangbizhong.pay.wechat.pay;

import android.content.Context;
import com.alibaba.fastjson.JSON;
import com.tencent.mm.opensdk.constants.Build;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.whmnrc.qiangbizhong.app.App;
import com.whmnrc.qiangbizhong.wxapi.WXPayBean;


/**
 * @author Vondear
 * @date 16/6/1
 */
public class WechatPay {

    public static final int NO_OR_LOW_WX = 1;   //未安装微信或微信版本过低
    public static final int ERROR_PAY_PARAM = 2;  //支付参数错误
    public static final int ERROR_PAY = 3;  //支付失败
    private static WechatPay sMWechatPay;
    private IWXAPI mWXApi;
    private String mPayParam;
    private WXPayResultCallBack mCallback;

    public WechatPay(Context context, String wx_appid) {
//        mWXApi = WXAPIFactory.createWXAPI(context, wx_appid);
//        mWXApi.registerApp(wx_appid);
    }

    public static void init(Context context, String wx_appid) {
        if (sMWechatPay == null) {
            sMWechatPay = new WechatPay(context, wx_appid);
        }
    }

    public static WechatPay getInstance() {
        return sMWechatPay;
    }

    public IWXAPI getWXApi() {
        return mWXApi;
    }

    /**
     * 发起微信支付
     */
    public void doPay(String pay_param, WXPayResultCallBack callback) {
        mPayParam = pay_param;
        mCallback = callback;

        WechatPayModelV2 wechatPayModelV2 = JSON.parseObject(pay_param,WechatPayModelV2.class);

        mWXApi = WXAPIFactory.createWXAPI(App.getContext(),  wechatPayModelV2.getAppId());
        mWXApi.registerApp( wechatPayModelV2.getAppId());
//        if (!check()) {
//            if (mCallback != null) {
//                mCallback.onError(NO_OR_LOW_WX);
//            }
//            return;
//        }
        PayReq req = new PayReq();
        req.appId = wechatPayModelV2.getAppId();
        req.partnerId = wechatPayModelV2.getPartnerId();
        req.prepayId = wechatPayModelV2.getPrepayId();
        req.packageValue = wechatPayModelV2.getPackageValue();
        req.nonceStr = wechatPayModelV2.getNonceStr();
        req.timeStamp = wechatPayModelV2.getTimeStamp();
        req.sign = wechatPayModelV2.getSign();

        mWXApi.sendReq(req);
    }

    //支付回调响应
    public void onResp(WXPayBean error_code) {
        if (mCallback == null) {
            return;
        }

        if (error_code.getCode() == 0) {   //成功
            mCallback.onSuccess();
        } else if (error_code.getCode() == -1) {   //错误
            mCallback.onError(ERROR_PAY);
        } else if (error_code.getCode() == -2) {   //取消
            mCallback.onCancel();
        }

        mCallback = null;
    }

    //检测是否支持微信支付
    private boolean check() {
        return mWXApi.isWXAppInstalled() && mWXApi.getWXAppSupportAPI() >= Build.PAY_SUPPORTED_SDK_INT;
    }

    public interface WXPayResultCallBack {
        void onSuccess(); //支付成功

        void onError(int error_code);   //支付失败

        void onCancel();    //支付取消
    }
}
