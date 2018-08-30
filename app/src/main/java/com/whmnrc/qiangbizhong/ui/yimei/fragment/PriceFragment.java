package com.whmnrc.qiangbizhong.ui.yimei.fragment;

import android.os.Bundle;

import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseFragment;
import com.whmnrc.qiangbizhong.presenter.yimei.StorePresenter;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/23.
 */

public class PriceFragment extends BaseFragment{

    private StorePresenter storePresenter;

    public static PriceFragment newInstance() {
        Bundle args = new Bundle();
        PriceFragment fragment = new PriceFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_sales_volume;
    }

    @Override
    protected void initData() {
        storePresenter = new StorePresenter(getActivity());
    }
}
