package com.whmnrc.qiangbizhong.ui.me.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.adapter.BaseAdapter;
import com.whmnrc.qiangbizhong.base.adapter.BaseViewHolder;
import com.whmnrc.qiangbizhong.model.bean.MineBean;
import com.whmnrc.qiangbizhong.ui.LoginActivity;
import com.whmnrc.qiangbizhong.ui.home.adapter.MenuAdapter;
import com.whmnrc.qiangbizhong.ui.me.activity.GoodsManageActivity;
import com.whmnrc.qiangbizhong.ui.me.activity.MyOrderActivity;
import com.whmnrc.qiangbizhong.ui.me.activity.ShopManageActivity;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/9.
 */

public class OderMenuAdapter extends BaseAdapter<MineBean.MenuBean> {

    private boolean isLogin;

    public OderMenuAdapter(Context context,boolean isLogin) {
        super(context);
        this.isLogin = isLogin;
    }

    @Override
    protected void bindDataToItemView(BaseViewHolder holder, MineBean.MenuBean item, int position1) {
        holder.setText(R.id.tv_title, item.getName()).setText(R.id.tv_more, item.getMore());
        RecyclerView recyclerView = holder.getView(R.id.rv_oreder);
        MenuAdapter menuAdapter = new MenuAdapter(getContext(), 0);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 4);
        if (position1 == 1){
            gridLayoutManager = new GridLayoutManager(getContext(), 3);
        }
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(menuAdapter);
        menuAdapter.addFirstDataSet(item.getList());

            menuAdapter.setOnItemClickListener(new OnItemClickListener() {
                @Override
                public void onClick(View view, Object item, int position) {
                    if (isLogin){
                        if (position1 == 0) {
                            MyOrderActivity.start(getContext(), position);
                        }else if (position1 == 1){
                            if (position == 0 ) {
                                GoodsManageActivity.start(getContext(), 1);
                            }else if (position == 1){
                                GoodsManageActivity.start(getContext(), 3);
                            }else if (position == 2){
                                GoodsManageActivity.start(getContext(), 2);
                            }
                        }else if (position1 == 2){
                            ShopManageActivity.start(getContext(),position);
                        }
                    }else {

                        LoginActivity.start(getContext());
                    }

                }
            });
        holder.setOnClickListener(R.id.tv_more, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isLogin){
                    if (position1 == 0) {
                        MyOrderActivity.start(getContext(), 4);
                    }else if (position1 == 1){
                        GoodsManageActivity.start(getContext(),0);
                    }else if (position1 == 2){
                        ShopManageActivity.start(getContext(),4);
                    }
                }else {
                    LoginActivity.start(getContext());
                }
            }
        });
    }

    @Override
    protected int getItemViewLayoutId(int position, MineBean.MenuBean item) {
        return R.layout.item_oder_me;
    }

}
