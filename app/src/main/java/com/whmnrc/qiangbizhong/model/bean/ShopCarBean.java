package com.whmnrc.qiangbizhong.model.bean;


import java.util.List;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/7.
 */

public class ShopCarBean {


    /**
     * StoreId : 43956e13-8dd6-476b-b6e4-02a73be238c4
     * StoreName : 艾美链
     * Goods : [{"BuyCar_ID":"275d16b7-849f-47e9-8eb3-e4b4380e8b42","Goods_ID":"4d0123ef-51df-4acd-8700-6e1cfe41dc72","GoodsPrice_ID":"120a2890-2fec-4226-8bed-f0f0c55f599a","UserInfo_ID":"bda06fce-e199-47a9-9a45-6ee3c4fae39c","BuyCar_Num":1,"BuyCar_CreateDate":"2018-07-28 00:00:00","GoodsPrice_Price":800,"Goods_Name":"宝马2018款 320Li时尚版","GoodsPrice_AttrName":"红色","GoodsPrice_SpecName":"宝马2018款 320Li时尚版","Goods_ImaPath":"http://192.168.1.157:8011/Resource/PhotoFile/e2664899-5aa9-4d4b-8f2b-2fb6270299ad.png","StoreId":"43956e13-8dd6-476b-b6e4-02a73be238c4","StoreName":"艾美链"}]
     */

    private String StoreId;
    private String StoreName;
    private List<GoodsBean> Goods;
    private boolean isSelect;
    private boolean allSelect;
    private String etDsec = "";

    public String getEtDsec() {
        return etDsec;
    }

    public void setEtDsec(String etDsec) {
        this.etDsec = etDsec;
    }

    public boolean isAllSelect() {
        return allSelect;
    }

    public void setAllSelect(boolean allSelect) {
        this.allSelect = allSelect;
    }

    public boolean isSelect() {
        return isSelect;
    }

    public void setSelect(boolean select) {
        isSelect = select;
    }

    public String getStoreId() {
        return StoreId;
    }

    public void setStoreId(String StoreId) {
        this.StoreId = StoreId;
    }

    public String getStoreName() {
        return StoreName;
    }

    public void setStoreName(String StoreName) {
        this.StoreName = StoreName;
    }

    public List<GoodsBean> getGoods() {
        return Goods;
    }

    public void setGoods(List<GoodsBean> Goods) {
        this.Goods = Goods;
    }

    public static class GoodsBean {
        /**
         * BuyCar_ID : 275d16b7-849f-47e9-8eb3-e4b4380e8b42
         * Goods_ID : 4d0123ef-51df-4acd-8700-6e1cfe41dc72
         * GoodsPrice_ID : 120a2890-2fec-4226-8bed-f0f0c55f599a
         * UserInfo_ID : bda06fce-e199-47a9-9a45-6ee3c4fae39c
         * BuyCar_Num : 1
         * BuyCar_CreateDate : 2018-07-28 00:00:00
         * GoodsPrice_Price : 800
         * Goods_Name : 宝马2018款 320Li时尚版
         * GoodsPrice_AttrName : 红色
         * GoodsPrice_SpecName : 宝马2018款 320Li时尚版
         * Goods_ImaPath : http://192.168.1.157:8011/Resource/PhotoFile/e2664899-5aa9-4d4b-8f2b-2fb6270299ad.png
         * StoreId : 43956e13-8dd6-476b-b6e4-02a73be238c4
         * StoreName : 艾美链
         */

        private String BuyCar_ID;
        private String Goods_ID;
        private String GoodsPrice_ID;
        private String UserInfo_ID;
        private int BuyCar_Num;
        private String BuyCar_CreateDate;
        private double GoodsPrice_Price;
        private String Goods_Name;
        private String GoodsPrice_AttrName;
        private String GoodsPrice_SpecName;
        private String Goods_ImaPath;
        private String StoreId;
        private String StoreName;
        private boolean isSelect;

        public boolean isSelect() {
            return isSelect;
        }

        public void setSelect(boolean select) {
            isSelect = select;
        }

        public String getBuyCar_ID() {
            return BuyCar_ID;
        }

        public void setBuyCar_ID(String BuyCar_ID) {
            this.BuyCar_ID = BuyCar_ID;
        }

        public String getGoods_ID() {
            return Goods_ID;
        }

        public void setGoods_ID(String Goods_ID) {
            this.Goods_ID = Goods_ID;
        }

        public String getGoodsPrice_ID() {
            return GoodsPrice_ID;
        }

        public void setGoodsPrice_ID(String GoodsPrice_ID) {
            this.GoodsPrice_ID = GoodsPrice_ID;
        }

        public String getUserInfo_ID() {
            return UserInfo_ID;
        }

        public void setUserInfo_ID(String UserInfo_ID) {
            this.UserInfo_ID = UserInfo_ID;
        }

        public int getBuyCar_Num() {
            return BuyCar_Num;
        }

        public void setBuyCar_Num(int BuyCar_Num) {
            this.BuyCar_Num = BuyCar_Num;
        }

        public String getBuyCar_CreateDate() {
            return BuyCar_CreateDate;
        }

        public void setBuyCar_CreateDate(String BuyCar_CreateDate) {
            this.BuyCar_CreateDate = BuyCar_CreateDate;
        }

        public double getGoodsPrice_Price() {
            return GoodsPrice_Price;
        }

        public void setGoodsPrice_Price(double GoodsPrice_Price) {
            this.GoodsPrice_Price = GoodsPrice_Price;
        }

        public String getGoods_Name() {
            return Goods_Name;
        }

        public void setGoods_Name(String Goods_Name) {
            this.Goods_Name = Goods_Name;
        }

        public String getGoodsPrice_AttrName() {
            return GoodsPrice_AttrName;
        }

        public void setGoodsPrice_AttrName(String GoodsPrice_AttrName) {
            this.GoodsPrice_AttrName = GoodsPrice_AttrName;
        }

        public String getGoodsPrice_SpecName() {
            return GoodsPrice_SpecName;
        }

        public void setGoodsPrice_SpecName(String GoodsPrice_SpecName) {
            this.GoodsPrice_SpecName = GoodsPrice_SpecName;
        }

        public String getGoods_ImaPath() {
            return Goods_ImaPath;
        }

        public void setGoods_ImaPath(String Goods_ImaPath) {
            this.Goods_ImaPath = Goods_ImaPath;
        }

        public String getStoreId() {
            return StoreId;
        }

        public void setStoreId(String StoreId) {
            this.StoreId = StoreId;
        }

        public String getStoreName() {
            return StoreName;
        }

        public void setStoreName(String StoreName) {
            this.StoreName = StoreName;
        }
    }
}
