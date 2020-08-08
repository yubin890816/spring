package com.yubin.spring.factory;

import com.yubin.spring.bean.User;

/**
 * 静态工程方法创建bean
 *
 * @author YUBIN
 * @create 2020-08-08
 */
public class StaticFactory {

    public static User getInstance(String name, String gender) {

        User user = new User();
        user.setId(10);
        user.setName(name);
        user.setAge(18);
        user.setGender(gender);
        return user;
    }
}