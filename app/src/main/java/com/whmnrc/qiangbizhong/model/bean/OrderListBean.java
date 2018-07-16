package com.whmnrc.qiangbizhong.model.bean;

import java.util.List;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/11.
 * Order_CreateType 0 商城商品订单 1抢购订单 2抽奖订单 3医美服务订单
 */

public class OrderListBean {

    /**
     * Address_Provice : 350000
     * UserInfo_ID : bda06fce-e199-47a9-9a45-6ee3c4fae39c
     * Order_HasNewGoods : false
     * Order_IntegerMoney : 0
     * Order_PayNo : P5542798692965525753
     * StoreInfo :
     * Address_FullAddress : 福建省 福州市 鼓楼区 呵呵
     * Address_Name : 李哲
     * RushRecord : {"RushId":"49201f3e-7139-4f97-9b5b-678588baaadc","Status":1,"Order_Money":200,"Goods_Id":"fc68ced0-0d14-4291-a492-abb9fd63e9ca","GoodsPrice_Price":200,"RushEndTime":"2018-07-15 19:50:00","RushRecordId":"831328d1-0c70-4ad3-85df-195489fdeb84","IsEnd":2,"OrderId":"831328d1-0c70-4ad3-85df-195489fdeb84","CreateDate":"2018-07-15 19:45:17","Goods_PriceId":"bd87547a-609f-4771-8ef1-b2e57a90e7ca","GoodsPrice_VirtualPrice":300,"Goods_ImaPath":"http://www.eehsxui.cn/Resource/PhotoFile/060fbf62-e5d9-49ef-97ae-9602425c272c.jpg","RushStartTime":"2018-07-15 19:46:00","UserId":"bda06fce-e199-47a9-9a45-6ee3c4fae39c","RushNumber":1,"Bond":80}
     * Order_CreateTime : 2018-07-15 19:45:17
     * Order_Type : 0
     * Order_CreateType : 1
     * Order_RebateMoney : 80
     * Order_Number : 1
     * ORder_Freight : 0
     * Order_Seed : 84616
     * Order_Integer : 0
     * Order_ID : 831328d1-0c70-4ad3-85df-195489fdeb84
     * Order_Money : 200
     * Address_City : 350100
     * Address_Detail : 呵呵
     * Order_State : 6
     * Address_ID : 7d866de7-e627-45ec-970d-fec7fcecbd06
     * Order_StoreId : 43956E13-8DD6-476B-B6E4-02A73BE238C4
     * Address_Region : 350102
     * Order_IntegerMoneyRate : 0
     * Order_Remark :
     * Address_Mobile : 17688943972
     * Award :
     * UserInfo_HeadImg : http://192.168.0.157:8011/Resource/HeadImage/bda06fce-e199-47a9-9a45-6ee3c4fae39c.jpg
     * Order_PayType : -1
     * Order_RebateNumber : 1
     * Order_No : Q4909655821732671815
     * Detail : [{"Order_ID":"831328d1-0c70-4ad3-85df-195489fdeb84","OrderItem_ID":"916d81c8-c577-4c04-a83e-fb467346ae12","OrderItem_Discount":0,"SpecAttr_Price":200,"SpecAttr_Integer":0,"Product_ID":"fc68ced0-0d14-4291-a492-abb9fd63e9ca","SpecAttr_Name":"1盒","Product_Name":"如花似玉益生菌植物酵素片1盒","DotProduct_ID":"","OrderItem_Number":1,"OrderItem_Integer":0,"SpecAttr_ID":"bd87547a-609f-4771-8ef1-b2e57a90e7ca","Product_Price":200,"OrderItem_Money":200,"Spec_Name":"盒","Product_ImgPath":"http://www.eehsxui.cn/Resource/PhotoFile/060fbf62-e5d9-49ef-97ae-9602425c272c.jpg","OrderItem_Type":0,"Bond":80,"Spec_ID":"bd87547a-609f-4771-8ef1-b2e57a90e7ca"}]
     */

    private String Address_Provice;
    private String UserInfo_ID;
    private boolean Order_HasNewGoods;
    private int Order_IntegerMoney;
    private String Order_PayNo;
    private String StoreInfo;
    private String Address_FullAddress;
    private String Address_Name;
    private RushRecordBean RushRecord;
    private String Order_CreateTime;
    private int Order_Type;
    private int Order_CreateType;
    private int Order_RebateMoney;
    private int Order_Number;
    private int ORder_Freight;
    private int Order_Seed;
    private int Order_Integer;
    private String Order_ID;
    private int Order_Money;
    private String Address_City;
    private String Address_Detail;
    private int Order_State;
    private String Address_ID;
    private String Order_StoreId;
    private String Address_Region;
    private int Order_IntegerMoneyRate;
    private String Order_Remark;
    private String Address_Mobile;
    private String Award;
    private String UserInfo_HeadImg;
    private int Order_PayType;
    private int Order_RebateNumber;
    private String Order_No;
    private List<DetailBean> Detail;

    public String getAddress_Provice() {
        return Address_Provice;
    }

    public void setAddress_Provice(String Address_Provice) {
        this.Address_Provice = Address_Provice;
    }

    public String getUserInfo_ID() {
        return UserInfo_ID;
    }

    public void setUserInfo_ID(String UserInfo_ID) {
        this.UserInfo_ID = UserInfo_ID;
    }

    public boolean isOrder_HasNewGoods() {
        return Order_HasNewGoods;
    }

    public void setOrder_HasNewGoods(boolean Order_HasNewGoods) {
        this.Order_HasNewGoods = Order_HasNewGoods;
    }

    public int getOrder_IntegerMoney() {
        return Order_IntegerMoney;
    }

    public void setOrder_IntegerMoney(int Order_IntegerMoney) {
        this.Order_IntegerMoney = Order_IntegerMoney;
    }

    public String getOrder_PayNo() {
        return Order_PayNo;
    }

    public void setOrder_PayNo(String Order_PayNo) {
        this.Order_PayNo = Order_PayNo;
    }

    public String getStoreInfo() {
        return StoreInfo;
    }

    public void setStoreInfo(String StoreInfo) {
        this.StoreInfo = StoreInfo;
    }

    public String getAddress_FullAddress() {
        return Address_FullAddress;
    }

    public void setAddress_FullAddress(String Address_FullAddress) {
        this.Address_FullAddress = Address_FullAddress;
    }

    public String getAddress_Name() {
        return Address_Name;
    }

    public void setAddress_Name(String Address_Name) {
        this.Address_Name = Address_Name;
    }

    public RushRecordBean getRushRecord() {
        return RushRecord;
    }

    public void setRushRecord(RushRecordBean RushRecord) {
        this.RushRecord = RushRecord;
    }

    public String getOrder_CreateTime() {
        return Order_CreateTime;
    }

    public void setOrder_CreateTime(String Order_CreateTime) {
        this.Order_CreateTime = Order_CreateTime;
    }

    public int getOrder_Type() {
        return Order_Type;
    }

    public void setOrder_Type(int Order_Type) {
        this.Order_Type = Order_Type;
    }

    public int getOrder_CreateType() {
        return Order_CreateType;
    }

    public void setOrder_CreateType(int Order_CreateType) {
        this.Order_CreateType = Order_CreateType;
    }

    public int getOrder_RebateMoney() {
        return Order_RebateMoney;
    }

    public void setOrder_RebateMoney(int Order_RebateMoney) {
        this.Order_RebateMoney = Order_RebateMoney;
    }

    public int getOrder_Number() {
        return Order_Number;
    }

    public void setOrder_Number(int Order_Number) {
        this.Order_Number = Order_Number;
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

    public int getOrder_Integer() {
        return Order_Integer;
    }

    public void setOrder_Integer(int Order_Integer) {
        this.Order_Integer = Order_Integer;
    }

    public String getOrder_ID() {
        return Order_ID;
    }

    public void setOrder_ID(String Order_ID) {
        this.Order_ID = Order_ID;
    }

    public int getOrder_Money() {
        return Order_Money;
    }

    public void setOrder_Money(int Order_Money) {
        this.Order_Money = Order_Money;
    }

    public String getAddress_City() {
        return Address_City;
    }

    public void setAddress_City(String Address_City) {
        this.Address_City = Address_City;
    }

    public String getAddress_Detail() {
        return Address_Detail;
    }

    public void setAddress_Detail(String Address_Detail) {
        this.Address_Detail = Address_Detail;
    }

    public int getOrder_State() {
        return Order_State;
    }

    public void setOrder_State(int Order_State) {
        this.Order_State = Order_State;
    }

    public String getAddress_ID() {
        return Address_ID;
    }

    public void setAddress_ID(String Address_ID) {
        this.Address_ID = Address_ID;
    }

    public String getOrder_StoreId() {
        return Order_StoreId;
    }

    public void setOrder_StoreId(String Order_StoreId) {
        this.Order_StoreId = Order_StoreId;
    }

    public String getAddress_Region() {
        return Address_Region;
    }

    public void setAddress_Region(String Address_Region) {
        this.Address_Region = Address_Region;
    }

    public int getOrder_IntegerMoneyRate() {
        return Order_IntegerMoneyRate;
    }

    public void setOrder_IntegerMoneyRate(int Order_IntegerMoneyRate) {
        this.Order_IntegerMoneyRate = Order_IntegerMoneyRate;
    }

    public String getOrder_Remark() {
        return Order_Remark;
    }

    public void setOrder_Remark(String Order_Remark) {
        this.Order_Remark = Order_Remark;
    }

    public String getAddress_Mobile() {
        return Address_Mobile;
    }

    public void setAddress_Mobile(String Address_Mobile) {
        this.Address_Mobile = Address_Mobile;
    }

    public String getAward() {
        return Award;
    }

    public void setAward(String Award) {
        this.Award = Award;
    }

    public String getUserInfo_HeadImg() {
        return UserInfo_HeadImg;
    }

    public void setUserInfo_HeadImg(String UserInfo_HeadImg) {
        this.UserInfo_HeadImg = UserInfo_HeadImg;
    }

    public int getOrder_PayType() {
        return Order_PayType;
    }

    public void setOrder_PayType(int Order_PayType) {
        this.Order_PayType = Order_PayType;
    }

    public int getOrder_RebateNumber() {
        return Order_RebateNumber;
    }

    public void setOrder_RebateNumber(int Order_RebateNumber) {
        this.Order_RebateNumber = Order_RebateNumber;
    }

    public String getOrder_No() {
        return Order_No;
    }

    public void setOrder_No(String Order_No) {
        this.Order_No = Order_No;
    }

    public List<DetailBean> getDetail() {
        return Detail;
    }

    public void setDetail(List<DetailBean> Detail) {
        this.Detail = Detail;
    }

    public static class RushRecordBean {
        /**
         * RushId : 49201f3e-7139-4f97-9b5b-678588baaadc
         * Status : 1
         * Order_Money : 200
         * Goods_Id : fc68ced0-0d14-4291-a492-abb9fd63e9ca
         * GoodsPrice_Price : 200
         * RushEndTime : 2018-07-15 19:50:00
         * RushRecordId : 831328d1-0c70-4ad3-85df-195489fdeb84
         * IsEnd : 2
         * OrderId : 831328d1-0c70-4ad3-85df-195489fdeb84
         * CreateDate : 2018-07-15 19:45:17
         * Goods_PriceId : bd87547a-609f-4771-8ef1-b2e57a90e7ca
         * GoodsPrice_VirtualPrice : 300
         * Goods_ImaPath : http://www.eehsxui.cn/Resource/PhotoFile/060fbf62-e5d9-49ef-97ae-9602425c272c.jpg
         * RushStartTime : 2018-07-15 19:46:00
         * UserId : bda06fce-e199-47a9-9a45-6ee3c4fae39c
         * RushNumber : 1
         * Bond : 80
         */

        private String RushId;
        private int Status;
        private int Order_Money;
        private String Goods_Id;
        private int GoodsPrice_Price;
        private String RushEndTime;
        private String RushRecordId;
        private int IsEnd;
        private String OrderId;
        private String CreateDate;
        private String Goods_PriceId;
        private int GoodsPrice_VirtualPrice;
        private String Goods_ImaPath;
        private String RushStartTime;
        private String UserId;
        private int RushNumber;
        private int Bond;

        public String getRushId() {
            return RushId;
        }

        public void setRushId(String RushId) {
            this.RushId = RushId;
        }

        public int getStatus() {
            return Status;
        }

        public void setStatus(int Status) {
            this.Status = Status;
        }

        public int getOrder_Money() {
            return Order_Money;
        }

        public void setOrder_Money(int Order_Money) {
            this.Order_Money = Order_Money;
        }

        public String getGoods_Id() {
            return Goods_Id;
        }

        public void setGoods_Id(String Goods_Id) {
            this.Goods_Id = Goods_Id;
        }

        public int getGoodsPrice_Price() {
            return GoodsPrice_Price;
        }

        public void setGoodsPrice_Price(int GoodsPrice_Price) {
            this.GoodsPrice_Price = GoodsPrice_Price;
        }

        public String getRushEndTime() {
            return RushEndTime;
        }

        public void setRushEndTime(String RushEndTime) {
            this.RushEndTime = RushEndTime;
        }

        public String getRushRecordId() {
            return RushRecordId;
        }

        public void setRushRecordId(String RushRecordId) {
            this.RushRecordId = RushRecordId;
        }

        public int getIsEnd() {
            return IsEnd;
        }

        public void setIsEnd(int IsEnd) {
            this.IsEnd = IsEnd;
        }

        public String getOrderId() {
            return OrderId;
        }

        public void setOrderId(String OrderId) {
            this.OrderId = OrderId;
        }

        public String getCreateDate() {
            return CreateDate;
        }

        public void setCreateDate(String CreateDate) {
            this.CreateDate = CreateDate;
        }

        public String getGoods_PriceId() {
            return Goods_PriceId;
        }

        public void setGoods_PriceId(String Goods_PriceId) {
            this.Goods_PriceId = Goods_PriceId;
        }

        public int getGoodsPrice_VirtualPrice() {
            return GoodsPrice_VirtualPrice;
        }

        public void setGoodsPrice_VirtualPrice(int GoodsPrice_VirtualPrice) {
            this.GoodsPrice_VirtualPrice = GoodsPrice_VirtualPrice;
        }

        public String getGoods_ImaPath() {
            return Goods_ImaPath;
        }

        public void setGoods_ImaPath(String Goods_ImaPath) {
            this.Goods_ImaPath = Goods_ImaPath;
        }

        public String getRushStartTime() {
            return RushStartTime;
        }

        public void setRushStartTime(String RushStartTime) {
            this.RushStartTime = RushStartTime;
        }

        public String getUserId() {
            return UserId;
        }

        public void setUserId(String UserId) {
            this.UserId = UserId;
        }

        public int getRushNumber() {
            return RushNumber;
        }

        public void setRushNumber(int RushNumber) {
            this.RushNumber = RushNumber;
        }

        public int getBond() {
            return Bond;
        }

        public void setBond(int Bond) {
            this.Bond = Bond;
        }
    }

    public static class DetailBean {
        /**
         * Order_ID : 831328d1-0c70-4ad3-85df-195489fdeb84
         * OrderItem_ID : 916d81c8-c577-4c04-a83e-fb467346ae12
         * OrderItem_Discount : 0
         * SpecAttr_Price : 200
         * SpecAttr_Integer : 0
         * Product_ID : fc68ced0-0d14-4291-a492-abb9fd63e9ca
         * SpecAttr_Name : 1盒
         * Product_Name : 如花似玉益生菌植物酵素片1盒
         * DotProduct_ID :
         * OrderItem_Number : 1
         * OrderItem_Integer : 0
         * SpecAttr_ID : bd87547a-609f-4771-8ef1-b2e57a90e7ca
         * Product_Price : 200
         * OrderItem_Money : 200
         * Spec_Name : 盒
         * Product_ImgPath : http://www.eehsxui.cn/Resource/PhotoFile/060fbf62-e5d9-49ef-97ae-9602425c272c.jpg
         * OrderItem_Type : 0
         * Bond : 80
         * Spec_ID : bd87547a-609f-4771-8ef1-b2e57a90e7ca
         */

        private String Order_ID;
        private String OrderItem_ID;
        private int OrderItem_Discount;
        private int SpecAttr_Price;
        private int SpecAttr_Integer;
        private String Product_ID;
        private String SpecAttr_Name;
        private String Product_Name;
        private String DotProduct_ID;
        private int OrderItem_Number;
        private int OrderItem_Integer;
        private String SpecAttr_ID;
        private int Product_Price;
        private int OrderItem_Money;
        private String Spec_Name;
        private String Product_ImgPath;
        private int OrderItem_Type;
        private int Bond;
        private String Spec_ID;

        public String getOrder_ID() {
            return Order_ID;
        }

        public void setOrder_ID(String Order_ID) {
            this.Order_ID = Order_ID;
        }

        public String getOrderItem_ID() {
            return OrderItem_ID;
        }

        public void setOrderItem_ID(String OrderItem_ID) {
            this.OrderItem_ID = OrderItem_ID;
        }

        public int getOrderItem_Discount() {
            return OrderItem_Discount;
        }

        public void setOrderItem_Discount(int OrderItem_Discount) {
            this.OrderItem_Discount = OrderItem_Discount;
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

        public String getProduct_ID() {
            return Product_ID;
        }

        public void setProduct_ID(String Product_ID) {
            this.Product_ID = Product_ID;
        }

        public String getSpecAttr_Name() {
            return SpecAttr_Name;
        }

        public void setSpecAttr_Name(String SpecAttr_Name) {
            this.SpecAttr_Name = SpecAttr_Name;
        }

        public String getProduct_Name() {
            return Product_Name;
        }

        public void setProduct_Name(String Product_Name) {
            this.Product_Name = Product_Name;
        }

        public String getDotProduct_ID() {
            return DotProduct_ID;
        }

        public void setDotProduct_ID(String DotProduct_ID) {
            this.DotProduct_ID = DotProduct_ID;
        }

        public int getOrderItem_Number() {
            return OrderItem_Number;
        }

        public void setOrderItem_Number(int OrderItem_Number) {
            this.OrderItem_Number = OrderItem_Number;
        }

        public int getOrderItem_Integer() {
            return OrderItem_Integer;
        }

        public void setOrderItem_Integer(int OrderItem_Integer) {
            this.OrderItem_Integer = OrderItem_Integer;
        }

        public String getSpecAttr_ID() {
            return SpecAttr_ID;
        }

        public void setSpecAttr_ID(String SpecAttr_ID) {
            this.SpecAttr_ID = SpecAttr_ID;
        }

        public int getProduct_Price() {
            return Product_Price;
        }

        public void setProduct_Price(int Product_Price) {
            this.Product_Price = Product_Price;
        }

        public int getOrderItem_Money() {
            return OrderItem_Money;
        }

        public void setOrderItem_Money(int OrderItem_Money) {
            this.OrderItem_Money = OrderItem_Money;
        }

        public String getSpec_Name() {
            return Spec_Name;
        }

        public void setSpec_Name(String Spec_Name) {
            this.Spec_Name = Spec_Name;
        }

        public String getProduct_ImgPath() {
            return Product_ImgPath;
        }

        public void setProduct_ImgPath(String Product_ImgPath) {
            this.Product_ImgPath = Product_ImgPath;
        }

        public int getOrderItem_Type() {
            return OrderItem_Type;
        }

        public void setOrderItem_Type(int OrderItem_Type) {
            this.OrderItem_Type = OrderItem_Type;
        }

        public int getBond() {
            return Bond;
        }

        public void setBond(int Bond) {
            this.Bond = Bond;
        }

        public String getSpec_ID() {
            return Spec_ID;
        }

        public void setSpec_ID(String Spec_ID) {
            this.Spec_ID = Spec_ID;
        }
    }
}
