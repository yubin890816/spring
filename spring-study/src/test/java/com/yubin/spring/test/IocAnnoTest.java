package com.yubin.spring.test;

import com.yubin.spring.ioc_anno.controller.UserController;
import com.yubin.spring.ioc_anno.service.StudentService;
import com.yubin.spring.ioc_anno.service.TeacherService;
import com.yubin.spring.ioc_anno.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * IOC注解方式测试类
 *
 * @author YUBIN
 * @create 2020-08-09
 */
public class IocAnnoTest {

    /**
     * IOC 注解应用基本演示
     */
    @Test
    public void test1() {
        ApplicationContext context = new ClassPathXmlApplicationContext("ioc_annotation/spring-ioc-anno01.xml");
        UserController userController1 = context.getBean("userController", UserController.class);
        UserController userController2 = context.getBean("userController", UserController.class);
        System.out.println(userController1 == userController2);
    }

    /**
     * 定义扫描包时要包含的类和不要包含的类
     */
    @Test
    public void test2() {
        ApplicationContext context = new ClassPathXmlApplicationContext("ioc_annotation/spring-ioc-anno02.xml");
        UserController userController = context.getBean("userController", UserController.class);
        System.out.println(userController);

        UserService userService = context.getBean("userService", UserService.class);
        System.out.println(userService);
    }

    /**
     * 使用@AutoWired进行自动注入
     */
    @Test
    public void test3() {
        ApplicationContext context = new ClassPathXmlApplicationContext("ioc_annotation/spring-ioc-anno01.xml");
        UserController userController = context.getBean("userController", UserController.class);
        userController.save();
    }

    /**
     * 泛型依赖注入
     */
    @Test
    public void test4() {
        ApplicationContext context = new ClassPathXmlApplicationContext("ioc_annotation/spring-ioc-anno01.xml");
        StudentService studentService = context.getBean("studentService", StudentService.class);
        TeacherService teacherService = context.getBean("teacherService", TeacherService.class);
        studentService.save();
        teacherService.save();
    }
}