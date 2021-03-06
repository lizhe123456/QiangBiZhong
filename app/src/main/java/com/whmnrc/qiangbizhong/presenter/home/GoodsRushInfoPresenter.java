package com.whmnrc.qiangbizhong.presenter.home;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.alibaba.fastjson.JSON;
import com.blankj.utilcode.util.EncryptUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseCall;
import com.whmnrc.qiangbizhong.model.bean.AwardBeanInfo;
import com.whmnrc.qiangbizhong.model.bean.GoodsRushinfoBean;
import com.whmnrc.qiangbizhong.presenter.me.OrderPresenter;
import com.whmnrc.qiangbizhong.ui.me.activity.MyOrderActivity;
import com.whmnrc.qiangbizhong.util.GsonUtil;
import com.whmnrc.qiangbizhong.util.OkhttpUtil;
import com.whmnrc.qiangbizhong.util.UserManage;

import java.util.HashMap;
import java.util.Map;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/13.
 */

public class GoodsRushInfoPresenter {

    private Activity context;

    public GoodsRushInfoPresenter(Activity context) {
        this.context = context;
    }

    public void getGoodsInfo(String goodId,GoodsInfoCall goodsInfoCall){
        Map<String,String> map = new HashMap<>();
        if (UserManage.getInstance().getUserID() != null) {
            map.put("userId", UserManage.getInstance().getUserID());
            map.put("rushId", goodId);
            OkhttpUtil.get(context.getString(R.string.server_address) + context.getString(R.string.goodsrushinfo), map, new OkhttpUtil.BeanCallback() {
                @Override
                public void onSuccess(String data) {
                    try {
                        if (!TextUtils.isEmpty(data)) {
                            GoodsRushinfoBean goodsRushinfoBean = GsonUtil.changeGsonToBean(data, GoodsRushinfoBean.class);
                            if (!context.isDestroyed()) {
                                if (goodsInfoCall != null) {
                                    goodsInfoCall.goodsInfoBack(goodsRushinfoBean);
                                }
                            }
                        }
                    }catch (Exception e) {
                        ToastUtils.showShort("数据解析失败");
                    }
                }

                @Override
                public void onFailure(int code, String errorMsg) {
                    if (!context.isDestroyed()) {
                        if (goodsInfoCall != null) {
                            goodsInfoCall.error();
                        }
                    }
                }

            });
        }
    }

    public void cayu(String goodId,CanYuCall canYuCall){
        Map<String,String> map = new HashMap<>();
        map.put("userId", UserManage.getInstance().getUserID());
        map.put("goodsRushId",goodId);
        OkhttpUtil.get(context.getString(R.string.server_address) + context.getString(R.string.rushbuy),map, new OkhttpUtil.BeanCallback() {
            @Override
            public void onSuccess(String data) {
                UserManage.getInstance().getUserInfo(null);
                context.finish();
                MyOrderActivity.start(context,4);
                if (!TextUtils.isEmpty(data)){

                }
            }

            @Override
            public void onFailure(int code, String errorMsg) {
                if (!context.isDestroyed()) {
                    if (code == 101 && errorMsg.equals("101")) {
                        if (canYuCall != null) {
                            canYuCall.canyuBack();
                        }
                    } else {
                        if (canYuCall != null) {
                            canYuCall.error();
                        }
                    }
                }
            }

        });
    }

    //抽奖详情
    public void awardInfo(String awardId,AwardCall awardCall){
        Map<String,String> map = new HashMap<>();
        OkhttpUtil.get(context.getString(R.string.server_address) + context.getString(R.string.awardInfo) + "?awardId="+awardId +"&userId="+UserManage.getInstance().getUserID(),map, new OkhttpUtil.BeanCallback() {
            @Override
            public void onSuccess(String data) {
                try {
                    AwardBeanInfo awardBeanInfo = GsonUtil.changeGsonToBean(data,AwardBeanInfo.class);
                    if (!context.isDestroyed()) {
                        if (awardCall != null) {
                            awardCall.awardBack(awardBeanInfo);
                        }
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(int code, String errorMsg) {
                if (!context.isDestroyed()) {
                    if (code == 101 && errorMsg.equals("101")) {
                        if (awardCall != null) {
                            awardCall.canyuBack();
                        }
                    } else {
                        if (awardCall != null) {
                            awardCall.error();
                        }
                    }
                }
            }
        });
    }

    //抽奖详情
    public void awardInfo(String userId,String awardId,AwardCall awardCall){
        Map<String,String> map = new HashMap<>();
        OkhttpUtil.get(context.getString(R.string.server_address) + context.getString(R.string.awardInfo) + "?awardId="+awardId +"&userId="+userId,map, new OkhttpUtil.BeanCallback() {
            @Override
            public void onSuccess(String data) {
                try {
                    AwardBeanInfo awardBeanInfo = GsonUtil.changeGsonToBean(data,AwardBeanInfo.class);
                    if (!context.isDestroyed()) {
                        if (awardCall != null) {
                            awardCall.awardBack(awardBeanInfo);
                        }
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(int code, String errorMsg) {
                if (!context.isDestroyed()) {
                    if (code == 101 && errorMsg.equals("101")) {
                        if (awardCall != null) {
                            awardCall.canyuBack();
                        }
                    } else {
                        if (awardCall != null) {
                            awardCall.error();
                        }
                    }
                }
            }
        });
    }

    //验证密码
    public void yzPass(String pwd, OrderPresenter.PayPassCall payPassCall){
        Map<String, String> map = new HashMap<>();
        map.put("userId",UserManage.getInstance().getUserID());
        map.put("pwd", EncryptUtils.encryptMD5ToString(pwd));
        OkhttpUtil.get(context.getString(R.string.server_address) + context.getString(R.string.validatePay), map, new OkhttpUtil.BeanCallback() {
            @Override
            public void onSuccess(String data) {
                if (!context.isDestroyed()) {
                    if (payPassCall != null) {
                        payPassCall.payPassBack();
                    }
                }
            }

            @Override
            public void onFailure(int code, String errorMsg) {
                if (!context.isDestroyed()) {
                    if (payPassCall != null) {
                        payPassCall.error();
                    }
                }
            }
        });
    }




    public interface GoodsInfoCall extends BaseCall {

        void goodsInfoBack(@NonNull GoodsRushinfoBean goodsRushinfoBean);

    }

    public interface CanYuCall extends BaseCall{

        void canyuBack();

    }

    public interface AwardCall extends BaseCall{

        void awardBack(@NonNull AwardBeanInfo awardBeanInfo);

        void canyuBack();
    }


}
