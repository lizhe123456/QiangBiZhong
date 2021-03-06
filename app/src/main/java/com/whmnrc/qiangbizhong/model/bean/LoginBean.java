package com.whmnrc.qiangbizhong.model.bean;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/10.
 * 0普通 1代理商 2商家 3平台
 */

public class LoginBean {


    /**
     * UserInfo_State : 0
     * UserType : 0
     * Level_Sort : 0
     * UserInfo_Integer : 0
     * UserInfo_Money : 349993.5
     * UserInfo_TotalMoney : 9906020
     * UserInfo_ChilCount : 0
     * UserInfo_IsProcess : false
     * UserInfo_HeadImg : http://testaml.whmnx.com/Resource/HeadImage/964fbbd9-b242-48c1-b456-c26070047518.jpg
     * UserInfo_ID : 964fbbd9-b242-48c1-b456-c26070047518
     * UserInfo_Mobile : 15927297175
     * UserInfo_CreateTime : 2018-07-15 13:55:04
     * UserInfo_Pwd : E10ADC3949BA59ABBE56E057F20F883E
     * UserInfo_NickName : 哈哈哈
     */

    private int UserInfo_State;
    private int UserType;
    private int Level_Sort;
    private int UserInfo_Integer;
    private double UserInfo_Money;
    private int UserInfo_TotalMoney;
    private int UserInfo_ChilCount;
    private boolean UserInfo_IsProcess;
    private String UserInfo_HeadImg;
    private String UserInfo_ID;
    private String UserInfo_Mobile;
    private String UserInfo_CreateTime;
    private String UserInfo_Pwd;
    private String UserInfo_NickName;
    private StoreInfo StoreInfo;

    public StoreInfo getStoreInfo() {
        return StoreInfo;
    }

    public void setStoreInfo(StoreInfo storeInfo) {
        this.StoreInfo = storeInfo;
    }

    public int getUserInfo_State() {
        return UserInfo_State;
    }

    public void setUserInfo_State(int UserInfo_State) {
        this.UserInfo_State = UserInfo_State;
    }

    public int getUserType() {
        return UserType;
    }

    public void setUserType(int UserType) {
        this.UserType = UserType;
    }

    public int getLevel_Sort() {
        return Level_Sort;
    }

    public void setLevel_Sort(int Level_Sort) {
        this.Level_Sort = Level_Sort;
    }

    public int getUserInfo_Integer() {
        return UserInfo_Integer;
    }

    public void setUserInfo_Integer(int UserInfo_Integer) {
        this.UserInfo_Integer = UserInfo_Integer;
    }

    public double getUserInfo_Money() {
        return UserInfo_Money;
    }

    public void setUserInfo_Money(double UserInfo_Money) {
        this.UserInfo_Money = UserInfo_Money;
    }

    public int getUserInfo_TotalMoney() {
        return UserInfo_TotalMoney;
    }

    public void setUserInfo_TotalMoney(int UserInfo_TotalMoney) {
        this.UserInfo_TotalMoney = UserInfo_TotalMoney;
    }

    public int getUserInfo_ChilCount() {
        return UserInfo_ChilCount;
    }

    public void setUserInfo_ChilCount(int UserInfo_ChilCount) {
        this.UserInfo_ChilCount = UserInfo_ChilCount;
    }

    public boolean isUserInfo_IsProcess() {
        return UserInfo_IsProcess;
    }

    public void setUserInfo_IsProcess(boolean UserInfo_IsProcess) {
        this.UserInfo_IsProcess = UserInfo_IsProcess;
    }

    public String getUserInfo_HeadImg() {
        return UserInfo_HeadImg;
    }

    public void setUserInfo_HeadImg(String UserInfo_HeadImg) {
        this.UserInfo_HeadImg = UserInfo_HeadImg;
    }

    public String getUserInfo_ID() {
        return UserInfo_ID;
    }

    public void setUserInfo_ID(String UserInfo_ID) {
        this.UserInfo_ID = UserInfo_ID;
    }

    public String getUserInfo_Mobile() {
        return UserInfo_Mobile;
    }

    public void setUserInfo_Mobile(String UserInfo_Mobile) {
        this.UserInfo_Mobile = UserInfo_Mobile;
    }

    public String getUserInfo_CreateTime() {
        return UserInfo_CreateTime;
    }

    public void setUserInfo_CreateTime(String UserInfo_CreateTime) {
        this.UserInfo_CreateTime = UserInfo_CreateTime;
    }

    public String getUserInfo_Pwd() {
        return UserInfo_Pwd;
    }

    public void setUserInfo_Pwd(String UserInfo_Pwd) {
        this.UserInfo_Pwd = UserInfo_Pwd;
    }

    public String getUserInfo_NickName() {
        return UserInfo_NickName;
    }

    public void setUserInfo_NickName(String UserInfo_NickName) {
        this.UserInfo_NickName = UserInfo_NickName;
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
