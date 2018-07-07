package com.whmnrc.qiangbizhong.ui.yimei.adpter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.adapter.BaseAdapter;
import com.whmnrc.qiangbizhong.base.adapter.BaseViewHolder;
import com.whmnrc.qiangbizhong.model.bean.HomePageBean;
import com.whmnrc.qiangbizhong.model.bean.YiMeiBean;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/7.
 */

public class YiMeiGoodsAdapter extends BaseAdapter<YiMeiBean.GoodsList>{


    public YiMeiGoodsAdapter(Context context) {
        super(context);

    }

    @Override
    protected void bindDataToItemView(BaseViewHolder holder, YiMeiBean.GoodsList item, int position) {
        holder.setGlieuImage(R.id.iv_img,item.getUrl());
        RecyclerView rvGoods = holder.getView(R.id.rv_goods);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        rvGoods.setLayoutManager(linearLayoutManager);
        GoodsAdapter goodsAdapter = new GoodsAdapter(getContext());
        rvGoods.setAdapter(goodsAdapter);
        goodsAdapter.addFirstDataSet(item.getGoodsBeans());
    }

    @Override
    protected int getItemViewLayoutId(int position, YiMeiBean.GoodsList item) {
        return R.layout.item_yimei_goods_list;
    }

    public class GoodsAdapter extends BaseAdapter<HomePageBean.GoodsBean>{

        public GoodsAdapter(Context context) {
            super(context);
        }

        @Override
        protected void bindDataToItemView(BaseViewHolder holder, HomePageBean.GoodsBean item, int position) {
            holder.setText(R.id.tv_goods_name,item.getName()).setText(R.id.tv_moeny,item.getMoney()).setGlieuImage(R.id.iv_img,item.getUrl());
        }

        @Override
        protected int getItemViewLayoutId(int position, HomePageBean.GoodsBean item) {
            return R.layout.item_yimei_goods_list_item_goods;
        }
    }
}
