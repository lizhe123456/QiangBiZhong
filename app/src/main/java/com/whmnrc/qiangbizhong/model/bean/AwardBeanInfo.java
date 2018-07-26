package com.whmnrc.qiangbizhong.model.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/16.
 */

public class AwardBeanInfo implements Parcelable {


    /**
     * AwardGoodsInfo : {"Goods_ID":"bac3e3e2-80f3-4455-8216-fe9558b2f0e1","Goods_ShopType":2,"GoodsPrice_ID":"fac3e3e2-80f3-4455-8216-fe9558b2f0e2","AwardId":"5750a589-426e-4205-ad87-acafd98375b3","Goods_Name":"法拉利豪车","Goods_ImaPath":"http://testaml.whmnx.com/Resource/PhotoFile/2a908ea7-5a5f-4f3f-b6a7-ae7a17849e9e.png","Goods_Content":"<p>dwqwqeqwe<\/p>","Goods_Parameter":null,"Goods_IsOn":true,"Goods_IsBuy":true,"GoodsPrice_SpecName":"F430","GoodsPrice_AttrName":"一辆","GoodsPrice_Price":3000,"GoodsPrice_VirtualPrice":6000000,"GoodsPrice_Stock":1,"AwardPeopleCount":91,"NeedCount":100,"Bond":200,"Goods_Describe":"法拉利F430","IsEnd":0,"AwardTime":"2018-07-18 14:50:00","CreateDate":"2018-07-10 05:00:00"}
     * AwardGoodsBanner : []
     * Record : {"AwardRecordId":"53039314-894e-47de-bd39-a65a66bd4d03","GoodsAwardId":"5750a589-426e-4205-ad87-acafd98375b3","AwardPeopleCount":91,"Goods_Name":"法拉利豪车","UserId":"bda06fce-e199-47a9-9a45-6ee3c4fae39c","OrderId":"d339d7f9-54c0-485e-946a-daf93c4cebb5","Goods_Id":"bac3e3e2-80f3-4455-8216-fe9558b2f0e1","Goods_PriceId":"fac3e3e2-80f3-4455-8216-fe9558b2f0e2","Status":0,"UserType":0,"UserHeadImage":"/Resource/HeadImage/bda06fce-e199-47a9-9a45-6ee3c4fae39c.jpg","AwardTime":"2018-07-18 14:50:00","Bond":200,"Price":4000000,"GoodsPrice_Price":3000,"GoodsPrice_VirtualPrice":6000000,"Product_ImgPath":"/Resource/PhotoFile/2a908ea7-5a5f-4f3f-b6a7-ae7a17849e9e.png","UserNick":"监控"}
     * Participate : 1
     */

    private AwardGoodsInfoBean AwardGoodsInfo;
//    private Object Record;
    private int Participate;
    private List<AwardGoodsBanner> AwardGoodsBanner;
    private List<UserInfoBean> UsersRecord;

    public List<UserInfoBean> getUsersRecord() {
        return UsersRecord;
    }

    public void setUsersRecord(List<UserInfoBean> usersRecord) {
        UsersRecord = usersRecord;
    }

    protected AwardBeanInfo(Parcel in) {
        Participate = in.readInt();
    }

    public static final Creator<AwardBeanInfo> CREATOR = new Creator<AwardBeanInfo>() {
        @Override
        public AwardBeanInfo createFromParcel(Parcel in) {
            return new AwardBeanInfo(in);
        }

        @Override
        public AwardBeanInfo[] newArray(int size) {
            return new AwardBeanInfo[size];
        }
    };

    public AwardGoodsInfoBean getAwardGoodsInfo() {
        return AwardGoodsInfo;
    }

    public void setAwardGoodsInfo(AwardGoodsInfoBean AwardGoodsInfo) {
        this.AwardGoodsInfo = AwardGoodsInfo;
    }

//    public Object getRecord() {
//        return Record;
//    }
//
//    public void setRecord(Object Record) {
//        this.Record = Record;
//    }

    public int getParticipate() {
        return Participate;
    }

    public void setParticipate(int Participate) {
        this.Participate = Participate;
    }

    public List<AwardGoodsBanner> getAwardGoodsBanner() {
        return AwardGoodsBanner;
    }

    public void setAwardGoodsBanner(List<AwardGoodsBanner> AwardGoodsBanner) {
        this.AwardGoodsBanner = AwardGoodsBanner;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(Participate);
    }

    public static class AwardGoodsInfoBean implements Parcelable{
        /**
         * Goods_ID : bac3e3e2-80f3-4455-8216-fe9558b2f0e1
         * Goods_ShopType : 2
         * GoodsPrice_ID : fac3e3e2-80f3-4455-8216-fe9558b2f0e2
         * AwardId : 5750a589-426e-4205-ad87-acafd98375b3
         * Goods_Name : 法拉利豪车
         * Goods_ImaPath : http://testaml.whmnx.com/Resource/PhotoFile/2a908ea7-5a5f-4f3f-b6a7-ae7a17849e9e.png
         * Goods_Content : <p>dwqwqeqwe</p>
         * Goods_Parameter : null
         * Goods_IsOn : true
         * Goods_IsBuy : true
         * GoodsPrice_SpecName : F430
         * GoodsPrice_AttrName : 一辆
         * GoodsPrice_Price : 3000
         * GoodsPrice_VirtualPrice : 6000000
         * GoodsPrice_Stock : 1
         * AwardPeopleCount : 91
         * NeedCount : 100
         * Bond : 200
         * Goods_Describe : 法拉利F430
         * IsEnd : 0
         * AwardTime : 2018-07-18 14:50:00
         * CreateDate : 2018-07-10 05:00:00
         */

        private String Goods_ID;
        private int Goods_ShopType;
        private String GoodsPrice_ID;
        private String AwardId;
        private String Goods_Name;
        private String Goods_ImaPath;
        private String Goods_Content;
        private Object Goods_Parameter;
        private boolean Goods_IsOn;
        private boolean Goods_IsBuy;
        private String GoodsPrice_SpecName;
        private String GoodsPrice_AttrName;
        private int GoodsPrice_Price;
        private int GoodsPrice_VirtualPrice;
        private int GoodsPrice_Stock;
        private int AwardPeopleCount;
        private int NeedCount;
        private int Bond;
        private String Goods_Describe;
        private int IsEnd;
        private String AwardTime;
        private String CreateDate;

        protected AwardGoodsInfoBean(Parcel in) {
            Goods_ID = in.readString();
            Goods_ShopType = in.readInt();
            GoodsPrice_ID = in.readString();
            AwardId = in.readString();
            Goods_Name = in.readString();
            Goods_ImaPath = in.readString();
            Goods_Content = in.readString();
            Goods_IsOn = in.readByte() != 0;
            Goods_IsBuy = in.readByte() != 0;
            GoodsPrice_SpecName = in.readString();
            GoodsPrice_AttrName = in.readString();
            GoodsPrice_Price = in.readInt();
            GoodsPrice_VirtualPrice = in.readInt();
            GoodsPrice_Stock = in.readInt();
            AwardPeopleCount = in.readInt();
            NeedCount = in.readInt();
            Bond = in.readInt();
            Goods_Describe = in.readString();
            IsEnd = in.readInt();
            AwardTime = in.readString();
            CreateDate = in.readString();
        }

        public static final Creator<AwardGoodsInfoBean> CREATOR = new Creator<AwardGoodsInfoBean>() {
            @Override
            public AwardGoodsInfoBean createFromParcel(Parcel in) {
                return new AwardGoodsInfoBean(in);
            }

            @Override
            public AwardGoodsInfoBean[] newArray(int size) {
                return new AwardGoodsInfoBean[size];
            }
        };

        public String getGoods_ID() {
            return Goods_ID;
        }

        public void setGoods_ID(String Goods_ID) {
            this.Goods_ID = Goods_ID;
        }

        public int getGoods_ShopType() {
            return Goods_ShopType;
        }

        public void setGoods_ShopType(int Goods_ShopType) {
            this.Goods_ShopType = Goods_ShopType;
        }

        public String getGoodsPrice_ID() {
            return GoodsPrice_ID;
        }

        public void setGoodsPrice_ID(String GoodsPrice_ID) {
            this.GoodsPrice_ID = GoodsPrice_ID;
        }

        public String getAwardId() {
            return AwardId;
        }

        public void setAwardId(String AwardId) {
            this.AwardId = AwardId;
        }

        public String getGoods_Name() {
            return Goods_Name;
        }

        public void setGoods_Name(String Goods_Name) {
            this.Goods_Name = Goods_Name;
        }

        public String getGoods_ImaPath() {
            return Goods_ImaPath;
        }

        public void setGoods_ImaPath(String Goods_ImaPath) {
            this.Goods_ImaPath = Goods_ImaPath;
        }

        public String getGoods_Content() {
            return Goods_Content;
        }

        public void setGoods_Content(String Goods_Content) {
            this.Goods_Content = Goods_Content;
        }

        public Object getGoods_Parameter() {
            return Goods_Parameter;
        }

        public void setGoods_Parameter(Object Goods_Parameter) {
            this.Goods_Parameter = Goods_Parameter;
        }

        public boolean isGoods_IsOn() {
            return Goods_IsOn;
        }

        public void setGoods_IsOn(boolean Goods_IsOn) {
            this.Goods_IsOn = Goods_IsOn;
        }

        public boolean isGoods_IsBuy() {
            return Goods_IsBuy;
        }

        public void setGoods_IsBuy(boolean Goods_IsBuy) {
            this.Goods_IsBuy = Goods_IsBuy;
        }

        public String getGoodsPrice_SpecName() {
            return GoodsPrice_SpecName;
        }

        public void setGoodsPrice_SpecName(String GoodsPrice_SpecName) {
            this.GoodsPrice_SpecName = GoodsPrice_SpecName;
        }

        public String getGoodsPrice_AttrName() {
            return GoodsPrice_AttrName;
        }

        public void setGoodsPrice_AttrName(String GoodsPrice_AttrName) {
            this.GoodsPrice_AttrName = GoodsPrice_AttrName;
        }

        public int getGoodsPrice_Price() {
            return GoodsPrice_Price;
        }

        public void setGoodsPrice_Price(int GoodsPrice_Price) {
            this.GoodsPrice_Price = GoodsPrice_Price;
        }

        public int getGoodsPrice_VirtualPrice() {
            return GoodsPrice_VirtualPrice;
        }

        public void setGoodsPrice_VirtualPrice(int GoodsPrice_VirtualPrice) {
            this.GoodsPrice_VirtualPrice = GoodsPrice_VirtualPrice;
        }

        public int getGoodsPrice_Stock() {
            return GoodsPrice_Stock;
        }

        public void setGoodsPrice_Stock(int GoodsPrice_Stock) {
            this.GoodsPrice_Stock = GoodsPrice_Stock;
        }

        public int getAwardPeopleCount() {
            return AwardPeopleCount;
        }

        public void setAwardPeopleCount(int AwardPeopleCount) {
            this.AwardPeopleCount = AwardPeopleCount;
        }

        public int getNeedCount() {
            return NeedCount;
        }

        public void setNeedCount(int NeedCount) {
            this.NeedCount = NeedCount;
        }

        public int getBond() {
            return Bond;
        }

        public void setBond(int Bond) {
            this.Bond = Bond;
        }

        public String getGoods_Describe() {
            return Goods_Describe;
        }

        public void setGoods_Describe(String Goods_Describe) {
            this.Goods_Describe = Goods_Describe;
        }

        public int getIsEnd() {
            return IsEnd;
        }

        public void setIsEnd(int IsEnd) {
            this.IsEnd = IsEnd;
        }

        public String getAwardTime() {
            return AwardTime;
        }

        public void setAwardTime(String AwardTime) {
            this.AwardTime = AwardTime;
        }

        public String getCreateDate() {
            return CreateDate;
        }

        public void setCreateDate(String CreateDate) {
            this.CreateDate = CreateDate;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(Goods_ID);
            dest.writeInt(Goods_ShopType);
            dest.writeString(GoodsPrice_ID);
            dest.writeString(AwardId);
            dest.writeString(Goods_Name);
            dest.writeString(Goods_ImaPath);
            dest.writeString(Goods_Content);
            dest.writeByte((byte) (Goods_IsOn ? 1 : 0));
            dest.writeByte((byte) (Goods_IsBuy ? 1 : 0));
            dest.writeString(GoodsPrice_SpecName);
            dest.writeString(GoodsPrice_AttrName);
            dest.writeInt(GoodsPrice_Price);
            dest.writeInt(GoodsPrice_VirtualPrice);
            dest.writeInt(GoodsPrice_Stock);
            dest.writeInt(AwardPeopleCount);
            dest.writeInt(NeedCount);
            dest.writeInt(Bond);
            dest.writeString(Goods_Describe);
            dest.writeInt(IsEnd);
            dest.writeString(AwardTime);
            dest.writeString(CreateDate);
        }
    }

    public static class AwardGoodsBanner{

        /**
         * Img_Path : http://testaml.whmnx.com/Resource/PhotoFile/67f54310-844a-41c4-93db-2323c56a892a.jpg
         * Object_ID : 65506fe7-06b3-4cc2-995a-b2ce3c8a6b7f
         * Img_Type : 0
         * Img_ID : 1b3a0731-ba46-4283-80a9-4460f433382d
         * Img_Sort : 1
         */

        private String Img_Path;
        private String Object_ID;
        private int Img_Type;
        private String Img_ID;
        private int Img_Sort;

        public String getImg_Path() {
            return Img_Path;
        }

        public void setImg_Path(String Img_Path) {
            this.Img_Path = Img_Path;
        }

        public String getObject_ID() {
            return Object_ID;
        }

        public void setObject_ID(String Object_ID) {
            this.Object_ID = Object_ID;
        }

        public int getImg_Type() {
            return Img_Type;
        }

        public void setImg_Type(int Img_Type) {
            this.Img_Type = Img_Type;
        }

        public String getImg_ID() {
            return Img_ID;
        }

        public void setImg_ID(String Img_ID) {
            this.Img_ID = Img_ID;
        }

        public int getImg_Sort() {
            return Img_Sort;
        }

        public void setImg_Sort(int Img_Sort) {
            this.Img_Sort = Img_Sort;
        }
    }

    public static class RecordBean {
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
        private int GoodsPrice_Price;
        private int GoodsPrice_VirtualPrice;
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

        public int getGoodsPrice_Price() {
            return GoodsPrice_Price;
        }

        public void setGoodsPrice_Price(int GoodsPrice_Price) {
            this.GoodsPrice_Price = GoodsPrice_Price;
        }

        public int getGoodsPrice_VirtualPrice() {
            return GoodsPrice_VirtualPrice;
        }

        public void setGoodsPrice_VirtualPrice(int GoodsPrice_VirtualPrice) {
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


}
