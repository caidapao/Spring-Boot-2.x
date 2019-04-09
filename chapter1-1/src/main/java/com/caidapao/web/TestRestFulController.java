package com.caidapao.web;

import com.caidapao.entity.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by caixuan on 2019/1/9.
 * Time 22:51
 */
@RestController
@RequestMapping("/rest")
public class TestRestFulController {

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String testRestFul(User user) {
        System.out.println(user.getName());
        return "hello ! rest ful API";
    }
}
