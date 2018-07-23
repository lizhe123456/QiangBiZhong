package com.whmnrc.qiangbizhong.ui.me.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseActivity;
import com.whmnrc.qiangbizhong.ui.me.fragment.order.goods.AllGoodsFragment;
import com.whmnrc.qiangbizhong.ui.me.fragment.order.goods.ShoppingGoodsFragment;
import com.whmnrc.qiangbizhong.ui.me.fragment.order.goods.UndercarriageFragment;
import com.whmnrc.qiangbizhong.util.ViewPagerUtil;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/23.
 * 商品管理
 */

public class GoodsManageActivity extends BaseActivity {

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_menu)
    TextView tvMenu;
    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.vp_content)
    ViewPager vpContent;

    @Override
    protected int setLayout() {
        return R.layout.activity_goods_manage;
    }

    @Override
    protected void setData() {
        tvTitle.setText("商品管理");
        tvMenu.setVisibility(View.VISIBLE);
        tvMenu.setText("全部下架");
        SparseArray<Fragment> fragments = new SparseArray<>();
        SparseArray<String> title = new SparseArray<>();
        title.append(0,"所有商品");
        title.append(1,"上架商品");
        title.append(2,"下架商品");
        fragments.append(0, AllGoodsFragment.newInstance());
        fragments.append(1, ShoppingGoodsFragment.newInstance());
        fragments.append(2, UndercarriageFragment.newInstance());
        ViewPagerUtil.initViewPage(vpContent,tabLayout,this,fragments,title,20,0);
    }


    @OnClick({R.id.iv_back, R.id.tv_menu})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                this.finish();
                break;
            case R.id.tv_menu:
                //全部下架
                break;
        }
    }
}
