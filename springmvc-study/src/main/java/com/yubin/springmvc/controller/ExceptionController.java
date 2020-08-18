package com.yubin.springmvc.controller;

import com.yubin.springmvc.exception.UserNameException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 异常处理器案例演示
 *   如果500异常直接抛到页面上会非常的不友好
 *   当某一个类中定义的ExceptionHandler只能处理当前类的异常信息,如果其它类包含的话,无法进行处理
 *   可以通过@ControllerAdvice注解进行标注,表示为全局异常处理类
 * @author YUBIN
 * @create 2020-08-18
 */
@Controller
public class ExceptionController {

    @RequestMapping("/exception")
    public String exception() {
        System.out.println("exception......");
        // 模拟业务异常
        int i = 1 / 0;
        return "success";
    }

    @ResponseStatus(reason = "不知道什么原因,反之异常", code = HttpStatus.NOT_ACCEPTABLE)
    @RequestMapping("/exception2")
    public String exception2() {
        System.out.println("exception2......");
        return "success";
    }

    @RequestMapping("/exception3")
    public String exception3(String userName) {
        System.out.println("exception3......");
        if ("admin".equals(userName)){
            return "success";
        }else{
            throw new UserNameException();
        }
    }

    /*@ExceptionHandler({ArithmeticException.class, NullPointerException.class})
    public ModelAndView handlerException1(Exception exception) {
        System.out.println("handlerException1........");
        ModelAndView mv = new ModelAndView("error");
        mv.addObject("ex", exception);
        return mv;
    }

    @ExceptionHandler(value = {Exception.class})
    public ModelAndView handlerException2(Exception exception){
        System.out.println("handlerException2........");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("error");
        mv.addObject("ex",exception);
        return mv;
    }*/
}
