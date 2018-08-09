package com.whmnrc.qiangbizhong.util;

import android.Manifest;
import android.app.Activity;

import com.blankj.utilcode.util.SizeUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.permissions.RxPermissions;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/8/2.
 */

public class ImageUtil {

    public static void img(Activity activity){
        RxPermissions rxPermissions = new RxPermissions(activity);
        rxPermissions
                .request(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .subscribe(granted -> {
                    if (granted) {
                        PictureSelector.create(activity)
                                .openGallery(PictureMimeType.ofImage())
                                .maxSelectNum(3)
                                .imageSpanCount(4)
                                .withAspectRatio(1,1)
                                .enableCrop(true)// 是否裁剪 true or false
                                .circleDimmedLayer(false)
                                .showCropFrame(true)
                                .cropWH(SizeUtils.dp2px(100),SizeUtils.dp2px(100))
                                .showCropGrid(false)
                                .compress(true)
                                .cropCompressQuality(10)
                                .previewImage(true)
                                .forResult(PictureConfig.CHOOSE_REQUEST);
                    } else {
                        ToastUtils.showShort("未开启读写权限，请开启读写");
                    }
                });
    }

    public static void img1(Activity activity){
        RxPermissions rxPermissions = new RxPermissions(activity);
        rxPermissions
                .request(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .subscribe(granted -> {
                    if (granted) {
                        PictureSelector.create(activity)
                                .openGallery(PictureMimeType.ofImage())
                                .maxSelectNum(1)
                                .imageSpanCount(4)
                                .withAspectRatio(16,10)
                                .enableCrop(true)// 是否裁剪 true or false
                                .circleDimmedLayer(false)
                                .showCropFrame(true)
                                .showCropGrid(false)
                                .compress(true)
                                .cropCompressQuality(50)
                                .previewImage(true)
                                .forResult(PictureConfig.CHOOSE_REQUEST);
                    } else {
                        ToastUtils.showShort("未开启读写权限，请开启读写");
                    }
                });
    }

    public static void img1Goods(Activity activity){
        RxPermissions rxPermissions = new RxPermissions(activity);
        rxPermissions
                .request(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .subscribe(granted -> {
                    if (granted) {
                        PictureSelector.create(activity)
                                .openGallery(PictureMimeType.ofImage())
                                .maxSelectNum(1)
                                .imageSpanCount(4)
                                .withAspectRatio(1,1)
                                .enableCrop(true)// 是否裁剪 true or false
                                .circleDimmedLayer(false)
                                .showCropFrame(true)
                                .showCropGrid(false)
                                .compress(true)
                                .cropCompressQuality(50)
                                .previewImage(true)
                                .forResult(PictureConfig.CHOOSE_REQUEST);
                    } else {
                        ToastUtils.showShort("未开启读写权限，请开启读写");
                    }
                });
    }


    public static void img1GoodsBanner(Activity activity){
        RxPermissions rxPermissions = new RxPermissions(activity);
        rxPermissions
                .request(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .subscribe(granted -> {
                    if (granted) {
                        PictureSelector.create(activity)
                                .openGallery(PictureMimeType.ofImage())
                                .maxSelectNum(9)
                                .imageSpanCount(4)
                                .withAspectRatio(375,200)
                                .enableCrop(true)// 是否裁剪 true or false
                                .circleDimmedLayer(false)
                                .showCropFrame(true)
                                .showCropGrid(false)
                                .compress(true)
                                .cropCompressQuality(50)
                                .previewImage(true)
                                .forResult(PictureConfig.CHOOSE_REQUEST);
                    } else {
                        ToastUtils.showShort("未开启读写权限，请开启读写");
                    }
                });
    }
}
