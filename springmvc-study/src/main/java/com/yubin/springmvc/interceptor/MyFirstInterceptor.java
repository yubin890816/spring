package com.yubin.springmvc.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义第一个拦截器
 *
 * @author YUBIN
 * @create 2020-08-18
 */
public class MyFirstInterceptor implements HandlerInterceptor {

    /**
     * 在处理器方法执行之前执行
     * @param request
     * @param response
     * @param handler
     * @return 注意返回值,如果返回false表示请求到此为止, 如果是true, 才会接着向下执行
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("MyFirstInterceptor.preHandle------");
        return true;
    }

    /**
     * 在处理器完成方法的处理之后执行
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("MyFirstInterceptor.postHandle------");
    }

    /**
     * 在整个servlet处理完成之后才会执行,主要做资源清理的工作
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("MyFirstInterceptor.afterCompletion------");
    }
}
