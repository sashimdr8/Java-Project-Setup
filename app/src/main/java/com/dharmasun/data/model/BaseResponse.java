package com.dharmasun.data.model;

/**
 * Created by brain on 4/17/17.
 */

public class BaseResponse<T> {
    private int Code;
    private String Message;
    private T data;

    public int getCode() {
        return Code;
    }

    public void setCode(int code) {
        this.Code = code;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        this.Message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
