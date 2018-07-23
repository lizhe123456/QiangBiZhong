package com.whmnrc.qiangbizhong.ui.yimei.fragment;

import android.os.Bundle;

import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseFragment;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/23.
 */

public class PriceFragment extends BaseFragment{

    public static PriceFragment newInstance() {
        Bundle args = new Bundle();
        PriceFragment fragment = new PriceFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_price;
    }

    @Override
    protected void initData() {

    }
}
