package com.whmnrc.qiangbizhong.ui.me.fragment.shop;

import android.os.Bundle;

import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseFragment;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/23.
 */

public class GoodsInfoFragment extends BaseFragment{


    public static GoodsInfoFragment newInstance() {
        Bundle args = new Bundle();
        GoodsInfoFragment fragment = new GoodsInfoFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_goods_info;
    }

    @Override
    protected void initData() {

    }
}
