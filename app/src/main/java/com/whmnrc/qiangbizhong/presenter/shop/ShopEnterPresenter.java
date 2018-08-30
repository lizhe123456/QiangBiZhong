package com.whmnrc.qiangbizhong.presenter.shop;

import android.app.Activity;
import android.content.Context;

import com.blankj.utilcode.util.ToastUtils;
import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseCall;
import com.whmnrc.qiangbizhong.ui.shop.shopenter.ShopEnterP;
import com.whmnrc.qiangbizhong.util.GsonUtil;
import com.whmnrc.qiangbizhong.util.OkhttpUtil;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/8/6.
 */

public class ShopEnterPresenter {

    private Activity context;

    public ShopEnterPresenter(Activity context) {
        this.context = context;
    }

    public void submitadmission(ShopEnterP shopEnterP,SubmitadmissionCall submitadmissionCall){
        OkhttpUtil.postString(context.getString(R.string.server_address) + context.getString(R.string.submitadmission),
                GsonUtil.createGsonString(shopEnterP), new OkhttpUtil.BeanCallback() {
                    @Override
                    public void onSuccess(String data) {
                        if (!context.isDestroyed()) {
                            if (submitadmissionCall != null) {
                                submitadmissionCall.submitadmissionBack();
                            }
                            ToastUtils.showShort("提交成功");
                        }
                    }

                    @Override
                    public void onFailure(int code, String errorMsg) {
                        if (!context.isDestroyed()) {
                            if (submitadmissionCall != null) {
                                submitadmissionCall.error();
                            }
                        }
                    }
                });
    }

    public interface SubmitadmissionCall extends BaseCall{
        void submitadmissionBack();
    }
}
