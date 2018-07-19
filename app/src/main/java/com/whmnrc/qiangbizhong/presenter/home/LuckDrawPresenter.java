package com.whmnrc.qiangbizhong.presenter.home;

import android.content.Context;

import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseCall;
import com.whmnrc.qiangbizhong.model.bean.LuckDrawGoodsBean;
import com.whmnrc.qiangbizhong.model.bean.LuckDrawGoodsBeanV2;
import com.whmnrc.qiangbizhong.model.bean.MyLuckDrawBean;
import com.whmnrc.qiangbizhong.util.GsonUtil;
import com.whmnrc.qiangbizhong.util.OkhttpUtil;
import com.whmnrc.qiangbizhong.util.UserManage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/14.
 */

public class LuckDrawPresenter {

    private Context context;

    private int page = 1;
    private int size = 10;

    public LuckDrawPresenter(Context context) {
        this.context = context;
    }

    public void awardlist2(int type, LuckDrawCall luckDrawCall, boolean isR){
        Map<String,String> map = new HashMap<>();
        if (isR) {
            page = 1;
        }
        map.put("PageIndex", page + "");
        map.put("PageCount",size+"");

        OkhttpUtil.post(context.getString(R.string.server_address) + context.getString(R.string.awardlist2)+"?type="+type,map, new OkhttpUtil.BeanCallback(){
            @Override
            public void onSuccess(String data) {
                List<LuckDrawGoodsBean> luckDrawGoodsBean = GsonUtil.changeGsonToList(data,LuckDrawGoodsBean.class);
                if (luckDrawCall != null){
                    if (isR) {
                        luckDrawCall.luckDrawBack(luckDrawGoodsBean);
                    }else {
                        luckDrawCall.loadMore(luckDrawGoodsBean);
                    }
                    page++;
                }
            }

            @Override
            public void onFailure(int code, String errorMsg) {
                if (luckDrawCall != null){
                    luckDrawCall.error();
                }
            }
        });
    }

    public void awardlist2(int type, LuckDrawCall2 luckDrawCall, boolean isR){
        Map<String,String> map = new HashMap<>();
        if (isR) {
            page = 1;
        }
        map.put("PageIndex", page + "");
        map.put("PageCount",size+"");

        OkhttpUtil.post(context.getString(R.string.server_address) + context.getString(R.string.awardlist2)+"?type="+type,map, new OkhttpUtil.BeanCallback(){
            @Override
            public void onSuccess(String data) {
                List<LuckDrawGoodsBeanV2> luckDrawGoodsBean = GsonUtil.changeGsonToList(data,LuckDrawGoodsBeanV2.class);
                if (luckDrawCall != null){
                    if (isR) {
                        luckDrawCall.luckDrawBack(luckDrawGoodsBean);
                    }else {
                        luckDrawCall.loadMore(luckDrawGoodsBean);
                    }
                    page++;
                }
            }

            @Override
            public void onFailure(int code, String errorMsg) {
                if (luckDrawCall != null){
                    luckDrawCall.error();
                }
            }
        });
    }


    //我的奖品
    public void awardlist(MyLuckDrawCall myLuckDrawCall,boolean isR){
        Map<String,String> map = new HashMap<>();
        if (isR){
            page = 1;
        }
        map.put("PageIndex",page+"");
        map.put("PageCount",size+"");
        OkhttpUtil.post(context.getString(R.string.server_address) + context.getString(R.string.myawardlist) + "?userId=" + UserManage.getInstance().getUserID(), map, new OkhttpUtil.BeanCallback() {
            @Override
            public void onSuccess(String data) {
                List<MyLuckDrawBean> luckDrawBeans = GsonUtil.changeGsonToList(data,MyLuckDrawBean.class);
                if (myLuckDrawCall != null){
                    if (isR) {
                        myLuckDrawCall.myLuckDraw(luckDrawBeans);
                    }else {
                        myLuckDrawCall.loadMore(luckDrawBeans);
                    }
                    page++;
                }

            }

            @Override
            public void onFailure(int code, String errorMsg) {
                if (myLuckDrawCall != null){
                    myLuckDrawCall.error();
                }
            }
        });
    }

    public interface LuckDrawCall2 extends BaseCall{
        void luckDrawBack(List<LuckDrawGoodsBeanV2> luckDrawGoodsBean);

        void loadMore(List<LuckDrawGoodsBeanV2> luckDrawGoodsBean);
    }

    public interface MyLuckDrawCall extends BaseCall{

        void myLuckDraw(List<MyLuckDrawBean> myLuckDrawBeans);

        void loadMore(List<MyLuckDrawBean> myLuckDrawBeans);

    }

    public interface LuckDrawCall extends BaseCall {

        void luckDrawBack(List<LuckDrawGoodsBean> luckDrawGoodsBean);

        void loadMore(List<LuckDrawGoodsBean> luckDrawGoodsBean);

    }

}
