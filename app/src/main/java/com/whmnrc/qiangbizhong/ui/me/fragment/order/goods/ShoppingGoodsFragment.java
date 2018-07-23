package com.whmnrc.qiangbizhong.ui.me.fragment.order.goods;

import android.os.Bundle;

import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseFragment;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/23.
 * 上架商品
 */

public class ShoppingGoodsFragment extends BaseFragment{


    public static ShoppingGoodsFragment newInstance() {
        Bundle args = new Bundle();
        ShoppingGoodsFragment fragment = new ShoppingGoodsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_shopping_goods;
    }

    @Override
    protected void initData() {

    }
}
