package com.whmnrc.qiangbizhong.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.text.InputType;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.blankj.utilcode.util.RegexUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseActivity;
import com.whmnrc.qiangbizhong.presenter.me.LoginPresenter;
import com.whmnrc.qiangbizhong.util.PwdCheckUtil;
import java.util.Timer;
import java.util.TimerTask;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/9.
 */

public class ZhaoPwdActivity extends BaseActivity implements LoginPresenter.ZhaoPassCall{


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
    @BindView(R.id.et_pwd)
    EditText etPwd;
    @BindView(R.id.et_code)
    EditText etCode;
    @BindView(R.id.bt_get_code)
    TextView btGetCode;
    @BindView(R.id.et_phone_number)
    EditText etPhoneNumber;
    @BindView(R.id.tv_login)
    TextView tvLogin;
    @BindView(R.id.isshow)
    ImageView ivShow;

    boolean isshow;


    private LoginPresenter loginPresenter;

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
                        btGetCode.setEnabled(true);
                        btGetCode.setText(getCodeAgain);
                    } else {
                        btGetCode.setText(secondleft + timerMessage);
                    }
                    break;
                case SENDSUCCESSFUL:
//                    etName.setEnabled(false);
                    break;
            }
        }
    };


    public static void start(Context context) {
        Intent starter = new Intent(context, ZhaoPwdActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected int setLayout() {
        return R.layout.activity_zhao_paw;
    }

    @Override
    protected void setData() {
        ivBack.setVisibility(View.VISIBLE);
        tvTitle.setText("找回密码");
        loginPresenter = new LoginPresenter(this);
    }


    @OnClick({R.id.iv_back, R.id.bt_get_code, R.id.tv_login,R.id.isshow})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                this.finish();
                break;
            case R.id.bt_get_code:
                if (TextUtils.isEmpty(etPhoneNumber.getText().toString().trim())){
                    ToastUtils.showShort("手机号为空");
                    return;
                }
                if (!RegexUtils.isMobileSimple(etPhoneNumber.getText())) {
                    ToastUtils.showShort("手机号格式有误");
                    return;
                }
                isStartTimer();
                loginPresenter.sendsmscode(etPhoneNumber.getText().toString().trim());
                break;
            case R.id.tv_login:
                //注册
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
                if (TextUtils.isEmpty(etPwd.getText().toString().trim())){
                    ToastUtils.showShort("密码不能为空");
                    return;
                }
                if (etPwd.getText().toString().trim().length() < 6){
                    ToastUtils.showShort("密码不能小于6位");
                    return;
                }

                if (!PwdCheckUtil.isLetterDigit(etPwd.getText().toString().trim())){
                    ToastUtils.showShort("至少包含大小写字母及数字");
                    return;
                }
                showLoading("提交中..");
                loginPresenter.retrievePwd(etPhoneNumber.getText().toString().trim(),etPwd.getText().toString().trim(),etCode.getText().toString().trim(),this);
                break;
            case R.id.isshow:
                if (!isshow){
                    isshow = true;
                    etPwd.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);// 输入为密码且可见
                    etPwd.setSelection(etPwd.getText().toString().length());
                    ivShow.setImageResource(R.drawable.ic_gson);

                }else {
                    isshow = false;
                    etPwd.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD | InputType.TYPE_CLASS_TEXT);// 设置文本类密码（默认不可见），这两个属性必须同时设置
                    etPwd.setSelection(etPwd.getText().toString().length());
                    ivShow.setImageResource(R.drawable.ic_cat_no);
                }
                break;
        }
    }

    /**
     * 倒计时
     */
    public void isStartTimer() {
        btGetCode.setEnabled(false);
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
    public void error() {

    }

    @Override
    public void zhaoPassBack() {
        ToastUtils.showShort("修改成功");
        this.finish();
    }
}
