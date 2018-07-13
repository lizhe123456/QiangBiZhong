package com.whmnrc.qiangbizhong.model.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/11.
 */

public class LuckDrawBean {

    private List<LuckDrawGoodsBean> luckDrawGoodsBeans;
    private List<OpenLuckDrawBean> openLuckDrawBeans;

    public List<LuckDrawGoodsBean> getLuckDrawGoodsBeans() {
        return luckDrawGoodsBeans;
    }

    public List<OpenLuckDrawBean> getOpenLuckDrawBeans() {
        return openLuckDrawBeans;
    }

    public void initData(){
        this.luckDrawGoodsBeans = new ArrayList<>();
        this.openLuckDrawBeans = new ArrayList<>();

        luckDrawGoodsBeans.add(new LuckDrawGoodsBean("","总需人数：100","已报名人数：89","6月13日 16:00","标致4008 豪华GT版","距开奖仅剩 05:48:28"));
        luckDrawGoodsBeans.add(new LuckDrawGoodsBean("","总需人数：100","已报名人数：89","6月13日 16:00","LV老花子母包","距开奖仅剩 05:48:28"));
        luckDrawGoodsBeans.add(new LuckDrawGoodsBean("","总需人数：100","已报名人数：89","6月13日 16:00","iPhone X 256G 灰色","距开奖仅剩 05:48:28"));
        luckDrawGoodsBeans.add(new LuckDrawGoodsBean("","总需人数：100","已报名人数：89","6月13日 16:00","Apple/苹果 iPad pro","距开奖仅剩 05:48:28"));

        openLuckDrawBeans.add(new OpenLuckDrawBean("","","07月11日榜单","qq***p"));
        openLuckDrawBeans.add(new OpenLuckDrawBean("","","07月12日榜单","会***哈"));
        openLuckDrawBeans.add(new OpenLuckDrawBean("","","07月12日榜单","ki***gtgg"));
        openLuckDrawBeans.add(new OpenLuckDrawBean("","","07月13日榜单","你是***空i"));
        openLuckDrawBeans.add(new OpenLuckDrawBean("","","07月14日榜单","mjk***oi"));
        openLuckDrawBeans.add(new OpenLuckDrawBean("","","07月15日榜单","176***57655"));


    }

    public class OpenLuckDrawBean{
        String url;
        String headUrl;
        String time;
        String name;

        public OpenLuckDrawBean(String url, String headUrl, String time, String name) {
            this.url = url;
            this.headUrl = headUrl;
            this.time = time;
            this.name = name;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getHeadUrl() {
            return headUrl;
        }

        public void setHeadUrl(String headUrl) {
            this.headUrl = headUrl;
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
    }


    public class LuckDrawGoodsBean{
        String url;
        String num;
        String canyu;
        String time;
        String name;
        String juliTime;


        public LuckDrawGoodsBean(String url, String num, String canyu, String time,String name,String juliTime) {
            this.url = url;
            this.num = num;
            this.canyu = canyu;
            this.time = time;
            this.name = name;
            this.juliTime = juliTime;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getJuliTime() {
            return juliTime;
        }

        public void setJuliTime(String juliTime) {
            this.juliTime = juliTime;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getNum() {
            return num;
        }

        public void setNum(String num) {
            this.num = num;
        }

        public String getCanyu() {
            return canyu;
        }

        public void setCanyu(String canyu) {
            this.canyu = canyu;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }
    }

}
