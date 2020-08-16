package com.yubin.springmvc.controller;

import com.yubin.springmvc.pojo.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * 演示ModelAttribute注解的使用
 *
 * @author YUBIN
 * @create 2020-08-16
 */
@Controller
@RequestMapping("/student")
@SessionAttributes({"student"})
public class StudentController {

    private Object o1;

    private Object o2;

    // 先从request中获取,获取不到再去session中获取
    // SessionAttributes要注意,在使用的时候如果没有对应的值,可能会报异常
    @RequestMapping("/update1")
    public String update1(@ModelAttribute("student") Student student, Model model) {
        System.out.println("update1================");
        System.out.println(student);
        // o1和student是同一个对象
        System.out.println(o1 == student);
        System.out.println(o2 == model);
        return "success";
    }

    @RequestMapping("/update2")
    public String update2(@ModelAttribute("student2") Student student) {
        System.out.println("update2================");
        System.out.println(student);
        return "success";
    }

    @ModelAttribute
    public void testModelAttribute(Model model, Integer id) {
        System.out.println("testModelAttribute=================");
        System.out.println(id);
        Student student = new Student();
        student.setId(1);
        student.setUserName("张三");
        student.setPassword("abcdef");
        student.setAge(18);
        model.addAttribute("student2", student);
        o1 = student;
        o2 = model;
    }

    @ModelAttribute("student")
    public Student testModelAttribute2(Model model) {
        System.out.println("testModelAttribute2=================");
        Student student = new Student();
        student.setId(2);
        student.setUserName("李四");
        student.setPassword("abcdef");
        student.setAge(18);
        //model.addAttribute("student2", student);
        return student;
    }
}
