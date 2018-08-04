package com.whmnrc.qiangbizhong.presenter.shop;

import android.content.Context;

import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseCall;
import com.whmnrc.qiangbizhong.model.bean.SpecBean;
import com.whmnrc.qiangbizhong.util.GsonUtil;
import com.whmnrc.qiangbizhong.util.OkhttpUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/31.
 */

public class SpecPresenter {

    private Context context;

    public SpecPresenter(Context context) {
        this.context = context;
    }


    public void getgoodsspecattr(String goodsId,GoodsSpecCall goodsSpecCall){
        Map<String,String> map = new HashMap<>();
        map.put("goodsId",goodsId);
        OkhttpUtil.get(context.getString(R.string.server_address) + context.getString(R.string.getgoodsspecattr), map, new OkhttpUtil.BeanCallback() {
            @Override
            public void onSuccess(String data) {
                SpecBean specBean = GsonUtil.changeGsonToBean(data,SpecBean.class);
                if (goodsSpecCall != null){
                    goodsSpecCall.spceBack(specBean);
                }
            }

            @Override
            public void onFailure(int code, String errorMsg) {
                if (goodsSpecCall != null){
                    goodsSpecCall.error();
                }
            }
        });
    }


    public interface GoodsSpecCall extends BaseCall{
        void spceBack(SpecBean specBean);
    }

}
