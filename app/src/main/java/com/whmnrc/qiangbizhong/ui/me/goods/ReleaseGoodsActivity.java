package com.whmnrc.qiangbizhong.ui.me.goods;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.blankj.utilcode.util.EncodeUtils;
import com.blankj.utilcode.util.EncryptUtils;
import com.blankj.utilcode.util.ImageUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.entity.LocalMedia;
import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseActivity;
import com.whmnrc.qiangbizhong.model.bean.ClassifyBean;
import com.whmnrc.qiangbizhong.model.parameter.GoodsParam;
import com.whmnrc.qiangbizhong.presenter.shop.ClassifyPresenter;
import com.whmnrc.qiangbizhong.presenter.shop.GoodsPresenter;
import com.whmnrc.qiangbizhong.presenter.shop.ImagePresenter;
import com.whmnrc.qiangbizhong.ui.me.activity.GoodsManageActivity;
import com.whmnrc.qiangbizhong.util.GlideuUtil;
import com.whmnrc.qiangbizhong.util.GsonUtil;
import com.whmnrc.qiangbizhong.util.ImageUtil;
import com.whmnrc.qiangbizhong.util.ToastUtil;
import com.whmnrc.qiangbizhong.util.UserManage;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.qqtheme.framework.picker.OptionPicker;
import cn.qqtheme.framework.picker.WheelPicker;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/23.
 */

public class ReleaseGoodsActivity extends BaseActivity implements ImagePresenter.ImageCall,
        ClassifyPresenter.ClassifyListCall,GoodsPresenter.ReleaseGoodsCall{


    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.et_goods_name)
    EditText etGoodsName;
    @BindView(R.id.et_desc)
    EditText etDesc;
    @BindView(R.id.iv_goods_img)
    ImageView ivGoodsImg;
    @BindView(R.id.ic_classify)
    TextView icClassify;
    @BindView(R.id.rl_select_classify)
    RelativeLayout rlSelectClassify;
    @BindView(R.id.et_brand)
    EditText etBrand;
    @BindView(R.id.et_min_price)
    EditText etMinPrice;
    @BindView(R.id.et_max_price)
    EditText etMaxPrice;
    @BindView(R.id.et_sort)
    EditText etSort;
    @BindView(R.id.tv_release)
    TextView tvRelease;
    @BindView(R.id.et_min_num)
    EditText etMinNum;

    private ImagePresenter imagePresenter;
    private ClassifyPresenter classifyPresenter;
    private GoodsPresenter goodsPresenter;

    private GoodsParam goodsParam;
    private List<LocalMedia> selectList;
    private List<ClassifyBean> classifyBeans;
    private List<String> list;
    private int type;
    public static void start(Context context) {
        Intent starter = new Intent(context, ReleaseGoodsActivity.class);
        context.startActivity(starter);
    }

    public static void start(Context context,GoodsParam goodsParam,int type) {
        Intent starter = new Intent(context, ReleaseGoodsActivity.class);
        starter.putExtra("goodsParam", GsonUtil.createGsonString(goodsParam));
        starter.putExtra("type", type);
        context.startActivity(starter);
    }

    @Override
    protected int setLayout() {
        return R.layout.activity_release_goods;
    }

    @Override
    protected void setData() {
        ivBack.setVisibility(View.VISIBLE);
        tvTitle.setText("商品发布");
        String data = getIntent().getStringExtra("goodsParam");
        type = getIntent().getIntExtra("type",0);
        if (TextUtils.isEmpty(data)){
            goodsParam = new GoodsParam();
        }else {
            goodsParam = GsonUtil.changeGsonToBean(data,GoodsParam.class);
            if (goodsParam != null){
                etGoodsName.setText(goodsParam.getGoods_Name());
                etGoodsName.setSelection(goodsParam.getGoods_Name().length());
                etDesc.setText(goodsParam.getGoods_Describe());
                etBrand.setText(goodsParam.getGoods_BrandName());
                etMinPrice.setText(goodsParam.getGoods_PriceMin());
                etMaxPrice.setText(goodsParam.getGoods_PriceMax());
                etSort.setText(goodsParam.getGoods_Sort());
                etMinNum.setText(goodsParam.getGoods_LimitCount());
                GlideuUtil.loadImageView(this,goodsParam.getGoods_ImaPath(),ivGoodsImg);
            }
        }

        imagePresenter = new ImagePresenter(this);
        classifyPresenter = new ClassifyPresenter(this);
        classifyPresenter.getClassifyList(0,this);
        goodsPresenter = new GoodsPresenter(this);
        goodsParam.setStoreId(UserManage.getInstance().getLoginBean().getStoreInfo().getId());
    }


    @OnClick({R.id.iv_back, R.id.tv_release,R.id.rl_select_classify,R.id.iv_goods_img})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                this.finish();
                break;
            case R.id.tv_release:

                if (TextUtils.isEmpty(etGoodsName.getText().toString())){
                    ToastUtils.showShort("请输入商品名称");
                    return;
                }
                goodsParam.setGoods_Name(etGoodsName.getText().toString());

                if (TextUtils.isEmpty(etDesc.getText().toString())){
                    ToastUtils.showShort("请输入商品介绍");
                    return;
                }
                goodsParam.setGoods_Describe(etDesc.getText().toString());

                if (TextUtils.isEmpty(goodsParam.getGoods_ImaPath())){
                    ToastUtils.showShort("请上传商品主图");
                    return;
                }

                if (TextUtils.isEmpty(icClassify.getText().toString())){
                    ToastUtils.showShort("请选择分类");
                    return;
                }

                if (TextUtils.isEmpty(etBrand.getText().toString())){
                    ToastUtils.showShort("请输入商品品牌");
                    return;
                }
                goodsParam.setGoods_BrandName(etBrand.getText().toString());

                if (TextUtils.isEmpty(etMinPrice.getText().toString())){
                    ToastUtils.showShort("请输入最小价格");
                    return;
                }


                if (TextUtils.isEmpty(etMaxPrice.getText().toString())){
                    ToastUtils.showShort("请输入最大价格");
                    return;
                }


                if (Double.valueOf(etMinPrice.getText().toString().trim()) > Double.valueOf(etMaxPrice.getText().toString())){
                    ToastUtils.showShort("请输入最小价格不可超过最大价格");
                    return;
                }
                goodsParam.setGoods_PriceMin(etMinPrice.getText().toString());
                goodsParam.setGoods_PriceMax(etMaxPrice.getText().toString());

                if (TextUtils.isEmpty(etSort.getText().toString())){
                    ToastUtils.showShort("请输入排序");
                    return;
                }

                goodsParam.setGoods_Sort(etSort.getText().toString());
                if (TextUtils.isEmpty(etMinNum.getText().toString())){
                    ToastUtils.showShort("请输入最小购买");
                    return;
                }
                goodsParam.setGoods_LimitCount(etMinNum.getText().toString());
                showLoading("提交中..");
                goodsPresenter.releaseGoods(goodsParam,type,this);
                break;
            case R.id.rl_select_classify:
                if (list != null) {
                    showVideoPicker(list);
                }
                break;
            case R.id.iv_goods_img:
                ImageUtil.img1Goods(ReleaseGoodsActivity.this);
                break;

        }
    }

    private void showVideoPicker(List<String> list) {
        OptionPicker picker = new OptionPicker(this,list);

        picker.setCycleDisable(false);
        picker.setDividerVisible(false);
        picker.setOffset(2);//偏移量
        picker.setOnOptionPickListener(new OptionPicker.OnOptionPickListener() {
            @Override
            public void onOptionPicked(int index, String item) {
                icClassify.setText(item);
                goodsParam.setGoods_Type(classifyBeans.get(index).getId());
            }
        });
        picker.show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case PictureConfig.CHOOSE_REQUEST:
                    selectList = PictureSelector.obtainMultipleResult(data);
                    List<String> list = new ArrayList<>();
                    list.add(selectList.get(0).getCompressPath());
                    showLoading("上传中..");
                    imagePresenter.uploadfilepublic(list,this);
                    break;
            }
        }
    }


    @Override
    public void error() {

    }

    @Override
    public void img(List<String> list) {
        goodsParam.setGoods_ImaPath(list.get(0));
        GlideuUtil.loadImageView(this,selectList.get(0).getCompressPath(),ivGoodsImg);
    }

    @Override
    public void classifyListBack(@NonNull List<ClassifyBean> classifyBeans) {
        this.classifyBeans = classifyBeans;
        list = new ArrayList<>();
        for (ClassifyBean classifyBean : classifyBeans) {
            list.add(classifyBean.getTypeName());
        }
        if (goodsParam != null){
            if (!TextUtils.isEmpty(goodsParam.getGoods_Type())){
                for (ClassifyBean classifyBean : classifyBeans) {
                    if (classifyBean.getId().equals(goodsParam.getGoods_Type())){
                        icClassify.setText(classifyBean.getTypeName());
                    }
                }

            }
        }
    }

    @Override
    public void releaseS() {
        GoodsManageActivity.start(this,2);
        this.finish();
    }
}
