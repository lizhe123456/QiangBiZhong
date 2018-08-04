package com.whmnrc.qiangbizhong.ui.shop.bean;

import com.whmnrc.qiangbizhong.model.bean.SpecBean;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/8/2.
 */

public class OrderBeanReq {

    private String spec;
    private String priceId;
    private String goodsId;
    private String price;
    private int count;

    private SpecBean.GoodsInfoBean goodsInfoBean;

    public OrderBeanReq() {
    }

    public OrderBeanReq(String spec, String priceId, String goodsId, String price, SpecBean.GoodsInfoBean goodsInfoBean,int count) {
        this.spec = spec;
        this.priceId = priceId;
        this.goodsId = goodsId;
        this.price = price;
        this.goodsInfoBean = goodsInfoBean;
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public String getPriceId() {
        return priceId;
    }

    public void setPriceId(String priceId) {
        this.priceId = priceId;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public SpecBean.GoodsInfoBean getGoodsInfoBean() {
        return goodsInfoBean;
    }

    public void setGoodsInfoBean(SpecBean.GoodsInfoBean goodsInfoBean) {
        this.goodsInfoBean = goodsInfoBean;
    }
}
