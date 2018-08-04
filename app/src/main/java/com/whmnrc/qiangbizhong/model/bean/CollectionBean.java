package com.whmnrc.qiangbizhong.model.bean;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/8/1.
 */

public class CollectionBean {


    /**
     * Id : 8e8671ec-d3f2-46f4-a591-421f1873d3f9
     * CollectionType : 0
     * Goods_ID : 40ce8944-6441-405d-bb98-c8cc835a8bac
     * StoreId : null
     * UserId : bda06fce-e199-47a9-9a45-6ee3c4fae39c
     * StoreName : null
     * StoreHeadImage : null
     * Address : null
     * Explain : null
     * Goods_Name : IPhone
     * Goods_PriceMin : 4500
     * Goods_ImaPath : http://192.168.1.157:8011/Resource/PhotoFile/fcd07f96-22a0-4311-81b4-bfb64a053490.png
     * Goods_ShopType : 0
     * CreateDate : 2018-07-31 16:22:33
     */

    private String Id;
    private int CollectionType;
    private String Goods_ID;
    private String StoreId;
    private String UserId;
    private String StoreName;
    private String StoreHeadImage;
    private String Address;
    private String Explain;
    private String Goods_Name;
    private int Goods_PriceMin;
    private String Goods_ImaPath;
    private int Goods_ShopType;
    private String CreateDate;
    private boolean isSelect;

    public boolean isSelect() {
        return isSelect;
    }

    public void setSelect(boolean select) {
        isSelect = select;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public int getCollectionType() {
        return CollectionType;
    }

    public void setCollectionType(int CollectionType) {
        this.CollectionType = CollectionType;
    }

    public String getGoods_ID() {
        return Goods_ID;
    }

    public void setGoods_ID(String Goods_ID) {
        this.Goods_ID = Goods_ID;
    }

    public String getStoreId() {
        return StoreId;
    }

    public void setStoreId(String StoreId) {
        this.StoreId = StoreId;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String UserId) {
        this.UserId = UserId;
    }

    public String getStoreName() {
        return StoreName;
    }

    public void setStoreName(String StoreName) {
        this.StoreName = StoreName;
    }

    public String getStoreHeadImage() {
        return StoreHeadImage;
    }

    public void setStoreHeadImage(String StoreHeadImage) {
        this.StoreHeadImage = StoreHeadImage;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getExplain() {
        return Explain;
    }

    public void setExplain(String Explain) {
        this.Explain = Explain;
    }

    public String getGoods_Name() {
        return Goods_Name;
    }

    public void setGoods_Name(String Goods_Name) {
        this.Goods_Name = Goods_Name;
    }

    public int getGoods_PriceMin() {
        return Goods_PriceMin;
    }

    public void setGoods_PriceMin(int Goods_PriceMin) {
        this.Goods_PriceMin = Goods_PriceMin;
    }

    public String getGoods_ImaPath() {
        return Goods_ImaPath;
    }

    public void setGoods_ImaPath(String Goods_ImaPath) {
        this.Goods_ImaPath = Goods_ImaPath;
    }

    public int getGoods_ShopType() {
        return Goods_ShopType;
    }

    public void setGoods_ShopType(int Goods_ShopType) {
        this.Goods_ShopType = Goods_ShopType;
    }

    public String getCreateDate() {
        return CreateDate;
    }

    public void setCreateDate(String CreateDate) {
        this.CreateDate = CreateDate;
    }
}
