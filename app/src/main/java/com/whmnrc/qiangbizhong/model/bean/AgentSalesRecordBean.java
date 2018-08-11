package com.whmnrc.qiangbizhong.model.bean;

import java.util.List;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/8/11.
 */

public class AgentSalesRecordBean {


    /**
     * RecordList : [{"Id":"72591dd9-626f-4ac9-af95-d8dcd1c23791","RechargeType":0,"Money":0.01,"ExchangeNumber":120,"CreateDate":"2018-08-11 15:37:34","AgentUserId":"bda06fce-e199-47a9-9a45-6ee3c4fae39c","AgentId":"30a31acb-a1a6-49f1-b6bd-7fea2b1e8659","UserId":"bda06fce-e199-47a9-9a45-6ee3c4fae39c","Status":0,"RecordOrderId":"G5124024653144227087","Number":1,"AgentShopDiscountId":"5cd0808a-15ca-43fe-a531-f5f81abf4c78","PayType":0,"UserInfo_NickName":"呵呵凉凉了","UserInfo_Mobile":"17688943972","AgentName":"测试代理"},{"Id":"bb691efa-b34d-417e-863c-eefdaebaa262","RechargeType":0,"Money":0,"ExchangeNumber":0,"CreateDate":"2018-08-11 15:37:29","AgentUserId":"bda06fce-e199-47a9-9a45-6ee3c4fae39c","AgentId":"30a31acb-a1a6-49f1-b6bd-7fea2b1e8659","UserId":"bda06fce-e199-47a9-9a45-6ee3c4fae39c","Status":0,"RecordOrderId":"G5169899929697787373","Number":0,"AgentShopDiscountId":"5cd0808a-15ca-43fe-a531-f5f81abf4c78","PayType":0,"UserInfo_NickName":"呵呵凉凉了","UserInfo_Mobile":"17688943972","AgentName":"测试代理"},{"Id":"9b97000f-bf31-46e9-a579-e9376f507a6b","RechargeType":0,"Money":0,"ExchangeNumber":0,"CreateDate":"2018-08-11 15:35:38","AgentUserId":"bda06fce-e199-47a9-9a45-6ee3c4fae39c","AgentId":"30a31acb-a1a6-49f1-b6bd-7fea2b1e8659","UserId":"bda06fce-e199-47a9-9a45-6ee3c4fae39c","Status":0,"RecordOrderId":"G5133044214389057247","Number":0,"AgentShopDiscountId":"5cd0808a-15ca-43fe-a531-f5f81abf4c78","PayType":0,"UserInfo_NickName":"呵呵凉凉了","UserInfo_Mobile":"17688943972","AgentName":"测试代理"},{"Id":"3684894f-935b-4b28-9dfe-d184729ebaf2","RechargeType":0,"Money":0,"ExchangeNumber":0,"CreateDate":"2018-08-11 15:35:06","AgentUserId":"bda06fce-e199-47a9-9a45-6ee3c4fae39c","AgentId":"30a31acb-a1a6-49f1-b6bd-7fea2b1e8659","UserId":"bda06fce-e199-47a9-9a45-6ee3c4fae39c","Status":0,"RecordOrderId":"G4871045304054217053","Number":0,"AgentShopDiscountId":"5cd0808a-15ca-43fe-a531-f5f81abf4c78","PayType":0,"UserInfo_NickName":"呵呵凉凉了","UserInfo_Mobile":"17688943972","AgentName":"测试代理"},{"Id":"1c91f5a6-7b4a-4305-94f0-23dc797269af","RechargeType":0,"Money":0,"ExchangeNumber":0,"CreateDate":"2018-08-11 15:35:02","AgentUserId":"bda06fce-e199-47a9-9a45-6ee3c4fae39c","AgentId":"30a31acb-a1a6-49f1-b6bd-7fea2b1e8659","UserId":"bda06fce-e199-47a9-9a45-6ee3c4fae39c","Status":0,"RecordOrderId":"G4621838363247968230","Number":0,"AgentShopDiscountId":"5cd0808a-15ca-43fe-a531-f5f81abf4c78","PayType":0,"UserInfo_NickName":"呵呵凉凉了","UserInfo_Mobile":"17688943972","AgentName":"测试代理"},{"Id":"9952e3c5-192a-46ef-b99f-b5e9d391eddc","RechargeType":0,"Money":0.01,"ExchangeNumber":120,"CreateDate":"2018-08-11 15:34:40","AgentUserId":"bda06fce-e199-47a9-9a45-6ee3c4fae39c","AgentId":"30a31acb-a1a6-49f1-b6bd-7fea2b1e8659","UserId":"bda06fce-e199-47a9-9a45-6ee3c4fae39c","Status":0,"RecordOrderId":"G5722571523028149531","Number":1,"AgentShopDiscountId":"5cd0808a-15ca-43fe-a531-f5f81abf4c78","PayType":0,"UserInfo_NickName":"呵呵凉凉了","UserInfo_Mobile":"17688943972","AgentName":"测试代理"}]
     * ShopInfo : {"Id":"30a31acb-a1a6-49f1-b6bd-7fea2b1e8659","HeadImage":"http://192.168.1.157:8011/Resource/HeadImage/bda06fce-e199-47a9-9a45-6ee3c4fae39c.jpg","AgentName":"测试代理","Discount":6,"UserId":"bda06fce-e199-47a9-9a45-6ee3c4fae39c","Status":1,"CreateDate":"2018-08-11 15:12:53","Sort":2,"Price":1,"Stock":8760,"Sales":240}
     * SumMoney : 0
     * Count : 0
     */

    private ShopInfoBean ShopInfo;
    private int SumMoney;
    private int Count;
    private List<RecordListBean> RecordList;

    public ShopInfoBean getShopInfo() {
        return ShopInfo;
    }

    public void setShopInfo(ShopInfoBean ShopInfo) {
        this.ShopInfo = ShopInfo;
    }

    public int getSumMoney() {
        return SumMoney;
    }

    public void setSumMoney(int SumMoney) {
        this.SumMoney = SumMoney;
    }

    public int getCount() {
        return Count;
    }

    public void setCount(int Count) {
        this.Count = Count;
    }

    public List<RecordListBean> getRecordList() {
        return RecordList;
    }

    public void setRecordList(List<RecordListBean> RecordList) {
        this.RecordList = RecordList;
    }

    public static class ShopInfoBean {
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
         * Stock : 8760
         * Sales : 240
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

    public static class RecordListBean {
        /**
         * Id : 72591dd9-626f-4ac9-af95-d8dcd1c23791
         * RechargeType : 0
         * Money : 0.01
         * ExchangeNumber : 120
         * CreateDate : 2018-08-11 15:37:34
         * AgentUserId : bda06fce-e199-47a9-9a45-6ee3c4fae39c
         * AgentId : 30a31acb-a1a6-49f1-b6bd-7fea2b1e8659
         * UserId : bda06fce-e199-47a9-9a45-6ee3c4fae39c
         * Status : 0
         * RecordOrderId : G5124024653144227087
         * Number : 1
         * AgentShopDiscountId : 5cd0808a-15ca-43fe-a531-f5f81abf4c78
         * PayType : 0
         * UserInfo_NickName : 呵呵凉凉了
         * UserInfo_Mobile : 17688943972
         * AgentName : 测试代理
         */

        private String Id;
        private int RechargeType;
        private double Money;
        private int ExchangeNumber;
        private String CreateDate;
        private String AgentUserId;
        private String AgentId;
        private String UserId;
        private int Status;
        private String RecordOrderId;
        private int Number;
        private String AgentShopDiscountId;
        private int PayType;
        private String UserInfo_NickName;
        private String UserInfo_Mobile;
        private String AgentName;

        public String getId() {
            return Id;
        }

        public void setId(String Id) {
            this.Id = Id;
        }

        public int getRechargeType() {
            return RechargeType;
        }

        public void setRechargeType(int RechargeType) {
            this.RechargeType = RechargeType;
        }

        public double getMoney() {
            return Money;
        }

        public void setMoney(double Money) {
            this.Money = Money;
        }

        public int getExchangeNumber() {
            return ExchangeNumber;
        }

        public void setExchangeNumber(int ExchangeNumber) {
            this.ExchangeNumber = ExchangeNumber;
        }

        public String getCreateDate() {
            return CreateDate;
        }

        public void setCreateDate(String CreateDate) {
            this.CreateDate = CreateDate;
        }

        public String getAgentUserId() {
            return AgentUserId;
        }

        public void setAgentUserId(String AgentUserId) {
            this.AgentUserId = AgentUserId;
        }

        public String getAgentId() {
            return AgentId;
        }

        public void setAgentId(String AgentId) {
            this.AgentId = AgentId;
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

        public String getRecordOrderId() {
            return RecordOrderId;
        }

        public void setRecordOrderId(String RecordOrderId) {
            this.RecordOrderId = RecordOrderId;
        }

        public int getNumber() {
            return Number;
        }

        public void setNumber(int Number) {
            this.Number = Number;
        }

        public String getAgentShopDiscountId() {
            return AgentShopDiscountId;
        }

        public void setAgentShopDiscountId(String AgentShopDiscountId) {
            this.AgentShopDiscountId = AgentShopDiscountId;
        }

        public int getPayType() {
            return PayType;
        }

        public void setPayType(int PayType) {
            this.PayType = PayType;
        }

        public String getUserInfo_NickName() {
            return UserInfo_NickName;
        }

        public void setUserInfo_NickName(String UserInfo_NickName) {
            this.UserInfo_NickName = UserInfo_NickName;
        }

        public String getUserInfo_Mobile() {
            return UserInfo_Mobile;
        }

        public void setUserInfo_Mobile(String UserInfo_Mobile) {
            this.UserInfo_Mobile = UserInfo_Mobile;
        }

        public String getAgentName() {
            return AgentName;
        }

        public void setAgentName(String AgentName) {
            this.AgentName = AgentName;
        }
    }
}
