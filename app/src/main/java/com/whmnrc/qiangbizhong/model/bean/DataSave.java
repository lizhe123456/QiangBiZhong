package com.whmnrc.qiangbizhong.model.bean;

import com.whmnrc.qiangbizhong.ui.shop.shopenter.ShopEnterP;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/8/7.
 */

public class DataSave {

    private static ShopEnterP shopEnterP1;

    public static void setValue(ShopEnterP shopEnterP){
        shopEnterP1 = shopEnterP;
    }

    public static ShopEnterP getValue(){
        return shopEnterP1;
    }


}
