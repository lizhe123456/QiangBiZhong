package com.whmnrc.qiangbizhong.ui.me.fragment.collection;

import android.os.Bundle;

import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseFragment;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/23.
 */

public class ShopCollectionFragment extends BaseFragment{

    public static ShopCollectionFragment newInstance() {
        Bundle args = new Bundle();
        ShopCollectionFragment fragment = new ShopCollectionFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_shop_collection;
    }

    @Override
    protected void initData() {

    }
}
