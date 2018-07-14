package com.whmnrc.qiangbizhong.ui.me.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseFragment;
import com.whmnrc.qiangbizhong.model.bean.RechargeBean;
import com.whmnrc.qiangbizhong.presenter.me.RechargePresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/9.
 */

public class RechargeFragment extends BaseFragment implements RechargePresenter.RechargeCall {


    @BindView(R.id.tv_moeny)
    TextView tvMoeny;
    @BindView(R.id.tv_rmb)
    TextView tvRmb;
    @BindView(R.id.et_recharge)
    EditText etRecharge;
    @BindView(R.id.btn_confirm)
    TextView btnConfirm;

    RechargePresenter rechargePresenter;

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
        rechargePresenter = new RechargePresenter(getContext());
        rechargePresenter.rechargeQuery(0, this);

    }

    @Override
    public void rechargeBack() {
        rechargePresenter.rechargeQuery(0, this);
    }

    @Override
    public void rechargeData(RechargeBean rechargeBean) {
        tvMoeny.setText(rechargeBean.getGoodsPrice_Stock()+"");
        tvRmb.setText(rechargeBean.getPrice()+"");
    }


    @OnClick(R.id.btn_confirm)
    public void onViewClicked() {
        if (!TextUtils.isEmpty(etRecharge.getText().toString().trim())){
            showLoading("充值中..");
            rechargePresenter.submitorder(etRecharge.getText().toString().trim(),"1","","");
        }
    }
}
