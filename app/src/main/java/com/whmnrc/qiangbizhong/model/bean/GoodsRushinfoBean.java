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
     * RushGoodsInfo : {"RushId":"f79b404f-4e9f-49a2-932c-106395d4ffa5","Goods_MonthCount":0,"GoodsPrice_Stock":911,"Goods_ID":"f2cfb2f8-b6ec-41fc-bf6b-59c522e80fa7","Goods_ShopType":1,"GoodsPrice_ID":"45bc81fb-7ca8-4e2e-848c-d4e0b673392e","Goods_Name":"IPhone 兵222","Goods_ImaPath":"http://www.eehsxui.cn/Resource/PhotoFile/c6d130e9-285a-4f7a-bef2-c044d91ce061.jpg","Goods_Content":"<p><img src=\"/Content/scripts/plugins/ueditor/net/../../../../../upload/image/20180408/6365881242772590514752915.jpg\" title=\"未标题-2_01.jpg\" alt=\"未标题-2_01.jpg\"/><img src=\"/Content/scripts/plugins/ueditor/net/../../../../../upload/image/20180408/6365881243096028019464110.jpg\" title=\"未标题-2_02.jpg\" alt=\"未标题-2_02.jpg\"/><img src=\"/Content/scripts/plugins/ueditor/net/../../../../../upload/image/20180408/6365881243725715516873941.jpg\" title=\"未标题-2_03.jpg\" alt=\"未标题-2_03.jpg\"/><img src=\"/Content/scripts/plugins/ueditor/net/../../../../../upload/image/20180408/6365881243958528018729124.jpg\" title=\"未标题-2_04.jpg\" alt=\"未标题-2_04.jpg\"/><img src=\"/Content/scripts/plugins/ueditor/net/../../../../../upload/image/20180408/6365881244175715516099166.jpg\" title=\"未标题-2_05.jpg\" alt=\"未标题-2_05.jpg\"/><img src=\"/Content/scripts/plugins/ueditor/net/../../../../../upload/image/20180408/6365881244425715516668735.jpg\" title=\"未标题-2_06.jpg\" alt=\"未标题-2_06.jpg\"/><img src=\"/Content/scripts/plugins/ueditor/net/../../../../../upload/image/20180408/6365881244652278015010592.jpg\" title=\"未标题-2_07.jpg\" alt=\"未标题-2_07.jpg\"/><img src=\"/Content/scripts/plugins/ueditor/net/../../../../../upload/image/20180408/6365881244867903018151389.jpg\" title=\"未标题-2_08.jpg\" alt=\"未标题-2_08.jpg\"/><img src=\"/Content/scripts/plugins/ueditor/net/../../../../../upload/image/20180408/6365881245099153016777327.jpg\" title=\"未标题-2_09.jpg\" alt=\"未标题-2_09.jpg\"/><img src=\"/Content/scripts/plugins/ueditor/net/../../../../../upload/image/20180408/6365881245313215512390706.jpg\" title=\"未标题-2_10.jpg\" alt=\"未标题-2_10.jpg\"/><img src=\"/Content/scripts/plugins/ueditor/net/../../../../../upload/image/20180408/6365881245555403015217704.jpg\" title=\"未标题-2_11.jpg\" alt=\"未标题-2_11.jpg\"/><img src=\"/Content/scripts/plugins/ueditor/net/../../../../../upload/image/20180408/6365881245794465511586213.jpg\" title=\"未标题-2_12.jpg\" alt=\"未标题-2_12.jpg\"/><img src=\"/Content/scripts/plugins/ueditor/net/../../../../../upload/image/20180408/6365881246055403016356843.jpg\" title=\"未标题-2_13.jpg\" alt=\"未标题-2_13.jpg\"/><img src=\"/Content/scripts/plugins/ueditor/net/../../../../../upload/image/20180408/6365881246335090518369277.jpg\" title=\"未标题-2_14.jpg\" alt=\"未标题-2_14.jpg\"/><img src=\"/Content/scripts/plugins/ueditor/net/../../../../../upload/image/20180408/6365881246555403017495981.jpg\" title=\"未标题-2_15.jpg\" alt=\"未标题-2_15.jpg\"/><img src=\"/Content/scripts/plugins/ueditor/net/../../../../../upload/image/20180408/6365881246800715513079643.jpg\" title=\"未标题-2_16.jpg\" alt=\"未标题-2_16.jpg\"/><img src=\"/Content/scripts/plugins/ueditor/net/../../../../../upload/image/20180408/6365881247019465517977102.jpg\" title=\"未标题-2_17.jpg\" alt=\"未标题-2_17.jpg\"/><img src=\"/Content/scripts/plugins/ueditor/net/../../../../../upload/image/20180408/6365881247231965519361236.jpg\" title=\"未标题-2_18.jpg\" alt=\"未标题-2_18.jpg\"/><\/p>","Goods_Parameter":null,"GoodsPrice_SpecName":"IPhone 7 亮黑色","GoodsPrice_AttrName":"32G","GoodsPrice_VirtualPrice":4000,"RushStartTime":"2018-07-14 22:00:00","RushEndTime":"2018-07-15 00:00:00","RushNumber":2,"Bond":100,"GoodsPrice_Price":6000,"IsEnd":0}
     * RushGoodsBanner : [{"Img_ID":"7a3a67a8-d6ed-4cfa-aa1c-42c40414a6a9","Object_ID":"f2cfb2f8-b6ec-41fc-bf6b-59c522e80fa7","Img_Path":"http://www.eehsxui.cn/Resource/PhotoFile/8e80378f-bcbf-46c1-991b-24b64032f55c.jpg","Img_Sort":1,"Img_Type":0},{"Img_ID":"f3512bd8-5d0e-4cc8-8ca1-84bd150a9793","Object_ID":"f2cfb2f8-b6ec-41fc-bf6b-59c522e80fa7","Img_Path":"http://www.eehsxui.cn/Resource/PhotoFile/0eecb43e-c6aa-4c59-bd4a-d0d1dd584e0b.jpg","Img_Sort":2,"Img_Type":0}]
     * Record :
     * Participate : 0
     */

    private RushGoodsInfoBean RushGoodsInfo;
    private String Record;
    private int Participate;
    private List<RushGoodsBannerBean> RushGoodsBanner;

    protected GoodsRushinfoBean(Parcel in) {
        Record = in.readString();
        Participate = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(Record);
        dest.writeInt(Participate);
    }

    @Override
    public int describeContents() {
        return 0;
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

    public String getRecord() {
        return Record;
    }

    public void setRecord(String Record) {
        this.Record = Record;
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

    public static class RushGoodsInfoBean implements Parcelable {
        /**
         * RushId : f79b404f-4e9f-49a2-932c-106395d4ffa5
         * Goods_MonthCount : 0
         * GoodsPrice_Stock : 911
         * Goods_ID : f2cfb2f8-b6ec-41fc-bf6b-59c522e80fa7
         * Goods_ShopType : 1
         * GoodsPrice_ID : 45bc81fb-7ca8-4e2e-848c-d4e0b673392e
         * Goods_Name : IPhone 兵222
         * Goods_ImaPath : http://www.eehsxui.cn/Resource/PhotoFile/c6d130e9-285a-4f7a-bef2-c044d91ce061.jpg
         * Goods_Content : <p><img src="/Content/scripts/plugins/ueditor/net/../../../../../upload/image/20180408/6365881242772590514752915.jpg" title="未标题-2_01.jpg" alt="未标题-2_01.jpg"/><img src="/Content/scripts/plugins/ueditor/net/../../../../../upload/image/20180408/6365881243096028019464110.jpg" title="未标题-2_02.jpg" alt="未标题-2_02.jpg"/><img src="/Content/scripts/plugins/ueditor/net/../../../../../upload/image/20180408/6365881243725715516873941.jpg" title="未标题-2_03.jpg" alt="未标题-2_03.jpg"/><img src="/Content/scripts/plugins/ueditor/net/../../../../../upload/image/20180408/6365881243958528018729124.jpg" title="未标题-2_04.jpg" alt="未标题-2_04.jpg"/><img src="/Content/scripts/plugins/ueditor/net/../../../../../upload/image/20180408/6365881244175715516099166.jpg" title="未标题-2_05.jpg" alt="未标题-2_05.jpg"/><img src="/Content/scripts/plugins/ueditor/net/../../../../../upload/image/20180408/6365881244425715516668735.jpg" title="未标题-2_06.jpg" alt="未标题-2_06.jpg"/><img src="/Content/scripts/plugins/ueditor/net/../../../../../upload/image/20180408/6365881244652278015010592.jpg" title="未标题-2_07.jpg" alt="未标题-2_07.jpg"/><img src="/Content/scripts/plugins/ueditor/net/../../../../../upload/image/20180408/6365881244867903018151389.jpg" title="未标题-2_08.jpg" alt="未标题-2_08.jpg"/><img src="/Content/scripts/plugins/ueditor/net/../../../../../upload/image/20180408/6365881245099153016777327.jpg" title="未标题-2_09.jpg" alt="未标题-2_09.jpg"/><img src="/Content/scripts/plugins/ueditor/net/../../../../../upload/image/20180408/6365881245313215512390706.jpg" title="未标题-2_10.jpg" alt="未标题-2_10.jpg"/><img src="/Content/scripts/plugins/ueditor/net/../../../../../upload/image/20180408/6365881245555403015217704.jpg" title="未标题-2_11.jpg" alt="未标题-2_11.jpg"/><img src="/Content/scripts/plugins/ueditor/net/../../../../../upload/image/20180408/6365881245794465511586213.jpg" title="未标题-2_12.jpg" alt="未标题-2_12.jpg"/><img src="/Content/scripts/plugins/ueditor/net/../../../../../upload/image/20180408/6365881246055403016356843.jpg" title="未标题-2_13.jpg" alt="未标题-2_13.jpg"/><img src="/Content/scripts/plugins/ueditor/net/../../../../../upload/image/20180408/6365881246335090518369277.jpg" title="未标题-2_14.jpg" alt="未标题-2_14.jpg"/><img src="/Content/scripts/plugins/ueditor/net/../../../../../upload/image/20180408/6365881246555403017495981.jpg" title="未标题-2_15.jpg" alt="未标题-2_15.jpg"/><img src="/Content/scripts/plugins/ueditor/net/../../../../../upload/image/20180408/6365881246800715513079643.jpg" title="未标题-2_16.jpg" alt="未标题-2_16.jpg"/><img src="/Content/scripts/plugins/ueditor/net/../../../../../upload/image/20180408/6365881247019465517977102.jpg" title="未标题-2_17.jpg" alt="未标题-2_17.jpg"/><img src="/Content/scripts/plugins/ueditor/net/../../../../../upload/image/20180408/6365881247231965519361236.jpg" title="未标题-2_18.jpg" alt="未标题-2_18.jpg"/></p>
         * Goods_Parameter : null
         * GoodsPrice_SpecName : IPhone 7 亮黑色
         * GoodsPrice_AttrName : 32G
         * GoodsPrice_VirtualPrice : 4000
         * RushStartTime : 2018-07-14 22:00:00
         * RushEndTime : 2018-07-15 00:00:00
         * RushNumber : 2
         * Bond : 100
         * GoodsPrice_Price : 6000
         * IsEnd : 0
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
        private Object Goods_Parameter;
        private String GoodsPrice_SpecName;
        private String GoodsPrice_AttrName;
        private int GoodsPrice_VirtualPrice;
        private String RushStartTime;
        private String RushEndTime;
        private int RushNumber;
        private int Bond;
        private int GoodsPrice_Price;
        private int IsEnd;

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
            GoodsPrice_SpecName = in.readString();
            GoodsPrice_AttrName = in.readString();
            GoodsPrice_VirtualPrice = in.readInt();
            RushStartTime = in.readString();
            RushEndTime = in.readString();
            RushNumber = in.readInt();
            Bond = in.readInt();
            GoodsPrice_Price = in.readInt();
            IsEnd = in.readInt();
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

        public Object getGoods_Parameter() {
            return Goods_Parameter;
        }

        public void setGoods_Parameter(Object Goods_Parameter) {
            this.Goods_Parameter = Goods_Parameter;
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

        public int getGoodsPrice_VirtualPrice() {
            return GoodsPrice_VirtualPrice;
        }

        public void setGoodsPrice_VirtualPrice(int GoodsPrice_VirtualPrice) {
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

        public int getIsEnd() {
            return IsEnd;
        }

        public void setIsEnd(int IsEnd) {
            this.IsEnd = IsEnd;
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
            dest.writeString(GoodsPrice_SpecName);
            dest.writeString(GoodsPrice_AttrName);
            dest.writeInt(GoodsPrice_VirtualPrice);
            dest.writeString(RushStartTime);
            dest.writeString(RushEndTime);
            dest.writeInt(RushNumber);
            dest.writeInt(Bond);
            dest.writeInt(GoodsPrice_Price);
            dest.writeInt(IsEnd);
        }
    }

    public static class RushGoodsBannerBean implements Parcelable {
        /**
         * Img_ID : 7a3a67a8-d6ed-4cfa-aa1c-42c40414a6a9
         * Object_ID : f2cfb2f8-b6ec-41fc-bf6b-59c522e80fa7
         * Img_Path : http://www.eehsxui.cn/Resource/PhotoFile/8e80378f-bcbf-46c1-991b-24b64032f55c.jpg
         * Img_Sort : 1
         * Img_Type : 0
         */

        private String Img_ID;
        private String Object_ID;
        private String Img_Path;
        private int Img_Sort;
        private int Img_Type;

        protected RushGoodsBannerBean(Parcel in) {
            Img_ID = in.readString();
            Object_ID = in.readString();
            Img_Path = in.readString();
            Img_Sort = in.readInt();
            Img_Type = in.readInt();
        }

        public static final Creator<RushGoodsBannerBean> CREATOR = new Creator<RushGoodsBannerBean>() {
            @Override
            public RushGoodsBannerBean createFromParcel(Parcel in) {
                return new RushGoodsBannerBean(in);
            }

            @Override
            public RushGoodsBannerBean[] newArray(int size) {
                return new RushGoodsBannerBean[size];
            }
        };

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

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(Img_ID);
            dest.writeString(Object_ID);
            dest.writeString(Img_Path);
            dest.writeInt(Img_Sort);
            dest.writeInt(Img_Type);
        }
    }
}
