package com.yubin.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * 基于注解的SpringMVC案例演示
 *
 * @author YUBIN
 * @create 2020-08-15
 */
@Controller
@RequestMapping("/hello")
public class HelloController {

    /**
     * SpringMVC处理过程
     *  1、浏览器要发送一个请求 http://localhost:8080/springmvc_study/hello
     *  2、首先交给tomcat容器
     *  3、在web.xml中配置了DispatcherServlet的类,所以此时会由当前的DispatcherServlet来接收请求
     *  4、接收到请求之后找到对应的Controller, 去Controller中寻找@RequestMapping注解标识的方法
     *  5、找到匹配的方法之后,执行方法的逻辑
     *  6、处理完成之后需要返回一个前端页面的名称
     *  7、由视图解析器根据名称映射到对应的jsp页面的路径
     *  8、DispatcherServlet拿到对应的路径地址之后返回给浏览器
     */
    @RequestMapping("/hello")
    public String hello(Map<String, String> map) {
        map.put("hello", "Hello SpringMVC");
        return "hello";
    }

    /**
     * @RequestMapping属性介绍
     *   value: 表示要匹配的路径
     *   method: 限制发送请求的方式 POST, GET
     *   params: 表示请求要接收的参数,如果定义了这个属性,那么发送的时候必须要添加参数
     *      params有几种匹配规则:
     *      1、直接写参数的名称 param1,param2
     *      表示请求中必须要包含userName属性值
     *      @RequestMapping(value = "/hello2", params = {"userName"})
     *      2、 表示请求不能包含的参数，！param1
     *      表示请求中不能包含userName属性值
     *      @RequestMapping(value = "/hello2", params = {"userName"})
     *      3、表示请求中需要要包含的参数但是可以限制值 param1=values  param1!=value
     *      表示必须包含userName和age属性值,且userName的属性值必须是zhangsan
     *      @RequestMapping(value = "/hello2", params = {"userName=zhangsan", "age"})
     *
     *   headers: 填写头信息
     *      chrome：User-Agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.79 Safari/537.36
     *      firefox:User-Agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:73.0) Gecko/20100101 Firefox/73.0
     *   consumers:只接受内容类型是哪种的请求，相当于指定Content-Type
     *   produces:返回的内容类型 Content-Type：text/html;charset=utf-8
     * @param map
     * @return
     */
    @RequestMapping(value = "/hello2", method = RequestMethod.POST, params = {"pass"}, headers = {"User-Agent: Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/84.0.4147.125 Safari/537.36"})
    public String hello2(Map<String, String> map) {
        map.put("hello", "Hello2 SpringMVC");
        return "hello";
    }

    /**
     * @RequestMapping 包含三种模糊匹配的方式，分别是：
     *  ？：能替代任意一个字符
     *  *: 能替代任意多个字符和一层路径
     *  **：能代替多层路径
     *
     *  如果能匹配到多个请求,那么优先是精准匹配,其次是模糊匹配
     * @return
     */
    @RequestMapping(value = "/hello3/*")
    public String hello3(Map<String, String> map) {
        map.put("hello", "Hello3 SpringMVC");
        return "hello";
    }
}