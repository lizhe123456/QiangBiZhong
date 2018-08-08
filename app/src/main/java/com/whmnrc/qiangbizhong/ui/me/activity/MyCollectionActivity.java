package com.whmnrc.qiangbizhong.ui.me.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseActivity;
import com.whmnrc.qiangbizhong.ui.me.fragment.collection.GoodsCollectionFragment;
import com.whmnrc.qiangbizhong.ui.me.fragment.collection.ShopCollectionFragment;
import com.whmnrc.qiangbizhong.util.ViewPagerUtil;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

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
    @BindView(R.id.tv_all)
    TextView tvAll;
    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.vp_content)
    ViewPager vpContent;
    @BindView(R.id.ll_edit)
    LinearLayout llEdit;
    private boolean isEdte;
    private boolean isAll1;
    private boolean isAll2;

    private int page;

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
        tvTitle.setText("我的收藏");
        SparseArray<String> title = new SparseArray<>();
        SparseArray<Fragment> fragments = new SparseArray<>();
        title.append(0, "商品收藏");
        title.append(1, "店铺收藏");
        fragments.append(0, GoodsCollectionFragment.newInstance());
        fragments.append(1, ShopCollectionFragment.newInstance());
        ViewPagerUtil.initViewPage(vpContent, tabLayout, this, fragments, title, 100, page);
        vpContent.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (page != position) {
                    page = position;
                    isEdte = false;
                    tvMenu.setText("编辑");
                    llEdit.setVisibility(View.GONE);

                    if (position == 0) {
                        if (isAll1){
                            Drawable nav_up=getResources().getDrawable(R.drawable.ic_select);
                            nav_up.setBounds(0, 0, nav_up.getMinimumWidth(), nav_up.getMinimumHeight());
                            tvAll.setCompoundDrawables(nav_up, null, null, null);
                        }else {
                            Drawable nav_up=getResources().getDrawable(R.drawable.ic_selece_no);
                            nav_up.setBounds(0, 0, nav_up.getMinimumWidth(), nav_up.getMinimumHeight());
                            tvAll.setCompoundDrawables(nav_up, null, null, null);
                        }
                    }else if (position == 1){
                        if (isAll2){
                            Drawable nav_up = getResources().getDrawable(R.drawable.ic_select);
                            nav_up.setBounds(0, 0, nav_up.getMinimumWidth(), nav_up.getMinimumHeight());
                            tvAll.setCompoundDrawables(nav_up, null, null, null);
                        }else {
                            Drawable nav_up=getResources().getDrawable(R.drawable.ic_selece_no);
                            nav_up.setBounds(0, 0, nav_up.getMinimumWidth(), nav_up.getMinimumHeight());
                            tvAll.setCompoundDrawables(nav_up, null, null, null);
                        }
                    }
                    EventBus.getDefault().post(new EventCollectionBean(0));
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void isAll(CollIsAll collIsAll){
//        if (page == 0){
//            if (collIsAll.isAll() == 0){
//                isAll1 = false;
//                Drawable nav_up=getResources().getDrawable(R.drawable.ic_selece_no);
//                nav_up.setBounds(0, 0, nav_up.getMinimumWidth(), nav_up.getMinimumHeight());
//                tvAll.setCompoundDrawables(nav_up, null, null, null);
//            }else {
//                isAll1 = true;
//                Drawable nav_up=getResources().getDrawable(R.drawable.ic_select);
//                nav_up.setBounds(0, 0, nav_up.getMinimumWidth(), nav_up.getMinimumHeight());
//                tvAll.setCompoundDrawables(nav_up, null, null, null);
//            }
//        }else if (page == 1){
//            if (collIsAll.isAll() == 2){
//                isAll2 = false;
//                Drawable nav_up = getResources().getDrawable(R.drawable.ic_selece_no);
//                nav_up.setBounds(0, 0, nav_up.getMinimumWidth(), nav_up.getMinimumHeight());
//                tvAll.setCompoundDrawables(nav_up, null, null, null);
//            }else {
//                isAll2 = true;
//                Drawable nav_up = getResources().getDrawable(R.drawable.ic_select);
//                nav_up.setBounds(0, 0, nav_up.getMinimumWidth(), nav_up.getMinimumHeight());
//                tvAll.setCompoundDrawables(nav_up, null, null, null);
//            }
//        }


    }

    @OnClick({R.id.iv_back, R.id.tv_menu,R.id.tv_all, R.id.tv_delete})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_menu:
                if (isEdte) {
                    isEdte = false;
                    tvMenu.setText("编辑");
                    EventBus.getDefault().post(new EventCollectionBean(0));
                    llEdit.setVisibility(View.GONE);
                } else {
                    isEdte = true;
                    tvMenu.setText("完成");
                    EventBus.getDefault().post(new EventCollectionBean(1));
                    llEdit.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.iv_back:
                this.finish();
                break;
            case R.id.tv_all:
                if (vpContent.getCurrentItem() == 0) {
                    if (isAll1){
                        isAll1 = false;
                        Drawable nav_up=getResources().getDrawable(R.drawable.ic_selece_no);
                        nav_up.setBounds(0, 0, nav_up.getMinimumWidth(), nav_up.getMinimumHeight());
                        tvAll.setCompoundDrawables(nav_up, null, null, null);
                    }else {
                        isAll1 = true;
                        Drawable nav_up=getResources().getDrawable(R.drawable.ic_select);
                        nav_up.setBounds(0, 0, nav_up.getMinimumWidth(), nav_up.getMinimumHeight());
                        tvAll.setCompoundDrawables(nav_up, null, null, null);
                    }
                    EventBus.getDefault().post(new EventCollectionBean(2));
                }else {
                    if (isAll2){
                        isAll2 = false;
                        Drawable nav_up = getResources().getDrawable(R.drawable.ic_selece_no);
                        nav_up.setBounds(0, 0, nav_up.getMinimumWidth(), nav_up.getMinimumHeight());
                        tvAll.setCompoundDrawables(nav_up, null, null, null);
                    }else {
                        isAll2 = true;
                        Drawable nav_up = getResources().getDrawable(R.drawable.ic_select);
                        nav_up.setBounds(0, 0, nav_up.getMinimumWidth(), nav_up.getMinimumHeight());
                        tvAll.setCompoundDrawables(nav_up, null, null, null);
                    }
                    EventBus.getDefault().post(new EventCollectionBean(4));
                }
                break;
            case R.id.tv_delete:
                if (vpContent.getCurrentItem() == 0) {
                    EventBus.getDefault().post(new EventCollectionBean(3));
                }else {
                    EventBus.getDefault().post(new EventCollectionBean(5));
                }
                break;
        }
    }

    public static class EventCollectionBean{

        int collection;

        public EventCollectionBean(int collection) {
            this.collection = collection;
        }

        public int getCollection() {
            return collection;
        }

        public void setCollection(int collection) {
            this.collection = collection;
        }
    }

}
