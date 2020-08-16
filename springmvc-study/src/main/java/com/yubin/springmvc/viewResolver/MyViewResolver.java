package com.yubin.springmvc.viewResolver;

import org.springframework.core.Ordered;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import java.util.Locale;

/**
 * 自定义视图解析器
 *
 * @author YUBIN
 * @create 2020-08-16
 */
public class MyViewResolver implements ViewResolver, Ordered {

    private Integer order;

    /**
     * @param viewName 视图名称
     * @param locale   国际化相关
     * @return
     * @throws Exception
     */
    @Override
    public View resolveViewName(String viewName, Locale locale) throws Exception {

        if (!StringUtils.isEmpty(viewName) && viewName.startsWith("yubin:")) {
            System.out.println(viewName);
            return new MyView();
        }
        return null;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
