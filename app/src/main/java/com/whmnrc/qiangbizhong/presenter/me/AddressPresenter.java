package com.whmnrc.qiangbizhong.presenter.me;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseCall;
import com.whmnrc.qiangbizhong.model.bean.AddressBean;
import com.whmnrc.qiangbizhong.util.GsonUtil;
import com.whmnrc.qiangbizhong.util.OkhttpUtil;
import com.whmnrc.qiangbizhong.util.UserManage;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/13.
 */

public class AddressPresenter {

    private Activity context;

    public AddressPresenter(Activity context) {
        this.context = context;
    }

    //收货地址
    public void addAddress(Map<String, String> params,AddressCall addressCall){
        OkhttpUtil.post(context.getString(R.string.server_address) + context.getString(R.string.addAddress),params, new OkhttpUtil.BeanCallback() {
            @Override
            public void onSuccess(String data) {
                if (!context.isDestroyed()) {
                    if (addressCall != null) {
                        addressCall.addressBack();
                    }
                }
            }

            @Override
            public void onFailure(int code, String errorMsg) {

            }

        });
    }

    //删除地址
    public void deleteAddress(String addressId,AddManageCall addManageCall){
        Map<String,String> map = new HashMap<>();
        map.put("addressId",addressId);
        OkhttpUtil.get(context.getString(R.string.server_address) + context.getString(R.string.deleteAddress),map, new OkhttpUtil.BeanCallback() {
            @Override
            public void onSuccess(String data) {
                if (!context.isDestroyed()) {
                    if (addManageCall != null) {
                        addManageCall.updateData();
                    }
                }
            }

            @Override
            public void onFailure(int code, String errorMsg) {

            }

        });
    }

    public void setDefault(String addressId,AddManageCall addManageCall){
        Map<String,String> map = new HashMap<>();
        map.put("addressId",addressId);
        map.put("userId",UserManage.getInstance().getUserID());
        OkhttpUtil.get(context.getString(R.string.server_address) + context.getString(R.string.setdefault),map, new OkhttpUtil.BeanCallback() {
            @Override
            public void onSuccess(String data) {
                if (!context.isDestroyed()) {
                    if (addManageCall != null) {
                        addManageCall.updateData();
                    }
                }
            }

            @Override
            public void onFailure(int code, String errorMsg) {

            }

        });
    }

    //添加地址
    public void getaddressList(AddManageCall addManageCall){
        Map<String,String> map = new HashMap<>();
        OkhttpUtil.get(context.getString(R.string.server_address) + context.getString(R.string.getaddresslist) + "?userId="+UserManage.getInstance().getUserID(),map, new OkhttpUtil.BeanCallback() {
            @Override
            public void onSuccess(String data) {
                if (!TextUtils.isEmpty(data)) {
                    List<AddressBean> list = GsonUtil.changeGsonToList(data, AddressBean.class);
                    if (!context.isDestroyed()) {
                        if (addManageCall != null) {
                            addManageCall.getAddressList(list);
                        }
                    }
                }
            }

            @Override
            public void onFailure(int code, String errorMsg) {
                if (!context.isDestroyed()) {
                    if (addManageCall != null) {
                        addManageCall.error();
                    }
                }
            }

        });
    }

    public interface AddressCall extends BaseCall {
        void addressBack();
    }

    public interface AddManageCall extends BaseCall{
        void getAddressList(@NonNull List<AddressBean> list);

        void updateData();
    }

}
