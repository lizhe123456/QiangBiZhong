package com.whmnrc.qiangbizhong.presenter.home;

import android.content.Context;

import com.alibaba.fastjson.JSON;
import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseCall;
import com.whmnrc.qiangbizhong.model.bean.LuckDrawBean;
import com.whmnrc.qiangbizhong.model.bean.LuckDrawGoodsBean;
import com.whmnrc.qiangbizhong.util.GsonUtil;
import com.whmnrc.qiangbizhong.util.OkhttpUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/15.
 */

public class AwardPresenter {

    private Context context;
    private int page = 1;
    private int size = 10;

    public AwardPresenter(Context context) {
        this.context = context;
    }

    public void getAwardList(int type,AwardCall awardCall){
        Map<String,String> map = new HashMap<>();
        map.put("PageIndex",page+"");
        map.put("PageCount",size+"");
        OkhttpUtil.post(context.getString(R.string.server_address)+context.getString(R.string.awardlist)+"?type="+type,map, new OkhttpUtil.BeanCallback() {
            @Override
            public void onSuccess(String data) {
                LuckDrawBean luckDrawBean = JSON.parseObject(data,LuckDrawBean.class);
                if (awardCall != null){
                    awardCall.awardBack(luckDrawBean);
                }
            }

            @Override
            public void onFailure(int code, String errorMsg) {

            }
        });
    }

    public interface AwardCall extends BaseCall{

        void awardBack(LuckDrawBean luckDrawBeans);

    }

}
