package com.whmnrc.qiangbizhong.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.blankj.utilcode.util.RegexUtils;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.whmnrc.qiangbizhong.MainActivity;
import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseActivity;
import com.whmnrc.qiangbizhong.model.bean.LoginBean;
import com.whmnrc.qiangbizhong.presenter.me.LoginPresenter;
import com.whmnrc.qiangbizhong.util.UserManage;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/10.
 */

public class PwdLoginActivity extends BaseActivity implements LoginPresenter.LoginCall{

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
    @BindView(R.id.isshow)
    ImageView ivShow;


    boolean isshow;

    private LoginPresenter loginPresenter;

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
        loginPresenter = new LoginPresenter(this);
    }

    @OnClick({R.id.iv_back, R.id.tv_login, R.id.tv_swich, R.id.tv_zhao_pwd,R.id.isshow})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                this.finish();
                break;
            case R.id.tv_login:
                if (TextUtils.isEmpty(etPhoneNumber.getText().toString().trim())) {
                    ToastUtils.showShort("手机号不能为空");
                    return;
                }

                if (!RegexUtils.isMobileSimple(etPhoneNumber.getText())) {
                    ToastUtils.showShort("手机号格式有误");
                    return;
                }

                if (TextUtils.isEmpty(etCode.getText().toString().trim())){
                    ToastUtils.showShort("密码不能为空");
                    return;
                }
                showLoading("登录中..");
                loginPresenter.login(etPhoneNumber.getText().toString().trim(),etCode.getText().toString().trim(),"",0,this);
                break;
            case R.id.tv_swich:
                this.finish();
                break;
            case R.id.tv_zhao_pwd:
                ZhaoPwdActivity.start(this);
                this.finish();
                break;
            case R.id.isshow:
                if (!isshow){
                    isshow = true;
                    etCode.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);// 输入为密码且可见
                    etCode.setSelection(etCode.getText().toString().length());
                }else {
                    isshow = false;
                    etCode.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD | InputType.TYPE_CLASS_TEXT);// 设置文本类密码（默认不可见），这两个属性必须同时设置
                    etCode.setSelection(etCode.getText().toString().length());
                }
                break;
        }
    }

    @Override
    public void loginBack(LoginBean loginBean) {
        UserManage.getInstance().updateLoginBena(loginBean);
        MainActivity.start(this);
        this.finish();
    }
}
