package com.whmnrc.qiangbizhong.ui.shopping.adpter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.adapter.BaseAdapter;
import com.whmnrc.qiangbizhong.base.adapter.BaseViewHolder;
import com.whmnrc.qiangbizhong.model.bean.ShopCarBean;
import com.whmnrc.qiangbizhong.util.StringUtil;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/8/1.
 */

public class ShopConfirmAdapter extends BaseAdapter<ShopCarBean> {

    public ShopConfirmAdapter(Context context) {
        super(context);
    }

    @Override
    protected void bindDataToItemView(BaseViewHolder holder, ShopCarBean item, int position) {
        holder.setText(R.id.tv_order_num,item.getStoreName());
        RecyclerView recyclerView = holder.getView(R.id.rv_goods_list);
        GoodsAdapter goodsAdapter = new GoodsAdapter(getContext());
        recyclerView.setAdapter(goodsAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        goodsAdapter.addFirstDataSet(item.getGoods());
        double num = 0;
        int count = 0;
        for (ShopCarBean.GoodsBean goodsBean :item.getGoods()) {
            num += goodsBean.getGoodsPrice_Price() * (double) goodsBean.getBuyCar_Num();
            count += goodsBean.getBuyCar_Num();
        }

        holder.setText(R.id.tv_price,StringUtil.wanString(num)).setText(R.id.tv_num,"共有"+count+"件商品");

        EditText editText = holder.getView(R.id.et_desc);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                item.setEtDsec(editText.getText().toString());
            }
        });
    }

    @Override
    protected int getItemViewLayoutId(int position, ShopCarBean item) {
        return R.layout.item_shop_car_confirm;
    }

    class GoodsAdapter extends BaseAdapter<ShopCarBean.GoodsBean>{

        private GoodsAdapter(Context context) {
            super(context);
        }

        @Override
        protected void bindDataToItemView(BaseViewHolder holder, ShopCarBean.GoodsBean item, int position) {
            holder.setText(R.id.tv_goods_name,item.getGoods_Name())
                    .setText(R.id.tv_goods_spec,item.getGoodsPrice_SpecName()+" "+item.getGoodsPrice_AttrName())
                    .setText(R.id.tv_count, "x" + item.getBuyCar_Num()).setGlieuImage(R.id.iv_img,item.getGoods_ImaPath())
                    .setText(R.id.tv_price, StringUtil.wanString(item.getGoodsPrice_Price()));
        }

        @Override
        protected int getItemViewLayoutId(int position, ShopCarBean.GoodsBean item) {
            return R.layout.item_confirm_shop_goods;
        }
    }
}
