package com.yubin.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 重定向使用说明
 *  redirect: 重定向的路径
 *      相当于response.sendRedirect("index.jsp")
 *      跟视图解析器无关
 * @author YUBIN
 * @create 2020-08-16
 */
@Controller
public class RedirectController {

    @RequestMapping("/redirect1")
    public String redirect1() {
        System.out.println("======redirect1======");
        return "redirect:/index.jsp";
    }

    @RequestMapping("/redirect2")
    public String redirect2() {
        System.out.println("======redirect2======");
        return "redirect:/redirect1";
    }
}
