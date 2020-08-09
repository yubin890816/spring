package com.yubin.spring.test;

import com.yubin.spring.jdk_proxy.Calculator;
import com.yubin.spring.jdk_proxy.JdkProxyFactory;
import com.yubin.spring.jdk_proxy.MyCalculator;
import org.junit.Test;

/**
 * jdk动态代理测试类
 *
 * @author YUBIN
 * @create 2020-08-09
 */
public class JdkProxyTest {

    @Test
    public void test1() {
        Calculator calculator = new MyCalculator();
        System.out.println(calculator.add(1, 1));
        System.out.println(calculator.sub(1, 1));
        System.out.println(calculator.mul(1, 1));
        System.out.println(calculator.div(1, 1));
    }

    @Test
    public void test2() {
        JdkProxyFactory proxyFactory = new JdkProxyFactory(new MyCalculator());
        Calculator proxyInstance = (Calculator) proxyFactory.getProxy();
        proxyInstance.add(1, 1);
        proxyInstance.sub(1, 1);
        proxyInstance.mul(1, 1);
        proxyInstance.div(1, 1);
    }
}
