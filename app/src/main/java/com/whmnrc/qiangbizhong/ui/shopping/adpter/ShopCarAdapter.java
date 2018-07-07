package com.whmnrc.qiangbizhong.ui.shopping.adpter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.adapter.BaseAdapter;
import com.whmnrc.qiangbizhong.base.adapter.BaseViewHolder;
import com.whmnrc.qiangbizhong.model.bean.ShopCarBean;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/7.
 */

public class ShopCarAdapter extends BaseAdapter<ShopCarBean> {

    public ShopCarAdapter(Context context) {
        super(context);
    }

    @Override
    protected void bindDataToItemView(BaseViewHolder holder, ShopCarBean item, int position) {
        holder.setText(R.id.tv_name,"");
        RecyclerView rvGoods = holder.getView(R.id.rv_goods);

    }

    @Override
    protected int getItemViewLayoutId(int position, ShopCarBean item) {
        return R.layout.item_shop_car;
    }

    public class GoodsAdapter extends BaseAdapter<ShopCarBean.GoodsBean>{

        public GoodsAdapter(Context context) {
            super(context);
        }

        @Override
        protected void bindDataToItemView(BaseViewHolder holder, ShopCarBean.GoodsBean item, int position) {

        }

        @Override
        protected int getItemViewLayoutId(int position, ShopCarBean.GoodsBean item) {
            return R.layout.item_shop_car_goods;
        }
    }

}
