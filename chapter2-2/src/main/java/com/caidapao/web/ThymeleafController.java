package com.caidapao.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by caixuan on 2019/1/9.
 * Time 22:51
 */
@Controller
@RequestMapping("/hello")
public class ThymeleafController {


    /**
     * 使用ResponseBody注解会将返回值转换成Json格式的字符串
     */
    @ResponseBody
    @RequestMapping("/string")
    public String hello() {
        return "index";
    }

    /**
     * Controller的方法，返回值如果是String类型的话，会将字符串映射成视图。
     * @param modelMap address 此项目在github的地址
     */
    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public String helloCaidapao(ModelMap modelMap) {
        modelMap.addAttribute("address", "https://github.com/caidapao/spring-boot-1.x");
        return "index";
    }


}
