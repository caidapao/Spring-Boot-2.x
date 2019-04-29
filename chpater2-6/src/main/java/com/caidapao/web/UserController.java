package com.caidapao.web;

import com.caidapao.exception.MyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by caidapao on 2019/4/29
 * Time 23:07
 * Blog http://www.caidapao.com
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("detail")
    public String userDetail(){
        throw new MyException();
    }
}
