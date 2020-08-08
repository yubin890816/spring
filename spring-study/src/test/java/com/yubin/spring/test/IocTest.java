package com.yubin.spring.test;

import com.yubin.spring.bean.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Spring IOC测试类
 *
 * @author YUBIN
 * @create 2020-08-07
 */
public class IocTest {

    /**
     * Spring IOC 基本使用
     */
    @Test
    public void test1() {
        ApplicationContext context = new ClassPathXmlApplicationContext("ioc/spring-ioc01.xml");
        User user = (User) context.getBean("user");
        System.out.println(user);
    }

}