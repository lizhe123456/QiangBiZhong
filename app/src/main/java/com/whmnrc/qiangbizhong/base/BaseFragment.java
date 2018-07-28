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

public abstract class BaseFragment extends Fragment {

    protected View mRootView;

    protected Context mContext;

    private Unbinder mUnbinder;

    // 标识fragment视图已经初始化完毕
    private boolean isViewPrepared;
    //标识已经触发过懒加载数据
    private boolean hasFetchData;

    private LoadingDialog loadingDialog;

    //统一初始化加载框
    private void initLoading() {
        loadingDialog = new LoadingDialog(mContext);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        EventBus.getDefault().register(this);
        mRootView = inflater.inflate(setLayout(),container,false);
        mUnbinder = ButterKnife.bind(this,mRootView);
        mContext = getActivity();
        initLoading();
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
        hasFetchData = false;
        isViewPrepared = false;
        if (mUnbinder != null) {
            mUnbinder.unbind();
        }
        EventBus.getDefault().unregister(this);
        super.onDestroyView();
    }

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

    @LayoutRes
    protected abstract int setLayout();

    protected abstract void initData();



}
