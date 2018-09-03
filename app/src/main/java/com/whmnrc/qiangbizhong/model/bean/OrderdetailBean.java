package com.whmnrc.qiangbizhong.model.bean;

import java.util.List;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/8/3.
 */

public class OrderdetailBean {


    /**
     * Order_ID : 1d3a2112-405a-438d-880a-270cce53869f
     * Order_No : S5227554199287838435
     * UserInfo_ID : a1fc93cc-1964-41e3-ac8f-3a5976a94842
     * UserInfo_ParentID : null
     * UserInfo_HeadImg : /Resource/HeadImage/a1fc93cc-1964-41e3-ac8f-3a5976a94842.jpg
     * Order_PayNo : P5607183283741864710
     * Order_CreateTime : 2018-08-06 13:57:10
     * Address_Name : 发个公告不不不
     * Address_Mobile : 15927297175
     * Address_ID : 4f443763-b545-480a-81b0-eca1ec0433d5
     * Address_Provice : 650000
     * Address_City : 650000
     * Address_Region : 650000
     * Address_Detail : 过一个月过一会
     * Address_FullAddress : 新疆维吾尔自治区 新疆维吾尔自治区 新疆维吾尔自治区 过一个月过一会
     * Order_PayType : -1
     * Order_State : 10
     * Order_Money : 360
     * ORder_Freight : 0
     * Order_Seed : 85337
     * Order_Type : 0
     * OrderStartDate : null
     * OrderEndDate : null
     * Order_Integer : 0
     * Order_Remark :
     * Order_IntegerMoney : 0
     * Order_IntegerMoneyRate : 0
     * Order_Number : 4
     * Order_WaybillCompany : ems快递
     * Order_WaybillNumber : 123456
     * Order_DeliverGoodsUserInfoID : null
     * Order_RebateMoney : 360
     * Order_HasNewGoods : false
     * Order_DeliverGoodsTime : 2018-08-06 13:58:51
     * Order_RebateNumber : 4
     * UserInfo_Mobile : 15927297175
     * UserInfo_NickName : 蜡笔小新
     * UserInfo_RealName : null
     * Order_CreateType : 0
     * Order_StoreId : f9641e98-a561-46f9-8cb9-aa9c43daabb0
     * AgentPayUserId : null
     * StoreName : 测试不要删除谢谢
     * StoreAddress : 湖北省武汉市洪山区珞喻路237号
     * StorePhone : 15988985669
     * Order_RefundRemark : null
     * Detail : [{"OrderItem_ID":"38ce597a-40d2-40b4-a281-9d3e485cc173","Product_ID":"e3334ae0-7fac-41dc-ad78-b36a1734176a","Product_Name":"大米面膜10片装","Product_ImgPath":"http://testaml.whmnx.com/Resource/PhotoFile/3bed4a52-6499-446a-b7ef-84f80c98117e.jpg","Product_Price":0,"OrderItem_Number":2,"OrderItem_Money":300,"Order_ID":"1d3a2112-405a-438d-880a-270cce53869f","DotProduct_ID":"","Spec_ID":"681e0b82-e448-49ad-ba55-dd150810b982","Spec_Name":"一袋","SpecAttr_ID":"","SpecAttr_Name":"7片","SpecAttr_Price":150,"SpecAttr_Integer":0,"OrderItem_Integer":0,"OrderItem_Discount":0,"OrderItem_Type":0,"OrderItem_UseCode":null,"RebateConfig_ID":null,"Bond":0},{"OrderItem_ID":"4600b2a1-1536-423d-976d-72185ac67a7e","Product_ID":"59f341d6-dc3e-4466-83c8-fc96d102fb90","Product_Name":"海洋陶瓷餐具","Product_ImgPath":"http://testaml.whmnx.com/Resource/PhotoFile/d2cb0265-48d0-4ba9-ab28-07373d206dfa.jpg","Product_Price":0,"OrderItem_Number":2,"OrderItem_Money":60,"Order_ID":"1d3a2112-405a-438d-880a-270cce53869f","DotProduct_ID":"","Spec_ID":"c5864951-d388-4f6e-9f9d-863109360186","Spec_Name":"白鱼碗","SpecAttr_ID":"","SpecAttr_Name":"140ml","SpecAttr_Price":30,"SpecAttr_Integer":0,"OrderItem_Integer":0,"OrderItem_Discount":0,"OrderItem_Type":0,"OrderItem_UseCode":null,"RebateConfig_ID":null,"Bond":0}]
     */

    private String Order_ID;
    private String Order_No;
    private String UserInfo_ID;
    private String UserInfo_HeadImg;
    private String Order_PayNo;
    private String Order_CreateTime;
    private String Address_Name;
    private String Address_Mobile;
    private String Address_ID;
    private String Address_Provice;
    private String Address_City;
    private String Address_Region;
    private String Address_Detail;
    private String Address_FullAddress;
    private int Order_State;
    private String Order_WaybillCompany;
    private String Order_WaybillNumber;
    private double Order_RebateMoney;
    private boolean Order_HasNewGoods;
    private String Order_DeliverGoodsTime;
    private String UserInfo_Mobile;
    private String UserInfo_NickName;
    private int Order_CreateType;
    private String Order_StoreId;
    private String StoreName;
    private String StoreAddress;
    private String StorePhone;
    private Object Order_RefundRemark;
    private List<OrderListBean.DetailBean> Detail;

    public void setOrder_RebateMoney(double order_RebateMoney) {
        Order_RebateMoney = order_RebateMoney;
    }

    public Object getOrder_RefundRemark() {
        return Order_RefundRemark;
    }

    public void setOrder_RefundRemark(Object order_RefundRemark) {
        Order_RefundRemark = order_RefundRemark;
    }

    public String getOrder_ID() {
        return Order_ID;
    }

    public void setOrder_ID(String Order_ID) {
        this.Order_ID = Order_ID;
    }

    public String getOrder_No() {
        return Order_No;
    }

    public void setOrder_No(String Order_No) {
        this.Order_No = Order_No;
    }

    public String getUserInfo_ID() {
        return UserInfo_ID;
    }

    public void setUserInfo_ID(String UserInfo_ID) {
        this.UserInfo_ID = UserInfo_ID;
    }

    public String getUserInfo_HeadImg() {
        return UserInfo_HeadImg;
    }

    public void setUserInfo_HeadImg(String UserInfo_HeadImg) {
        this.UserInfo_HeadImg = UserInfo_HeadImg;
    }



    public int getOrder_State() {
        return Order_State;
    }

    public void setOrder_State(int order_State) {
        Order_State = order_State;
    }

    public String getOrder_PayNo() {
        return Order_PayNo;
    }

    public void setOrder_PayNo(String Order_PayNo) {
        this.Order_PayNo = Order_PayNo;
    }

    public String getOrder_CreateTime() {
        return Order_CreateTime;
    }

    public void setOrder_CreateTime(String Order_CreateTime) {
        this.Order_CreateTime = Order_CreateTime;
    }

    public String getAddress_Name() {
        return Address_Name;
    }

    public void setAddress_Name(String Address_Name) {
        this.Address_Name = Address_Name;
    }

    public String getAddress_Mobile() {
        return Address_Mobile;
    }

    public void setAddress_Mobile(String Address_Mobile) {
        this.Address_Mobile = Address_Mobile;
    }

    public String getAddress_ID() {
        return Address_ID;
    }

    public void setAddress_ID(String Address_ID) {
        this.Address_ID = Address_ID;
    }

    public String getAddress_Provice() {
        return Address_Provice;
    }

    public void setAddress_Provice(String Address_Provice) {
        this.Address_Provice = Address_Provice;
    }

    public String getAddress_City() {
        return Address_City;
    }

    public void setAddress_City(String Address_City) {
        this.Address_City = Address_City;
    }

    public String getAddress_Region() {
        return Address_Region;
    }

    public void setAddress_Region(String Address_Region) {
        this.Address_Region = Address_Region;
    }

    public String getAddress_Detail() {
        return Address_Detail;
    }

    public void setAddress_Detail(String Address_Detail) {
        this.Address_Detail = Address_Detail;
    }

    public String getAddress_FullAddress() {
        return Address_FullAddress;
    }

    public void setAddress_FullAddress(String Address_FullAddress) {
        this.Address_FullAddress = Address_FullAddress;
    }

    public String getOrder_WaybillCompany() {
        return Order_WaybillCompany;
    }

    public void setOrder_WaybillCompany(String Order_WaybillCompany) {
        this.Order_WaybillCompany = Order_WaybillCompany;
    }

    public String getOrder_WaybillNumber() {
        return Order_WaybillNumber;
    }

    public void setOrder_WaybillNumber(String Order_WaybillNumber) {
        this.Order_WaybillNumber = Order_WaybillNumber;
    }

    public double getOrder_RebateMoney() {
        return Order_RebateMoney;
    }

    public void setOrder_RebateMoney(int Order_RebateMoney) {
        this.Order_RebateMoney = Order_RebateMoney;
    }

    public boolean isOrder_HasNewGoods() {
        return Order_HasNewGoods;
    }

    public void setOrder_HasNewGoods(boolean Order_HasNewGoods) {
        this.Order_HasNewGoods = Order_HasNewGoods;
    }

    public String getOrder_DeliverGoodsTime() {
        return Order_DeliverGoodsTime;
    }

    public void setOrder_DeliverGoodsTime(String Order_DeliverGoodsTime) {
        this.Order_DeliverGoodsTime = Order_DeliverGoodsTime;
    }

    public String getUserInfo_Mobile() {
        return UserInfo_Mobile;
    }

    public void setUserInfo_Mobile(String UserInfo_Mobile) {
        this.UserInfo_Mobile = UserInfo_Mobile;
    }

    public String getUserInfo_NickName() {
        return UserInfo_NickName;
    }

    public void setUserInfo_NickName(String UserInfo_NickName) {
        this.UserInfo_NickName = UserInfo_NickName;
    }

    public int getOrder_CreateType() {
        return Order_CreateType;
    }

    public void setOrder_CreateType(int Order_CreateType) {
        this.Order_CreateType = Order_CreateType;
    }

    public String getOrder_StoreId() {
        return Order_StoreId;
    }

    public void setOrder_StoreId(String Order_StoreId) {
        this.Order_StoreId = Order_StoreId;
    }

    public String getStoreName() {
        return StoreName;
    }

    public void setStoreName(String StoreName) {
        this.StoreName = StoreName;
    }

    public String getStoreAddress() {
        return StoreAddress;
    }

    public void setStoreAddress(String StoreAddress) {
        this.StoreAddress = StoreAddress;
    }

    public String getStorePhone() {
        return StorePhone;
    }

    public void setStorePhone(String StorePhone) {
        this.StorePhone = StorePhone;
    }

    public List<OrderListBean.DetailBean> getDetail() {
        return Detail;
    }

    public void setDetail(List<OrderListBean.DetailBean> Detail) {
        this.Detail = Detail;
    }

}
