package com.yubin.springmvc.controller;

import com.yubin.springmvc.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 数据校验案例演示
 *
 * @author YUBIN
 * @create 2020-08-17
 */
@Controller
public class DataValidateController {

    @RequestMapping("/dataValidate")
    public String dataValidate(@Valid User user, BindingResult bindingResult, Model model) {
        System.out.println(user);
        if (bindingResult.hasErrors()) {
            Map<String, Object> errors = new HashMap<>();
            System.out.println("验证失败");
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            for (FieldError fieldError : fieldErrors) {
                System.out.println(fieldError.getField());
                System.out.println(fieldError.getDefaultMessage());
                errors.put(fieldError.getField(), fieldError.getDefaultMessage());
            }
            model.addAttribute("errorMsg", errors);
            return "forward:/validateUser.jsp";
        } else {
            System.out.println("验证成功");
            return "success";
        }
    }
}
