package com.whmnrc.qiangbizhong.model.bean;

import java.util.List;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/25.
 */

public class YiMeiGoodsDetailBean {


    /**
     * Goods : {"Goods_ID":"c3375c79-5637-4719-93de-a9f9b049417c","Goods_Name":"印度神油","Goods_BrandName":"ymd","Goods_Describe":"印度神油，是产自印度的一款按摩精油，又称阿育吠陀印度神油，是一种男女性保健品","Goods_ImaPath":"http://testaml.whmnx.com/Resource/PhotoFile/5696be82-583a-4605-8333-349eaeda7f74.png","Goods_Content":null,"Goods_LookCount":0,"Goods_MonthCount":0,"Goods_Sort":99,"Goods_IsOn":true,"Goods_IsBuy":true,"Goods_Type":"08868888-16f1-4c58-a428-2b01bd1b14a1","Goods_LimitCount":1,"StoreId":"16e074f3-7279-4abb-8ad2-5d42f3e8ac7c","Goods_Parameter":null,"Goods_ShopType":3,"Goods_PriceMin":400,"Goods_PriceMax":400}
     * GoodsPrice : {"GoodsPrice_ID":"1dc38420-d1a9-41bd-a7a2-4451d005a2e3","GoodsPrice_AttrName":"10支装","GoodsPrice_SpecName":"盒","GoodsPrice_Price":400,"Goods_ID":"c3375c79-5637-4719-93de-a9f9b049417c","GoodsPrice_Sort":1,"GoodsPrice_Stock":1000,"GoodsPrice_TotalStock":1000,"GoodsPrice_VirtualPrice":800}
     * StoreInfo : {"Id":"16e074f3-7279-4abb-8ad2-5d42f3e8ac7c","StoreName":"辛巴的店","StoreImage":"http://testaml.whmnx.com","LegalPerson":null,"IdentityCard":null,"CompanyName":null,"OrganizationCode":null,"Area":null,"Address":"湖北省武汉市洪山区珞喻路237号","IdentityCardImage1":null,"IdentityCardImage2":null,"LicenseImage":null,"Phone":null,"WeChartNum":null,"BankAccount":null,"BankName":null,"BankBranchName":null,"SettlementBankAccount":null,"SettlementBankName":null,"Explain":"1111111111111111最棒的","StoreHeadImage":"http://testaml.whmnx.com","UserId":null,"Status":0,"CreateDate":"0001-01-01 00:00:00","Reson":null,"Latitude":null,"Longitude":null}
     * Evaluate : []
     * EvaluateCount : 0
     */

    private GoodsBean Goods;
    private GoodsPriceBean GoodsPrice;
    private StoreInfoBean StoreInfo;
    private int EvaluateCount;
    private List<?> Evaluate;

    public GoodsBean getGoods() {
        return Goods;
    }

    public void setGoods(GoodsBean Goods) {
        this.Goods = Goods;
    }

    public GoodsPriceBean getGoodsPrice() {
        return GoodsPrice;
    }

    public void setGoodsPrice(GoodsPriceBean GoodsPrice) {
        this.GoodsPrice = GoodsPrice;
    }

    public StoreInfoBean getStoreInfo() {
        return StoreInfo;
    }

    public void setStoreInfo(StoreInfoBean StoreInfo) {
        this.StoreInfo = StoreInfo;
    }

    public int getEvaluateCount() {
        return EvaluateCount;
    }

    public void setEvaluateCount(int EvaluateCount) {
        this.EvaluateCount = EvaluateCount;
    }

    public List<?> getEvaluate() {
        return Evaluate;
    }

    public void setEvaluate(List<?> Evaluate) {
        this.Evaluate = Evaluate;
    }

    public static class GoodsBean {
        /**
         * Goods_ID : c3375c79-5637-4719-93de-a9f9b049417c
         * Goods_Name : 印度神油
         * Goods_BrandName : ymd
         * Goods_Describe : 印度神油，是产自印度的一款按摩精油，又称阿育吠陀印度神油，是一种男女性保健品
         * Goods_ImaPath : http://testaml.whmnx.com/Resource/PhotoFile/5696be82-583a-4605-8333-349eaeda7f74.png
         * Goods_Content : null
         * Goods_LookCount : 0
         * Goods_MonthCount : 0
         * Goods_Sort : 99
         * Goods_IsOn : true
         * Goods_IsBuy : true
         * Goods_Type : 08868888-16f1-4c58-a428-2b01bd1b14a1
         * Goods_LimitCount : 1
         * StoreId : 16e074f3-7279-4abb-8ad2-5d42f3e8ac7c
         * Goods_Parameter : null
         * Goods_ShopType : 3
         * Goods_PriceMin : 400
         * Goods_PriceMax : 400
         */

        private String Goods_ID;
        private String Goods_Name;
        private String Goods_BrandName;
        private String Goods_Describe;
        private String Goods_ImaPath;
        private Object Goods_Content;
        private int Goods_LookCount;
        private int Goods_MonthCount;
        private int Goods_Sort;
        private boolean Goods_IsOn;
        private boolean Goods_IsBuy;
        private String Goods_Type;
        private int Goods_LimitCount;
        private String StoreId;
        private Object Goods_Parameter;
        private int Goods_ShopType;
        private int Goods_PriceMin;
        private int Goods_PriceMax;

        public String getGoods_ID() {
            return Goods_ID;
        }

        public void setGoods_ID(String Goods_ID) {
            this.Goods_ID = Goods_ID;
        }

        public String getGoods_Name() {
            return Goods_Name;
        }

        public void setGoods_Name(String Goods_Name) {
            this.Goods_Name = Goods_Name;
        }

        public String getGoods_BrandName() {
            return Goods_BrandName;
        }

        public void setGoods_BrandName(String Goods_BrandName) {
            this.Goods_BrandName = Goods_BrandName;
        }

        public String getGoods_Describe() {
            return Goods_Describe;
        }

        public void setGoods_Describe(String Goods_Describe) {
            this.Goods_Describe = Goods_Describe;
        }

        public String getGoods_ImaPath() {
            return Goods_ImaPath;
        }

        public void setGoods_ImaPath(String Goods_ImaPath) {
            this.Goods_ImaPath = Goods_ImaPath;
        }

        public Object getGoods_Content() {
            return Goods_Content;
        }

        public void setGoods_Content(Object Goods_Content) {
            this.Goods_Content = Goods_Content;
        }

        public int getGoods_LookCount() {
            return Goods_LookCount;
        }

        public void setGoods_LookCount(int Goods_LookCount) {
            this.Goods_LookCount = Goods_LookCount;
        }

        public int getGoods_MonthCount() {
            return Goods_MonthCount;
        }

        public void setGoods_MonthCount(int Goods_MonthCount) {
            this.Goods_MonthCount = Goods_MonthCount;
        }

        public int getGoods_Sort() {
            return Goods_Sort;
        }

        public void setGoods_Sort(int Goods_Sort) {
            this.Goods_Sort = Goods_Sort;
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

        public String getGoods_Type() {
            return Goods_Type;
        }

        public void setGoods_Type(String Goods_Type) {
            this.Goods_Type = Goods_Type;
        }

        public int getGoods_LimitCount() {
            return Goods_LimitCount;
        }

        public void setGoods_LimitCount(int Goods_LimitCount) {
            this.Goods_LimitCount = Goods_LimitCount;
        }

        public String getStoreId() {
            return StoreId;
        }

        public void setStoreId(String StoreId) {
            this.StoreId = StoreId;
        }

        public Object getGoods_Parameter() {
            return Goods_Parameter;
        }

        public void setGoods_Parameter(Object Goods_Parameter) {
            this.Goods_Parameter = Goods_Parameter;
        }

        public int getGoods_ShopType() {
            return Goods_ShopType;
        }

        public void setGoods_ShopType(int Goods_ShopType) {
            this.Goods_ShopType = Goods_ShopType;
        }

        public int getGoods_PriceMin() {
            return Goods_PriceMin;
        }

        public void setGoods_PriceMin(int Goods_PriceMin) {
            this.Goods_PriceMin = Goods_PriceMin;
        }

        public int getGoods_PriceMax() {
            return Goods_PriceMax;
        }

        public void setGoods_PriceMax(int Goods_PriceMax) {
            this.Goods_PriceMax = Goods_PriceMax;
        }
    }

    public static class GoodsPriceBean {
        /**
         * GoodsPrice_ID : 1dc38420-d1a9-41bd-a7a2-4451d005a2e3
         * GoodsPrice_AttrName : 10支装
         * GoodsPrice_SpecName : 盒
         * GoodsPrice_Price : 400
         * Goods_ID : c3375c79-5637-4719-93de-a9f9b049417c
         * GoodsPrice_Sort : 1
         * GoodsPrice_Stock : 1000
         * GoodsPrice_TotalStock : 1000
         * GoodsPrice_VirtualPrice : 800
         */

        private String GoodsPrice_ID;
        private String GoodsPrice_AttrName;
        private String GoodsPrice_SpecName;
        private int GoodsPrice_Price;
        private String Goods_ID;
        private int GoodsPrice_Sort;
        private int GoodsPrice_Stock;
        private int GoodsPrice_TotalStock;
        private int GoodsPrice_VirtualPrice;

        public String getGoodsPrice_ID() {
            return GoodsPrice_ID;
        }

        public void setGoodsPrice_ID(String GoodsPrice_ID) {
            this.GoodsPrice_ID = GoodsPrice_ID;
        }

        public String getGoodsPrice_AttrName() {
            return GoodsPrice_AttrName;
        }

        public void setGoodsPrice_AttrName(String GoodsPrice_AttrName) {
            this.GoodsPrice_AttrName = GoodsPrice_AttrName;
        }

        public String getGoodsPrice_SpecName() {
            return GoodsPrice_SpecName;
        }

        public void setGoodsPrice_SpecName(String GoodsPrice_SpecName) {
            this.GoodsPrice_SpecName = GoodsPrice_SpecName;
        }

        public int getGoodsPrice_Price() {
            return GoodsPrice_Price;
        }

        public void setGoodsPrice_Price(int GoodsPrice_Price) {
            this.GoodsPrice_Price = GoodsPrice_Price;
        }

        public String getGoods_ID() {
            return Goods_ID;
        }

        public void setGoods_ID(String Goods_ID) {
            this.Goods_ID = Goods_ID;
        }

        public int getGoodsPrice_Sort() {
            return GoodsPrice_Sort;
        }

        public void setGoodsPrice_Sort(int GoodsPrice_Sort) {
            this.GoodsPrice_Sort = GoodsPrice_Sort;
        }

        public int getGoodsPrice_Stock() {
            return GoodsPrice_Stock;
        }

        public void setGoodsPrice_Stock(int GoodsPrice_Stock) {
            this.GoodsPrice_Stock = GoodsPrice_Stock;
        }

        public int getGoodsPrice_TotalStock() {
            return GoodsPrice_TotalStock;
        }

        public void setGoodsPrice_TotalStock(int GoodsPrice_TotalStock) {
            this.GoodsPrice_TotalStock = GoodsPrice_TotalStock;
        }

        public int getGoodsPrice_VirtualPrice() {
            return GoodsPrice_VirtualPrice;
        }

        public void setGoodsPrice_VirtualPrice(int GoodsPrice_VirtualPrice) {
            this.GoodsPrice_VirtualPrice = GoodsPrice_VirtualPrice;
        }
    }

    public static class StoreInfoBean {
        /**
         * Id : 16e074f3-7279-4abb-8ad2-5d42f3e8ac7c
         * StoreName : 辛巴的店
         * StoreImage : http://testaml.whmnx.com
         * LegalPerson : null
         * IdentityCard : null
         * CompanyName : null
         * OrganizationCode : null
         * Area : null
         * Address : 湖北省武汉市洪山区珞喻路237号
         * IdentityCardImage1 : null
         * IdentityCardImage2 : null
         * LicenseImage : null
         * Phone : null
         * WeChartNum : null
         * BankAccount : null
         * BankName : null
         * BankBranchName : null
         * SettlementBankAccount : null
         * SettlementBankName : null
         * Explain : 1111111111111111最棒的
         * StoreHeadImage : http://testaml.whmnx.com
         * UserId : null
         * Status : 0
         * CreateDate : 0001-01-01 00:00:00
         * Reson : null
         * Latitude : null
         * Longitude : null
         */

        private String Id;
        private String StoreName;
        private String StoreImage;
        private Object LegalPerson;
        private Object IdentityCard;
        private Object CompanyName;
        private Object OrganizationCode;
        private Object Area;
        private String Address;
        private Object IdentityCardImage1;
        private Object IdentityCardImage2;
        private Object LicenseImage;
        private Object Phone;
        private Object WeChartNum;
        private Object BankAccount;
        private Object BankName;
        private Object BankBranchName;
        private Object SettlementBankAccount;
        private Object SettlementBankName;
        private String Explain;
        private String StoreHeadImage;
        private Object UserId;
        private int Status;
        private String CreateDate;
        private Object Reson;
        private Object Latitude;
        private Object Longitude;

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

        public String getStoreImage() {
            return StoreImage;
        }

        public void setStoreImage(String StoreImage) {
            this.StoreImage = StoreImage;
        }

        public Object getLegalPerson() {
            return LegalPerson;
        }

        public void setLegalPerson(Object LegalPerson) {
            this.LegalPerson = LegalPerson;
        }

        public Object getIdentityCard() {
            return IdentityCard;
        }

        public void setIdentityCard(Object IdentityCard) {
            this.IdentityCard = IdentityCard;
        }

        public Object getCompanyName() {
            return CompanyName;
        }

        public void setCompanyName(Object CompanyName) {
            this.CompanyName = CompanyName;
        }

        public Object getOrganizationCode() {
            return OrganizationCode;
        }

        public void setOrganizationCode(Object OrganizationCode) {
            this.OrganizationCode = OrganizationCode;
        }

        public Object getArea() {
            return Area;
        }

        public void setArea(Object Area) {
            this.Area = Area;
        }

        public String getAddress() {
            return Address;
        }

        public void setAddress(String Address) {
            this.Address = Address;
        }

        public Object getIdentityCardImage1() {
            return IdentityCardImage1;
        }

        public void setIdentityCardImage1(Object IdentityCardImage1) {
            this.IdentityCardImage1 = IdentityCardImage1;
        }

        public Object getIdentityCardImage2() {
            return IdentityCardImage2;
        }

        public void setIdentityCardImage2(Object IdentityCardImage2) {
            this.IdentityCardImage2 = IdentityCardImage2;
        }

        public Object getLicenseImage() {
            return LicenseImage;
        }

        public void setLicenseImage(Object LicenseImage) {
            this.LicenseImage = LicenseImage;
        }

        public Object getPhone() {
            return Phone;
        }

        public void setPhone(Object Phone) {
            this.Phone = Phone;
        }

        public Object getWeChartNum() {
            return WeChartNum;
        }

        public void setWeChartNum(Object WeChartNum) {
            this.WeChartNum = WeChartNum;
        }

        public Object getBankAccount() {
            return BankAccount;
        }

        public void setBankAccount(Object BankAccount) {
            this.BankAccount = BankAccount;
        }

        public Object getBankName() {
            return BankName;
        }

        public void setBankName(Object BankName) {
            this.BankName = BankName;
        }

        public Object getBankBranchName() {
            return BankBranchName;
        }

        public void setBankBranchName(Object BankBranchName) {
            this.BankBranchName = BankBranchName;
        }

        public Object getSettlementBankAccount() {
            return SettlementBankAccount;
        }

        public void setSettlementBankAccount(Object SettlementBankAccount) {
            this.SettlementBankAccount = SettlementBankAccount;
        }

        public Object getSettlementBankName() {
            return SettlementBankName;
        }

        public void setSettlementBankName(Object SettlementBankName) {
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

        public Object getUserId() {
            return UserId;
        }

        public void setUserId(Object UserId) {
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

        public Object getReson() {
            return Reson;
        }

        public void setReson(Object Reson) {
            this.Reson = Reson;
        }

        public Object getLatitude() {
            return Latitude;
        }

        public void setLatitude(Object Latitude) {
            this.Latitude = Latitude;
        }

        public Object getLongitude() {
            return Longitude;
        }

        public void setLongitude(Object Longitude) {
            this.Longitude = Longitude;
        }
    }
}
