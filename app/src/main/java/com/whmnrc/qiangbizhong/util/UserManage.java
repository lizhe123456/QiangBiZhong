package com.whmnrc.qiangbizhong.util;

import com.blankj.utilcode.util.SPUtils;
import com.google.gson.JsonSyntaxException;
import com.whmnrc.qiangbizhong.model.bean.LoginBean;

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

    public void updateLoginBena(LoginBean loginBean){
        try {
            SPUtils.getInstance().put("loginBean",GsonUtil.createGsonString(loginBean));
        } catch (Exception e) {

        }
    }

    public void layout(){
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
            return null;
        }
        return loginBean.getUserInfo_ID();
    }
}
