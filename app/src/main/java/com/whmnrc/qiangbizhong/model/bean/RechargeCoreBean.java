package com.whmnrc.qiangbizhong.model.bean;

import java.util.List;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/8/11.
 */

public class RechargeCoreBean {


    /**
     * AgentShopInfo : {"Id":"30a31acb-a1a6-49f1-b6bd-7fea2b1e8659","HeadImage":"/Resource/HeadImage/bda06fce-e199-47a9-9a45-6ee3c4fae39c.jpg","AgentName":"测试代理","Discount":6,"UserId":"bda06fce-e199-47a9-9a45-6ee3c4fae39c","Status":1,"CreateDate":"2018-08-11 15:12:53","Sort":2,"Price":1,"Stock":9000,"Sales":0}
     * Items : [{"Id":"5cd0808a-15ca-43fe-a531-f5f81abf4c78","TotalPrice":0.01,"OldPrice":120,"Number":120,"AgentShopId":"30a31acb-a1a6-49f1-b6bd-7fea2b1e8659"},{"Id":"fe3f038b-fe71-498b-a7e0-a6e6843b1189","TotalPrice":0.01,"OldPrice":10,"Number":120,"AgentShopId":"30a31acb-a1a6-49f1-b6bd-7fea2b1e8659"}]
     */

    private AgentShopInfoBean AgentShopInfo;
    private List<ItemsBean> Items;

    public AgentShopInfoBean getAgentShopInfo() {
        return AgentShopInfo;
    }

    public void setAgentShopInfo(AgentShopInfoBean AgentShopInfo) {
        this.AgentShopInfo = AgentShopInfo;
    }

    public List<ItemsBean> getItems() {
        return Items;
    }

    public void setItems(List<ItemsBean> Items) {
        this.Items = Items;
    }

    public static class AgentShopInfoBean {
        /**
         * Id : 30a31acb-a1a6-49f1-b6bd-7fea2b1e8659
         * HeadImage : /Resource/HeadImage/bda06fce-e199-47a9-9a45-6ee3c4fae39c.jpg
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

    public static class ItemsBean {
        /**
         * Id : 5cd0808a-15ca-43fe-a531-f5f81abf4c78
         * TotalPrice : 0.01
         * OldPrice : 120
         * Number : 120
         * AgentShopId : 30a31acb-a1a6-49f1-b6bd-7fea2b1e8659
         */

        private String Id;
        private double TotalPrice;
        private int OldPrice;
        private int Number;
        private String AgentShopId;
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

        public double getTotalPrice() {
            return TotalPrice;
        }

        public void setTotalPrice(double TotalPrice) {
            this.TotalPrice = TotalPrice;
        }

        public int getOldPrice() {
            return OldPrice;
        }

        public void setOldPrice(int OldPrice) {
            this.OldPrice = OldPrice;
        }

        public int getNumber() {
            return Number;
        }

        public void setNumber(int Number) {
            this.Number = Number;
        }

        public String getAgentShopId() {
            return AgentShopId;
        }

        public void setAgentShopId(String AgentShopId) {
            this.AgentShopId = AgentShopId;
        }
    }
}
