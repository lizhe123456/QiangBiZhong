package com.whmnrc.qiangbizhong.ui.shop.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.adapter.BaseAdapter;
import com.whmnrc.qiangbizhong.base.adapter.BaseViewHolder;
import com.whmnrc.qiangbizhong.model.bean.ShopConfirmOrderBean;
import com.whmnrc.qiangbizhong.ui.shopping.adpter.ShopCarAdapter;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/28.
 */

public class ShopConfirmOrderAdapter extends BaseAdapter<ShopConfirmOrderBean>{

    public ShopConfirmOrderAdapter(Context context) {
        super(context);
    }

    @Override
    protected void bindDataToItemView(BaseViewHolder holder, ShopConfirmOrderBean item, int position) {
        RecyclerView recyclerView = holder.getView(R.id.rv_goods);
        ShopCarAdapter.GoodsAdapter goodsAdapter = new ShopCarAdapter.GoodsAdapter(getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(goodsAdapter);
    }

    @Override
    protected int getItemViewLayoutId(int position, ShopConfirmOrderBean item) {
        return R.layout.item_shop_confirm_order;
    }
}
