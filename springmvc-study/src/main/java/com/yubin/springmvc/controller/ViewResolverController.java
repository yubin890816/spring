package com.yubin.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 自定义视图解析器演示
 *
 * @author YUBIN
 * @create 2020-08-16
 */
@Controller
public class ViewResolverController {

    @RequestMapping("/testView1")
    public String testView1() {
        System.out.println("======testView1======");
        return "yubin:/index";
    }

    @RequestMapping("/testView2")
    public String testView2() {
        System.out.println("======testView2======");
        return "heihei:/index";
    }
}
