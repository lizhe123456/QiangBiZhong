package com.whmnrc.qiangbizhong.presenter.me;

import android.content.Context;

import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseCall;
import com.whmnrc.qiangbizhong.model.bean.LiveryBean;
import com.whmnrc.qiangbizhong.util.GsonUtil;
import com.whmnrc.qiangbizhong.util.OkhttpUtil;

import java.util.HashMap;
import java.util.List;

/**
 * Created by admin on 2018/8/10.
 * 物流
 */

public class LiveryPresenter {

    private Context context;
    private LiveryPresenterCall liveryPresenterCall;

    public LiveryPresenter(Context context, LiveryPresenterCall liveryPresenterCall) {
        this.context = context;
        this.liveryPresenterCall = liveryPresenterCall;
    }

    public void getexpressdelivery(){
        OkhttpUtil.get(context.getString(R.string.server_address) + context.getString(R.string.getexpressdelivery), new HashMap<>(), new OkhttpUtil.BeanCallback() {
            @Override
            public void onSuccess(String data) {
                List<LiveryBean> liveryBeans = GsonUtil.changeGsonToList(data,LiveryBean.class);
                if (liveryPresenterCall != null){
                    liveryPresenterCall.getexpressdelivery(liveryBeans);
                }
            }

            @Override
            public void onFailure(int code, String errorMsg) {
                if (liveryPresenterCall != null){
                    liveryPresenterCall.error();
                }
            }
        });
    }

    public void sendGoods(String orderId, String waybillCompany, String waybillNumber,LiveryPresenterCall liveryPresenterCall){
        OkhttpUtil.get(context.getString(R.string.server_address) + context.getString(R.string.sendgoods)
                +"?orderId="+orderId+"&waybillCompany="+waybillCompany+"&waybillNumber="+waybillNumber, new HashMap<>(), new OkhttpUtil.BeanCallback() {
            @Override
            public void onSuccess(String data) {
                if (liveryPresenterCall != null){
                        liveryPresenterCall.updateOrder();
                }
            }

            @Override
            public void onFailure(int code, String errorMsg) {
                if (liveryPresenterCall != null){
                    liveryPresenterCall.error();
                }
            }
        });
    }

    public interface LiveryPresenterCall extends BaseCall{

        void getexpressdelivery(List<LiveryBean> liveryBeans);

        void updateOrder();
    }
}
