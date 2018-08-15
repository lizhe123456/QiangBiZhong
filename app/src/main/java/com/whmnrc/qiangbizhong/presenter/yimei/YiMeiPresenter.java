package com.whmnrc.qiangbizhong.presenter.yimei;

import android.content.Context;
import android.text.TextUtils;

import com.blankj.utilcode.util.ToastUtils;
import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseCall;
import com.whmnrc.qiangbizhong.model.bean.YiMeiGoodsBean;
import com.whmnrc.qiangbizhong.model.bean.YiMeiGoodsDetailBean;
import com.whmnrc.qiangbizhong.model.bean.YiMeiIndexBean;
import com.whmnrc.qiangbizhong.util.GsonUtil;
import com.whmnrc.qiangbizhong.util.OkhttpUtil;
import com.whmnrc.qiangbizhong.util.ToastUtil;
import com.whmnrc.qiangbizhong.util.UserManage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.Call;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/25.
 */

public class YiMeiPresenter {

    private int page;

    private Context context;

    public YiMeiPresenter(Context context) {
        this.context = context;
    }

    public void medicalIndex(boolean isR, MedicalIndexCall medicalIndexCall){
        Map<String,String> map = new HashMap<>();
        if (isR){
            page = 1;
        }
        map.put("PageIndex",page+"");
        map.put("PageCount","10");
        OkhttpUtil.post(context.getString(R.string.server_address) + context.getString(R.string.medicalIndex), map, new OkhttpUtil.BeanCallback() {
            @Override
            public void onSuccess(String data) {
                YiMeiIndexBean yiMeiIndexBean = GsonUtil.changeGsonToBean(data,YiMeiIndexBean.class);
                if (medicalIndexCall != null){
                    if (isR) {
                        medicalIndexCall.medicalIndexBack(yiMeiIndexBean);
                    }else {
                        if (yiMeiIndexBean != null) {
                            medicalIndexCall.loadMore(yiMeiIndexBean.getMedicalList());
                        }else {
                            medicalIndexCall.error();
                        }
                    }
                    page++;
                }

            }

            @Override
            public void onFailure(int code, String errorMsg) {
                if (medicalIndexCall != null) {
                    medicalIndexCall.error();
                }
            }
        });

    }

    public void medicalsearchlist(boolean isR,String keyWord,int sortIndex,double latitude, double longitude,String typeId,SearchCall searchCall){
        Map<String, String> map = new HashMap<>();
        if (isR){
            page = 1;
        }
        map.put("PageIndex",page + "");
        map.put("PageCount","10");
        map.put("KeyWord",keyWord);
        map.put("SortIndex",sortIndex+"");
        if (!TextUtils.isEmpty(typeId)) {
            map.put("ProductTypeId", typeId);
        }
        OkhttpUtil.post(context.getString(R.string.server_address) + context.getString(R.string.medicalsearchlist) +"?latitude="+latitude + "&longitude=" + longitude, map, new OkhttpUtil.BeanCallback() {
            @Override
            public void onSuccess(String data) {
                List<YiMeiGoodsBean> yiMeiGoodsBeans = GsonUtil.changeGsonToList(data,YiMeiGoodsBean.class);
                if (searchCall != null){
                    if (isR) {
                        searchCall.searchGoods(yiMeiGoodsBeans);
                    }else {
                        searchCall.loadMore(yiMeiGoodsBeans);
                    }
                    page++;
                }
            }

            @Override
            public void onFailure(int code, String errorMsg) {
                if (searchCall != null){
                    searchCall.error();
                }
            }
        });
    }



    //医美详情
    public void getmedicaldetail(String goodsId,MedicaldetailCall medicaldetailCall){
        Map<String,String> map = new HashMap<>();
        OkhttpUtil.get(context.getString(R.string.server_address) + context.getString(R.string.getmedicaldetail)+"?goodsId=" + goodsId + "&userId=" + UserManage.getInstance().getUserID(), map, new OkhttpUtil.BeanCallback() {
            @Override
            public void onSuccess(String data) {
                YiMeiGoodsDetailBean yiMeiGoodsDetailBean = GsonUtil.changeGsonToBean(data,YiMeiGoodsDetailBean.class);
                if (medicaldetailCall != null){
                    medicaldetailCall.medicaldetai(yiMeiGoodsDetailBean);
                }
            }

            @Override
            public void onFailure(int code, String errorMsg) {
                if (medicaldetailCall != null){
                    medicaldetailCall.error();
                }
            }
        });

    }

    public interface SearchCall extends BaseCall{
        void searchGoods(List<YiMeiGoodsBean> yiMeiGoodsBeanList);

        void loadMore(List<YiMeiGoodsBean> yiMeiGoodsBeanList);
    }

    public interface MedicalIndexCall extends BaseCall{

        void medicalIndexBack(YiMeiIndexBean yiMeiIndexBean);

        void loadMore(List<YiMeiIndexBean.MedicalListBean> listBeans);
    }

    public interface MedicaldetailCall extends BaseCall{
        void medicaldetai(YiMeiGoodsDetailBean yiMeiGoodsDetailBean);
    }

}
