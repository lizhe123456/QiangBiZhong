package com.whmnrc.qiangbizhong.presenter.home;

import android.content.Context;
import android.text.TextUtils;

import com.alibaba.fastjson.JSON;
import com.blankj.utilcode.util.ToastUtils;
import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.model.bean.KillGoodsBean;
import com.whmnrc.qiangbizhong.util.OkhttpUtil;
import com.whmnrc.qiangbizhong.util.ToastUtil;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/12.
 */

public class FlashSalePresenter {

    Context context;

    public FlashSalePresenter(Context context) {
        this.context = context;
    }

    public void getFlashSale(String time,FlashSaleCall flashSaleCall){
        Map<String,String> map = new HashMap<>();
//        map.put("time",time);
        map.put("PageIndex","1");
        map.put("PageCount","10");
        OkhttpUtil.post(context.getString(R.string.server_address)+context.getString(R.string.goodsrushlist)+"?time="+time,map, new OkhttpUtil.BeanCallback() {
            @Override
            public void onSuccess(String data) {
                if (!TextUtils.isEmpty(data)) {
                    KillGoodsBean killGoodsBeans = JSON.parseObject(data,KillGoodsBean.class);
                    if (flashSaleCall != null){
                        flashSaleCall.onKillGoodsBack(killGoodsBeans);
                    }
                }
            }

            @Override
            public void onFailure(int code, String errorMsg) {

            }

        });
    }

    public interface FlashSaleCall{

        void onKillGoodsBack(KillGoodsBean killGoodsBeans);

    }
}
