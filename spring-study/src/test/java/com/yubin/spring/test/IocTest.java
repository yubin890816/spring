package com.yubin.spring.test;

import com.alibaba.druid.pool.DruidDataSource;
import com.yubin.spring.bean.Person;
import com.yubin.spring.bean.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

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

    /**
     * 通过bean的类型获取bean对象
     */
    @Test
    public void test2() {
        ApplicationContext context = new ClassPathXmlApplicationContext("ioc/spring-ioc01.xml");
        //User user2 = context.getBean(User.class);
        //System.out.println(user2);

        User user2 = context.getBean("user2",User.class);
        System.out.println(user2);
    }

    /**
     * 通过构造器给bean对象赋值
     */
    @Test
    public void test3() {
        ApplicationContext context = new ClassPathXmlApplicationContext("ioc/spring-ioc01.xml");
        User user3 = context.getBean("user3",User.class);
        System.out.println(user3);

        User user4 = context.getBean("user4",User.class);
        System.out.println(user4);

        User user5 = context.getBean("user5",User.class);
        System.out.println(user5);

        User user6 = context.getBean("user6",User.class);
        System.out.println(user6);
    }

    /**
     * 通过p命名空间为bean赋值
     */
    @Test
    public void test4() {
        ApplicationContext context = new ClassPathXmlApplicationContext("ioc/spring-ioc01.xml");
        User user7 = context.getBean("user7", User.class);
        System.out.println(user7);
    }

    /**
     * 为复杂类型进行赋值操作
     */
    @Test
    public void test5() {
        ApplicationContext context = new ClassPathXmlApplicationContext("ioc/spring-ioc01.xml");
        Person person = context.getBean("person", Person.class);
        System.out.println(person);
    }

    /**
     * 继承关系bean的配置
     */
    @Test
    public void test6() {
        ApplicationContext context = new ClassPathXmlApplicationContext("ioc/spring-ioc01.xml");
        User user8 = context.getBean("user8", User.class);
        System.out.println(user8);
    }

    /**
     * bean对象创建的依赖关系
     */
    @Test
    public void test7() {
        ApplicationContext context = new ClassPathXmlApplicationContext("ioc/spring-ioc02.xml");
    }

    /**
     * bean的作用域控制，是否是单例
     */
    @Test
    public void test8() {
        ApplicationContext context = new ClassPathXmlApplicationContext("ioc/spring-ioc02.xml");
        User user1 = context.getBean("user2", User.class);
        User user2 = context.getBean("user2", User.class);
        System.out.println(user1 == user2);
    }

    /**
     * 利用工厂模式创建bean对象
     * 1、静态工厂方法  对象=工厂类.静态工厂方法名()
     * 2、实例化工厂方法  对象=工厂对象实例.工厂方法名()
     */
    @Test
    public void test9() {
        ApplicationContext context = new ClassPathXmlApplicationContext("ioc/spring-ioc03.xml");
        // 静态工厂方法创建bean对象
        User user1 = context.getBean("user1", User.class);
        System.out.println(user1);

        // 实例工厂方法创建bean对象
        User user2 = context.getBean("user2", User.class);
        System.out.println(user2);
    }

    /**
     * 实现FactoryBean来创建对象
     */
    @Test
    public void test10() {
        ApplicationContext context = new ClassPathXmlApplicationContext("ioc/spring-ioc03.xml");
        // 静态工厂方法创建bean对象
        User user3 = context.getBean("user3", User.class);
        System.out.println(user3);
    }

    /**
     * bean对象的初始化和销毁方法
     */
    @Test
    public void test11() {
        ApplicationContext context = new ClassPathXmlApplicationContext("ioc/spring-ioc04.xml");
        User user = context.getBean("user", User.class);
        System.out.println(user);
        // ApplicationContext没有close方法,需要使用具体的子类
        ((ClassPathXmlApplicationContext)context).close();
    }

    /**
     * bean后处理器
     */
    @Test
    public void test12() {
        ApplicationContext context = new ClassPathXmlApplicationContext("ioc/spring-ioc04.xml");
        User user = context.getBean("user", User.class);
        System.out.println(user);
    }

    /**
     * Spring创建第三方bean对象
     * @throws SQLException
     */
    @Test
    public void test13() throws SQLException {
        ApplicationContext context = new ClassPathXmlApplicationContext("ioc/spring-ioc05.xml");
        DruidDataSource dataSource = context.getBean("dataSource", DruidDataSource.class);
        System.out.println(dataSource);
        System.out.println(dataSource.getConnection());
    }

    /**
     * spring引用外部配置文件
     * @throws SQLException
     */
    @Test
    public void test14() throws SQLException {
        ApplicationContext context = new ClassPathXmlApplicationContext("ioc/spring-ioc05.xml");
        DruidDataSource dataSource2 = context.getBean("dataSource2", DruidDataSource.class);
        System.out.println(dataSource2);
        System.out.println(dataSource2.getConnection());
    }

    /**
     * Spring基于xml文件的自动装配
     */
    @Test
    public void test15() {
        ApplicationContext context = new ClassPathXmlApplicationContext("ioc/spring-ioc05.xml");
        Person person = context.getBean("person", Person.class);
        System.out.println(person);
    }

    /**
     * SpEL表达式的使用
     * @throws SQLException
     */
    @Test
    public void test16() {
        ApplicationContext context = new ClassPathXmlApplicationContext("ioc/spring-ioc05.xml");
        Person person2 = context.getBean("person2", Person.class);
        System.out.println(person2);
    }
}