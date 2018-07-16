package com.whmnrc.qiangbizhong.model.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/11.
 */

public class FlashSaleBean {

    String goodsName;
    String desc;
    int yigou;
    int sheng;
    String price;
    String oldPrice;
    List<TimeBean> timeBeans;
    List<GoodsBean> goodsBeans;

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getYigou() {
        return yigou;
    }

    public void setYigou(int yigou) {
        this.yigou = yigou;
    }

    public int getSheng() {
        return sheng;
    }

    public void setSheng(int sheng) {
        this.sheng = sheng;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(String oldPrice) {
        this.oldPrice = oldPrice;
    }

    public List<TimeBean> getTimeBeans() {
        return timeBeans;
    }

    public void setTimeBeans(List<TimeBean> timeBeans) {
        this.timeBeans = timeBeans;
    }

    public List<GoodsBean> getGoodsBeans() {
        return goodsBeans;
    }

    public void setGoodsBeans(List<GoodsBean> goodsBeans) {
        this.goodsBeans = goodsBeans;
    }

    public void initData(){
        this.goodsName = "C级奔驰 2018款 C200L";
        this.desc = "品味至臻，智者之选";
        this.yigou = 0;
        this.sheng = 1;
        this.price = "10w";
        this.oldPrice = "32w";
        timeBeans = new ArrayList<>();
        goodsBeans = new ArrayList<>();
        timeBeans.add(new TimeBean("13:00","开枪"));
        timeBeans.add(new TimeBean("14:00","开枪"));
        timeBeans.add(new TimeBean("15:00","开枪"));
        timeBeans.add(new TimeBean("16:00","开枪"));
        timeBeans.add(new TimeBean("17:00","开枪"));
        timeBeans.add(new TimeBean("18:00","开枪"));
        timeBeans.add(new TimeBean("19:00","开枪"));
        timeBeans.add(new TimeBean("20:00","开枪"));
        timeBeans.add(new TimeBean("21:00","开枪"));
        timeBeans.add(new TimeBean("22:00","开枪"));
        timeBeans.add(new TimeBean("23:00","开枪"));

        goodsBeans.add(new GoodsBean("iPhone X 256G","品味至臻，智者之选",8,11,"4000","9000"));
        goodsBeans.add(new GoodsBean("SK-II网红套组","品味至臻，智者之选",350,2,"499","2000"));
        goodsBeans.add(new GoodsBean("小米8","品味至臻，智者之选",153,47,"1000","2900"));
    }

    public class GoodsBean{
        String goodsName;
        String desc;
        int yigou;
        int sheng;
        String price;
        String oldPrice;

        public GoodsBean(String goodsName, String desc, int yigou, int sheng, String price, String oldPrice) {
            this.goodsName = goodsName;
            this.desc = desc;
            this.yigou = yigou;
            this.sheng = sheng;
            this.price = price;
            this.oldPrice = oldPrice;
        }

        public String getGoodsName() {
            return goodsName;
        }

        public void setGoodsName(String goodsName) {
            this.goodsName = goodsName;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public int getYigou() {
            return yigou;
        }

        public void setYigou(int yigou) {
            this.yigou = yigou;
        }

        public int getSheng() {
            return sheng;
        }

        public void setSheng(int sheng) {
            this.sheng = sheng;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getOldPrice() {
            return oldPrice;
        }

        public void setOldPrice(String oldPrice) {
            this.oldPrice = oldPrice;
        }
    }



    public static class TimeBean {
        String time;
        String name;
        boolean isSelect;

        public TimeBean(String time, String name) {
            this.time = time;
            this.name = name;
        }

        public boolean isSelect() {
            return isSelect;
        }

        public void setSelect(boolean select) {
            isSelect = select;
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

}
