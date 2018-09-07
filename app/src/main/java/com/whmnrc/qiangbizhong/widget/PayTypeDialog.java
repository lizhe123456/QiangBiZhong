package com.whmnrc.qiangbizhong.widget;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.whmnrc.qiangbizhong.R;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/9/7.
 */

public class PayTypeDialog extends Dialog{
    private ImageView selectAli;
    private ImageView selectWx;
    private LinearLayout llAli;
    private LinearLayout llWx;
    private TextView tvPay;
    private Context context;

    private OnPayClickListener onPayClickListener;
    private int type;


    public PayTypeDialog(@NonNull Context context) {
        super(context, R.style.BottomDialogSty);
        this.context = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_pay_type);
        Window dialogWindow = this.getWindow();
        dialogWindow.setGravity(Gravity.BOTTOM);
        dialogWindow.setWindowAnimations(R.style.BottomDialog_Animation); // 添加动画
        dialogWindow.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);//设置横向全屏
        selectAli = findViewById(R.id.select_ali);
        selectWx = findViewById(R.id.select_wx);
        llAli = findViewById(R.id.ali_ll);
        llWx = findViewById(R.id.wx_ll);
        tvPay = findViewById(R.id.tv_pay);
    }

    @Override
    public void show() {
        super.show();
        show(this);
    }

    public void show(PayTypeDialog payDialog){
        select(type);
        payDialog.llAli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                type = 0;
                select(type);
            }
        });



        payDialog.llWx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                type = 1;
                select(type);
            }
        });

        if (onPayClickListener != null){
            payDialog.tvPay.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    payDialog.onPayClickListener.onPay(type);
                }
            });
        }
    }

    public int getType() {
        return type;
    }

    public void select(int type){
        switch (type){
            case 0:
                selectAli.setImageResource(R.drawable.ic_select);
                selectWx.setImageResource(R.drawable.ic_selece_no);
                break;
            case 1:
                selectWx.setImageResource(R.drawable.ic_select);
                selectAli.setImageResource(R.drawable.ic_selece_no);
                break;
        }
    }

    public static class Builder {
        private PayTypeDialog mDialog;

        public Builder(Context context) {
            mDialog = new PayTypeDialog(context);
        }


        public Builder setPayListener(OnPayClickListener onPayClickListener) {
            mDialog.onPayClickListener = onPayClickListener;
            return this;
        }

        public PayTypeDialog build() {
            return mDialog;
        }
    }

    public interface OnPayClickListener{
        void onPay(int type);
    }
}
