package com.whmnrc.qiangbizhong.ui.shopping.adpter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.adapter.BaseAdapter;
import com.whmnrc.qiangbizhong.base.adapter.BaseViewHolder;
import com.whmnrc.qiangbizhong.model.bean.ShopCarBean;
import com.whmnrc.qiangbizhong.presenter.shopcar.ShopCarPresenter;
import com.whmnrc.qiangbizhong.ui.shop.activity.ShopDetailsActivity;
import com.whmnrc.qiangbizhong.ui.shop.activity.ShopsListActivity;
import com.whmnrc.qiangbizhong.util.StringUtil;
import java.util.ArrayList;
import java.util.List;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/7.
 */

public class ShopCarAdapter extends BaseAdapter<ShopCarBean> {


    public OnEditCall onEditCall;
    private boolean isEdit;
    private boolean all;
    private ShopCarPresenter shopCarPresenter;
    public void setOnEditCall(OnEditCall onEditCall) {
        this.onEditCall = onEditCall;
    }

    public ShopCarAdapter(Context context,ShopCarPresenter shopCarPresenter) {
        super(context);
        this.shopCarPresenter = shopCarPresenter;
    }

    public void allSelect(boolean isAll){

        for (ShopCarBean shopCarBean:getDataSource()) {
            for (ShopCarBean.GoodsBean goodsBean : shopCarBean.getGoods()) {
                goodsBean.setSelect(isAll);
            }
            shopCarBean.setSelect(isAll);
            notifyDataSetChanged();
        }

        if (onEditCall != null){
            onEditCall.heji();
        }
    }

    public void setEdit(boolean isEdit){
        this.isEdit = isEdit;
        notifyDataSetChanged();
    }

    public void setSelect(int position,boolean isSelect){
        getDataSource().get(position).setSelect(isSelect);
        notifyItemChanged(position);
    }

    @Override
    protected void bindDataToItemView(BaseViewHolder holder, ShopCarBean item, int position) {
        holder.setText(R.id.tv_name,item.getStoreName());
        holder.setOnClickListener(R.id.tv_name, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShopsListActivity.start(getContext(),item.getStoreId());
            }
        });
        RecyclerView rvGoods = holder.getView(R.id.rv_goods);
        rvGoods.setLayoutManager(new LinearLayoutManager(getContext()));

        if (item.isSelect()){
            holder.setImageResource(R.id.iv_select,R.drawable.ic_select);
        }else {
            holder.setImageResource(R.id.iv_select,R.drawable.ic_selece_no);
        }
        GoodsAdapter goodsAdapter = new GoodsAdapter(getContext(),isEdit,onEditCall,position,shopCarPresenter);
        rvGoods.setAdapter(goodsAdapter);
        goodsAdapter.addFirstDataSet(item.getGoods());

        holder.setOnClickListener(R.id.iv_select, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (item.isSelect()) {
                    item.setSelect(false);
                    holder.setImageResource(R.id.iv_select,R.drawable.ic_selece_no);
                    goodsAdapter.allSelect(false);
                }else {
                    item.setSelect(true);
                    holder.setImageResource(R.id.iv_select,R.drawable.ic_select);
                    goodsAdapter.allSelect(true);
                }

                if (onEditCall != null){
                    onEditCall.isAll();
                    onEditCall.heji();
                }

            }
        });

        holder.setOnClickListener(R.id.tv_name, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转商家详情
                ShopsListActivity.start(getContext(),item.getStoreId());
            }
        });

    }

    @Override
    protected int getItemViewLayoutId(int position, ShopCarBean item) {
        return R.layout.item_shop_car;
    }



    public static class GoodsAdapter extends BaseAdapter<ShopCarBean.GoodsBean>{

        private boolean isEdit;

        private OnEditCall onEditCall;

        private int position;
        private ShopCarPresenter shopCarPresenter;

        private GoodsAdapter(Context context,boolean isEdit,OnEditCall onEditCall,int position,ShopCarPresenter shopCarPresenter) {
            super(context);
            this.isEdit = isEdit;
            this.onEditCall = onEditCall;
            this.position = position;
            this.shopCarPresenter = shopCarPresenter;
        }

        private void allSelect(boolean isAll){
            for (ShopCarBean.GoodsBean shopCarBean:getDataSource()) {
                shopCarBean.setSelect(isAll);
                notifyDataSetChanged();
            }
            if (onEditCall != null){
                onEditCall.heji();
            }
        }

        @Override
        protected void bindDataToItemView(BaseViewHolder holder, ShopCarBean.GoodsBean item, int position) {

            if (item.isSelect()){
                holder.setImageResource(R.id.iv_select,R.drawable.ic_select);
            }else {
                holder.setImageResource(R.id.iv_select,R.drawable.ic_selece_no);
            }
            holder.setGlieuImage(R.id.iv_img,item.getGoods_ImaPath())
                    .setOnClickListener(R.id.iv_img, new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ShopDetailsActivity.start(getContext(),item.getGoods_ID());
                }
            });

            if (position == getDataSource().size() - 1){
                holder.setVisible(R.id.v_xian,false);
            }else {
                holder.setVisible(R.id.v_xian,true);
            }

            if (isEdit){
                //编辑
                holder.setVisible(R.id.ll_edit,true);
                holder.setVisible(R.id.rl_layout,false);
                holder.setText(R.id.tv_guige,item.getGoodsPrice_SpecName() + " " + item.getGoodsPrice_AttrName()).setText(R.id.tv_edit_count,item.getBuyCar_Num() + "");

                holder.setOnClickListener(R.id.tv_jia, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (onEditCall != null){
//                            onEditCall.jiaOrjian(position,item.getBuyCar_ID(),1);
                            shopCarPresenter.updatecarnum(item.getBuyCar_ID(), 1, new ShopCarPresenter.CarStatuCall() {
                                @Override
                                public void csS() {

                                }

                                @Override
                                public void updateS() {

                                }

                                @Override
                                public void jj() {
                                    item.setBuyCar_Num(item.getBuyCar_Num() + 1);
                                    notifyItemChanged(position);
                                }

                                @Override
                                public void deleteCar() {

                                }

                                @Override
                                public void error() {

                                }
                            });
                        }
                    }
                });

                holder.setOnClickListener(R.id.tv_jian, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (item.getBuyCar_Num() > 1){
                            shopCarPresenter.updatecarnum(item.getBuyCar_ID(), 0, new ShopCarPresenter.CarStatuCall() {
                                @Override
                                public void csS() {

                                }

                                @Override
                                public void updateS() {

                                }

                                @Override
                                public void jj() {
                                    item.setBuyCar_Num(item.getBuyCar_Num() - 1);
                                    notifyItemChanged(position);
                                }

                                @Override
                                public void deleteCar() {

                                }

                                @Override
                                public void error() {

                                }
                            });
                        }
                    }
                });

                holder.setOnClickListener(R.id.tv_guige, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //弹出规格框
                        if (onEditCall != null){
                            onEditCall.updateSpec(GoodsAdapter.this.position,position,item.getBuyCar_ID(),item.getGoods_ID());
                        }
                    }
                });

                holder.setOnClickListener(R.id.iv_shopping_car_delete, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        new com.whmnrc.qiangbizhong.widget.AlertDialog(getContext()).builder()
                                .setTitle("提示")
                                .setMsg("确定要删除吗?")
                                .setNegativeButton("取消", new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {

                                    }
                                })
                                .setPositiveButton("确认", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                List<String> list = new ArrayList<>();
                                list.add(item.getBuyCar_ID());
                                shopCarPresenter.deletecars(list, new ShopCarPresenter.CarStatuCall() {
                                    @Override
                                    public void csS() {

                                    }

                                    @Override
                                    public void updateS() {

                                    }

                                    @Override
                                    public void jj() {

                                    }

                                    @Override
                                    public void deleteCar() {
                                        if (onEditCall != null) {
                                            onEditCall.updateData();
                                        }
                                    }

                                    @Override
                                    public void error() {

                                    }
                                });
                            }
                        }).setCancelable(true).show();

                    }
                });
            }else {
                //商品
                holder.setVisible(R.id.rl_layout,true);
                holder.setVisible(R.id.ll_edit,false);
                holder.setText(R.id.tv_goods_name,item.getGoods_Name())
                        .setText(R.id.tv_guige_name,item.getGoodsPrice_SpecName() + " "+item.getGoodsPrice_AttrName())
                        .setText(R.id.tv_moeny, StringUtil.weiString1(item.getGoodsPrice_Price()))
                        .setText(R.id.tv_count,"x"+item.getBuyCar_Num() + "");
            }

            holder.setOnClickListener(R.id.iv_select, new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (item.isSelect()) {
                        item.setSelect(false);
                        holder.setImageResource(R.id.iv_select,R.drawable.ic_selece_no);
                    }else {
                        item.setSelect(true);
                        holder.setImageResource(R.id.iv_select,R.drawable.ic_select);
                    }
                    //选中并重置价格
                    if (onEditCall != null){
                        onEditCall.sonSelect(GoodsAdapter.this.position);
                        onEditCall.isAll();
                        onEditCall.heji();
                    }
                }
            });

        }

        @Override
        protected int getItemViewLayoutId(int position, ShopCarBean.GoodsBean item) {
            return R.layout.item_shop_car_goods;
        }

    }

    public interface OnEditCall{
        void jiaOrjian(int position,String carId,int type);

        void updateSpec(int fposition,int position,String carId,String goodsId);

        void heji();

        void isAll();

        void sonSelect(int position);

        void updateData();

    }

}
