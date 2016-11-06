package org.changs.campus.mobile.domain;

/**
 * Created by yincs on 2016/11/5.
 */

public class AppRes<T> {
    private int code;
    private String des;
    T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
