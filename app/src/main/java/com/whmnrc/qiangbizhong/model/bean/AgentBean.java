package com.whmnrc.qiangbizhong.model.bean;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/8/8.
 */

public class AgentBean {


    /**
     * Id : 0ed55a40-32c9-4580-b6ec-ca6e12f19667
     * HeadImage : http://testaml.whmnx.com/Resource/HeadImage/default.jpg
     * AgentName : 阿三的豆子铺
     * Discount : 8
     * UserId : 023814e9-8df0-49eb-880b-740c57d4bfa2
     * Status : 1
     * CreateDate : 2018-07-18 15:25:04
     * Sort : 0
     * Price : 1
     * Stock : 8000
     * Sales : 0
     */

    private String Id;
    private String HeadImage;
    private String AgentName;
    private int Discount;
    private String UserId;
    private int Status;
    private String CreateDate;
    private int Sort;
    private int Price;
    private int Stock;
    private int Sales;

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getHeadImage() {
        return HeadImage;
    }

    public void setHeadImage(String HeadImage) {
        this.HeadImage = HeadImage;
    }

    public String getAgentName() {
        return AgentName;
    }

    public void setAgentName(String AgentName) {
        this.AgentName = AgentName;
    }

    public int getDiscount() {
        return Discount;
    }

    public void setDiscount(int Discount) {
        this.Discount = Discount;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String UserId) {
        this.UserId = UserId;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int Status) {
        this.Status = Status;
    }

    public String getCreateDate() {
        return CreateDate;
    }

    public void setCreateDate(String CreateDate) {
        this.CreateDate = CreateDate;
    }

    public int getSort() {
        return Sort;
    }

    public void setSort(int Sort) {
        this.Sort = Sort;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int Price) {
        this.Price = Price;
    }

    public int getStock() {
        return Stock;
    }

    public void setStock(int Stock) {
        this.Stock = Stock;
    }

    public int getSales() {
        return Sales;
    }

    public void setSales(int Sales) {
        this.Sales = Sales;
    }
}
