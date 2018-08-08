package com.whmnrc.qiangbizhong.model.bean;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/8/7.
 */

public class EditBannerBean {


    /**
     * Img_ID : 0a7ba22d-f5dd-4cf8-bf2a-b42be7e6c5c0
     * Object_ID : 51570444-9d95-42e7-a9c2-667299d82dc6
     * Img_Path : http://192.168.1.157:8011/Resource/PhotoFile/445354fd-bfb0-40f0-b7a1-0e4973096e26.jpg
     * Img_Sort : 3
     * Img_Type : 0
     */

    private String Img_ID;
    private String Object_ID;
    private String Img_Path;
    private int Img_Sort;
    private int Img_Type;

    public EditBannerBean() {
    }

    public EditBannerBean(String img_Path) {
        Img_Path = img_Path;
    }

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
