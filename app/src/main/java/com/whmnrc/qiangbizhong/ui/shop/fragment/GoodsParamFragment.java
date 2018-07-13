package com.whmnrc.qiangbizhong.ui.shop.fragment;

import android.os.Bundle;

import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseFragment;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/11.
 */

public class GoodsParamFragment extends BaseFragment {

    public static GoodsParamFragment newInstance() {
        Bundle args = new Bundle();
        GoodsParamFragment fragment = new GoodsParamFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_goods_param;
    }

    @Override
    protected void initData() {

    }
}
