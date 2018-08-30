package com.whmnrc.qiangbizhong.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.util.DisplayMetrics;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;
import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseActivity;
import butterknife.BindView;
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

    private String title;

    public static void start(Context context,String url,String title) {
        Intent starter = new Intent(context, UserXieYiActivity.class);
        starter.putExtra("url",url);
        starter.putExtra("title",title);
        context.startActivity(starter);
    }


    @Override
    protected int setLayout() {
        return R.layout.activity_xieyi;
    }

    @Override
    protected void setData() {
        String url = getIntent().getStringExtra("url");
        title = getIntent().getStringExtra("title");
        ivBack.setVisibility(View.VISIBLE);
        tvTitle.setText(title);
        //支持javascript
        wvContent.getSettings().setJavaScriptEnabled(true);
        //支持屏幕缩放
        wvContent.getSettings().setBuiltInZoomControls(true);
        wvContent.getSettings().setDisplayZoomControls(false);
        // 设置可以支持缩放
        wvContent.getSettings().setSupportZoom(true);
        wvContent.getSettings().setUseWideViewPort(true);
        wvContent.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        wvContent.getSettings().setLoadWithOverviewMode(true);

//        wvContent.loadUrl("http://testaml.whmnx.com/Protocol");
//        wvContent.loadUrl("http://192.168.1.157:8011/Protocol");
        wvContent.loadUrl(url);

        wvContent.setWebViewClient(new WebViewClient() {

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);//防止调用系统自带的浏览器打开网页
                return true;
            }


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
