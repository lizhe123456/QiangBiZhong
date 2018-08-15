package com.whmnrc.qiangbizhong.ui.me.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
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

public class OpinionBackActivity extends BaseActivity implements NewsPresenter.FeedbackCall{

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
            if (s.toString().length() <= 20){
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


    @OnClick({R.id.iv_back, R.id.tv_menu})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                this.finish();
                break;
            case R.id.tv_menu:
                if (TextUtils.isEmpty(etContent.getText().toString())){
                    ToastUtils.showShort("请填写反馈意见");
                    return;
                }
                showLoading("提交中..");
                //提交
                newsPresenter.feedback(etContent.getText().toString(),this);
                break;
        }
    }

    @Override
    public void error() {

    }

    @Override
    public void feedBack() {
        this.finish();
    }
}
