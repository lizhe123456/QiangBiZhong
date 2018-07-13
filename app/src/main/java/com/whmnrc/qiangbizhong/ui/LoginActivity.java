package com.whmnrc.qiangbizhong.ui;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.blankj.utilcode.util.AppUtils;
import com.blankj.utilcode.util.RegexUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.whmnrc.qiangbizhong.MainActivity;
import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseActivity;
import com.whmnrc.qiangbizhong.model.bean.LoginBean;
import com.whmnrc.qiangbizhong.presenter.me.LoginPresenter;
import com.whmnrc.qiangbizhong.util.ToastUtil;
import com.whmnrc.qiangbizhong.util.UserManage;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/9.
 */

public class LoginActivity extends BaseActivity implements LoginPresenter.LoginCall{


    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.et_phone_number)
    EditText etPhoneNumber;
    @BindView(R.id.et_code)
    EditText etCode;
    @BindView(R.id.tv_title)
    TextView tvTitle;

    private LoginPresenter loginPresenter;

    public static void start(Context context) {
        Intent starter = new Intent(context, LoginActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected int setLayout() {
        return R.layout.activity_login;
    }

    @Override
    protected void setData() {
        loginPresenter = new LoginPresenter(this);
        ivBack.setVisibility(View.VISIBLE);
        tvTitle.setText("登录");
    }

    @OnClick({R.id.iv_back, R.id.bt_get_code, R.id.tv_register, R.id.tv_login,R.id.tv_swich})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_swich:
                PwdLoginActivity.start(this);
                break;
            case R.id.iv_back:
                this.finish();
                break;
            case R.id.bt_get_code:
                if (TextUtils.isEmpty(etPhoneNumber.getText().toString().trim())) {
                    ToastUtils.showShort("手机号不能为空");
                    return;
                }
                if (RegexUtils.isMobileSimple(etPhoneNumber.getText())) {
                    loginPresenter.sendsmscode(etPhoneNumber.getText().toString().trim());
                }else {
                    ToastUtils.showShort("手机号格式有误");
                }
                loginPresenter.sendsmscode(etPhoneNumber.getText().toString().trim());
                break;
            case R.id.tv_register:
                RegisterActivity.start(this);
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
                    ToastUtils.showShort("验证码不能为空");
                    return;
                }
                showLoading("登录中..");
                loginPresenter.login(etPhoneNumber.getText().toString().trim(),"",etCode.getText().toString().trim(),1,this);
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
