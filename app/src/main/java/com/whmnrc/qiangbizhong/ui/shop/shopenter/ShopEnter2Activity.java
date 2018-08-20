package com.whmnrc.qiangbizhong.ui.shop.shopenter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.blankj.utilcode.util.ToastUtils;
import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseActivity;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/8/6.
 */

public class ShopEnter2Activity extends BaseActivity {


    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.ll_title)
    RelativeLayout llTitle;
    @BindView(R.id.iv_bz1)
    ImageView ivBz1;
    @BindView(R.id.tv_bz1)
    TextView tvBz1;
    @BindView(R.id.wv_content)
    WebView wvContent;
    @BindView(R.id.iv_select)
    ImageView ivSelect;
    @BindView(R.id.tv_confirm)
    TextView tvConfirm;

    private boolean isSelect;


    public static void start(Context context) {
        Intent starter = new Intent(context, ShopEnter2Activity.class);
        context.startActivity(starter);
    }

    @Override
    protected int setLayout() {
        return R.layout.activity_shop_enter2;
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
        wvContent.loadUrl("http://qbz.aimeilian.com.cn/Protocol/Admission");
    }


    @OnClick({R.id.iv_back,R.id.tv_confirm,R.id.iv_select})
    public void onViewClicked(View view) {
        switch (view.getId()){
            case R.id.tv_confirm:
                if (isSelect){
                    //同意
                    ShopEnter3Activity.start(this);
                }else {
                    //不同意
                    ToastUtils.showShort("请先阅读并同意入驻协议");
                }
                break;
            case R.id.iv_back:
                finish();
                break;
            case R.id.iv_select:
                if (isSelect){
                    isSelect = false;
                    ivSelect.setImageResource(R.drawable.ic_selece_no);
                }else {
                    isSelect = true;
                    ivSelect.setImageResource(R.drawable.ic_select);
                }
                break;

        }
    }
}
