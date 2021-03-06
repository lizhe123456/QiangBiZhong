package com.whmnrc.qiangbizhong.widget;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.blankj.utilcode.util.KeyboardUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.ui.me.activity.UpdatePayPwdActivity;


/**
 * Created by yong hao zeng on 10/23/15.
 */
public class AlertEditTextDialog {
    private Context context;
    private Dialog dialog;
    private LinearLayout lLayout_bg;
    private TextView txt_title;
    private TextView txt_msg;
    private TextView tv_fund_zf_pwd;
    private Button btn_neg;
    private Button btn_pos;
    private ImageView img_line;
    private Display display;
    private boolean showTitle = false;
    private boolean showMsg = false;
    private boolean showPosBtn = false;
    private boolean showNegBtn = false;

    private EditText mEtPayPwd;
    private EditText mEtPayPwd1;


    public AlertEditTextDialog(Context context) {
        this.context = context;
        WindowManager windowManager = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        display = windowManager.getDefaultDisplay();
    }

    public AlertEditTextDialog builder() {
        // 获取Dialog布局
        View view = LayoutInflater.from(context).inflate(
                R.layout.view_alert_et_dialog, null);

        // 获取自定义Dialog布局中的控件
        lLayout_bg = (LinearLayout) view.findViewById(R.id.lLayout_bg);
        txt_title = (TextView) view.findViewById(R.id.txt_title);
        txt_title.setVisibility(View.GONE);
        txt_msg = (TextView) view.findViewById(R.id.txt_msg);
        tv_fund_zf_pwd = (TextView) view.findViewById(R.id.tv_fund_zf_pwd);
        txt_msg.setVisibility(View.GONE);
        btn_neg = (Button) view.findViewById(R.id.btn_neg);
        btn_neg.setVisibility(View.GONE);
        btn_pos = (Button) view.findViewById(R.id.btn_pos);
        btn_pos.setVisibility(View.GONE);
        img_line = (ImageView) view.findViewById(R.id.img_line);
        mEtPayPwd = (EditText) view.findViewById(R.id.et_pay_pwd);
        mEtPayPwd1 = (EditText) view.findViewById(R.id.et_pay_pwd1);
        img_line.setVisibility(View.GONE);

        // 定义Dialog布局和参数
        dialog = new Dialog(context, R.style.AlertDialogStyle);
        dialog.setContentView(view);

        // 调整dialog背景大小
        lLayout_bg.setLayoutParams(new FrameLayout.LayoutParams((int) (display
                .getWidth() * 0.85), LinearLayout.LayoutParams.WRAP_CONTENT));

        tv_fund_zf_pwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UpdatePayPwdActivity.start(v.getContext());
                dialog.dismiss();
            }
        });

        return this;
    }

    public AlertEditTextDialog setTitle(String title) {
        showTitle = true;
        if ("".equals(title)) {
            txt_title.setText("标题");
        } else {
            txt_title.setText(title);
        }
        return this;
    }

    public AlertEditTextDialog setTvFundZfPwd(boolean flag) {
        if (flag) {
            tv_fund_zf_pwd.setVisibility(View.VISIBLE);
        } else {
            tv_fund_zf_pwd.setVisibility(View.GONE);
        }
        return this;
    }

    public AlertEditTextDialog setMinTitle(String title) {
        showTitle = true;
        if ("".equals(title)) {
            tv_fund_zf_pwd.setText("标题");
        } else {
            tv_fund_zf_pwd.setText(title);
        }
        return this;
    }


    public AlertEditTextDialog setMsg(String msg) {
        showMsg = true;
        if ("".equals(msg)) {
            txt_msg.setText("内容");
        } else {
            txt_msg.setText(msg);
        }
        return this;
    }

    public AlertEditTextDialog setEidtMsg(String msg) {
        if ("".equals(msg)) {
            mEtPayPwd.setHint("内容");
        } else {
            mEtPayPwd.setHint(msg);
        }
        return this;
    }

    public AlertEditTextDialog setInputType(int type){
        mEtPayPwd.setInputType(type);
        mEtPayPwd1.setInputType(type);
        return this;
    }

    public AlertEditTextDialog setInputNume(int num){
        if (num == 6){
            mEtPayPwd.setVisibility(View.VISIBLE);
            mEtPayPwd1.setVisibility(View.GONE);
        }else {
            mEtPayPwd.setVisibility(View.GONE);
            mEtPayPwd1.setVisibility(View.VISIBLE);
        }

        return this;
    }



    public AlertEditTextDialog setCancelable(boolean cancel) {
        dialog.setCancelable(cancel);
        return this;
    }

    public AlertEditTextDialog setPositiveButton(String text, final ConfirmListenter confirmListenter) {
        showPosBtn = true;
        if ("".equals(text)) {
            btn_pos.setText("确定");
        } else {
            btn_pos.setText(text);
        }
        btn_pos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String payPwd = mEtPayPwd.getText().toString().trim();
                String com = mEtPayPwd1.getText().toString();
                KeyboardUtils.hideSoftInput(v);
                if (TextUtils.isEmpty(payPwd)){
                    confirmListenter.comfrim(com);
                }else {
                    confirmListenter.comfrim(payPwd);
                }
                dialog.dismiss();
                KeyboardUtils.hideSoftInput(btn_pos);
            }
        });
        return this;
    }

    public AlertEditTextDialog setPositive1Button(String text, final ConfirmListenter confirmListenter) {
        showPosBtn = true;
        if ("".equals(text)) {
            btn_pos.setText("确定");
        } else {
            btn_pos.setText(text);
        }
        btn_pos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String payPwd = mEtPayPwd.getText().toString().trim();
                KeyboardUtils.hideSoftInput(v);
                confirmListenter.comfrim(payPwd);
                dialog.dismiss();
                KeyboardUtils.hideSoftInput(btn_pos);
            }
        });
        return this;
    }

    public AlertEditTextDialog setNegativeButton(String text, final View.OnClickListener listener) {
        showNegBtn = true;
        if ("".equals(text)) {
            btn_neg.setText("取消");
        } else {
            btn_neg.setText(text);
        }
        btn_neg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(v);
                dialog.dismiss();
            }
        });
        return this;
    }

    private void setLayout() {
        if (!showTitle && !showMsg) {
            txt_title.setText("提示");
            txt_title.setVisibility(View.VISIBLE);
        }

        if (showTitle) {
            txt_title.setVisibility(View.VISIBLE);
        }

        if (showMsg) {
            txt_msg.setVisibility(View.VISIBLE);
        }

        if (!showPosBtn && !showNegBtn) {
            btn_pos.setText("确定");
            btn_pos.setVisibility(View.VISIBLE);
            btn_pos.setBackgroundResource(R.drawable.alertdialog_single_selector);
            btn_pos.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                }
            });
        }

        if (showPosBtn && showNegBtn) {
            btn_pos.setVisibility(View.VISIBLE);
            btn_pos.setBackgroundResource(R.drawable.alertdialog_right_selector);
            btn_neg.setVisibility(View.VISIBLE);
            btn_neg.setBackgroundResource(R.drawable.alertdialog_left_selector);
            img_line.setVisibility(View.VISIBLE);
        }

        if (showPosBtn && !showNegBtn) {
            btn_pos.setVisibility(View.VISIBLE);
            btn_pos.setBackgroundResource(R.drawable.alertdialog_single_selector);
        }

        if (!showPosBtn && showNegBtn) {
            btn_neg.setVisibility(View.VISIBLE);
            btn_neg.setBackgroundResource(R.drawable.alertdialog_single_selector);
        }
    }

    public void show() {
        setLayout();
        dialog.show();
        KeyboardUtils.showSoftInput(mEtPayPwd);
    }

    public interface ConfirmListenter {
        void comfrim(String content);
    }
}
