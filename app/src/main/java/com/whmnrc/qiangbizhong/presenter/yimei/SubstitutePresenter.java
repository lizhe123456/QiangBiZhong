package com.whmnrc.qiangbizhong.presenter.yimei;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;

import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseCall;
import com.whmnrc.qiangbizhong.util.OkhttpUtil;

import java.util.HashMap;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/8/13.
 */

public class SubstitutePresenter {

    Activity context;

    public SubstitutePresenter(Activity context) {
        this.context = context;
    }

    //代付
    public void getAgentUserId(String phone,AgentUserIdCall agentUserIdCall){
        OkhttpUtil.get(context.getString(R.string.server_address) + context.getString(R.string.getagentuserid) + "?phone=" + phone
                , new HashMap<>(), new OkhttpUtil.BeanCallback() {
                    @Override
                    public void onSuccess(String data) {
                        if (!context.isDestroyed()) {
                            if (agentUserIdCall != null) {
                                agentUserIdCall.getAgentUserIdS(data);
                            }
                        }
                    }

                    @Override
                    public void onFailure(int code, String errorMsg) {
                        if (!context.isDestroyed()) {
                            if (agentUserIdCall != null) {
                                agentUserIdCall.error();
                            }
                        }
                    }
                });


    }

    public interface AgentUserIdCall extends BaseCall{
        void getAgentUserIdS(@NonNull String userId);
    }

}
