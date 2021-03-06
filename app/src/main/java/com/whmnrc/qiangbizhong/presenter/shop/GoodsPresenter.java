package com.whmnrc.qiangbizhong.presenter.shop;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;

import com.blankj.utilcode.util.ToastUtils;
import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseCall;
import com.whmnrc.qiangbizhong.model.bean.EditBannerBean;
import com.whmnrc.qiangbizhong.model.bean.GoodsManageBean;
import com.whmnrc.qiangbizhong.model.parameter.BannerParam;
import com.whmnrc.qiangbizhong.model.parameter.GoodsParam;
import com.whmnrc.qiangbizhong.util.GsonUtil;
import com.whmnrc.qiangbizhong.util.OkhttpUtil;
import com.whmnrc.qiangbizhong.util.ToastUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/8/7.
 */

public class GoodsPresenter {

    private Activity context;
    private int page;

    public GoodsPresenter(Activity context) {
        this.context = context;
    }


    public void releaseGoods(GoodsParam goodsParam,int type, ReleaseGoodsCall releaseGoodsCall){
        OkhttpUtil.postString(context.getString(R.string.server_address) + (type == 0 ?  context.getString(R.string.submitgoods) : context.getString(R.string.updategoodsinfo)), GsonUtil.createGsonString(goodsParam), new OkhttpUtil.BeanCallback() {
            @Override
            public void onSuccess(String data) {
                if (!context.isDestroyed()) {
                    if (releaseGoodsCall != null) {
                        releaseGoodsCall.releaseS();
                    }
                    ToastUtils.showShort("发布成功");
                }
            }

            @Override
            public void onFailure(int code, String errorMsg) {
                if (!context.isDestroyed()) {
                    if (releaseGoodsCall != null) {
                        releaseGoodsCall.error();
                    }
                }
            }
        });
    }

    public void updategoodsinfo(GoodsParam goodsParam, ReleaseGoodsCall releaseGoodsCall){
        OkhttpUtil.postString(context.getString(R.string.server_address) + context.getString(R.string.updategoodsinfo), GsonUtil.createGsonString(goodsParam), new OkhttpUtil.BeanCallback() {
            @Override
            public void onSuccess(String data) {
                if (!context.isDestroyed()) {
                    if (releaseGoodsCall != null) {
                        releaseGoodsCall.releaseS();
                    }
                    ToastUtils.showShort("修改成功");
                }
            }

            @Override
            public void onFailure(int code, String errorMsg) {
                if (!context.isDestroyed()) {
                    if (releaseGoodsCall != null) {
                        releaseGoodsCall.error();
                    }
                }
            }
        });
    }

    public void getgoodslist(String type,String storeId,boolean isR,GoodsListCall goodsListCall){
        Map<String,String> map = new HashMap<>();
        if (isR){
            page = 1;
        }
        map.put("PageIndex",page+"");
        map.put("PageCount","10");
        OkhttpUtil.post(context.getString(R.string.server_address) + context.getString(R.string.getgoodslist) + "?storeId="
                + storeId + "&type=" + type, map, new OkhttpUtil.BeanCallback() {
            @Override
            public void onSuccess(String data) {
                List<GoodsManageBean> list = GsonUtil.changeGsonToList(data,GoodsManageBean.class);
                if (!context.isDestroyed()) {
                    if (goodsListCall != null) {
                        if (list != null) {
                            if (isR) {
                                goodsListCall.getGoods(list);
                            } else {
                                goodsListCall.loadMore(list);
                            }
                            page++;
                        }
                    }
                }
            }

            @Override
            public void onFailure(int code, String errorMsg) {
                if (!context.isDestroyed()) {
                    if (goodsListCall != null) {
                        goodsListCall.error();
                    }
                }
            }
        });
    }

    public void getgoodsbanner(String goodsId,GoodsBannerCall goodsBannerCall){
        Map<String,String> map = new HashMap<>();
        OkhttpUtil.get(context.getString(R.string.server_address) + context.getString(R.string.getgoodsbanner) + "?goodsId=" + goodsId,
                map, new OkhttpUtil.BeanCallback() {
                    @Override
                    public void onSuccess(String data) {
                        List<EditBannerBean> list = GsonUtil.changeGsonToList(data,EditBannerBean.class);
                        if (!context.isDestroyed()) {
                            if (goodsBannerCall != null) {
                                goodsBannerCall.getgoodsbanner(list);
                            }
                        }
                    }

                    @Override
                    public void onFailure(int code, String errorMsg) {
                        if (!context.isDestroyed()) {
                            if (goodsBannerCall != null) {
                                goodsBannerCall.error();
                            }
                        }
                    }
                });
    }

    public void addgoodsbanner(List<BannerParam> imgs, AddGoodsBannerCall addGoodsBannerCall){
        OkhttpUtil.postString(context.getString(R.string.server_address) + context.getString(R.string.addgoodsbanner) ,GsonUtil.createGsonString(imgs), new OkhttpUtil.BeanCallback() {
            @Override
            public void onSuccess(String data) {
                if (!context.isDestroyed()) {
                    if (addGoodsBannerCall != null) {
                        addGoodsBannerCall.addGoodsBanner();
                    }
                }
                ToastUtils.showShort("添加成功");
            }

            @Override
            public void onFailure(int code, String errorMsg) {
                if (!context.isDestroyed()) {
                    if (addGoodsBannerCall != null) {
                        addGoodsBannerCall.error();
                    }
                }
            }
        });
    }

    //上架商品
    public void setgoodsgoup(String goodsId,int type,GoodsGoupCall goodsGoupCall){
        OkhttpUtil.get(context.getString(R.string.server_address) + context.getString(R.string.setgoodsgoup) + "?goodsId="
                + goodsId + "&type=" + type, new HashMap<>(), new OkhttpUtil.BeanCallback() {
            @Override
            public void onSuccess(String data) {
                if (!context.isDestroyed()) {
                    if (goodsGoupCall != null) {
                        if (type == 0) {
                            ToastUtils.showShort("下架成功");
                        } else {
                            ToastUtils.showShort("上架成功");
                        }
                        goodsGoupCall.goodsgoup();
                    }
                }
            }

            @Override
            public void onFailure(int code, String errorMsg) {
                if (!context.isDestroyed()) {
                    if (goodsGoupCall != null) {
                        goodsGoupCall.error();
                    }
                }
            }
        });
    }

    public void setstoregoodsgoup(String storeId, int type,GoodsGoupCall goodsListCall){
        OkhttpUtil.get(context.getString(R.string.server_address) + context.getString(R.string.setstoregoodsgoup) + "?storeId="
                + storeId + "&type=" + type, new HashMap<>(), new OkhttpUtil.BeanCallback() {
            @Override
            public void onSuccess(String data) {
                if (!context.isDestroyed()) {
                    if (goodsListCall != null) {
                        if (type == 0) {
                            ToastUtils.showShort("下架成功");
                        } else {
                            ToastUtils.showShort("上架成功");
                        }
                        goodsListCall.goodsgoup();
                    }
                }
            }

            @Override
            public void onFailure(int code, String errorMsg) {
                if (!context.isDestroyed()) {
                    if (goodsListCall != null) {
                        goodsListCall.error();
                    }
                }
            }
        });
    }



    public interface ReleaseGoodsCall extends BaseCall{

        void releaseS();
    }

    public interface GoodsListCall extends BaseCall{
        void getGoods(@NonNull List<GoodsManageBean> goodsParamList);

        void loadMore(@NonNull List<GoodsManageBean> goodsParamList);
    }

    public interface GoodsBannerCall extends BaseCall{
        void getgoodsbanner(@NonNull List<EditBannerBean> editBannerBeans);
    }

    public interface AddGoodsBannerCall extends BaseCall{
        void addGoodsBanner();
    }

    public interface GoodsGoupCall extends BaseCall{
        void goodsgoup();
    }
}
