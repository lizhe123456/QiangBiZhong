package com.whmnrc.qiangbizhong.ui.me.goods.update;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseActivity;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/8/7.
 * 编辑商品详情
 */

public class EditGoodsDetailsActivity extends BaseActivity {


    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.wv_content)
    WebView wvContent;
    @BindView(R.id.tv_menu)
    TextView tvMenu;

    public static void start(Context context,String goodsId) {
        Intent starter = new Intent(context, EditGoodsDetailsActivity.class);
        starter.putExtra("goodsId",goodsId);
        context.startActivity(starter);
    }

    @Override
    protected int setLayout() {
        return R.layout.activity_edit_goods_details;
    }

    @Override
    protected void setData() {
        ivBack.setVisibility(View.VISIBLE);
        tvTitle.setText("编辑商品详情");
        tvMenu.setVisibility(View.VISIBLE);
        tvMenu.setText("保存");
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
        wvContent.getSettings().setJavaScriptEnabled(true);
        wvContent.addJavascriptInterface(new EditGoodsDetailsActivity(),
                "android");
        String goodsId = getIntent().getStringExtra("goodsId");
        wvContent.loadUrl("http://192.168.1.157:8011/GoodsDetail/Edit?goodsId=" + goodsId);
    }

    /**
     * 与js交互时用到的方法，在js里直接调用的
     */
    @JavascriptInterface
    public void exit() {
        EventBus.getDefault().post(new Exit());
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void exit1(Exit exit){
        this.finish();
    }

    private class Exit{

    }


    @OnClick({R.id.iv_back,R.id.tv_menu})
    public void onViewClicked(View view) {
        switch (view.getId()){
            case R.id.tv_menu:
                //保存
                wvContent.loadUrl("javascript:SaveContext()");
                break;
            case R.id.iv_back:
                this.finish();
                break;
        }
    }

}
