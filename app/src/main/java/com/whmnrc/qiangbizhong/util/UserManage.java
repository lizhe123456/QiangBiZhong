package com.whmnrc.qiangbizhong.util;

import android.text.TextUtils;

import com.alibaba.fastjson.JSON;
import com.blankj.utilcode.util.EncryptUtils;
import com.blankj.utilcode.util.SPUtils;
import com.google.gson.JsonSyntaxException;
import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.app.App;
import com.whmnrc.qiangbizhong.model.bean.LoginBean;
import com.whmnrc.qiangbizhong.presenter.me.LoginPresenter;

import java.util.HashMap;
import java.util.Map;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/10.
 */

public class UserManage {

    private static UserManage userManage;
    private static String serverTime;

    public synchronized static UserManage getInstance() {
        if (userManage == null) {
            return new UserManage();
        }
        return userManage;
    }

    public LoginBean getLoginBean() {
        LoginBean loginBean = null;
        try {
            loginBean = GsonUtil.changeGsonToBean(SPUtils.getInstance().getString("loginBean"), LoginBean.class);
        } catch (Exception e) {
            return null;
        }
        return loginBean;
    }

    public void updateLoginBena(LoginBean loginBean) {
        try {
            SPUtils.getInstance().put("loginBean", GsonUtil.createGsonString(loginBean));
        } catch (Exception e) {

        }
    }

    public void layout() {
        SPUtils.getInstance().remove("loginBean");
    }

    public static UserManage getUserManage() {
        return userManage;
    }

    public static void setUserManage(UserManage userManage) {
        UserManage.userManage = userManage;
    }

    public String getServerTime() {
        return serverTime;
    }

    public void setServerTime(String serverTime) {
        UserManage.serverTime = serverTime;
    }

    public String getUserID() {
        LoginBean loginBean = null;
        try {
            loginBean = GsonUtil.changeGsonToBean(SPUtils.getInstance().getString("loginBean"), LoginBean.class);
        } catch (Exception e) {
            return "";
        }
        if (loginBean != null) {
            return loginBean.getUserInfo_ID() == null ? "" : loginBean.getUserInfo_ID();
        }
        return "";
    }

    public void getUserInfo(UserInfoCall userInfoCall) {
        LoginBean loginBean = getLoginBean();
        if (loginBean != null) {
            Map<String, String> map = new HashMap<>();
            map.put("LoginType", 0 + "");
            map.put("Phone", loginBean.getUserInfo_Mobile());
            map.put("Pwd", loginBean.getUserInfo_Pwd());

            OkhttpUtil.post(App.getContext().getString(R.string.server_address) + App.getContext().getString(R.string.login), map, new OkhttpUtil.BeanCallback() {
                @Override
                public void onSuccess(String st) {
                    if (!TextUtils.isEmpty(st)) {
                        LoginBean response = GsonUtil.changeGsonToBean(st, LoginBean.class);
                        if (userInfoCall != null) {
                            userInfoCall.userInfoBack(response);
                        }
                        updateLoginBena(response);
                    }
                }

                @Override
                public void onFailure(int code, String errorMsg) {

                }

            });
        }
    }


    public interface UserInfoCall {
        void userInfoBack(LoginBean loginBean);
    }
}
