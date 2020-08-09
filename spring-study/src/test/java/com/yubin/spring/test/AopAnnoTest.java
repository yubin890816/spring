package com.yubin.spring.test;

import com.yubin.spring.aop_anno.MyCalculator;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Aop注解形式使用测试类
 *
 * @author YUBIN
 * @create 2020-08-09
 */
public class AopAnnoTest {

    @Test
    public void test1() {
        ApplicationContext context = new ClassPathXmlApplicationContext("aop_anno/spring-aop-anno01.xml");
        MyCalculator calculator = context.getBean(MyCalculator.class);
        //calculator.add(1, 1);
        calculator.show();

        //calculator.div(1, 0);
        System.out.println(calculator.getClass());
    }
}
