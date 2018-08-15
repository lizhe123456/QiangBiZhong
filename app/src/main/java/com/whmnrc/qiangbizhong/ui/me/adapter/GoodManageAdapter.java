package com.whmnrc.qiangbizhong.ui.me.adapter;

import android.content.Context;
import android.view.View;
import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.adapter.BaseAdapter;
import com.whmnrc.qiangbizhong.base.adapter.BaseViewHolder;
import com.whmnrc.qiangbizhong.model.bean.GoodsManageBean;
import com.whmnrc.qiangbizhong.ui.me.goods.update.EditListActivity;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/8/7.
 */

public class GoodManageAdapter extends BaseAdapter<GoodsManageBean>{


    private OnGoodsManageListener onGoodsManageListener;

    public GoodManageAdapter(Context context) {
        super(context);
    }

    public void setOnGoodsManageListener(OnGoodsManageListener onGoodsManageListener) {
        this.onGoodsManageListener = onGoodsManageListener;
    }

    @Override
    protected void bindDataToItemView(BaseViewHolder holder, GoodsManageBean item, int position) {
        holder.setText(R.id.tv_goods_desc,item.getGoods_Name())
                .setText(R.id.tv_moeny, item.getGoods_PriceMin() + "~" + item.getGoods_PriceMax())
                .setGlieuImage(R.id.iv_goods,item.getGoods_ImaPath()).setText(R.id.tv_order_num,"");
        if (item.isGoods_IsOn()){
            holder.setText(R.id.order_state,"已上架");
            holder.setText(R.id.tv_btn_3,"直接下架");
            holder.setOnClickListener(R.id.tv_btn_3, new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onGoodsManageListener != null){
                        onGoodsManageListener.lowerFrame(item);
                    }
                }
            });
            holder.setVisible(R.id.tv_btn_2,false);
        }else {
            holder.setText(R.id.order_state,"已下架");
            holder.setText(R.id.tv_btn_3,"直接上架");
            holder.setOnClickListener(R.id.tv_btn_3, new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onGoodsManageListener != null){
                        onGoodsManageListener.exhibitGoods(item);
                    }
                }
            });
            holder.setVisible(R.id.tv_btn_2,true);
            holder.setOnClickListener(R.id.tv_btn_2, new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    EditListActivity.start(getContext(),item.getGoods_ID(),item);
                }
            });
        }



    }



    @Override
    protected int getItemViewLayoutId(int position, GoodsManageBean item) {
        return R.layout.item_goods_manage;
    }

    public interface OnGoodsManageListener{
        void lowerFrame(GoodsManageBean item);

        void exhibitGoods(GoodsManageBean item);
    }
}
