package com.yubin.spring.factory;

import com.yubin.spring.bean.User;

/**
 * 实例工厂方法创建bean对象
 *
 * @author YUBIN
 * @create 2020-08-08
 */
public class InstanceFactory {

    public User getInstance(String name, Integer age) {
        User user = new User();
        user.setId(11);
        user.setName(name);
        user.setAge(age);
        user.setGender("女");
        return user;
    }
}