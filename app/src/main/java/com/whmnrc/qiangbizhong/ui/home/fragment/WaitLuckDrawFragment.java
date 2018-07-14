package com.whmnrc.qiangbizhong.ui.home.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.blankj.utilcode.util.ScreenUtils;
import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseFragment;
import com.whmnrc.qiangbizhong.base.adapter.BaseAdapter;
import com.whmnrc.qiangbizhong.base.adapter.BaseViewHolder;
import com.whmnrc.qiangbizhong.model.bean.LuckDrawGoodsBean;
import com.whmnrc.qiangbizhong.presenter.home.LuckDrawPresenter;
import com.whmnrc.qiangbizhong.ui.shop.activity.FlashSaleDetailsActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/11.
 */

public class WaitLuckDrawFragment extends BaseFragment {


    @BindView(R.id.rv_list)
    RecyclerView rvList;

    private LuckDrawPresenter luckDrawPresenter;
    private OpenLuckDrawAdapter adapter;

    @Override
    protected int setLayout() {
        return R.layout.fragment_wait_luck_draw;
    }

    @Override
    protected void initData() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),2);
        rvList.setLayoutManager(gridLayoutManager);
        adapter = new OpenLuckDrawAdapter(mContext);
        rvList.setAdapter(adapter);
        luckDrawPresenter = new LuckDrawPresenter(mContext);
        luckDrawPresenter.awardlist2(1,this::luckDrawBack);
//        luckDrawGoodsBeans.add(new LuckDrawGoodsBean("","Eason","2018-07-11 \n" +" 16:00"));
//        luckDrawGoodsBeans.add(new LuckDrawGoodsBean("","xians","2018-07-11 \n" +" 16:00"));
//        luckDrawGoodsBeans.add(new LuckDrawGoodsBean("","xians","2018-07-12 \n" +" 15:00"));
//        luckDrawGoodsBeans.add(new LuckDrawGoodsBean("","huixnk","2018-07-13 \n" +" 15:00"));
//        adapter.addFirstDataSet(luckDrawGoodsBeans);
        adapter.setOnItemClickListener(new BaseAdapter.OnItemClickListener() {
            @Override
            public void onClick(View view, Object item, int position) {
                FlashSaleDetailsActivity.start(mContext,"");
            }
        });
    }

    private void luckDrawBack(List<LuckDrawGoodsBean> luckDrawGoodsBeans) {
        adapter.addFirstDataSet(luckDrawGoodsBeans);
    }


    class OpenLuckDrawAdapter extends BaseAdapter<LuckDrawGoodsBean> {

        private int width;

        private OpenLuckDrawAdapter(Context context) {
            super(context);
            width = ((ScreenUtils.getScreenWidth() - 45)/2);
        }

        @Override
        protected void bindDataToItemView(BaseViewHolder holder, LuckDrawGoodsBean item, int position) {
            holder.setText(R.id.tv_time,item.getAwardTime()).setText(R.id.tv_name,item.getUserNick()).setGlieuImage(R.id.iv_img,item.getProduct_ImgPath());

            ImageView imageView = holder.getView(R.id.iv_img);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) imageView.getLayoutParams();
            layoutParams.width = width;
            layoutParams.height = width;
            imageView.setLayoutParams(layoutParams);
        }

        @Override
        protected int getItemViewLayoutId(int position, LuckDrawGoodsBean item) {
            return R.layout.item_open_luch_wait;
        }
    }
}
