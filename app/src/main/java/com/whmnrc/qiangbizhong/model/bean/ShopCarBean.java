package com.whmnrc.qiangbizhong.model.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/7.
 */

public class ShopCarBean {

    private String name;
    private List<GoodsBean> goodsBeans;

    private List<ShopCarBean> list;

    public List<ShopCarBean> getList() {
        return list;
    }

    public void initShopCar(){
        List<ShopCarBean> shopCarBeans = new ArrayList<>();
        List<GoodsBean> goodsBeans = new ArrayList<>();
        List<String> stringList = new ArrayList<>();
        stringList.add("黑色");
        stringList.add("绿色");
        stringList.add("紫色");
        stringList.add("红色");
        goodsBeans.add(new GoodsBean("",20,0,"红色",stringList,"人字拖",500));
        goodsBeans.add(new GoodsBean("",20,0,"红色",stringList,"黄金人字拖",1500));
        shopCarBeans.add(new ShopCarBean("李哲的店",goodsBeans));
        List<GoodsBean> goodsBeans1 = new ArrayList<>();
        List<String> stringList2 = new ArrayList<>();
        stringList.add("黑色");
        stringList.add("绿色");
        stringList.add("紫色");
        stringList.add("红色");
        goodsBeans.add(new GoodsBean("",20,0,"红色",stringList2,"人字拖",500));
        goodsBeans.add(new GoodsBean("",20,0,"红色",stringList2,"黄金人字拖",1500));
        goodsBeans.add(new GoodsBean("",20,0,"红色",stringList2,"白金人字拖",2000));
        goodsBeans.add(new GoodsBean("",20,0,"红色",stringList2,"镶砖人字拖",3000));
        shopCarBeans.add(new ShopCarBean("李哲的2号店",goodsBeans1));
        List<GoodsBean> goodsBeans2 = new ArrayList<>();
        List<String> stringList3 = new ArrayList<>();
        stringList.add("黑色");
        stringList.add("绿色");
        stringList.add("紫色");
        stringList.add("土豪金");
        goodsBeans.add(new GoodsBean("",20,0,"红色",stringList3,"镶砖人字拖",3000));
        shopCarBeans.add(new ShopCarBean("李哲的3号店",goodsBeans2));
        this.list = shopCarBeans;
    }

    public ShopCarBean(String name, List<GoodsBean> goodsBeans) {
        this.name = name;
        this.goodsBeans = goodsBeans;
    }

    public ShopCarBean() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<GoodsBean> getGoodsBeans() {
        return goodsBeans;
    }

    public void setGoodsBeans(List<GoodsBean> goodsBeans) {
        this.goodsBeans = goodsBeans;
    }

    public class GoodsBean{
        String url;
        int goodsNum;
        int isCollection;
        String specifications;
        List<String> specificationsList;
        String goodsName;
        int price;

        public GoodsBean(String url, int goodsNum, int isCollection, String specifications, List<String> specificationsList, String goodsName, int price) {
            this.url = url;
            this.goodsNum = goodsNum;
            this.isCollection = isCollection;
            this.specifications = specifications;
            this.specificationsList = specificationsList;
            this.goodsName = goodsName;
            this.price = price;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public int getGoodsNum() {
            return goodsNum;
        }

        public void setGoodsNum(int goodsNum) {
            this.goodsNum = goodsNum;
        }

        public int getIsCollection() {
            return isCollection;
        }

        public void setIsCollection(int isCollection) {
            this.isCollection = isCollection;
        }

        public String getSpecifications() {
            return specifications;
        }

        public void setSpecifications(String specifications) {
            this.specifications = specifications;
        }

        public List<String> getSpecificationsList() {
            return specificationsList;
        }

        public void setSpecificationsList(List<String> specificationsList) {
            this.specificationsList = specificationsList;
        }

        public String getGoodsName() {
            return goodsName;
        }

        public void setGoodsName(String goodsName) {
            this.goodsName = goodsName;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }
    }

}
