package com.whmnrc.qiangbizhong.presenter.yimei;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;

import com.blankj.utilcode.util.ToastUtils;
import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseCall;
import com.whmnrc.qiangbizhong.model.bean.NewsBean;
import com.whmnrc.qiangbizhong.util.GsonUtil;
import com.whmnrc.qiangbizhong.util.OkhttpUtil;
import com.whmnrc.qiangbizhong.util.UserManage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/8/14.
 */

public class NewsPresenter {

    private Activity context;

    private int page;

    public NewsPresenter(Activity context) {
        this.context = context;
    }


    public void getmessagenotice(boolean isR,MessageNoticeCall messageNoticeCall){
        Map<String,String> map = new HashMap<>();
        if (isR){
            page = 1;
        }
        map.put("PageIndex",page+"");
        map.put("PageCount","10");
        OkhttpUtil.post(context.getString(R.string.server_address) + context.getString(R.string.getmessagenotice)
                +"?userId="+ UserManage.getInstance().getUserID(), map, new OkhttpUtil.BeanCallback() {
            @Override
            public void onSuccess(String data) {
                List<NewsBean> newsBeans = GsonUtil.changeGsonToList(data,NewsBean.class);
                if (!context.isDestroyed()) {
                    if (isR) {
                        messageNoticeCall.getmessagenotice(newsBeans);
                    } else {
                        messageNoticeCall.loadMore(newsBeans);
                    }
                    page++;
                }
            }

            @Override
            public void onFailure(int code, String errorMsg) {
                if (!context.isDestroyed()) {
                    if (messageNoticeCall != null) {
                        messageNoticeCall.error();
                    }
                }
            }
        });
    }

    public void setnoticeisread(String noticeId){
        Map<String,String> map = new HashMap<>();


        OkhttpUtil.get(context.getString(R.string.server_address) + context.getString(R.string.setnoticeisread)
                +"?noticeId="+ noticeId, map, new OkhttpUtil.BeanCallback() {
            @Override
            public void onSuccess(String data) {

            }

            @Override
            public void onFailure(int code, String errorMsg) {

            }
        });
    }

    public void feedback(String text,FeedbackCall feedbackCall){
        OkhttpUtil.get(context.getString(R.string.server_address) + context.getString(R.string.feedback)
                +"?userId="+ UserManage.getInstance().getUserID() + "&context=" + text, new HashMap<>(), new OkhttpUtil.BeanCallback() {
            @Override
            public void onSuccess(String data) {
                if (!context.isDestroyed()) {
                    if (feedbackCall != null) {
                        feedbackCall.feedBack();
                    }
                    ToastUtils.showShort("提交成功");
                }
            }

            @Override
            public void onFailure(int code, String errorMsg) {
                if (!context.isDestroyed()) {
                    if (feedbackCall != null) {
                        feedbackCall.error();
                    }
                }
            }
        });
    }


    public interface MessageNoticeCall extends BaseCall{
        void getmessagenotice(@NonNull List<NewsBean> newsBeans);

        void loadMore(@NonNull List<NewsBean> newsBeans);
    }

    public interface FeedbackCall extends BaseCall{
        void feedBack();
    }

}
