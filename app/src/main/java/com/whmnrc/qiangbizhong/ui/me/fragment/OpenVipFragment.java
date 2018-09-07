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
import com.google.gson.Gson;
import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.app.Constants;
import com.whmnrc.qiangbizhong.base.BaseFragment;
import com.whmnrc.qiangbizhong.model.bean.LoginBean;
import com.whmnrc.qiangbizhong.model.bean.RechargeBean;
import com.whmnrc.qiangbizhong.pay.alipay.AliPayTools;
import com.whmnrc.qiangbizhong.pay.listener.OnSuccessAndErrorListener;
import com.whmnrc.qiangbizhong.pay.wechat.pay.WechatPay;
import com.whmnrc.qiangbizhong.pay.wechat.pay.WechatPayModel;
import com.whmnrc.qiangbizhong.pay.wechat.pay.WechatPayTools;
import com.whmnrc.qiangbizhong.presenter.me.RechargePresenter;
import com.whmnrc.qiangbizhong.ui.UserXieYiActivity;
import com.whmnrc.qiangbizhong.util.StringUtil;
import com.whmnrc.qiangbizhong.util.UserManage;
import com.whmnrc.qiangbizhong.widget.PayDialogUtil;
import com.whmnrc.qiangbizhong.widget.PayTypeDialog;
import com.whmnrc.qiangbizhong.wxapi.WXPayBean;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

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
    public void payS(String data, int type) {
        if (!TextUtils.isEmpty(data)) {
            if (type == 0) {
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
            } else {
                WechatPayTools.doWXPay(getContext(), Constants.WX_APP_ID, data, new OnSuccessAndErrorListener() {
                    @Override
                    public void onSuccess(String s) {
                        UserManage.getInstance().getUserInfo(OpenVipFragment.this);
                        rechargePresenter.rechargeQuery(1, OpenVipFragment.this);
                    }

                    @Override
                    public void onError(String s) {
                        UserManage.getInstance().getUserInfo(OpenVipFragment.this);
                        rechargePresenter.rechargeQuery(1, OpenVipFragment.this);
                    }
                });
            }
        }else {
            ToastUtils.showShort("订单信息有误");
        }
    }

    @Override
    public void userInfoBack(LoginBean loginBean) {
        tvYue.setText(StringUtil.wanString(loginBean.getUserInfo_Money()));
    }

    @Override
    public void error() {

    }

    //支付回调响应
    @Subscribe(threadMode = ThreadMode.POSTING)
    public void onResp(WXPayBean error_code) {
        switch (error_code.getCode()) {
            case 0:
                ToastUtils.showShort("支付成功");
                break;
            case -2:
                ToastUtils.showShort("已取消");
                break;
            case -1:
                ToastUtils.showShort("支付失败");
                break;
            default:
                ToastUtils.showShort("参数错误");
                break;

        }
        UserManage.getInstance().getUserInfo(OpenVipFragment.this);
        rechargePresenter.rechargeQuery(1, OpenVipFragment.this);
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
//                    WechatPayModel wechatPayModel = new WechatPayModel("wx572d4c6551e02121", "1511222231", "wx07155714958843be0d7cb3943232466596", "Sign=WXPay", "1595af6435015c77a7149e92a551338e", "1536307035", "FD5FCB7922EFCA44CD55C14AAA5929AC");
//                    String pay_param = new Gson().toJson(wechatPayModel);
//                    WechatPayTools.doWXPay(getContext(), "wx572d4c6551e02121", pay_param, new OnSuccessAndErrorListener() {
//                        @Override
//                        public void onSuccess(String s) {
//
//                        }
//
//                        @Override
//                        public void onError(String s) {
//
//                        }
//                    });



                    if (!TextUtils.isEmpty(etRecharge.getText().toString().trim())) {
                        new PayTypeDialog.Builder(getContext()).setPayListener(new PayTypeDialog.OnPayClickListener() {
                            @Override
                            public void onPay(int type) {
                                showLoading("充值中..");
                                rechargePresenter.submitorder(type,etRecharge.getText().toString().trim(), "1", "", "", OpenVipFragment.this);
                            }
                        }).build().show();

                    }
                }else {
                    ToastUtils.showShort("请先去阅读充值协议");
                }
                break;
        }
    }
}
