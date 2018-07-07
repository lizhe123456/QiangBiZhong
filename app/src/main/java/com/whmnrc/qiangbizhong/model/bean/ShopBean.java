package com.whmnrc.qiangbizhong.model.bean;

import com.whmnrc.qiangbizhong.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/7.
 */

public class ShopBean {

    private List<String> banners;
    private List<HomePageBean.MenuBean> menuBeans;
    private List<YiMeiBean.GoodsList> goodsLists;

    public void initYiMei(){
        List<String> list = new ArrayList<>();
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        this.banners = list;
        List<HomePageBean.MenuBean> menuBeans = new ArrayList<>();
        menuBeans.add(new HomePageBean.MenuBean(R.drawable.ic_shop_menu_1,"箱包"));
        menuBeans.add(new HomePageBean.MenuBean(R.drawable.ic_shop_menu_1,"汽车"));
        menuBeans.add(new HomePageBean.MenuBean(R.drawable.ic_shop_menu_2,"手机数码"));
        menuBeans.add(new HomePageBean.MenuBean(R.drawable.ic_shop_menu_1,"电器"));
        menuBeans.add(new HomePageBean.MenuBean(R.drawable.ic_shop_menu_4,"生活用品"));
        menuBeans.add(new HomePageBean.MenuBean(R.drawable.ic_shop_menu_5,"家居家纺"));
        menuBeans.add(new HomePageBean.MenuBean(R.drawable.ic_shop_menu_6,"珠宝配饰"));
        menuBeans.add(new HomePageBean.MenuBean(R.drawable.ic_shop_menu_7,"鞋靴"));
        menuBeans.add(new HomePageBean.MenuBean(R.drawable.ic_shop_menu_8,"运动户外"));
        menuBeans.add(new HomePageBean.MenuBean(R.drawable.ic_shop_menu_9,"美妆洗护"));
        menuBeans.add(new HomePageBean.MenuBean(R.drawable.ic_shop_menu_10,"女装"));
        menuBeans.add(new HomePageBean.MenuBean(R.drawable.ic_shop_menu_11,"男装"));
        menuBeans.add(new HomePageBean.MenuBean(R.drawable.ic_shop_menu_12,"母婴"));
        menuBeans.add(new HomePageBean.MenuBean(R.drawable.ic_shop_menu_13,"图书"));
        this.menuBeans = menuBeans;
        this.goodsLists =  new YiMeiBean.GoodsList().getList();
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

    public List<YiMeiBean.GoodsList> getGoodsLists() {
        return goodsLists;
    }

    public void setGoodsLists(List<YiMeiBean.GoodsList> goodsLists) {
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





}
