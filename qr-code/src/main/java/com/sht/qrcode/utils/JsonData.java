package com.sht.qrcode.utils;

import java.io.Serializable;

/**
 * @author Administrator
 */
public class JsonData implements Serializable {

    private static final Long serialVersionUID = 1L;
    private Integer code;
    private Object data;
    private String msg;

    public JsonData() {
    }

    public JsonData(Integer code, Object data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    public static JsonData buildSuccess() {
        return new JsonData(200, null, null);
    }

    public static JsonData buildError(Object data, String msg) {
        return new JsonData(400, data, msg);
    }

    public static JsonData buildError(String msg) {
        return new JsonData(400, null, msg);
    }

    public static JsonData buildError(String msg, Integer code) {
        return new JsonData(code, null, msg);
    }

    public static JsonData buildSuccess(Object data, String msg) {
        return new JsonData(200, data, msg);
    }

    public static JsonData buildSuccess(String msg) {
        return new JsonData(200, null, msg);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "JsonData [code=" + this.code + ", data=" + this.data + ", msg=" + this.msg + "]";
    }
}
