package com.yubin.springmvc.controller;

import com.yubin.springmvc.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Locale;

/**
 * 用户相关控制层
 *
 * @author YUBIN
 * @create 2020-08-16
 */
@Controller
public class UserController {

    /**
     * 如果使用默认的类型转换器,那么在输入日期的时候必须要使用 / 作为分隔, 如果需要自定义实现该如何操作
     * 方式1、
     *      在字段上添加 @DateTimeFormat(pattern="yyyy-MM-dd")
     *      如果之前定义了  ConversionServiceFactoryBean 将其改成 FormattingConversionServiceFactoryBean
     *
     * 方式2、
     *      在字段上添加 @DateTimeFormat(pattern="yyyy-MM-dd")
     *      删除 ConversionServiceFactoryBean 的定义
     *
     * 小结：
     *  如果需要添加日期格式化器的话, 只需要在实体类上添加@DateTimeFormat(pattern="yyyy-MM-dd") 即可
     *  但是需要注意的是,如果在配置日期格式化器的时候,配置了类型转换器,那么此时就会失效 需要使用FormattingConversionServiceFactoryBean对象
     *  因为FormattingConversionServiceFactoryBean类中带有格式化器
     *
     *
     * 乱码问题解决:
     *  我们需要设置request和response的编码方式, 可以自己手动编写过滤, 也可以由现成的框架来实现
     *  post: 必须要分别设置request和response的编码格式
     *  get: 在tomcat的server.xml文件中,添加URIEncoding=UTF-8
     *
     *  在一个应用程序中可能会包含多个过滤器,这N多个过滤器一般是没有顺序的要求的,
     *  但是如果你设置了编码过滤其,那么要求必须要将编码过滤器设置到最上面,保证编码过滤器优先执行
     *  因为如果先经过其它过滤器,你的请求可能已经被处理过,这时候编码过滤器可能就不管用了
     * @param user
     * @return
     */
    @RequestMapping("/addUser")
    public String addUser(User user) {
        System.out.println(user);
        return "success";
    }

    /**
     * SpringMVC也可以在参数上使用原生Servlet API
     *
     * HttpSession
     * HttpServletRequest
     * HttpServletResponse
     *
     *  java.security.Principal 安全协议相关
     *  Locale：国际化相关的区域信息对象
     *  InputStream:
     *      ServletInputStream inputStream = request.getInputStream();
     *  OutputStream:
     *      ServletOutputStream outputStream = response.getOutputStream();
     *  Reader:
     *      BufferedReader reader = request.getReader();
     *  Writer:
     *      PrintWriter writer = response.getWriter();
     * @param session
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/servletApi")
    public String servletApi(HttpSession session, HttpServletRequest request, HttpServletResponse response, Locale locale) {
        request.setAttribute("request", "request");
        session.setAttribute("session", "session");
        return "success";
    }
}
