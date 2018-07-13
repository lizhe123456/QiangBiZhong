package com.whmnrc.qiangbizhong.presenter.home;

import android.content.Context;
import android.text.TextUtils;

import com.alibaba.fastjson.JSON;
import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.model.bean.GoodsRushinfoBean;
import com.whmnrc.qiangbizhong.util.OkhttpUtil;
import com.whmnrc.qiangbizhong.util.UserManage;

import java.util.HashMap;
import java.util.Map;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/13.
 */

public class GoodsRushInfoPresenter {

    private Context context;

    public GoodsRushInfoPresenter(Context context) {
        this.context = context;
    }

    public void getGoodsInfo(String goodId,GoodsInfoCall goodsInfoCall){
        Map<String,String> map = new HashMap<>();
        map.put("userId", UserManage.getInstance().getUserID());
        map.put("rushId",goodId);
        OkhttpUtil.get(context.getString(R.string.server_address) + context.getString(R.string.goodsrushinfo),map, new OkhttpUtil.BeanCallback() {
            @Override
            public void onSuccess(String data) {
                if (!TextUtils.isEmpty(data)){
                    GoodsRushinfoBean goodsRushinfoBean = JSON.parseObject(data,GoodsRushinfoBean.class);
                    if (goodsInfoCall != null){
                        goodsInfoCall.goodsInfoBack(goodsRushinfoBean);
                    }
                }
            }

            @Override
            public void onFailure(int code, String errorMsg) {

            }

        });
    }


    public interface GoodsInfoCall{

        void goodsInfoBack(GoodsRushinfoBean goodsRushinfoBean);

    }


}
