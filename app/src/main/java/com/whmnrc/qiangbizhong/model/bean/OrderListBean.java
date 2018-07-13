package com.whmnrc.qiangbizhong.model.bean;

import java.util.List;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/11.
 * Order_CreateType 0 商城商品订单 1抢购订单 2抽奖订单 3医美服务订单
 */

public class OrderListBean {

    int type;

    int Order_CreateType;

    String name;

    List<GoodsBean> goodsBeans;


    public OrderListBean(int type, int order_CreateType, String name, List<GoodsBean> goodsBeans) {
        this.type = type;
        Order_CreateType = order_CreateType;
        this.name = name;
        this.goodsBeans = goodsBeans;
    }

    public int getOrder_CreateType() {
        return Order_CreateType;
    }

    public void setOrder_CreateType(int order_CreateType) {
        Order_CreateType = order_CreateType;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
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

    public class GoodsBean {
        String name;
        String url;
        String price;
        int num;
        String desc;

        public GoodsBean(String name, String url, String price, int num, String desc) {
            this.name = name;
            this.url = url;
            this.price = price;
            this.num = num;
            this.desc = desc;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }
    }
}
