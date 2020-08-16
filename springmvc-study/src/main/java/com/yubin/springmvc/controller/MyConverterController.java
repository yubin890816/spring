package com.yubin.springmvc.controller;

import com.yubin.springmvc.pojo.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 自定义类型转换器演示
 *
 * @author YUBIN
 * @create 2020-08-16
 */
@Controller
public class MyConverterController {

    /**
     *
     * @param student 此参数名称也要和客户端传递过来的参数名称一致
     * @return
     */
    @RequestMapping("/testConverter")
    public String testConverter(Student student) {
        System.out.println(student);
        return "success";
    }
}
