package com.whmnrc.qiangbizhong.presenter.me;

import android.content.Context;
import android.text.TextUtils;

import com.alibaba.fastjson.JSON;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.model.bean.OrderListBean;
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
                    List<OrderListBean> orderListBeans = GsonUtil.changeGsonToList(data, OrderListBean.class);
                    if (orderCall != null){
                        orderCall.orderlistBack(orderListBeans);
                    }
                }
            }

            @Override
            public void onFailure(int code, String errorMsg) {
                LogUtils.e(errorMsg);
            }

        });
    }

    public void submitOrder(String goodsId,String addressId,SubmitOrederCall submitOrederCall){
        Map<String,String> map = new HashMap<>();
        map.put("goodsRushId",goodsId);
        map.put("userId",UserManage.getInstance().getUserID());
        map.put("addressId",addressId);
        OkhttpUtil.get(context.getString(R.string.server_address) + context.getString(R.string.submitOrder),map, new OkhttpUtil.BeanCallback() {
            @Override
            public void onSuccess(String data) {
                if (submitOrederCall != null){
                    submitOrederCall.submitOrederBack();
                }
            }

            @Override
            public void onFailure(int code, String errorMsg) {

            }
        });
    }

    public interface OrderCall{
        void orderlistBack(List<OrderListBean> orderListBeans);
    }

    public interface SubmitOrederCall{
        void submitOrederBack();
    }
}
