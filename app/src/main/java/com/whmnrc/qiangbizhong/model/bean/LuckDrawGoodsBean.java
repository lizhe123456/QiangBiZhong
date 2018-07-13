package com.whmnrc.qiangbizhong.model.bean;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/11.
 */

public class LuckDrawGoodsBean {

    String url;
    String name;
    String zhongName;

    String num;
    String time;
    String juliTime;

    public LuckDrawGoodsBean(String url, String name, String zhongName, String num, String time, String juliTime) {
        this.url = url;
        this.name = name;
        this.zhongName = zhongName;
        this.num = num;
        this.time = time;
        this.juliTime = juliTime;
    }

    public LuckDrawGoodsBean(String url, String zhongName, String time) {
        this.url = url;
        this.zhongName = zhongName;
        this.time = time;
    }

    public LuckDrawGoodsBean(String url, String name, String num, String juliTime) {
        this.url = url;
        this.name = name;
        this.num = num;
        this.juliTime = juliTime;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getZhongName() {
        return zhongName;
    }

    public void setZhongName(String zhongName) {
        this.zhongName = zhongName;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getJuliTime() {
        return juliTime;
    }

    public void setJuliTime(String juliTime) {
        this.juliTime = juliTime;
    }
}
