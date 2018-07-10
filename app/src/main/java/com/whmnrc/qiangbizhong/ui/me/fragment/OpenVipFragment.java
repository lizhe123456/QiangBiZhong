package com.whmnrc.qiangbizhong.ui.me.fragment;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseFragment;
import butterknife.BindView;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/9.
 * 会员充值
 */

public class OpenVipFragment extends BaseFragment {


    @BindView(R.id.tv_moeny)
    TextView tvMoeny;
    @BindView(R.id.tv_yue)
    TextView tvYue;
    @BindView(R.id.tv_rmb)
    TextView tvRmb;
    @BindView(R.id.tv_kegoumai)
    TextView tvKegoumai;
    @BindView(R.id.et_recharge)
    EditText etRecharge;

    public static OpenVipFragment newInstance() {
        Bundle args = new Bundle();
        OpenVipFragment fragment = new OpenVipFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_open_vip;
    }

    @Override
    protected void initData() {

    }


    @OnClick(R.id.btn_confirm)
    public void onViewClicked() {
    }
}
