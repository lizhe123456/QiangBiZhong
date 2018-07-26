package com.whmnrc.qiangbizhong.ui.me.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
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

public class UpdatePayPwdActivity extends BaseActivity implements LoginPresenter.UpdatePwdCall{


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
    EditText textAmount;
    @BindView(R.id.et_code)
    EditText etCode;
    @BindView(R.id.bt_get_code)
    TextView btGetCode;
    @BindView(R.id.tv_login)
    TextView tvLogin;
    @BindView(R.id.et_pwd_2)
    EditText editText2;


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
        Intent starter = new Intent(context, UpdatePayPwdActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected int setLayout() {
        return R.layout.activity_update_pay_pass;
    }

    @Override
    protected void setData() {
        ivBack.setVisibility(View.VISIBLE);
        tvTitle.setText("设置支付密码");
        loginPresenter = new LoginPresenter(this);
    }






    @OnClick({R.id.iv_back, R.id.bt_get_code, R.id.tv_login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                this.finish();
                break;
            case R.id.bt_get_code:
                isStartTimer();
                loginPresenter.sendsmscode(UserManage.getInstance().getLoginBean().getUserInfo_Mobile());
                break;
            case R.id.tv_login:
                if (TextUtils.isEmpty(etCode.getText().toString().trim())){
                    ToastUtils.showShort("验证码不能为空");
                    return;
                }
                if (TextUtils.isEmpty(textAmount.getText().toString().trim())){
                    ToastUtils.showShort("密码不能为空");
                    return;
                }
                if (textAmount.getText().toString().trim().length() < 6){
                    ToastUtils.showShort("密码不能小于6位");
                    return;
                }
                if (!editText2.getText().toString().trim().equals(textAmount.getText().toString().trim())){
                    ToastUtils.showShort("两次输入不一致");
                    return;
                }
                showLoading("提交中..");
                loginPresenter.updatePayPass(textAmount.getText().toString().trim(),etCode.getText().toString().trim(),this);
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
    public void updatePaw() {
        ToastUtils.showShort("操作成功");
        this.finish();
    }
}
