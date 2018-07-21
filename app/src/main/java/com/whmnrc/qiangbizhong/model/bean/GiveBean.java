package com.whmnrc.qiangbizhong.model.bean;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/21.
 */

public class GiveBean {
    String  title;
    int zs;
    int yl;
    String time;

    public GiveBean(String title, int zs, int yl, String time) {
        this.title = title;
        this.zs = zs;
        this.yl = yl;
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getZs() {
        return zs;
    }

    public void setZs(int zs) {
        this.zs = zs;
    }

    public int getYl() {
        return yl;
    }

    public void setYl(int yl) {
        this.yl = yl;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
