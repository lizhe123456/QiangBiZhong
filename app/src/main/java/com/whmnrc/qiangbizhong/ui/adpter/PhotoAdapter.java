package com.whmnrc.qiangbizhong.ui.adpter;

import android.app.Activity;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.luck.picture.lib.photoview.OnPhotoTapListener;
import com.luck.picture.lib.photoview.PhotoView;
import com.luck.picture.lib.photoview.PhotoViewAttacher;
import com.whmnrc.qiangbizhong.R;

import java.util.List;


/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/5/8.
 */

public class PhotoAdapter extends PagerAdapter {
    public static final String TAG = PhotoAdapter.class.getSimpleName();
    private List<String> imageUrls;
    private Activity activity;

    public PhotoAdapter(List<String> imageUrls, Activity activity) {
        this.imageUrls = imageUrls;
        this.activity = activity;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        String url = imageUrls.get(position);
        PhotoView photoView = new PhotoView(activity);

        Glide.with(activity)
                .load(url)
                .apply(new RequestOptions().placeholder(R.drawable.img_error))
                .into(photoView);


        photoView.setOnPhotoTapListener(new OnPhotoTapListener() {
            @Override
            public void onPhotoTap(ImageView imageView, float v, float v1) {
                activity.finish();
//                activity.overridePendingTransition(R.anim.anim_in,R.anim.anim_out);
            }


        });
        container.addView(photoView);

        return photoView;
    }

    @Override
    public int getCount() {
        return imageUrls != null ? imageUrls.size() : 0;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }

}
