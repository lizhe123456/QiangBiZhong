package com.whmnrc.qiangbizhong.ui.yimei;

import android.os.Bundle;

import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseFragment;
import com.whmnrc.qiangbizhong.base.BasePresenter;
import com.whmnrc.qiangbizhong.base.BaseView;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/6.
 */

public class YiMeiFragment extends BaseFragment{


    public static YiMeiFragment newInstance() {
        Bundle args = new Bundle();
        YiMeiFragment fragment = new YiMeiFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_yimei;
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
