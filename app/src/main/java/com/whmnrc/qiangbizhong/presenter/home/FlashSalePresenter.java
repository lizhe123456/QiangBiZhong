package com.whmnrc.qiangbizhong.presenter.home;

import android.content.Context;
import android.text.TextUtils;

import com.alibaba.fastjson.JSON;
import com.blankj.utilcode.util.ToastUtils;
import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseCall;
import com.whmnrc.qiangbizhong.model.bean.FlashSaleBean;
import com.whmnrc.qiangbizhong.model.bean.KillGoodsBean;
import com.whmnrc.qiangbizhong.model.bean.RushRecordBean;
import com.whmnrc.qiangbizhong.util.GsonUtil;
import com.whmnrc.qiangbizhong.util.OkhttpUtil;
import com.whmnrc.qiangbizhong.util.ToastUtil;
import com.whmnrc.qiangbizhong.util.UserManage;

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
                if (flashSaleCall != null) {
                    flashSaleCall.error();
                }
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
                    List<FlashSaleBean.TimeBean> list =  GsonUtil.changeGsonToList(data, FlashSaleBean.TimeBean.class);
                    if (flashSaleCall != null){
                        flashSaleCall.onFlashSaleTime(list);

                    }
                }
            }

            @Override
            public void onFailure(int code, String errorMsg) {
                if (flashSaleCall != null) {
                    flashSaleCall.error();
                }
            }

        });
    }


    public void myRushGoodSrecord(boolean isR ,FlashSaleRecordCall flashSaleRecordCall){
        Map<String,String> map = new HashMap<>();
        if (isR){
            page = 1;
        }
        map.put("PageIndex",page+"");
        map.put("PageCount","10");
        OkhttpUtil.post(context.getString(R.string.server_address) + context.getString(R.string.myrushgoodsrecord)+"?userId="+ UserManage.getInstance().getUserID(), map, new OkhttpUtil.BeanCallback() {
            @Override
            public void onSuccess(String data) {
                List<RushRecordBean> rushRecordBeans = GsonUtil.changeGsonToList(data,RushRecordBean.class);
                if (flashSaleRecordCall != null){
                    if (isR) {
                        flashSaleRecordCall.onFlashSaleRecord(rushRecordBeans);
                    }else {
                        flashSaleRecordCall.loadMore(rushRecordBeans);
                    }
                    page++;
                }

            }

            @Override
            public void onFailure(int code, String errorMsg) {
                if (flashSaleRecordCall != null){
                    flashSaleRecordCall.error();
                }
            }
        });
    }

    public interface FlashSaleCall extends BaseCall{

        void onKillGoodsBack(KillGoodsBean killGoodsBeans);

        void loadMore(KillGoodsBean killGoodsBean);
    }

    public interface FlashSaleTimeCall extends BaseCall {

        void onFlashSaleTime(List<FlashSaleBean.TimeBean> list);

    }

    public interface FlashSaleRecordCall extends BaseCall{

        void onFlashSaleRecord(List<RushRecordBean> rushRecordBeans);

        void loadMore(List<RushRecordBean> rushRecordBeans);

    }

}
