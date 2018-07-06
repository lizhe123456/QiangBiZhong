package com.whmnrc.qiangbizhong.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.whmnrc.qiangbizhong.R;


/**
 * author：lizhe
 * time： 2017/8/25.
 * 类介绍：Glideu 图片加载封装类
 */

public class GlideuUtil {

    private static RequestOptions options = new RequestOptions()
            .placeholder(R.drawable.ic_launcher)
            .error(R.drawable.ic_launcher);

    private static RequestOptions options1 = new RequestOptions()
            .placeholder(R.drawable.ic_launcher)
            .error(R.drawable.ic_launcher);

    private static RequestOptions options2 = new RequestOptions()
            .placeholder(R.drawable.ic_launcher)
            .error(R.drawable.ic_launcher);

    //默认加载
    public static void loadImageView(Context mContext, String path, ImageView mImageView) {
        Glide.with(mContext).load(path).apply(options).into(mImageView);
    }


    @SuppressLint("CheckResult")
    public static void loadImageViewNoCache(Context mContext, String path, ImageView mImageView) {
        RequestOptions requestOptions = options2.override(200, 200).skipMemoryCache(true);
        requestOptions.diskCacheStrategy(DiskCacheStrategy.RESOURCE);
        Glide.with(mContext).asDrawable().load(path).apply(requestOptions).into(mImageView);
    }

    @SuppressLint("CheckResult")
    public static void loadImageViewBanner(Context mContext, String path, ImageView mImageView) {
        RequestOptions requestOptions = options2.override(400, 400).skipMemoryCache(true);
        requestOptions.diskCacheStrategy(DiskCacheStrategy.RESOURCE);
        Glide.with(mContext).load(path).apply(requestOptions).into(mImageView);
    }


    /**
     * 会先加载缩略图
     */

    //设置缩略图支持
    public static void loadImageViewThumbnail(Context mContext, String path, ImageView mImageView) {
        Glide.with(mContext).load(path).thumbnail(0.1f).into(mImageView);
    }


    //清理磁盘缓存
    public static void GuideClearDiskCache(Context mContext) {
        //理磁盘缓存 需要在子线程中执行
        Glide.get(mContext).clearDiskCache();
    }

    //清理内存缓存
    public static void GuideClearMemory(Context mContext) {
        //清理内存缓存  可以在UI主线程中进行
        Glide.get(mContext).clearMemory();
    }



    //原图 -> 圆图
    public static void loadCropCircle(Context mContext, String path, ImageView mImageView){
        Glide.with(mContext).load(path).into(mImageView);
    }

    public static void loadCircle(Context mContext, String path, ImageView mImageView){
        Glide.with(mContext).load(path).apply(options).into(mImageView);
    }

}
