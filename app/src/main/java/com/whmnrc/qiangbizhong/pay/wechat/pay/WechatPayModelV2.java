package com.whmnrc.qiangbizhong.pay.wechat.pay;

/**
 * @author Vondear
 * @date 2017/4/17
 */

public class WechatPayModelV2 {


    /**
     * timeStamp : 1536320110
     * packageValue : Sign=WXPay
     * appId : wx047407a9f3cde3c9
     * sign : 1C3358AE8B757458D084F9F957DDBF7D
     * partnerId : 1514058211
     * prepayId : wx07193510472909da273350ef2588326252
     * nonceStr : 59cf42300ed9fd30a2687e847b650f20
     */

    private String timeStamp;
    private String packageValue;
    private String appId;
    private String sign;
    private String partnerId;
    private String prepayId;
    private String nonceStr;

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getPackageValue() {
        return packageValue;
    }

    public void setPackageValue(String packageValue) {
        this.packageValue = packageValue;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId;
    }

    public String getPrepayId() {
        return prepayId;
    }

    public void setPrepayId(String prepayId) {
        this.prepayId = prepayId;
    }

    public String getNonceStr() {
        return nonceStr;
    }

    public void setNonceStr(String nonceStr) {
        this.nonceStr = nonceStr;
    }
}
