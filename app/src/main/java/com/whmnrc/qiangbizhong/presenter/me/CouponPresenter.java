package com.whmnrc.qiangbizhong.presenter.me;

import android.content.Context;

import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseCall;
import com.whmnrc.qiangbizhong.model.bean.CouponBean;
import com.whmnrc.qiangbizhong.util.GsonUtil;
import com.whmnrc.qiangbizhong.util.OkhttpUtil;
import com.whmnrc.qiangbizhong.util.UserManage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/8/14.
 */

public class CouponPresenter {

    private Context context;

    private int page;

    public CouponPresenter(Context context) {
        this.context = context;
    }

    public void getcouponlist(boolean isR,CouponListCall couponListCall){
        Map<String,String> map = new HashMap<>();
        if (isR){
            page = 1;
        }
        map.put("PageIndex",page+"");
        map.put("PageCount","10");
        OkhttpUtil.post(context.getString(R.string.server_address) + context.getString(R.string.getcouponlist)
                +"?userId=" + UserManage.getInstance().getUserID(), map, new OkhttpUtil.BeanCallback() {
            @Override
            public void onSuccess(String data) {
                List<CouponBean> couponBeans = GsonUtil.changeGsonToList(data,CouponBean.class);
                if (couponListCall != null){
                    if (isR){
                        couponListCall.getcouponlist(couponBeans);
                    }else {
                        couponListCall.loadMore(couponBeans);
                    }

                }
            }

            @Override
            public void onFailure(int code, String errorMsg) {
                if (couponListCall != null){
                    couponListCall.error();
                }
            }
        });

    }


    public interface CouponListCall extends BaseCall{

        void getcouponlist(List<CouponBean> couponBeans);

        void loadMore(List<CouponBean> couponBeans);
    }
}
