package com.whmnrc.qiangbizhong.model.bean;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/21.
 */

public class CouponBean {

    /**
     * Id : a77bf6ef-8b0e-452c-b25c-92178c7a3e8a
     * Name : 免预约金抵用券
     * CouponValue : -1
     * Condition_value : -1
     * Condition_desc : 仅限于抢购、抽奖活动 免预约金
     * StartDate : 2018-08-09 17:19:08
     * EndDate : 2018-09-08 17:19:08
     * Sort : 1
     * UserId : 514c01ba-9900-4067-a0ae-11939c2bed70
     * Type : 0
     */

    private String Id;
    private String Name;
    private int CouponValue;
    private int Condition_value;
    private String Condition_desc;
    private String StartDate;
    private String EndDate;
    private int Sort;
    private String UserId;
    private int Type;

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getCouponValue() {
        return CouponValue;
    }

    public void setCouponValue(int CouponValue) {
        this.CouponValue = CouponValue;
    }

    public int getCondition_value() {
        return Condition_value;
    }

    public void setCondition_value(int Condition_value) {
        this.Condition_value = Condition_value;
    }

    public String getCondition_desc() {
        return Condition_desc;
    }

    public void setCondition_desc(String Condition_desc) {
        this.Condition_desc = Condition_desc;
    }

    public String getStartDate() {
        return StartDate;
    }

    public void setStartDate(String StartDate) {
        this.StartDate = StartDate;
    }

    public String getEndDate() {
        return EndDate;
    }

    public void setEndDate(String EndDate) {
        this.EndDate = EndDate;
    }

    public int getSort() {
        return Sort;
    }

    public void setSort(int Sort) {
        this.Sort = Sort;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String UserId) {
        this.UserId = UserId;
    }

    public int getType() {
        return Type;
    }

    public void setType(int Type) {
        this.Type = Type;
    }
}
