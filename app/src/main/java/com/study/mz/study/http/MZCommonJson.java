package com.study.mz.study.http;

import java.io.Serializable;

public class MZCommonJson<T> implements Serializable {
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    protected int code;
    protected String msg;
    protected T data;
}
