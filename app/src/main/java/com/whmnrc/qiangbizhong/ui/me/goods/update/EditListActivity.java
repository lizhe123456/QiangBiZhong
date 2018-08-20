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
import com.whmnrc.qiangbizhong.model.bean.GoodsManageBean;
import com.whmnrc.qiangbizhong.model.parameter.GoodsParam;
import com.whmnrc.qiangbizhong.ui.me.goods.ReleaseGoodsActivity;
import com.whmnrc.qiangbizhong.util.GsonUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/8/7.
 * 编辑列表
 */

public class EditListActivity extends BaseActivity {


    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.rv_edit_list)
    RecyclerView rvEditList;

    private GoodsManageBean goodsManageBean;

    public static void start(Context context, String goodsId, GoodsManageBean goodsManageBean) {
        Intent starter = new Intent(context, EditListActivity.class);
        starter.putExtra("goodsId",goodsId);
        starter.putExtra("goodsManageBean", GsonUtil.createGsonString(goodsManageBean));
        context.startActivity(starter);
    }

    @Override
    protected int setLayout() {
        return R.layout.activity_edit_list;
    }

    @Override
    protected void setData() {
        ivBack.setVisibility(View.VISIBLE);
        tvTitle.setText("编辑商品");
        String data = getIntent().getStringExtra("goodsManageBean");
        goodsManageBean = GsonUtil.changeGsonToBean(data, GoodsManageBean.class);
        List<String> list = new ArrayList<>();
        list.add("编辑商品信息");
        list.add("编辑商品轮播图");
        list.add("编辑商品规格");
        if (goodsManageBean.getGoods_ShopType() != 3) {
            list.add("编辑商品详情");
        }
        EditItemAdapter editItemAdapter = new EditItemAdapter(this);
        rvEditList.setLayoutManager(new LinearLayoutManager(this));
        rvEditList.setAdapter(editItemAdapter);
        editItemAdapter.setOnItemClickListener(new BaseAdapter.OnItemClickListener() {
            @Override
            public void onClick(View view, Object item, int position) {
                switch (position){
                    case 0:
                        GoodsParam goodsParam = new GoodsParam();
                        goodsParam.setStoreId(goodsManageBean.getStoreId());
                        goodsParam.setGoods_Type(goodsManageBean.getGoods_Type());
                        goodsParam.setGoods_Sort(goodsManageBean.getGoods_Sort()+"");
                        goodsParam.setGoods_Describe(goodsManageBean.getGoods_Describe());
                        goodsParam.setGoods_Name(goodsManageBean.getGoods_Name());
                        goodsParam.setGoods_BrandName(goodsManageBean.getGoods_BrandName());
                        goodsParam.setGoods_PriceMax(goodsManageBean.getGoods_PriceMax()+"");
                        goodsParam.setGoods_PriceMin(goodsManageBean.getGoods_PriceMin()+"");
                        goodsParam.setGoods_ImaPath(goodsManageBean.getGoods_ImaPath());
                        goodsParam.setGoods_Content(goodsManageBean.getGoods_ImaPath());
                        goodsParam.setGoods_IsBuy(goodsManageBean.isGoods_IsBuy());
                        goodsParam.setGoods_IsOn(goodsManageBean.isGoods_IsOn());
                        goodsParam.setGoods_LimitCount(goodsManageBean.getGoods_LimitCount()+"");
                        goodsParam.setGoods_Parameter(goodsManageBean.getGoods_Parameter()+"");
                        goodsParam.setGoods_MonthCount(goodsManageBean.getGoods_MonthCount()+"");
                        goodsParam.setGoods_LookCount(goodsManageBean.getGoods_LookCount()+"");
                        goodsParam.setGoods_ShopType(goodsManageBean.getGoods_ShopType()+"");
                        goodsParam.setGoods_ID(goodsManageBean.getGoods_ID()+"");

                        ReleaseGoodsActivity.start(EditListActivity.this,goodsParam,1);
                        break;
                    case 1:
                        EditBannerActivity.start(EditListActivity.this,getIntent().getStringExtra("goodsId"));
                        break;
                    case 3:
                        EditGoodsDetailsActivity.start(EditListActivity.this,getIntent().getStringExtra("goodsId"));
                        break;
                    case 2:
                        EditSpecActivity.start(EditListActivity.this,getIntent().getStringExtra("goodsId"));
                        break;
                }
            }
        });
        editItemAdapter.addFirstDataSet(list);
    }

    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        this.finish();
    }

    class EditItemAdapter extends BaseAdapter<String>{

        public EditItemAdapter(Context context) {
            super(context);
        }

        @Override
        protected void bindDataToItemView(BaseViewHolder holder, String item, int position) {
            holder.setText(R.id.tv_edit_item,item);
        }

        @Override
        protected int getItemViewLayoutId(int position, String item) {
            return R.layout.item_edit_bean;
        }
    }
}
