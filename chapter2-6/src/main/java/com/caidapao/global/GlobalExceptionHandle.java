package com.caidapao.global;

import com.caidapao.common.RespJson;
import com.caidapao.exception.MyException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by caidapao on 2019/4/29
 * Time 23:08
 * Blog http://www.caidapao.com
 */
@ControllerAdvice
public class GlobalExceptionHandle {

    /**
     * 当抛出MyException时，会被此方法拦截。直接返回RespJson
     * @param e 异常对象
     */
    @ExceptionHandler(value = MyException.class)
    @ResponseBody
    public RespJson handleMyException(MyException e){
        RespJson respJson = new RespJson();
        respJson.setCode(e.getCode());
        respJson.setMsg(e.getErrorMsg());
        return respJson;
    }
}
