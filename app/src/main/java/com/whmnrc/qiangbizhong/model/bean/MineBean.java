package com.whmnrc.qiangbizhong.model.bean;

import com.whmnrc.qiangbizhong.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/7.
 */

public class MineBean {

    private List<MenuBean> menuBeans;
    private List<ItemBean> itemBeans;

    public List<MenuBean> getMenuBeans() {
        return menuBeans;
    }

    public void setMenuBeans(List<MenuBean> menuBeans) {
        this.menuBeans = menuBeans;
    }

    public List<ItemBean> getItemBeans() {
        return itemBeans;
    }

    public void setItemBeans(List<ItemBean> itemBeans) {
        this.itemBeans = itemBeans;
    }

    public void initMineBean(int type){
        List<MenuBean> menuBeans= new ArrayList<>();
        List<ItemBean> itemBeans = new ArrayList<>();
        if (type == 2) {
            itemBeans.add(new ItemBean(R.drawable.ic_san_san, "扫一扫"));
        }

        itemBeans.add(new ItemBean(R.drawable.ic_item1, "赠送记录"));
        itemBeans.add(new ItemBean(R.drawable.ic_item2, "我的抵用券"));

        if (type == 0) {
            itemBeans.add(new ItemBean(R.drawable.ic_item3, "我要入驻"));
        }else if (type == 1){
            itemBeans.add(new ItemBean(R.drawable.ic_item4, "我是代理商"));
        }else if (type == 2){
            itemBeans.add(new ItemBean(R.drawable.ic_item3, "商品发布"));
        }else if (type == 3){
        }

        itemBeans.add(new ItemBean(R.drawable.ic_item5, "充值"));
        itemBeans.add(new ItemBean(R.drawable.ic_item6, "我的收藏"));
        itemBeans.add(new ItemBean(R.drawable.ic_item7, "收货信息"));
        itemBeans.add(new ItemBean(R.drawable.ic_item8, "意见反馈"));
        itemBeans.add(new ItemBean(R.drawable.ic_item9, "设置"));
        this.itemBeans = itemBeans;
        List<HomePageBean.MenuBean> list = new ArrayList<>();
        list.add(new HomePageBean.MenuBean(R.drawable.ic_send_goods,"待发货"));
        list.add(new HomePageBean.MenuBean(R.drawable.ic_pending_delivery,"已发货"));
        list.add(new HomePageBean.MenuBean(R.drawable.ic_wait_evaluate,"待评价"));
        list.add(new HomePageBean.MenuBean(R.drawable.ic_wait_evaluate,"已完成"));
        menuBeans.add(new MenuBean("我的订单","全部订单",list));
        if (type == 2){
            List<HomePageBean.MenuBean> list1 = new ArrayList<>();
//            list1.add(new HomePageBean.MenuBean(R.drawable.ic_to_examine,"审核中"));
            list1.add(new HomePageBean.MenuBean(R.drawable.ic_on_sale,"已上架"));
            list1.add(new HomePageBean.MenuBean(R.drawable.ic_already_sold,"已售空"));
            list1.add(new HomePageBean.MenuBean(R.drawable.ic_already_down,"已下架"));
//            list1.add(new HomePageBean.MenuBean(R.drawable.ic_already_sold,"已出售"));

            menuBeans.add(new MenuBean("商品管理","所有商品",list1));
            List<HomePageBean.MenuBean> list2 = new ArrayList<>();
            list2.add(new HomePageBean.MenuBean(R.drawable.ic_pending_payment,"已支付"));
            list2.add(new HomePageBean.MenuBean(R.drawable.ic_in_the_transaction,"待收货"));
            list2.add(new HomePageBean.MenuBean(R.drawable.ic_successful_trade,"已完成"));
            list2.add(new HomePageBean.MenuBean(R.drawable.ic_transaction_cancellation,"待退款"));
            menuBeans.add(new MenuBean("商家管理","全部订单",list2));
        }
        this.menuBeans = menuBeans;
    }

    public class MenuBean{
        String name;
        String more;
        List<HomePageBean.MenuBean> list;

        private MenuBean(String name, String more, List<HomePageBean.MenuBean> list) {
            this.name = name;
            this.more = more;
            this.list = list;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getMore() {
            return more;
        }

        public void setMore(String more) {
            this.more = more;
        }

        public List<HomePageBean.MenuBean> getList() {
            return list;
        }

        public void setList(List<HomePageBean.MenuBean> list) {
            this.list = list;
        }
    }

    public class ItemBean{
        int redId;
        String name;

        private ItemBean(int redId, String name) {
            this.redId = redId;
            this.name = name;
        }

        public int getRedId() {
            return redId;
        }

        public void setRedId(int redId) {
            this.redId = redId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
