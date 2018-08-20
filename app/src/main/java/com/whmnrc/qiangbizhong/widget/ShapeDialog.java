package com.whmnrc.qiangbizhong.widget;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.widget.ImageView;

import com.whmnrc.qiangbizhong.R;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/8/20.
 */

public class ShapeDialog extends Dialog{

    ImageView imageView;
    ImageView imageView2;

    public ShapeDialog(@NonNull Context context) {
        super(context);
    }

    public ShapeDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_shape);

    }
}
