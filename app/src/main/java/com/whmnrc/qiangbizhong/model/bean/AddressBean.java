package com.whmnrc.qiangbizhong.model.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/10.
 */

public class AddressBean implements Parcelable {


    /**
     * Address_ID : 7d866de7-e627-45ec-970d-fec7fcecbd06
     * Address_Mobile : 17688943972
     * Address_Name : 李哲
     * Address_Provice : 350000
     * Address_City : 350100
     * Address_Region : 350102
     * Address_Detail : 呵呵
     * Address_CreateTime : 2018-07-13 17:59:39
     * UserInfo_ID : bda06fce-e199-47a9-9a45-6ee3c4fae39c
     * Address_IsDefault : 1
     * ProviceName : 福建省
     * CityName : 福州市
     * RegionName : 鼓楼区
     */

    private String Address_ID;
    private String Address_Mobile;
    private String Address_Name;
    private String Address_Provice;
    private String Address_City;
    private String Address_Region;
    private String Address_Detail;
    private String Address_CreateTime;
    private String UserInfo_ID;
    private int Address_IsDefault;
    private String ProviceName;
    private String CityName;
    private String RegionName;

    protected AddressBean(Parcel in) {
        Address_ID = in.readString();
        Address_Mobile = in.readString();
        Address_Name = in.readString();
        Address_Provice = in.readString();
        Address_City = in.readString();
        Address_Region = in.readString();
        Address_Detail = in.readString();
        Address_CreateTime = in.readString();
        UserInfo_ID = in.readString();
        Address_IsDefault = in.readInt();
        ProviceName = in.readString();
        CityName = in.readString();
        RegionName = in.readString();
    }

    public static final Creator<AddressBean> CREATOR = new Creator<AddressBean>() {
        @Override
        public AddressBean createFromParcel(Parcel in) {
            return new AddressBean(in);
        }

        @Override
        public AddressBean[] newArray(int size) {
            return new AddressBean[size];
        }
    };

    public String getAddress_ID() {
        return Address_ID;
    }

    public void setAddress_ID(String Address_ID) {
        this.Address_ID = Address_ID;
    }

    public String getAddress_Mobile() {
        return Address_Mobile;
    }

    public void setAddress_Mobile(String Address_Mobile) {
        this.Address_Mobile = Address_Mobile;
    }

    public String getAddress_Name() {
        return Address_Name;
    }

    public void setAddress_Name(String Address_Name) {
        this.Address_Name = Address_Name;
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

    public String getAddress_CreateTime() {
        return Address_CreateTime;
    }

    public void setAddress_CreateTime(String Address_CreateTime) {
        this.Address_CreateTime = Address_CreateTime;
    }

    public String getUserInfo_ID() {
        return UserInfo_ID;
    }

    public void setUserInfo_ID(String UserInfo_ID) {
        this.UserInfo_ID = UserInfo_ID;
    }

    public int getAddress_IsDefault() {
        return Address_IsDefault;
    }

    public void setAddress_IsDefault(int Address_IsDefault) {
        this.Address_IsDefault = Address_IsDefault;
    }

    public String getProviceName() {
        return ProviceName;
    }

    public void setProviceName(String ProviceName) {
        this.ProviceName = ProviceName;
    }

    public String getCityName() {
        return CityName;
    }

    public void setCityName(String CityName) {
        this.CityName = CityName;
    }

    public String getRegionName() {
        return RegionName;
    }

    public void setRegionName(String RegionName) {
        this.RegionName = RegionName;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(Address_ID);
        dest.writeString(Address_Mobile);
        dest.writeString(Address_Name);
        dest.writeString(Address_Provice);
        dest.writeString(Address_City);
        dest.writeString(Address_Region);
        dest.writeString(Address_Detail);
        dest.writeString(Address_CreateTime);
        dest.writeString(UserInfo_ID);
        dest.writeInt(Address_IsDefault);
        dest.writeString(ProviceName);
        dest.writeString(CityName);
        dest.writeString(RegionName);
    }
}
