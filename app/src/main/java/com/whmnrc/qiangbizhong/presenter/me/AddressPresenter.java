package com.whmnrc.qiangbizhong.presenter.me;

import android.content.Context;
import android.text.TextUtils;

import com.alibaba.fastjson.JSON;
import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.model.bean.AddressBean;
import com.whmnrc.qiangbizhong.util.OkhttpUtil;
import com.whmnrc.qiangbizhong.util.ToastUtil;
import com.whmnrc.qiangbizhong.util.UserManage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/13.
 */

public class AddressPresenter {

    Context context;

    public AddressPresenter(Context context) {
        this.context = context;
    }

    //收货地址
    public void addAddress(Map<String, String> params,AddressCall addressCall){
        OkhttpUtil.post(context.getString(R.string.server_address) + context.getString(R.string.addAddress),params, new OkhttpUtil.BeanCallback() {
            @Override
            public void onSuccess(String data) {
                if (addressCall != null){
                    addressCall.addressBack();
                }
            }

            @Override
            public void onFailure(int code, String errorMsg) {

            }

        });
    }

    //删除地址
    public void deleteAddress(){
        Map<String,String> map = new HashMap<>();
        OkhttpUtil.get(context.getString(R.string.server_address) + context.getString(R.string.deleteAddress),map, new OkhttpUtil.BeanCallback() {
            @Override
            public void onSuccess(String data) {

            }

            @Override
            public void onFailure(int code, String errorMsg) {

            }

        });
    }

    //添加地址
    public void getaddressList(AddManageCall addManageCall){
        Map<String,String> map = new HashMap<>();
        map.put("userId", UserManage.getInstance().getUserID());
        OkhttpUtil.get(context.getString(R.string.server_address) + context.getString(R.string.getaddresslist),map, new OkhttpUtil.BeanCallback() {
            @Override
            public void onSuccess(String data) {
                if (!TextUtils.isEmpty(data)) {
                    List<AddressBean> list = JSON.parseArray(data, AddressBean.class);
                    if (addManageCall != null){
                        addManageCall.getAddressList(list);
                    }
                }
            }

            @Override
            public void onFailure(int code, String errorMsg) {

            }

        });
    }

    public interface AddressCall{
        void addressBack();
    }

    public interface AddManageCall{
        void getAddressList(List<AddressBean> list);

        void deleteAddress();
    }

}
