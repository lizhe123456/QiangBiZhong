package com.whmnrc.qiangbizhong.presenter.me;

import android.content.Context;
import android.text.TextUtils;

import com.alibaba.fastjson.JSON;
import com.blankj.utilcode.util.EncryptUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.app.App;
import com.whmnrc.qiangbizhong.base.BaseCall;
import com.whmnrc.qiangbizhong.base.BaseResponse;
import com.whmnrc.qiangbizhong.model.bean.LoginBean;
import com.whmnrc.qiangbizhong.util.GsonUtil;
import com.whmnrc.qiangbizhong.util.OkhttpUtil;
import com.whmnrc.qiangbizhong.util.ToastUtil;
import com.whmnrc.qiangbizhong.util.UserManage;
import com.zhy.http.okhttp.OkHttpUtils;

import java.util.HashMap;
import java.util.Map;


/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/10.
 */

public class LoginPresenter{

    private Context context;

    public LoginPresenter(Context context) {
        this.context = context;
    }

    // 0 密码 1 验证码
    public void login(String phone, String pwd, String code, int type, final LoginCall loginCall){
        Map<String,String> map = new HashMap<>();
        map.put("LoginType",type+"");
        map.put("Phone",phone);
        if (type == 0){
            map.put("Pwd",EncryptUtils.encryptMD5ToString(pwd));
        }else {
            map.put("Code",code);
        }

        OkhttpUtil.post(App.getContext().getString(R.string.server_address) + App.getContext().getString(R.string.login), map, new OkhttpUtil.BeanCallback() {
            @Override
            public void onSuccess(String st) {
                if (!TextUtils.isEmpty(st)) {
                    LoginBean response = JSON.parseObject(st,LoginBean.class);
                    loginCall.loginBack(response);
                }
            }

            @Override
            public void onFailure(int code, String errorMsg) {

            }

        });
    }

    public void sendsmscode(String phone){
        Map<String,String> map = new HashMap<>();
        map.put("phone",phone);
        OkhttpUtil.get(App.getContext().getString(R.string.server_address) + App.getContext().getString(R.string.sendSmsCode), map, new OkhttpUtil.ObjectCallback() {
            @Override
            public void onSuccess(String st) {
                if (!TextUtils.isEmpty(st)) {
                    BaseResponse response = GsonUtil.changeGsonToBean(st,BaseResponse.class);
                    if (response.getStatus() == 1){
                        ToastUtils.showShort("验证码发送成功");
                        return;
                    }
                    ToastUtils.showShort(response.getMessage());
                }

            }

            @Override
            public void onFailure(int code, String errorMsg) {
                ToastUtils.showShort(errorMsg);
            }
        });
    }

    public void register (String phone,String pwd, String code,RegisterCall registerCall){
        Map<String,String> map = new HashMap<>();
        map.put("Phone",phone);
        map.put("Pwd", EncryptUtils.encryptMD5ToString(pwd));
        map.put("Code",code);
        OkhttpUtil.post(App.getContext().getString(R.string.server_address) + App.getContext().getString(R.string.register), map, new OkhttpUtil.BeanCallback() {
            @Override
            public void onSuccess(String st) {
                ToastUtils.showShort("注册成功");
                if (registerCall != null){
                    registerCall.registerBack();
                }
            }

            @Override
            public void onFailure(int code, String errorMsg) {

            }

        });
    }

    public void updatePwd(String pwd,String newPwd,UpdatePwdCall updatePwdCall){
        Map<String,String> map = new HashMap<>();
        map.put("UserId", UserManage.getInstance().getUserID());
        map.put("Pwd",EncryptUtils.encryptMD5ToString(pwd));
        map.put("NewPwd",EncryptUtils.encryptMD5ToString(newPwd));
        OkhttpUtil.post(context.getString(R.string.server_address) + context.getString(R.string.updatePwd),map, new OkhttpUtil.BeanCallback(){

            @Override
            public void onSuccess(String data) {
                if (updatePwdCall != null){
                    updatePwdCall.updatePaw();
                }
            }

            @Override
            public void onFailure(int code, String errorMsg) {
                if (updatePwdCall != null){
                    updatePwdCall.error();
                }
            }
        });
    }

    public void updatePayPass(String pwd, String code, UpdatePwdCall updatePwdCall){
        Map<String,String> map = new HashMap<>();
        map.put("UserId",UserManage.getInstance().getUserID());
        map.put("Phone",UserManage.getInstance().getLoginBean().getUserInfo_Mobile());
        map.put("PayPwd",EncryptUtils.encryptMD5ToString(pwd));
        map.put("Code",code);
        OkhttpUtil.post(context.getString(R.string.server_address) + context.getString(R.string.updatePayPwd), map, new OkhttpUtil.BeanCallback(){

            @Override
            public void onSuccess(String data) {
                if (updatePwdCall != null){
                    updatePwdCall.updatePaw();
                }
            }

            @Override
            public void onFailure(int code, String errorMsg) {
                if (updatePwdCall != null){
                    updatePwdCall.error();
                }
            }
        });

    }

    public void retrievePwd(String phone, String pwd, String code, ZhaoPassCall zhaoPassCall){
        Map<String, String> map = new HashMap<>();
        map.put("phone", phone);
        map.put("pwd", pwd);
        map.put("code", code);
        OkhttpUtil.get(context.getString(R.string.server_address) + context.getString(R.string.retrievePwd), map, new OkhttpUtil.BeanCallback() {
            @Override
            public void onSuccess(String data) {
                if (zhaoPassCall != null){
                    zhaoPassCall.zhaoPassBack();
                }
            }

            @Override
            public void onFailure(int code, String errorMsg) {
                if (zhaoPassCall != null){
                    zhaoPassCall.error();
                }
            }
        });
    }

    public interface LoginCall extends BaseCall {
        void loginBack(LoginBean loginBean);
    }

    public interface RegisterCall extends BaseCall{
        void registerBack();
    }

    public interface UpdatePwdCall extends BaseCall{
        void updatePaw();
    }

    public interface ZhaoPassCall extends BaseCall{
        void zhaoPassBack();
    }

}
