package com.yubin.springmvc.controller;

import com.yubin.springmvc.pojo.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * 返回json数据的演示
 *      @ResponseBody: 表示把当前请求返回的内容直接作为响应体
 *
 *
 * @author YUBIN
 * @create 2020-08-17
 */
@Controller
public class JsonController {

    @ResponseBody
    @RequestMapping("/testJson1")
    public List<Student> testJson1() {
        List<Student> list = new ArrayList<>();
        list.add(new Student(1, "zhangsan1", "111", 20));
        list.add(new Student(2, "zhangsan2", "222", 21));
        list.add(new Student(3, "zhangsan3", "333", 22));
        return list;
    }

    @ResponseBody
    @RequestMapping("/testJson2")
    public String testJson2() {
        return "<h1>hello json</h1>";
    }

    @RequestMapping("/testRequestBody")
    public String testRequestBody(@RequestBody String str) {
        System.out.println(str);
        return "success";
    }

    @RequestMapping("/testRequestJson")
    public String testRequestJson(@RequestBody Student student) {
        System.out.println(student);
        return "success";
    }
}
