package com.whmnrc.qiangbizhong.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/5.
 */

public abstract class BaseFragment<V extends BaseView,P extends BasePresenter> extends Fragment {

    protected View mRootView;
    protected V view;
    protected P presenter;
    protected Context mContext;

    private Unbinder mUnbinder;

    // 标识fragment视图已经初始化完毕
    private boolean isViewPrepared;
    //标识已经触发过懒加载数据
    private boolean hasFetchData;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView = inflater.inflate(setLayout(),container,false);
        mUnbinder = ButterKnife.bind(this,mRootView);
        mContext = getActivity();
        if(presenter == null){
            presenter = createPresenter();
        }
        if(view == null){
            view = createView();
        }
        if(presenter != null && view != null){
            presenter.attachView(view);
        }
        return mRootView;
    }

    private void lazyFetchDataIfPrepared() {
        if (getUserVisibleHint() && !hasFetchData && isViewPrepared) {
            hasFetchData = true;
            initData();
        }
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser){
            lazyFetchDataIfPrepared();
        }
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        isViewPrepared = true;
        lazyFetchDataIfPrepared();
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        hasFetchData = false;
        isViewPrepared = false;
        if (mUnbinder != null) {
            mUnbinder.unbind();
        }
        if (presenter != null){
            presenter.detachView();
        }
    }

    @LayoutRes
    protected abstract int setLayout();

    protected abstract void initData();

    public abstract P createPresenter();
    public abstract V createView();


}
