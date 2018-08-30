package com.whmnrc.qiangbizhong.ui.me.activity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.PhoneUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.luck.picture.lib.permissions.RxPermissions;
import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseActivity;
import com.whmnrc.qiangbizhong.presenter.yimei.NewsPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/23.
 * 意见反馈
 */

public class OpinionBackActivity extends BaseActivity implements NewsPresenter.FeedbackCall {

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_menu)
    TextView tvMenu;
    @BindView(R.id.et_content)
    EditText etContent;
    @BindView(R.id.tv_count)
    TextView tvCount;

    private NewsPresenter newsPresenter;

    private TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if (s.toString().length() <= 20) {
                tvCount.setText("（" + count + "/20）");
            }
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    public static void start(Context context) {
        Intent starter = new Intent(context, OpinionBackActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected int setLayout() {
        return R.layout.activity_opinion_back;
    }

    @Override
    protected void setData() {
        ivBack.setVisibility(View.VISIBLE);
        tvTitle.setText("建议反馈");
        tvMenu.setVisibility(View.VISIBLE);
        tvMenu.setText("提交");
        etContent.addTextChangedListener(textWatcher);
        newsPresenter = new NewsPresenter(this);
    }


    @OnClick({R.id.iv_back, R.id.tv_menu,R.id.tv_cs_1})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                this.finish();
                break;
            case R.id.tv_menu:
                if (TextUtils.isEmpty(etContent.getText().toString())) {
                    ToastUtils.showShort("请填写反馈意见");
                    return;
                }
                showLoading("提交中..");
                //提交
                newsPresenter.feedback(etContent.getText().toString(), this);
                break;
            case R.id.tv_cs_1:
                RxPermissions rxPermissions = new RxPermissions(this);
                rxPermissions
                        .request(Manifest.permission.CALL_PHONE)
                        .subscribe(granted -> {
                            callPhone("027-87898381");
                        });

                break;
//            case R.id.tv_cs_2:
//                RxPermissions rxPermissions1 = new RxPermissions(this);
//                rxPermissions1
//                        .request(Manifest.permission.CALL_PHONE)
//                        .subscribe(granted -> {
//                            callPhone("4001089086");
//                        });

//                break;
        }
    }

    @SuppressLint("MissingPermission")
    public void callPhone(String phoneNum) {
        Intent intent = new Intent(Intent.ACTION_CALL);
        Uri data = Uri.parse("tel:" + phoneNum);
        intent.setData(data);
        startActivity(intent);
    }

    @Override
    public void error() {

    }

    @Override
    public void feedBack() {
        this.finish();
    }

}
