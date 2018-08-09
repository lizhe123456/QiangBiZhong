package com.whmnrc.qiangbizhong.model.parameter;

/**
 * Created by admin on 2018/8/9.
 */

public class BannerParam {


    public BannerParam(String goodsId, String url, int sort) {
        GoodsId = goodsId;
        Url = url;
        Sort = sort;
    }

    /**
     * GoodsId : string
     * Url : string
     * Sort : 0
     */


    private String GoodsId;
    private String Url;
    private int Sort;

    public String getGoodsId() {
        return GoodsId;
    }

    public void setGoodsId(String GoodsId) {
        this.GoodsId = GoodsId;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String Url) {
        this.Url = Url;
    }

    public int getSort() {
        return Sort;
    }

    public void setSort(int Sort) {
        this.Sort = Sort;
    }
}
