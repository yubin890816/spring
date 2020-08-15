package com.yubin.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * REST风格的请求资源案例演示
 *
 * @author YUBIN
 * @create 2020-08-15
 */
@Controller
@RequestMapping("/rest")
public class RestDemoController {

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String save() {
        System.out.println("save");
        return "success";
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable Integer id) {
        System.out.println("delete id:" + id);
        return "success";
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
    public String update(@PathVariable Integer id) {
        System.out.println("update id:" + id);
        return "success";
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String query() {
        System.out.println("query");
        return "success";
    }
}
