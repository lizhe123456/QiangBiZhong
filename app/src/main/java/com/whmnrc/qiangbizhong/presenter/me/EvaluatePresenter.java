package com.whmnrc.qiangbizhong.presenter.me;

import android.content.Context;

import com.blankj.utilcode.util.ToastUtils;
import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseCall;
import com.whmnrc.qiangbizhong.model.bean.CommentBean;
import com.whmnrc.qiangbizhong.ui.shopping.activity.param.EvaluateParam;
import com.whmnrc.qiangbizhong.util.GsonUtil;
import com.whmnrc.qiangbizhong.util.OkhttpUtil;
import com.whmnrc.qiangbizhong.util.ToastUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/8/2.
 */

public class EvaluatePresenter {

    private Context context;

    private int page;

    public EvaluatePresenter(Context context) {
        this.context = context;
    }

    public void evaluate(List<EvaluateParam> evaluateParams,EvaluateCallBack evaluateCallBack){
        OkhttpUtil.postString(context.getString(R.string.server_address) + context.getString(R.string.submitcommentinfo), GsonUtil.createGsonString(evaluateParams), new OkhttpUtil.BeanCallback() {
            @Override
            public void onSuccess(String data) {
                if (evaluateCallBack != null){
                    evaluateCallBack.evaluateS();
                }
                ToastUtils.showShort("评论成功");
            }

            @Override
            public void onFailure(int code, String errorMsg) {
                if (evaluateCallBack != null){
                    evaluateCallBack.error();
                }
            }
        });
    }

    public void evaluateList(String goodsId,boolean isR,EvaluateListCall evaluateListCall){
        Map<String,String> map = new HashMap<>();
        if (isR){
            page = 1;
        }
        map.put("PageIndex",page+"");
        map.put("PageCount","10");
        OkhttpUtil.post(context.getString(R.string.server_address) + context.getString(R.string.getcommentlist ) +
                "?goodsId=" + goodsId
                , map, new OkhttpUtil.BeanCallback() {
            @Override
            public void onSuccess(String data) {
                List<CommentBean> commentBeans = GsonUtil.changeGsonToList(data,CommentBean.class);
                if (evaluateListCall != null){
                    if (isR){
                        evaluateListCall.evaluateList(commentBeans);
                    }else {
                        evaluateListCall.loadMore(commentBeans);
                    }
                   page++;
                }
            }

            @Override
            public void onFailure(int code, String errorMsg) {
                if (evaluateListCall != null){
                    evaluateListCall.error();
                }
            }
        });
    }


    public interface EvaluateCallBack extends BaseCall{
        void evaluateS();
    }

    public interface EvaluateListCall extends BaseCall{

        void evaluateList(List<CommentBean> commentBeans);

        void loadMore(List<CommentBean> commentBeans);

    }
}
