package com.whmnrc.qiangbizhong.ui.shop.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewStub;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.blankj.utilcode.util.KeyboardUtils;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseActivity;
import com.whmnrc.qiangbizhong.base.adapter.BaseAdapter;
import com.whmnrc.qiangbizhong.model.bean.ShopBean;
import com.whmnrc.qiangbizhong.model.bean.ShopGoodsBean;
import com.whmnrc.qiangbizhong.model.bean.YiMeiGoodsBean;
import com.whmnrc.qiangbizhong.presenter.shop.ShopPresenter;
import com.whmnrc.qiangbizhong.ui.shop.adapter.ShopListAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/20.
 */

public class SearchGoodsActivity extends BaseActivity implements ShopPresenter.ShopSearchListCall,TextView.OnEditorActionListener{


    @BindView(R.id.tv_item1)
    TextView tvItem1;
    @BindView(R.id.view_item1)
    View viewItem1;
    @BindView(R.id.tv_item2)
    TextView tvItem2;
    @BindView(R.id.view_item2)
    View viewItem2;
    @BindView(R.id.tv_item3)
    TextView tvItem3;
    @BindView(R.id.view_item3)
    View viewItem3;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.refresh)
    SmartRefreshLayout refresh;
    @BindView(R.id.vs_empty)
    ViewStub vsEmpty;
    @BindView(R.id.et_keyword)
    EditText etKeyword;

    //请求类型
    private int type;

    private ShopPresenter shopPresenter;
    private ShopListAdapter shopListAdapter;
    private String productTypeId;

    public static void start(Context context,String productTypeId) {
        Intent starter = new Intent(context, SearchGoodsActivity.class);
        starter.putExtra("productTypeId",productTypeId);
        context.startActivity(starter);
    }

    @Override
    protected int setLayout() {
        return R.layout.activity_search_goods;
    }

    @Override
    protected void setData() {
        shopPresenter = new ShopPresenter(this);
        productTypeId = getIntent().getStringExtra("productTypeId");
        req(1);
        shopListAdapter = new ShopListAdapter(this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(shopListAdapter);
        etKeyword.setOnEditorActionListener(this);

        shopListAdapter.setOnItemClickListener((view, item, position) -> {
            ShopGoodsBean shopGoodsBean = (ShopGoodsBean) item;
            ShopDetailsActivity.start(SearchGoodsActivity.this,shopGoodsBean.getGoods_ID());
        });
        refresh.setOnRefreshListener(refreshLayout -> {
            shopPresenter.goodssearchlist(productTypeId,etKeyword.getText().toString(), type, true, this);
        });
        refresh.setOnLoadMoreListener(refreshLayout -> {
            shopPresenter.goodssearchlist(productTypeId,etKeyword.getText().toString(), type, false, this);
        });
    }


    @OnClick({R.id.iv_img, R.id.ll_item1, R.id.ll_item2, R.id.ll_item3})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_img:
                this.finish();
                break;
            case R.id.ll_item1:
                //综合
                req(1);
                break;
            case R.id.ll_item2:
                //销量
                req(2);
                break;
            case R.id.ll_item3:
                //价格
                req(3);
                break;
        }
    }

    private void req(int i) {
        tvItem1.setTextColor(getResources().getColor(R.color.tv_191));
        tvItem2.setTextColor(getResources().getColor(R.color.tv_191));
        tvItem3.setTextColor(getResources().getColor(R.color.tv_191));
        viewItem1.setVisibility(View.INVISIBLE);
        viewItem2.setVisibility(View.INVISIBLE);
        viewItem3.setVisibility(View.INVISIBLE);

        switch (i) {
            case 1:
                type = 0;
                viewItem1.setVisibility(View.VISIBLE);
                tvItem1.setTextColor(getResources().getColor(R.color.colorAccent));
                break;
            case 2:
                type = 1;
                viewItem2.setVisibility(View.VISIBLE);
                tvItem2.setTextColor(getResources().getColor(R.color.colorAccent));
                break;
            case 3:
                type = 2;
                viewItem3.setVisibility(View.VISIBLE);
                tvItem3.setTextColor(getResources().getColor(R.color.colorAccent));
                break;
        }
        showLoading("加载中..");
        shopPresenter.goodssearchlist(productTypeId,etKeyword.getText().toString(), type, true, this);
    }

    @Override
    public void error() {
        refresh.finishRefresh(false);
        refresh.finishLoadMore(false);
    }

    @Override
    public void searchList(@NonNull List<ShopGoodsBean> yiMeiGoodsBeans) {
        if (yiMeiGoodsBeans.size() == 0){
            showEmpty();
        }else {
            vsEmpty.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);
        }
        shopListAdapter.addFirstDataSet(yiMeiGoodsBeans);
        refresh.finishRefresh(true);
    }

    @Override
    public void loadMore(@NonNull List<ShopGoodsBean> yiMeiGoodsBeans) {
        shopListAdapter.addMoreDataSet(yiMeiGoodsBeans);
        refresh.finishLoadMore(true);
    }

    public void showEmpty() {
        if (vsEmpty.getParent() != null) {
            View view = vsEmpty.inflate();
            ImageView imageView = view.findViewById(R.id.iv_empty);
            TextView textView = view.findViewById(R.id.tv_text);
            imageView.setImageResource(R.drawable.ic_empty_search);
            textView.setText("暂无更多数据~");
        }
        vsEmpty.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.GONE);
    }

    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        if (actionId == EditorInfo.IME_ACTION_SEARCH) {
            // 当按了搜索之后关闭软键盘
            showLoading("加载中..");
            shopPresenter.goodssearchlist(productTypeId,etKeyword.getText().toString(), type,true, this);
            KeyboardUtils.hideSoftInput(this);
            return true;
        }
        return false;
    }
}
