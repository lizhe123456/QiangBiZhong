package com.whmnrc.qiangbizhong.model.bean;

import java.util.List;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/8/8.
 */

public class EditSpecBean {


    /**
     * Items : [{"GoodsPrice_ID":"1a096417-13a3-4c88-9849-97a2c831414d","GoodsPrice_SpecName":"Iphone 蓝色","GoodsPrice_AttrName":"128G","GoodsPrice_Price":8000,"Goods_ID":"40ce8944-6441-405d-bb98-c8cc835a8bac","GoodsPrice_Sort":1,"GoodsPrice_Stock":999,"GoodsPrice_TotalStock":1000,"GoodsPrice_VirtualPrice":9500,"GoodsPrice_PayMaxCount":0},{"GoodsPrice_ID":"2b378dca-c2ed-4b1e-90e4-0f8d087e26f8","GoodsPrice_SpecName":"Iphone 黑色","GoodsPrice_AttrName":"32G","GoodsPrice_Price":4500,"Goods_ID":"40ce8944-6441-405d-bb98-c8cc835a8bac","GoodsPrice_Sort":1,"GoodsPrice_Stock":996,"GoodsPrice_TotalStock":1000,"GoodsPrice_VirtualPrice":6000,"GoodsPrice_PayMaxCount":0},{"GoodsPrice_ID":"7c33074d-dd68-42f2-a2d2-f18fd19e6108","GoodsPrice_SpecName":"Iphone 黑色","GoodsPrice_AttrName":"64G","GoodsPrice_Price":5500,"Goods_ID":"40ce8944-6441-405d-bb98-c8cc835a8bac","GoodsPrice_Sort":2,"GoodsPrice_Stock":986,"GoodsPrice_TotalStock":1000,"GoodsPrice_VirtualPrice":6500,"GoodsPrice_PayMaxCount":0}]
     * GoodsInfo : {"Goods_ID":"40ce8944-6441-405d-bb98-c8cc835a8bac","Goods_Name":"IPhone","Goods_BrandName":"Apple","Goods_Describe":"苹果手机","Goods_ImaPath":"http://192.168.1.157:8011/Resource/PhotoFile/fcd07f96-22a0-4311-81b4-bfb64a053490.png","Goods_Content":null,"Goods_LookCount":0,"Goods_MonthCount":19,"Goods_Sort":1,"Goods_IsOn":true,"Goods_IsBuy":true,"Goods_Type":"94dfa9cc-3d03-4524-af07-8e401a24875d","Goods_LimitCount":1,"StoreId":"f9641e98-a561-46f9-8cb9-aa9c43daabb0","Goods_Parameter":null,"Goods_ShopType":0,"Goods_PriceMin":4500,"Goods_PriceMax":8000}
     */

    private GoodsInfoBean GoodsInfo;
    private List<ItemsBean> Items;

    public GoodsInfoBean getGoodsInfo() {
        return GoodsInfo;
    }

    public void setGoodsInfo(GoodsInfoBean GoodsInfo) {
        this.GoodsInfo = GoodsInfo;
    }

    public List<ItemsBean> getItems() {
        return Items;
    }

    public void setItems(List<ItemsBean> Items) {
        this.Items = Items;
    }

    public static class GoodsInfoBean {
        /**
         * Goods_ID : 40ce8944-6441-405d-bb98-c8cc835a8bac
         * Goods_Name : IPhone
         * Goods_BrandName : Apple
         * Goods_Describe : 苹果手机
         * Goods_ImaPath : http://192.168.1.157:8011/Resource/PhotoFile/fcd07f96-22a0-4311-81b4-bfb64a053490.png
         * Goods_Content : null
         * Goods_LookCount : 0
         * Goods_MonthCount : 19
         * Goods_Sort : 1
         * Goods_IsOn : true
         * Goods_IsBuy : true
         * Goods_Type : 94dfa9cc-3d03-4524-af07-8e401a24875d
         * Goods_LimitCount : 1
         * StoreId : f9641e98-a561-46f9-8cb9-aa9c43daabb0
         * Goods_Parameter : null
         * Goods_ShopType : 0
         * Goods_PriceMin : 4500
         * Goods_PriceMax : 8000
         */

        private String Goods_ID;
        private String Goods_Name;
        private String Goods_BrandName;
        private String Goods_Describe;
        private String Goods_ImaPath;
        private Object Goods_Content;
        private int Goods_LookCount;
        private int Goods_MonthCount;
        private int Goods_Sort;
        private boolean Goods_IsOn;
        private boolean Goods_IsBuy;
        private String Goods_Type;
        private int Goods_LimitCount;
        private String StoreId;
        private Object Goods_Parameter;
        private int Goods_ShopType;
        private double Goods_PriceMin;
        private double Goods_PriceMax;

        public String getGoods_ID() {
            return Goods_ID;
        }

        public void setGoods_ID(String Goods_ID) {
            this.Goods_ID = Goods_ID;
        }

        public String getGoods_Name() {
            return Goods_Name;
        }

        public void setGoods_Name(String Goods_Name) {
            this.Goods_Name = Goods_Name;
        }

        public String getGoods_BrandName() {
            return Goods_BrandName;
        }

        public void setGoods_BrandName(String Goods_BrandName) {
            this.Goods_BrandName = Goods_BrandName;
        }

        public String getGoods_Describe() {
            return Goods_Describe;
        }

        public void setGoods_Describe(String Goods_Describe) {
            this.Goods_Describe = Goods_Describe;
        }

        public String getGoods_ImaPath() {
            return Goods_ImaPath;
        }

        public void setGoods_ImaPath(String Goods_ImaPath) {
            this.Goods_ImaPath = Goods_ImaPath;
        }

        public Object getGoods_Content() {
            return Goods_Content;
        }

        public void setGoods_Content(Object Goods_Content) {
            this.Goods_Content = Goods_Content;
        }

        public int getGoods_LookCount() {
            return Goods_LookCount;
        }

        public void setGoods_LookCount(int Goods_LookCount) {
            this.Goods_LookCount = Goods_LookCount;
        }

        public int getGoods_MonthCount() {
            return Goods_MonthCount;
        }

        public void setGoods_MonthCount(int Goods_MonthCount) {
            this.Goods_MonthCount = Goods_MonthCount;
        }

        public int getGoods_Sort() {
            return Goods_Sort;
        }

        public void setGoods_Sort(int Goods_Sort) {
            this.Goods_Sort = Goods_Sort;
        }

        public boolean isGoods_IsOn() {
            return Goods_IsOn;
        }

        public void setGoods_IsOn(boolean Goods_IsOn) {
            this.Goods_IsOn = Goods_IsOn;
        }

        public boolean isGoods_IsBuy() {
            return Goods_IsBuy;
        }

        public void setGoods_IsBuy(boolean Goods_IsBuy) {
            this.Goods_IsBuy = Goods_IsBuy;
        }

        public String getGoods_Type() {
            return Goods_Type;
        }

        public void setGoods_Type(String Goods_Type) {
            this.Goods_Type = Goods_Type;
        }

        public int getGoods_LimitCount() {
            return Goods_LimitCount;
        }

        public void setGoods_LimitCount(int Goods_LimitCount) {
            this.Goods_LimitCount = Goods_LimitCount;
        }

        public String getStoreId() {
            return StoreId;
        }

        public void setStoreId(String StoreId) {
            this.StoreId = StoreId;
        }

        public Object getGoods_Parameter() {
            return Goods_Parameter;
        }

        public void setGoods_Parameter(Object Goods_Parameter) {
            this.Goods_Parameter = Goods_Parameter;
        }

        public int getGoods_ShopType() {
            return Goods_ShopType;
        }

        public void setGoods_ShopType(int Goods_ShopType) {
            this.Goods_ShopType = Goods_ShopType;
        }

        public double getGoods_PriceMin() {
            return Goods_PriceMin;
        }

        public void setGoods_PriceMin(double Goods_PriceMin) {
            this.Goods_PriceMin = Goods_PriceMin;
        }

        public double getGoods_PriceMax() {
            return Goods_PriceMax;
        }

        public void setGoods_PriceMax(double Goods_PriceMax) {
            this.Goods_PriceMax = Goods_PriceMax;
        }
    }

    public static class ItemsBean {
        /**
         * GoodsPrice_ID : 1a096417-13a3-4c88-9849-97a2c831414d
         * GoodsPrice_SpecName : Iphone 蓝色
         * GoodsPrice_AttrName : 128G
         * GoodsPrice_Price : 8000
         * Goods_ID : 40ce8944-6441-405d-bb98-c8cc835a8bac
         * GoodsPrice_Sort : 1
         * GoodsPrice_Stock : 999
         * GoodsPrice_TotalStock : 1000
         * GoodsPrice_VirtualPrice : 9500
         * GoodsPrice_PayMaxCount : 0
         */

        private String GoodsPrice_ID;
        private String GoodsPrice_SpecName;
        private String GoodsPrice_AttrName;
        private double GoodsPrice_Price;
        private String Goods_ID;
        private int GoodsPrice_Sort;
        private int GoodsPrice_Stock;
        private int GoodsPrice_TotalStock;
        private double GoodsPrice_VirtualPrice;
        private double GoodsPrice_PayMaxCount;

        public String getGoodsPrice_ID() {
            return GoodsPrice_ID;
        }

        public void setGoodsPrice_ID(String GoodsPrice_ID) {
            this.GoodsPrice_ID = GoodsPrice_ID;
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

        public double getGoodsPrice_Price() {
            return GoodsPrice_Price;
        }

        public void setGoodsPrice_Price(double GoodsPrice_Price) {
            this.GoodsPrice_Price = GoodsPrice_Price;
        }

        public String getGoods_ID() {
            return Goods_ID;
        }

        public void setGoods_ID(String Goods_ID) {
            this.Goods_ID = Goods_ID;
        }

        public int getGoodsPrice_Sort() {
            return GoodsPrice_Sort;
        }

        public void setGoodsPrice_Sort(int GoodsPrice_Sort) {
            this.GoodsPrice_Sort = GoodsPrice_Sort;
        }

        public int getGoodsPrice_Stock() {
            return GoodsPrice_Stock;
        }

        public void setGoodsPrice_Stock(int GoodsPrice_Stock) {
            this.GoodsPrice_Stock = GoodsPrice_Stock;
        }

        public int getGoodsPrice_TotalStock() {
            return GoodsPrice_TotalStock;
        }

        public void setGoodsPrice_TotalStock(int GoodsPrice_TotalStock) {
            this.GoodsPrice_TotalStock = GoodsPrice_TotalStock;
        }

        public double getGoodsPrice_VirtualPrice() {
            return GoodsPrice_VirtualPrice;
        }

        public void setGoodsPrice_VirtualPrice(double GoodsPrice_VirtualPrice) {
            this.GoodsPrice_VirtualPrice = GoodsPrice_VirtualPrice;
        }

        public double getGoodsPrice_PayMaxCount() {
            return GoodsPrice_PayMaxCount;
        }

        public void setGoodsPrice_PayMaxCount(double GoodsPrice_PayMaxCount) {
            this.GoodsPrice_PayMaxCount = GoodsPrice_PayMaxCount;
        }
    }
}
