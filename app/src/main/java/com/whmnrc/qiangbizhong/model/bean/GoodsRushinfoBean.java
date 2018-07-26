package com.whmnrc.qiangbizhong.model.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/13.
 */

public class GoodsRushinfoBean implements Parcelable {

    /**
     * RushGoodsInfo : {"RushId":"1a721891-a86d-4478-9840-5b9acef5fce5","Goods_MonthCount":1000,"GoodsPrice_Stock":1000,"Goods_ID":"ed58f160-6b87-4d93-bb52-2545c9e39e9e","Goods_ShopType":1,"GoodsPrice_ID":"d794c755-5596-4f27-9721-617a3192fc3f","Goods_Name":"七彩渐变玻璃杯","Goods_ImaPath":"http://testaml.whmnx.com/Resource/PhotoFile/5085d83f-f380-4ab7-8669-daf96fe7b4e9.jpg","Goods_Content":"<p><img src=\"/Resource/image/20180726/6366821622400585905309881.jpg\" title=\"1.jpg\"/><\/p><p><img src=\"/Resource/image/20180726/6366821622413481408038359.jpg\" title=\"3.jpg\"/><\/p><p><img src=\"/Resource/image/20180726/6366821622414159978038359.jpg\" title=\"4.jpg\"/><\/p><p><img src=\"/Resource/image/20180726/6366821622414660202267604.jpg\" title=\"2.jpg\"/><\/p><p><img src=\"/Resource/image/20180726/6366821622423537879010175.jpg\" title=\"105f7ece-5.jpg\"/><\/p><p><img src=\"/Resource/image/20180726/6366821622424903883239420.jpg\" title=\"105f7ece-2.jpg\"/><\/p><p><img src=\"/Resource/image/20180726/6366821622425797091766838.jpg\" title=\"105f7ece-4.jpg\"/><\/p><p><img src=\"/Resource/image/20180726/6366821622432228149981991.jpg\" title=\"105f7ece-6.jpg\"/><\/p><p><br/><\/p>","Goods_Parameter":"<p><img src=\"/Resource/image/20180726/6366821624000783863555124.jpg\" title=\"5.jpg\" alt=\"5.jpg\"/><\/p>","Goods_Describe":"彩色随手直身玻璃杯便携韩式简约清新ins家用磨砂水杯子","Goods_IsOn":true,"Goods_IsBuy":true,"GoodsPrice_SpecName":"个","GoodsPrice_AttrName":"多色","GoodsPrice_VirtualPrice":79.9,"RushStartTime":"2018-07-26 15:41:00","RushEndTime":"2018-07-26 16:39:00","RushNumber":1000,"Bond":5,"GoodsPrice_Price":32,"IsGoUp":1,"IsEnd":1,"CreateDate":"2018-07-26 15:39:54"}
     * RushGoodsBanner : [{"Img_ID":"f1501d27-ff8d-495d-9f69-7978e9409115","Object_ID":"ed58f160-6b87-4d93-bb52-2545c9e39e9e","Img_Path":"http://testaml.whmnx.com/Resource/PhotoFile/e846381d-e424-44b0-ab45-ac9e8dd259c2.jpg","Img_Sort":2,"Img_Type":0}]
     * Record :
     * Participate : 0
     */

    private RushGoodsInfoBean RushGoodsInfo;
//    private String Record;
    private int Participate;
    private List<RushGoodsBannerBean> RushGoodsBanner;

    protected GoodsRushinfoBean(Parcel in) {
        RushGoodsInfo = in.readParcelable(RushGoodsInfoBean.class.getClassLoader());
        Participate = in.readInt();
    }

    public static final Creator<GoodsRushinfoBean> CREATOR = new Creator<GoodsRushinfoBean>() {
        @Override
        public GoodsRushinfoBean createFromParcel(Parcel in) {
            return new GoodsRushinfoBean(in);
        }

        @Override
        public GoodsRushinfoBean[] newArray(int size) {
            return new GoodsRushinfoBean[size];
        }
    };

    public RushGoodsInfoBean getRushGoodsInfo() {
        return RushGoodsInfo;
    }

    public void setRushGoodsInfo(RushGoodsInfoBean RushGoodsInfo) {
        this.RushGoodsInfo = RushGoodsInfo;
    }

    public int getParticipate() {
        return Participate;
    }

    public void setParticipate(int Participate) {
        this.Participate = Participate;
    }

    public List<RushGoodsBannerBean> getRushGoodsBanner() {
        return RushGoodsBanner;
    }

    public void setRushGoodsBanner(List<RushGoodsBannerBean> RushGoodsBanner) {
        this.RushGoodsBanner = RushGoodsBanner;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(RushGoodsInfo, flags);
        dest.writeInt(Participate);
    }

    public static class RushGoodsInfoBean implements Parcelable{
        /**
         * RushId : 1a721891-a86d-4478-9840-5b9acef5fce5
         * Goods_MonthCount : 1000
         * GoodsPrice_Stock : 1000
         * Goods_ID : ed58f160-6b87-4d93-bb52-2545c9e39e9e
         * Goods_ShopType : 1
         * GoodsPrice_ID : d794c755-5596-4f27-9721-617a3192fc3f
         * Goods_Name : 七彩渐变玻璃杯
         * Goods_ImaPath : http://testaml.whmnx.com/Resource/PhotoFile/5085d83f-f380-4ab7-8669-daf96fe7b4e9.jpg
         * Goods_Content : <p><img src="/Resource/image/20180726/6366821622400585905309881.jpg" title="1.jpg"/></p><p><img src="/Resource/image/20180726/6366821622413481408038359.jpg" title="3.jpg"/></p><p><img src="/Resource/image/20180726/6366821622414159978038359.jpg" title="4.jpg"/></p><p><img src="/Resource/image/20180726/6366821622414660202267604.jpg" title="2.jpg"/></p><p><img src="/Resource/image/20180726/6366821622423537879010175.jpg" title="105f7ece-5.jpg"/></p><p><img src="/Resource/image/20180726/6366821622424903883239420.jpg" title="105f7ece-2.jpg"/></p><p><img src="/Resource/image/20180726/6366821622425797091766838.jpg" title="105f7ece-4.jpg"/></p><p><img src="/Resource/image/20180726/6366821622432228149981991.jpg" title="105f7ece-6.jpg"/></p><p><br/></p>
         * Goods_Parameter : <p><img src="/Resource/image/20180726/6366821624000783863555124.jpg" title="5.jpg" alt="5.jpg"/></p>
         * Goods_Describe : 彩色随手直身玻璃杯便携韩式简约清新ins家用磨砂水杯子
         * Goods_IsOn : true
         * Goods_IsBuy : true
         * GoodsPrice_SpecName : 个
         * GoodsPrice_AttrName : 多色
         * GoodsPrice_VirtualPrice : 79.9
         * RushStartTime : 2018-07-26 15:41:00
         * RushEndTime : 2018-07-26 16:39:00
         * RushNumber : 1000
         * Bond : 5
         * GoodsPrice_Price : 32
         * IsGoUp : 1
         * IsEnd : 1
         * CreateDate : 2018-07-26 15:39:54
         */

        private String RushId;
        private int Goods_MonthCount;
        private int GoodsPrice_Stock;
        private String Goods_ID;
        private int Goods_ShopType;
        private String GoodsPrice_ID;
        private String Goods_Name;
        private String Goods_ImaPath;
        private String Goods_Content;
        private String Goods_Parameter;
        private String Goods_Describe;
        private boolean Goods_IsOn;
        private boolean Goods_IsBuy;
        private String GoodsPrice_SpecName;
        private String GoodsPrice_AttrName;
        private double GoodsPrice_VirtualPrice;
        private String RushStartTime;
        private String RushEndTime;
        private int RushNumber;
        private int Bond;
        private int GoodsPrice_Price;
        private int IsGoUp;
        private int IsEnd;
        private String CreateDate;

        protected RushGoodsInfoBean(Parcel in) {
            RushId = in.readString();
            Goods_MonthCount = in.readInt();
            GoodsPrice_Stock = in.readInt();
            Goods_ID = in.readString();
            Goods_ShopType = in.readInt();
            GoodsPrice_ID = in.readString();
            Goods_Name = in.readString();
            Goods_ImaPath = in.readString();
            Goods_Content = in.readString();
            Goods_Parameter = in.readString();
            Goods_Describe = in.readString();
            Goods_IsOn = in.readByte() != 0;
            Goods_IsBuy = in.readByte() != 0;
            GoodsPrice_SpecName = in.readString();
            GoodsPrice_AttrName = in.readString();
            GoodsPrice_VirtualPrice = in.readDouble();
            RushStartTime = in.readString();
            RushEndTime = in.readString();
            RushNumber = in.readInt();
            Bond = in.readInt();
            GoodsPrice_Price = in.readInt();
            IsGoUp = in.readInt();
            IsEnd = in.readInt();
            CreateDate = in.readString();
        }

        public static final Creator<RushGoodsInfoBean> CREATOR = new Creator<RushGoodsInfoBean>() {
            @Override
            public RushGoodsInfoBean createFromParcel(Parcel in) {
                return new RushGoodsInfoBean(in);
            }

            @Override
            public RushGoodsInfoBean[] newArray(int size) {
                return new RushGoodsInfoBean[size];
            }
        };

        public String getRushId() {
            return RushId;
        }

        public void setRushId(String RushId) {
            this.RushId = RushId;
        }

        public int getGoods_MonthCount() {
            return Goods_MonthCount;
        }

        public void setGoods_MonthCount(int Goods_MonthCount) {
            this.Goods_MonthCount = Goods_MonthCount;
        }

        public int getGoodsPrice_Stock() {
            return GoodsPrice_Stock;
        }

        public void setGoodsPrice_Stock(int GoodsPrice_Stock) {
            this.GoodsPrice_Stock = GoodsPrice_Stock;
        }

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

        public String getGoods_Parameter() {
            return Goods_Parameter;
        }

        public void setGoods_Parameter(String Goods_Parameter) {
            this.Goods_Parameter = Goods_Parameter;
        }

        public String getGoods_Describe() {
            return Goods_Describe;
        }

        public void setGoods_Describe(String Goods_Describe) {
            this.Goods_Describe = Goods_Describe;
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

        public double getGoodsPrice_VirtualPrice() {
            return GoodsPrice_VirtualPrice;
        }

        public void setGoodsPrice_VirtualPrice(double GoodsPrice_VirtualPrice) {
            this.GoodsPrice_VirtualPrice = GoodsPrice_VirtualPrice;
        }

        public String getRushStartTime() {
            return RushStartTime;
        }

        public void setRushStartTime(String RushStartTime) {
            this.RushStartTime = RushStartTime;
        }

        public String getRushEndTime() {
            return RushEndTime;
        }

        public void setRushEndTime(String RushEndTime) {
            this.RushEndTime = RushEndTime;
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

        public int getGoodsPrice_Price() {
            return GoodsPrice_Price;
        }

        public void setGoodsPrice_Price(int GoodsPrice_Price) {
            this.GoodsPrice_Price = GoodsPrice_Price;
        }

        public int getIsGoUp() {
            return IsGoUp;
        }

        public void setIsGoUp(int IsGoUp) {
            this.IsGoUp = IsGoUp;
        }

        public int getIsEnd() {
            return IsEnd;
        }

        public void setIsEnd(int IsEnd) {
            this.IsEnd = IsEnd;
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
            dest.writeString(RushId);
            dest.writeInt(Goods_MonthCount);
            dest.writeInt(GoodsPrice_Stock);
            dest.writeString(Goods_ID);
            dest.writeInt(Goods_ShopType);
            dest.writeString(GoodsPrice_ID);
            dest.writeString(Goods_Name);
            dest.writeString(Goods_ImaPath);
            dest.writeString(Goods_Content);
            dest.writeString(Goods_Parameter);
            dest.writeString(Goods_Describe);
            dest.writeByte((byte) (Goods_IsOn ? 1 : 0));
            dest.writeByte((byte) (Goods_IsBuy ? 1 : 0));
            dest.writeString(GoodsPrice_SpecName);
            dest.writeString(GoodsPrice_AttrName);
            dest.writeDouble(GoodsPrice_VirtualPrice);
            dest.writeString(RushStartTime);
            dest.writeString(RushEndTime);
            dest.writeInt(RushNumber);
            dest.writeInt(Bond);
            dest.writeInt(GoodsPrice_Price);
            dest.writeInt(IsGoUp);
            dest.writeInt(IsEnd);
            dest.writeString(CreateDate);
        }
    }

    public static class RushGoodsBannerBean {
        /**
         * Img_ID : f1501d27-ff8d-495d-9f69-7978e9409115
         * Object_ID : ed58f160-6b87-4d93-bb52-2545c9e39e9e
         * Img_Path : http://testaml.whmnx.com/Resource/PhotoFile/e846381d-e424-44b0-ab45-ac9e8dd259c2.jpg
         * Img_Sort : 2
         * Img_Type : 0
         */

        private String Img_ID;
        private String Object_ID;
        private String Img_Path;
        private int Img_Sort;
        private int Img_Type;

        public String getImg_ID() {
            return Img_ID;
        }

        public void setImg_ID(String Img_ID) {
            this.Img_ID = Img_ID;
        }

        public String getObject_ID() {
            return Object_ID;
        }

        public void setObject_ID(String Object_ID) {
            this.Object_ID = Object_ID;
        }

        public String getImg_Path() {
            return Img_Path;
        }

        public void setImg_Path(String Img_Path) {
            this.Img_Path = Img_Path;
        }

        public int getImg_Sort() {
            return Img_Sort;
        }

        public void setImg_Sort(int Img_Sort) {
            this.Img_Sort = Img_Sort;
        }

        public int getImg_Type() {
            return Img_Type;
        }

        public void setImg_Type(int Img_Type) {
            this.Img_Type = Img_Type;
        }
    }
}
