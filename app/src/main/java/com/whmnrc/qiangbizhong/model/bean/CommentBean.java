package com.whmnrc.qiangbizhong.model.bean;

import java.util.List;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/30.
 */

public class CommentBean {


    /**
     * Id : e829d43f-9799-40a6-89cc-1133b7890857
     * UserId : 0ca2dd15-dac7-45c6-8216-26b41ba68d85
     * Goods_ID : 142cb9af-a91f-40d5-8405-09268518123d
     * GoodsPrice_ID : 49e5277a-13c0-4e86-9ce8-9ae0af37bf04
     * CreateDate : 2018-07-14 00:00:00
     * ImageContext : ['/Resource/HeadImage/0ca2dd15-dac7-45c6-8216-26b41ba68d85.jpg']
     * TextContext :
     * UserInfo_NickName : 啦啦队长
     * UserInfo_HeadImg : http://192.168.1.157:8011/Resource/HeadImage/0ca2dd15-dac7-45c6-8216-26b41ba68d85.jpg
     * Images : ["http://192.168.1.157:8011/Resource/HeadImage/0ca2dd15-dac7-45c6-8216-26b41ba68d85.jpg"]
     */

    private String Id;
    private String UserId;
    private String Goods_ID;
    private String GoodsPrice_ID;
    private String CreateDate;
    private String ImageContext;
    private String TextContext;
    private String UserInfo_NickName;
    private String UserInfo_HeadImg;
    private List<String> Images;

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String UserId) {
        this.UserId = UserId;
    }

    public String getGoods_ID() {
        return Goods_ID;
    }

    public void setGoods_ID(String Goods_ID) {
        this.Goods_ID = Goods_ID;
    }

    public String getGoodsPrice_ID() {
        return GoodsPrice_ID;
    }

    public void setGoodsPrice_ID(String GoodsPrice_ID) {
        this.GoodsPrice_ID = GoodsPrice_ID;
    }

    public String getCreateDate() {
        return CreateDate;
    }

    public void setCreateDate(String CreateDate) {
        this.CreateDate = CreateDate;
    }

    public String getImageContext() {
        return ImageContext;
    }

    public void setImageContext(String ImageContext) {
        this.ImageContext = ImageContext;
    }

    public String getTextContext() {
        return TextContext;
    }

    public void setTextContext(String TextContext) {
        this.TextContext = TextContext;
    }

    public String getUserInfo_NickName() {
        return UserInfo_NickName;
    }

    public void setUserInfo_NickName(String UserInfo_NickName) {
        this.UserInfo_NickName = UserInfo_NickName;
    }

    public String getUserInfo_HeadImg() {
        return UserInfo_HeadImg;
    }

    public void setUserInfo_HeadImg(String UserInfo_HeadImg) {
        this.UserInfo_HeadImg = UserInfo_HeadImg;
    }

    public List<String> getImages() {
        return Images;
    }

    public void setImages(List<String> Images) {
        this.Images = Images;
    }
}
