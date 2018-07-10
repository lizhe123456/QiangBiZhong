package com.whmnrc.qiangbizhong.base;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/10.
 */

public class BaseResponse<T> {


    /**
     * Message : 手机号和密码不匹配
     * Status : 0
     * Result : null
     */

    private String Message;
    private int Status;
    private T Result;

    public String getMessage() {
        return Message;
    }

    public void setMessage(String Message) {
        this.Message = Message;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int Status) {
        this.Status = Status;
    }

    public T getResult() {
        return Result;
    }

    public void setResult(T Result) {
        this.Result = Result;
    }
}
