package com.whmnrc.qiangbizhong.model.bean;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/8/14.
 */

public class NewsBean {

    /**
     * Notice_ID : 55372289-f23e-4a8e-942a-222b50bee0ed
     * Notice_Title : 用户；呵呵凉凉了 ，申请代付订单：S4640638522099144585 商品：韩式硅胶隆鼻
     * Notice_CreateTime : 2018-08-13 19:22:53
     * Notice_ReleaseTime : 2018-08-13 19:22:53
     * Notice_Content : null
     * Notice_Sort : 0
     * Type : 1
     * ObjectId : 5fd396c2-6755-405d-a201-257ff54299d0
     * ReceiveUserId : bda06fce-e199-47a9-9a45-6ee3c4fae39c
     * ReadStatus : 0
     */

    private String Notice_ID;
    private String Notice_Title;
    private String Notice_CreateTime;
    private String Notice_ReleaseTime;
    private Object Notice_Content;
    private int Notice_Sort;
    private int Type;
    private String ObjectId;
    private String ReceiveUserId;
    private int ReadStatus;
    private String GiveId;

    public String getGiveId() {
        return GiveId;
    }

    public void setGiveId(String giveId) {
        GiveId = giveId;
    }

    public String getNotice_ID() {
        return Notice_ID;
    }

    public void setNotice_ID(String Notice_ID) {
        this.Notice_ID = Notice_ID;
    }

    public String getNotice_Title() {
        return Notice_Title;
    }

    public void setNotice_Title(String Notice_Title) {
        this.Notice_Title = Notice_Title;
    }

    public String getNotice_CreateTime() {
        return Notice_CreateTime;
    }

    public void setNotice_CreateTime(String Notice_CreateTime) {
        this.Notice_CreateTime = Notice_CreateTime;
    }

    public String getNotice_ReleaseTime() {
        return Notice_ReleaseTime;
    }

    public void setNotice_ReleaseTime(String Notice_ReleaseTime) {
        this.Notice_ReleaseTime = Notice_ReleaseTime;
    }

    public Object getNotice_Content() {
        return Notice_Content;
    }

    public void setNotice_Content(Object Notice_Content) {
        this.Notice_Content = Notice_Content;
    }

    public int getNotice_Sort() {
        return Notice_Sort;
    }

    public void setNotice_Sort(int Notice_Sort) {
        this.Notice_Sort = Notice_Sort;
    }

    public int getType() {
        return Type;
    }

    public void setType(int Type) {
        this.Type = Type;
    }

    public String getObjectId() {
        return ObjectId;
    }

    public void setObjectId(String ObjectId) {
        this.ObjectId = ObjectId;
    }

    public String getReceiveUserId() {
        return ReceiveUserId;
    }

    public void setReceiveUserId(String ReceiveUserId) {
        this.ReceiveUserId = ReceiveUserId;
    }

    public int getReadStatus() {
        return ReadStatus;
    }

    public void setReadStatus(int ReadStatus) {
        this.ReadStatus = ReadStatus;
    }
}
