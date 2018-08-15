package com.whmnrc.qiangbizhong.widget;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.ui.me.activity.MyOrderActivity;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/8/13.
 */

public class YiMeiDialog extends Dialog {

    private ImageView imageView;
    private Display display;
    private LinearLayout lLayout_bg;


    public YiMeiDialog(@NonNull Context context) {
        super(context,R.style.AlertDialogStyle);
        WindowManager windowManager = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        display = windowManager.getDefaultDisplay();
    }

    public YiMeiDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_yimei);
        imageView = findViewById(R.id.ic_close);
        lLayout_bg = findViewById(R.id.lLayout_bg);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOrderActivity.start(getContext(),4);
                dismiss();
            }
        });
        setCancelable(false);
        // 调整dialog背景大小
        lLayout_bg.setLayoutParams(new FrameLayout.LayoutParams((int) (display
                .getWidth() * 0.85), LinearLayout.LayoutParams.WRAP_CONTENT));
    }

}
