package com.yubin.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 请求参数处理案例
 *
 * @author YUBIN
 * @create 2020-08-15
 */
@Controller
public class RequestController {

    /**
     * request.getParameter("参数名称")
     * 当发送请求的时候,找到对应的处理方法之后,会根据参数的名称从request中获取对应的参数值,并封装到方法中
     * 此时要求,方法的名称和url中参数的名称必须一致,如果不一致,设置不成功
     *
     * 如果设置的值不同,同时又想让参数获取到对应的属性值,可以通过@RequestParam("参数名称")来使用
     * @RequestParam 注解的属性值
     *      value: 指定参数名称, 如果不指定, 则参数名称需要与方法中的参数名称一致
     *      required: 是否必须,默认为true 表示请求参数中必须携带此参数,如果没有则会出现400的错误
     *      defaultValue: 用于设置默认值,如果请求参数中没有当前这个参数,则设置成默认值(此时required会默认设置成false)
     *
     * @param name
     * @return
     */
    @RequestMapping("/testRequestParam")
    public String testRequestParam(@RequestParam(value = "userName", required = true, defaultValue = "lisi") String name) {
        System.out.println(name);
        return "success";
    }

    /**
     * 获取请求头信息
     * @RequestHeader 注解可以获取请求头信息
     * 相当于 request.getHeader("参数名称");
     * 同时也包含 value、required、defaultValue 用法与@RquestParam的属性同
     * @param userAgent
     * @return
     */
    @RequestMapping("/testRequestHeader")
    public String testRequestHeader(@RequestHeader(value = "User-Agent") String userAgent) {
        System.out.println(userAgent);
        return "success";
    }

    /**
     * 获取cookie中得值 使用 @CookieValue
     *      Cookie[] cookies = request.getCookies();
     *  同时也包含 value、required、defaultValue 用法与@RquestParam的属性同
     *
     * @param jsId
     * @return
     */
    @RequestMapping("/testCookieValue")
    public String testCookieValue(@CookieValue(value = "JSESSIONID") String jsId) {
        System.out.println(jsId);
        return "success";
    }
}
