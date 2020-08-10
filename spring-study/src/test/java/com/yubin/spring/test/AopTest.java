package com.yubin.spring.test;


import com.yubin.spring.aop.Calculator;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Aop注解形式使用测试类
 *
 * @author YUBIN
 * @create 2020-08-09
 */
public class AopTest {

    @Test
    public void test1() {
        ApplicationContext context = new ClassPathXmlApplicationContext("aop/spring-aop01.xml");
        Calculator calculator = context.getBean(Calculator.class);
        calculator.div(1, 1);
    }
}
