package com.whmnrc.qiangbizhong.ui;

import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseActivity;
import com.whmnrc.qiangbizhong.base.BasePresenter;
import com.whmnrc.qiangbizhong.base.BaseResponse;
import com.whmnrc.qiangbizhong.base.BaseView;
import com.whmnrc.qiangbizhong.model.bean.LoginBean;
import com.whmnrc.qiangbizhong.presenter.me.LoginPresenter;
import com.whmnrc.qiangbizhong.presenter.me.contract.LoginContract;

import java.util.List;

import io.reactivex.ObservableTransformer;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/9.
 */

public class LoginActivity extends BaseActivity<LoginContract.View,LoginPresenter> implements LoginContract.View{


    @Override
    protected int setLayout() {
        return R.layout.activity_login;
    }

    @Override
    protected void setData() {

    }

    @Override
    protected LoginPresenter createPresenter() {
        return new LoginPresenter(this);
    }

    @Override
    protected LoginContract.View createView() {
        return this;
    }

    @Override
    public void result(BaseResponse<LoginBean> data) {

    }

    @Override
    public void logoutResult(BaseResponse<LoginBean> data) {

    }

    @Override
    public void setMsg(String msg) {

    }

    @Override
    public <T> ObservableTransformer<T, T> bindLifecycle() {
        return this.bindToLifecycle();
    }
}
