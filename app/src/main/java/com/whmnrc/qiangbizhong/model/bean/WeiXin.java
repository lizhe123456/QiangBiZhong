package com.whmnrc.qiangbizhong.model.bean;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/8/20.
 */

public class WeiXin {
    private int type;//1:登录 2.分享 3:微信支付
    private int errCode;//微信返回的错误码
    private String code;//登录成功才会有的code
    private String openId;

    public WeiXin() {
    }

    public WeiXin(int type,int errCode, String code, String openId) {
        this.type = type;
        this.errCode=errCode;
        this.code = code;
        this.openId = openId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getErrCode() {
        return errCode;
    }

    public void setErrCode(int errCode) {
        this.errCode = errCode;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }
}
