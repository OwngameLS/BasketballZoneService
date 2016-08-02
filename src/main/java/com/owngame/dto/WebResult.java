package com.owngame.dto;

/**
 * Created by Administrator on 2016-8-2.
 * 通过网络ajax访问返回json数据的结果对象
 */

public class WebResult<T> {
    private boolean success;
    private T data;
    private String error;

    public WebResult(boolean success, T data){
        this.success = success;
        this.data = data;
    }

    public WebResult(boolean success, String error){
        this.success = success;
        this.error = error;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
