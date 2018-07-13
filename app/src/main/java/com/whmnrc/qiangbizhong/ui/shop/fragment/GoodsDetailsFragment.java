package com.whmnrc.qiangbizhong.ui.shop.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/11.
 */

public class GoodsDetailsFragment extends BaseFragment {


    @BindView(R.id.wv_view)
    WebView wvView;

    public static GoodsDetailsFragment newInstance(String html) {
        Bundle args = new Bundle();
        args.putString("html", html);
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
        String html = getArguments().getString("html");
        //支持App内部javascript交互
        wvView.getSettings().setJavaScriptEnabled(true);
        //自适应屏幕
        wvView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        wvView.getSettings().setLoadWithOverviewMode(false);
        //设置可以支持缩放
        wvView.getSettings().setSupportZoom(false);
        //扩大比例的缩放
        wvView.getSettings().setUseWideViewPort(false);
        //设置是否出现缩放工具
        wvView.getSettings().setBuiltInZoomControls(false);
//        wvView.loadDataWithBaseURL(null,html,"text/html", "utf-8",null);
        wvView.loadData(html,"text/html", "utf-8");
    }

}
