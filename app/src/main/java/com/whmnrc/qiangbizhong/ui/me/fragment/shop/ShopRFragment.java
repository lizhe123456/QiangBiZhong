package com.whmnrc.qiangbizhong.ui.me.fragment.shop;

import android.os.Bundle;

import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseFragment;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/23.
 */

public class ShopRFragment extends BaseFragment{


    public static ShopRFragment newInstance() {
        Bundle args = new Bundle();
        ShopRFragment fragment = new ShopRFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_shop_r;
    }

    @Override
    protected void initData() {

    }
}
