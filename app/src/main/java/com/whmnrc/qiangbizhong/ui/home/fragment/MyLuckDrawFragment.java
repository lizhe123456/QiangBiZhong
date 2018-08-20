package com.whmnrc.qiangbizhong.ui.home.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseFragment;
import com.whmnrc.qiangbizhong.base.adapter.BaseAdapter;
import com.whmnrc.qiangbizhong.model.bean.HomeResult;
import com.whmnrc.qiangbizhong.model.bean.MyLuckDrawBean;
import com.whmnrc.qiangbizhong.presenter.home.LuckDrawPresenter;
import com.whmnrc.qiangbizhong.ui.home.activity.AwardDetailActivity;
import com.whmnrc.qiangbizhong.ui.home.adapter.MyLuckDrawAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/9.
 */

public class MyLuckDrawFragment extends BaseFragment implements LuckDrawPresenter.MyLuckDrawCall {


    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.ll_title)
    RelativeLayout llTitle;
    @BindView(R.id.v_divider)
    View vDivider;
    @BindView(R.id.ll_all_title)
    LinearLayout llAllTitle;
    @BindView(R.id.iv_img)
    ImageView ivImg;
    @BindView(R.id.rv_list)
    RecyclerView rvList;
    @BindView(R.id.vs_empty)
    ViewStub vsEmpty;
    @BindView(R.id.refresh)
    SmartRefreshLayout refresh;

    private LuckDrawPresenter luckDrawPresenter;

    private MyLuckDrawAdapter myLuckDrawAdapter;

    public static MyLuckDrawFragment newInstance() {
        Bundle args = new Bundle();
        MyLuckDrawFragment fragment = new MyLuckDrawFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_my_luck_draw;
    }

    @Override
    protected void initData() {
        ivBack.setVisibility(View.VISIBLE);
        tvTitle.setText("我的奖品");
        luckDrawPresenter = new LuckDrawPresenter(mContext);
        showLoading("加载中..");
        luckDrawPresenter.awardlist(this,true);
        myLuckDrawAdapter = new MyLuckDrawAdapter(mContext);
        rvList.setLayoutManager(new LinearLayoutManager(mContext));
        rvList.setAdapter(myLuckDrawAdapter);
        rvList.setNestedScrollingEnabled(false);

        refresh.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshLayout) {
                luckDrawPresenter.awardlist(MyLuckDrawFragment.this,true);
            }
        });

        refresh.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(RefreshLayout refreshLayout) {
                luckDrawPresenter.awardlist(MyLuckDrawFragment.this,false);
            }
        });

        myLuckDrawAdapter.setOnItemClickListener(new BaseAdapter.OnItemClickListener() {
            @Override
            public void onClick(View view, Object item, int position) {
                MyLuckDrawBean goodsNewAwardBean = (MyLuckDrawBean) item;
                AwardDetailActivity.start(mContext, goodsNewAwardBean.getGoodsAwardId());
            }
        });
    }


    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        getActivity().finish();
    }

    @Override
    public void error() {
        refresh.finishRefresh(false);
        refresh.finishLoadMore(false);
    }

    @Override
    public void myLuckDraw(List<MyLuckDrawBean> myLuckDrawBeans) {
        if (myLuckDrawBeans.size() == 0){
            showEmpty();
            rvList.setVisibility(View.GONE);
        }else {
            if (vsEmpty.getParent() == null) {
                vsEmpty.setVisibility(View.GONE);
            }
            rvList.setVisibility(View.VISIBLE);
        }
        myLuckDrawAdapter.addFirstDataSet(myLuckDrawBeans);
        refresh.finishRefresh(true);
    }

    @Override
    public void loadMore(List<MyLuckDrawBean> myLuckDrawBeans) {
        myLuckDrawAdapter.addMoreDataSet(myLuckDrawBeans);
        refresh.finishLoadMore(true);
    }

    public void showEmpty() {
        if (vsEmpty.getParent() != null) {
            View view = vsEmpty.inflate();
            ImageView imageView = view.findViewById(R.id.iv_empty);
            TextView textView = view.findViewById(R.id.tv_text);
            imageView.setImageResource(R.drawable.ic_empty_public);
            textView.setText("暂无更多数据~");
            vsEmpty.setVisibility(View.VISIBLE);
            rvList.setVisibility(View.GONE);
        }
    }

}
