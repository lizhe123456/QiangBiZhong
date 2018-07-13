package com.whmnrc.qiangbizhong.presenter.home;

import android.content.Context;

import com.alibaba.fastjson.JSON;
import com.blankj.utilcode.util.ToastUtils;
import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.model.bean.HomeResult;
import com.whmnrc.qiangbizhong.util.OkhttpUtil;
import java.util.HashMap;
import java.util.Map;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/12.
 */

public class HomePresenter {

    private Context mContext;
    private HomePageCall homePageCall;

    public HomePresenter(Context mContext, HomePageCall homePageCall) {
        this.mContext = mContext;
        this.homePageCall = homePageCall;
    }

    public void getHomepage(){
        Map<String,String> map = new HashMap<>();
        OkhttpUtil.get(mContext.getString(R.string.server_address)+mContext.getString(R.string.homeIndex),map, new OkhttpUtil.BeanCallback() {

            @Override
            public void onSuccess(String data) {
                if (homePageCall != null){
                    homePageCall.homePage(JSON.parseObject(data,HomeResult.class));
                }
            }

            @Override
            public void onFailure(int code, String errorMsg) {

            }
        });
    }

    public interface HomePageCall{

        void homePage(HomeResult homeResult);

    }
}
