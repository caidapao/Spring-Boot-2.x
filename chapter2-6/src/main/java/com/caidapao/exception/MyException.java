package com.caidapao.exception;

import com.caidapao.common.ErrorCode;

/**
 * Created by caidapao on 2019/4/29
 * Time 23:06
 * Blog http://www.caidapao.com
 */
public class MyException extends RuntimeException {

    private String code;

    private String errorMsg;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public MyException(String code, String msg, Object... params) {
        this.code = code;
        this.errorMsg = (params != null && params.length > 0) ? String.format(msg, params) : msg;
    }

    public MyException(ErrorCode errorCode, Object... params) {
        this.code = errorCode.getCode();
        this.errorMsg = (params != null && params.length > 0) ? String.format(errorCode.getErrorMsg(), params) : errorCode.getErrorMsg();
    }
}
