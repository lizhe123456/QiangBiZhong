package com.whmnrc.qiangbizhong.model.bean;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/8/14.
 */

public class GiveOrderDetailBean {


    /**
     * GiveDetail : {"GiveId":"4799bbb8-db81-4ac3-ad15-86281d7fc243","FromUserId":"bda06fce-e199-47a9-9a45-6ee3c4fae39c","GiveUserId":"8259dfa0-d4c6-4178-bdb1-0c5a2f0703e3","CreateDate":"2018-08-14 15:02:30","OrderId":"b718045d-3b00-42d5-a6c1-a4fd58340bb8","Context":"呵呵","GoodsId":"d4987999-4f8f-476e-8e60-eda6e1479680","Goods_ImaPath":"http://192.168.1.157:8011/Resource/PhotoFile/66cece9e-15b2-4262-84e4-5bf7b4574fb4.jpg","Goods_Name":"飞翼零式高达改","GiveUserHead":"http://192.168.1.157:8011/Resource/HeadImage/8259dfa0-d4c6-4178-bdb1-0c5a2f0703e3.jpg","GiveUserNick":"薪尽火传","FromGiveHead":"http://192.168.1.157:8011/Resource/HeadImage/bda06fce-e199-47a9-9a45-6ee3c4fae39c.jpg","FromGiveNick":"呵呵凉凉了","Order_State":1}
     * OrderInfo : {"Order_ID":"b718045d-3b00-42d5-a6c1-a4fd58340bb8","Order_No":"S5001546335730178830","UserInfo_ID":"8259dfa0-d4c6-4178-bdb1-0c5a2f0703e3","UserInfo_ParentID":null,"UserInfo_HeadImg":"/Resource/HeadImage/bda06fce-e199-47a9-9a45-6ee3c4fae39c.jpg","Order_PayNo":"P5053567240243518741","Order_CreateTime":"2018-08-14 15:01:57","Address_Name":"","Address_Mobile":"17688943972","Address_ID":"","Address_Provice":"","Address_City":"","Address_Region":"","Address_Detail":"","Address_FullAddress":"","Order_PayType":-1,"Order_State":1,"Order_Money":1999,"ORder_Freight":0,"Order_Seed":88095,"Order_Type":0,"OrderStartDate":null,"OrderEndDate":null,"Order_Integer":0,"Order_Remark":"","Order_IntegerMoney":0,"Order_IntegerMoneyRate":0,"Order_Number":1,"Order_WaybillCompany":null,"Order_WaybillNumber":null,"Order_DeliverGoodsUserInfoID":null,"Order_RebateMoney":1999,"Order_HasNewGoods":false,"Order_DeliverGoodsTime":null,"Order_RebateNumber":1,"UserInfo_Mobile":"13971121168","UserInfo_NickName":"薪尽火传","UserInfo_RealName":null,"Order_CreateType":3,"Order_StoreId":"076c5743-cc0d-4611-803c-cb173e6b219c","AgentPayUserId":"","StoreName":"Djdjdj","StoreAddress":"Djdjjdj","StorePhone":"13912345678","Order_RefundRemark":null}
     */

    private GiveDetailBean GiveDetail;
    private OrderInfoBean OrderInfo;

    public GiveDetailBean getGiveDetail() {
        return GiveDetail;
    }

    public void setGiveDetail(GiveDetailBean GiveDetail) {
        this.GiveDetail = GiveDetail;
    }

    public OrderInfoBean getOrderInfo() {
        return OrderInfo;
    }

    public void setOrderInfo(OrderInfoBean OrderInfo) {
        this.OrderInfo = OrderInfo;
    }

    public static class GiveDetailBean {
        /**
         * GiveId : 4799bbb8-db81-4ac3-ad15-86281d7fc243
         * FromUserId : bda06fce-e199-47a9-9a45-6ee3c4fae39c
         * GiveUserId : 8259dfa0-d4c6-4178-bdb1-0c5a2f0703e3
         * CreateDate : 2018-08-14 15:02:30
         * OrderId : b718045d-3b00-42d5-a6c1-a4fd58340bb8
         * Context : 呵呵
         * GoodsId : d4987999-4f8f-476e-8e60-eda6e1479680
         * Goods_ImaPath : http://192.168.1.157:8011/Resource/PhotoFile/66cece9e-15b2-4262-84e4-5bf7b4574fb4.jpg
         * Goods_Name : 飞翼零式高达改
         * GiveUserHead : http://192.168.1.157:8011/Resource/HeadImage/8259dfa0-d4c6-4178-bdb1-0c5a2f0703e3.jpg
         * GiveUserNick : 薪尽火传
         * FromGiveHead : http://192.168.1.157:8011/Resource/HeadImage/bda06fce-e199-47a9-9a45-6ee3c4fae39c.jpg
         * FromGiveNick : 呵呵凉凉了
         * Order_State : 1
         */

        private String GiveId;
        private String FromUserId;
        private String GiveUserId;
        private String CreateDate;
        private String OrderId;
        private String Context;
        private String GoodsId;
        private String Goods_ImaPath;
        private String Goods_Name;
        private String GiveUserHead;
        private String GiveUserNick;
        private String FromGiveHead;
        private String FromGiveNick;
        private int Order_State;

        public String getGiveId() {
            return GiveId;
        }

        public void setGiveId(String GiveId) {
            this.GiveId = GiveId;
        }

        public String getFromUserId() {
            return FromUserId;
        }

        public void setFromUserId(String FromUserId) {
            this.FromUserId = FromUserId;
        }

        public String getGiveUserId() {
            return GiveUserId;
        }

        public void setGiveUserId(String GiveUserId) {
            this.GiveUserId = GiveUserId;
        }

        public String getCreateDate() {
            return CreateDate;
        }

        public void setCreateDate(String CreateDate) {
            this.CreateDate = CreateDate;
        }

        public String getOrderId() {
            return OrderId;
        }

        public void setOrderId(String OrderId) {
            this.OrderId = OrderId;
        }

        public String getContext() {
            return Context;
        }

        public void setContext(String Context) {
            this.Context = Context;
        }

        public String getGoodsId() {
            return GoodsId;
        }

        public void setGoodsId(String GoodsId) {
            this.GoodsId = GoodsId;
        }

        public String getGoods_ImaPath() {
            return Goods_ImaPath;
        }

        public void setGoods_ImaPath(String Goods_ImaPath) {
            this.Goods_ImaPath = Goods_ImaPath;
        }

        public String getGoods_Name() {
            return Goods_Name;
        }

        public void setGoods_Name(String Goods_Name) {
            this.Goods_Name = Goods_Name;
        }

        public String getGiveUserHead() {
            return GiveUserHead;
        }

        public void setGiveUserHead(String GiveUserHead) {
            this.GiveUserHead = GiveUserHead;
        }

        public String getGiveUserNick() {
            return GiveUserNick;
        }

        public void setGiveUserNick(String GiveUserNick) {
            this.GiveUserNick = GiveUserNick;
        }

        public String getFromGiveHead() {
            return FromGiveHead;
        }

        public void setFromGiveHead(String FromGiveHead) {
            this.FromGiveHead = FromGiveHead;
        }

        public String getFromGiveNick() {
            return FromGiveNick;
        }

        public void setFromGiveNick(String FromGiveNick) {
            this.FromGiveNick = FromGiveNick;
        }

        public int getOrder_State() {
            return Order_State;
        }

        public void setOrder_State(int Order_State) {
            this.Order_State = Order_State;
        }
    }

    public static class OrderInfoBean {
        /**
         * Order_ID : b718045d-3b00-42d5-a6c1-a4fd58340bb8
         * Order_No : S5001546335730178830
         * UserInfo_ID : 8259dfa0-d4c6-4178-bdb1-0c5a2f0703e3
         * UserInfo_ParentID : null
         * UserInfo_HeadImg : /Resource/HeadImage/bda06fce-e199-47a9-9a45-6ee3c4fae39c.jpg
         * Order_PayNo : P5053567240243518741
         * Order_CreateTime : 2018-08-14 15:01:57
         * Address_Name :
         * Address_Mobile : 17688943972
         * Address_ID :
         * Address_Provice :
         * Address_City :
         * Address_Region :
         * Address_Detail :
         * Address_FullAddress :
         * Order_PayType : -1
         * Order_State : 1
         * Order_Money : 1999
         * ORder_Freight : 0
         * Order_Seed : 88095
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
         * Order_RebateMoney : 1999
         * Order_HasNewGoods : false
         * Order_DeliverGoodsTime : null
         * Order_RebateNumber : 1
         * UserInfo_Mobile : 13971121168
         * UserInfo_NickName : 薪尽火传
         * UserInfo_RealName : null
         * Order_CreateType : 3
         * Order_StoreId : 076c5743-cc0d-4611-803c-cb173e6b219c
         * AgentPayUserId :
         * StoreName : Djdjdj
         * StoreAddress : Djdjjdj
         * StorePhone : 13912345678
         * Order_RefundRemark : null
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
        private Object Order_WaybillNumber;
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
        private String AgentPayUserId;
        private String StoreName;
        private String StoreAddress;
        private String StorePhone;
        private Object Order_RefundRemark;

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

        public Object getOrder_WaybillNumber() {
            return Order_WaybillNumber;
        }

        public void setOrder_WaybillNumber(Object Order_WaybillNumber) {
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

        public String getAgentPayUserId() {
            return AgentPayUserId;
        }

        public void setAgentPayUserId(String AgentPayUserId) {
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

        public Object getOrder_RefundRemark() {
            return Order_RefundRemark;
        }

        public void setOrder_RefundRemark(Object Order_RefundRemark) {
            this.Order_RefundRemark = Order_RefundRemark;
        }
    }
}
