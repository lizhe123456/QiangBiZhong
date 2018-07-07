package com.whmnrc.qiangbizhong.ui.home.adapter;

import android.content.Context;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.blankj.utilcode.util.ScreenUtils;
import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.adapter.BaseAdapter;
import com.whmnrc.qiangbizhong.base.adapter.BaseViewHolder;
import com.whmnrc.qiangbizhong.model.bean.HomePageBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/6.
 */

public class MenuAdapter extends BaseAdapter<HomePageBean.MenuBean> {

    private int width;
    private int type;

    public MenuAdapter(Context context,int type) {
        super(context);
        if (type == 1) {
            width = (ScreenUtils.getScreenWidth() - 130) / 5;
        }
        this.type = type;
    }

    public void setOpen(boolean isOpen,List<HomePageBean.MenuBean> datas){
        if (isOpen){
            addFirstDataSet(datas);
        }else {
            List<HomePageBean.MenuBean> list = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                list.add(datas.get(i));
            }
            addFirstDataSet(list);
        }
    }

    @Override
    protected void bindDataToItemView(BaseViewHolder holder, HomePageBean.MenuBean item, int position) {
        holder.setImageResource(R.id.iv_img,item.getResId()).setText(R.id.tv_text,item.getText());
        if (type == 1){
            ImageView imageView = holder.getView(R.id.iv_img);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) imageView.getLayoutParams();
            layoutParams.width = width;
            imageView.setLayoutParams(layoutParams);
//            imageView.setPadding(13,imageView.getPaddingTop(),13,imageView.getPaddingTop());
        }
    }

    @Override
    protected int getItemViewLayoutId(int position, HomePageBean.MenuBean item) {
        return R.layout.item_menu;
    }
}
