package com.whmnrc.qiangbizhong.ui.shop.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.adapter.BaseAdapter;
import com.whmnrc.qiangbizhong.base.adapter.BaseViewHolder;
import com.whmnrc.qiangbizhong.model.bean.ShopBean;
import com.whmnrc.qiangbizhong.ui.LoginActivity;
import com.whmnrc.qiangbizhong.ui.shop.activity.ShopDetailsActivity;
import com.whmnrc.qiangbizhong.util.StringUtil;
import com.whmnrc.qiangbizhong.util.UserManage;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/30.
 */

public class ShopGoodsAdapter extends BaseAdapter<ShopBean.PalteListBean>{

    public ShopGoodsAdapter(Context context) {
        super(context);
    }

    @Override
    protected void bindDataToItemView(BaseViewHolder holder, ShopBean.PalteListBean item, int position) {
        holder.setGlieuImage(R.id.iv_img,item.getPlate().getImage_url());
        RecyclerView rvGoods = holder.getView(R.id.rv_goods);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        rvGoods.setLayoutManager(linearLayoutManager);
        ShopGoodsAdapter.GoodsAdapter goodsAdapter = new ShopGoodsAdapter.GoodsAdapter(getContext());
        rvGoods.setAdapter(goodsAdapter);
        goodsAdapter.addFirstDataSet(item.getGoods());
        goodsAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onClick(View view, Object item, int position) {
                if (UserManage.getInstance().getLoginBean() != null) {
                    ShopBean.PalteListBean.GoodsBean goodsBean = (ShopBean.PalteListBean.GoodsBean) item;
                    ShopDetailsActivity.start(getContext(), goodsBean.getGoods_ID());
                }else {
                    LoginActivity.start(getContext());
                }
            }
        });
    }

    @Override
    protected int getItemViewLayoutId(int position, ShopBean.PalteListBean item) {
        return R.layout.item_yimei_goods_list;
    }

    public class GoodsAdapter extends BaseAdapter<ShopBean.PalteListBean.GoodsBean>{

        private GoodsAdapter(Context context) {
            super(context);
        }

        @Override
        protected void bindDataToItemView(BaseViewHolder holder, ShopBean.PalteListBean.GoodsBean item, int position) {
            holder.setText(R.id.tv_goods_name,item.getGoods_Name())
                    .setText(R.id.tv_moeny, StringUtil.weiString1(item.getGoodsPrice_Price()))
                    .setGlieuImage(R.id.iv_img,item.getGoods_ImaPath());
        }

        @Override
        protected int getItemViewLayoutId(int position, ShopBean.PalteListBean.GoodsBean item) {
            return R.layout.item_yimei_goods_list_item_goods;
        }
    }
}
