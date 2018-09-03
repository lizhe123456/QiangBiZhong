package com.whmnrc.qiangbizhong.ui.me.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseFragment;
import com.whmnrc.qiangbizhong.model.bean.LoginBean;
import com.whmnrc.qiangbizhong.model.bean.RechargeBean;
import com.whmnrc.qiangbizhong.pay.alipay.AliPayTools;
import com.whmnrc.qiangbizhong.pay.listener.OnSuccessAndErrorListener;
import com.whmnrc.qiangbizhong.presenter.me.RechargePresenter;
import com.whmnrc.qiangbizhong.ui.UserXieYiActivity;
import com.whmnrc.qiangbizhong.util.StringUtil;
import com.whmnrc.qiangbizhong.util.UserManage;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/9.
 * 会员充值
 */

public class OpenVipFragment extends BaseFragment implements RechargePresenter.RechargeCall, UserManage.UserInfoCall {


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
    @BindView(R.id.tv_kegou)
    TextView tvKegou;

    RechargePresenter rechargePresenter;
    @BindView(R.id.iv_select)
    ImageView ivSelect;

    private boolean isSelect;

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
        if (getUserVisibleHint()) {
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
        rechargePresenter = new RechargePresenter(getActivity());
        rechargePresenter.rechargeQuery(1, this);
        ivSelect.setImageResource(R.drawable.ic_selece_no);
        isSelect = false;
    }

    @Override
    public void rechargeBack() {
        rechargePresenter.rechargeQuery(1, this);
    }

    @Override
    public void rechargeData(RechargeBean rechargeBean) {
        tvMoeny.setText(rechargeBean.getGoodsPrice_Stock() + "");
        tvRmb.setText(rechargeBean.getPrice() + "");
        tvKegoumai.setText(StringUtil.wanString(rechargeBean.getCanPayCount()));
        tvYue.setText(StringUtil.wanString(UserManage.getInstance().getLoginBean().getUserInfo_Money()));
        tvKegou.setText(StringUtil.wanString(rechargeBean.getTodayPayCount()));
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
                if (s.equals("4000")) {
                    ToastUtils.showShort("请确认支付宝是否安装");
                } else {
                    ToastUtils.showShort("充值失败");
                }
            }
        });
    }

    @Override
    public void userInfoBack(LoginBean loginBean) {
        tvYue.setText(StringUtil.wanString(loginBean.getUserInfo_Money()));
    }

    @Override
    public void error() {

    }


    @OnClick({R.id.iv_select, R.id.tv_xieyi,R.id.btn_confirm})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_select:
                if (isSelect){
                    ivSelect.setImageResource(R.drawable.ic_selece_no);
                    isSelect = false;
                }else {
                    ivSelect.setImageResource(R.drawable.ic_select);
                    isSelect = true;
                }
                break;
            case R.id.tv_xieyi:
                UserXieYiActivity.start(getContext(),"http://qbz.aimeilian.com.cn/Protocol/Recharge","充值协议");
                break;
            case R.id.btn_confirm:
                if (isSelect){
                    if (!TextUtils.isEmpty(etRecharge.getText().toString().trim())) {
                        showLoading("充值中..");
                        rechargePresenter.submitorder(etRecharge.getText().toString().trim(), "1", "", "", this);
                    }
                }else {
                    ToastUtils.showShort("请先去阅读充值协议");
                }
                break;
        }
    }
}
