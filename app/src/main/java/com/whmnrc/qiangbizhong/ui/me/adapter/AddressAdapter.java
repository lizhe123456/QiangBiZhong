package com.whmnrc.qiangbizhong.ui.me.adapter;

import android.content.Context;

import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.adapter.BaseAdapter;
import com.whmnrc.qiangbizhong.base.adapter.BaseViewHolder;
import com.whmnrc.qiangbizhong.model.bean.AddressBean;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/10.
 */

public class AddressAdapter extends BaseAdapter<AddressBean>{

    public AddressAdapter(Context context) {
        super(context);
    }

    @Override
    protected void bindDataToItemView(BaseViewHolder holder, AddressBean item, int position) {
        holder.setText(R.id.tv_name,item.getAddress_Name())
                .setText(R.id.tv_phone,item.getAddress_Mobile())
                .setText(R.id.tv_address,item.getAddress_Provice()+item.getAddress_City()+item.getAddress_Region()+item.getAddress_Detail())
                .setText(R.id.tv_select_address,"")
                .setText(R.id.tv_edit,"")
                .setText(R.id.tv_delete,"");
    }

    @Override
    protected int getItemViewLayoutId(int position, AddressBean item) {
        return R.layout.item_list_address;
    }
}
