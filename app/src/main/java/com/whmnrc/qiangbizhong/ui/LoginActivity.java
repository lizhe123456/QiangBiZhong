package com.whmnrc.qiangbizhong.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseActivity;
import com.whmnrc.qiangbizhong.presenter.me.LoginPresenter;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/9.
 */

public class LoginActivity extends BaseActivity {


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
                break;
            case R.id.tv_register:
                RegisterActivity.start(this);
                break;
            case R.id.tv_login:
                break;
        }
    }


}
