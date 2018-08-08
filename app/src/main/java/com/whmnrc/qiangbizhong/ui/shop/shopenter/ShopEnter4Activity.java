package com.whmnrc.qiangbizhong.ui.shop.shopenter;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.alibaba.fastjson.JSON;
import com.blankj.utilcode.util.ToastUtils;
import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseActivity;
import com.whmnrc.qiangbizhong.model.bean.DataSave;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/8/6.
 */

public class ShopEnter4Activity extends BaseActivity {


    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_kaihu_hao)
    EditText tvKaihuHao;
    @BindView(R.id.tv_kaihu_name)
    EditText tvKaihuName;
    @BindView(R.id.tv_city)
    EditText tvCity;
    @BindView(R.id.tv_band_hao_2)
    EditText tvBandHao2;
    @BindView(R.id.tv_kaihu_city)
    EditText tvKaihuCity;
    @BindView(R.id.tv_confirm)
    TextView tvConfirm;

    private ShopEnterP shopEnterP;

    public static void start(Context context, ShopEnterP shopEnterP) {
        Intent starter = new Intent(context, ShopEnter4Activity.class);
        DataSave.setValue(shopEnterP);
        context.startActivity(starter);
    }

    @Override
    protected int setLayout() {
        return R.layout.activity_shop_enter4;
    }

    @Override
    protected void setData() {
        tvTitle.setText("我要入驻");
        ivBack.setVisibility(View.VISIBLE);
        shopEnterP = DataSave.getValue();
    }



    @OnClick({R.id.iv_back, R.id.tv_confirm})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                this.finish();
                break;
            case R.id.tv_confirm:
                if (TextUtils.isEmpty(tvKaihuHao.getText().toString().trim())){
                    ToastUtils.showShort("请填写开户行账号");
                    return;
                }
                shopEnterP.setSettlementBankAccount(tvKaihuHao.getText().toString().trim());


                if (TextUtils.isEmpty(tvKaihuName.getText().toString().trim())){
                    ToastUtils.showShort("请填写开户行名称");
                    return;
                }
                shopEnterP.setBankName(tvKaihuName.getText().toString().trim());


                if (TextUtils.isEmpty(tvCity.getText().toString().trim())){
                    ToastUtils.showShort("请填写开户行支行名称");
                    return;
                }
                shopEnterP.setBankBranchName(tvCity.getText().toString().trim());

                if (TextUtils.isEmpty(tvBandHao2.getText().toString().trim())){
                    ToastUtils.showShort("请填写银行账号");
                    return;
                }
                shopEnterP.setBankAccount(tvBandHao2.getText().toString().trim());

                if (TextUtils.isEmpty(tvKaihuCity.getText().toString().trim())){
                    ToastUtils.showShort("请选择开户行所在地");
                    return;
                }
                shopEnterP.setSettlementBankName(tvKaihuCity.getText().toString().trim());

                ShopEnter5Activity.start(this,shopEnterP);
                break;
        }
    }
}
