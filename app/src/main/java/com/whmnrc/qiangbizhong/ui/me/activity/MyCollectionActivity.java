package com.whmnrc.qiangbizhong.ui.me.activity;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseActivity;
import com.whmnrc.qiangbizhong.ui.me.fragment.collection.GoodsCollectionFragment;
import com.whmnrc.qiangbizhong.ui.me.fragment.collection.ShopCollectionFragment;
import com.whmnrc.qiangbizhong.util.ViewPagerUtil;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/23.
 */

public class MyCollectionActivity extends BaseActivity {


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

    public static void start(Context context) {
        Intent starter = new Intent(context, MyCollectionActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected int setLayout() {
        return R.layout.activity_my_collection;
    }

    @Override
    protected void setData() {
        ivBack.setVisibility(View.VISIBLE);
        tvMenu.setText("编辑");
        tvMenu.setVisibility(View.VISIBLE);
        SparseArray<String> title = new SparseArray<>();
        SparseArray<Fragment> fragments = new SparseArray<>();
        title.append(0,"商品收藏");
        title.append(1,"店铺收藏");
        fragments.append(0, GoodsCollectionFragment.newInstance());
        fragments.append(1, ShopCollectionFragment.newInstance());
        ViewPagerUtil.initViewPage(vpContent,tabLayout,this,fragments,title,100,0);
    }

    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        this.finish();
    }
}
