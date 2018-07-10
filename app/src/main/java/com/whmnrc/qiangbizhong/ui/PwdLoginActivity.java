package com.whmnrc.qiangbizhong.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/10.
 */

public class PwdLoginActivity extends BaseActivity {

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.iv_menu)
    ImageView ivMenu;
    @BindView(R.id.tv_menu)
    TextView tvMenu;
    @BindView(R.id.ll_title)
    RelativeLayout llTitle;
    @BindView(R.id.v_divider)
    View vDivider;
    @BindView(R.id.ll_all_title)
    LinearLayout llAllTitle;
    @BindView(R.id.et_phone_number)
    EditText etPhoneNumber;
    @BindView(R.id.et_code)
    EditText etCode;
    @BindView(R.id.tv_login)
    TextView tvLogin;
    @BindView(R.id.tv_swich)
    TextView tvSwich;
    @BindView(R.id.tv_zhao_pwd)
    TextView tvZhaoPwd;

    public static void start(Context context) {
        Intent starter = new Intent(context, PwdLoginActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected int setLayout() {
        return R.layout.activity_pwd_login;
    }

    @Override
    protected void setData() {
        ivBack.setVisibility(View.VISIBLE);
        tvTitle.setText("密码登录");
    }

    @OnClick({R.id.iv_back, R.id.tv_login, R.id.tv_swich, R.id.tv_zhao_pwd})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                this.finish();
                break;
            case R.id.tv_login:
                this.finish();
                break;
            case R.id.tv_swich:
                this.finish();
                break;
            case R.id.tv_zhao_pwd:
                ZhaoPwdActivity.start(this);
                this.finish();
                break;
        }
    }
}
