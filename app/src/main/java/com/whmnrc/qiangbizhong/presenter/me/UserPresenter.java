package com.whmnrc.qiangbizhong.presenter.me;

import android.content.Context;
import android.graphics.Bitmap;

import com.blankj.utilcode.util.EncodeUtils;
import com.blankj.utilcode.util.ImageUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.util.OkhttpUtil;
import com.whmnrc.qiangbizhong.util.ToastUtil;
import com.whmnrc.qiangbizhong.util.UserManage;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/12.
 */

public class UserPresenter {

    private Context context;

    public UserPresenter(Context context) {
        this.context = context;
    }

    //修改密码
    public void updatePass(String pwd,String newPwd){
        Map<String,String> map = new HashMap<>();
        map.put("UserId",UserManage.getInstance().getUserID());
        map.put("Pwd", pwd);
        map.put("NewPwd", newPwd);
        OkhttpUtil.post(context.getString(R.string.server_address) + context.getString(R.string.updatePwd), map, new OkhttpUtil.BeanCallback() {
            @Override
            public void onSuccess(String data) {

            }

            @Override
            public void onFailure(int code, String errorMsg) {

            }

        });
    }

    //修改头像
    public void updateHead(String path){
        Bitmap bitmap = ImageUtils.getBitmap(new File(path));
        String base64 = EncodeUtils.base64Encode2String(ImageUtils.bitmap2Bytes(bitmap, Bitmap.CompressFormat.JPEG));
        Map<String,String> map = new HashMap<>();
        map.put("UserId",UserManage.getInstance().getUserID());
        map.put("UserHeadImage", base64);
        OkhttpUtil.post(context.getString(R.string.server_address) + context.getString(R.string.updateHeadImage), map, new OkhttpUtil.BeanCallback() {
            @Override
            public void onSuccess(String data) {
                ToastUtils.showShort("上传成功");
            }

            @Override
            public void onFailure(int code, String errorMsg) {

            }

        });
    }

    //修改昵称
    public void updateNickName(String nickName){
        Map<String,String> map = new HashMap<>();
        map.put("UserId",UserManage.getInstance().getUserID());
        map.put("UserHeadImage", nickName);
        OkhttpUtil.post(context.getString(R.string.server_address) + context.getString(R.string.updateUserNick), map, new OkhttpUtil.BeanCallback() {
            @Override
            public void onSuccess(String data) {

            }

            @Override
            public void onFailure(int code, String errorMsg) {

            }

        });
    }



}
