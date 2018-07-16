package com.whmnrc.qiangbizhong.model.bean;

import java.util.List;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/16.
 */

public class AwardBeanInfo {


    /**
     * AwardGoodsInfo : {"Goods_ID":"bac3e3e2-80f3-4455-8216-fe9558b2f0e1","Goods_ShopType":2,"GoodsPrice_ID":"fac3e3e2-80f3-4455-8216-fe9558b2f0e2","AwardId":"5750a589-426e-4205-ad87-acafd98375b3","Goods_Name":"法拉利豪车","Goods_ImaPath":"/Resource/PhotoFile/2a908ea7-5a5f-4f3f-b6a7-ae7a17849e9e.png","Goods_Content":"<p>dwqwqeqwe<\/p>","Goods_Parameter":null,"GoodsPrice_SpecName":"F430","GoodsPrice_AttrName":"一辆","GoodsPrice_Price":4000000,"GoodsPrice_VirtualPrice":6000000,"GoodsPrice_Stock":1,"AwardPeopleCount":99,"NeedCount":100,"Bond":200,"IsEnd":0,"AwardTime":"2018-07-15 00:00:00"}
     * AwardGoodsBanner : []
     */

    private AwardGoodsInfoBean AwardGoodsInfo;
    private List<String> AwardGoodsBanner;

    public AwardGoodsInfoBean getAwardGoodsInfo() {
        return AwardGoodsInfo;
    }

    public void setAwardGoodsInfo(AwardGoodsInfoBean AwardGoodsInfo) {
        this.AwardGoodsInfo = AwardGoodsInfo;
    }

    public List<String> getAwardGoodsBanner() {
        return AwardGoodsBanner;
    }

    public void setAwardGoodsBanner(List<String> AwardGoodsBanner) {
        this.AwardGoodsBanner = AwardGoodsBanner;
    }

    public static class AwardGoodsInfoBean {
        /**
         * Goods_ID : bac3e3e2-80f3-4455-8216-fe9558b2f0e1
         * Goods_ShopType : 2
         * GoodsPrice_ID : fac3e3e2-80f3-4455-8216-fe9558b2f0e2
         * AwardId : 5750a589-426e-4205-ad87-acafd98375b3
         * Goods_Name : 法拉利豪车
         * Goods_ImaPath : /Resource/PhotoFile/2a908ea7-5a5f-4f3f-b6a7-ae7a17849e9e.png
         * Goods_Content : <p>dwqwqeqwe</p>
         * Goods_Parameter : null
         * GoodsPrice_SpecName : F430
         * GoodsPrice_AttrName : 一辆
         * GoodsPrice_Price : 4000000
         * GoodsPrice_VirtualPrice : 6000000
         * GoodsPrice_Stock : 1
         * AwardPeopleCount : 99
         * NeedCount : 100
         * Bond : 200
         * IsEnd : 0
         * AwardTime : 2018-07-15 00:00:00
         */

        private String Goods_ID;
        private int Goods_ShopType;
        private String GoodsPrice_ID;
        private String AwardId;
        private String Goods_Name;
        private String Goods_ImaPath;
        private String Goods_Content;
        private Object Goods_Parameter;
        private String GoodsPrice_SpecName;
        private String GoodsPrice_AttrName;
        private int GoodsPrice_Price;
        private int GoodsPrice_VirtualPrice;
        private int GoodsPrice_Stock;
        private int AwardPeopleCount;
        private int NeedCount;
        private int Bond;
        private int IsEnd;
        private String AwardTime;

        public String getGoods_ID() {
            return Goods_ID;
        }

        public void setGoods_ID(String Goods_ID) {
            this.Goods_ID = Goods_ID;
        }

        public int getGoods_ShopType() {
            return Goods_ShopType;
        }

        public void setGoods_ShopType(int Goods_ShopType) {
            this.Goods_ShopType = Goods_ShopType;
        }

        public String getGoodsPrice_ID() {
            return GoodsPrice_ID;
        }

        public void setGoodsPrice_ID(String GoodsPrice_ID) {
            this.GoodsPrice_ID = GoodsPrice_ID;
        }

        public String getAwardId() {
            return AwardId;
        }

        public void setAwardId(String AwardId) {
            this.AwardId = AwardId;
        }

        public String getGoods_Name() {
            return Goods_Name;
        }

        public void setGoods_Name(String Goods_Name) {
            this.Goods_Name = Goods_Name;
        }

        public String getGoods_ImaPath() {
            return Goods_ImaPath;
        }

        public void setGoods_ImaPath(String Goods_ImaPath) {
            this.Goods_ImaPath = Goods_ImaPath;
        }

        public String getGoods_Content() {
            return Goods_Content;
        }

        public void setGoods_Content(String Goods_Content) {
            this.Goods_Content = Goods_Content;
        }

        public Object getGoods_Parameter() {
            return Goods_Parameter;
        }

        public void setGoods_Parameter(Object Goods_Parameter) {
            this.Goods_Parameter = Goods_Parameter;
        }

        public String getGoodsPrice_SpecName() {
            return GoodsPrice_SpecName;
        }

        public void setGoodsPrice_SpecName(String GoodsPrice_SpecName) {
            this.GoodsPrice_SpecName = GoodsPrice_SpecName;
        }

        public String getGoodsPrice_AttrName() {
            return GoodsPrice_AttrName;
        }

        public void setGoodsPrice_AttrName(String GoodsPrice_AttrName) {
            this.GoodsPrice_AttrName = GoodsPrice_AttrName;
        }

        public int getGoodsPrice_Price() {
            return GoodsPrice_Price;
        }

        public void setGoodsPrice_Price(int GoodsPrice_Price) {
            this.GoodsPrice_Price = GoodsPrice_Price;
        }

        public int getGoodsPrice_VirtualPrice() {
            return GoodsPrice_VirtualPrice;
        }

        public void setGoodsPrice_VirtualPrice(int GoodsPrice_VirtualPrice) {
            this.GoodsPrice_VirtualPrice = GoodsPrice_VirtualPrice;
        }

        public int getGoodsPrice_Stock() {
            return GoodsPrice_Stock;
        }

        public void setGoodsPrice_Stock(int GoodsPrice_Stock) {
            this.GoodsPrice_Stock = GoodsPrice_Stock;
        }

        public int getAwardPeopleCount() {
            return AwardPeopleCount;
        }

        public void setAwardPeopleCount(int AwardPeopleCount) {
            this.AwardPeopleCount = AwardPeopleCount;
        }

        public int getNeedCount() {
            return NeedCount;
        }

        public void setNeedCount(int NeedCount) {
            this.NeedCount = NeedCount;
        }

        public int getBond() {
            return Bond;
        }

        public void setBond(int Bond) {
            this.Bond = Bond;
        }

        public int getIsEnd() {
            return IsEnd;
        }

        public void setIsEnd(int IsEnd) {
            this.IsEnd = IsEnd;
        }

        public String getAwardTime() {
            return AwardTime;
        }

        public void setAwardTime(String AwardTime) {
            this.AwardTime = AwardTime;
        }
    }
}
