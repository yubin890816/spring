package com.yubin.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * PathVariable注解的使用演示
 *
 * @author YUBIN
 * @create 2020-08-15
 */
@Controller
public class PathVariableController {

    /**
     * @PathVariable 可以获取请求路径中的值
     * 在路径中使用{变量名称}做标识
     * 在方法参数中可以添加@PathVariable做识别, 如果路径中的名称跟参数名称不一致的时候,可以通过@PathVariable注解的value属性值添加路径中的变量名称
     * 推荐添加
     */
    @RequestMapping("/testPathVariable/{id}/{name}")
    public String testPathVariable(@PathVariable(value = "id") Integer id,@PathVariable("name") String name) {
        System.out.println(id);
        System.out.println(name);
        return "hello";
    }
}
