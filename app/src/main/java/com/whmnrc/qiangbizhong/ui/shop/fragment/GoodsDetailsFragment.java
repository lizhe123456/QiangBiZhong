package com.whmnrc.qiangbizhong.ui.shop.fragment;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseFragment;

import butterknife.BindView;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/11.
 */

public class GoodsDetailsFragment extends BaseFragment {


    @BindView(R.id.wv_view)
    WebView wvView;

    public static GoodsDetailsFragment newInstance(String html) {
        Bundle args = new Bundle();
        args.putString("url", html);
        GoodsDetailsFragment fragment = new GoodsDetailsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_goods_details;
    }

    @Override
    protected void initData() {

        String url = getArguments().getString("url");
        //支持javascript
        wvView.getSettings().setJavaScriptEnabled(true);
        // 设置可以支持缩放
        wvView.getSettings().setSupportZoom(true);
        // 设置出现缩放工具
        wvView.getSettings().setBuiltInZoomControls(true);
        //扩大比例的缩放
        wvView.getSettings().setUseWideViewPort(true);
        //自适应屏幕
        wvView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        wvView.getSettings().setLoadWithOverviewMode(true);

        wvView.loadUrl(url);

    }

}
