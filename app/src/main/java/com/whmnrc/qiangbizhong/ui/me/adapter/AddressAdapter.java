package com.whmnrc.qiangbizhong.ui.me.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.adapter.BaseAdapter;
import com.whmnrc.qiangbizhong.base.adapter.BaseViewHolder;
import com.whmnrc.qiangbizhong.model.bean.AddressBean;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/10.
 */

public class AddressAdapter extends BaseAdapter<AddressBean>{

    private OnDeleteClickListener onDeleteClickListener;

    public void setOnDeleteClickListener(OnDeleteClickListener onDeleteClickListener) {
        this.onDeleteClickListener = onDeleteClickListener;
    }

    public AddressAdapter(Context context) {
        super(context);
    }

    @Override
    protected void bindDataToItemView(BaseViewHolder holder, AddressBean item, int position) {
        holder.setText(R.id.tv_name,item.getAddress_Name())
                .setText(R.id.tv_phone,item.getAddress_Mobile())
                .setText(R.id.tv_address,item.getProviceName()  + item.getCityName() +item.getRegionName() + item.getAddress_Detail());
        TextView textView = holder.getView(R.id.tv_select_address);
        if (item.getAddress_IsDefault() == 0){
            Drawable nav_up = getContext().getResources().getDrawable(R.drawable.ic_selece_no);
            nav_up.setBounds(0, 0, nav_up.getMinimumWidth(), nav_up.getMinimumHeight());
            textView.setCompoundDrawables(nav_up, null, null, null);
            textView.setCompoundDrawablePadding(10);
            textView.setText("设置为默认地址");
            textView.setTextColor(getContext().getResources().getColor(R.color.tv_navigation));
        }else {
            Drawable nav_up= getContext().getResources().getDrawable(R.drawable.ic_select);
            nav_up.setBounds(0, 0, nav_up.getMinimumWidth(), nav_up.getMinimumHeight());
            textView.setCompoundDrawables(nav_up, null, null, null);
            textView.setCompoundDrawablePadding(10);
            textView.setText("默认地址");
            textView.setTextColor(getContext().getResources().getColor(R.color.colorAccent));
        }
        holder.setOnClickListener(R.id.tv_delete, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onDeleteClickListener != null){
                    onDeleteClickListener.onDelete(item);
                }
            }
        });

        holder.setOnClickListener(R.id.tv_edit, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onDeleteClickListener != null){
                    onDeleteClickListener.onEdit(item);
                }
            }
        });
    }

    @Override
    protected int getItemViewLayoutId(int position, AddressBean item) {
        return R.layout.item_list_address;
    }

    public interface OnDeleteClickListener{
        void onDelete(AddressBean addressBean);

        void onEdit(AddressBean addressBean);
    }

}
