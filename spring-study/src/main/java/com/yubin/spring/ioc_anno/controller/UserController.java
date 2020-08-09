package com.yubin.spring.ioc_anno.controller;

import com.yubin.spring.ioc_anno.dao.UserDao;
import com.yubin.spring.ioc_anno.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

/**
 * 用户控制层
 *
 * @author YUBIN
 * @create 2020-08-09
 */
@Controller
public class UserController {

    @Autowired
    @Qualifier("userService")
    private UserService userService2;

    public void save() {
        userService2.save();
    }

    /**
     * 当@Autowired注解加在方法上的时候
     * 1、此方法在bean创建的时候会自动调用
     * 2、这个方法的每一个参数都会自动注入
     */
    @Autowired
    public void test1(UserDao userDao) {
        userDao.update();
        System.out.println("test1方法被默认调用:" + userDao);
    }

    /**
     * 当@Autowired注解加在方法上的时候, 此方法会在创建对象的时候默认调用
     * 同时方法中的参数会自动装配
     * @Qualifier 注解也可以定义在方法的参数列表中，可以指定当前属性的id名称(如果没有此注解,那么直接按照类型进行匹配)
     */
    @Autowired
    public void test2(@Qualifier("userService2") UserService userService) {
        System.out.println("test2方法被默认调用:" + userService);
    }
}