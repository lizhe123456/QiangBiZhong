package com.whmnrc.qiangbizhong.ui.shop.shopenter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.blankj.utilcode.util.EncodeUtils;
import com.blankj.utilcode.util.ImageUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.whmnrc.qiangbizhong.MainActivity;
import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseActivity;
import com.whmnrc.qiangbizhong.model.bean.DataSave;
import com.whmnrc.qiangbizhong.presenter.shop.ShopEnterPresenter;
import com.whmnrc.qiangbizhong.ui.StatusActivity;
import com.whmnrc.qiangbizhong.util.GlideuUtil;
import com.whmnrc.qiangbizhong.util.ToastUtil;
import com.whmnrc.qiangbizhong.util.UserManage;

import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/8/6.
 */

public class ShopEnter5Activity extends BaseActivity implements ShopEnterPresenter.SubmitadmissionCall{


    @BindView(R.id.tv_dian_ming)
    TextView tvDianMing;
    @BindView(R.id.tv_band_hao)
    EditText tvBandHao;
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_shop_desc)
    TextView tvShopDesc;
    @BindView(R.id.tv_confirm)
    TextView tvConfirm;

    private ShopEnterP shopEnterP;
    private ShopEnterPresenter shopEnterPresenter;

    public static void start(Context context,ShopEnterP shopP) {
        Intent starter = new Intent(context, ShopEnter5Activity.class);
        DataSave.setValue(shopP);
        context.startActivity(starter);
    }

    @Override
    protected int setLayout() {
        return R.layout.activity_shop_enter5;
    }

    @Override
    protected void setData() {
        tvTitle.setText("我要入驻");
        ivBack.setVisibility(View.VISIBLE);
        shopEnterP = DataSave.getValue();
        tvDianMing.setText(UserManage.getInstance().getLoginBean().getUserInfo_NickName());
        shopEnterP.setUserId(UserManage.getInstance().getLoginBean().getUserInfo_ID());
        String img = UserManage.getInstance().getLoginBean().getUserInfo_HeadImg();
//        String s = img.split(23);
        img=img.replace("http://testaml.whmnx.com","");
//                http://testaml.whmnx.com
        shopEnterP.setStoreHeadImage(img);
        shopEnterP.setStoreImage(img);
        shopEnterPresenter = new ShopEnterPresenter(this);
    }

    @OnClick({R.id.iv_back, R.id.tv_confirm})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                this.finish();
                break;
            case R.id.tv_confirm:
                if (TextUtils.isEmpty(tvBandHao.getText().toString())){
                    ToastUtils.showShort("店名不能为空");
                    return;
                }
                shopEnterP.setStoreName(tvBandHao.getText().toString());

                if (TextUtils.isEmpty(tvShopDesc.getText().toString())){
                    ToastUtils.showShort("店铺介绍不能为空");
                    return;
                }
                shopEnterP.setExplain(tvShopDesc.getText().toString());
                showLoading("提交中..");
                //提交审核
                shopEnterPresenter.submitadmission(shopEnterP,this);
                break;
        }
    }

    @Override
    public void error() {
        if (loadingDialog.isShowing()){
            loadingDialog.cancel();
        }
    }

    @Override
    public void submitadmissionBack() {
        StatusActivity.start(this,1,"您入驻的申请目前正在等待审核中，\n" +
                "我们将于5个工作日告知结果，请耐心等待！","入驻结果");
    }

}
