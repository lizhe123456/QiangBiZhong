package com.whmnrc.qiangbizhong.pay.wechat.share;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.blankj.utilcode.util.LogUtils;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.whmnrc.qiangbizhong.app.Constants;
import com.whmnrc.qiangbizhong.base.BaseActivity;
import com.whmnrc.qiangbizhong.model.bean.WeiXin;

import org.greenrobot.eventbus.EventBus;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/8/20.
 */

public class WXEntryActivity extends AppCompatActivity implements IWXAPIEventHandler {

    private IWXAPI wxAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        wxAPI = WXAPIFactory.createWXAPI(this, Constants.WX_APP_ID,true);
        wxAPI.registerApp(Constants.WX_APP_ID);
        wxAPI.handleIntent(getIntent(), this);
    }

    @Override
    protected void onNewIntent(Intent intent){
        super.onNewIntent(intent);
        wxAPI.handleIntent(getIntent(),this);
    }

    @Override
    public void onReq(BaseReq arg0) {
        Log.i("ansen","WXEntryActivity onReq:"+arg0);
    }

    @Override
    public void onResp(BaseResp resp){
        if(resp.getType()== ConstantsAPI.COMMAND_SENDMESSAGE_TO_WX){//分享
//            WeiXin weiXin=new WeiXin(2,resp.errCode,"",authResp.openId);
//            EventBus.getDefault().post(weiXin);
        }else if(resp.getType()==ConstantsAPI.COMMAND_SENDAUTH){//登陆
            SendAuth.Resp authResp = (SendAuth.Resp) resp;
            WeiXin weiXin=new WeiXin(1,resp.errCode,authResp.code,authResp.openId);
            EventBus.getDefault().post(weiXin);
        }
        finish();
    }
}
