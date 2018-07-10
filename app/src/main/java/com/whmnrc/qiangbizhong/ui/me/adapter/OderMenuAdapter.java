package com.whmnrc.qiangbizhong.ui.me.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.adapter.BaseAdapter;
import com.whmnrc.qiangbizhong.base.adapter.BaseViewHolder;
import com.whmnrc.qiangbizhong.model.bean.MineBean;
import com.whmnrc.qiangbizhong.ui.home.adapter.MenuAdapter;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/9.
 */

public class OderMenuAdapter extends BaseAdapter<MineBean.MenuBean> {

    public OderMenuAdapter(Context context) {
        super(context);
    }

    @Override
    protected void bindDataToItemView(BaseViewHolder holder, MineBean.MenuBean item, int position) {
        holder.setText(R.id.tv_title,item.getName()).setText(R.id.tv_more,item.getMore());
        RecyclerView recyclerView = holder.getView(R.id.rv_oreder);
        MenuAdapter menuAdapter = new MenuAdapter(getContext(),0);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),4);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(menuAdapter);
        menuAdapter.addFirstDataSet(item.getList());
    }

    @Override
    protected int getItemViewLayoutId(int position, MineBean.MenuBean item) {
        return R.layout.item_oder_me;
    }

}
