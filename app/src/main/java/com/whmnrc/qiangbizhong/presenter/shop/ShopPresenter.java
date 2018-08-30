package com.whmnrc.qiangbizhong.presenter.shop;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseCall;
import com.whmnrc.qiangbizhong.model.bean.ShopBean;
import com.whmnrc.qiangbizhong.model.bean.ShopDetailsBean;
import com.whmnrc.qiangbizhong.model.bean.ShopGoodsBean;
import com.whmnrc.qiangbizhong.model.bean.StroeBean;
import com.whmnrc.qiangbizhong.model.bean.YiMeiGoodsBean;
import com.whmnrc.qiangbizhong.util.GsonUtil;
import com.whmnrc.qiangbizhong.util.OkhttpUtil;
import com.whmnrc.qiangbizhong.util.UserManage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/30.
 */

public class ShopPresenter {

    private Activity context;

    private int page;

    public ShopPresenter(Activity context) {
        this.context = context;
    }

    public void getshoppingindex(boolean isR,ShopIndexCall shopIndexCall){
        Map<String,String> map = new HashMap<>();
        if (isR){
            page = 1;
        }
        map.put("PageIndex",page+"");
        map.put("PageCount","10");
        OkhttpUtil.post(context.getString(R.string.server_address) + context.getString(R.string.getshoppingindex), map, new OkhttpUtil.BeanCallback() {
            @Override
            public void onSuccess(String data) {
                ShopBean sHopBean = GsonUtil.changeGsonToBean(data,ShopBean.class);
                if (!context.isDestroyed()) {
                    if (shopIndexCall != null) {
                        if (isR) {
                            if (sHopBean != null) {
                                shopIndexCall.shoIndex(sHopBean);
                            }
                        } else {
                            if (sHopBean != null) {
                                shopIndexCall.loadMore(sHopBean.getPalteList());
                            }
                        }
                        page++;
                    }
                }
            }

            @Override
            public void onFailure(int code, String errorMsg) {
                if (!context.isDestroyed()) {
                    if (shopIndexCall != null) {
                        shopIndexCall.error();
                    }
                }
            }
        });
    }

    public void goodssearchlist(String productTypeId,String keyWord,int sortIndex,boolean isR,ShopSearchListCall shopIndexCall){
        Map<String,String> map = new HashMap<>();
        if (isR){
            page = 1;
        }
        map.put("PageIndex",page+"");
        map.put("PageCount","10");
        map.put("SortIndex",sortIndex+"");
        map.put("KeyWord",keyWord);
        if (!TextUtils.isEmpty(productTypeId)){
            map.put("ProductTypeId",productTypeId);
        }

        OkhttpUtil.post(context.getString(R.string.server_address) + context.getString(R.string.goodssearchlist), map, new OkhttpUtil.BeanCallback() {
            @Override
            public void onSuccess(String data) {
                List<ShopGoodsBean> yiMeiGoodsBeans = GsonUtil.changeGsonToList(data,ShopGoodsBean.class);
                if (!context.isDestroyed()) {
                    if (shopIndexCall != null) {
                        if (yiMeiGoodsBeans != null)
                            if (isR) {
                                shopIndexCall.searchList(yiMeiGoodsBeans);
                            } else {
                                shopIndexCall.loadMore(yiMeiGoodsBeans);
                            }
                        page++;
                    }
                }
            }

            @Override
            public void onFailure(int code, String errorMsg) {
                if (!context.isDestroyed()) {
                    if (shopIndexCall != null) {
                        shopIndexCall.error();
                    }
                }
            }
        });

    }

    public void getGoodsDetail(String goodsId,ShopDetailCall shopIndexCall){
        Map<String,String> map = new HashMap<>();
        map.put("userId", UserManage.getInstance().getUserID());
        map.put("goodsId",goodsId);

        OkhttpUtil.get(context.getString(R.string.server_address) + context.getString(R.string.getgoodsdetail), map, new OkhttpUtil.BeanCallback() {
            @Override
            public void onSuccess(String data) {
                ShopDetailsBean shopDetailsBean = GsonUtil.changeGsonToBean(data,ShopDetailsBean.class);
                if (!context.isDestroyed()) {
                    if (shopIndexCall != null) {
                        if (shopDetailsBean != null) {
                            shopIndexCall.shopDetails(shopDetailsBean);
                        }
                    }
                }
            }

            @Override
            public void onFailure(int code, String errorMsg) {
                if (!context.isDestroyed()) {
                    if (shopIndexCall != null) {
                        shopIndexCall.error();
                    }
                }
            }
        });
    }

    //商城商铺信息
    public void getshoppingstoredetail(String keyWord,String storeId, int sortIndex, boolean isR,StoreDeailCall storeDeailCall){
        Map<String,String> map = new HashMap<>();
        if (isR){
            page = 1;
        }
        map.put("PageIndex",page+"");
        map.put("PageCount",10+"");
        map.put("SortIndex",sortIndex+"");
        map.put("KeyWord",keyWord);
        OkhttpUtil.post(context.getString(R.string.server_address) + context.getString(R.string.getshoppingstoredetail) +
                "?userId=" + UserManage.getInstance().getUserID() + "&storeId=" + storeId, map, new OkhttpUtil.BeanCallback() {
            @Override
            public void onSuccess(String data) {
                StroeBean stroeBean = GsonUtil.changeGsonToBean(data,StroeBean.class);
                if (!context.isDestroyed()) {
                    if (storeDeailCall != null) {
                        if (stroeBean != null) {
                            if (isR) {
                                storeDeailCall.storeDeail(stroeBean.getResult());
                            } else {
                                storeDeailCall.loadMore(stroeBean.getResult().getGoods());
                            }
                            page++;
                        }
                    }
                }
            }

            @Override
            public void onFailure(int code, String errorMsg) {
                if (!context.isDestroyed()) {
                    if (storeDeailCall != null) {
                        storeDeailCall.error();
                    }
                }
            }
        });
    }

//    public void getgoodsspecattr(){
//        Map<String,String> map = new HashMap<>();
//        if (isR){
//            page = 1;
//        }
//        map.put("PageIndex",page+"");
//        map.put("PageCount","10");
//        OkhttpUtil.post(context.getString(R.string.server_address) + context.getString(R.string.getshoppingindex), map, new OkhttpUtil.BeanCallback() {
//            @Override
//            public void onSuccess(String data) {
//                ShopBean sHopBean = GsonUtil.changeGsonToBean(data,ShopBean.class);
//                if (shopIndexCall != null) {
//                    if (isR) {
//                        if (sHopBean != null) {
//                            shopIndexCall.shoIndex(sHopBean);
//                        }
//                    } else {
//                        if (sHopBean != null) {
//                            shopIndexCall.loadMore(sHopBean.getPalteList());
//                        }
//                    }
//                }
//            }
//
//            @Override
//            public void onFailure(int code, String errorMsg) {
//                if (shopIndexCall != null) {
//                    shopIndexCall.error();
//                }
//            }
//        });
//    }

    public interface ShopIndexCall extends BaseCall{

        void shoIndex(@NonNull ShopBean shopBean);

        void loadMore(@NonNull List<ShopBean.PalteListBean> palteListBeans);

    }

    public interface ShopSearchListCall extends BaseCall{

        void searchList(@NonNull List<ShopGoodsBean> yiMeiGoodsBeans);

        void loadMore(@NonNull List<ShopGoodsBean> yiMeiGoodsBeans);

    }

    public interface ShopDetailCall extends BaseCall{

        void shopDetails(@NonNull ShopDetailsBean shopBean);

    }
//
//    public interface ShopIndexCall extends BaseCall{
//
//        void shoIndex(@NonNull ShopBean shopBean);
//
//        void loadMore(@NonNull List<ShopBean.PalteListBean> palteListBeans);
//
//    }

    public interface StoreDeailCall extends BaseCall{
        void storeDeail(@NonNull StroeBean.ResultBean stroeBean);

        void loadMore(@NonNull List<StroeBean.ResultBean.GoodsBean> goodsBeans);

    }

}
