package com.whmnrc.qiangbizhong.presenter.shopcar;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.blankj.utilcode.util.ToastUtils;
import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseCall;
import com.whmnrc.qiangbizhong.base.BaseResponse;
import com.whmnrc.qiangbizhong.model.bean.ShopCarBean;
import com.whmnrc.qiangbizhong.util.GsonUtil;
import com.whmnrc.qiangbizhong.util.OkhttpUtil;
import com.whmnrc.qiangbizhong.util.ToastUtil;
import com.whmnrc.qiangbizhong.util.UserManage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/30.
 */

public class ShopCarPresenter {

    private Context context;

    public ShopCarPresenter(Context context) {
        this.context = context;
    }


    public void addcar(String goodsId,String goodsPriceId,int count,CarStatuCall collectionCall){
        Map<String,String> map = new HashMap<>();
        OkhttpUtil.get(context.getString(R.string.server_address) + context.getString(R.string.addcar)
                        + "?userId=" + UserManage.getInstance().getUserID() + "&goodsId=" + goodsId + "&goodsPriceId=" + goodsPriceId +
                "&number=" + count,map,new OkhttpUtil.BeanCallback(){
            @Override
            public void onSuccess(String data) {
                if (collectionCall != null){
                    collectionCall.csS();
                }
                ToastUtils.showShort("加入成功");

            }

            @Override
            public void onFailure(int code, String errorMsg) {
                if (collectionCall != null){
                    collectionCall.error();
                }
            }
        });
    }

    public void deletecars(List<String> carIds,CarStatuCall carStatuCall){
        Map<String,String> map = new HashMap<>();
        OkhttpUtil.postString(context.getString(R.string.server_address) + context.getString(R.string.deletecars), GsonUtil.createGsonString(carIds), new OkhttpUtil.BeanCallback() {
            @Override
            public void onSuccess(String st) {
                if (carStatuCall != null){
                    carStatuCall.deleteCar();
                }
                if (TextUtils.isEmpty(st)) {
                    ToastUtils.showShort("删除成功");
                }else {
                    ToastUtils.showShort(st);
                }
            }

            @Override
            public void onFailure(int code, String errorMsg) {
                if (carStatuCall != null){
                    carStatuCall.error();
                }
            }
        });
    }

    public void getcarlist(CarCall carCall){
        Map<String,String> map = new HashMap<>();
        map.put("userId",UserManage.getInstance().getUserID());
        OkhttpUtil.get(context.getString(R.string.server_address) + context.getString(R.string.getcarlist), map, new OkhttpUtil.BeanCallback() {
            @Override
            public void onSuccess(String data) {
                List<ShopCarBean> shopCarBeans = GsonUtil.changeGsonToList(data, ShopCarBean.class);
                if (carCall != null){
                    carCall.showCarList(shopCarBeans);
                }
            }

            @Override
            public void onFailure(int code, String errorMsg) {
                if (carCall != null){
                    carCall.error();
                }
            }
        });

    }

    public void updatecar(String carId, String goodsId, String goodsPriceId,CarStatuCall carStatuCall){
        OkhttpUtil.get(context.getString(R.string.server_address) + context.getString(R.string.updatecar) +
                        "?carId=" + carId + "&userId=" + UserManage.getInstance().getUserID() + "&goodsId=" + goodsId +
                        "&goodsPriceId=" + goodsPriceId, new HashMap<>(), new OkhttpUtil.BeanCallback() {
                    @Override
                    public void onSuccess(String data) {
                        if (carStatuCall != null){
                            carStatuCall.updateS();
                        }
                        if (TextUtils.isEmpty(data)) {
                            ToastUtils.showShort("修改成功");
                        }else {
                            ToastUtils.showShort(data);
                        }
                    }

                    @Override
                    public void onFailure(int code, String errorMsg) {
                        if (carStatuCall != null){
                            carStatuCall.error();
                        }
                    }
                }
        );
    }

    public void updatecarnum(String carId, int type,CarStatuCall carStatuCall){
        OkhttpUtil.get(context.getString(R.string.server_address) + context.getString(R.string.updatecarnum) +
                "?carId=" + carId + "&type=" + type
                , new HashMap<>(), new OkhttpUtil.BeanCallback() {
            @Override
            public void onSuccess(String data) {
                if (carStatuCall != null){
                    carStatuCall.jj();
                }
                if (TextUtils.isEmpty(data)) {
                    ToastUtils.showShort("修改成功");
                }else {
                    ToastUtils.showShort(data);
                }
            }

            @Override
            public void onFailure(int code, String errorMsg) {
                if (carStatuCall != null){
                    carStatuCall.error();
                }
            }
        });
    }


    public interface CarStatuCall extends BaseCall{
        //加入成功
        void csS();

        void updateS();

        void jj();

        void deleteCar();
    }

    public interface CarCall extends BaseCall{

        void showCarList(List<ShopCarBean> shopCarBeans);

    }



}
