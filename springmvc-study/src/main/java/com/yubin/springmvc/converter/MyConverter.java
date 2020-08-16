package com.yubin.springmvc.converter;

import com.yubin.springmvc.pojo.Student;
import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

/**
 * 自定义类型转换器
 *
 * @author YUBIN
 * @create 2020-08-16
 */
public class MyConverter implements Converter<String, Student> {
    @Override
    public Student convert(String source) {
        Student student = null;
        if (!StringUtils.isEmpty(source) && source.split("-").length == 4) {
            student = new Student();
            student.setId(Integer.valueOf(source.split("-")[0]));
            student.setUserName(source.split("-")[1]);
            student.setPassword(source.split("-")[2]);
            student.setAge(Integer.valueOf(source.split("-")[3]));
        }

        return student;
    }
}
