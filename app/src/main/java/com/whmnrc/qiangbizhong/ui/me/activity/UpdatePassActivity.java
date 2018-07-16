package com.whmnrc.qiangbizhong.ui.me.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseActivity;
import com.whmnrc.qiangbizhong.presenter.me.LoginPresenter;
import com.whmnrc.qiangbizhong.ui.LoginActivity;
import com.whmnrc.qiangbizhong.ui.ZhaoPwdActivity;
import com.whmnrc.qiangbizhong.util.ToastUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/12.
 */

public class UpdatePassActivity extends BaseActivity {


    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.et_old_pass)
    EditText etOldPass;
    @BindView(R.id.et_new_pass)
    EditText etNewPass;
    @BindView(R.id.et_new_pass_2)
    EditText etNewPass2;
    @BindView(R.id.tv_login)
    TextView tvLogin;

    private LoginPresenter loginPresenter;

    public static void start(Context context) {
        Intent starter = new Intent(context, UpdatePassActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected int setLayout() {
        return R.layout.activity_update_pass;
    }

    @Override
    protected void setData() {
        ivBack.setVisibility(View.VISIBLE);
        tvTitle.setText("修改密码");
        loginPresenter = new LoginPresenter(this);
    }


    @OnClick({R.id.iv_back, R.id.tv_login, R.id.tv_address})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                this.finish();
                break;
            case R.id.tv_login:
                if (TextUtils.isEmpty(etOldPass.getText().toString())){
                    ToastUtils.showShort("旧密码不能为空");
                    return;
                }
                if (TextUtils.isEmpty(etNewPass.getText().toString())){
                    ToastUtils.showShort("新密码不能为空");
                    return;
                }
                if (TextUtils.isEmpty(etNewPass2.getText().toString())){
                    ToastUtils.showShort("请确认密码");
                    return;
                }
                if (!etOldPass.getText().toString().equals(etOldPass.getText().toString())){
                    ToastUtils.showShort("两次输入密码不一致");
                    return;
                }
                loginPresenter.updatePwd(etOldPass.getText().toString(),etNewPass.getText().toString(),this::updatePaw);
                break;
            case R.id.tv_address:
                ZhaoPwdActivity.start(this);
                break;
        }
    }

    private void updatePaw() {
        ToastUtils.showShort("修改成功，请重新登录");
        this.finish();
        LoginActivity.start(this);
    }
}
