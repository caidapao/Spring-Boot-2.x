package com.caidapao.common;

/**
 * Created by caidapao on 2019/5/7
 * Time 21:46
 * Blog http://www.caidapao.com
 */
public enum ErrorCode {

    SYS_OBJECT_IS_NOT_NULL("SYS_OBJECT_IS_NOT_NULL", "%s不能为空"),
    SYS_USER_NOT_LOGIN("SYS_USER_NOT_LOGIN","您未登录");


    private String code;

    private String errorMsg;
    ErrorCode(String code, String errorMsg) {
        this.code = code;
        this.errorMsg = errorMsg;
    }

    public String getCode() {
        return code;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

}
