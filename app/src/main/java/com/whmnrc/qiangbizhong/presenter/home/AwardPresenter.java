package com.whmnrc.qiangbizhong.presenter.home;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;

import com.alibaba.fastjson.JSON;
import com.blankj.utilcode.util.ToastUtils;
import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseCall;
import com.whmnrc.qiangbizhong.model.bean.LuckDrawBean;
import com.whmnrc.qiangbizhong.model.bean.LuckDrawGoodsBean;
import com.whmnrc.qiangbizhong.model.bean.UserInfoBean;
import com.whmnrc.qiangbizhong.util.GsonUtil;
import com.whmnrc.qiangbizhong.util.OkhttpUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/15.
 */

public class AwardPresenter {

    private Activity context;
    private int page = 1;
    private int size = 10;

    public AwardPresenter(Activity context) {
        this.context = context;
    }

    public void getAwardList(AwardCall awardCall, boolean isR){
        Map<String,String> map = new HashMap<>();
        if (isR){
            page = 1;
        }
        map.put("PageIndex",page+"");
        map.put("PageCount",size+"");
        OkhttpUtil.post(context.getString(R.string.server_address)+context.getString(R.string.awardlist),map, new OkhttpUtil.BeanCallback() {
            @Override
            public void onSuccess(String data) {
                LuckDrawBean luckDrawBean = GsonUtil.changeGsonToBean(data,LuckDrawBean.class);
                if (awardCall != null){
                    if (isR) {
                        awardCall.awardBack(luckDrawBean);
                    }else {
                        awardCall.loadMore(luckDrawBean.getGoods());
                    }
                    page++;
                }
            }

            @Override
            public void onFailure(int code, String errorMsg) {
                if (awardCall != null){
                    awardCall.error();
                }
            }
        });
    }

    public void awardrecorduserlist(boolean isR,String awardId,UserCall userCall){
        Map<String, String> map = new HashMap<>();
        if (isR){
            page = 1;
        }
        map.put("PageIndex",page+"");
        map.put("PageCount",size+"");
        OkhttpUtil.post(context.getString(R.string.server_address)+context.getString(R.string.awardrecorduserlist)+"?awardId="+awardId,map, new OkhttpUtil.BeanCallback() {
            @Override
            public void onSuccess(String data) {
                List<UserInfoBean> userInfoBeans = GsonUtil.changeGsonToList(data,UserInfoBean.class);
                if (!context.isDestroyed()) {
                    if (userCall != null) {
                        if (isR) {
                            userCall.awardUserBack(userInfoBeans);
                        } else {
                            userCall.loadMore(userInfoBeans);
                        }
                        page++;
                    }
                }
            }

            @Override
            public void onFailure(int code, String errorMsg) {
                if (!context.isDestroyed()) {
                    if (userCall != null) {
                        userCall.error();
                    }
                }
            }
        });
    }

    public interface AwardCall extends BaseCall{

        void awardBack(@NonNull LuckDrawBean luckDrawBeans);

        void loadMore(@NonNull List<LuckDrawBean.GoodsBean> goodsBean);

    }

    public interface UserCall extends BaseCall{

        void awardUserBack(@NonNull List<UserInfoBean> list);

        void loadMore(@NonNull List<UserInfoBean> list);
    }

}
