package com.whmnrc.qiangbizhong.ui.me.activity;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.blankj.utilcode.util.SizeUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.permissions.RxPermissions;
import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseActivity;
import com.whmnrc.qiangbizhong.model.bean.LoginBean;
import com.whmnrc.qiangbizhong.presenter.me.UserPresenter;
import com.whmnrc.qiangbizhong.util.GlideuUtil;
import com.whmnrc.qiangbizhong.util.UserManage;
import com.whmnrc.qiangbizhong.widget.RoundedImageView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/10.
 */

public class UserInfoActivity extends BaseActivity {

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.iv_menu)
    ImageView ivMenu;
    @BindView(R.id.tv_menu)
    TextView tvMenu;
    @BindView(R.id.iv_img)
    RoundedImageView ivImg;
    @BindView(R.id.tv_username)
    TextView tvUsername;
    @BindView(R.id.tv_update_img)
    TextView tvUpdateImg;
    @BindView(R.id.tv_update_pass)
    TextView tvUpdatePass;
    @BindView(R.id.tv_login)
    TextView tvLogin;
    @BindView(R.id.et_nickName)
    EditText etNickName;

    UserPresenter userPresenter;

    public static void start(Context context) {
        Intent starter = new Intent(context, UserInfoActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected int setLayout() {
        return R.layout.activity_user_info;
    }

    @Override
    protected void setData() {
        tvTitle.setText("设置");
        ivBack.setVisibility(View.VISIBLE);
        userPresenter = new UserPresenter(this);
        LoginBean loginBean = UserManage.getInstance().getLoginBean();
        GlideuUtil.loadImageView(this,loginBean.getUserInfo_HeadImg(),ivImg);
        tvUsername.setText(loginBean.getUserInfo_NickName());
        UserManage.getInstance().getUserInfo(new UserManage.UserInfoCall() {
            @Override
            public void userInfoBack(LoginBean loginBean) {

            }
        });

//        etNickName.addTextChangedListener(new TextWatcher() {
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                //输入的内容变化的监听
//                if (s.toString().equals())
//            }
//
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count,
//                                          int after) {
//                // 输入前的监听
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//                // 输入后的监听
//
//            }
//        });
    }


    @OnClick({R.id.iv_img,R.id.iv_back,R.id.tv_update_img, R.id.tv_update_pass, R.id.tv_login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_img:
                RxPermissions rxPermissions = new RxPermissions(this);
                rxPermissions
                        .request(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                        .subscribe(granted -> {
                            if (granted) {
                                PictureSelector.create(this)
                                        .openGallery(PictureMimeType.ofImage())
                                        .maxSelectNum(1)
                                        .imageSpanCount(4)
                                        .withAspectRatio(1,1)
                                        .enableCrop(true)// 是否裁剪 true or false
                                        .circleDimmedLayer(false)
                                        .showCropFrame(true)
                                        .cropWH(SizeUtils.dp2px(90),SizeUtils.dp2px(90))
                                        .showCropGrid(false)
                                        .compress(true)
                                        .cropCompressQuality(50)
                                        .previewImage(true)
                                        .forResult(PictureConfig.CHOOSE_REQUEST);
                            } else {
                                ToastUtils.showShort("未开启读写权限，请开启读写");
                            }
                        });
                break;
            case R.id.iv_back:
                this.finish();
                break;
            case R.id.tv_update_img:
                break;
            case R.id.tv_update_pass:
                break;
            case R.id.tv_login:
                //退出登录
                UserManage.getInstance().layout();
                this.finish();
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case PictureConfig.CHOOSE_REQUEST:
                    List<LocalMedia> selectList = PictureSelector.obtainMultipleResult(data);
                    String path = selectList.get(0).getCompressPath();
                    GlideuUtil.loadImageView(this, path, ivImg);
//                    mPresenter.updateHeadImg(selectList.get(0).getPath());
                    userPresenter.updateHead(path);
                    break;

            }
        }
    }


}
