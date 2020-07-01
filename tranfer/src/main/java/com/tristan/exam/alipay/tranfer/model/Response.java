package com.tristan.exam.alipay.tranfer.model;


/**
 * 一般响应接口数据格式定义
 *
 * @author byzuse
 * datetime: 2018/10/27 11:18.
 */
public class Response<T> {
    private int statusCode = StatusCode.SUCCESS.getCode();

    private String msg = "ok";

    private T data;

    public Response() {
    }

    public Response(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return statusCode + "_" + msg;
    }

    public void setMsgCode(StatusCode statusCode) {
        this.msg = statusCode.getMsg();
        this.statusCode = statusCode.getCode();
    }

    public void setClientErrorMsg(String msg) {
        this.msg = msg;
        this.statusCode = StatusCode.CLIENT_ERROR.getCode();
    }

    public void setServerErrorMsg(String msg) {
        this.msg = msg;
        this.statusCode = StatusCode.SERVER_ERROR.getCode();
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
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
}
