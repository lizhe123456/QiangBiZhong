package com.whmnrc.qiangbizhong.base;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/10.
 */

public class BaseResponse {


    private String Message;
    private int Status;
    private String Result;
    //2018-07-12 17:42:11
    private String ServerTime;


    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }

    public String getResult() {
        return Result;
    }

    public void setResult(String result) {
        Result = result;
    }

    public String getServerTime() {
        return ServerTime;
    }

    public void setServerTime(String serverTime) {
        ServerTime = serverTime;
    }
}
