package com.whmnrc.qiangbizhong.model.bean;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/19.
 */

public class RechargeRrecordBean {


    /**
     * Id : eede49d6-2d3c-475a-9b4f-63391d59eba4
     * RechargeType : 1
     * Money : 0.1
     * ExchangeNumber : 10
     * CreateDate : 2018-07-19 11:01:01
     * AgentUserId : null
     * AgentId : null
     * UserId : 964fbbd9-b242-48c1-b456-c26070047518
     * Status : 1
     * RecordOrderId : G5415699889442055376
     * Number : 1
     * AgentShopDiscountId : null
     * PayType : 2
     */

    private String Id;
    private int RechargeType;
    private double Money;
    private int ExchangeNumber;
    private String CreateDate;
    private Object AgentUserId;
    private Object AgentId;
    private String UserId;
    private int Status;
    private String RecordOrderId;
    private int Number;
    private Object AgentShopDiscountId;
    private int PayType;

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

    public Object getAgentUserId() {
        return AgentUserId;
    }

    public void setAgentUserId(Object AgentUserId) {
        this.AgentUserId = AgentUserId;
    }

    public Object getAgentId() {
        return AgentId;
    }

    public void setAgentId(Object AgentId) {
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

    public Object getAgentShopDiscountId() {
        return AgentShopDiscountId;
    }

    public void setAgentShopDiscountId(Object AgentShopDiscountId) {
        this.AgentShopDiscountId = AgentShopDiscountId;
    }

    public int getPayType() {
        return PayType;
    }

    public void setPayType(int PayType) {
        this.PayType = PayType;
    }
}
