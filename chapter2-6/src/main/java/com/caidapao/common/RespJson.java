package com.caidapao.common;

/**
 * Created by caidapao on 2019/5/7
 * Time 21:57
 * Blog http://www.caidapao.com
 */
public class RespJson {

    private String code;

    private String msg;

    private Object data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
