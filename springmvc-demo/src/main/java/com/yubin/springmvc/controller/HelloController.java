package com.yubin.springmvc.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * SpringMVC案例演示
 *
 * @author YUBIN
 * @create 2020-08-15
 */
public class HelloController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("hello");
        mv.addObject("hello", "hello SpringMVC");
        return mv;
    }
}
