package com.whmnrc.qiangbizhong.ui.shop.shopenter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v4.widget.NestedScrollView;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.alibaba.fastjson.JSON;
import com.blankj.utilcode.util.EncodeUtils;
import com.blankj.utilcode.util.ImageUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.entity.LocalMedia;
import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseActivity;
import com.whmnrc.qiangbizhong.model.bean.DataSave;
import com.whmnrc.qiangbizhong.presenter.shop.ImagePresenter;
import com.whmnrc.qiangbizhong.ui.shop.shopenter.location.SelectAddressActivity;
import com.whmnrc.qiangbizhong.util.GlideuUtil;
import com.whmnrc.qiangbizhong.util.ImageUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/8/6.
 */

public class ShopEnter3Activity extends BaseActivity implements ImagePresenter.ImageCall{


    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.iv_bz2)
    ImageView ivBz2;
    @BindView(R.id.tv_bz2)
    TextView tvBz2;
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
    @BindView(R.id.tv_city_1)
    TextView tvCity1;
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
    @BindView(R.id.tv_confirm)
    TextView tvConfirm;

    private double latitude;
    private double longitude;

    private ShopEnterP shopEnterP = new ShopEnterP();
    private ImagePresenter imagePresenter;

    private int imgType;

    public static void start(Context context) {
        Intent starter = new Intent(context, ShopEnter3Activity.class);
        context.startActivity(starter);
    }

    @Override
    protected int setLayout() {
        return R.layout.activity_shop_enter_3;
    }

    @Override
    protected void setData() {
        tvTitle.setText("我要入驻");
        ivBack.setVisibility(View.VISIBLE);
        imagePresenter = new ImagePresenter(this);
    }


    @OnClick({R.id.iv_back, R.id.iv_camera1,R.id.iv_img1, R.id.iv_img2,R.id.iv_img3,R.id.iv_camera2, R.id.iv_camera3, R.id.tv_confirm,R.id.tv_city_1})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                this.finish();
                break;
            case R.id.iv_img1:
                imgType = 1;
                ImageUtil.img1(this);
                break;
            case R.id.iv_img2:
                imgType = 2;
                ImageUtil.img1(this);
                break;
            case R.id.iv_img3:
                imgType = 3;
                ImageUtil.img1(this);
                break;
            case R.id.iv_camera1:
                //上传身份证正面
                imgType = 1;
                ImageUtil.img1(this);
                break;
            case R.id.iv_camera2:
                //上传身份证反面
                imgType = 2;
                ImageUtil.img1(this);
                break;
            case R.id.iv_camera3:
                //企业营业执照
                imgType = 3;
                ImageUtil.img1(this);
                break;
            case R.id.tv_city_1:
                //跳转图片选择地址
                SelectAddressActivity.start(this);
                break;
            case R.id.tv_confirm:
                if (TextUtils.isEmpty(etPhone.getText().toString().trim())){
                    ToastUtils.showShort("请输入手机号");
                    return;
                }
                shopEnterP.setPhone(etPhone.getText().toString().trim());

                if (TextUtils.isEmpty(etWx.getText().toString().trim())){
                    ToastUtils.showShort("请输入微信号");
                    return;
                }
                shopEnterP.setWeChartNum(etWx.getText().toString().trim());

                if (TextUtils.isEmpty(etName.getText().toString().trim())){
                    ToastUtils.showShort("请输入公司法人姓名");
                    return;
                }
                shopEnterP.setLegalPerson(etName.getText().toString().trim());

                if (TextUtils.isEmpty(etIdCrad.getText().toString().trim())){
                    ToastUtils.showShort("请输入法人身份证号码");
                    return;
                }
                shopEnterP.setIdentityCard(etIdCrad.getText().toString().trim());

                if (TextUtils.isEmpty(etShopName.getText().toString().trim())){
                    ToastUtils.showShort("请输入企业名称");
                    return;
                }
                shopEnterP.setCompanyName(etShopName.getText().toString().trim());

                if (TextUtils.isEmpty(tvCode.getText().toString().trim())){
                    ToastUtils.showShort("请填写企业的机构代码");
                    return;
                }
                shopEnterP.setOrganizationCode(tvCode.getText().toString().trim());

                if (TextUtils.isEmpty(shopEnterP.getLatitude()) & TextUtils.isEmpty(shopEnterP.getLongitude())){
                    ToastUtils.showShort("请选择商铺位置");
                    return;
                }
                if (TextUtils.isEmpty(etAddress.getText().toString())){
                    ToastUtils.showShort("请输入详细位置");
                    return;
                }
                shopEnterP.setAddress(etAddress.getText().toString().trim());

                if (TextUtils.isEmpty(shopEnterP.getIdentityCardImage1())){
                    ToastUtils.showShort("请上传法人身份证正面");
                    return;
                }
                if (TextUtils.isEmpty(shopEnterP.getIdentityCardImage2())){
                    ToastUtils.showShort("请上传法人身份证反面");
                    return;
                }

                if (TextUtils.isEmpty(shopEnterP.getLicenseImage())){
                    ToastUtils.showShort("请上传营业执照");
                    return;
                }
                //将value设置到静态类DataSave中
                //SecondActivity.value = value;//或则将value设置到SecondActivity的静态属性中
                ShopEnter4Activity.start(this, shopEnterP);

                break;
        }
    }

    private List<LocalMedia> selectList;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case PictureConfig.CHOOSE_REQUEST:
                    selectList = PictureSelector.obtainMultipleResult(data);
                    List<String> list = new ArrayList<>();
                    list.add(selectList.get(0).getCompressPath());
                    imagePresenter.uploadfilepublic(list,this);
                    break;
            }
        }else if (requestCode == 102){
            if (resultCode == 101){
                shopEnterP.setLatitude(data.getStringExtra("latitude"));
                shopEnterP.setLongitude(data.getStringExtra("longitude"));
                shopEnterP.setArea(data.getStringExtra("city"));
                tvCity1.setText(data.getStringExtra("city"));
            }
        }
    }

    @Override
    public void error() {

    }

    @Override
    public void img(List<String> list) {
        if (imgType == 1){
            shopEnterP.setIdentityCardImage1(list.get(0));
            GlideuUtil.loadImageView(this,selectList.get(0).getCompressPath(),ivImg1);
            ivCamera1.setVisibility(View.GONE);
        }else if (imgType == 2){
            shopEnterP.setIdentityCardImage2(list.get(0));
            GlideuUtil.loadImageView(this,selectList.get(0).getCompressPath(),ivImg2);
            ivCamera2.setVisibility(View.GONE);
        }else if (imgType == 3){
            shopEnterP.setLicenseImage(list.get(0));
            GlideuUtil.loadImageView(this,selectList.get(0).getCompressPath(),ivImg3);
            ivCamera3.setVisibility(View.GONE);
        }
    }
}
