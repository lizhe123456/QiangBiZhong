package com.whmnrc.qiangbizhong.presenter.shop;

import android.content.Context;
import android.support.annotation.NonNull;

import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseCall;
import com.whmnrc.qiangbizhong.model.bean.ClassifyBean;
import com.whmnrc.qiangbizhong.util.GsonUtil;
import com.whmnrc.qiangbizhong.util.OkhttpUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/8/7.
 */

public class ClassifyPresenter {

    Context context;

    public ClassifyPresenter(Context context) {
        this.context = context;
    }

    public void getClassifyList(int type,ClassifyListCall classifyListCall){
        Map<String,String> map = new HashMap<>();
        OkhttpUtil.get(context.getString(R.string.server_address) + context.getString(R.string.getgoodstypelist) + "?type=" + type, map, new OkhttpUtil.BeanCallback() {
            @Override
            public void onSuccess(String data) {
                List<ClassifyBean> classifyBeans = GsonUtil.changeGsonToList(data,ClassifyBean.class);
                if (classifyListCall != null){
                    if (classifyBeans != null) {
                        classifyListCall.classifyListBack(classifyBeans);
                    }
                }

            }

            @Override
            public void onFailure(int code, String errorMsg) {

            }
        });
    }

    public interface ClassifyListCall extends BaseCall{
        void classifyListBack(@NonNull List<ClassifyBean> classifyBeans);
    }
}
