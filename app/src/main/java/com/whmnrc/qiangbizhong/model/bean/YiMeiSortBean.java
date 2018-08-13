package com.whmnrc.qiangbizhong.model.bean;

import java.util.List;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/26.
 */

public class YiMeiSortBean {


    /**
     * Goods : [{"Goods_ID":"c3375c79-5637-4719-93de-a9f9b049417c","Goods_Name":"印度神油","Goods_BrandName":"ymd","Goods_Describe":"印度神油，是产自印度的一款按摩精油，又称阿育吠陀印度神油，是一种男女性保健品","Goods_ImaPath":"http://192.168.1.157:8011/Resource/PhotoFile/5696be82-583a-4605-8333-349eaeda7f74.png","Goods_Content":null,"Goods_LookCount":0,"Goods_MonthCount":0,"Goods_Sort":99,"Goods_IsOn":true,"Goods_IsBuy":true,"Goods_Type":"08868888-16f1-4c58-a428-2b01bd1b14a1","Goods_LimitCount":1,"StoreId":"16e074f3-7279-4abb-8ad2-5d42f3e8ac7c","Goods_Parameter":null,"Goods_ShopType":3,"TypeName":"精油","StoreName":"辛巴的店","StoreStatus":1,"Goods_PriceMin":400,"Goods_PriceMax":400,"Address":"湖北省武汉市洪山区珞喻路237号","Latitude":"30.522112","Longitude":"114.365712","Distance":0}]
     * StoreInfo : {"Id":"16e074f3-7279-4abb-8ad2-5d42f3e8ac7c","StoreName":"辛巴的店","StoreImage":"http://192.168.1.157:8011","LegalPerson":null,"IdentityCard":null,"CompanyName":null,"OrganizationCode":null,"Area":null,"Address":"湖北省武汉市洪山区珞喻路237号","IdentityCardImage1":null,"IdentityCardImage2":null,"LicenseImage":null,"Phone":null,"WeChartNum":null,"BankAccount":null,"BankName":null,"BankBranchName":null,"SettlementBankAccount":null,"SettlementBankName":null,"Explain":"1111111111111111最棒的","StoreHeadImage":"http://192.168.1.157:8011","UserId":null,"Status":0,"CreateDate":"0001-01-01 00:00:00","Reson":null,"Latitude":null,"Longitude":null}
     */

    private StoreInfoBean StoreInfo;
    private List<YiMeiGoodsBean> Goods;
    private  int StoreIsCollection;

    public int getStoreIsCollection() {
        return StoreIsCollection;
    }

    public void setStoreIsCollection(int storeIsCollection) {
        StoreIsCollection = storeIsCollection;
    }

    public StoreInfoBean getStoreInfo() {
        return StoreInfo;
    }

    public void setStoreInfo(StoreInfoBean StoreInfo) {
        this.StoreInfo = StoreInfo;
    }

    public List<YiMeiGoodsBean> getGoods() {
        return Goods;
    }

    public void setGoods(List<YiMeiGoodsBean> Goods) {
        this.Goods = Goods;
    }

    public static class StoreInfoBean {
        /**
         * Id : 16e074f3-7279-4abb-8ad2-5d42f3e8ac7c
         * StoreName : 辛巴的店
         * StoreImage : http://192.168.1.157:8011
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
         * StoreHeadImage : http://192.168.1.157:8011
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
