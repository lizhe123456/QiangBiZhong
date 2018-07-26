package com.whmnrc.qiangbizhong.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.gyf.barlibrary.ImmersionBar;
import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.adapter.BaseLiveData;
import com.whmnrc.qiangbizhong.model.bean.LodingBean;
import com.whmnrc.qiangbizhong.widget.LoadingDialog;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/5.
 */

public abstract class BaseActivity extends AppCompatActivity{


    private Unbinder mUnbinder;

    private ImmersionBar mImmersionBar;

    protected LoadingDialog loadingDialog;

    private BaseLiveData baseLiveData;

    //统一初始化加载框
    private void initLoading() {
        loadingDialog = new LoadingDialog(this);
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLayout());
        mUnbinder = ButterKnife.bind(this);
        mImmersionBar = ImmersionBar.with(this)
                .transparentStatusBar()
                .statusBarDarkFont(true)   //状态栏字体是深色，不写默认为亮色
//                .fitsSystemWindows(true)
                .flymeOSStatusBarFontColor(R.color.tv_000) ;
        mImmersionBar.init();   //所有子类都将继承这些相同的属性
        EventBus.getDefault().register(this);
        initLoading();
        setData();
    }

    @LayoutRes
    protected abstract int setLayout();

    protected abstract void setData();

    protected void showLoading(String msg) {
        if (!loadingDialog.isShowing()) {
            loadingDialog.setMessage(msg);
            loadingDialog.show();
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void unLoading(LodingBean lodingBean) {
        if (loadingDialog.isShowing()) {
            loadingDialog.cancel();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mUnbinder !=  null) {
            mUnbinder.unbind();
        }
        if (mImmersionBar != null){
            mImmersionBar.destroy();
        }
        EventBus.getDefault().unregister(this);
    }


}
