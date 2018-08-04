package com.whmnrc.qiangbizhong.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.view.View;

import com.alibaba.fastjson.JSON;
import com.luck.picture.lib.photoview.PhotoView;
import com.luck.picture.lib.photoview.PhotoViewAttacher;
import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseActivity;
import com.whmnrc.qiangbizhong.ui.adpter.PhotoAdapter;
import com.whmnrc.qiangbizhong.widget.MyViewPage;


import java.util.List;

import butterknife.BindView;


/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/5/8.
 * 图片查看
 */

public class PhotoCatActivity extends BaseActivity {

    @BindView(R.id.view_pager)
    MyViewPage mViewPager;
    @BindView(R.id.pager_view)
    PhotoView pagerView;
    private PhotoAdapter adapter;
    private int currentPosition;
    PhotoViewAttacher mAttacher;




    public void start(Context context, String json, int currentPosition) {
        Intent starter = new Intent(context, PhotoCatActivity.class);
        starter.putExtra("json", json);
        starter.putExtra("position", currentPosition);
        context.startActivity(starter);
//        overridePendingTransition(R.anim.anim_in,R.anim.anim_out);
    }

    public static void start(Context context, byte[] bitmap) {
        Intent starter = new Intent(context, PhotoCatActivity.class);
        starter.putExtra("img", bitmap);
        context.startActivity(starter);
    }

    @Override
    protected int setLayout() {
        return R.layout.activity_cat_photo;
    }


    @Override
    protected void setData() {
        if (TextUtils.isEmpty(getIntent().getStringExtra("json"))) {
            pagerView.setVisibility(View.VISIBLE);
            byte [] bis = getIntent().getByteArrayExtra("img");
            Bitmap bitmap = BitmapFactory.decodeByteArray(bis, 0, bis.length);
            mAttacher = new PhotoViewAttacher(pagerView);
            pagerView.setImageBitmap(bitmap);
            mAttacher.update();
        } else {
            List<String> imgList = JSON.parseArray(getIntent().getStringExtra("json"), String.class);
            currentPosition = getIntent().getIntExtra("position", 0);
            adapter = new PhotoAdapter(imgList, this);
            mViewPager.setAdapter(adapter);
            mViewPager.setCurrentItem(currentPosition, false);
        }
    }


}
