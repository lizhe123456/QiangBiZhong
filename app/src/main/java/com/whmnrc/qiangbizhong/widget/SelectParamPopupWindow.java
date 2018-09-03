package com.whmnrc.qiangbizhong.widget;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.blankj.utilcode.util.ScreenUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.adapter.BaseAdapter;
import com.whmnrc.qiangbizhong.base.adapter.BaseViewHolder;
import com.whmnrc.qiangbizhong.model.bean.SpecBean;
import com.whmnrc.qiangbizhong.ui.shop.bean.OrderBeanReq;
import com.whmnrc.qiangbizhong.util.GlideuUtil;
import com.whmnrc.qiangbizhong.util.StringUtil;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ctrun on 2017/7/29.
 */

public class SelectParamPopupWindow extends PopupWindow {

    private View mRealContentLayout;

    private ArrayList<SpecBean.ItemsBean.SpecItemsBean> list;

    private TextView textSpec;
    private TextView textPrice;
    private SpceAdapter spceAdapter2;

    private String goodsId;
    private String priceId;
    private int count = 1;

    @SuppressLint("SetTextI18n")
    public SelectParamPopupWindow(final Activity activity, SpecBean specBean,int type) {
        super(activity.getLayoutInflater().inflate(R.layout.popup_select_param, null), ScreenUtils.getScreenWidth(), ScreenUtils.getScreenHeight());
        getContentView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        goodsId = specBean.getGoodsInfo().getGoods_ID();
        list = new ArrayList();
        for (SpecBean.ItemsBean itemsBean : specBean.getItems()) {
            list.add(new SpecBean.ItemsBean.SpecItemsBean(itemsBean.getSpecName()));
        }
        mRealContentLayout = getContentView().findViewById(R.id.realContentLayout);
        mRealContentLayout.setVisibility(View.INVISIBLE);
        RelativeLayout relativeLayout = mRealContentLayout.findViewById(R.id.rl_count);
        RecyclerView recyclerView = mRealContentLayout.findViewById(R.id.rv_list1);
        RecyclerView recyclerView2 = mRealContentLayout.findViewById(R.id.rv_list2);
        SpceAdapter spceAdapter = new SpceAdapter(activity,0);
        spceAdapter2 = new SpceAdapter(activity,1);

        GridLayoutManager gridLayoutManager1 = new GridLayoutManager(activity,4);
        recyclerView.setLayoutManager(gridLayoutManager1);
        recyclerView.setAdapter(spceAdapter);
        spceAdapter.setOnItemClickListener((view, item, position) -> {
            spceAdapter.setSelect(position);
            spceAdapter2.addFirstDataSet(specBean.getItems().get(position).getSpecItems());
            if (specBean.getItems().get(position).getSpecItems().size() > 0) {
                if (specBean.getItems().get(position).getSpecItems().get(0).getGoodsPrice_Stock() > 0) {
                    spceAdapter2.setSelect(0);
                    textPrice.setText(StringUtil.wanString(specBean.getItems().get(position).getSpecItems().get(0).getGoodsPrice_Price()));
                    textSpec.setText("已选 " + specBean.getItems().get(position).getSpecItems().get(0).getGoodsPrice_AttrName() + " " + specBean.getItems().get(position).getSpecItems().get(0).getGoodsPrice_SpecName());
                    priceId = specBean.getItems().get(position).getSpecItems().get(0).getGoodsPrice_ID();
                }
            }
        });

        spceAdapter.addFirstDataSet(list);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(activity,3);
        recyclerView2.setLayoutManager(gridLayoutManager);
        recyclerView2.setAdapter(spceAdapter2);
        spceAdapter2.setOnItemClickListener((view, item, position) -> {
            SpecBean.ItemsBean.SpecItemsBean specItemsBean = (SpecBean.ItemsBean.SpecItemsBean) item;
            if (specItemsBean.getGoodsPrice_Stock() > 0) {
                spceAdapter2.setSelect(position);
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).getGoodsPrice_AttrName().equals(specItemsBean.getGoodsPrice_SpecName())) {
                        spceAdapter.setSelect(i);
                        break;
                    }
                }
                priceId = specItemsBean.getGoodsPrice_ID();
                textPrice.setText(StringUtil.wanString(specItemsBean.getGoodsPrice_Price()));
                textSpec.setText("已选 " + specItemsBean.getGoodsPrice_AttrName() + " " + specItemsBean.getGoodsPrice_SpecName());
            }
        });
        if (specBean.getItems().size() > 0) {
            spceAdapter2.addFirstDataSet(specBean.getItems().get(0).getSpecItems());
        }

        GlideuUtil.loadImageView(activity, specBean.getGoodsInfo().getGoods_ImaPath(), mRealContentLayout.findViewById(R.id.iv_image));
        textPrice = mRealContentLayout.findViewById(R.id.tv_price);
        if (specBean.getGoodsInfo().getGoods_PriceMin() == specBean.getGoodsInfo().getGoods_PriceMax()) {
            textPrice.setText(StringUtil.wanString(specBean.getGoodsInfo().getGoods_PriceMin()));
        }else {
            textPrice.setText(StringUtil.wanString(specBean.getGoodsInfo().getGoods_PriceMin()) + "~" + StringUtil.wanString(specBean.getGoodsInfo().getGoods_PriceMax()));
        }
        textSpec = mRealContentLayout.findViewById(R.id.tv_spec);
        textSpec.setText("已选");

        if (type == 0){
            mRealContentLayout.findViewById(R.id.tv_add_car).setVisibility(View.GONE);
            TextView textView = mRealContentLayout.findViewById(R.id.tv_buy);
            textView.setText("确认");
            relativeLayout.setVisibility(View.GONE);
        }

        TextView tvCount = mRealContentLayout.findViewById(R.id.tv_count);

        mRealContentLayout.findViewById(R.id.tv_jian).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (count > 1){
                    count -= 1;
                    tvCount.setText(String.valueOf(count));
                }
            }
        });

        mRealContentLayout.findViewById(R.id.tv_jia).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count += 1;
                tvCount.setText(String.valueOf(count));
            }
        });

        mRealContentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        mRealContentLayout.findViewById(R.id.iv_close).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        mRealContentLayout.findViewById(R.id.tv_add_car).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null){
                    if (TextUtils.isEmpty(goodsId)){
                        return;
                    }
                    if (TextUtils.isEmpty(priceId)){
                        ToastUtils.showShort("请选择商品规格");
                        return;
                    }
                    dismiss();
                    mListener.onAddCar(goodsId,priceId,count);
                }
            }
        });

        mRealContentLayout.findViewById(R.id.tv_buy).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null){
                    if (TextUtils.isEmpty(goodsId)){
                        return;
                    }
                    if (TextUtils.isEmpty(priceId)){
                        ToastUtils.showShort("请选择商品规格");
                        return;
                    }
                    dismiss();
                    OrderBeanReq orderBeanReq = new OrderBeanReq(textSpec.getText().toString(),priceId,goodsId,textPrice.getText().toString(),specBean.getGoodsInfo(),count);
                    mListener.onBuy(orderBeanReq);
                }
            }
        });

        setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        setOutsideTouchable(true);
        setTouchable(true);
        setFocusable(true);
        //sdk > 21 解决 标题栏没有办法遮罩的问题
        setClippingEnabled(false);
//        setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
    }

    public void showPop(View parent,Activity activity) {
        if (isShowing() || getContentView() == null) {
            return;
        }

        showAtLocation(parent, Gravity.BOTTOM, 0, getNavigationBarHeight(activity));

        mRealContentLayout.setVisibility(View.VISIBLE);
        Animation inAnimation = AnimationUtils.loadAnimation(getContentView().getContext(), R.anim.slide_in_bottom);
        mRealContentLayout.startAnimation(inAnimation);
    }

    /**
     * 按返回键的时候会调用这个方法
     * 所以这里重写该方法，主要是解决按返回键也具有动画效果
     */
    @Override
    public void dismiss() {
        if (!isShowing()) {
            return;
        }

        mRealContentLayout.setVisibility(View.VISIBLE);
        Animation outAnimation = AnimationUtils.loadAnimation(getContentView().getContext(), R.anim.slide_out_bottom);
        outAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                SelectParamPopupWindow.super.dismiss();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        mRealContentLayout.startAnimation(outAnimation);
        if (mListener != null) {
            mListener.onCancel();
        }
    }

    private OnCancelListener mListener;

    public void setOnCancelListener(OnCancelListener listener) {
        mListener = listener;
    }

    public interface OnCancelListener {
        void onCancel();

        void onBuy(OrderBeanReq orderBeanReq);

        void onAddCar(String goodsId, String priceId,int count);

    }


    class SpceAdapter extends BaseAdapter<SpecBean.ItemsBean.SpecItemsBean> {
        private int type;

        private SpceAdapter(Context context,int type) {
            super(context);
            this.type = type;
        }


        public void setSelect(int position) {
            for (SpecBean.ItemsBean.SpecItemsBean item : getDataSource()) {
                item.setSelect(false);
            }
            getDataSource().get(position).setSelect(true);
            notifyDataSetChanged();
        }

        @Override
        protected void bindDataToItemView(BaseViewHolder holder, SpecBean.ItemsBean.SpecItemsBean item, int position) {
            TextView textView = holder.getView(R.id.tv_spec);
            textView.setBackgroundResource(R.drawable.bg_spec);
            if (type == 0){
                textView.setText(item.getGoodsPrice_AttrName());
                if (item.isSelect()) {
                    textView.setSelected(true);
                    textView.setTextColor(getContext().getResources().getColor(R.color.goods_price));
                } else {
                    textView.setSelected(false);
                    textView.setTextColor(getContext().getResources().getColor(R.color.tv_777));
                }
            }else {
                textView.setText(item.getGoodsPrice_AttrName());
                if (item.isSelect()) {
                    textView.setSelected(true);
                    textView.setTextColor(getContext().getResources().getColor(R.color.goods_price));
                } else {
                    textView.setSelected(false);
                    if (item.getGoodsPrice_Stock() > 0) {
                        textView.setTextColor(getContext().getResources().getColor(R.color.tv_777));
                    }else {
                        textView.setBackgroundResource(R.drawable.bu_sort_bg);
                        textView.setTextColor(getContext().getResources().getColor(R.color.tv_999));
                    }
                }
            }


        }

        @Override
        protected int getItemViewLayoutId(int position, SpecBean.ItemsBean.SpecItemsBean item) {
            return R.layout.item_spce;
        }
    }


    /**
     * 设置页面的透明度
     *
     * @param bgAlpha 1表示不透明
     */
    public static void setBackgroundAlpha(Activity activity, float bgAlpha) {
        WindowManager.LayoutParams lp = activity.getWindow().getAttributes();
        lp.alpha = bgAlpha;
        if (bgAlpha == 1) {
            //不移除该Flag的话,在有视频的页面上的视频会出现黑屏的bug
            activity.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        } else {
            //此行代码主要是解决在华为手机上半透明效果无效的bug
            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        }

        activity.getWindow().setAttributes(lp);
    }


    public static int getNavigationBarHeight(Activity activity) {
        if (hasSoftKeys(activity.getWindowManager())) {
            Resources resources = activity.getResources();
            int resourceId = resources.getIdentifier("navigation_bar_height",
                    "dimen", "android");
            //获取NavigationBar的高度
            int height = resources.getDimensionPixelSize(resourceId);
            return height;
        }
        return 0;
    }

    /**
     * 判断底部navigator是否已经显示
     * @param windowManager
     * @return
     */
    private static boolean hasSoftKeys(WindowManager windowManager){
        Display d = windowManager.getDefaultDisplay();


        DisplayMetrics realDisplayMetrics = new DisplayMetrics();
        d.getRealMetrics(realDisplayMetrics);


        int realHeight = realDisplayMetrics.heightPixels;
        int realWidth = realDisplayMetrics.widthPixels;


        DisplayMetrics displayMetrics = new DisplayMetrics();
        d.getMetrics(displayMetrics);


        int displayHeight = displayMetrics.heightPixels;
        int displayWidth = displayMetrics.widthPixels;


        return (realWidth - displayWidth) > 0 || (realHeight - displayHeight) > 0;
    }

    /**
     * 获取底部虚拟键盘的高度
     */
    public int getBottomKeyboardHeight(Activity context){
        int screenHeight =  getAccurateScreenDpi(context)[1];
        DisplayMetrics dm = new DisplayMetrics();
        context.getWindowManager().getDefaultDisplay().getMetrics(dm);
        int heightDifference = screenHeight - dm.heightPixels;
        return heightDifference;
    }


    /**
     * 获取精确的屏幕大小
     */
    public int[] getAccurateScreenDpi(Activity context) {
        int[] screenWH = new int[2];
        Display display = context.getWindowManager().getDefaultDisplay();
        DisplayMetrics dm = new DisplayMetrics();
        try {
            Class<?> c = Class.forName("android.view.Display");
            Method method = c.getMethod("getRealMetrics",DisplayMetrics.class);
            method.invoke(display, dm);
            screenWH[0] = dm.widthPixels;
            screenWH[1] = dm.heightPixels;
        }catch(Exception e){
            e.printStackTrace();
        }
        return screenWH;
    }




}
