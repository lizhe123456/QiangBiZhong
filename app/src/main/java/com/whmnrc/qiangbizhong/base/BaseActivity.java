package com.whmnrc.qiangbizhong.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/5.
 */

public abstract class BaseActivity extends AppCompatActivity{


    private Unbinder mUnbinder;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLayout());
        mUnbinder = ButterKnife.bind(this);
//        mImmersionBar = ImmersionBar.with(this)
//                .statusBarColor(R.color.white)
//                .statusBarDarkFont(true)   //状态栏字体是深色，不写默认为亮色
//                .flymeOSStatusBarFontColor(R.color.tv_000) ;
//        mImmersionBar.init();   //所有子类都将继承这些相同的属性

        setData();
    }

    @LayoutRes
    protected abstract int setLayout();

    protected abstract void setData();


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mUnbinder !=  null) {
            mUnbinder.unbind();
        }
    }

}
