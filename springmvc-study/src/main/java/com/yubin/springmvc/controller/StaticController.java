package com.yubin.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 静态资源访问演示
 *
 * @author YUBIN
 * @create 2020-08-16
 */
@Controller
public class StaticController {

    @RequestMapping("/static")
    public String testStatic() {

        return "forward:/hello.jsp";
    }
}
