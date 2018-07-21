package com.whmnrc.qiangbizhong.model.bean;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/21.
 */

public class CouponBean {

    String time;

    String name;

    String limit;

    public CouponBean(String time, String name, String limit) {
        this.time = time;
        this.name = name;
        this.limit = limit;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLimit() {
        return limit;
    }

    public void setLimit(String limit) {
        this.limit = limit;
    }
}
