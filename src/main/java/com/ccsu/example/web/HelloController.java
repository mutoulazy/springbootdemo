package com.ccsu.example.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.DateFormat;
import java.util.Date;

/**
 * Created by mutoulazy on 2018/3/1.
 */
@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String hello(Model m) throws Exception {
        m.addAttribute("now", DateFormat.getDateTimeInstance().format(new Date()) + " 2333");
        System.out.println("中文测试");
        if (false){
            throw new Exception("some exception");
        }
        return "hello";
    }
}
