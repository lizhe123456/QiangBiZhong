package com.whmnrc.qiangbizhong.ui.me.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.TextView;

import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseFragment;
import com.whmnrc.qiangbizhong.model.bean.RechargeBean;
import com.whmnrc.qiangbizhong.presenter.me.RechargePresenter;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/9.
 * 会员充值
 */

public class OpenVipFragment extends BaseFragment implements RechargePresenter.RechargeCall {


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

    RechargePresenter rechargePresenter;

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
        RechargePresenter rechargePresenter = new RechargePresenter(getContext());
        rechargePresenter.rechargeQuery(1, this);
    }

    @Override
    public void rechargeBack() {
        rechargePresenter.rechargeQuery(1, this);
    }

    @Override
    public void rechargeData(RechargeBean rechargeBean) {
        tvMoeny.setText(rechargeBean.getGoodsPrice_Stock()+"");
        tvRmb.setText(rechargeBean.getPrice()+"");
        tvKegoumai.setText(rechargeBean.getCanPayCount()+"");

    }

    @OnClick(R.id.btn_confirm)
    public void onViewClicked() {
        if (TextUtils.isEmpty(etRecharge.getText().toString().trim())){
            showLoading("充值中..");
            rechargePresenter.submitorder(etRecharge.getText().toString().trim(),"1","","");
        }
    }


}
