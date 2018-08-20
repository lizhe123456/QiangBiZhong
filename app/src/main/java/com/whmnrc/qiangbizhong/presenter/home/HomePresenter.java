package com.whmnrc.qiangbizhong.presenter.home;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;

import com.alibaba.fastjson.JSON;
import com.blankj.utilcode.util.AppUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseCall;
import com.whmnrc.qiangbizhong.model.bean.HomeResult;
import com.whmnrc.qiangbizhong.ui.home.HomeFragment;
import com.whmnrc.qiangbizhong.util.OkhttpUtil;
import com.whmnrc.qiangbizhong.util.UserManage;
import com.whmnrc.qiangbizhong.widget.AlertDialog;

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

    public void getHomepage() {
        Map<String, String> map = new HashMap<>();
        OkhttpUtil.get(mContext.getString(R.string.server_address) + mContext.getString(R.string.homeIndex), map, new OkhttpUtil.BeanCallback() {

            @Override
            public void onSuccess(String data) {
                if (UserManage.getInstance().getLoginBean() != null) {
                    getnoticecount();
                }
                if (homePageCall != null) {
                    homePageCall.homePage(JSON.parseObject(data, HomeResult.class));
                }
            }

            @Override
            public void onFailure(int code, String errorMsg) {
                if (homePageCall != null) {
                    homePageCall.error();
                }
            }
        });
    }

    public void getnoticecount() {
        OkhttpUtil.get(mContext.getString(R.string.server_address) + mContext.getString(R.string.getnoticecount)
                + "?userId=" + UserManage.getInstance().getUserID(), new HashMap<>(), new OkhttpUtil.BeanCallback() {
            @Override
            public void onSuccess(String data) {
                if (homePageCall != null) {
                    if (!TextUtils.isEmpty(data)) {
                        homePageCall.noticeCount(data);
                    } else {
                        homePageCall.noticeCount("0");
                    }
                }
            }

            @Override
            public void onFailure(int code, String errorMsg) {
                if (homePageCall != null) {
                    homePageCall.error();
                }
            }
        });
    }


    public void getappversion() {
        OkhttpUtil.get(mContext.getString(R.string.server_address) + mContext.getString(R.string.getappversion)
                + "?type=1", new HashMap<>(), new OkhttpUtil.BeanCallback() {
            @Override
            public void onSuccess(String data) {
                if (!TextUtils.isEmpty(data)) {
                    if (!AppUtils.getAppVersionName().equals(data)) {
                        downloadapp();
                    }
                }

            }

            @Override
            public void onFailure(int code, String errorMsg) {

            }
        });
    }


    public void downloadapp() {
        OkhttpUtil.get(mContext.getString(R.string.server_address) + mContext.getString(R.string.downloadapp)
                + "?type=1", new HashMap<>(), new OkhttpUtil.BeanCallback() {
            @Override
            public void onSuccess(String data) {
                if (!TextUtils.isEmpty(data)) {
                    new AlertDialog(mContext).builder()
                            .setTitle("提示")
                            .setMsg("检测到新版本")
                            .setCancelable(false)
                            .setPositiveButton("去更新", new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Intent intent = new Intent();
                                    intent.setAction("android.intent.action.VIEW");
                                    Uri content_url = Uri.parse(data);
                                    intent.setData(content_url);
                                    mContext.startActivity(intent);
                                    AppUtils.exitApp();
                                }
                            }).show();
                }

            }

            @Override
            public void onFailure(int code, String errorMsg) {

            }
        });
    }


    public interface HomePageCall extends BaseCall {

        void homePage(HomeResult homeResult);

        void noticeCount(String count);


    }


}
