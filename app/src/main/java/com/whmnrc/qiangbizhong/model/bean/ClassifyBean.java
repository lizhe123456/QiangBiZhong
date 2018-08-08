package com.whmnrc.qiangbizhong.model.bean;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/8/7.
 */

public class ClassifyBean {


    /**
     * Id : 94dfa9cc-3d03-4524-af07-8e401a24875d
     * TypeName : 手机数码
     * ParentId : 0
     * Describe : 手机数码
     * Keyword : 手机数码
     * Image_url : /Resource/PhotoFile/a1043429-bab6-4fdf-8781-68c99502602e.png
     * Sort : 0
     * Status : 1
     */

    private String Id;
    private String TypeName;
    private String ParentId;
    private String Describe;
    private String Keyword;
    private String Image_url;
    private int Sort;
    private int Status;

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getTypeName() {
        return TypeName;
    }

    public void setTypeName(String TypeName) {
        this.TypeName = TypeName;
    }

    public String getParentId() {
        return ParentId;
    }

    public void setParentId(String ParentId) {
        this.ParentId = ParentId;
    }

    public String getDescribe() {
        return Describe;
    }

    public void setDescribe(String Describe) {
        this.Describe = Describe;
    }

    public String getKeyword() {
        return Keyword;
    }

    public void setKeyword(String Keyword) {
        this.Keyword = Keyword;
    }

    public String getImage_url() {
        return Image_url;
    }

    public void setImage_url(String Image_url) {
        this.Image_url = Image_url;
    }

    public int getSort() {
        return Sort;
    }

    public void setSort(int Sort) {
        this.Sort = Sort;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int Status) {
        this.Status = Status;
    }
}
