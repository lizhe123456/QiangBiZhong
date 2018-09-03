package com.whmnrc.qiangbizhong.model.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/11.
 * Order_CreateType 0 商城商品订单 1抢购订单 2抽奖订单 3医美服务订单
 */

public class OrderListBean {


    /**
     * Order_ID : d339d7f9-54c0-485e-946a-daf93c4cebb5
     * Order_No : Q5155050178623387197
     * UserInfo_ID : bda06fce-e199-47a9-9a45-6ee3c4fae39c
     * UserInfo_ParentID : null
     * UserInfo_HeadImg : /Resource/HeadImage/bda06fce-e199-47a9-9a45-6ee3c4fae39c.jpg
     * Order_PayNo : P4692156508943792296
     * Order_CreateTime : 2018-07-17 16:49:40
     * Address_Name : 李哲
     * Address_Mobile : 17688943972
     * Address_ID : 7d866de7-e627-45ec-970d-fec7fcecbd06
     * Address_Provice : 350000
     * Address_City : 350100
     * Address_Region : 350102
     * Address_Detail : 呵呵
     * Address_FullAddress : 福建省 福州市 鼓楼区 呵呵
     * Order_PayType : -1
     * Order_State : -1
     * Order_Money : 3000
     * ORder_Freight : 0
     * Order_Seed : 84674
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
     * Order_RebateMoney : 200
     * Order_RebateNumber : 1
     * Order_HasNewGoods : false
     * Order_DeliverGoodsTime : null
     * Order_CreateType : 2
     * Order_StoreId : 43956E13-8DD6-476B-B6E4-02A73BE238C4
     * AgentPayUserId : null
     * Detail : [{"OrderItem_ID":"6b11d9e2-acb5-4383-9eb6-21a01791a0ae","Product_ID":"bac3e3e2-80f3-4455-8216-fe9558b2f0e1","Product_Name":"法拉利豪车","Product_ImgPath":"http://testaml.whmnx.com/Resource/PhotoFile/2a908ea7-5a5f-4f3f-b6a7-ae7a17849e9e.png","Product_Price":3000,"OrderItem_Number":1,"OrderItem_Money":3000,"Order_ID":"d339d7f9-54c0-485e-946a-daf93c4cebb5","DotProduct_ID":"","Spec_ID":"fac3e3e2-80f3-4455-8216-fe9558b2f0e2","Spec_Name":"F430","SpecAttr_ID":"fac3e3e2-80f3-4455-8216-fe9558b2f0e2","SpecAttr_Name":"一辆","SpecAttr_Price":3000,"SpecAttr_Integer":0,"OrderItem_Integer":0,"OrderItem_Discount":0,"OrderItem_Type":0,"OrderItem_UseCode":null,"RebateConfig_ID":null,"Bond":200}]
     * RushRecord :
     * Award : {"AwardRecordId":"53039314-894e-47de-bd39-a65a66bd4d03","GoodsAwardId":"5750a589-426e-4205-ad87-acafd98375b3","AwardPeopleCount":91,"Goods_Name":"法拉利豪车","UserId":"bda06fce-e199-47a9-9a45-6ee3c4fae39c","OrderId":"d339d7f9-54c0-485e-946a-daf93c4cebb5","Goods_Id":"bac3e3e2-80f3-4455-8216-fe9558b2f0e1","Goods_PriceId":"fac3e3e2-80f3-4455-8216-fe9558b2f0e2","Status":0,"UserType":0,"UserHeadImage":"/Resource/HeadImage/bda06fce-e199-47a9-9a45-6ee3c4fae39c.jpg","AwardTime":"2018-07-18 14:50:00","Bond":200,"Price":4000000,"GoodsPrice_Price":3000,"GoodsPrice_VirtualPrice":6000000,"Product_ImgPath":"/Resource/PhotoFile/2a908ea7-5a5f-4f3f-b6a7-ae7a17849e9e.png","UserNick":"监控"}
     * StoreInfo :
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
    private int Order_RebateNumber;
    private boolean Order_HasNewGoods;
    private Object Order_DeliverGoodsTime;
    private int Order_CreateType;
    private String Order_StoreId;
    private Object AgentPayUserId;
    private RushRecordBean RushRecord;
    private AwardBean Award;
    private StoreInfo StoreInfo;
    private List<DetailBean> Detail;
    private boolean isLoging;

    public boolean isLoging() {
        return isLoging;
    }

    public void setLoging(boolean loging) {
        isLoging = loging;
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

    public int getOrder_RebateNumber() {
        return Order_RebateNumber;
    }

    public void setOrder_RebateNumber(int Order_RebateNumber) {
        this.Order_RebateNumber = Order_RebateNumber;
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

    public RushRecordBean getRushRecord() {
        return RushRecord;
    }

    public void setRushRecord(RushRecordBean RushRecord) {
        this.RushRecord = RushRecord;
    }

    public AwardBean getAward() {
        return Award;
    }

    public void setAward(AwardBean Award) {
        this.Award = Award;
    }

    public StoreInfo getStoreInfo() {
        return StoreInfo;
    }

    public void setStoreInfo(StoreInfo StoreInfo) {
        this.StoreInfo = StoreInfo;
    }

    public List<DetailBean> getDetail() {
        return Detail;
    }

    public void setDetail(List<DetailBean> Detail) {
        this.Detail = Detail;
    }

    public static class AwardBean {
        /**
         * AwardRecordId : 53039314-894e-47de-bd39-a65a66bd4d03
         * GoodsAwardId : 5750a589-426e-4205-ad87-acafd98375b3
         * AwardPeopleCount : 91
         * Goods_Name : 法拉利豪车
         * UserId : bda06fce-e199-47a9-9a45-6ee3c4fae39c
         * OrderId : d339d7f9-54c0-485e-946a-daf93c4cebb5
         * Goods_Id : bac3e3e2-80f3-4455-8216-fe9558b2f0e1
         * Goods_PriceId : fac3e3e2-80f3-4455-8216-fe9558b2f0e2
         * Status : 0
         * UserType : 0
         * UserHeadImage : /Resource/HeadImage/bda06fce-e199-47a9-9a45-6ee3c4fae39c.jpg
         * AwardTime : 2018-07-18 14:50:00
         * Bond : 200
         * Price : 4000000
         * GoodsPrice_Price : 3000
         * GoodsPrice_VirtualPrice : 6000000
         * Product_ImgPath : /Resource/PhotoFile/2a908ea7-5a5f-4f3f-b6a7-ae7a17849e9e.png
         * UserNick : 监控
         */

        private String AwardRecordId;
        private String GoodsAwardId;
        private int AwardPeopleCount;
        private String Goods_Name;
        private String UserId;
        private String OrderId;
        private String Goods_Id;
        private String Goods_PriceId;
        private int Status;
        private int UserType;
        private String UserHeadImage;
        private String AwardTime;
        private int Bond;
        private int Price;
        private double GoodsPrice_Price;
        private double GoodsPrice_VirtualPrice;
        private String Product_ImgPath;
        private String UserNick;

        public String getAwardRecordId() {
            return AwardRecordId;
        }

        public void setAwardRecordId(String AwardRecordId) {
            this.AwardRecordId = AwardRecordId;
        }

        public String getGoodsAwardId() {
            return GoodsAwardId;
        }

        public void setGoodsAwardId(String GoodsAwardId) {
            this.GoodsAwardId = GoodsAwardId;
        }

        public int getAwardPeopleCount() {
            return AwardPeopleCount;
        }

        public void setAwardPeopleCount(int AwardPeopleCount) {
            this.AwardPeopleCount = AwardPeopleCount;
        }

        public String getGoods_Name() {
            return Goods_Name;
        }

        public void setGoods_Name(String Goods_Name) {
            this.Goods_Name = Goods_Name;
        }

        public String getUserId() {
            return UserId;
        }

        public void setUserId(String UserId) {
            this.UserId = UserId;
        }

        public String getOrderId() {
            return OrderId;
        }

        public void setOrderId(String OrderId) {
            this.OrderId = OrderId;
        }

        public String getGoods_Id() {
            return Goods_Id;
        }

        public void setGoods_Id(String Goods_Id) {
            this.Goods_Id = Goods_Id;
        }

        public String getGoods_PriceId() {
            return Goods_PriceId;
        }

        public void setGoods_PriceId(String Goods_PriceId) {
            this.Goods_PriceId = Goods_PriceId;
        }

        public int getStatus() {
            return Status;
        }

        public void setStatus(int Status) {
            this.Status = Status;
        }

        public int getUserType() {
            return UserType;
        }

        public void setUserType(int UserType) {
            this.UserType = UserType;
        }

        public String getUserHeadImage() {
            return UserHeadImage;
        }

        public void setUserHeadImage(String UserHeadImage) {
            this.UserHeadImage = UserHeadImage;
        }

        public String getAwardTime() {
            return AwardTime;
        }

        public void setAwardTime(String AwardTime) {
            this.AwardTime = AwardTime;
        }

        public int getBond() {
            return Bond;
        }

        public void setBond(int Bond) {
            this.Bond = Bond;
        }

        public int getPrice() {
            return Price;
        }

        public void setPrice(int Price) {
            this.Price = Price;
        }

        public double getGoodsPrice_Price() {
            return GoodsPrice_Price;
        }

        public void setGoodsPrice_Price(double GoodsPrice_Price) {
            this.GoodsPrice_Price = GoodsPrice_Price;
        }

        public double getGoodsPrice_VirtualPrice() {
            return GoodsPrice_VirtualPrice;
        }

        public void setGoodsPrice_VirtualPrice(double GoodsPrice_VirtualPrice) {
            this.GoodsPrice_VirtualPrice = GoodsPrice_VirtualPrice;
        }

        public String getProduct_ImgPath() {
            return Product_ImgPath;
        }

        public void setProduct_ImgPath(String Product_ImgPath) {
            this.Product_ImgPath = Product_ImgPath;
        }

        public String getUserNick() {
            return UserNick;
        }

        public void setUserNick(String UserNick) {
            this.UserNick = UserNick;
        }
    }

    public static class DetailBean {
        /**
         * OrderItem_ID : 38ce597a-40d2-40b4-a281-9d3e485cc173
         * Product_ID : e3334ae0-7fac-41dc-ad78-b36a1734176a
         * Product_Name : 大米面膜10片装
         * Product_ImgPath : http://testaml.whmnx.com/Resource/PhotoFile/3bed4a52-6499-446a-b7ef-84f80c98117e.jpg
         * Product_Price : 0
         * OrderItem_Number : 2
         * OrderItem_Money : 300
         * Order_ID : 1d3a2112-405a-438d-880a-270cce53869f
         * DotProduct_ID :
         * Spec_ID : 681e0b82-e448-49ad-ba55-dd150810b982
         * Spec_Name : 一袋
         * SpecAttr_ID :
         * SpecAttr_Name : 7片
         * SpecAttr_Price : 150
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
        private double Product_Price;
        private int OrderItem_Number;
        private String Order_ID;
        private String DotProduct_ID;
        private String Spec_ID;
        private String Spec_Name;
        private String SpecAttr_ID;
        private String SpecAttr_Name;
        private double SpecAttr_Price;
        private int Bond;
        private String comment;
        private List<String> list = new ArrayList<>();
        private List<String> selectList;

        public List<String> getList() {
            if (list.size() == 0){
                list.add("");
            }
            return list;
        }

        public void setList(List<String> list) {
            this.list = list;
        }

        public void setSelectList(List<String> selectList) {
            if (selectList.size() < 3){
                selectList.add("");

            }
            this.selectList = selectList;
        }

        public List<String> getSelectList() {
            return selectList;
        }

        public String getComment() {
            return comment;
        }

        public void setComment(String comment) {
            this.comment = comment;
        }

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

        public double getProduct_Price() {
            return Product_Price;
        }

        public void setProduct_Price(double Product_Price) {
            this.Product_Price = Product_Price;
        }

        public int getOrderItem_Number() {
            return OrderItem_Number;
        }

        public void setOrderItem_Number(int OrderItem_Number) {
            this.OrderItem_Number = OrderItem_Number;
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

        public double getSpecAttr_Price() {
            return SpecAttr_Price;
        }

        public void setSpecAttr_Price(double SpecAttr_Price) {
            this.SpecAttr_Price = SpecAttr_Price;
        }

        public int getBond() {
            return Bond;
        }

        public void setBond(int Bond) {
            this.Bond = Bond;
        }
    }

    public class RushRecordBean {

        /**
         * RushRecordId : 64ff42b7-f704-4c7c-ab46-302a151ee1eb
         * RushId : 3a4f1291-9ad1-4659-92e7-c518c5b4f882
         * Goods_Id : f2cfb2f8-b6ec-41fc-bf6b-59c522e80fa7
         * Goods_PriceId : 0c12ba6a-b594-4e1c-8f1a-71f985163a76
         * UserId : bda06fce-e199-47a9-9a45-6ee3c4fae39c
         * Status : 0
         * CreateDate : 2018-07-17 14:24:57
         * OrderId : 64ff42b7-f704-4c7c-ab46-302a151ee1eb
         * Bond : 100
         * IsEnd : 2
         * RushNumber : 101
         * Order_Money : 6000
         * GoodsPrice_Price : 6000
         * GoodsPrice_VirtualPrice : 6890
         * RushEndTime : 2018-07-17 14:30:50
         * RushStartTime : 2018-07-17 14:25:41
         * Goods_ImaPath : /Resource/PhotoFile/4774dce3-9d30-4813-9b3b-b9f9b1913af5.jpg
         */

        private String RushRecordId;
        private String RushId;
        private String Goods_Id;
        private String Goods_PriceId;
        private String UserId;
        private int Status;
        private String CreateDate;
        private String OrderId;
        private int Bond;
        private int IsEnd;
        private int RushNumber;
        private int Order_Money;
        private double GoodsPrice_Price;
        private double GoodsPrice_VirtualPrice;
        private String RushEndTime;
        private String RushStartTime;
        private String Goods_ImaPath;

        public String getRushRecordId() {
            return RushRecordId;
        }

        public void setRushRecordId(String RushRecordId) {
            this.RushRecordId = RushRecordId;
        }

        public String getRushId() {
            return RushId;
        }

        public void setRushId(String RushId) {
            this.RushId = RushId;
        }

        public String getGoods_Id() {
            return Goods_Id;
        }

        public void setGoods_Id(String Goods_Id) {
            this.Goods_Id = Goods_Id;
        }

        public String getGoods_PriceId() {
            return Goods_PriceId;
        }

        public void setGoods_PriceId(String Goods_PriceId) {
            this.Goods_PriceId = Goods_PriceId;
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

        public String getOrderId() {
            return OrderId;
        }

        public void setOrderId(String OrderId) {
            this.OrderId = OrderId;
        }

        public int getBond() {
            return Bond;
        }

        public void setBond(int Bond) {
            this.Bond = Bond;
        }

        public int getIsEnd() {
            return IsEnd;
        }

        public void setIsEnd(int IsEnd) {
            this.IsEnd = IsEnd;
        }

        public int getRushNumber() {
            return RushNumber;
        }

        public void setRushNumber(int RushNumber) {
            this.RushNumber = RushNumber;
        }

        public int getOrder_Money() {
            return Order_Money;
        }

        public void setOrder_Money(int Order_Money) {
            this.Order_Money = Order_Money;
        }

        public double getGoodsPrice_Price() {
            return GoodsPrice_Price;
        }

        public void setGoodsPrice_Price(double GoodsPrice_Price) {
            this.GoodsPrice_Price = GoodsPrice_Price;
        }

        public double getGoodsPrice_VirtualPrice() {
            return GoodsPrice_VirtualPrice;
        }

        public void setGoodsPrice_VirtualPrice(double GoodsPrice_VirtualPrice) {
            this.GoodsPrice_VirtualPrice = GoodsPrice_VirtualPrice;
        }

        public String getRushEndTime() {
            return RushEndTime;
        }

        public void setRushEndTime(String RushEndTime) {
            this.RushEndTime = RushEndTime;
        }

        public String getRushStartTime() {
            return RushStartTime;
        }

        public void setRushStartTime(String RushStartTime) {
            this.RushStartTime = RushStartTime;
        }

        public String getGoods_ImaPath() {
            return Goods_ImaPath;
        }

        public void setGoods_ImaPath(String Goods_ImaPath) {
            this.Goods_ImaPath = Goods_ImaPath;
        }
    }

    public class StoreInfo{

        /**
         * Id : f9641e98-a561-46f9-8cb9-aa9c43daabb0
         * StoreName : 测试不要删除谢谢
         * StoreImage : null
         * LegalPerson : 程芳芳
         * IdentityCard : 420111199011162317
         * CompanyName : 阿尔法
         * OrganizationCode : 478008001
         * Area : 湖北省武汉市
         * Address : 湖北省武汉市洪山区珞喻路237号
         * IdentityCardImage1 : /Resource/PhotoFile/6719db2c-82f2-4d04-8a95-9c8a6744714c.png
         * IdentityCardImage2 : /Resource/PhotoFile/14d8098d-e039-41f5-961a-c02946a5ae17.png
         * LicenseImage : bbbbbbbbb
         * Phone : 15988985669
         * WeChartNum : wx108010
         * BankAccount : 6217 0028 6230 6560
         * BankName : 汉口银行
         * BankBranchName : 武汉市积玉桥支行
         * SettlementBankAccount : 6217 0028 6230 6560
         * SettlementBankName : 武汉市积玉桥支行
         * Explain : 1111111111111111最棒的
         * StoreHeadImage : /Resource/HeadImage/b94a0f91-0e89-4faf-91f0-3869c5f2394c.jpg
         * UserId : 394298d1-a8ec-438d-8e73-ffa306a97b01
         * Status : 1
         * CreateDate : 2018-07-28 09:36:39
         * Reson :
         * Latitude : 30.549420
         * Longitude : 114.265550
         */

        private String Id;
        private String StoreName;
        private Object StoreImage;
        private String LegalPerson;
        private String IdentityCard;
        private String CompanyName;
        private String OrganizationCode;
        private String Area;
        private String Address;
        private String IdentityCardImage1;
        private String IdentityCardImage2;
        private String LicenseImage;
        private String Phone;
        private String WeChartNum;
        private String BankAccount;
        private String BankName;
        private String BankBranchName;
        private String SettlementBankAccount;
        private String SettlementBankName;
        private String Explain;
        private String StoreHeadImage;
        private String UserId;
        private int Status;
        private String CreateDate;
        private String Reson;
        private String Latitude;
        private String Longitude;

        public String getId() {
            return Id;
        }

        public void setId(String Id) {
            this.Id = Id;
        }

        public String getStoreName() {
            return StoreName;
        }

        public void setStoreName(String StoreName) {
            this.StoreName = StoreName;
        }

        public Object getStoreImage() {
            return StoreImage;
        }

        public void setStoreImage(Object StoreImage) {
            this.StoreImage = StoreImage;
        }

        public String getLegalPerson() {
            return LegalPerson;
        }

        public void setLegalPerson(String LegalPerson) {
            this.LegalPerson = LegalPerson;
        }

        public String getIdentityCard() {
            return IdentityCard;
        }

        public void setIdentityCard(String IdentityCard) {
            this.IdentityCard = IdentityCard;
        }

        public String getCompanyName() {
            return CompanyName;
        }

        public void setCompanyName(String CompanyName) {
            this.CompanyName = CompanyName;
        }

        public String getOrganizationCode() {
            return OrganizationCode;
        }

        public void setOrganizationCode(String OrganizationCode) {
            this.OrganizationCode = OrganizationCode;
        }

        public String getArea() {
            return Area;
        }

        public void setArea(String Area) {
            this.Area = Area;
        }

        public String getAddress() {
            return Address;
        }

        public void setAddress(String Address) {
            this.Address = Address;
        }

        public String getIdentityCardImage1() {
            return IdentityCardImage1;
        }

        public void setIdentityCardImage1(String IdentityCardImage1) {
            this.IdentityCardImage1 = IdentityCardImage1;
        }

        public String getIdentityCardImage2() {
            return IdentityCardImage2;
        }

        public void setIdentityCardImage2(String IdentityCardImage2) {
            this.IdentityCardImage2 = IdentityCardImage2;
        }

        public String getLicenseImage() {
            return LicenseImage;
        }

        public void setLicenseImage(String LicenseImage) {
            this.LicenseImage = LicenseImage;
        }

        public String getPhone() {
            return Phone;
        }

        public void setPhone(String Phone) {
            this.Phone = Phone;
        }

        public String getWeChartNum() {
            return WeChartNum;
        }

        public void setWeChartNum(String WeChartNum) {
            this.WeChartNum = WeChartNum;
        }

        public String getBankAccount() {
            return BankAccount;
        }

        public void setBankAccount(String BankAccount) {
            this.BankAccount = BankAccount;
        }

        public String getBankName() {
            return BankName;
        }

        public void setBankName(String BankName) {
            this.BankName = BankName;
        }

        public String getBankBranchName() {
            return BankBranchName;
        }

        public void setBankBranchName(String BankBranchName) {
            this.BankBranchName = BankBranchName;
        }

        public String getSettlementBankAccount() {
            return SettlementBankAccount;
        }

        public void setSettlementBankAccount(String SettlementBankAccount) {
            this.SettlementBankAccount = SettlementBankAccount;
        }

        public String getSettlementBankName() {
            return SettlementBankName;
        }

        public void setSettlementBankName(String SettlementBankName) {
            this.SettlementBankName = SettlementBankName;
        }

        public String getExplain() {
            return Explain;
        }

        public void setExplain(String Explain) {
            this.Explain = Explain;
        }

        public String getStoreHeadImage() {
            return StoreHeadImage;
        }

        public void setStoreHeadImage(String StoreHeadImage) {
            this.StoreHeadImage = StoreHeadImage;
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

        public String getReson() {
            return Reson;
        }

        public void setReson(String Reson) {
            this.Reson = Reson;
        }

        public String getLatitude() {
            return Latitude;
        }

        public void setLatitude(String Latitude) {
            this.Latitude = Latitude;
        }

        public String getLongitude() {
            return Longitude;
        }

        public void setLongitude(String Longitude) {
            this.Longitude = Longitude;
        }
    }
}
