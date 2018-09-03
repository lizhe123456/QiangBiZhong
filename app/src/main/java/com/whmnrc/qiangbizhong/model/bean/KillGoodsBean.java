package com.whmnrc.qiangbizhong.model.bean;

import java.util.List;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/12.
 */

public class KillGoodsBean {


    /**
     * HotGoods : {"RushId":"f79b404f-4e9f-49a2-932c-106395d4ffa5","Goods_MonthCount":0,"GoodsPrice_Stock":911,"Goods_ID":"f2cfb2f8-b6ec-41fc-bf6b-59c522e80fa7","Goods_ShopType":1,"GoodsPrice_ID":"45bc81fb-7ca8-4e2e-848c-d4e0b673392e","Goods_Name":"IPhone 兵222","Goods_ImaPath":"http://www.eehsxui.cn/Resource/PhotoFile/c6d130e9-285a-4f7a-bef2-c044d91ce061.jpg","Goods_Content":"<p>464684<\/p>","Goods_Parameter":null,"GoodsPrice_SpecName":"IPhone 7 亮黑色","GoodsPrice_AttrName":"32G","GoodsPrice_VirtualPrice":4000,"RushStartTime":"2018-07-13 22:00:00","RushEndTime":"2018-07-14 00:00:00","RushNumber":2,"Bond":100,"Price":4000,"GoodsPrice_Price":6000,"IsEnd":0}
     * Goods : [{"RushId":"f79b404f-4e9f-49a2-932c-106395d4ffa5","Goods_MonthCount":0,"GoodsPrice_Stock":911,"Goods_ID":"f2cfb2f8-b6ec-41fc-bf6b-59c522e80fa7","Goods_ShopType":1,"GoodsPrice_ID":"45bc81fb-7ca8-4e2e-848c-d4e0b673392e","Goods_Name":"IPhone 兵222","Goods_ImaPath":"http://www.eehsxui.cn/Resource/PhotoFile/c6d130e9-285a-4f7a-bef2-c044d91ce061.jpg","Goods_Content":"<p>464684<\/p>","Goods_Parameter":null,"GoodsPrice_SpecName":"IPhone 7 亮黑色","GoodsPrice_AttrName":"32G","GoodsPrice_VirtualPrice":4000,"RushStartTime":"2018-07-13 22:00:00","RushEndTime":"2018-07-14 00:00:00","RushNumber":2,"Bond":100,"Price":4000,"GoodsPrice_Price":6000,"IsEnd":0},{"RushId":"f79b404f-4e9f-49a2-932c-106395d4ffa8","Goods_MonthCount":0,"GoodsPrice_Stock":9945,"Goods_ID":"fd1e07eb-1940-4388-941e-4d7a6b5c9759","Goods_ShopType":1,"GoodsPrice_ID":"863dd59f-154c-49b4-bd5a-d9a1259e8470","Goods_Name":"雅茜薇兰罗马之恋系列","Goods_ImaPath":"http://www.eehsxui.cn/Resource/PhotoFile/c6d130e9-285a-4f7a-bef2-c044d91ce061.jpg","Goods_Content":"<p><img src=\"http://www.eehsxui.cn/Resource/image/20180408/6365878635201428251760617.jpg\" title=\"罗马之恋系列1.jpg\" alt=\"罗马之恋系列1.jpg\"/><img src=\"http://www.eehsxui.cn/Resource/image/20180408/6365878635429553257629892.jpg\" title=\"罗马之恋系列2.jpg\" alt=\"罗马之恋系列2.jpg\"/><img src=\"http://www.eehsxui.cn/Resource/image/20180408/6365878635668615753998401.jpg\" title=\"罗马之恋系列3.jpg\" alt=\"罗马之恋系列3.jpg\"/><img src=\"http://www.eehsxui.cn/Resource/image/20180408/6365878635984240756668853.jpg\" title=\"罗马之恋系列4.jpg\" alt=\"罗马之恋系列4.jpg\"/><img src=\"http://www.eehsxui.cn/Resource/image/20180408/6365878636213928256767373.jpg\" title=\"罗马之恋系列5.jpg\" alt=\"罗马之恋系列5.jpg\"/><img src=\"http://www.eehsxui.cn/Resource/image/20180408/6365878636460803259878452.jpg\" title=\"罗马之恋系列6.jpg\" alt=\"罗马之恋系列6.jpg\"/><img src=\"http://www.eehsxui.cn/Resource/image/20180408/6365878636807678253519186.jpg\" title=\"罗马之恋系列7.jpg\" alt=\"罗马之恋系列7.jpg\"/><img src=\"http://www.eehsxui.cn/Resource/image/20180408/6365878637046740754589522.jpg\" title=\"罗马之恋系列8.jpg\" alt=\"罗马之恋系列8.jpg\"/><img src=\"http://www.eehsxui.cn/Resource/image/20180408/6365878637284240752430613.jpg\" title=\"罗马之恋系列9.jpg\" alt=\"罗马之恋系列9.jpg\"/><img src=\"http://www.eehsxui.cn/Resource/image/20180408/6365878637526428255257612.jpg\" title=\"罗马之恋系列10.jpg\" alt=\"罗马之恋系列10.jpg\"/><\/p>","Goods_Parameter":null,"GoodsPrice_SpecName":null,"GoodsPrice_AttrName":"1套","GoodsPrice_VirtualPrice":88,"RushStartTime":"2018-07-13 22:00:00","RushEndTime":"2018-07-14 00:00:00","RushNumber":1,"Bond":100,"Price":4800,"GoodsPrice_Price":6000,"IsEnd":0}]
     */

    private HotGoodsBean HotGoods;
    private List<GoodsBean> Goods;

    public HotGoodsBean getHotGoods() {
        return HotGoods;
    }

    public void setHotGoods(HotGoodsBean HotGoods) {
        this.HotGoods = HotGoods;
    }

    public List<GoodsBean> getGoods() {
        return Goods;
    }

    public void setGoods(List<GoodsBean> Goods) {
        this.Goods = Goods;
    }

    public static class HotGoodsBean {
        /**
         * RushId : f79b404f-4e9f-49a2-932c-106395d4ffa5
         * Goods_MonthCount : 0
         * GoodsPrice_Stock : 911
         * Goods_ID : f2cfb2f8-b6ec-41fc-bf6b-59c522e80fa7
         * Goods_ShopType : 1
         * GoodsPrice_ID : 45bc81fb-7ca8-4e2e-848c-d4e0b673392e
         * Goods_Name : IPhone 兵222
         * Goods_ImaPath : http://www.eehsxui.cn/Resource/PhotoFile/c6d130e9-285a-4f7a-bef2-c044d91ce061.jpg
         * Goods_Content : <p>464684</p>
         * Goods_Parameter : null
         * GoodsPrice_SpecName : IPhone 7 亮黑色
         * GoodsPrice_AttrName : 32G
         * GoodsPrice_VirtualPrice : 4000
         * RushStartTime : 2018-07-13 22:00:00
         * RushEndTime : 2018-07-14 00:00:00
         * RushNumber : 2
         * Bond : 100
         * Price : 4000
         * GoodsPrice_Price : 6000
         * IsEnd : 0
         */

        private String RushId;
        private int Goods_MonthCount;
        private int GoodsPrice_Stock;
        private String Goods_ID;
        private int Goods_ShopType;
        private String GoodsPrice_ID;
        private String Goods_Name;
        private String Goods_ImaPath;
        private String Goods_Content;
        private Object Goods_Parameter;
        private String GoodsPrice_SpecName;
        private String GoodsPrice_AttrName;
        private double GoodsPrice_VirtualPrice;
        private String RushStartTime;
        private String RushEndTime;
        private int RushNumber;
        private int Bond;
        private int Price;
        private double GoodsPrice_Price;
        private int IsEnd;

        public String getRushId() {
            return RushId;
        }

        public void setRushId(String RushId) {
            this.RushId = RushId;
        }

        public int getGoods_MonthCount() {
            return Goods_MonthCount;
        }

        public void setGoods_MonthCount(int Goods_MonthCount) {
            this.Goods_MonthCount = Goods_MonthCount;
        }

        public int getGoodsPrice_Stock() {
            return GoodsPrice_Stock;
        }

        public void setGoodsPrice_Stock(int GoodsPrice_Stock) {
            this.GoodsPrice_Stock = GoodsPrice_Stock;
        }

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

        public double getGoodsPrice_VirtualPrice() {
            return GoodsPrice_VirtualPrice;
        }

        public void setGoodsPrice_VirtualPrice(double GoodsPrice_VirtualPrice) {
            this.GoodsPrice_VirtualPrice = GoodsPrice_VirtualPrice;
        }

        public String getRushStartTime() {
            return RushStartTime;
        }

        public void setRushStartTime(String RushStartTime) {
            this.RushStartTime = RushStartTime;
        }

        public String getRushEndTime() {
            return RushEndTime;
        }

        public void setRushEndTime(String RushEndTime) {
            this.RushEndTime = RushEndTime;
        }

        public int getRushNumber() {
            return RushNumber;
        }

        public void setRushNumber(int RushNumber) {
            this.RushNumber = RushNumber;
        }

        public int getBond() {
            return Bond;
        }

        public void setBond(int Bond) {
            this.Bond = Bond;
        }

        public int getPrice() {
            return Price;
        }

        public void setPrice(int Price) {
            this.Price = Price;
        }

        public double getGoodsPrice_Price() {
            return GoodsPrice_Price;
        }

        public void setGoodsPrice_Price(double GoodsPrice_Price) {
            this.GoodsPrice_Price = GoodsPrice_Price;
        }

        public int getIsEnd() {
            return IsEnd;
        }

        public void setIsEnd(int IsEnd) {
            this.IsEnd = IsEnd;
        }
    }

    public static class GoodsBean {
        /**
         * RushId : f79b404f-4e9f-49a2-932c-106395d4ffa5
         * Goods_MonthCount : 0
         * GoodsPrice_Stock : 911
         * Goods_ID : f2cfb2f8-b6ec-41fc-bf6b-59c522e80fa7
         * Goods_ShopType : 1
         * GoodsPrice_ID : 45bc81fb-7ca8-4e2e-848c-d4e0b673392e
         * Goods_Name : IPhone 兵222
         * Goods_ImaPath : http://www.eehsxui.cn/Resource/PhotoFile/c6d130e9-285a-4f7a-bef2-c044d91ce061.jpg
         * Goods_Content : <p>464684</p>
         * Goods_Parameter : null
         * GoodsPrice_SpecName : IPhone 7 亮黑色
         * GoodsPrice_AttrName : 32G
         * GoodsPrice_VirtualPrice : 4000
         * RushStartTime : 2018-07-13 22:00:00
         * RushEndTime : 2018-07-14 00:00:00
         * RushNumber : 2
         * Bond : 100
         * Price : 4000
         * GoodsPrice_Price : 6000
         * IsEnd : 0
         */

        private String RushId;
        private int Goods_MonthCount;
        private int GoodsPrice_Stock;
        private String Goods_ID;
        private int Goods_ShopType;
        private String GoodsPrice_ID;
        private String Goods_Name;
        private String Goods_ImaPath;
        private String Goods_Content;
        private Object Goods_Parameter;
        private String GoodsPrice_SpecName;
        private String GoodsPrice_AttrName;
        private double GoodsPrice_VirtualPrice;
        private String RushStartTime;
        private String RushEndTime;
        private int RushNumber;
        private int Bond;
        private int Price;
        private double GoodsPrice_Price;
        private int IsEnd;

        public String getRushId() {
            return RushId;
        }

        public void setRushId(String RushId) {
            this.RushId = RushId;
        }

        public int getGoods_MonthCount() {
            return Goods_MonthCount;
        }

        public void setGoods_MonthCount(int Goods_MonthCount) {
            this.Goods_MonthCount = Goods_MonthCount;
        }

        public int getGoodsPrice_Stock() {
            return GoodsPrice_Stock;
        }

        public void setGoodsPrice_Stock(int GoodsPrice_Stock) {
            this.GoodsPrice_Stock = GoodsPrice_Stock;
        }

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

        public double getGoodsPrice_VirtualPrice() {
            return GoodsPrice_VirtualPrice;
        }

        public void setGoodsPrice_VirtualPrice(double GoodsPrice_VirtualPrice) {
            this.GoodsPrice_VirtualPrice = GoodsPrice_VirtualPrice;
        }

        public String getRushStartTime() {
            return RushStartTime;
        }

        public void setRushStartTime(String RushStartTime) {
            this.RushStartTime = RushStartTime;
        }

        public String getRushEndTime() {
            return RushEndTime;
        }

        public void setRushEndTime(String RushEndTime) {
            this.RushEndTime = RushEndTime;
        }

        public int getRushNumber() {
            return RushNumber;
        }

        public void setRushNumber(int RushNumber) {
            this.RushNumber = RushNumber;
        }

        public int getBond() {
            return Bond;
        }

        public void setBond(int Bond) {
            this.Bond = Bond;
        }

        public int getPrice() {
            return Price;
        }

        public void setPrice(int Price) {
            this.Price = Price;
        }

        public double getGoodsPrice_Price() {
            return GoodsPrice_Price;
        }

        public void setGoodsPrice_Price(double GoodsPrice_Price) {
            this.GoodsPrice_Price = GoodsPrice_Price;
        }

        public int getIsEnd() {
            return IsEnd;
        }

        public void setIsEnd(int IsEnd) {
            this.IsEnd = IsEnd;
        }
    }
}
