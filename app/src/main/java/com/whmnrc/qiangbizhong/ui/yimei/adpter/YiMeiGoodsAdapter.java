package com.whmnrc.qiangbizhong.ui.yimei.adpter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.adapter.BaseAdapter;
import com.whmnrc.qiangbizhong.base.adapter.BaseViewHolder;
import com.whmnrc.qiangbizhong.model.bean.HomePageBean;
import com.whmnrc.qiangbizhong.model.bean.YiMeiBean;
import com.whmnrc.qiangbizhong.model.bean.YiMeiGoodsDetailBean;
import com.whmnrc.qiangbizhong.model.bean.YiMeiIndexBean;
import com.whmnrc.qiangbizhong.ui.yimei.activity.YiMeiGoodsDetailsActivity;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/7.
 */

public class YiMeiGoodsAdapter extends BaseAdapter<YiMeiIndexBean.MedicalListBean>{


    public YiMeiGoodsAdapter(Context context) {
        super(context);

    }

    @Override
    protected void bindDataToItemView(BaseViewHolder holder, YiMeiIndexBean.MedicalListBean item, int position) {
        holder.setGlieuImage(R.id.iv_img,item.getPlate().getImage_url());
        RecyclerView rvGoods = holder.getView(R.id.rv_goods);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        rvGoods.setLayoutManager(linearLayoutManager);
        GoodsAdapter goodsAdapter = new GoodsAdapter(getContext());
        rvGoods.setAdapter(goodsAdapter);
        goodsAdapter.addFirstDataSet(item.getGoods());
        goodsAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onClick(View view, Object item, int position) {
                YiMeiIndexBean.MedicalListBean.GoodsBean medicalListBean = (YiMeiIndexBean.MedicalListBean.GoodsBean) item;
                YiMeiGoodsDetailsActivity.start(getContext(),medicalListBean.getGoods_ID());
            }
        });
    }

    @Override
    protected int getItemViewLayoutId(int position, YiMeiIndexBean.MedicalListBean item) {
        return R.layout.item_yimei_goods_list;
    }

    public class GoodsAdapter extends BaseAdapter<YiMeiIndexBean.MedicalListBean.GoodsBean>{

        private GoodsAdapter(Context context) {
            super(context);
        }

        @Override
        protected void bindDataToItemView(BaseViewHolder holder, YiMeiIndexBean.MedicalListBean.GoodsBean item, int position) {
            holder.setText(R.id.tv_goods_name,item.getGoods_Name()).setText(R.id.tv_moeny,String.valueOf(item.getGoodsPrice_Price())).setGlieuImage(R.id.iv_img,item.getGoods_ImaPath());


        }

        @Override
        protected int getItemViewLayoutId(int position, YiMeiIndexBean.MedicalListBean.GoodsBean item) {
            return R.layout.item_yimei_goods_list_item_goods;
        }
    }
}
