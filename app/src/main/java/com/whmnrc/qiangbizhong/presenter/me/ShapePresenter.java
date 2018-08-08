package com.whmnrc.qiangbizhong.presenter.me;

import android.content.Context;

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

    private Context context;

    public ShapePresenter(Context context) {
        this.context = context;
    }

    public void getshardcode(CodeCall codeCall){
        OkhttpUtil.get(context.getString(R.string.server_address) + context.getString(R.string.getshardcode) + "?userId=" + UserManage.getInstance().getUserID(), new HashMap<>(), new OkhttpUtil.BeanCallback() {
            @Override
            public void onSuccess(String data) {
                if (codeCall != null){
                    codeCall.code("data:image/jpg;base64,"+data);
                }
            }

            @Override
            public void onFailure(int code, String errorMsg) {
                if (codeCall != null){
                    codeCall.error();
                }
            }
        });
    }

    public interface CodeCall extends BaseCall{

        void code(String code);
    }

}
