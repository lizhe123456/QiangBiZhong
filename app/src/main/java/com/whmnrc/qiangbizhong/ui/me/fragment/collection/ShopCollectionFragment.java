package com.whmnrc.qiangbizhong.ui.me.fragment.collection;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;

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
import com.whmnrc.qiangbizhong.ui.shop.activity.ShopsListActivity;

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

public class ShopCollectionFragment extends BaseFragment implements CollectionPresenter.CollectionListCall,CollectionPresenter.CollectionCall{

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.refresh)
    SmartRefreshLayout refresh;
    @BindView(R.id.vs_empty)
    ViewStub vsEmpty;

    public static ShopCollectionFragment newInstance() {
        Bundle args = new Bundle();
        ShopCollectionFragment fragment = new ShopCollectionFragment();
        fragment.setArguments(args);
        return fragment;
    }

    private boolean isEdit;
    private boolean isAll;
    private ShopCollectionAdapter shopCollectionAdapter;
    private CollectionPresenter collectionPresenter;

    @Override
    protected int setLayout() {
        return R.layout.fragment_shop_collection;
    }

    @Override
    protected void initData() {
        shopCollectionAdapter = new ShopCollectionAdapter(getContext());
        recyclerView.setAdapter(shopCollectionAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        collectionPresenter = new CollectionPresenter(getActivity());
        showLoading("加载中..");
        collectionPresenter.getcollectionlist(1,true,this);

        refresh.setOnLoadMoreListener(refreshLayout -> collectionPresenter.getcollectionlist(1, false, this));

        refresh.setOnRefreshListener(refreshLayout ->collectionPresenter.getcollectionlist(1, true, this));

        shopCollectionAdapter.setOnItemClickListener(new BaseAdapter.OnItemClickListener() {
            @Override
            public void onClick(View view, Object item, int position) {
                CollectionBean collectionBean = (CollectionBean) item;
                ShopsListActivity.start(getContext(),collectionBean.getStoreId());
            }
        });
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void mycoll(MyCollectionActivity.EventCollectionBean eventCollectionBean) {
        if (eventCollectionBean.getCollection() == 0) {
            //非编辑模式
            isEdit = false;
            shopCollectionAdapter.setEdit(isEdit);
        } else if (eventCollectionBean.getCollection() == 1) {
            //编辑模式
            isEdit = true;
            shopCollectionAdapter.setEdit(isEdit);
        } else if (eventCollectionBean.getCollection() == 4) {
            //全选

            if (isAll) {
                isAll = false;
                shopCollectionAdapter.setAll(false);
            }else {
                isAll = true;
                shopCollectionAdapter.setAll(true);
            }

        } else if (eventCollectionBean.getCollection() == 5) {
            //删除
            List<String> collectionBeans = new ArrayList<>();
            for (CollectionBean collectionBean : shopCollectionAdapter.getDataSource()) {
                if (collectionBean.isSelect()) {
                    collectionBeans.add(collectionBean.getStoreId());
                }
            }
            if (collectionBeans.size() > 0) {
                collectionPresenter.cannercollectionlist(collectionBeans, 1, this);
            } else {
                ToastUtils.showShort("未选中任何商品");
            }
        }
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
        shopCollectionAdapter.addFirstDataSet(collectionBeans);
        refresh.finishRefresh(true);
    }

    @Override
    public void loadMore(List<CollectionBean> collectionBeans) {
        shopCollectionAdapter.addMoreDataSet(collectionBeans);
        refresh.finishLoadMore(true);
    }

    @Override
    public void cS() {
        collectionPresenter.getcollectionlist(1, true, this);
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


    class ShopCollectionAdapter extends BaseAdapter<CollectionBean> {

        private boolean isEdit;

        private boolean isAll;

        public boolean isAll() {
            return isAll;
        }

        public void setAll(boolean all) {
            isAll = all;
            allSelect(isAll);
        }

        public void setEdit(boolean edit) {
            isEdit = edit;
            notifyDataSetChanged();
        }

        public void allSelect(boolean isSelect) {
            if (isAll) {
                isAll = false;
            } else {
                isAll = true;
            }
            for (CollectionBean collectionBean : getDataSource()) {
                collectionBean.setSelect(isSelect);
            }
            notifyDataSetChanged();
        }

        public ShopCollectionAdapter(Context context) {
            super(context);
        }

        @Override
        protected void bindDataToItemView(BaseViewHolder holder, CollectionBean item, int position) {
            holder.setGlieuImage(R.id.iv_img1, item.getStoreHeadImage())
                    .setText(R.id.tv_name, item.getStoreName())
                    .setText(R.id.tv_address, item.getAddress())
                    .setText(R.id.tv_shop_desc, item.getExplain());

            if (isEdit) {
                holder.setVisible(R.id.iv_select, true);
            } else {
                holder.setVisible(R.id.iv_select, false);
            }

            if (item.isSelect()) {
                holder.setImageResource(R.id.iv_select, R.drawable.ic_select);
            } else {
                holder.setImageResource(R.id.iv_select, R.drawable.ic_selece_no);
            }


            holder.setOnClickListener(R.id.iv_select, new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (item.isSelect()) {
                        item.setSelect(false);
                        holder.setImageResource(R.id.iv_select, R.drawable.ic_selece_no);
                    } else {
                        item.setSelect(true);
                        holder.setImageResource(R.id.iv_select, R.drawable.ic_select);
                    }

//                    boolean flag = false;
//
//                    for (CollectionBean item :getDataSource()) {
//                        if (item.isSelect()){
//                            flag = true;
//                        }else {
//                            flag = false;
//                            break;
//                        }
//                    }
//
//                    if (flag){
//                        EventBus.getDefault().post(new CollIsAll(2));
//                    }else {
//                        EventBus.getDefault().post(new CollIsAll(3));
//                    }
                }
            });
        }

        @Override
        protected int getItemViewLayoutId(int position, CollectionBean item) {
            return R.layout.item_shop_collection;
        }
    }
}
