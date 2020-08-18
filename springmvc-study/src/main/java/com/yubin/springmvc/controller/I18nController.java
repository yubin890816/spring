package com.yubin.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Locale;

/**
 * 国际化操作演示
 *
 * @author YUBIN
 * @create 2020-08-18
 */
@Controller
public class I18nController {

    @Autowired
    private MessageSource messageSource;

    /**
     * 国际化跳转登录页面
     * @return
     */
    @RequestMapping("/i18n")
    public String i18n(Locale locale) {
        System.out.println(locale);
        String username = messageSource.getMessage("username", null, locale);
        System.out.println(username);
        return "login";
    }
}
