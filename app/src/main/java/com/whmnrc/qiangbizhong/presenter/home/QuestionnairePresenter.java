package com.whmnrc.qiangbizhong.presenter.home;

import android.content.Context;

import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseCall;
import com.whmnrc.qiangbizhong.model.parameter.QuestionnaireParam;
import com.whmnrc.qiangbizhong.util.GsonUtil;
import com.whmnrc.qiangbizhong.util.OkhttpUtil;

import java.util.List;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/8/15.
 */

public class QuestionnairePresenter {

    private Context context;

    public QuestionnairePresenter(Context context) {
        this.context = context;
    }


    public void submitquestion(String phone, List<QuestionnaireParam> questionnaireParams,QuestionnaireCall questionnaireCall){
        OkhttpUtil.postString(context.getString(R.string.server_address) + context.getString(R.string.submitquestion)
                + "?phone=" + phone, GsonUtil.createGsonString(questionnaireParams), new OkhttpUtil.BeanCallback() {
            @Override
            public void onSuccess(String data) {
                if (questionnaireCall != null){
                    questionnaireCall.submitS();
                }
            }

            @Override
            public void onFailure(int code, String errorMsg) {
                if (questionnaireCall != null){
                    questionnaireCall.error();
                }
            }
        });
    }

    public interface QuestionnaireCall extends BaseCall{
        void submitS();
    }

}
