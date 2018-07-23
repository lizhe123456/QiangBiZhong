package com.whmnrc.qiangbizhong.ui.me.fragment.collection;

import android.os.Bundle;

import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseFragment;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/23.
 */

public class GoodsCollectionFragment extends BaseFragment{


    public static GoodsCollectionFragment newInstance() {
        Bundle args = new Bundle();
        GoodsCollectionFragment fragment = new GoodsCollectionFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_goods_collection;
    }

    @Override
    protected void initData() {

    }
}
