package com.whmnrc.qiangbizhong.presenter.me;

import android.content.Context;

import com.alibaba.fastjson.JSON;
import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.model.bean.RechargeBean;
import com.whmnrc.qiangbizhong.util.OkhttpUtil;
import com.whmnrc.qiangbizhong.util.UserManage;

import java.util.HashMap;
import java.util.Map;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/14.
 * OrderType 0 供应商 1 会员 2普通
 */

public class RechargePresenter {

    Context context;

    public RechargePresenter(Context context) {
        this.context = context;
    }



    public void submitorder(String monery,String orderType,String agentshopId,String agentShopDiscountId){
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

            }

            @Override
            public void onFailure(int code, String errorMsg) {

            }
        });
    }

    public void rechargeQuery(int type,RechargeCall rechargeCall){
        Map<String,String> map = new HashMap<>();
        map.put("isVip",type+"");
        OkhttpUtil.get(context.getString(R.string.server_address) + context.getString(R.string.rechargequery), map, new OkhttpUtil.BeanCallback() {
            @Override
            public void onSuccess(String data) {
                RechargeBean rechargeBean = JSON.parseObject(data,RechargeBean.class);
                if (rechargeCall != null){
                    rechargeCall.rechargeData(rechargeBean);
                }
            }

            @Override
            public void onFailure(int code, String errorMsg) {

            }
        });
    }

    public interface RechargeCall{

        void rechargeBack();

        void rechargeData(RechargeBean rechargeBean);
    }


}
