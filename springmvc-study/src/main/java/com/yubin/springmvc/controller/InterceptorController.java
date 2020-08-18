package com.yubin.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 拦截器案例演示
 *
 * @author YUBIN
 * @create 2020-08-18
 */
@Controller
@RequestMapping("/interceptor")
public class InterceptorController {

    @RequestMapping("/testInterceptor")
    public String testInterceptor() {
        System.out.println("InterceptorController.testInterceptor----");
        return "success";
    }
}
