package com.whmnrc.qiangbizhong.presenter.yimei;

import android.content.Context;

import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseCall;
import com.whmnrc.qiangbizhong.model.bean.YiMeiGoodsBean;
import com.whmnrc.qiangbizhong.model.bean.YiMeiSortBean;
import com.whmnrc.qiangbizhong.util.GsonUtil;
import com.whmnrc.qiangbizhong.util.OkhttpUtil;
import com.whmnrc.qiangbizhong.util.UserManage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/26.
 */

public class StorePresenter {

    private Context context;

    private int page;

    public StorePresenter(Context context) {
        this.context = context;
    }

    public void getmedicalstorelist(boolean isR, String sId, String type,double latitude, double longitude, MedicalStoreCall medicalStoreCall){
        Map<String, String> map = new HashMap<>();
        map.put("SortIndex", type);
        if (isR){
            page = 1;
        }
        map.put("PageIndex",page+"");
        map.put("PageCount","10");
        OkhttpUtil.post(context.getString(R.string.server_address) + context.getString(R.string.getmedicalstorelist)+ "?storeId="+ sId+"&userId="+ UserManage.getInstance().getUserID() + "&latitude=" + latitude + "&longitude=" + longitude, map, new OkhttpUtil.BeanCallback() {
            @Override
            public void onSuccess(String data) {
                YiMeiSortBean yiMeiSortBean = GsonUtil.changeGsonToBean(data,YiMeiSortBean.class);
                if (medicalStoreCall != null){
                    if (isR){
                        medicalStoreCall.medicalStoreBack(yiMeiSortBean);
                    }else {
                        medicalStoreCall.loadMore(yiMeiSortBean.getGoods());
                    }
                    page++;
                }
            }

            @Override
            public void onFailure(int code, String errorMsg) {
                if (medicalStoreCall != null){
                    medicalStoreCall.error();
                }
            }
        });

    }

    public interface MedicalStoreCall extends BaseCall{

        void medicalStoreBack(YiMeiSortBean yiMeiSortBean);

        void loadMore(List<YiMeiGoodsBean> goodsBeans);

    }
}
