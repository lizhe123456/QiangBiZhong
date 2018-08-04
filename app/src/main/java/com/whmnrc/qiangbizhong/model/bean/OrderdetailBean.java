package com.whmnrc.qiangbizhong.model.bean;

import java.util.List;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/8/3.
 */

public class OrderdetailBean {


    /**
     * Order_ID : d9596c8a-9045-43d2-a4b7-2740379f8d9c
     * Order_No : S4623607880905890072
     * UserInfo_ID : bda06fce-e199-47a9-9a45-6ee3c4fae39c
     * UserInfo_ParentID : null
     * UserInfo_HeadImg : /Resource/HeadImage/bda06fce-e199-47a9-9a45-6ee3c4fae39c.jpg
     * Order_PayNo : P5010999730971267971
     * Order_CreateTime : 2018-08-03 09:18:00
     * Address_Name : 拉拉
     * Address_Mobile : 15927297175
     * Address_ID : 71cf77c0-2615-4ce8-be39-50faeb4b17a7
     * Address_Provice : 110000
     * Address_City : 110000
     * Address_Region : 110101
     * Address_Detail : hdhdjdjdk
     * Address_FullAddress : 北京 北京 东城区 hdhdjdjdk
     * Order_PayType : -1
     * Order_State : 1
     * Order_Money : 1260
     * ORder_Freight : 0
     * Order_Seed : 86082
     * Order_Type : 0
     * OrderStartDate : null
     * OrderEndDate : null
     * Order_Integer : 0
     * Order_Remark :
     * Order_IntegerMoney : 0
     * Order_IntegerMoneyRate : 0
     * Order_Number : 1
     * Order_WaybillCompany : null
     * Order_WaybillNumber : null
     * Order_DeliverGoodsUserInfoID : null
     * Order_RebateMoney : 1260
     * Order_HasNewGoods : false
     * Order_DeliverGoodsTime : null
     * Order_RebateNumber : 1
     * UserInfo_Mobile : 17688943972
     * UserInfo_NickName : 呵呵凉凉了
     * UserInfo_RealName : null
     * Order_CreateType : 0
     * Order_StoreId : f9641e98-a561-46f9-8cb9-aa9c43daabb0
     * AgentPayUserId : null
     * StoreName : 测试不要删除谢谢
     * StoreAddress : 湖北省武汉市洪山区珞喻路237号
     * StorePhone : 15988985669
     * Detail : [{"OrderItem_ID":"ad91055f-9fc3-441b-8030-bf85857d4015","Product_ID":"5b575864-8732-4184-b18c-c3c043b41b4d","Product_Name":"PINKO女包","Product_ImgPath":"http://192.168.1.157:8011/Resource/PhotoFile/75c9bbc9-e9eb-4c83-abd5-2ab739ad9417.jpg","Product_Price":0,"OrderItem_Number":1,"OrderItem_Money":1260,"Order_ID":"d9596c8a-9045-43d2-a4b7-2740379f8d9c","DotProduct_ID":"","Spec_ID":"20bb9865-6b95-48a4-ae8d-51680d0276fd","Spec_Name":"21cm*11cm*7cm","SpecAttr_ID":"","SpecAttr_Name":"白色","SpecAttr_Price":1260,"SpecAttr_Integer":0,"OrderItem_Integer":0,"OrderItem_Discount":0,"OrderItem_Type":0,"OrderItem_UseCode":null,"RebateConfig_ID":null,"Bond":0}]
     */

    private String Order_ID;
    private String Order_No;
    private String UserInfo_ID;
    private Object UserInfo_ParentID;
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
    private int Order_PayType;
    private int Order_State;
    private int Order_Money;
    private int ORder_Freight;
    private int Order_Seed;
    private int Order_Type;
    private Object OrderStartDate;
    private Object OrderEndDate;
    private int Order_Integer;
    private String Order_Remark;
    private int Order_IntegerMoney;
    private int Order_IntegerMoneyRate;
    private int Order_Number;
    private Object Order_WaybillCompany;
    private String Order_WaybillNumber;
    private Object Order_DeliverGoodsUserInfoID;
    private int Order_RebateMoney;
    private boolean Order_HasNewGoods;
    private Object Order_DeliverGoodsTime;
    private int Order_RebateNumber;
    private String UserInfo_Mobile;
    private String UserInfo_NickName;
    private Object UserInfo_RealName;
    private int Order_CreateType;
    private String Order_StoreId;
    private Object AgentPayUserId;
    private String StoreName;
    private String StoreAddress;
    private String StorePhone;
    private List<OrderListBean.DetailBean> Detail;

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

    public Object getUserInfo_ParentID() {
        return UserInfo_ParentID;
    }

    public void setUserInfo_ParentID(Object UserInfo_ParentID) {
        this.UserInfo_ParentID = UserInfo_ParentID;
    }

    public String getUserInfo_HeadImg() {
        return UserInfo_HeadImg;
    }

    public void setUserInfo_HeadImg(String UserInfo_HeadImg) {
        this.UserInfo_HeadImg = UserInfo_HeadImg;
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

    public int getOrder_PayType() {
        return Order_PayType;
    }

    public void setOrder_PayType(int Order_PayType) {
        this.Order_PayType = Order_PayType;
    }

    public int getOrder_State() {
        return Order_State;
    }

    public void setOrder_State(int Order_State) {
        this.Order_State = Order_State;
    }

    public int getOrder_Money() {
        return Order_Money;
    }

    public void setOrder_Money(int Order_Money) {
        this.Order_Money = Order_Money;
    }

    public int getORder_Freight() {
        return ORder_Freight;
    }

    public void setORder_Freight(int ORder_Freight) {
        this.ORder_Freight = ORder_Freight;
    }

    public int getOrder_Seed() {
        return Order_Seed;
    }

    public void setOrder_Seed(int Order_Seed) {
        this.Order_Seed = Order_Seed;
    }

    public int getOrder_Type() {
        return Order_Type;
    }

    public void setOrder_Type(int Order_Type) {
        this.Order_Type = Order_Type;
    }

    public Object getOrderStartDate() {
        return OrderStartDate;
    }

    public void setOrderStartDate(Object OrderStartDate) {
        this.OrderStartDate = OrderStartDate;
    }

    public Object getOrderEndDate() {
        return OrderEndDate;
    }

    public void setOrderEndDate(Object OrderEndDate) {
        this.OrderEndDate = OrderEndDate;
    }

    public int getOrder_Integer() {
        return Order_Integer;
    }

    public void setOrder_Integer(int Order_Integer) {
        this.Order_Integer = Order_Integer;
    }

    public String getOrder_Remark() {
        return Order_Remark;
    }

    public void setOrder_Remark(String Order_Remark) {
        this.Order_Remark = Order_Remark;
    }

    public int getOrder_IntegerMoney() {
        return Order_IntegerMoney;
    }

    public void setOrder_IntegerMoney(int Order_IntegerMoney) {
        this.Order_IntegerMoney = Order_IntegerMoney;
    }

    public int getOrder_IntegerMoneyRate() {
        return Order_IntegerMoneyRate;
    }

    public void setOrder_IntegerMoneyRate(int Order_IntegerMoneyRate) {
        this.Order_IntegerMoneyRate = Order_IntegerMoneyRate;
    }

    public int getOrder_Number() {
        return Order_Number;
    }

    public void setOrder_Number(int Order_Number) {
        this.Order_Number = Order_Number;
    }

    public Object getOrder_WaybillCompany() {
        return Order_WaybillCompany;
    }

    public void setOrder_WaybillCompany(Object Order_WaybillCompany) {
        this.Order_WaybillCompany = Order_WaybillCompany;
    }

    public String getOrder_WaybillNumber() {
        return Order_WaybillNumber;
    }

    public void setOrder_WaybillNumber(String Order_WaybillNumber) {
        this.Order_WaybillNumber = Order_WaybillNumber;
    }

    public Object getOrder_DeliverGoodsUserInfoID() {
        return Order_DeliverGoodsUserInfoID;
    }

    public void setOrder_DeliverGoodsUserInfoID(Object Order_DeliverGoodsUserInfoID) {
        this.Order_DeliverGoodsUserInfoID = Order_DeliverGoodsUserInfoID;
    }

    public int getOrder_RebateMoney() {
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

    public Object getOrder_DeliverGoodsTime() {
        return Order_DeliverGoodsTime;
    }

    public void setOrder_DeliverGoodsTime(Object Order_DeliverGoodsTime) {
        this.Order_DeliverGoodsTime = Order_DeliverGoodsTime;
    }

    public int getOrder_RebateNumber() {
        return Order_RebateNumber;
    }

    public void setOrder_RebateNumber(int Order_RebateNumber) {
        this.Order_RebateNumber = Order_RebateNumber;
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

    public Object getUserInfo_RealName() {
        return UserInfo_RealName;
    }

    public void setUserInfo_RealName(Object UserInfo_RealName) {
        this.UserInfo_RealName = UserInfo_RealName;
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

    public Object getAgentPayUserId() {
        return AgentPayUserId;
    }

    public void setAgentPayUserId(Object AgentPayUserId) {
        this.AgentPayUserId = AgentPayUserId;
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

    public static class DetailBean {
        /**
         * OrderItem_ID : ad91055f-9fc3-441b-8030-bf85857d4015
         * Product_ID : 5b575864-8732-4184-b18c-c3c043b41b4d
         * Product_Name : PINKO女包
         * Product_ImgPath : http://192.168.1.157:8011/Resource/PhotoFile/75c9bbc9-e9eb-4c83-abd5-2ab739ad9417.jpg
         * Product_Price : 0
         * OrderItem_Number : 1
         * OrderItem_Money : 1260
         * Order_ID : d9596c8a-9045-43d2-a4b7-2740379f8d9c
         * DotProduct_ID :
         * Spec_ID : 20bb9865-6b95-48a4-ae8d-51680d0276fd
         * Spec_Name : 21cm*11cm*7cm
         * SpecAttr_ID :
         * SpecAttr_Name : 白色
         * SpecAttr_Price : 1260
         * SpecAttr_Integer : 0
         * OrderItem_Integer : 0
         * OrderItem_Discount : 0
         * OrderItem_Type : 0
         * OrderItem_UseCode : null
         * RebateConfig_ID : null
         * Bond : 0
         */

        private String OrderItem_ID;
        private String Product_ID;
        private String Product_Name;
        private String Product_ImgPath;
        private int Product_Price;
        private int OrderItem_Number;
        private int OrderItem_Money;
        private String Order_ID;
        private String DotProduct_ID;
        private String Spec_ID;
        private String Spec_Name;
        private String SpecAttr_ID;
        private String SpecAttr_Name;
        private int SpecAttr_Price;
        private int SpecAttr_Integer;
        private int OrderItem_Integer;
        private int OrderItem_Discount;
        private int OrderItem_Type;
        private Object OrderItem_UseCode;
        private Object RebateConfig_ID;
        private int Bond;

        public String getOrderItem_ID() {
            return OrderItem_ID;
        }

        public void setOrderItem_ID(String OrderItem_ID) {
            this.OrderItem_ID = OrderItem_ID;
        }

        public String getProduct_ID() {
            return Product_ID;
        }

        public void setProduct_ID(String Product_ID) {
            this.Product_ID = Product_ID;
        }

        public String getProduct_Name() {
            return Product_Name;
        }

        public void setProduct_Name(String Product_Name) {
            this.Product_Name = Product_Name;
        }

        public String getProduct_ImgPath() {
            return Product_ImgPath;
        }

        public void setProduct_ImgPath(String Product_ImgPath) {
            this.Product_ImgPath = Product_ImgPath;
        }

        public int getProduct_Price() {
            return Product_Price;
        }

        public void setProduct_Price(int Product_Price) {
            this.Product_Price = Product_Price;
        }

        public int getOrderItem_Number() {
            return OrderItem_Number;
        }

        public void setOrderItem_Number(int OrderItem_Number) {
            this.OrderItem_Number = OrderItem_Number;
        }

        public int getOrderItem_Money() {
            return OrderItem_Money;
        }

        public void setOrderItem_Money(int OrderItem_Money) {
            this.OrderItem_Money = OrderItem_Money;
        }

        public String getOrder_ID() {
            return Order_ID;
        }

        public void setOrder_ID(String Order_ID) {
            this.Order_ID = Order_ID;
        }

        public String getDotProduct_ID() {
            return DotProduct_ID;
        }

        public void setDotProduct_ID(String DotProduct_ID) {
            this.DotProduct_ID = DotProduct_ID;
        }

        public String getSpec_ID() {
            return Spec_ID;
        }

        public void setSpec_ID(String Spec_ID) {
            this.Spec_ID = Spec_ID;
        }

        public String getSpec_Name() {
            return Spec_Name;
        }

        public void setSpec_Name(String Spec_Name) {
            this.Spec_Name = Spec_Name;
        }

        public String getSpecAttr_ID() {
            return SpecAttr_ID;
        }

        public void setSpecAttr_ID(String SpecAttr_ID) {
            this.SpecAttr_ID = SpecAttr_ID;
        }

        public String getSpecAttr_Name() {
            return SpecAttr_Name;
        }

        public void setSpecAttr_Name(String SpecAttr_Name) {
            this.SpecAttr_Name = SpecAttr_Name;
        }

        public int getSpecAttr_Price() {
            return SpecAttr_Price;
        }

        public void setSpecAttr_Price(int SpecAttr_Price) {
            this.SpecAttr_Price = SpecAttr_Price;
        }

        public int getSpecAttr_Integer() {
            return SpecAttr_Integer;
        }

        public void setSpecAttr_Integer(int SpecAttr_Integer) {
            this.SpecAttr_Integer = SpecAttr_Integer;
        }

        public int getOrderItem_Integer() {
            return OrderItem_Integer;
        }

        public void setOrderItem_Integer(int OrderItem_Integer) {
            this.OrderItem_Integer = OrderItem_Integer;
        }

        public int getOrderItem_Discount() {
            return OrderItem_Discount;
        }

        public void setOrderItem_Discount(int OrderItem_Discount) {
            this.OrderItem_Discount = OrderItem_Discount;
        }

        public int getOrderItem_Type() {
            return OrderItem_Type;
        }

        public void setOrderItem_Type(int OrderItem_Type) {
            this.OrderItem_Type = OrderItem_Type;
        }

        public Object getOrderItem_UseCode() {
            return OrderItem_UseCode;
        }

        public void setOrderItem_UseCode(Object OrderItem_UseCode) {
            this.OrderItem_UseCode = OrderItem_UseCode;
        }

        public Object getRebateConfig_ID() {
            return RebateConfig_ID;
        }

        public void setRebateConfig_ID(Object RebateConfig_ID) {
            this.RebateConfig_ID = RebateConfig_ID;
        }

        public int getBond() {
            return Bond;
        }

        public void setBond(int Bond) {
            this.Bond = Bond;
        }
    }
}
