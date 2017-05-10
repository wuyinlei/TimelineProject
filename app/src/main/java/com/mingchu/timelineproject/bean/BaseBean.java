package com.mingchu.timelineproject.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by wuyinlei on 2017/5/10.
 */

public class BaseBean<T> extends BaseEntity{

    private String message;
    private String errorCode;
    private List<T> datas;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public List<T> getDatas() {
        return datas;
    }

    public void setDatas(List<T> datas) {
        this.datas = datas;
    }

    @Override
    public String toString() {
        return "BaseBean{" +
                "message='" + message + '\'' +
                ", errorCode='" + errorCode + '\'' +
                ", datas=" + datas +
                '}';
    }
}
