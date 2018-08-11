package com.whmnrc.qiangbizhong.presenter.me;

import android.content.Context;

import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseCall;
import com.whmnrc.qiangbizhong.model.bean.AgentSalesRecordBean;
import com.whmnrc.qiangbizhong.model.bean.AgentShopBean;
import com.whmnrc.qiangbizhong.util.GsonUtil;
import com.whmnrc.qiangbizhong.util.OkhttpUtil;
import com.whmnrc.qiangbizhong.util.UserManage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/8/11.
 */

public class AgentPresenter {

    private Context context;
    private int page;

    public AgentPresenter(Context context) {
        this.context = context;
    }

    public void getagentshopinfo(AgentShopInfoCall agentShopInfoCall){

        OkhttpUtil.get(context.getString(R.string.server_address) + context.getString(R.string.getagentshopinfo)
                + "?userId=" + UserManage.getInstance().getLoginBean().getUserInfo_ID(), new HashMap<>(), new OkhttpUtil.BeanCallback() {
            @Override
            public void onSuccess(String data) {
                AgentShopBean agentShopBean = GsonUtil.changeGsonToBean(data,AgentShopBean.class);
                if (agentShopInfoCall != null){
                    agentShopInfoCall.AgentShopInfoaBack(agentShopBean);
                }
            }

            @Override
            public void onFailure(int code, String errorMsg) {
                if (agentShopInfoCall != null){
                    agentShopInfoCall.error();
                }
            }
        });
    }

    public void getagentsalesrecord(boolean isR,AgentSalesRecordCall agentSalesRecordCall){
        Map<String,String> map = new HashMap<>();
        if (isR){
            page = 1;
        }
        map.put("PageIndex",page+"");
        map.put("PageCount","10");
        OkhttpUtil.post(context.getString(R.string.server_address) + context.getString(R.string.getagentsalesrecord)
                + "?userId=" + UserManage.getInstance().getUserID(), map, new OkhttpUtil.BeanCallback() {
            @Override
            public void onSuccess(String data) {
                AgentSalesRecordBean agentSalesRecordBean = GsonUtil.changeGsonToBean(data,AgentSalesRecordBean.class);
                if (agentSalesRecordCall != null){
                    if (isR){
                        agentSalesRecordCall.AgentSalesRecordBack(agentSalesRecordBean);
                    }else {
                        agentSalesRecordCall.loadMore(agentSalesRecordBean.getRecordList());
                    }
                    page++;
                }
            }

            @Override
            public void onFailure(int code, String errorMsg) {

            }
        });
    }

    public interface AgentShopInfoCall extends BaseCall{
        void AgentShopInfoaBack(AgentShopBean agentShopBean);
    }

    public interface AgentSalesRecordCall extends BaseCall{
        void AgentSalesRecordBack(AgentSalesRecordBean agentSalesRecordBean);

        void loadMore(List<AgentSalesRecordBean.RecordListBean> recordListBeans);
    }
}
