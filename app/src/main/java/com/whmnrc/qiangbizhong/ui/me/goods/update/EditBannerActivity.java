package com.whmnrc.qiangbizhong.ui.me.goods.update;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.amap.api.services.core.SearchUtils;
import com.blankj.utilcode.util.ScreenUtils;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.entity.LocalMedia;
import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseActivity;
import com.whmnrc.qiangbizhong.base.adapter.BaseAdapter;
import com.whmnrc.qiangbizhong.base.adapter.BaseViewHolder;
import com.whmnrc.qiangbizhong.model.bean.EditBannerBean;
import com.whmnrc.qiangbizhong.model.parameter.BannerParam;
import com.whmnrc.qiangbizhong.presenter.shop.GoodsPresenter;
import com.whmnrc.qiangbizhong.presenter.shop.ImagePresenter;
import com.whmnrc.qiangbizhong.util.ImageUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/8/7.
 * 编辑轮播图
 */

public class EditBannerActivity extends BaseActivity implements GoodsPresenter.GoodsBannerCall,ImagePresenter.ImageCall,GoodsPresenter.AddGoodsBannerCall{


    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.rv_banner_list)
    RecyclerView rvBannerList;

    private ImageAdapter imageAdapter;

    private GoodsPresenter goodsPresenter;
    private List<String> selectList1;
    private ImagePresenter imagePresenter;
    private int page;
    private int oldPage;
    private String goodsId;

    public static void start(Context context,String goodsId) {
        Intent starter = new Intent(context, EditBannerActivity.class);
        starter.putExtra("goodsId",goodsId);
        context.startActivity(starter);
    }

    @Override
    protected int setLayout() {
        return R.layout.activity_edit_banner;
    }

    @Override
    protected void setData() {
        tvTitle.setText("编辑商品轮播图");
        ivBack.setVisibility(View.VISIBLE);
        goodsPresenter = new GoodsPresenter(this);
        imagePresenter = new ImagePresenter(this);
        rvBannerList.setLayoutManager(new LinearLayoutManager(this));
        imageAdapter = new ImageAdapter(this);
        rvBannerList.setAdapter(imageAdapter);
        showLoading("加载中..");
        goodsId = getIntent().getStringExtra("goodsId");
        goodsPresenter.getgoodsbanner(goodsId,this);

        imageAdapter.setOnItemClickListener(new BaseAdapter.OnItemClickListener() {
            @Override
            public void onClick(View view, Object item, int position) {
                ImageUtil.img1GoodsBanner(EditBannerActivity.this);
            }
        });

    }


    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        this.finish();
    }

    @Override
    public void error() {

    }

    @Override
    public void getgoodsbanner(List<EditBannerBean> editBannerBeans) {
        List<String> list = new ArrayList<>();
        for (EditBannerBean editBannerBean :editBannerBeans) {
            list.add(editBannerBean.getImg_Path());
        }
        imageAdapter.addFirstDataSet(list);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case PictureConfig.CHOOSE_REQUEST:
                    List<LocalMedia> selectList = PictureSelector.obtainMultipleResult(data);
                    selectList1 = new ArrayList<>();
                    for (LocalMedia l: selectList) {
                        selectList1.add(l.getCompressPath());
                    }
                    showLoading("上传中..");
                    imagePresenter.uploadfilepublic(selectList1,this);
                    break;
            }
        }
    }

    @Override
    public void img(List<String> list) {
        List<BannerParam> bannerParamList = new ArrayList<>();
        for (int i = 0; i < selectList1.size(); i++) {
            bannerParamList.add(new BannerParam(goodsId,list.get(i),i));
        }
        goodsPresenter.addgoodsbanner(bannerParamList,this);
    }

    @Override
    public void addGoodsBanner() {
        imageAdapter.addFirstDataSet(selectList1);
    }


    public class ImageAdapter extends BaseAdapter<String>{

        int width;

        ImageAdapter(Context context) {
            super(context);
            width = ScreenUtils.getScreenWidth();
        }


        @Override
        protected void bindDataToItemView(BaseViewHolder holder, String item, int position) {
            if (!TextUtils.isEmpty(item)) {
                holder.setGlieuImage(R.id.iv_img, item);
            }


        }

        @Override
        protected int getItemViewLayoutId(int position, String item) {
            return R.layout.item_image_banner;
        }
    }

}
