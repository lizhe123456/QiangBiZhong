package com.whmnrc.qiangbizhong.ui.yimei.fragment;

import android.os.Bundle;

import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseFragment;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/23.
 */

public class SalesVolumeFragment extends BaseFragment{


    public static SalesVolumeFragment newInstance() {
        Bundle args = new Bundle();
        SalesVolumeFragment fragment = new SalesVolumeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_sales_volume;
    }

    @Override
    protected void initData() {

    }
}
