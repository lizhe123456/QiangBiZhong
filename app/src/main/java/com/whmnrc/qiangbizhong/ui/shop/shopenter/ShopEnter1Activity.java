package com.whmnrc.qiangbizhong.ui.shop.shopenter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseActivity;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/8/6.
 * 入驻1
 */

public class ShopEnter1Activity extends BaseActivity {


    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.wv_content)
    WebView wvContent;

    public static void start(Context context) {
        Intent starter = new Intent(context, ShopEnter1Activity.class);
        context.startActivity(starter);
    }

    @Override
    protected int setLayout() {
        return R.layout.activity_shop_enter1;
    }

    @Override
    protected void setData() {
        tvTitle.setText("我要入驻");
        ivBack.setVisibility(View.VISIBLE);
        wvContent.getSettings().setJavaScriptEnabled(true);
        //支持屏幕缩放
        wvContent.getSettings().setBuiltInZoomControls(true);
        wvContent.getSettings().setDisplayZoomControls(false);
        // 设置可以支持缩放
        wvContent.getSettings().setSupportZoom(true);
        wvContent.getSettings().setUseWideViewPort(true);
        wvContent.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        wvContent.getSettings().setLoadWithOverviewMode(true);
//        wvContent.loadUrl("http://192.168.1.157:8011/Protocol/AdmissionInstructions");
//        wvContent.loadUrl("http://192.168.1.157:8011/Protocol/AdmissionInstructions");
        wvContent.loadUrl(getResources().getString(R.string.server_address)+"/Protocol/AdmissionInstructions");
    }


    @OnClick({R.id.iv_back,R.id.tv_confirm})
    public void onViewClicked(View view) {
        switch (view.getId()){
            case R.id.iv_back:
                this.finish();
                break;
            case R.id.tv_confirm:
                ShopEnter2Activity.start(this);
                break;
        }
    }
}
