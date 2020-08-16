package com.yubin.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * 响应数据演示
 *  在向页面回显数据的时候,可以在方法的参数中显示的声明
 *     Map
 *     Model
 *     ModelMap
 *     注意这三个对象都会转换成BindingAwareModelMap这个类,查看BindingAwareModelMap的类图,你就会明白一切
 *  都可以将数据进行回显:回显之后数据是保存在哪个作用域中的呢?
 *  当使用上述方式传递数据的时候会把数据放置在request作用域中
 *  作用域:
 *  request: 当前请求
 *  session: 当前会话
 *  application: 当前应用
 *  page: 当前页面
 * @author YUBIN
 * @create 2020-08-16
 */
@Controller
@SessionAttributes({"userName"})
public class OutPutController {

    @RequestMapping("outPut1")
    public String outPut1(Map map) {
        map.put("msg", "outPut1");
        System.out.println(map.getClass());
        return "outPut";
    }

    @RequestMapping("outPut2")
    public String outPut2(Model model) {
        model.addAttribute("msg", "outPut2");
        System.out.println(model.getClass());
        return "outPut";
    }

    @RequestMapping("outPut3")
    public String outPut3(ModelMap modelMap) {
        modelMap.addAttribute("msg", "outPut3");
        System.out.println(modelMap.getClass());
        return "outPut";
    }

    @RequestMapping("outPut4")
    public ModelAndView outPut4() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("outPut");
        mv.addObject("msg", "outPut4");
        System.out.println(mv.getClass());
        return mv;
    }

    /**
     * 当需要向session中设置数据的时候, 可以在当前Controller上添加@SessionAttributes注解
     * 此注解表示,每次向request作用域中设置属性值的时候,顺带着向session中保存一份
     * @SessionAttributes 注解的属性value和types都写上之后表示session中可以存储名字为value值的参数以及类型为指定类型的参数
     * value和types可以分开单独使用,但是尽量不要使用type类型,因为会把所有符合类型的数据都设置到session中,导致session异常
     * @param map
     * @return
     */
    @RequestMapping("/testSession")
    public String testSession(Map map) {
        map.put("userName", "张三");
        return "outPut";
    }
}
