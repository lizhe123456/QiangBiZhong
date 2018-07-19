package com.whmnrc.qiangbizhong.model.bean;

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
        int Status;
        String Time;
        boolean isSelect;


        public boolean isSelect() {
            return isSelect;
        }

        public void setSelect(boolean select) {
            isSelect = select;
        }

        public String getTime() {
            return Time;
        }

        public void setTime(String time) {
            this.Time = time;
        }

        public int getS(){
            return Status;
        }

        public String getStatus() {
            if (Status == 0){
                return "即将开枪";
            }else if (Status == 1){
                return "开抢进行中";
            }else if (Status == 2){
                return "已开抢";
            }
            return "";
        }

        public void setStatus(int status) {
            Status = status;
        }
    }

}
