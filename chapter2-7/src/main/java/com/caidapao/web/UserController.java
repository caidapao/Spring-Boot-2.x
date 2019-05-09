package com.caidapao.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by caidapao on 2019/5/9
 * Time 22:46
 * Blog http://www.caidapao.com
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/test500")
    public Object test500(String name){
        int a = 5/0;
        return a;
    }
}
