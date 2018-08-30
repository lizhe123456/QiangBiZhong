package com.whmnrc.qiangbizhong.presenter.me;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.alibaba.fastjson.JSON;
import com.blankj.utilcode.util.ToastUtils;
import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseCall;
import com.whmnrc.qiangbizhong.model.bean.AgentBean;
import com.whmnrc.qiangbizhong.model.bean.RechargeBean;
import com.whmnrc.qiangbizhong.model.bean.RechargeCoreBean;
import com.whmnrc.qiangbizhong.model.bean.RechargeRrecordBean;
import com.whmnrc.qiangbizhong.model.parameter.AgentshopParam;
import com.whmnrc.qiangbizhong.pay.alipay.AliPayTools;
import com.whmnrc.qiangbizhong.pay.listener.OnSuccessAndErrorListener;
import com.whmnrc.qiangbizhong.util.GsonUtil;
import com.whmnrc.qiangbizhong.util.OkhttpUtil;
import com.whmnrc.qiangbizhong.util.ToastUtil;
import com.whmnrc.qiangbizhong.util.UserManage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/14.
 * OrderType 0 供应商 1 会员 2普通
 */

public class RechargePresenter {

    private Activity context;

    private int page;

    public RechargePresenter(Activity context) {
        this.context = context;
    }


    public void submitorder(String monery,String orderType,String agentshopId,String agentShopDiscountId,RechargeCall rechargeCall){
        Map<String,String> map = new HashMap<>();
        map.put("UserId", UserManage.getInstance().getUserID());
        if (orderType.equals("0")){
            map.put("AgentshopId",agentshopId);
            map.put("AgentShopDiscountId",agentShopDiscountId);
        }else if (orderType.equals("1")){

        }else if (orderType.equals("2")){

        }
        map.put("OrderType",orderType);
        map.put("Count",monery);
        OkhttpUtil.post(context.getString(R.string.server_address) + context.getString(R.string.submitorder),map, new OkhttpUtil.BeanCallback() {
            @Override
            public void onSuccess(String data) {
                if (!context.isDestroyed()) {
                    if (data != null) {
                        pay(data, rechargeCall);
                    } else {
                        ToastUtils.showShort("请确认支付宝是否安装");
                    }
                }
            }

            @Override
            public void onFailure(int code, String errorMsg) {

            }
        });
    }

    public void rechargeQuery(int type,RechargeCall rechargeCall){
        Map<String,String> map = new HashMap<>();
        map.put("isVip",type+"");
        map.put("userId",UserManage.getInstance().getUserID());
        OkhttpUtil.get(context.getString(R.string.server_address) + context.getString(R.string.rechargequery), map, new OkhttpUtil.BeanCallback() {
            @Override
            public void onSuccess(String data) {
                RechargeBean rechargeBean = JSON.parseObject(data,RechargeBean.class);
                if (!context.isDestroyed()) {
                    if (rechargeCall != null) {
                        rechargeCall.rechargeData(rechargeBean);
                    }
                }
            }

            @Override
            public void onFailure(int code, String errorMsg) {

            }
        });
    }

    public void recordquery(RechargeRCall rechargeRCall,boolean isR){
        Map<String,String> map = new HashMap<>();
        if (isR){
            page = 1;
        }
        map.put("PageIndex",page+"");
        map.put("PageCount","10");
        OkhttpUtil.post(context.getString(R.string.server_address) + context.getString(R.string.recordquery)+"?userId="+UserManage.getInstance().getUserID(), map, new OkhttpUtil.BeanCallback() {
            @Override
            public void onSuccess(String data) {
                List<RechargeRrecordBean> rechargeBean = GsonUtil.changeGsonToList(data,RechargeRrecordBean.class);
                if (!context.isDestroyed()) {
                    if (rechargeRCall != null) {
                        if (isR) {
                            rechargeRCall.rechargeBack(rechargeBean);
                        } else {
                            rechargeRCall.loadMore(rechargeBean);
                        }
                        page++;
                    }
                }
            }

            @Override
            public void onFailure(int code, String errorMsg) {
                if (!context.isDestroyed()) {
                    if (rechargeRCall != null) {
                        rechargeRCall.error();
                    }
                }
            }
        });
    }

    public void querytype(String id, QuerytypeListCall querytypeListCall){

        OkhttpUtil.get(context.getString(R.string.server_address) + context.getString(R.string.querytype)
                + "?keyValue=" + id, new HashMap<>(), new OkhttpUtil.BeanCallback() {
            @Override
            public void onSuccess(String data) {
                RechargeCoreBean rechargeCoreBean = GsonUtil.changeGsonToBean(data,RechargeCoreBean.class);
                if (!context.isDestroyed()) {
                    if (querytypeListCall != null) {
                        if (rechargeCoreBean != null) {
                            querytypeListCall.querytype(rechargeCoreBean);
                        }
                    }
                }
            }

            @Override
            public void onFailure(int code, String errorMsg) {
                if (!context.isDestroyed()) {
                    if (querytypeListCall != null) {
                        querytypeListCall.error();
                    }
                }
            }
        });

    }


    public void pay(String orerId,RechargeCall rechargeCall){
        Map<String,String> map = new HashMap<>();
        map.put("orderNo",orerId);
        OkhttpUtil.get(context.getString(R.string.server_address) + context.getString(R.string.alipay),map, new OkhttpUtil.BeanCallback() {
            @Override
            public void onSuccess(String data) {
                if (!context.isDestroyed()) {
                    if (rechargeCall != null) {
                        rechargeCall.payS(data);
                    }
                }
            }

            @Override
            public void onFailure(int code, String errorMsg) {

            }
        });
    }

    public void agentshopQuery(String sortName,String sortType,String keyWord,boolean isR,AgentshopQueryCall agentshopQueryCall){
        Map<String,String> map = new HashMap<>();
        if (isR){
            page = 1;
        }
        map.put("PageIndex",page+"");
        map.put("PageCount","10");
        if (!TextUtils.isEmpty(keyWord)){
            map.put("KeyWord",keyWord);
        }
        map.put("SortType",sortType);
        map.put("SortName",sortName);
        OkhttpUtil.post(context.getString(R.string.server_address) + context.getString(R.string.agentshopquery), map, new OkhttpUtil.BeanCallback() {
            @Override
            public void onSuccess(String data) {
                List<AgentBean> list = GsonUtil.changeGsonToList(data,AgentBean.class);
                if (!context.isDestroyed()) {
                    if (agentshopQueryCall != null) {
                        if (isR) {
                            agentshopQueryCall.agentshopQuery(list);
                        } else {
                            agentshopQueryCall.loadMore(list);
                        }
                        page++;
                    }
                }
            }

            @Override
            public void onFailure(int code, String errorMsg) {
                if (!context.isDestroyed()) {
                    if (agentshopQueryCall != null) {
                        agentshopQueryCall.error();
                    }
                }
            }
        });
    }

    public interface AgentshopQueryCall extends BaseCall{
        void agentshopQuery(@NonNull List<AgentBean> agentBeans);

        void loadMore(@NonNull List<AgentBean> agentBeans);
    }

    public interface RechargeCall extends BaseCall {

        void rechargeBack();

        void rechargeData(@NonNull RechargeBean rechargeBean);

        void payS(@NonNull String data);
    }

    public interface RechargeRCall extends BaseCall {

        void rechargeBack(@NonNull List<RechargeRrecordBean> rechargeRrecordBeans);

        void loadMore(@NonNull List<RechargeRrecordBean> rechargeRrecordBeans);
    }

    public interface QuerytypeListCall extends BaseCall{

        void querytype(@NonNull RechargeCoreBean rechargeCoreBean);
    }

}
