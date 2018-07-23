package com.whmnrc.qiangbizhong.ui.me.fragment.order.goods;

import android.os.Bundle;

import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseFragment;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/23.
 */

public class AllGoodsFragment extends BaseFragment {


    public static AllGoodsFragment newInstance() {
        Bundle args = new Bundle();
        AllGoodsFragment fragment = new AllGoodsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_all_goods;
    }

    @Override
    protected void initData() {

    }
}
