package com.yubin.springmvc.handler;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * 全局异常处理类
 *
 * @author YUBIN
 * @create 2020-08-18
 */
//@ControllerAdvice
public class MyGlobalExceptionHandler {

    @ExceptionHandler(value = {ArithmeticException.class})
    public ModelAndView handlerException1(Exception exception){
        System.out.println("MyGlobalExceptionHandler.handlerException1........");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("error");
        mv.addObject("ex",exception);
        return mv;
    }
}
