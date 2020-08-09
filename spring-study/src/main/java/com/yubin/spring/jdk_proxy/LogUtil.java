package com.yubin.spring.jdk_proxy;

import java.util.Arrays;

/**
 * 日志工具类
 *
 * @author YUBIN
 * @create 2020-08-09
 */
public class LogUtil {

    public static void start(Object... objs) {
        System.out.println("XXX方法开始执行，使用的参数是："+ Arrays.asList(objs));
    }

    public static void stop(Object... objs) {
        System.out.println("XXX方法执行结束，结果是："+ Arrays.asList(objs));
    }
}
