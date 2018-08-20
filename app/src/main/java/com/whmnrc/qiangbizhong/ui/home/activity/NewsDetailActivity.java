package com.whmnrc.qiangbizhong.ui.home.activity;

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
 * Created by lizhe on 2018/8/14.
 */

public class NewsDetailActivity extends BaseActivity {


    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.wv_view)
    WebView wvView;

    public static void start(Context context,String newsId) {
        Intent starter = new Intent(context, NewsDetailActivity.class);
        starter.putExtra("newsId", newsId);
        context.startActivity(starter);
    }

    @Override
    protected int setLayout() {
        return R.layout.activity_news_detail;
    }

    @Override
    protected void setData() {
        ivBack.setVisibility(View.VISIBLE);
        tvTitle.setText("消息详情");
//        String url = "http://127.0.0.1:8011/MessageNotice/Index?noticeId=" + getIntent().getStringExtra("newsId");
        String url = "http://qbz.aimeilian.com.cn/MessageNotice/Index?noticeId=" + getIntent().getStringExtra("newsId");

        wvView.getSettings().setJavaScriptEnabled(true);
        //支持屏幕缩放
        wvView.getSettings().setBuiltInZoomControls(true);
        wvView.getSettings().setDisplayZoomControls(false);
        // 设置可以支持缩放
        wvView.getSettings().setSupportZoom(true);
        wvView.getSettings().setUseWideViewPort(true);
        wvView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        wvView.getSettings().setLoadWithOverviewMode(true);
        wvView.loadUrl(url);

    }

    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        this.finish();
    }
}
