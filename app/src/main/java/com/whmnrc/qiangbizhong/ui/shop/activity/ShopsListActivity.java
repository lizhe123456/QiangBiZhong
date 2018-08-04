package com.whmnrc.qiangbizhong.ui.shop.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewStub;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.blankj.utilcode.util.KeyboardUtils;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseActivity;
import com.whmnrc.qiangbizhong.base.adapter.BaseAdapter;
import com.whmnrc.qiangbizhong.model.bean.StroeBean;
import com.whmnrc.qiangbizhong.presenter.me.CollectionPresenter;
import com.whmnrc.qiangbizhong.presenter.shop.ShopPresenter;
import com.whmnrc.qiangbizhong.ui.shop.adapter.ShopsListAdapter;
import com.whmnrc.qiangbizhong.util.GlideuUtil;
import com.whmnrc.qiangbizhong.widget.RoundedImageView;
import java.util.List;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/8/2.
 * 店铺详情
 */

public class ShopsListActivity extends BaseActivity implements ShopPresenter.StoreDeailCall,TextView.OnEditorActionListener,CollectionPresenter.CollectionCall{

    @BindView(R.id.iv_img)
    ImageView ivImg;
    @BindView(R.id.ll_search)
    LinearLayout llSearch;
    @BindView(R.id.iv_img1)
    RoundedImageView ivImg1;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_address)
    TextView tvAddress;
    @BindView(R.id.tv_collection)
    TextView tvCollection;
    @BindView(R.id.tv_shop_desc)
    TextView tvShopDesc;
    @BindView(R.id.rl_sort)
    RelativeLayout rlSort;
    @BindView(R.id.tv_item1)
    TextView tvItem1;
    @BindView(R.id.view_item1)
    View viewItem1;
    @BindView(R.id.ll_item1)
    LinearLayout llItem1;
    @BindView(R.id.tv_item2)
    TextView tvItem2;
    @BindView(R.id.view_item2)
    View viewItem2;
    @BindView(R.id.ll_item2)
    LinearLayout llItem2;
    @BindView(R.id.tv_item3)
    TextView tvItem3;
    @BindView(R.id.view_item3)
    View viewItem3;
    @BindView(R.id.ll_item3)
    LinearLayout llItem3;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.refresh)
    SmartRefreshLayout refresh;
    @BindView(R.id.vs_empty)
    ViewStub vsEmpty;
    @BindView(R.id.et_keyword)
    EditText etKeyword;


    private ShopPresenter mShopPresenter;
    private ShopsListAdapter shopListAdapter;
    private int type;
    private String sid;
    private boolean isCollection;
    private CollectionPresenter collectionPresenter;
    private StroeBean.ResultBean stroeBean;
    public static void start(Context context,String sid) {
        Intent starter = new Intent(context, ShopsListActivity.class);
        starter.putExtra("sid",sid);
        context.startActivity(starter);
    }

    @Override
    protected int setLayout() {
        return R.layout.activity_shops_list;
    }

    @Override
    protected void setData() {
        sid = getIntent().getStringExtra("sid");
        mShopPresenter = new ShopPresenter(this);
        collectionPresenter = new CollectionPresenter(this);
        type = 0;
        req();
        shopListAdapter = new ShopsListAdapter(this);
        recyclerView.setAdapter(shopListAdapter);
        GridLayoutManager gridLayoutManager  = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(gridLayoutManager);

        shopListAdapter.setOnItemClickListener(new BaseAdapter.OnItemClickListener() {
            @Override
            public void onClick(View view, Object item, int position) {
                StroeBean.ResultBean.GoodsBean goodsBean = (StroeBean.ResultBean.GoodsBean) item;
                ShopDetailsActivity.start(ShopsListActivity.this,goodsBean.getGoods_ID());
            }
        });

        refresh.setOnLoadMoreListener(refreshLayout -> mShopPresenter.getshoppingstoredetail(etKeyword.getText().toString(),sid, type, false, ShopsListActivity.this));

        refresh.setOnRefreshListener(refreshLayout -> req());

        etKeyword.setOnEditorActionListener(this);

        tvCollection.setSelected(true);
    }


    @OnClick({R.id.iv_img, R.id.ll_item1, R.id.ll_item2, R.id.ll_item3,R.id.tv_collection})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_img:
                this.finish();
                break;
            case R.id.ll_item1:
                type = 0;
                req();
                break;
            case R.id.ll_item2:
                type = 1;
                req();
                break;
            case R.id.ll_item3:
                type = 2;
                req();
                break;
            case R.id.tv_collection:
                if (isCollection){
                    isCollection = false;
                    tvCollection.setSelected(true);
                    tvCollection.setText("收藏");
                    Drawable nav_up=getResources().getDrawable(R.drawable.ic_white_coll);
                    nav_up.setBounds(0, 0, nav_up.getMinimumWidth(), nav_up.getMinimumHeight());
                    tvCollection.setCompoundDrawables(nav_up,null,null,null);
                    collectionPresenter.cannercollection(1,stroeBean.getStoreInfo().getId(),this);
                }else {
                    isCollection = true;
                    tvCollection.setSelected(false);
                    tvCollection.setText("已收藏");
                    tvCollection.setCompoundDrawables(null,null,null,null);
                    collectionPresenter.addcollection(0,stroeBean.getStoreInfo().getId(),1,this);
                }
                break;
        }
    }

    private void req(){
        tvItem1.setTextColor(getResources().getColor(R.color.tv_191));
        tvItem2.setTextColor(getResources().getColor(R.color.tv_191));
        tvItem3.setTextColor(getResources().getColor(R.color.tv_191));
        viewItem1.setVisibility(View.INVISIBLE);
        viewItem2.setVisibility(View.INVISIBLE);
        viewItem3.setVisibility(View.INVISIBLE);
        switch (type) {
            case 0:
                viewItem1.setVisibility(View.VISIBLE);
                tvItem1.setTextColor(getResources().getColor(R.color.colorAccent));
                break;
            case 1:
                viewItem2.setVisibility(View.VISIBLE);
                tvItem2.setTextColor(getResources().getColor(R.color.colorAccent));
                break;
            case 2:
                viewItem3.setVisibility(View.VISIBLE);
                tvItem3.setTextColor(getResources().getColor(R.color.colorAccent));
                break;
        }
        if (mShopPresenter != null) {
            showLoading("加载中..");
            mShopPresenter.getshoppingstoredetail(etKeyword.getText().toString(),sid, type, true, this);
        }
    }

    @Override
    public void error() {
        refresh.finishLoadMore(false);
        refresh.finishRefresh(false);
    }

    @Override
    public void storeDeail(@NonNull StroeBean.ResultBean stroeBean) {
        this.stroeBean = stroeBean;
        if (stroeBean.getGoods().size() == 0){
            showEmpty();
        }else {
            vsEmpty.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);
        }
        shopListAdapter.addFirstDataSet(stroeBean.getGoods());
        GlideuUtil.loadImageView(this,stroeBean.getStoreInfo().getStoreHeadImage(),ivImg1);
        tvName.setText(stroeBean.getStoreInfo().getStoreName());
        tvAddress.setText("销量："+stroeBean.getStoreInfo().getStatus());
        tvShopDesc.setText(stroeBean.getStoreInfo().getExplain());
        if (stroeBean.getStoreIsCollection() == 0){
            isCollection = false;
            tvCollection.setSelected(true);
            tvCollection.setText("收藏");
            Drawable nav_up=getResources().getDrawable(R.drawable.ic_white_coll);
            nav_up.setBounds(0, 0, nav_up.getMinimumWidth(), nav_up.getMinimumHeight());
            tvCollection.setCompoundDrawables(nav_up,null,null,null);
        }else {
            isCollection = true;
            tvCollection.setSelected(false);
            tvCollection.setText("已收藏");
            tvCollection.setCompoundDrawables(null,null,null,null);
        }
        refresh.finishRefresh(true);
    }

    @Override
    public void loadMore(List<StroeBean.ResultBean.GoodsBean> goodsBeans) {
        shopListAdapter.addMoreDataSet(goodsBeans);
        refresh.finishLoadMore(true);
    }

    public void showEmpty() {
        if (vsEmpty.getParent() != null) {
            View view = vsEmpty.inflate();
            ImageView imageView = view.findViewById(R.id.iv_empty);
            TextView textView = view.findViewById(R.id.tv_text);
            imageView.setImageResource(R.drawable.ic_empty_search);
            textView.setText("暂无更多订单~");
            textView.setVisibility(View.GONE);
            vsEmpty.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.GONE);
        }
    }

    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        if (actionId == EditorInfo.IME_ACTION_SEARCH) {
            // 当按了搜索之后关闭软键盘
            req();
            KeyboardUtils.hideSoftInput(this);
            return true;
        }
        return false;
    }

    @Override
    public void cS() {

    }
}
