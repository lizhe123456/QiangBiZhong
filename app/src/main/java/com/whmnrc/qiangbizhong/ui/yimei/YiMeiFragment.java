package com.whmnrc.qiangbizhong.ui.yimei;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseFragment;
import com.whmnrc.qiangbizhong.model.bean.HomePageBean;
import com.whmnrc.qiangbizhong.model.bean.YiMeiBean;
import com.whmnrc.qiangbizhong.ui.home.adapter.MenuAdapter;
import com.whmnrc.qiangbizhong.ui.shop.activity.SearchGoodsActivity;
import com.whmnrc.qiangbizhong.ui.yimei.adpter.YiMeiGoodsAdapter;
import com.youth.banner.Banner;
import java.util.List;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/6.
 */

public class YiMeiFragment extends BaseFragment {


    @BindView(R.id.rv_menu)
    RecyclerView rvMenu;
    @BindView(R.id.rv_goods)
    RecyclerView rvGoods;
    @BindView(R.id.banner)
    Banner bannerView;
    @BindView(R.id.tv_open)
    TextView tvOpen;

    private boolean isOpen = false;
    private List<HomePageBean.MenuBean> menuBeans;
    private MenuAdapter menuAdapter;

    public static YiMeiFragment newInstance() {
        Bundle args = new Bundle();
        YiMeiFragment fragment = new YiMeiFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_yimei;
    }

    @Override
    protected void initData() {
        YiMeiBean yiMeiBean = new YiMeiBean();
        yiMeiBean.initYiMei();
        initBanner(yiMeiBean.getBanners());
        initMenu(yiMeiBean.getMenuBeans());
        menuBeans = yiMeiBean.getMenuBeans();
        initGoodsList(yiMeiBean.getGoodsLists());
    }

    private void initGoodsList(List<YiMeiBean.GoodsList> goodsLists) {
        YiMeiGoodsAdapter yiMeiGoodsAdapter = new YiMeiGoodsAdapter(getContext());
        rvGoods.setLayoutManager(new LinearLayoutManager(getContext()));
        rvGoods.setAdapter(yiMeiGoodsAdapter);
        yiMeiGoodsAdapter.addFirstDataSet(goodsLists);
    }

    private void initMenu(List<HomePageBean.MenuBean> menuBeans) {
        menuAdapter = new MenuAdapter(getContext(),1);
        rvMenu.setAdapter(menuAdapter);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(mContext,5);
        gridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvMenu.setLayoutManager(gridLayoutManager);
        menuAdapter.setOpen(isOpen,menuBeans);

    }

    private void initBanner(List<String> banners) {
        bannerView.setImages(banners);
        bannerView.start();
    }


    @OnClick({R.id.ll_search,R.id.fl_open})
    public void onViewClicked(View view) {
        switch (view.getId()){
            case R.id.ll_search:
                SearchGoodsActivity.start(mContext);
                break;
            case R.id.fl_open:
                if (isOpen){
                    isOpen = false;
                    menuAdapter.setOpen(isOpen,menuBeans);
                    Drawable drawableLeft = getResources().getDrawable(
                            R.drawable.ic_open);
                    tvOpen.setText(getString(R.string.open));
                    tvOpen.setCompoundDrawablesWithIntrinsicBounds(null,null,drawableLeft ,null );
                    tvOpen.setCompoundDrawablePadding(20);
                }else {
                    isOpen = true;
                    menuAdapter.setOpen(isOpen,menuBeans);
                    Drawable drawableLeft = getResources().getDrawable(
                            R.drawable.ic_take_up);
                    tvOpen.setText(getString(R.string.take_up));
                    tvOpen.setCompoundDrawablesWithIntrinsicBounds(null,null,drawableLeft ,null);
                    tvOpen.setCompoundDrawablePadding(20);
                }
                break;
        }
    }

}
