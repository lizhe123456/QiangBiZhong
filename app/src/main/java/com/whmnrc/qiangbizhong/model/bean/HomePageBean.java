package com.whmnrc.qiangbizhong.model.bean;

import com.whmnrc.qiangbizhong.R;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/6.
 */

public class HomePageBean {

    private List<String> banner;
    private List<MenuBean> menuBeans;
    private SecondKillBean secondKillBean;
    private List<NewUnveiled> newUnveileds;
    private List<LuckDrawBean> luckDrawBeans;
    private List<GoodsBean> goodsBeans;

    public HomePageBean intiHome(){
        HomePageBean homePageBean = new HomePageBean();
        List<String> banners = new ArrayList<>();
        banners.add("");
        banners.add("");
        banners.add("");
        banners.add("");
        homePageBean.banner = banners;
        List<MenuBean> menuBeans = new ArrayList<>();
        menuBeans.add(new MenuBean(R.drawable.ic_recharge,"账户充值"));
        menuBeans.add(new MenuBean(R.drawable.ic_luck_draw,"抽奖专区"));
        menuBeans.add(new MenuBean(R.drawable.ic_second_kill,"秒杀专区"));
        menuBeans.add(new MenuBean(R.drawable.ic_open_prize,"最新揭晓"));
        menuBeans.add(new MenuBean(R.drawable.ic_record,"抢购记录"));
        homePageBean.menuBeans = menuBeans;
        List<GoodsBean> list = new ArrayList<>();
        list.add(new GoodsBean("","一号拖鞋","4000"));
        list.add(new GoodsBean("","二号拖鞋","5333"));
        list.add(new GoodsBean("","三号拖鞋","5333"));
        list.add(new GoodsBean("","四号拖鞋","5333"));
        list.add(new GoodsBean("","五号拖鞋","5333"));
        list.add(new GoodsBean("","六号拖鞋","5333"));
        homePageBean.secondKillBean = new SecondKillBean(list,3213213);
        List<NewUnveiled> newUnveileds = new ArrayList<>();
        newUnveileds.add(new NewUnveiled("","至尊版拖鞋",15634,123456));
        newUnveileds.add(new NewUnveiled("","至尊版拖鞋",15634,123456));
        newUnveileds.add(new NewUnveiled("","至尊版拖鞋",15634,123456));
        newUnveileds.add(new NewUnveiled("","至尊版拖鞋",15634,123456));
        newUnveileds.add(new NewUnveiled("","至尊版拖鞋",15634,123456));
        List<LuckDrawBean> luckDrawBeans = new ArrayList<>();
        luckDrawBeans.add(new LuckDrawBean("","哈哈5",5000,2006,0));
        luckDrawBeans.add(new LuckDrawBean("","哈哈4",5000,2006,0));
        luckDrawBeans.add(new LuckDrawBean("","哈哈3",5000,2006,0));
        luckDrawBeans.add(new LuckDrawBean("","哈哈2",5000,2006,0));
        luckDrawBeans.add(new LuckDrawBean("","哈哈1",5000,2006,0));
        List<GoodsBean> goodsBeans = new ArrayList<>();
        goodsBeans.add(new GoodsBean("","呵呵1","603"));
        goodsBeans.add(new GoodsBean("","呵呵9","605"));
        goodsBeans.add(new GoodsBean("","呵呵26","606"));
        goodsBeans.add(new GoodsBean("","呵呵2","600"));
        goodsBeans.add(new GoodsBean("","呵呵2","600"));
        goodsBeans.add(new GoodsBean("","呵呵2","600"));
        goodsBeans.add(new GoodsBean("","呵呵2","600"));

        homePageBean.newUnveileds = newUnveileds;
        homePageBean.luckDrawBeans = luckDrawBeans;
        homePageBean.goodsBeans = goodsBeans;
       return homePageBean;
    }

    public List<String> getBanner() {
        return banner;
    }

    public void setBanner(List<String> banner) {
        this.banner = banner;
    }

    public List<MenuBean> getMenuBeans() {
        return menuBeans;
    }

    public void setMenuBeans(List<MenuBean> menuBeans) {
        this.menuBeans = menuBeans;
    }

    public SecondKillBean getSecondKillBean() {
        return secondKillBean;
    }

    public void setSecondKillBean(SecondKillBean secondKillBean) {
        this.secondKillBean = secondKillBean;
    }

    public List<NewUnveiled> getNewUnveileds() {
        return newUnveileds;
    }

    public void setNewUnveileds(List<NewUnveiled> newUnveileds) {
        this.newUnveileds = newUnveileds;
    }

    public List<LuckDrawBean> getLuckDrawBeans() {
        return luckDrawBeans;
    }

    public void setLuckDrawBeans(List<LuckDrawBean> luckDrawBeans) {
        this.luckDrawBeans = luckDrawBeans;
    }

    public List<GoodsBean> getGoodsBeans() {
        return goodsBeans;
    }

    public void setGoodsBeans(List<GoodsBean> goodsBeans) {
        this.goodsBeans = goodsBeans;
    }

    public static class MenuBean{
        int resId;
        String url;

        String text;

        public MenuBean(int resId, String text) {
            this.resId = resId;
            this.text = text;
        }

        public MenuBean(String url, String text) {
            this.url = url;
            this.text = text;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public int getResId() {
            return resId;
        }

        public void setResId(int resId) {
            this.resId = resId;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
    }

    //秒杀
    public class SecondKillBean{
        List<GoodsBean> list;
        long time;

        public SecondKillBean(List<GoodsBean> list, long time) {
            this.list = list;
            this.time = time;
        }

        public List<GoodsBean> getList() {
            return list;
        }

        public void setList(List<GoodsBean> list) {
            this.list = list;
        }

        public long getTime() {
            return time;
        }

        public void setTime(long time) {
            this.time = time;
        }
    }

    //最新揭晓
    public class NewUnveiled{
        String url;
        String name;
        int participateIn;
        int time;

        public NewUnveiled(String url, String name, int participateIn, int time) {
            this.url = url;
            this.name = name;
            this.participateIn = participateIn;
            this.time = time;
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

        public int getParticipateIn() {
            return participateIn;
        }

        public void setParticipateIn(int participateIn) {
            this.participateIn = participateIn;
        }

        public int getTime() {
            return time;
        }

        public void setTime(int time) {
            this.time = time;
        }
    }

    //最新抽奖
    public class LuckDrawBean{
        String url;
        String name;
        int total;
        int participateIn;
        int surplus;

        public LuckDrawBean(String url, String name, int total, int participateIn, int surplus) {
            this.url = url;
            this.name = name;
            this.total = total;
            this.participateIn = participateIn;
            this.surplus = surplus;
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

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public int getParticipateIn() {
            return participateIn;
        }

        public void setParticipateIn(int participateIn) {
            this.participateIn = participateIn;
        }

        public int getSurplus() {
            return surplus;
        }

        public void setSurplus(int surplus) {
            this.surplus = surplus;
        }
    }


    //为你推荐
    public static class GoodsBean{
        String url;
        String name;
        String money;


        public GoodsBean(String url, String name, String money) {
            this.url = url;
            this.name = name;
            this.money = money;
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

        public String getMoney() {
            return money;
        }

        public void setMoney(String money) {
            this.money = money;
        }
    }



}
