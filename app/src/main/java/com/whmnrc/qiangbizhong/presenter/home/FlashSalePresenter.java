package com.whmnrc.qiangbizhong.presenter.home;

import android.content.Context;
import android.text.TextUtils;

import com.alibaba.fastjson.JSON;
import com.blankj.utilcode.util.ToastUtils;
import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.model.bean.KillGoodsBean;
import com.whmnrc.qiangbizhong.util.GsonUtil;
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

    private Context context;

    private int page = 1;

    public FlashSalePresenter(Context context) {
        this.context = context;
    }

    public void getFlashSale(String time,FlashSaleCall flashSaleCall,boolean isR){
        Map<String,String> map = new HashMap<>();
//        map.put("time",time);
        if (isR){
            page = 1;
        }
        map.put("PageIndex",page+"");
        map.put("PageCount","10");
        OkhttpUtil.post(context.getString(R.string.server_address)+context.getString(R.string.goodsrushlist)+"?time="+time,map, new OkhttpUtil.BeanCallback() {
            @Override
            public void onSuccess(String data) {
                if (!TextUtils.isEmpty(data)) {
                    KillGoodsBean killGoodsBeans = JSON.parseObject(data,KillGoodsBean.class);
                    if (flashSaleCall != null){
                        if (isR) {
                            flashSaleCall.onKillGoodsBack(killGoodsBeans);
                        }else {
                            flashSaleCall.loadMore(killGoodsBeans);
                        }
                        page++;
                    }
                }
            }

            @Override
            public void onFailure(int code, String errorMsg) {

            }

        });
    }

    public void goodsrushtimelist(FlashSaleTimeCall flashSaleCall){
        Map<String,String> map = new HashMap<>();
//        map.put("time",time);
        OkhttpUtil.get(context.getString(R.string.server_address)+context.getString(R.string.goodsrushtimelist),map, new OkhttpUtil.BeanCallback() {
            @Override
            public void onSuccess(String data) {
                if (!TextUtils.isEmpty(data)) {
                    List<String> list =  GsonUtil.changeGsonToList(data,String.class);
                    if (flashSaleCall != null){
                        flashSaleCall.onFlashSaleTime(list);

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

        void loadMore(KillGoodsBean killGoodsBean);
    }

    public interface FlashSaleTimeCall{

        void onFlashSaleTime(List<String> list);

    }

}
