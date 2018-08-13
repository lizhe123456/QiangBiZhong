package com.whmnrc.qiangbizhong.model.parameter;

import java.util.List;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/8/13.
 */

public class YiMeiOrderParam {

    /**
     * AddressId : string
     * GoodsPriceList : [{"Key":"string","Value":0}]
     * RemarksList : [{"Key":"string","Value":"string"}]
     * UserId : string
     * IsAgentPay : 0
     * Phone : string
     * AgentPayUserId : string
     */

    private String AddressId;
    private String UserId;
    private int IsAgentPay;
    private String Phone;
    private String AgentPayUserId;
    private List<GoodsPriceListBean> GoodsPriceList;
    private List<RemarksListBean> RemarksList;

    public String getAddressId() {
        return AddressId;
    }

    public void setAddressId(String AddressId) {
        this.AddressId = AddressId;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String UserId) {
        this.UserId = UserId;
    }

    public int getIsAgentPay() {
        return IsAgentPay;
    }

    public void setIsAgentPay(int IsAgentPay) {
        this.IsAgentPay = IsAgentPay;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public String getAgentPayUserId() {
        return AgentPayUserId;
    }

    public void setAgentPayUserId(String AgentPayUserId) {
        this.AgentPayUserId = AgentPayUserId;
    }

    public List<GoodsPriceListBean> getGoodsPriceList() {
        return GoodsPriceList;
    }

    public void setGoodsPriceList(List<GoodsPriceListBean> GoodsPriceList) {
        this.GoodsPriceList = GoodsPriceList;
    }

    public List<RemarksListBean> getRemarksList() {
        return RemarksList;
    }

    public void setRemarksList(List<RemarksListBean> RemarksList) {
        this.RemarksList = RemarksList;
    }

    public static class GoodsPriceListBean {
        /**
         * Key : string
         * Value : 0
         */

        private String Key;
        private int Value;

        public GoodsPriceListBean(String key, int value) {
            Key = key;
            Value = value;
        }

        public String getKey() {
            return Key;
        }

        public void setKey(String Key) {
            this.Key = Key;
        }

        public int getValue() {
            return Value;
        }

        public void setValue(int Value) {
            this.Value = Value;
        }
    }

    public static class RemarksListBean {
        /**
         * Key : string
         * Value : string
         */

        private String Key;
        private String Value;

        public String getKey() {
            return Key;
        }

        public void setKey(String Key) {
            this.Key = Key;
        }

        public String getValue() {
            return Value;
        }

        public void setValue(String Value) {
            this.Value = Value;
        }
    }
}
