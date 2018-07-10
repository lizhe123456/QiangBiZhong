package com.whmnrc.qiangbizhong.ui.home.fragment;

import android.os.Bundle;

import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseFragment;
import com.whmnrc.qiangbizhong.base.BasePresenter;
import com.whmnrc.qiangbizhong.base.BaseView;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/9.
 */

public class RuleFragment extends BaseFragment {


    public static RuleFragment newInstance() {
        Bundle args = new Bundle();
        RuleFragment fragment = new RuleFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_rule;
    }

    @Override
    protected void initData() {

    }

    @Override
    public BasePresenter createPresenter() {
        return null;
    }

    @Override
    public BaseView createView() {
        return null;
    }
}
