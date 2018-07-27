package com.whmnrc.qiangbizhong.widget;

import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.blankj.utilcode.util.ToastUtils;
import com.whmnrc.qiangbizhong.R;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/27.
 */

public class CustomerServiceDialog extends Dialog {

    private Display display;

    private LinearLayout lLayout_bg;
    private Button btn_neg;
    private LinearLayout ll_pay_pwd1;
    private LinearLayout ll_pay_pwd2;

    public CustomerServiceDialog(@NonNull Context context) {
        super(context);

    }

    public CustomerServiceDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
        WindowManager windowManager = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        display = windowManager.getDefaultDisplay();
        setContentView(R.layout.layout_customer_service);
        lLayout_bg = findViewById(R.id.lLayout_bg);
        lLayout_bg.setLayoutParams(new FrameLayout.LayoutParams((int) (display
                .getWidth() * 0.85), LinearLayout.LayoutParams.WRAP_CONTENT));
        btn_neg = findViewById(R.id.btn_neg);

        ll_pay_pwd1 = findViewById(R.id.ll_pay_pwd1);
        ll_pay_pwd2 = findViewById(R.id.ll_pay_pwd2);

        ll_pay_pwd1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClipboardManager cm = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData myClip = ClipData.newPlainText("text", "15571853734");
                cm.setPrimaryClip(myClip);
                ToastUtils.showShort("已复制到剪切板");
                dismiss();
            }
        });

        ll_pay_pwd2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClipboardManager cm = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData myClip = ClipData.newPlainText("text", "foreverdick999");
                cm.setPrimaryClip(myClip);
                ToastUtils.showShort("已复制到剪切板");
                dismiss();
            }
        });

        btn_neg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

    }


}
