package com.whmnrc.qiangbizhong.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/26.
 */

public class UserXieYiActivity extends BaseActivity {

    @BindView(R.id.wv_content)
    WebView wvContent;
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;

    public static void start(Context context) {
        Intent starter = new Intent(context, UserXieYiActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected int setLayout() {
        return R.layout.activity_xieyi;
    }

    @Override
    protected void setData() {
        ivBack.setVisibility(View.VISIBLE);
        tvTitle.setText("用户协议");
        //支持javascript
        wvContent.getSettings().setJavaScriptEnabled(true);
        // 设置可以支持缩放
        wvContent.getSettings().setSupportZoom(true);
        // 设置出现缩放工具
        wvContent.getSettings().setBuiltInZoomControls(false);
        //扩大比例的缩放
        wvContent.getSettings().setUseWideViewPort(true);
        //自适应屏幕
        wvContent.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        wvContent.getSettings().setLoadWithOverviewMode(true);

        wvContent.loadUrl("http://testaml.whmnx.com/Protocol");
        wvContent.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                if (loadingDialog.isShowing()) {
                    loadingDialog.cancel();
                }
            }
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                showLoading("加载中..");
            }
        });
    }

    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        this.finish();
    }
}
