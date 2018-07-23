package com.whmnrc.qiangbizhong.ui.me.fragment.order.goods;

import android.os.Bundle;

import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseFragment;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/23.
 * 下架商品
 */

public class UndercarriageFragment extends BaseFragment {


    public static UndercarriageFragment newInstance() {
        Bundle args = new Bundle();
        UndercarriageFragment fragment = new UndercarriageFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_undercarriage;
    }

    @Override
    protected void initData() {

    }
}
