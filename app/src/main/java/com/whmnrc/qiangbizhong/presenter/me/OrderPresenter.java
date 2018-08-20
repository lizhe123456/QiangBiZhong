package com.whmnrc.qiangbizhong.presenter.me;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;

import com.alibaba.fastjson.JSON;
import com.blankj.utilcode.util.EncryptUtils;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.google.gson.Gson;
import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseCall;
import com.whmnrc.qiangbizhong.model.bean.OrderListBean;
import com.whmnrc.qiangbizhong.model.bean.OrderdetailBean;
import com.whmnrc.qiangbizhong.model.bean.YiMeiOrderDetailBean;
import com.whmnrc.qiangbizhong.model.parameter.YiMeiOrderParam;
import com.whmnrc.qiangbizhong.ui.PayStuActivity;
import com.whmnrc.qiangbizhong.ui.shopping.activity.ShopConfirmOrderActivity;
import com.whmnrc.qiangbizhong.util.GsonUtil;
import com.whmnrc.qiangbizhong.util.OkhttpUtil;
import com.whmnrc.qiangbizhong.util.UserManage;

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

    public void getShopOrderList(String orderStatus,boolean isRefresh,OrderCall orderCall){
        Map<String,String> map = new HashMap<>();
        if (isRefresh) {
            page = 0;
        }
        page++;
        map.put("PageIndex",page+"");
        map.put("PageCount",size+"");
        OkhttpUtil.post(context.getString(R.string.server_address) + context.getString(R.string.getorderlist)
                + "?storeId=" + UserManage.getInstance().getLoginBean().getStoreInfo().getId() + "&orderStatus=" + orderStatus, map, new OkhttpUtil.BeanCallback() {
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

    //验证密码
    public void yzPass(String pwd, PayPassCall payPassCall){
        Map<String, String> map = new HashMap<>();
        map.put("userId",UserManage.getInstance().getUserID());
        map.put("pwd", EncryptUtils.encryptMD5ToString(pwd));
        OkhttpUtil.get(context.getString(R.string.server_address) + context.getString(R.string.validatePay), map, new OkhttpUtil.BeanCallback() {
            @Override
            public void onSuccess(String data) {
                if (payPassCall != null){
                    payPassCall.payPassBack();
                }
            }

            @Override
            public void onFailure(int code, String errorMsg) {
                if (payPassCall != null){
                    payPassCall.error();
                }
            }
        });
    }

    public void submitshoppingorder(ShopConfirmOrderActivity.Parameter parameter, SubmitOrederCall submitShoppingOrderCall){
        OkhttpUtil.postString(context.getString(R.string.server_address) + context.getString(R.string.submitshoppingorder), GsonUtil.createGsonString(parameter), new OkhttpUtil.BeanCallback() {
            @Override
            public void onSuccess(String data) {
                if (submitShoppingOrderCall != null){
                    submitShoppingOrderCall.submitOrederBack();
                }
                if (TextUtils.isEmpty(data)){

                }else {
                    ToastUtils.showShort(data);
                }
            }

            @Override
            public void onFailure(int code, String errorMsg) {
                if (submitShoppingOrderCall != null){
                    submitShoppingOrderCall.error();
                }

                if (code == 101 && errorMsg.equals("101")){
                    if (submitShoppingOrderCall != null) {
                        submitShoppingOrderCall.recharge();
                    }
                }else {
                    if (submitShoppingOrderCall != null) {
                        submitShoppingOrderCall.error();
                    }
                }
            }
        });

    }

    public void submitrefund(String orderId,String refundremark,OrderUpdateCall orderUpdateCall){
        Map<String,String> map = new HashMap<>();
        OkhttpUtil.get(context.getString(R.string.server_address) + context.getString(R.string.submitrefund) +
                "?userId=" + UserManage.getInstance().getUserID() + "&orderId=" + orderId + "&refundremark=" + refundremark, map, new OkhttpUtil.BeanCallback() {
            @Override
            public void onSuccess(String data) {
                if (orderUpdateCall != null) {
                    if (TextUtils.isEmpty(data)) {
                        orderUpdateCall.updateData();
                        ToastUtils.showShort("提交成功");
                    } else {
                        ToastUtils.showShort(data);
                    }
                }
            }

            @Override
            public void onFailure(int code, String errorMsg) {
                if (orderUpdateCall != null) {
                    orderUpdateCall.error();
                }
            }
        });
    }

    public void cannerrefund(String orderId,OrderUpdateCall orderUpdateCall){
        Map<String,String> map = new HashMap<>();
        OkhttpUtil.get(context.getString(R.string.server_address) + context.getString(R.string.cannerrefund) +
                "?userId=" + UserManage.getInstance().getUserID() + "&orderId=" + orderId, map, new OkhttpUtil.BeanCallback() {
            @Override
            public void onSuccess(String data) {
                if (orderUpdateCall != null) {
                    if (TextUtils.isEmpty(data)) {
                        orderUpdateCall.updateData();
                        ToastUtils.showShort("取消成功");
                    } else {
                        ToastUtils.showShort(data);
                    }
                }
            }

            @Override
            public void onFailure(int code, String errorMsg) {
                if (orderUpdateCall != null) {
                    orderUpdateCall.error();
                }
            }
        });
    }

    public void orderdetail(String orderId,OrderDetailCall orderUpdateCall){
        Map<String,String> map = new HashMap<>();
        OkhttpUtil.get(context.getString(R.string.server_address) + context.getString(R.string.orderdetail) +
                "?orderId=" + orderId, map, new OkhttpUtil.BeanCallback() {
            @Override
            public void onSuccess(String data) {
                OrderdetailBean orderdetailBean = GsonUtil.changeGsonToBean(data,OrderdetailBean.class);
                if (orderUpdateCall != null) {
                    orderUpdateCall.orderDetail(orderdetailBean);
                }
            }

            @Override
            public void onFailure(int code, String errorMsg) {
                if (orderUpdateCall != null) {
                    orderUpdateCall.error();
                }
            }
        });
    }

    public void returngoods(String orderId,OrderUpdateCall orderUpdateCall){
        OkhttpUtil.get(context.getString(R.string.server_address) + context.getString(R.string.returngoods)
                + "?orderId=" + orderId, new HashMap<>(), new OkhttpUtil.BeanCallback() {
            @Override
            public void onSuccess(String data) {
                if (orderUpdateCall != null){
                    orderUpdateCall.updateData();
                }
            }

            @Override
            public void onFailure(int code, String errorMsg) {
                if (orderUpdateCall != null){
                    orderUpdateCall.error();
                }
            }
        });
    }

    public void confirmused(String orderId,OrderUpdateCall orderUpdateCall){
        OkhttpUtil.get(context.getString(R.string.server_address) + context.getString(R.string.returngoods)
                + "?orderId=" + orderId, new HashMap<>(), new OkhttpUtil.BeanCallback() {
            @Override
            public void onSuccess(String data) {
                if (orderUpdateCall != null){
                    orderUpdateCall.updateData();
                }
            }

            @Override
            public void onFailure(int code, String errorMsg) {
                if (orderUpdateCall != null){
                    orderUpdateCall.error();
                }
            }
        });
    }

    public void yiMeiOrder(YiMeiOrderParam yiMeiOrderParam,SubmitOrederCall submitOrederCall){
        OkhttpUtil.postString(context.getString(R.string.server_address) + context.getString(R.string.submitmedicalorder),
                GsonUtil.createGsonString(yiMeiOrderParam), new OkhttpUtil.BeanCallback() {
                    @Override
                    public void onSuccess(String data) {
                        if (submitOrederCall != null){
                            submitOrederCall.submitOrederBack();
                        }
                        if (TextUtils.isEmpty(data)){

                        }else {
                            ToastUtils.showShort(data);
                        }
                    }

                    @Override
                    public void onFailure(int code, String errorMsg) {
                        if (submitOrederCall != null){
                            submitOrederCall.error();
                        }

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


    public void orderdetailmedical(String orderId,OrderDetailMedicalCall orderDetailMedicalCall){
        OkhttpUtil.get(context.getString(R.string.server_address) + context.getString(R.string.orderdetailmedical) + "?orderId=" + orderId,
                new HashMap<>(), new OkhttpUtil.BeanCallback() {
            @Override
            public void onSuccess(String data) {
                YiMeiOrderDetailBean yiMeiOrderDetailBean = JSON.parseObject(data,YiMeiOrderDetailBean.class);
//                YiMeiOrderDetailBean yiMeiOrderDetailBean = GsonUtil.changeGsonToBean(data,YiMeiOrderDetailBean.class);
                if (orderDetailMedicalCall != null){
                    if (yiMeiOrderDetailBean != null) {
                        orderDetailMedicalCall.orderDetailMedical(yiMeiOrderDetailBean);
                    }
                }
            }

            @Override
            public void onFailure(int code, String errorMsg) {
                if (orderDetailMedicalCall != null){
                    orderDetailMedicalCall.error();
                }
            }
        });
    }

    public void canneragentpay(String orderId, OrderUpdateCall orderUpdateCall){
        OkhttpUtil.get(context.getString(R.string.server_address) + context.getString(R.string.canneragentpay) + "?orderId="
                + orderId, new HashMap<>(), new OkhttpUtil.BeanCallback() {
            @Override
            public void onSuccess(String data) {
                if (orderUpdateCall != null){
                    orderUpdateCall.updateData();
                }
                if (TextUtils.isEmpty(data)){
                    return;
                }
                ToastUtils.showShort(data);
            }

            @Override
            public void onFailure(int code, String errorMsg) {
                if (orderUpdateCall != null){
                    orderUpdateCall.error();
                }
            }
        });
    }

    public void cannerorder(String orderId, OrderUpdateCall orderUpdateCall){
        OkhttpUtil.get(context.getString(R.string.server_address) + context.getString(R.string.cannerorder) + "?orderId="
                + orderId, new HashMap<>(), new OkhttpUtil.BeanCallback() {
            @Override
            public void onSuccess(String data) {
                if (orderUpdateCall != null){
                    orderUpdateCall.updateData();
                }
                if (TextUtils.isEmpty(data)){
                    return;
                }
                ToastUtils.showShort(data);
            }

            @Override
            public void onFailure(int code, String errorMsg) {
                if (orderUpdateCall != null){
                    orderUpdateCall.error();
                }
            }
        });
    }

    public void paymedicalorder(Activity activity ,String orderId){
        OkhttpUtil.get(context.getString(R.string.server_address) + context.getString(R.string.paymedicalorder) + "?orderId="
                + orderId + "&userId=" + UserManage.getInstance().getUserID(), new HashMap<>(), new OkhttpUtil.BeanCallback() {
            @Override
            public void onSuccess(String data) {
                activity.finish();
                PayStuActivity.start(context,1);
                if (TextUtils.isEmpty(data)){
                    return;
                }
                ToastUtils.showShort(data);
            }

            @Override
            public void onFailure(int code, String errorMsg) {
                activity.finish();
                PayStuActivity.start(context,0);
            }
        });
    }

    public void paymedicalorder(String orderId,OrderUpdateCall orderUpdateCall){
        OkhttpUtil.get(context.getString(R.string.server_address) + context.getString(R.string.paymedicalorder) + "?orderId="
                + orderId + "&userId=" + UserManage.getInstance().getUserID(), new HashMap<>(), new OkhttpUtil.BeanCallback() {
            @Override
            public void onSuccess(String data) {
                if (orderUpdateCall != null){
                    orderUpdateCall.updateData();
                }
                if (TextUtils.isEmpty(data)){
                    return;
                }
                ToastUtils.showShort(data);
            }

            @Override
            public void onFailure(int code, String errorMsg) {
                if (orderUpdateCall != null){
                    orderUpdateCall.error();
                }
            }
        });
    }


    public void giveorder(Activity activity,String orderId,String giveUserId,String desc){
        OkhttpUtil.get(context.getString(R.string.server_address) + context.getString(R.string.giveorder) + "?orderId="
                + orderId + "&fromUserId=" + UserManage.getInstance().getUserID() + "&giveUserId=" + giveUserId + "&context=" + desc, new HashMap<>(), new OkhttpUtil.BeanCallback() {
            @Override
            public void onSuccess(String data) {
                activity.finish();
//                StatusActivity.start(context,1,"赠送成功，请到赠送记录里查看","赠送成功");
                if (TextUtils.isEmpty(data)){
                    return;
                }
                ToastUtils.showShort(data);
            }

            @Override
            public void onFailure(int code, String errorMsg) {
//                StatusActivity.start(context,0,"赠送失败，请重试","赠送失败");
            }
        });
    }

    public void confirmused(String orderId,String sid){
        OkhttpUtil.get(context.getString(R.string.server_address) + context.getString(R.string.confirmused) + "?orderId="
                + orderId + "&storeId=" + sid , new HashMap<>(), new OkhttpUtil.BeanCallback() {
            @Override
            public void onSuccess(String data) {
                ToastUtils.showShort("操作成功");
            }

            @Override
            public void onFailure(int code, String errorMsg) {
            }
        });
    }


    public interface OrderDetailMedicalCall extends BaseCall{
        void orderDetailMedical(YiMeiOrderDetailBean yiMeiOrderDetailBean);

    }

    public interface OrderDetailCall extends BaseCall{
        void orderDetail(OrderdetailBean orderdetailBean);
    }


    public interface PayPassCall extends BaseCall{

        void payPassBack();
    }

    public interface OrderCall extends BaseCall {
        void orderlistBack(List<OrderListBean> orderListBeans);

        void loadMore(List<OrderListBean> orderListBeans);
    }

    public interface OrderUpdateCall extends BaseCall {

        void updateData();
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

    public interface SubmitShoppingOrderCall extends BaseCall{

        void submitShoppingOrderBack();

    }
}
