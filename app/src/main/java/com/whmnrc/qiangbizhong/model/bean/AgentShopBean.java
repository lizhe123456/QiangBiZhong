package com.whmnrc.qiangbizhong.model.bean;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/8/11.
 */

public class AgentShopBean {


    /**
     * Id : 30a31acb-a1a6-49f1-b6bd-7fea2b1e8659
     * HeadImage : http://192.168.1.157:8011/Resource/HeadImage/bda06fce-e199-47a9-9a45-6ee3c4fae39c.jpg
     * AgentName : 测试代理
     * Discount : 6
     * UserId : bda06fce-e199-47a9-9a45-6ee3c4fae39c
     * Status : 1
     * CreateDate : 2018-08-11 15:12:53
     * Sort : 2
     * Price : 1
     * Stock : 9000
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
