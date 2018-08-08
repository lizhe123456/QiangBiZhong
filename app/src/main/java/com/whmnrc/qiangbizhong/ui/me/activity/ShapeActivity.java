package com.whmnrc.qiangbizhong.ui.me.activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Base64;
import android.widget.ImageView;
import android.widget.TextView;

import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseActivity;
import com.whmnrc.qiangbizhong.model.bean.LoginBean;
import com.whmnrc.qiangbizhong.presenter.me.ShapePresenter;
import com.whmnrc.qiangbizhong.util.GlideuUtil;
import com.whmnrc.qiangbizhong.util.UserManage;
import com.whmnrc.qiangbizhong.widget.RoundedImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/8/8.
 */

public class ShapeActivity extends BaseActivity implements ShapePresenter.CodeCall{

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.ic_scode)
    ImageView icScode;
    @BindView(R.id.iv_head)
    RoundedImageView ivHead;
    @BindView(R.id.tv_nick_name)
    TextView tvNickName;


    ShapePresenter shapePresenter;

    @Override
    protected int setLayout() {
        return R.layout.activity_shape;
    }

    @Override
    protected void setData() {
        shapePresenter = new ShapePresenter(this);
        shapePresenter.getshardcode(this);
        LoginBean loginBean = UserManage.getInstance().getLoginBean();
        if (loginBean != null) {
            GlideuUtil.loadImageView(this, loginBean.getUserInfo_HeadImg(), ivHead);
            tvNickName.setText(loginBean.getUserInfo_NickName());
        }
    }


    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        this.finish();
    }

    @Override
    public void error() {

    }

    @Override
    public void code(String code) {
        icScode.setImageBitmap(sendImage(code));
    }

    public Bitmap sendImage(String bmMsg){
        byte [] input = Base64.decode(bmMsg, Base64.DEFAULT);
        Bitmap bitmap = BitmapFactory.decodeByteArray(input, 0, input.length);
        return bitmap;
    }
}
