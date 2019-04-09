package com.caidapao.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by caixuan on 2019/4/9.
 * Time 23:38
 */
@RestController
@RequestMapping("/user")
public class UserController {

    //创建线程安全的Map
    private static Map<Long,String> users = Collections.synchronizedMap(new HashMap<>());

}
