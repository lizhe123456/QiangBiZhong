package com.whmnrc.qiangbizhong.presenter.me;

import android.content.Context;

import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseCall;
import com.whmnrc.qiangbizhong.model.bean.GiveOrderDetailBean;
import com.whmnrc.qiangbizhong.model.bean.GiveRBean;
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

public class GivePresenter {

    private Context context;
    private int page;


    public GivePresenter(Context context) {
        this.context = context;
    }


    public void getgivelist(boolean isR, GiveListCall giveListCall){
        Map<String,String> map = new HashMap<>();
        if (isR){
            page = 1;
        }
        map.put("PageIndex", page+"");
        map.put("PageCount","10");
        OkhttpUtil.post(context.getString(R.string.server_address) + context.getString(R.string.getgivelist)
                +"?userId=" + UserManage.getInstance().getUserID(), map, new OkhttpUtil.BeanCallback() {
            @Override
            public void onSuccess(String data) {
                List<GiveRBean> giveRBeans = GsonUtil.changeGsonToList(data,GiveRBean.class);
                if (giveListCall != null){
                    if (isR) {
                        giveListCall.getGiveList(giveRBeans);
                    }else {
                        giveListCall.loadMore(giveRBeans);
                    }
                    page++;
                }
            }

            @Override
            public void onFailure(int code, String errorMsg) {
                if (giveListCall != null){
                    giveListCall.error();
                }
            }
        });
    }



    public void giveorderdetail(String orderId,GiveOrderDetailCall giveOrderDetailCall){
        OkhttpUtil.get(context.getString(R.string.server_address) + context.getString(R.string.giveorderdetail)
                + "?giveId=" + orderId, new HashMap<>(), new OkhttpUtil.BeanCallback() {
            @Override
            public void onSuccess(String data) {
                GiveOrderDetailBean giveOrderDetailBean = GsonUtil.changeGsonToBean(data,GiveOrderDetailBean.class);
                if (giveOrderDetailCall != null){
                    giveOrderDetailCall.getGiveOrderDetail(giveOrderDetailBean);
                }
            }

            @Override
            public void onFailure(int code, String errorMsg) {
                if (giveOrderDetailCall != null){
                    giveOrderDetailCall.error();
                }
            }
        });
    }


    public interface GiveListCall extends BaseCall{

        void getGiveList(List<GiveRBean> giveRBeans);

        void loadMore(List<GiveRBean> giveRBeans);
    }

    public interface GiveOrderDetailCall extends BaseCall{
        void getGiveOrderDetail(GiveOrderDetailBean giveOrderDetailBean);
    }

}
