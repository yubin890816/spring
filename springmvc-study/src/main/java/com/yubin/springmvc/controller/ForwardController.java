package com.yubin.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 转发使用实例
 *  当使用转发的时候可以添加前缀 forward:index.jsp, 此时是不会经过视图解析器的,所以要添加完整的名称
 *
 *  forward:也可以由一个请求跳转到另外一个请求
 * @author YUBIN
 * @create 2020-08-16
 */
@Controller
public class ForwardController {

    @RequestMapping("/forward1")
    public String forward1() {
        System.out.println("======forward1======");
        return "forward:/index.jsp";
    }

    @RequestMapping("/forward2")
    public String forward2() {
        System.out.println("======forward2======");
        return "forward:/forward1";
    }
}
