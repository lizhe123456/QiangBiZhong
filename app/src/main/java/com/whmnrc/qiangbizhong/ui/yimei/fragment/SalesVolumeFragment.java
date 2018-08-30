package com.whmnrc.qiangbizhong.ui.yimei.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseFragment;
import com.whmnrc.qiangbizhong.base.adapter.BaseAdapter;
import com.whmnrc.qiangbizhong.model.bean.YiMeiGoodsBean;
import com.whmnrc.qiangbizhong.model.bean.YiMeiSortBean;
import com.whmnrc.qiangbizhong.presenter.yimei.StorePresenter;
import com.whmnrc.qiangbizhong.ui.yimei.activity.YiMeiDetailsActivity;
import com.whmnrc.qiangbizhong.ui.yimei.activity.YiMeiGoodsDetailsActivity;
import com.whmnrc.qiangbizhong.ui.yimei.adpter.YiMeiSearchAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/23.
 */

public class SalesVolumeFragment extends BaseFragment implements StorePresenter.MedicalStoreCall {


    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.refresh)
    SmartRefreshLayout refresh;
    @BindView(R.id.vs_empty)
    ViewStub vsEmpty;

    private StorePresenter storePresenter;
    private double latitude;
    private double longitude;
    private String sortId;
    private String type;
    private YiMeiSearchAdapter mYiMeiSearchAdapter;


    public static SalesVolumeFragment newInstance(String sortId,String type) {
        Bundle args = new Bundle();
        args.putString("sortId",sortId);
        args.putString("type",type);
        SalesVolumeFragment fragment = new SalesVolumeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_sales_volume;
    }

    @Override
    protected void initData() {
        sortId = getArguments().getString("sortId");
        type = getArguments().getString("type");
        storePresenter = new StorePresenter(getActivity());
        latitude = ((YiMeiDetailsActivity) getActivity()).latitude;
        longitude = ((YiMeiDetailsActivity) getActivity()).longitude;
        showLoading("加载中..");
        storePresenter.getmedicalstorelist(true, sortId,type, latitude, longitude, this);
        refresh.setOnRefreshListener(refreshLayout -> storePresenter.getmedicalstorelist(true, sortId,type, latitude, longitude, this));

        refresh.setOnLoadMoreListener(refreshLayout -> storePresenter.getmedicalstorelist(false, sortId,type, latitude, longitude, this));

        mYiMeiSearchAdapter = new YiMeiSearchAdapter(mContext);
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        recyclerView.setAdapter(mYiMeiSearchAdapter);
        recyclerView.setNestedScrollingEnabled(true);

    }


    @Override
    public void error() {
        refresh.finishRefresh(false);
        refresh.finishLoadMore(false);
    }

    @Override
    public void medicalStoreBack(YiMeiSortBean yiMeiSortBean) {
        if (yiMeiSortBean.getGoods().size() == 0){
            showEmpty();
        }else {
            vsEmpty.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);
        }
        mYiMeiSearchAdapter.addFirstDataSet(yiMeiSortBean.getGoods());
        refresh.finishRefresh(true);
    }

    @Override
    public void loadMore(List<YiMeiGoodsBean> goodsBeans) {
        mYiMeiSearchAdapter.addMoreDataSet(goodsBeans);
        refresh.finishLoadMore(true);
    }

    public void showEmpty() {
        if (vsEmpty.getParent() != null) {
            View view = vsEmpty.inflate();
            ImageView imageView = view.findViewById(R.id.iv_empty);
            TextView textView = view.findViewById(R.id.tv_text);
            imageView.setImageResource(R.drawable.ic_empty_public);
            textView.setText("暂无更多数据~");
        }
        vsEmpty.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.GONE);
    }

}
