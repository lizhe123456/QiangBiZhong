package com.whmnrc.qiangbizhong.ui.home.adapter;

import android.content.Context;

import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.adapter.BaseAdapter;
import com.whmnrc.qiangbizhong.base.adapter.BaseViewHolder;
import com.whmnrc.qiangbizhong.model.bean.UserInfoBean;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/26.
 */

public class UserInfoAdapter extends BaseAdapter<UserInfoBean> {

    public UserInfoAdapter(Context context) {
        super(context);
    }

    @Override
    protected void bindDataToItemView(BaseViewHolder holder, UserInfoBean item, int position) {
            holder.setText(R.id.tv_name,item.getUserNick())
                    .setText(R.id.tv_time,item.getCreateDate())
                    .setGlieuImage(R.id.iv_head,item.getUserHeadImage());

            if (item.getOrder_State() == 8){
                holder.setVisible(R.id.iv_img_zj,true);
            }else {
                holder.setVisible(R.id.iv_img_zj,false);
            }
    }

    @Override
    protected int getItemViewLayoutId(int position, UserInfoBean item) {
        return R.layout.item_user_list;
    }

}
