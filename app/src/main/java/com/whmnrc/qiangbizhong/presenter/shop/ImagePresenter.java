package com.whmnrc.qiangbizhong.presenter.shop;

import android.content.Context;

import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseCall;
import com.whmnrc.qiangbizhong.util.OkhttpUtil;

import java.util.List;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/8/2.
 */

public class ImagePresenter {

    private Context context;

    public ImagePresenter(Context context) {
        this.context = context;
    }

    //上传图片文件流
    public void uploadfile(List<String> list,ImageCall imageCall){
        OkhttpUtil.uploadImages(context.getString(R.string.server_address) + context.getString(R.string.uploadfile), list, new OkhttpUtil.ImageCallback() {
            @Override
            public void onSuccess(List<String> data) {
                if (imageCall != null){
                    imageCall.img(data);
                }
            }

            @Override
            public void onFailure(int code, String errorMsg) {
                if (imageCall != null){
                    imageCall.error();
                }
            }
        });
    }


    public interface ImageCall extends BaseCall{
        void img(List<String> list);
    }


}
