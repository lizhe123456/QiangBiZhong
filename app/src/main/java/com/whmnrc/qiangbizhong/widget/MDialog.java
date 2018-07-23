package com.whmnrc.qiangbizhong.widget;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.whmnrc.qiangbizhong.R;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/23.
 */

public class MDialog extends Dialog{

    private TextView tvTitle;
    private TextView tvCancel;
    private TextView tvConfirm;

    private View.OnClickListener onConfirmClickListener;
    private View.OnClickListener onCancelClickListener;

    public MDialog(Context context) {
        super(context);
    }

    public MDialog(Context context, int alertType) {
        super(context, alertType);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m_dialog);
        tvCancel = findViewById(R.id.tv_cancel);
        tvTitle = findViewById(R.id.tv_title);
        tvConfirm = findViewById(R.id.tv_confirm);
    }

    public void build(){

        if (onConfirmClickListener != null){
            tvConfirm.setOnClickListener(onConfirmClickListener);
        }

        if (onCancelClickListener != null){
            tvCancel.setOnClickListener(onCancelClickListener);
        }


    }

    public class Build{

    }
}
