package com.whmnrc.qiangbizhong.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.ColorRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;

import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/5.
 */

public abstract class BaseActivity<V extends BaseView,P extends BasePresenter<V>> extends RxAppCompatActivity{

    //引用V层和P层
    private P presenter;
    private V view;

    private Unbinder mUnbinder;

    public P getPresenter(){
        return presenter;
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLayout());
        mUnbinder = ButterKnife.bind(this);
        if(presenter == null){
            presenter = createPresenter();
        }
        if(view == null){
            view = createView();
        }
        if(presenter != null && view != null){
            presenter.attachView(view);
        }
        setData();
    }

    @LayoutRes
    protected abstract int setLayout();

    protected abstract void setData();

    protected abstract P createPresenter();
    protected abstract V createView();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mUnbinder !=  null) {
            mUnbinder.unbind();
        }
        if(presenter != null){
            presenter.detachView();
        }
    }

}
