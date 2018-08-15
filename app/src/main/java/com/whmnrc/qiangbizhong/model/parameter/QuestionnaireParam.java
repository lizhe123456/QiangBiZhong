package com.whmnrc.qiangbizhong.model.parameter;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/8/15.
 */

public class QuestionnaireParam {


    /**
     * RecordId : string
     * QuestionId : string
     * QuestionValue : string
     * User_Mobile : string
     * CreateDate : 2018-08-15T08:56:44.848Z
     */

    private String RecordId;
    private String QuestionId;
    private String QuestionValue;
    private String User_Mobile;
    private String CreateDate;

    public String getRecordId() {
        return RecordId;
    }

    public void setRecordId(String RecordId) {
        this.RecordId = RecordId;
    }

    public String getQuestionId() {
        return QuestionId;
    }

    public void setQuestionId(String QuestionId) {
        this.QuestionId = QuestionId;
    }

    public String getQuestionValue() {
        return QuestionValue;
    }

    public void setQuestionValue(String QuestionValue) {
        this.QuestionValue = QuestionValue;
    }

    public String getUser_Mobile() {
        return User_Mobile;
    }

    public void setUser_Mobile(String User_Mobile) {
        this.User_Mobile = User_Mobile;
    }

    public String getCreateDate() {
        return CreateDate;
    }

    public void setCreateDate(String CreateDate) {
        this.CreateDate = CreateDate;
    }
}
