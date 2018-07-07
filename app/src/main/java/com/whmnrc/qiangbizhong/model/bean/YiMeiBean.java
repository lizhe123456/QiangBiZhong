package com.whmnrc.qiangbizhong.model.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/7.
 */

public class YiMeiBean {

    private List<String> banners;
    private List<HomePageBean.MenuBean> menuBeans;
    private List<GoodsList> goodsLists;

    public void initYiMei(){
        List<String> list = new ArrayList<>();
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        this.banners = list;
        List<HomePageBean.MenuBean> menuBeans = new ArrayList<>();
        menuBeans.add(new HomePageBean.MenuBean("","水光针0"));
        menuBeans.add(new HomePageBean.MenuBean("","水光针1"));
        menuBeans.add(new HomePageBean.MenuBean("","水光针2"));
        menuBeans.add(new HomePageBean.MenuBean("","水光针3"));
        menuBeans.add(new HomePageBean.MenuBean("","水光针4"));
        menuBeans.add(new HomePageBean.MenuBean("","水光针5"));
        menuBeans.add(new HomePageBean.MenuBean("","水光针6"));
        menuBeans.add(new HomePageBean.MenuBean("","水光针7"));
        menuBeans.add(new HomePageBean.MenuBean("","水光针8"));
        menuBeans.add(new HomePageBean.MenuBean("","水光针9"));
        menuBeans.add(new HomePageBean.MenuBean("","水光针1"));
        menuBeans.add(new HomePageBean.MenuBean("","水光针1"));
        menuBeans.add(new HomePageBean.MenuBean("","水光针1"));
        menuBeans.add(new HomePageBean.MenuBean("","水光针1"));
        menuBeans.add(new HomePageBean.MenuBean("","水光针1"));
        menuBeans.add(new HomePageBean.MenuBean("","水光针1"));
        menuBeans.add(new HomePageBean.MenuBean("","水光针1"));
        menuBeans.add(new HomePageBean.MenuBean("","水光针1"));
        menuBeans.add(new HomePageBean.MenuBean("","水光针2"));
        menuBeans.add(new HomePageBean.MenuBean("","水光针2"));
        menuBeans.add(new HomePageBean.MenuBean("","水光针2"));
        menuBeans.add(new HomePageBean.MenuBean("","水光针2"));
        menuBeans.add(new HomePageBean.MenuBean("","水光针2"));
        this.menuBeans = menuBeans;
        this.goodsLists =  new GoodsList().getList();
    }

    public List<String> getBanners() {
        return banners;
    }

    public void setBanners(List<String> banners) {
        this.banners = banners;
    }

    public List<HomePageBean.MenuBean> getMenuBeans() {
        return menuBeans;
    }

    public void setMenuBeans(List<HomePageBean.MenuBean> menuBeans) {
        this.menuBeans = menuBeans;
    }

    public List<GoodsList> getGoodsLists() {
        return goodsLists;
    }

    public void setGoodsLists(List<GoodsList> goodsLists) {
        this.goodsLists = goodsLists;
    }

    public class MenuBean{
        String url;
        String name;

        public MenuBean(String url, String name) {
            this.url = url;
            this.name = name;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static class GoodsList{
        String url;
        List<HomePageBean.GoodsBean> goodsBeans;

        public GoodsList(String url, List<HomePageBean.GoodsBean> goodsBeans) {
            this.url = url;
            this.goodsBeans = goodsBeans;
        }

        public GoodsList() {
        }

        public List<GoodsList> getList(){
            List<GoodsList> lists = new ArrayList<>();
            List<HomePageBean.GoodsBean> goodsBeans = new ArrayList<>();
            goodsBeans.add(new HomePageBean.GoodsBean("","455","955"));
            goodsBeans.add(new HomePageBean.GoodsBean("","455","955"));
            goodsBeans.add(new HomePageBean.GoodsBean("","455","955"));
            goodsBeans.add(new HomePageBean.GoodsBean("","455","955"));
            goodsBeans.add(new HomePageBean.GoodsBean("","455","955"));
            goodsBeans.add(new HomePageBean.GoodsBean("","455","955"));
            goodsBeans.add(new HomePageBean.GoodsBean("","455","955"));
            goodsBeans.add(new HomePageBean.GoodsBean("","455","955"));
            GoodsList goodsList = new GoodsList("",goodsBeans);
            lists.add(goodsList);
            lists.add(goodsList);
            lists.add(goodsList);
            lists.add(goodsList);
            return lists;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public List<HomePageBean.GoodsBean> getGoodsBeans() {
            return goodsBeans;
        }

        public void setGoodsBeans(List<HomePageBean.GoodsBean> goodsBeans) {
            this.goodsBeans = goodsBeans;
        }
    }
}
