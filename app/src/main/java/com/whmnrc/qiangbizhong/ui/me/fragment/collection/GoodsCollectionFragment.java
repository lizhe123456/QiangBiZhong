package com.whmnrc.qiangbizhong.ui.me.fragment.collection;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.blankj.utilcode.util.ScreenUtils;
import com.blankj.utilcode.util.SizeUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseFragment;
import com.whmnrc.qiangbizhong.base.adapter.BaseAdapter;
import com.whmnrc.qiangbizhong.base.adapter.BaseViewHolder;
import com.whmnrc.qiangbizhong.model.bean.CollectionBean;
import com.whmnrc.qiangbizhong.presenter.me.CollectionPresenter;
import com.whmnrc.qiangbizhong.ui.me.activity.CollIsAll;
import com.whmnrc.qiangbizhong.ui.me.activity.MyCollectionActivity;
import com.whmnrc.qiangbizhong.ui.shop.activity.ShopDetailsActivity;
import com.whmnrc.qiangbizhong.util.StringUtil;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/23.
 */

public class GoodsCollectionFragment extends BaseFragment implements
        CollectionPresenter.CollectionListCall,CollectionPresenter.CollectionCall{


    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.refresh)
    SmartRefreshLayout refresh;
    @BindView(R.id.vs_empty)
    ViewStub vsEmpty;

    private CollectionPresenter collectionPresenter;

    private GoodsCollectionAdapter goodsCollectionAdapter;

    private boolean isEdit;
    private boolean isAll;

    public static GoodsCollectionFragment newInstance() {
        Bundle args = new Bundle();
        GoodsCollectionFragment fragment = new GoodsCollectionFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_goods_collection;
    }

    @Override
    protected void initData() {
        collectionPresenter = new CollectionPresenter(mContext);
        showLoading("加载中..");
        collectionPresenter.getcollectionlist(0, true, this);
        goodsCollectionAdapter = new GoodsCollectionAdapter(getContext());
        recyclerView.setLayoutManager(new GridLayoutManager(mContext,2));
        recyclerView.setAdapter(goodsCollectionAdapter);
        refresh.setOnRefreshListener(refreshLayout -> collectionPresenter.getcollectionlist(0, true, GoodsCollectionFragment.this));
        refresh.setOnLoadMoreListener(refreshLayout -> collectionPresenter.getcollectionlist(0, false, GoodsCollectionFragment.this));
        goodsCollectionAdapter.setOnItemClickListener(new BaseAdapter.OnItemClickListener() {
            @Override
            public void onClick(View view, Object item, int position) {
                CollectionBean collectionBean = (CollectionBean) item;
                ShopDetailsActivity.start(mContext,collectionBean.getGoods_ID());
            }
        });
    }

    @Override
    public void error() {
        refresh.finishRefresh(false);
        refresh.finishLoadMore(false);
    }

    @Override
    public void collectionList(List<CollectionBean> collectionBeans) {
        if (collectionBeans.size() == 0){
            showEmpty();
        }else {
            vsEmpty.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);
        }
        goodsCollectionAdapter.addFirstDataSet(collectionBeans);
        refresh.finishRefresh(true);
    }

    @Override
    public void loadMore(List<CollectionBean> collectionBeans) {
        goodsCollectionAdapter.addMoreDataSet(collectionBeans);
        refresh.finishLoadMore(true);
    }



    @Subscribe(threadMode = ThreadMode.MAIN)
    public void mycoll(MyCollectionActivity.EventCollectionBean eventCollectionBean){
        if (eventCollectionBean.getCollection() == 0){
            //非编辑模式
            isEdit = false;
            goodsCollectionAdapter.setEdit(isEdit);
        }else if (eventCollectionBean.getCollection() == 1){
            //编辑模式
            isEdit = true;
            goodsCollectionAdapter.setEdit(isEdit);
        }else if (eventCollectionBean.getCollection() == 2){
            //全选
            if (isAll) {
                isAll = false;
                goodsCollectionAdapter.setAll(false);
            }else {
                isAll = true;
                goodsCollectionAdapter.setAll(true);
            }

        }else if (eventCollectionBean.getCollection() == 3){
            //删除
            List<String> collectionBeans = new ArrayList<>();
            for (CollectionBean collectionBean :goodsCollectionAdapter.getDataSource()) {
                if (collectionBean.isSelect()){
                    collectionBeans.add(collectionBean.getGoods_ID());
                }
            }
            if (collectionBeans.size() > 0) {
                collectionPresenter.cannercollectionlist(collectionBeans, 0, this);
            }else {
                ToastUtils.showShort("未选中任何商品");
            }
        }
    }

    public void showEmpty() {
        if (vsEmpty.getParent() != null) {
            View view = vsEmpty.inflate();
            ImageView imageView = view.findViewById(R.id.iv_empty);
            TextView textView = view.findViewById(R.id.tv_text);
            textView.setVisibility(View.GONE);
            imageView.setImageResource(R.drawable.ic_empty_collection);
//            textView.setText("暂无更多订单~");
        }
        vsEmpty.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.GONE);
    }

    @Override
    public void cS() {
        collectionPresenter.getcollectionlist(0, true, GoodsCollectionFragment.this);
    }

    public class GoodsCollectionAdapter extends BaseAdapter<CollectionBean>{

        private int width;

        private boolean isEdit;

        private boolean isAll;


        public boolean isAll() {
            return isAll;
        }

        public void setAll(boolean all) {
            isAll = all;
            allSelect(isAll);
        }

        private GoodsCollectionAdapter(Context context) {
            super(context);
            width =  ((ScreenUtils.getScreenWidth() - SizeUtils.dp2px(40)) / 2);
        }

        public void setEdit(boolean edit) {
            isEdit = edit;
            notifyDataSetChanged();
        }

        public void allSelect(boolean isSelect){
            if (isAll){
                isAll = false;
            }else {
                isAll = true;
            }
            for (CollectionBean collectionBean : getDataSource()) {
                collectionBean.setSelect(isSelect);
            }
            notifyDataSetChanged();
        }

        @Override
        protected void bindDataToItemView(BaseViewHolder holder, CollectionBean item, int position) {
            holder.setText(R.id.tv_price, StringUtil.wanString(item.getGoods_PriceMin())).setText(R.id.tv_goods_name,item.getGoods_Name()).setGlieuImage(R.id.iv_img,item.getGoods_ImaPath());
            ImageView imageView = holder.getView(R.id.iv_img);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) imageView.getLayoutParams();
            layoutParams.width = width;
            layoutParams.height = width;
            imageView.setLayoutParams(layoutParams);

            if (isEdit){
                holder.setVisible(R.id.iv_select,true);
            }else {
                holder.setVisible(R.id.iv_select,false);
            }

            if (item.isSelect()) {
                holder.setImageResource(R.id.iv_select, R.drawable.ic_select);
            } else {
                holder.setImageResource(R.id.iv_select, R.drawable.ic_selece_no);
            }

            holder.setOnClickListener(R.id.iv_select, new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (item.isSelect()){
                        item.setSelect(false);
                        holder.setImageResource(R.id.iv_select,R.drawable.ic_selece_no);
                    }else {
                        item.setSelect(true);
                        holder.setImageResource(R.id.iv_select,R.drawable.ic_select);
                    }

//                    boolean flag = false;
//
//                    for (CollectionBean item : getDataSource()) {
//                        if (item.isSelect()){
//                            flag = true;
//                        }else {
//                            flag = false;
//                            break;
//                        }
//                    }
//
//                    if (flag){
//                        EventBus.getDefault().post(new CollIsAll(0));
//                    }else {
//                        EventBus.getDefault().post(new CollIsAll(1));
//                    }
                }
            });
        }

        @Override
        protected int getItemViewLayoutId(int position, CollectionBean item) {
            return R.layout.item_collection_goods_list;
        }
    }

}
