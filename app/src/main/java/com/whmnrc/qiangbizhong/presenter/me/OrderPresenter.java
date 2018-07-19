package com.whmnrc.qiangbizhong.presenter.me;

import android.content.Context;
import android.text.TextUtils;

import com.alibaba.fastjson.JSON;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseCall;
import com.whmnrc.qiangbizhong.model.bean.OrderListBean;
import com.whmnrc.qiangbizhong.ui.me.activity.MyOrderActivity;
import com.whmnrc.qiangbizhong.util.GlideuUtil;
import com.whmnrc.qiangbizhong.util.GsonUtil;
import com.whmnrc.qiangbizhong.util.OkhttpUtil;
import com.whmnrc.qiangbizhong.util.UserManage;
import com.zhy.http.okhttp.OkHttpUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/13.
 */

public class OrderPresenter {

    private Context context;
    private int page = 0;
    private int size = 10;

    public OrderPresenter(Context context) {
        this.context = context;
    }

    public void getOrderList(String orderStatus,boolean isRefresh,OrderCall orderCall){
        Map<String,String> map = new HashMap<>();
        if (isRefresh) {
            page = 0;
        }
        page++;
        map.put("PageIndex",page+"");
        map.put("PageCount",size+"");
        OkhttpUtil.post(context.getString(R.string.server_address) + context.getString(R.string.orderlist)
                + "?userId=" + UserManage.getInstance().getUserID() + "&orderStatus=" + orderStatus, map, new OkhttpUtil.BeanCallback() {
            @Override
            public void onSuccess(String data) {
                if (!TextUtils.isEmpty(data)){
                    List<OrderListBean> orderListBeans = JSON.parseArray(data, OrderListBean.class);
                    if (orderCall != null){
                        if (isRefresh) {
                            orderCall.orderlistBack(orderListBeans);
                        }else {
                            orderCall.loadMore(orderListBeans);
                        }
                    }
                }
            }

            @Override
            public void onFailure(int code, String errorMsg) {
                if (orderCall != null){
                    orderCall.error();
                }
            }

        });
    }

    public void submitOrder(String goodsId,String addressId,SubmitOrederCall submitOrederCall){
        Map<String,String> map = new HashMap<>();
//        map.put("goodsRushId",goodsId);
//        map.put("userId",UserManage.getInstance().getUserID());
//        map.put("addressId",addressId);
        OkhttpUtil.get(context.getString(R.string.server_address) + context.getString(R.string.submitOrder)+ "?goodsRushId="+goodsId+"&userId="+UserManage.getInstance().getUserID()+"&addressId="+addressId,map, new OkhttpUtil.BeanCallback() {
            @Override
            public void onSuccess(String data) {
                if (submitOrederCall != null){
                    submitOrederCall.submitOrederBack();
                }
                UserManage.getInstance().getUserInfo(null);
            }

            @Override
            public void onFailure(int code, String errorMsg) {
                if (code == 101 && errorMsg.equals("101")){
                    if (submitOrederCall != null) {
                        submitOrederCall.recharge();
                    }
                }else {
                    if (submitOrederCall != null) {
                        submitOrederCall.error();
                    }
                }
            }
        });
    }

    public void abandon(String goodsId,CancelCall cancelCall){
        Map<String,String> map = new HashMap<>();
        map.put("userId",UserManage.getInstance().getUserID());
        map.put("goodsRushId",goodsId);
        OkhttpUtil.get(context.getString(R.string.server_address) + context.getString(R.string.abandon),map, new OkhttpUtil.BeanCallback() {
            @Override
            public void onSuccess(String data) {
                if (cancelCall != null){
                    cancelCall.cancelS();
                }
                UserManage.getInstance().getUserInfo(null);
            }

            @Override
            public void onFailure(int code, String errorMsg) {

            }
        });
    }

    public void payOrder(String awardId,PayBackS payBackS){
        Map<String,String> map = new HashMap<>();
        OkhttpUtil.get(context.getString(R.string.server_address) + context.getString(R.string.buy)+"?awardId="+awardId+"&userId="+UserManage.getInstance().getUserID(),map, new OkhttpUtil.BeanCallback() {
            @Override
            public void onSuccess(String data) {
                UserManage.getInstance().getUserInfo(null);
                if (payBackS != null){
                    payBackS.payS();
                }
            }

            @Override
            public void onFailure(int code, String errorMsg) {
                if (code == 101 && errorMsg.equals("101")){
                    if (payBackS != null) {
                        payBackS.recharge();
                    }
                }else {
                    if (payBackS != null) {
                        payBackS.error();
                    }
                }
            }
        });
    }

    public void collectgoods(String orderId,CollectCall cancelCall){
        Map<String,String> map = new HashMap<>();
        map.put("orderId",orderId);
        OkhttpUtil.get(context.getString(R.string.server_address) + context.getString(R.string.collectgoods),map, new OkhttpUtil.BeanCallback() {
            @Override
            public void onSuccess(String data) {
                if (cancelCall != null){
                    cancelCall.collect();
                }
            }

            @Override
            public void onFailure(int code, String errorMsg) {

            }
        });
    }

    public void awardSubmitOrder(String awardId,String addressId,SubmitOrederCall submitOrederCall){
        Map<String,String> map = new HashMap<>();
        OkhttpUtil.get(context.getString(R.string.server_address)+context.getString(R.string.awardSubmitOrder) + "?awardId=" +awardId+"&userId="+UserManage.getInstance().getUserID()+"&addressId="+addressId,map, new OkhttpUtil.BeanCallback() {
            @Override
            public void onSuccess(String data) {
                if (submitOrederCall != null){
                    submitOrederCall.submitOrederBack();
                }
                UserManage.getInstance().getUserInfo(null);
            }

            @Override
            public void onFailure(int code, String errorMsg) {
                if (code == 101 && errorMsg.equals("101")){
                    if (submitOrederCall != null) {
                        submitOrederCall.recharge();
                    }
                }else {
                    if (submitOrederCall != null) {
                        submitOrederCall.error();
                    }
                }
            }
        });
    }

    public interface OrderCall extends BaseCall {
        void orderlistBack(List<OrderListBean> orderListBeans);

        void loadMore(List<OrderListBean> orderListBeans);
    }

    public interface SubmitOrederCall extends BaseCall{
        void submitOrederBack();

        void recharge();
    }

    public interface CancelCall extends BaseCall{
        void cancelS();
    }

    public interface CollectCall extends BaseCall{

        void collect();
    }

    public interface PayBackS extends BaseCall{

        void payS();

        void recharge();

    }
}
