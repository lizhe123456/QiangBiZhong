package com.whmnrc.qiangbizhong.presenter.home;

import android.content.Context;

import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.model.bean.LuckDrawGoodsBean;
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

    public void awardlist2(int type, LuckDrawCall luckDrawCall){
        Map<String,String> map = new HashMap<>();
        map.put("PageIndex",page+"");
        map.put("PageCount",size+"");
        OkhttpUtil.post(context.getString(R.string.server_address) + context.getString(R.string.awardlist2)+"?type="+type,map, new OkhttpUtil.BeanCallback(){

            @Override
            public void onSuccess(String data) {
                List<LuckDrawGoodsBean> luckDrawGoodsBean = GsonUtil.changeGsonToList(data,LuckDrawGoodsBean.class);
                if (luckDrawCall != null){
                    luckDrawCall.luckDrawBack(luckDrawGoodsBean);
                }
            }

            @Override
            public void onFailure(int code, String errorMsg) {

            }
        });
    }

    //我的奖品
    public void awardlist(){
        Map<String,String> map = new HashMap<>();
        map.put("PageIndex",page+"");
        map.put("PageCount",size+"");
        OkhttpUtil.post(context.getString(R.string.server_address) + context.getString(R.string.awardlist) + "?type=" + UserManage.getInstance().getUserID(), map, new OkhttpUtil.BeanCallback() {
            @Override
            public void onSuccess(String data) {

            }

            @Override
            public void onFailure(int code, String errorMsg) {

            }
        });
    }







    public interface LuckDrawCall{

        void luckDrawBack(List<LuckDrawGoodsBean> luckDrawGoodsBean);

    }

}
