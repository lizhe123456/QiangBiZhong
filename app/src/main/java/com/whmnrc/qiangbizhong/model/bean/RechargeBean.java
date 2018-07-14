package com.whmnrc.qiangbizhong.model.bean;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/14.
 */

public class RechargeBean {


    /**
     * GoodsPrice_Stock : 100000
     * CanPayCount : 10000
     * Price : 6000
     */

    private int GoodsPrice_Stock;
    private int CanPayCount;
    private int Price;

    public int getGoodsPrice_Stock() {
        return GoodsPrice_Stock;
    }

    public void setGoodsPrice_Stock(int GoodsPrice_Stock) {
        this.GoodsPrice_Stock = GoodsPrice_Stock;
    }

    public int getCanPayCount() {
        return CanPayCount;
    }

    public void setCanPayCount(int CanPayCount) {
        this.CanPayCount = CanPayCount;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int Price) {
        this.Price = Price;
    }
}
