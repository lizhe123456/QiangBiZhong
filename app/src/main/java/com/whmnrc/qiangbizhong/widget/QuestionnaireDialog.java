package com.whmnrc.qiangbizhong.widget;

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
import android.widget.TextView;

import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.ui.QuestionnaireInvestigationActivity;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/8/15.
 */

public class QuestionnaireDialog extends Dialog{

    private ImageView imageView;
    private ImageView ivClose;
    private Display display;
    private LinearLayout lLayout_bg;

    public QuestionnaireDialog(@NonNull Context context) {
        super(context,R.style.AlertDialogStyle);
        WindowManager windowManager = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        display = windowManager.getDefaultDisplay();
    }

    public QuestionnaireDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_questionnaire);

        ivClose = findViewById(R.id.iv_close);
        imageView = findViewById(R.id.iv_q);
        lLayout_bg = findViewById(R.id.lLayout_bg);

        ivClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
                QuestionnaireInvestigationActivity.start(getContext());
            }
        });

        // 调整dialog背景大小
        lLayout_bg.setLayoutParams(new FrameLayout.LayoutParams((int) (display
                .getWidth() * 0.85), LinearLayout.LayoutParams.WRAP_CONTENT));

    }


}
