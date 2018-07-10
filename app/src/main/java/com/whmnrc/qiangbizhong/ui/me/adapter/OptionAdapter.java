package com.whmnrc.qiangbizhong.ui.me.adapter;

import android.content.Context;

import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.adapter.BaseAdapter;
import com.whmnrc.qiangbizhong.base.adapter.BaseViewHolder;
import com.whmnrc.qiangbizhong.model.bean.MineBean;
import com.whmnrc.qiangbizhong.model.bean.OptionBean;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/9.
 */

public class OptionAdapter extends BaseAdapter<MineBean.ItemBean> {

    public OptionAdapter(Context context) {
        super(context);
    }

    @Override
    protected void bindDataToItemView(BaseViewHolder holder, MineBean.ItemBean item, int position) {
        if (position == getDataSource().size()-1){
            holder.setVisible(R.id.v_divider,false);
        }else {
            holder.setVisible(R.id.v_divider,true);
        }

        holder.setImageResource(R.id.iv_title,item.getRedId()).setText(R.id.tv_title,item.getName());

    }

    @Override
    protected int getItemViewLayoutId(int position, MineBean.ItemBean item) {
        return R.layout.item_option;
    }
}
