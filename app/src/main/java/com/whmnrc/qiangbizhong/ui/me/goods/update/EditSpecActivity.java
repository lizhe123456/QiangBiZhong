package com.whmnrc.qiangbizhong.ui.me.goods.update;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseActivity;
import com.whmnrc.qiangbizhong.base.adapter.BaseAdapter;
import com.whmnrc.qiangbizhong.base.adapter.BaseViewHolder;
import com.whmnrc.qiangbizhong.model.bean.EditSpecBean;
import com.whmnrc.qiangbizhong.model.parameter.SpecParam;
import com.whmnrc.qiangbizhong.presenter.shop.SpecPresenter;
import com.whmnrc.qiangbizhong.widget.AlertDialog;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/8/7.
 * 编辑规格
 */

public class EditSpecActivity extends BaseActivity implements SpecPresenter.EditSpecCall,SpecPresenter.SpecStatuCall{


    @BindView(R.id.rv_list)
    RecyclerView rvList;
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_menu)
    TextView tvMenu;
    private SpecAdapter specAdapter;

    private SpecPresenter specPresenter;
    private String goodsId;

    public static void start(Context context, String goodsId) {
        Intent starter = new Intent(context, EditSpecActivity.class);
        starter.putExtra("goodsId", goodsId);
        context.startActivity(starter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (specPresenter != null){
            specPresenter.getEditSpecList(goodsId, this);
        }
    }

    @Override
    protected int setLayout() {
        return R.layout.activity_edit_spec;
    }

    @Override
    protected void setData() {
        ivBack.setVisibility(View.VISIBLE);
        tvTitle.setText("编辑商品规格");
        tvMenu.setVisibility(View.VISIBLE);
        tvMenu.setText("新增");
        goodsId = getIntent().getStringExtra("goodsId");
        rvList.setLayoutManager(new LinearLayoutManager(this));
        specAdapter = new SpecAdapter(this);
        rvList.setAdapter(specAdapter);
        specPresenter = new SpecPresenter(this);
        specPresenter.getEditSpecList(goodsId, this);
        specAdapter.setDeleteCall(new DeleteCall() {
            @Override
            public void delete(EditSpecBean.ItemsBean item) {
                showLoading("删除中");
                specPresenter.deleteSpec(item.getGoodsPrice_ID(),EditSpecActivity.this);
            }
        });
    }

    @Override
    public void error() {

    }

    @Override
    public void specBack(EditSpecBean editSpecBean) {
        specAdapter.setGoodsName(editSpecBean.getGoodsInfo().getGoods_Name(), editSpecBean.getGoodsInfo().getGoods_ImaPath());
        specAdapter.addFirstDataSet(editSpecBean.getItems());
    }


    @OnClick({R.id.iv_back, R.id.tv_menu})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_menu:
                //新增
                AddSpecActivity.start(this,goodsId);
                break;
            case R.id.iv_back:
                this.finish();
                break;
        }
    }

    @Override
    public void specBack() {
        specPresenter.getEditSpecList(goodsId, this);
    }


    public class SpecAdapter extends BaseAdapter<EditSpecBean.ItemsBean> {

        String goodsName = "";
        String img = "";

        private DeleteCall deleteCall;

        public void setDeleteCall(DeleteCall deleteCall) {
            this.deleteCall = deleteCall;
        }

        public SpecAdapter(Context context) {
            super(context);
        }

        public void setGoodsName(String goodsName, String img) {
            this.goodsName = goodsName;
            this.img = img;
        }

        @Override
        protected void bindDataToItemView(BaseViewHolder holder, EditSpecBean.ItemsBean item, int position) {
            holder.setText(R.id.tv_goods_name, goodsName)
                    .setText(R.id.tv_goods_spec, item.getGoodsPrice_SpecName() + " " + item.getGoodsPrice_AttrName())
                    .setGlieuImage(R.id.iv_img, img);
            holder.setOnClickListener(R.id.tv_btn_2, new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    SpecParam specParam = new SpecParam();
                    specParam.setGoodsPrice_Sort(item.getGoodsPrice_Sort()+"");
                    specParam.setGoodsPrice_Stock(item.getGoodsPrice_Stock()+"");
                    specParam.setGoodsPrice_ID(item.getGoodsPrice_ID());
                    specParam.setGoodsPrice_VirtualPrice(item.getGoodsPrice_VirtualPrice()+"");
                    specParam.setGoodsPrice_AttrName(item.getGoodsPrice_AttrName()+"");
                    specParam.setGoodsPrice_SpecName(item.getGoodsPrice_SpecName()+"");
                    specParam.setGoods_ID(item.getGoods_ID()+"");
                    specParam.setGoodsPrice_Price(item.getGoodsPrice_Price()+"");
                    specParam.setGoodsPrice_PayMaxCount(item.getGoodsPrice_PayMaxCount()+"");
                    specParam.setGoodsPrice_TotalStock(item.getGoodsPrice_TotalStock()+"");
                    AddSpecActivity.start(EditSpecActivity.this,specParam);
                }
            });

            holder.setOnClickListener(R.id.tv_btn_3, new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    new AlertDialog(getContext()).builder()
                            .setMsg("确定要删除吗？")
                            .setNegativeButton("取消", new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {

                                }
                            })
                            .setPositiveButton("确认", new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    deleteCall.delete(item);
                                }
                            }).show();

                }
            });
        }

        @Override
        protected int getItemViewLayoutId(int position, EditSpecBean.ItemsBean item) {
            return R.layout.item_goods_spec;
        }



    }

    public interface DeleteCall{
        void delete(EditSpecBean.ItemsBean item);
    }
}
