package com.yubin.springmvc.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * HttpEntity对象的演示
 *
 * @author YUBIN
 * @create 2020-08-17
 */
@Controller
public class EntityController {

    @RequestMapping("/testHttpEntity")
    public String testHttpEntity(HttpEntity<String> httpEntity) {
        System.out.println(httpEntity);
        return "success";
    }

    @RequestMapping("/testResponseEntity")
    public ResponseEntity<String> testResponseEntity() {
        String body = "<h1>hello ResponseEntity</h1>";
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Set-Cookie","name=zhangsan");
        return new ResponseEntity<String>(body, httpHeaders, HttpStatus.OK);
    }
}
