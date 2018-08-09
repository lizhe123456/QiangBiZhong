package com.whmnrc.qiangbizhong.presenter.shop;

import android.content.Context;

import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseCall;
import com.whmnrc.qiangbizhong.model.bean.EditSpecBean;
import com.whmnrc.qiangbizhong.model.bean.SpecBean;
import com.whmnrc.qiangbizhong.model.parameter.SpecParam;
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

    public void getEditSpecList(String goodsId, EditSpecCall editSpecCall){
        Map<String,String> map = new HashMap<>();
        OkhttpUtil.get(context.getString(R.string.server_address) + context.getString(R.string.getgoodsspeclist) + "?goodsId="
                + goodsId, map, new OkhttpUtil.BeanCallback() {
            @Override
            public void onSuccess(String data) {
                EditSpecBean editSpecBean = GsonUtil.changeGsonToBean(data,EditSpecBean.class);
                if (editSpecCall != null){
                    editSpecCall.specBack(editSpecBean);
                }

            }

            @Override
            public void onFailure(int code, String errorMsg) {
                if (editSpecCall != null){
                    editSpecCall.error();
                }
            }
        });

    }

    public void addSpec(SpecParam specParam,SpecStatuCall specStatuCall){
        OkhttpUtil.postString(context.getString(R.string.server_address) + context.getString(R.string.addgoodsspec), GsonUtil.createGsonString(specParam), new OkhttpUtil.BeanCallback() {
            @Override
            public void onSuccess(String data) {
                if (specStatuCall != null){
                    specStatuCall.specBack();
                }
            }

            @Override
            public void onFailure(int code, String errorMsg) {
                if (specStatuCall != null){
                    specStatuCall.error();
                }
            }
        });

    }

    public void updateSpec(SpecParam specParam,SpecStatuCall specStatuCall){
        OkhttpUtil.postString(context.getString(R.string.server_address) + context.getString(R.string.updategoodsspec), GsonUtil.createGsonString(specParam), new OkhttpUtil.BeanCallback() {
            @Override
            public void onSuccess(String data) {
                if (specStatuCall != null){
                    specStatuCall.specBack();
                }
            }

            @Override
            public void onFailure(int code, String errorMsg) {
                if (specStatuCall != null){
                    specStatuCall.error();
                }
            }
        });
    }

    public void deleteSpec(String goodsPriceId,SpecStatuCall specStatuCall){
        OkhttpUtil.get(context.getString(R.string.server_address) + context.getString(R.string.deletegoodsspec)+"?goodsPriceId=" + goodsPriceId,new HashMap<>(), new OkhttpUtil.BeanCallback() {
            @Override
            public void onSuccess(String data) {
                if (specStatuCall != null){
                    specStatuCall.specBack();
                }
            }

            @Override
            public void onFailure(int code, String errorMsg) {
                if (specStatuCall != null){
                    specStatuCall.error();
                }
            }
        });
    }


    public interface GoodsSpecCall extends BaseCall{
        void spceBack(SpecBean specBean);
    }

    public interface EditSpecCall extends BaseCall{

        void specBack(EditSpecBean editSpecBean);
    }

    public interface SpecStatuCall extends BaseCall{

        void specBack();
    }

}
