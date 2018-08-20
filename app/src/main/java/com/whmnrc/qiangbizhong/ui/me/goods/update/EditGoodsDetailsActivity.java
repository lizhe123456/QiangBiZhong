package com.whmnrc.qiangbizhong.ui.me.goods.update;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseActivity;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.File;
import java.util.Calendar;
import java.util.Locale;

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

    public ValueCallback<Uri[]> mUploadMessageForAndroid5;
    public ValueCallback<Uri> mUploadMessage;
    public final static int FILE_CHOOSER_RESULT_CODE_FOR_ANDROID_5 = 2;
    private final static int FILE_CHOOSER_RESULT_CODE = 1;// 表单的结果回调
    private Uri imageUri;

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
        wvContent.loadUrl("http://qbz.aimeilian.com.cn/GoodsDetail/Edit?goodsId=" + goodsId);

       //H5加载链接监听
        wvContent.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return true;
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                showLoading("加载中..");
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                if (loadingDialog.isShowing()){
                    loadingDialog.cancel();
                }
            }
        });

        //H5界面加载进度监听
        wvContent.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {

                super.onProgressChanged(view, newProgress);
            }

            // For Android < 5.0
            public void openFileChooser(ValueCallback<Uri> uploadMsg, String acceptType, String capture) {
                openFileChooserImpl(uploadMsg);
            }

            // For Android => 5.0
            public boolean onShowFileChooser (WebView webView, ValueCallback<Uri[]> uploadMsg,
                                              WebChromeClient.FileChooserParams fileChooserParams) {
                onenFileChooseImpleForAndroid(uploadMsg);
                return true;
            }

        });

    }


    /**
     * android 5.0 以下开启图片选择（原生）
     *
     * 可以自己改图片选择框架。
     */
    private void openFileChooserImpl(ValueCallback<Uri> uploadMsg) {
        mUploadMessage = uploadMsg;
        Intent i = new Intent(Intent.ACTION_GET_CONTENT);
        i.addCategory(Intent.CATEGORY_OPENABLE);
        i.setType("image/*");
        startActivityForResult(Intent.createChooser(i, "File Chooser"), FILE_CHOOSER_RESULT_CODE);
    }

    /**
     * android 5.0(含) 以上开启图片选择（原生）
     *
     * 可以自己改图片选择框架。
     */
    private void onenFileChooseImpleForAndroid(ValueCallback<Uri[]> filePathCallback) {
        mUploadMessageForAndroid5 = filePathCallback;
//        Intent contentSelectionIntent = new Intent(Intent.ACTION_GET_CONTENT);
//        contentSelectionIntent.addCategory(Intent.CATEGORY_OPENABLE);
//        contentSelectionIntent.setType("image/*");
//
//        Intent chooserIntent = new Intent(Intent.ACTION_CHOOSER);
//        chooserIntent.putExtra(Intent.EXTRA_INTENT, contentSelectionIntent);
//        chooserIntent.putExtra(Intent.EXTRA_TITLE, "Image Chooser");
//
//        startActivityForResult(chooserIntent, FILE_CHOOSER_RESULT_CODE_FOR_ANDROID_5);
        openPhoto(this);
    }

    /**
     * 打开机册
     */
    public static void openPhoto(Activity activity) {
        Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media
                .EXTERNAL_CONTENT_URI);
//        intent.setType("image/*");
        intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
        activity.startActivityForResult(intent, FILE_CHOOSER_RESULT_CODE_FOR_ANDROID_5);
    }



    @Override
    public void onActivityResult(int requestCode, int resultCode,Intent intent) {
        Uri result = (intent == null || resultCode != Activity.RESULT_OK) ? null: intent.getData();
        switch (requestCode){
            case FILE_CHOOSER_RESULT_CODE:  //android 5.0以下 选择图片回调

                if (null == mUploadMessage)
                    return;
                mUploadMessage.onReceiveValue(result);
                mUploadMessage = null;

                break;

            case FILE_CHOOSER_RESULT_CODE_FOR_ANDROID_5:  //android 5.0(含) 以上 选择图片回调

                if (null == mUploadMessageForAndroid5)
                    return;
                if (result != null) {
                    mUploadMessageForAndroid5.onReceiveValue(new Uri[]{result});
                } else {
                    mUploadMessageForAndroid5.onReceiveValue(new Uri[]{});
                }
                mUploadMessageForAndroid5 = null;

                break;
        }
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
