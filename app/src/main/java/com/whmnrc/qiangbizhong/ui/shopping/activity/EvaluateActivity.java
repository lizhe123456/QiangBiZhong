package com.whmnrc.qiangbizhong.ui.shopping.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.blankj.utilcode.util.ToastUtils;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.entity.LocalMedia;
import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseActivity;
import com.whmnrc.qiangbizhong.base.adapter.BaseAdapter;
import com.whmnrc.qiangbizhong.base.adapter.BaseViewHolder;
import com.whmnrc.qiangbizhong.model.bean.OrderListBean;
import com.whmnrc.qiangbizhong.presenter.me.EvaluatePresenter;
import com.whmnrc.qiangbizhong.presenter.shop.ImagePresenter;
import com.whmnrc.qiangbizhong.ui.shop.adapter.ImageAdapter;
import com.whmnrc.qiangbizhong.ui.shopping.activity.param.EvaluateParam;
import com.whmnrc.qiangbizhong.ui.shopping.activity.param.ImgCall;
import com.whmnrc.qiangbizhong.util.GsonUtil;
import com.whmnrc.qiangbizhong.util.ImageUtil;
import com.whmnrc.qiangbizhong.util.UserManage;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/23.
 */

public class EvaluateActivity extends BaseActivity implements ImagePresenter.ImageCall,EvaluatePresenter.EvaluateCallBack{


    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_menu)
    TextView tvMenu;
    @BindView(R.id.rv_comment_list)
    RecyclerView rvCommentList;


    private OrderListBean orderListBean;
    private ImagePresenter imagePresenter;
    private EvaluatePresenter mEvaluatePresenter;
    private int imgIndex;
    private TCommentAdapter tCommentAdapter;
    private List<String> selectList;

    public static void start(Fragment context, OrderListBean orderListBean) {
        Intent starter = new Intent(context.getContext(), EvaluateActivity.class);
        starter.putExtra("orderListBean", GsonUtil.createGsonString(orderListBean));
        context.startActivityForResult(starter,101);
    }

    public static void start(Activity context, OrderListBean orderListBean) {
        Intent starter = new Intent(context, EvaluateActivity.class);
        starter.putExtra("orderListBean", GsonUtil.createGsonString(orderListBean));
        context.startActivityForResult(starter,101);
    }

    @Override
    protected int setLayout() {
        return R.layout.activity_evaluate;
    }

    @Override
    protected void setData() {
        ivBack.setVisibility(View.VISIBLE);
        tvTitle.setText("发表评价");
        tvMenu.setText("发表");
        tvMenu.setVisibility(View.VISIBLE);
        orderListBean = GsonUtil.changeGsonToBean(getIntent().getStringExtra("orderListBean"),OrderListBean.class);
        imagePresenter = new ImagePresenter(this);
        mEvaluatePresenter = new EvaluatePresenter(this);
        rvCommentList.setLayoutManager(new LinearLayoutManager(this));
        tCommentAdapter = new TCommentAdapter(this);
        rvCommentList.setAdapter(tCommentAdapter);
        tCommentAdapter.addFirstDataSet(orderListBean.getDetail());

        tCommentAdapter.setImgCall(new ImgCall() {
            @Override
            public void index(int findex, int sindex) {
                imgIndex = findex;
                ImageUtil.img(EvaluateActivity.this);
            }
        });
    }

    @OnClick({R.id.iv_back,R.id.tv_menu})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                this.finish();
                break;
            case R.id.tv_menu:
                release();
                break;

        }
    }

    private void release() {
        List<EvaluateParam> list = new ArrayList<>();

        for (OrderListBean.DetailBean detailBean :tCommentAdapter.getDataSource()) {
            EvaluateParam evaluateParam = new EvaluateParam();
            evaluateParam.setGoods_ID(detailBean.getProduct_ID());
            evaluateParam.setGoodsPrice_ID(detailBean.getSpecAttr_ID());
            evaluateParam.setOrder_ID(detailBean.getOrder_ID());
            List<String> list1  = new ArrayList<>();
            for (int i = 0; i < detailBean.getList().size(); i++) {
                if (detailBean.getList().get(i).equals("")){
                }else {
                    list1.add(detailBean.getList().get(i));
                }
            }
            evaluateParam.setImageContext(list1);
            evaluateParam.setTextContext(detailBean.getComment());
            evaluateParam.setUserId(UserManage.getInstance().getUserID());
            list.add(evaluateParam);
        }

        boolean flag = true;
        for (EvaluateParam evaluateParam : list) {
            if (TextUtils.isEmpty(evaluateParam.getTextContext())){
                flag = false;
            }
        }

        if (flag){
            showLoading("提交中..");
            mEvaluatePresenter.evaluate(list,this);
        }else {
            ToastUtils.showShort("至少评论一条");
        }



    }

    @Override
    public void error() {

    }

    @Override
    public void img(List<String> list) {
        tCommentAdapter.updateImg(imgIndex,list);
    }

    @Override
    public void evaluateS() {
        setResult(102);
        this.finish();
    }

    public class TCommentAdapter extends BaseAdapter<OrderListBean.DetailBean>{

        private ImgCall imgCall;

        public TCommentAdapter(Context context) {
            super(context);
        }

        public void setImgCall(ImgCall imgCall) {
            this.imgCall = imgCall;
        }

        public void updateImg(int index, List<String> list){

            getDataSource().get(index).setSelectList(selectList);
            getDataSource().get(index).setList(list);
            notifyItemChanged(index);
        }

        @Override
        protected void bindDataToItemView(BaseViewHolder holder, OrderListBean.DetailBean item, int position) {
            holder.setText(R.id.tv_goods_name,item.getProduct_Name()).setGlieuImage(R.id.iv_img,item.getProduct_ImgPath());
            EditText editText = holder.getView(R.id.et_comment);
            editText.setText(item.getComment());
            if(item.getComment() != null){
                editText.setSelection(item.getComment().length());
            }
            int index = position;
            editText.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                }

                @Override
                public void afterTextChanged(Editable s) {
                    item.setComment(editText.getText().toString());
                }
            });

            RecyclerView recyclerView = holder.getView(R.id.rv_add_img);
            recyclerView.setLayoutManager(new GridLayoutManager(getContext(),3));
            ImageAdapter imageAdapter = new ImageAdapter(getContext(),0);
            imageAdapter.setOnImgDelete(new ImageAdapter.OnImgDelete() {
                @Override
                public void delete(int position1) {
                    item.getSelectList().remove(position1);

                    if (!selectList.contains("")) {
                        item.getSelectList().add("");
                    }
                    item.getList().remove(position1);
                    notifyItemChanged(position);
                }
            });
            recyclerView.setAdapter(imageAdapter);
            if (item.getSelectList() == null) {
                imageAdapter.addFirstDataSet(item.getList());
            }else {
                imageAdapter.addFirstDataSet(item.getSelectList());
            }
            imageAdapter.setOnItemClickListener(new OnItemClickListener() {
                @Override
                public void onClick(View view, Object item, int position) {
                    if (imgCall != null){
                        imgCall.index(index,position);
                    }

                }
            });
        }

        @Override
        protected int getItemViewLayoutId(int position, OrderListBean.DetailBean item) {
            return R.layout.item_t_comment_list;
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case PictureConfig.CHOOSE_REQUEST:
                    List<LocalMedia> imgs = PictureSelector.obtainMultipleResult(data);
                    selectList = new ArrayList<>();
                    for (LocalMedia localMedia :imgs) {
                        selectList.add(localMedia.getCompressPath());
                    }
                    if (selectList.size() > 0) {
                        showLoading("上传中..");
                        imagePresenter.uploadfile(selectList,this);
                    }
                    break;
            }
        }
    }


}
