package com.whmnrc.qiangbizhong.ui.me.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseFragment;
import com.whmnrc.qiangbizhong.model.bean.LoginBean;
import com.whmnrc.qiangbizhong.model.bean.RechargeBean;
import com.whmnrc.qiangbizhong.pay.alipay.AliPayTools;
import com.whmnrc.qiangbizhong.pay.listener.OnSuccessAndErrorListener;
import com.whmnrc.qiangbizhong.presenter.me.RechargePresenter;
import com.whmnrc.qiangbizhong.util.StringUtil;
import com.whmnrc.qiangbizhong.util.UserManage;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/9.
 * 会员充值
 */

public class OpenVipFragment extends BaseFragment implements RechargePresenter.RechargeCall ,UserManage.UserInfoCall{


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
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if(getUserVisibleHint()) {
            // 可视
            if (rechargePresenter != null) {
                rechargePresenter.rechargeQuery(1, this);
            }
        } else {
            // 不可视
        }
    }

    @Override
    protected void initData() {
        rechargePresenter = new RechargePresenter(getContext());
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
        tvKegoumai.setText(StringUtil.wanString(rechargeBean.getCanPayCount()));
        tvYue.setText(StringUtil.wanString((int)UserManage.getInstance().getLoginBean().getUserInfo_Money()));
    }

    @Override
    public void payS(String data) {
        AliPayTools.aliSignPay(getActivity(), data, new OnSuccessAndErrorListener() {
            @Override
            public void onSuccess(String s) {
                UserManage.getInstance().getUserInfo(OpenVipFragment.this);
                ToastUtils.showShort("充值成功");
                rechargePresenter.rechargeQuery(1, OpenVipFragment.this);
            }

            @Override
            public void onError(String s) {
                UserManage.getInstance().getUserInfo(OpenVipFragment.this);
                rechargePresenter.rechargeQuery(1, OpenVipFragment.this);
                ToastUtils.showShort("充值失败");
            }
        });
    }

    @OnClick(R.id.btn_confirm)
    public void onViewClicked() {
        if (!TextUtils.isEmpty(etRecharge.getText().toString().trim())){
            showLoading("充值中..");
            rechargePresenter.submitorder(etRecharge.getText().toString().trim(),"1","","",this);
        }
    }


    @Override
    public void userInfoBack(LoginBean loginBean) {
        tvYue.setText(loginBean.getUserInfo_Money()+"");
    }

    @Override
    public void error() {

    }
}
