package com.whmnrc.qiangbizhong.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
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

import java.util.Timer;
import java.util.TimerTask;

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
    @BindView(R.id.bt_get_code)
    TextView tvGetCode;

    private LoginPresenter loginPresenter;

    public static void start(Context context) {
        Intent starter = new Intent(context, LoginActivity.class);
        context.startActivity(starter);
    }

    //验证码重发倒计时
    private int secondleft = 60;

    private static final int TICK_TIME = 1;
    private static final int SENDSUCCESSFUL = 2;
    //The timer.
    private Timer timer;

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case TICK_TIME:
                    String getCodeAgain = getString(R.string.getcode_again);
                    String timerMessage = getString(R.string.timer_message);
                    secondleft--;
                    if (secondleft <= 0) {
                        timer.cancel();
                        tvGetCode.setEnabled(true);
                        tvGetCode.setText(getCodeAgain);
                    } else {
                        tvGetCode.setText(secondleft + timerMessage);
                    }
                    break;
                case SENDSUCCESSFUL:
//                    etName.setEnabled(false);
                    break;
            }
        }
    };

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
                if (!RegexUtils.isMobileSimple(etPhoneNumber.getText())) {
                    ToastUtils.showShort("手机号格式有误");
                    return;
                }
                isStartTimer();
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

    /**
     * 倒计时
     */
    public void isStartTimer() {
        tvGetCode.setEnabled(false);
//        tvCode.setBackgroundResource(R.drawable.btn_getcode_shape_gray);
        secondleft = 60;
        timer = new Timer();
        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                handler.sendEmptyMessage(TICK_TIME);
            }
        }, 1000, 1000);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (timer != null) {
            timer.cancel();
        }
    }


    @Override
    public void loginBack(LoginBean loginBean) {
        UserManage.getInstance().updateLoginBena(loginBean);
        MainActivity.start(this);
        this.finish();
    }

    @Override
    public void error() {

    }
}
