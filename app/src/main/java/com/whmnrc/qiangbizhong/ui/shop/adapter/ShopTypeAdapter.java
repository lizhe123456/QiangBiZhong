package com.whmnrc.qiangbizhong.ui.shop.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.blankj.utilcode.util.ScreenUtils;
import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.adapter.BaseAdapter;
import com.whmnrc.qiangbizhong.base.adapter.BaseViewHolder;
import com.whmnrc.qiangbizhong.model.bean.ShopBean;

import java.util.ArrayList;
import java.util.List;


/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/30.
 */

public class ShopTypeAdapter extends BaseAdapter<ShopBean.TypeListBean>{

    private int width;

    public ShopTypeAdapter(Context context) {
        super(context);
        width = (ScreenUtils.getScreenWidth() - 130) / 5;
    }

    public void setOpen(boolean isOpen,@NonNull List<ShopBean.TypeListBean> datas){
        if (datas != null) {
            if (datas.size() > 10) {
                if (isOpen) {
                    addFirstDataSet(datas);
                } else {
                    List<ShopBean.TypeListBean> list = new ArrayList<>();
                    for (int i = 0; i < 10; i++) {
                        list.add(datas.get(i));
                    }
                    addFirstDataSet(list);
                }
            } else {
                addFirstDataSet(datas);
            }
        }
    }

    @Override
    protected void bindDataToItemView(BaseViewHolder holder, ShopBean.TypeListBean item, int position) {
        holder.setGlieuImage(R.id.iv_img,item.getImage_url()).setText(R.id.tv_text,item.getTypeName());
        ImageView imageView = holder.getView(R.id.iv_img);

        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) imageView.getLayoutParams();
        layoutParams.width = width;
        layoutParams.height = width;
        imageView.setLayoutParams(layoutParams);

    }

    @Override
    protected int getItemViewLayoutId(int position, ShopBean.TypeListBean item) {
        return R.layout.item_menu;
    }

}
