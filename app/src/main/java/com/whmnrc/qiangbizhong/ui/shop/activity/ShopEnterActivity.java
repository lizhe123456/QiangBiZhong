package com.whmnrc.qiangbizhong.ui.shop.activity;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v4.widget.NestedScrollView;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.blankj.utilcode.util.SizeUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.permissions.RxPermissions;
import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseActivity;
import com.whmnrc.qiangbizhong.util.GlideuUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/27.
 */

public class ShopEnterActivity extends BaseActivity {

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.et_phone)
    EditText etPhone;
    @BindView(R.id.et_wx)
    EditText etWx;
    @BindView(R.id.et_name)
    EditText etName;
    @BindView(R.id.et_id_crad)
    EditText etIdCrad;
    @BindView(R.id.et_shop_name)
    EditText etShopName;
    @BindView(R.id.tv_code)
    EditText tvCode;
    @BindView(R.id.tv_city)
    TextView tvCity;
    @BindView(R.id.et_address)
    EditText etAddress;
    @BindView(R.id.iv_img1)
    ImageView ivImg1;
    @BindView(R.id.iv_camera1)
    ImageView ivCamera1;
    @BindView(R.id.iv_img2)
    ImageView ivImg2;
    @BindView(R.id.iv_camera2)
    ImageView ivCamera2;
    @BindView(R.id.iv_img3)
    ImageView ivImg3;
    @BindView(R.id.iv_camera3)
    ImageView ivCamera3;
    @BindView(R.id.ll_layout_1)
    NestedScrollView llLayout1;
    @BindView(R.id.tv_kaihu_hao)
    TextView tvKaihuHao;
    @BindView(R.id.tv_kaihu_name)
    TextView tvKaihuName;
    @BindView(R.id.tv_city_1)
    TextView tvCity1;
    @BindView(R.id.tv_band_hao)
    TextView tvBandHao;
    @BindView(R.id.tv_kaihu_city)
    TextView tvKaihuCity;
    @BindView(R.id.ll_layout_2)
    LinearLayout llLayout2;
    @BindView(R.id.tv_dian_ming)
    TextView tvDianMing;
    @BindView(R.id.tv_band_hao_2)
    TextView tvBandHao2;
    @BindView(R.id.ll_layout_3)
    LinearLayout llLayout3;
    @BindView(R.id.ll_input)
    LinearLayout llInput;
    @BindView(R.id.wv_content)
    WebView wvContent;
    @BindView(R.id.iv_select)
    ImageView ivSelect;
    @BindView(R.id.tv_confirm)
    TextView tvConfirm;
    @BindView(R.id.ll_select)
    LinearLayout llSelect;
    @BindView(R.id.iv_bz1)
    ImageView ivBz1;
    @BindView(R.id.iv_bz2)
    ImageView ivBz2;
    @BindView(R.id.iv_bz3)
    ImageView ivBz3;
    @BindView(R.id.iv_bz4)
    ImageView ivBz4;
    @BindView(R.id.ll_bz)
    LinearLayout llBz;
    @BindView(R.id.tv_bz1)
    TextView tvBz1;
    @BindView(R.id.tv_bz2)
    TextView tvBz2;
    @BindView(R.id.tv_bz3)
    TextView tvBz3;
    @BindView(R.id.tv_bz4)
    TextView tvBz4;

    private Map<String, String> map = new HashMap<>();
    private int imgType;

    private int stepNumber;

    private boolean isSelect = false;

    public static void start(Context context) {
        Intent starter = new Intent(context, ShopEnterActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected int setLayout() {
        return R.layout.activity_shop_enter;
    }

    @Override
    protected void setData() {
        tvTitle.setText("我要入驻");
        ivBack.setVisibility(View.VISIBLE);
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
        wvContent.loadUrl("http://192.168.1.157:8011/Protocol/Admission");

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

    @OnClick({R.id.iv_back, R.id.iv_select, R.id.tv_confirm, R.id.iv_camera1, R.id.iv_camera2, R.id.iv_camera3})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                this.finish();
                break;
            case R.id.iv_select:
                if (isSelect){
                    isSelect = false;
                    ivSelect.setImageResource(R.drawable.ic_selece_no);
                    tvConfirm.setBackgroundColor(getResources().getColor(R.color.divider_color));
                }else {
                    isSelect = true;
                    ivSelect.setImageResource(R.drawable.ic_select);
                    tvConfirm.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                }
                break;
            case R.id.tv_confirm:
                if (stepNumber == 0) {
                    stepNumber += 1;
                    tvConfirm.setText("已阅读完毕，并同意协议");
                    tvConfirm.setBackgroundColor(getResources().getColor(R.color.divider_color));
                    llSelect.setVisibility(View.VISIBLE);
                    llBz.setVisibility(View.VISIBLE);
                    ivBz1.setSelected(true);
                    tvBz1.setTextColor(getResources().getColor(R.color.tv_191));
                } else if (stepNumber == 1) {
                    if (isSelect) {
                        stepNumber += 1;
                        tvConfirm.setText("已阅读完毕，并同意协议");
                        llSelect.setVisibility(View.VISIBLE);
                        ivBz2.setSelected(true);
                        tvBz2.setTextColor(getResources().getColor(R.color.tv_191));
                    } else {
                        ToastUtils.showShort("请同意本协议");
                    }
                } else if (stepNumber == 2) {
                    stepNumber += 1;
                    tvConfirm.setText("下一步");
                    llLayout1.setVisibility(View.VISIBLE);

                } else if (stepNumber == 3) {
                    stepNumber += 1;
                    llLayout1.setVisibility(View.GONE);
                } else if (stepNumber == 4) {
                    stepNumber += 1;
                    llLayout1.setVisibility(View.GONE);
                }
                break;
            case R.id.iv_camera1:
                imgType = 0;
                openCamera();
            case R.id.iv_camera2:
                imgType = 1;
                openCamera();
            case R.id.iv_camera3:
                imgType = 2;
                openCamera();
                break;
        }
    }

    private void openCamera() {
        RxPermissions rxPermissions = new RxPermissions(this);
        rxPermissions
                .request(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .subscribe(granted -> {
                    if (granted) {
                        PictureSelector.create(this)
                                .openGallery(PictureMimeType.ofImage())
                                .maxSelectNum(1)
                                .imageSpanCount(4)
                                .withAspectRatio(1, 1)
                                .enableCrop(true)// 是否裁剪 true or false
                                .circleDimmedLayer(false)
                                .showCropFrame(true)
                                .cropWH(SizeUtils.dp2px(90), SizeUtils.dp2px(90))
                                .showCropGrid(false)
                                .compress(true)
                                .cropCompressQuality(50)
                                .previewImage(true)
                                .forResult(PictureConfig.CHOOSE_REQUEST);
                    } else {
                        ToastUtils.showShort("未开启读写权限，请开启读写");
                    }
                });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case PictureConfig.CHOOSE_REQUEST:
                    List<LocalMedia> selectList = PictureSelector.obtainMultipleResult(data);
                    if (imgType == 0) {
                        //企业法人代表身份证正面
                        ivCamera1.setVisibility(View.GONE);
                        GlideuUtil.loadImageView(this, selectList.get(0).getCompressPath(), ivImg1);
                    } else if (imgType == 1) {
                        //企业法人代表身份证反面
                        ivCamera2.setVisibility(View.GONE);
                        GlideuUtil.loadImageView(this, selectList.get(0).getCompressPath(), ivImg2);
                    } else if (imgType == 2) {
                        //企业营业执照
                        ivCamera3.setVisibility(View.GONE);
                        GlideuUtil.loadImageView(this, selectList.get(0).getCompressPath(), ivImg3);
                    }
                    break;
            }
        }
    }

}
