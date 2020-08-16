package com.yubin.springmvc.viewResolver;

import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Map;

/**
 * 自定义视图
 *
 * @author YUBIN
 * @create 2020-08-16
 */
public class MyView implements View {
    @Override
    public String getContentType() {
        return "text/html";
    }

    @Override
    public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("model:" + model);

        response.setContentType("text/html");

        PrintWriter writer = response.getWriter();
        writer.write("<h1>自定义视图解析器</h1>");
        writer.write("123456");
    }
}
