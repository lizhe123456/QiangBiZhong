package com.whmnrc.qiangbizhong.presenter.me;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.blankj.utilcode.util.ToastUtils;
import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseCall;
import com.whmnrc.qiangbizhong.base.BaseResponse;
import com.whmnrc.qiangbizhong.model.bean.CollectionBean;
import com.whmnrc.qiangbizhong.presenter.shopcar.ShopCarPresenter;
import com.whmnrc.qiangbizhong.util.GsonUtil;
import com.whmnrc.qiangbizhong.util.OkhttpUtil;
import com.whmnrc.qiangbizhong.util.ToastUtil;
import com.whmnrc.qiangbizhong.util.UserManage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/31.
 */

public class CollectionPresenter {

    private Activity context;

    private int page;

    public CollectionPresenter(Activity context) {
        this.context = context;
    }

    public void addcollection(int showType,String cId , int type,CollectionCall collectionCall){
        //shopType 0 商城  3 医美
        Map<String,String> map = new HashMap<>();
        OkhttpUtil.get(context.getString(R.string.server_address) + context.getString(R.string.addcollection)
                + "?type=" + type + "&goodsIdOrStoreId=" + cId +"&userId=" + UserManage.getInstance().getUserID() + "&shopType=" + showType, map, new OkhttpUtil.BeanCallback() {
            @Override
            public void onSuccess(String data) {
                if (!context.isDestroyed()) {
                    if (collectionCall != null) {
                        collectionCall.cS();
                        ToastUtils.showShort("收藏成功");
                    }
                }
            }

            @Override
            public void onFailure(int code, String errorMsg) {
                if (!context.isDestroyed()) {
                    if (collectionCall != null) {
                        collectionCall.error();
                    }
                }
            }
        });
    }

    public void cannercollection(int type, String gsId, CollectionCall collectionCall){
        //shopType 0 商城  3 医美
        Map<String,String> map = new HashMap<>();
        OkhttpUtil.get(context.getString(R.string.server_address) + context.getString(R.string.cannercollection)
                + "?type=" + type + "&goodsIdOrStoreId=" + gsId +"&userId=" + UserManage.getInstance().getUserID(), map, new OkhttpUtil.BeanCallback() {
            @Override
            public void onSuccess(String data) {
                if (!context.isDestroyed()) {
                    if (collectionCall != null) {
                        collectionCall.cS();
                        ToastUtils.showShort("取消成功");
                    }
                }
            }

            @Override
            public void onFailure(int code, String errorMsg) {
                if (!context.isDestroyed()) {
                    if (collectionCall != null) {
                        collectionCall.error();
                    }
                }
            }
        });
    }

    public void cannercollectionlist(List<String> list,int type,CollectionCall collectionCall){
        OkhttpUtil.postString(context.getString(R.string.server_address) + context.getString(R.string.cannercollectionlist) +
                "?userId=" + UserManage.getInstance().getUserID() +
                "&type=" + type , GsonUtil.createGsonString(list), new OkhttpUtil.BeanCallback() {
            @Override
            public void onSuccess(String data) {
                if (!context.isDestroyed()) {
                    if (collectionCall != null) {
                        collectionCall.cS();
                    }
                }
            }

            @Override
            public void onFailure(int code, String errorMsg) {
                if (!context.isDestroyed()) {
                    if (collectionCall != null) {
                        collectionCall.error();
                    }
                }
            }
        });
    }

    public void addcollectionlist(List<String> list,CollectionCall collectionCall){
        OkhttpUtil.postString(context.getString(R.string.server_address) + context.getString(R.string.addcollectionlist)
                + "?userId=" + UserManage.getInstance().getUserID() , GsonUtil.createGsonString(list), new OkhttpUtil.BeanCallback() {
            @Override
            public void onSuccess(String data) {
                if (!context.isDestroyed()) {
                    if (collectionCall != null) {
                        if (TextUtils.isEmpty(data)) {
                            ToastUtils.showShort("添加成功");
                        } else {
                            ToastUtils.showShort(data);
                        }
                    }
                }


            }

            @Override
            public void onFailure(int code, String errorMsg) {
                if (!context.isDestroyed()) {
                    if (collectionCall != null) {
                        collectionCall.error();
                    }
                }
            }
        });
    }

    public void getcollectionlist(int type,boolean isR,CollectionListCall collectionListCall){
        Map<String,String> map = new HashMap<>();
        if (isR){
            page = 1;
        }
        map.put("PageIndex",page+"");
        map.put("PageCount","10");
        OkhttpUtil.post(context.getString(R.string.server_address) + context.getString(R.string.getcollectionlist) + "?userId=" + UserManage.getInstance().getUserID() +
                "&type=" + type, map, new OkhttpUtil.BeanCallback() {
            @Override
            public void onSuccess(String data) {
                List<CollectionBean> collectionBeans = GsonUtil.changeGsonToList(data,CollectionBean.class);
                if (!context.isDestroyed()) {
                    if (collectionListCall != null) {
                        if (isR) {
                            collectionListCall.collectionList(collectionBeans);
                        } else {
                            collectionListCall.loadMore(collectionBeans);
                        }
                        page++;
                    }
                }
            }

            @Override
            public void onFailure(int code, String errorMsg) {
                if (!context.isDestroyed()) {
                    if (collectionListCall != null) {
                        collectionListCall.error();
                    }
                }
            }
        });
    }

    public interface CollectionCall extends BaseCall {
        void cS();
    }

    public interface CollectionListCall extends BaseCall{

        void collectionList(@NonNull List<CollectionBean> collectionBeans);

        void loadMore(@NonNull List<CollectionBean> collectionBeans);
    }


}
