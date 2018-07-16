package com.whmnrc.qiangbizhong.presenter.home;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;

import com.alibaba.fastjson.JSON;
import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.model.bean.AwardBeanInfo;
import com.whmnrc.qiangbizhong.model.bean.GoodsRushinfoBean;
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
        map.put("userId", UserManage.getInstance().getUserID());
        map.put("rushId",goodId);
        OkhttpUtil.get(context.getString(R.string.server_address) + context.getString(R.string.goodsrushinfo),map, new OkhttpUtil.BeanCallback() {
            @Override
            public void onSuccess(String data) {
                if (!TextUtils.isEmpty(data)){
                    GoodsRushinfoBean goodsRushinfoBean = JSON.parseObject(data,GoodsRushinfoBean.class);
                    if (goodsInfoCall != null){
                        goodsInfoCall.goodsInfoBack(goodsRushinfoBean);
                    }
                }
            }

            @Override
            public void onFailure(int code, String errorMsg) {

            }

        });
    }

    public void cayu(String goodId){
        Map<String,String> map = new HashMap<>();
        map.put("userId", UserManage.getInstance().getUserID());
        map.put("goodsRushId",goodId);
        OkhttpUtil.get(context.getString(R.string.server_address) + context.getString(R.string.rushbuy),map, new OkhttpUtil.BeanCallback() {
            @Override
            public void onSuccess(String data) {
                MyOrderActivity.start(context,4);
                context.finish();
                if (!TextUtils.isEmpty(data)){

                }
            }

            @Override
            public void onFailure(int code, String errorMsg) {

            }

        });
    }

    //抽奖详情
    public void awardInfo(String awardId,AwardCall awardCall){
        Map<String,String> map = new HashMap<>();
        OkhttpUtil.get(context.getString(R.string.server_address) + context.getString(R.string.awardInfo) + "?awardId="+awardId,map, new OkhttpUtil.BeanCallback() {
            @Override
            public void onSuccess(String data) {
                AwardBeanInfo awardBeanInfo = GsonUtil.changeGsonToBean(data,AwardBeanInfo.class);
                if (awardCall != null){
                    awardCall.awardBack(awardBeanInfo);
                }
            }

            @Override
            public void onFailure(int code, String errorMsg) {

            }
        });
    }

    public void awardSubmitOrder(String awardId,String addressId){
        Map<String,String> map = new HashMap<>();
        map.put("awardId", awardId);
        map.put("userId", UserManage.getInstance().getUserID());
        map.put("addressId", addressId);
        OkhttpUtil.post(context.getString(R.string.server_address)+context.getString(R.string.awardSubmitOrder),map, new OkhttpUtil.BeanCallback() {
            @Override
            public void onSuccess(String data) {
                MyOrderActivity.start(context,4);
                context.finish();
                if (!TextUtils.isEmpty(data)){

                }
            }

            @Override
            public void onFailure(int code, String errorMsg) {

            }
        });
    }


    public interface GoodsInfoCall{

        void goodsInfoBack(GoodsRushinfoBean goodsRushinfoBean);

    }

    public interface CanYuCall{

        void canyuBack();

    }

    public interface AwardCall{

        void awardBack(AwardBeanInfo awardBeanInfo);
    }


}
