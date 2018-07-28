package com.whmnrc.qiangbizhong.model.bean;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/14.
 */

public class RechargeBean {


    /**
     * GoodsPrice_Stock : 1000000
     * CanPayCount : 1000000
     * Price : 0.1
     * TotalMoney : 200
     */

    private int GoodsPrice_Stock;
    private int CanPayCount;
    private double Price;
    private int TotalMoney;
    private int TodayPayCount;

    public int getTodayPayCount() {
        return TodayPayCount;
    }

    public void setTodayPayCount(int todayPayCount) {
        TodayPayCount = todayPayCount;
    }

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

    public double getPrice() {
        return Price;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }

    public int getTotalMoney() {
        return TotalMoney;
    }

    public void setTotalMoney(int TotalMoney) {
        this.TotalMoney = TotalMoney;
    }
}
