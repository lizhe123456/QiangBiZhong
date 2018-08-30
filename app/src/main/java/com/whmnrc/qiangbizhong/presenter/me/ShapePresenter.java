package com.whmnrc.qiangbizhong.presenter.me;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;

import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseCall;
import com.whmnrc.qiangbizhong.util.OkhttpUtil;
import com.whmnrc.qiangbizhong.util.UserManage;

import java.util.HashMap;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/8/8.
 */

public class ShapePresenter {

    private Activity context;

    public ShapePresenter(Activity context) {
        this.context = context;
    }

    public void getshardcode(CodeCall codeCall){
        OkhttpUtil.get(context.getString(R.string.server_address) + context.getString(R.string.getshardcode) + "?userId=" + UserManage.getInstance().getUserID(), new HashMap<>(), new OkhttpUtil.BeanCallback() {
            @Override
            public void onSuccess(String data) {
                if (!context.isDestroyed()) {
                    if (codeCall != null) {
//                    "data:image/jpg;base64,"+
                        codeCall.code(data);
                    }
                }
            }

            @Override
            public void onFailure(int code, String errorMsg) {
                if (!context.isDestroyed()) {
                    if (codeCall != null) {
                        codeCall.error();
                    }
                }
            }
        });
    }

    public interface CodeCall extends BaseCall{

        void code(@NonNull String code);
    }

}
