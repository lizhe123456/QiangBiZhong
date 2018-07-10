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

}
