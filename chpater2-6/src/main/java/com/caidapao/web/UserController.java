package com.caidapao.web;

import com.caidapao.common.ErrorCode;
import com.caidapao.exception.MyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by caidapao on 2019/4/29
 * Time 23:07
 * Blog http://www.caidapao.com
 */
@Controller
@RequestMapping("/user")
public class UserController {

    /**
     * 用户未登录异常
     */
    @RequestMapping("login")
    @ResponseBody
    public Object login(){
        throw new MyException(ErrorCode.SYS_USER_NOT_LOGIN);
    }

    /**
     * 测试通配符异常信息
     * @param name
     * @param sex
     */
    @RequestMapping("detail")
    @ResponseBody
    public Object detail(String name,String sex){
        if (name == null) {
            throw new MyException(ErrorCode.SYS_OBJECT_IS_NOT_NULL,"名称");
        }
        return name;
    }
}
