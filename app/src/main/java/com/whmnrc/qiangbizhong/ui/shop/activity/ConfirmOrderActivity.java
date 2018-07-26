package com.whmnrc.qiangbizhong.ui.shop.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseActivity;
import com.whmnrc.qiangbizhong.model.bean.AddressBean;
import com.whmnrc.qiangbizhong.model.bean.AwardBeanInfo;
import com.whmnrc.qiangbizhong.model.bean.GoodsRushinfoBean;
import com.whmnrc.qiangbizhong.presenter.me.AddressPresenter;
import com.whmnrc.qiangbizhong.presenter.me.OrderPresenter;
import com.whmnrc.qiangbizhong.ui.me.activity.AccountRechargeActivity;
import com.whmnrc.qiangbizhong.ui.me.activity.MyOrderActivity;
import com.whmnrc.qiangbizhong.ui.me.fragment.order.Order4Fragment;
import com.whmnrc.qiangbizhong.util.GlideuUtil;
import com.whmnrc.qiangbizhong.widget.AlertEditTextDialog;
import com.whmnrc.qiangbizhong.widget.PayDialogUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.pedant.SweetAlert.SweetAlertDialog;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/13.
 */

public class ConfirmOrderActivity extends BaseActivity implements OrderPresenter.SubmitOrederCall,AddressPresenter.AddManageCall,OrderPresenter.PayPassCall{


    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_goods_name)
    TextView tvGoodsName;
    @BindView(R.id.tv_price)
    TextView tvPrice;
    @BindView(R.id.tv_adress)
    TextView tvAdress;
    @BindView(R.id.iv_img)
    ImageView ivImg;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_phone)
    TextView tvPhone;
    @BindView(R.id.tv_address)
    TextView tvAddress;
    @BindView(R.id.rl_address)
    RelativeLayout rlAddress;
    @BindView(R.id.tv_yuyue)
    TextView tvYuyue;

    private GoodsRushinfoBean.RushGoodsInfoBean goodsRushinfoBean;
    private AwardBeanInfo.AwardGoodsInfoBean awardBeanInfo;
    private AddressBean addressBean;
    private OrderPresenter orderPresenter;
    private AddressPresenter addressPresenter;

    public static void start(Activity context, GoodsRushinfoBean.RushGoodsInfoBean rushGoodsInfoBean) {
        Intent starter = new Intent(context, ConfirmOrderActivity.class);
        starter.putExtra("rushGoodsInfoBean", rushGoodsInfoBean);
        context.startActivityForResult(starter,102);
    }

    public static void start(Activity context, AwardBeanInfo.AwardGoodsInfoBean awardBeanInfo) {
        Intent starter = new Intent(context, ConfirmOrderActivity.class);
        starter.putExtra("awardBeanInfo", awardBeanInfo);
        context.startActivityForResult(starter,102);
    }

    @Override
    protected int setLayout() {
        return R.layout.activity_confirm_order;
    }

    @Override
    protected void setData() {
        goodsRushinfoBean = getIntent().getParcelableExtra("rushGoodsInfoBean");
        awardBeanInfo = getIntent().getParcelableExtra("awardBeanInfo");
        if (goodsRushinfoBean != null) {
            GlideuUtil.loadImageView(this, goodsRushinfoBean.getGoods_ImaPath(), ivImg);
            tvPrice.setText(String.valueOf(goodsRushinfoBean.getGoodsPrice_Price()));
            tvGoodsName.setText(goodsRushinfoBean.getGoods_Name());
            tvYuyue.setText(String.valueOf(goodsRushinfoBean.getBond()));
        }else {
            GlideuUtil.loadImageView(this, awardBeanInfo.getGoods_ImaPath(), ivImg);
            tvPrice.setText(String.valueOf(awardBeanInfo.getGoodsPrice_Price()));
            tvGoodsName.setText(awardBeanInfo.getGoods_Name());
            tvYuyue.setText(String.valueOf(awardBeanInfo.getBond()));
        }
        orderPresenter = new OrderPresenter(this);
        ivBack.setVisibility(View.VISIBLE);
        tvTitle.setText("确认订单");
        addressPresenter = new AddressPresenter(this);
        addressPresenter.getaddressList(this);

    }


    @OnClick({R.id.iv_back, R.id.tv_adress, R.id.tv_tijiao, R.id.rl_address})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                this.finish();
                break;
            case R.id.tv_adress:
                SelectAddressActivity.start(this);
                break;
            case R.id.rl_address:
                SelectAddressActivity.start(this);
                break;
            case R.id.tv_tijiao:
                new SweetAlertDialog(this)
                        .setTitleText("提示")
                        .setContentText("确定支付预约金"+(goodsRushinfoBean == null ? awardBeanInfo.getBond() : goodsRushinfoBean.getBond())+"?")
                        .setCancelButton("取消", new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sweetAlertDialog) {
                                sweetAlertDialog.dismiss();
                            }
                        }).setConfirmButton("确认", new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sweetAlertDialog) {
                        sweetAlertDialog.dismiss();
                        PayDialogUtil.payDialogShow(ConfirmOrderActivity.this, new AlertEditTextDialog.ConfirmListenter(){

                            @Override
                            public void comfrim(String content) {
                                showLoading("支付中..");
                                orderPresenter.yzPass(content,ConfirmOrderActivity.this);
                            }
                        });
                    }
                }).show();

                break;
        }
    }


    @SuppressLint("SetTextI18n")
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 102) {
            if (resultCode == 101) {
                addressBean = data.getParcelableExtra("address");
                if (addressBean != null) {
                    tvAddress.setText(addressBean.getProviceName() + addressBean.getCityName() + addressBean.getRegionName() + addressBean.getAddress_Detail());
                    tvPhone.setText(addressBean.getAddress_Mobile());
                    tvName.setText(addressBean.getAddress_Name());
                    tvAdress.setVisibility(View.GONE);
                    rlAddress.setVisibility(View.VISIBLE);
                }
            }
        }

    }

    @Override
    public void error() {

    }

    @Override
    public void submitOrederBack() {
        setResult(101);
        this.finish();
    }

    @Override
    public void recharge() {
        new SweetAlertDialog(this)
                .setTitleText("提示")
                .setContentText("余额不足,请充值！")
                .setCancelButton("取消", new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sweetAlertDialog) {
                        sweetAlertDialog.dismiss();
                    }
                }).setConfirmButton("确认", new SweetAlertDialog.OnSweetClickListener() {
            @Override
            public void onClick(SweetAlertDialog sweetAlertDialog) {
                sweetAlertDialog.dismiss();
                AccountRechargeActivity.start(ConfirmOrderActivity.this,0);
            }
        }).show();
    }

    @Override
    public void getAddressList(@NonNull List<AddressBean> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getAddress_IsDefault() == 1){
                addressBean = list.get(i);
            }
        }
        if (addressBean != null) {
            tvAddress.setText(addressBean.getProviceName() + addressBean.getCityName() + addressBean.getRegionName() + addressBean.getAddress_Detail());
            tvPhone.setText(addressBean.getAddress_Mobile());
            tvName.setText(addressBean.getAddress_Name());
            tvAdress.setVisibility(View.GONE);
            rlAddress.setVisibility(View.VISIBLE);
        }else {
            tvAdress.setVisibility(View.VISIBLE);
            rlAddress.setVisibility(View.GONE);
        }

    }

    @Override
    public void updateData() {

    }

    @Override
    public void payPassBack() {
        if (addressBean != null) {
            showLoading("提交中..");
            if (goodsRushinfoBean != null) {
                orderPresenter.submitOrder(goodsRushinfoBean.getRushId(), addressBean.getAddress_ID(), ConfirmOrderActivity.this);
            }else if (awardBeanInfo != null){
                orderPresenter.awardSubmitOrder(awardBeanInfo.getAwardId(), addressBean.getAddress_ID(), ConfirmOrderActivity.this);
            }
        } else {
            ToastUtils.showShort("请选择地址");
        }
    }
}
