package com.whmnrc.qiangbizhong.ui.shopping.activity.param;

import java.util.List;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/8/2.
 * 上传参数
 */

public class EvaluateParam {


    /**
     * Order_ID : string
     * UserId : string
     * Goods_ID : string
     * GoodsPrice_ID : string
     * ImageContext : ["string"]
     * TextContext : string
     */

    private String Order_ID;
    private String UserId;
    private String Goods_ID;
    private String GoodsPrice_ID;
    private String TextContext;
    private List<String> ImageContext;

    public String getOrder_ID() {
        return Order_ID;
    }

    public void setOrder_ID(String Order_ID) {
        this.Order_ID = Order_ID;
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

    public String getTextContext() {
        return TextContext;
    }

    public void setTextContext(String TextContext) {
        this.TextContext = TextContext;
    }

    public List<String> getImageContext() {
        return ImageContext;
    }

    public void setImageContext(List<String> ImageContext) {
        this.ImageContext = ImageContext;
    }
}
