package com.yubin.spring.ioc_anno.service;

import com.yubin.spring.ioc_anno.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户业务层
 *
 * @author YUBIN
 * @create 2020-08-09
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public void save() {
        System.out.println("UserService......");
        userDao.save();
    }
}