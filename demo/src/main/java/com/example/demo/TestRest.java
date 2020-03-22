package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by caidapao on 2020/3/14
 * Time 12:38
 * address https://today.caidapao.com
 */
@RequestMapping("/demo")
@Controller
public class TestRest {

    @GetMapping("/home/{name}")
    public String sayHello(@PathVariable String name, Model model) {
        model.addAttribute("name",name);
        return "home-page";
    }
}
