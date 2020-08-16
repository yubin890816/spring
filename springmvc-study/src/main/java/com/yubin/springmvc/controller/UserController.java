package com.yubin.springmvc.controller;

import com.yubin.springmvc.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 用户相关控制层
 *
 * @author YUBIN
 * @create 2020-08-16
 */
@Controller
public class UserController {

    @RequestMapping("/addUser")
    public String addUser(User user) {
        System.out.println(user);
        return "success";
    }
}
