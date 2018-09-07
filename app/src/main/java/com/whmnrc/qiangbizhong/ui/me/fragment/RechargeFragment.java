package com.whmnrc.qiangbizhong.ui.me.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseFragment;
import com.whmnrc.qiangbizhong.model.bean.LoginBean;
import com.whmnrc.qiangbizhong.model.bean.RechargeBean;
import com.whmnrc.qiangbizhong.pay.alipay.AliPayTools;
import com.whmnrc.qiangbizhong.pay.listener.OnSuccessAndErrorListener;
import com.whmnrc.qiangbizhong.presenter.me.LoginPresenter;
import com.whmnrc.qiangbizhong.presenter.me.RechargePresenter;
import com.whmnrc.qiangbizhong.util.StringUtil;
import com.whmnrc.qiangbizhong.util.UserManage;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/9.
 */

public class RechargeFragment extends BaseFragment implements RechargePresenter.RechargeCall ,UserManage.UserInfoCall{


    @BindView(R.id.tv_moeny)
    TextView tvMoeny;
    @BindView(R.id.tv_rmb)
    TextView tvRmb;
    @BindView(R.id.et_recharge)
    EditText etRecharge;
    @BindView(R.id.btn_confirm)
    TextView btnConfirm;
    @BindView(R.id.tv_kegoumai)
    TextView textView;


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
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if(getUserVisibleHint()) {
            if (rechargePresenter != null) {
                // 可视
                rechargePresenter.rechargeQuery(0, this);
            }
        } else {
            // 不可视
        }
    }

    @Override
    protected void initData() {
        rechargePresenter = new RechargePresenter(getActivity());
        rechargePresenter.rechargeQuery(0, this);
    }

    @Override
    public void rechargeBack() {
        rechargePresenter.rechargeQuery(0, this);
    }

    @Override
    public void rechargeData(@NonNull RechargeBean rechargeBean) {
        tvMoeny.setText(rechargeBean.getGoodsPrice_Stock()+"");
        tvRmb.setText(rechargeBean.getPrice()+"");
        textView.setText(StringUtil.wanString(rechargeBean.getCanPayCount()));
    }

    @Override
    public void payS(String data,int type) {
        AliPayTools.aliSignPay(getActivity(), data, new OnSuccessAndErrorListener() {
            @Override
            public void onSuccess(String s) {
                UserManage.getInstance().getUserInfo(RechargeFragment.this);
                rechargePresenter.rechargeQuery(0, RechargeFragment.this);
                ToastUtils.showShort("充值成功");
            }

            @Override
            public void onError(String s) {
                UserManage.getInstance().getUserInfo(RechargeFragment.this);
                rechargePresenter.rechargeQuery(0, RechargeFragment.this);
                if (s.equals("4000")) {
                    ToastUtils.showShort("请确认支付宝是否安装");
                }else {
                    ToastUtils.showShort("充值失败");
                }
            }
        });
    }


    @OnClick(R.id.btn_confirm)
    public void onViewClicked() {
        if (!TextUtils.isEmpty(etRecharge.getText().toString().trim())){
            showLoading("充值中..");
//            rechargePresenter.submitorder(etRecharge.getText().toString().trim(),"2","","",this);
        }
    }


    @Override
    public void userInfoBack(LoginBean loginBean) {

    }

    @Override
    public void error() {

    }
}
