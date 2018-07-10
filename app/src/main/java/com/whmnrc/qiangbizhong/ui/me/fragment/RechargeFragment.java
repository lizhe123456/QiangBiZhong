package com.whmnrc.qiangbizhong.ui.me.fragment;

import android.os.Bundle;

import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseFragment;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/9.
 */

public class RechargeFragment extends BaseFragment {


    public static RechargeFragment newInstance() {
        Bundle args = new Bundle();
        RechargeFragment fragment = new RechargeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_recharge;
    }

    @Override
    protected void initData() {

    }

}
