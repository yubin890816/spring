package com.yubin.spring.ioc_anno.dao;

import org.springframework.stereotype.Repository;

/**
 * 用户持久层
 *
 * @author YUBIN
 * @create 2020-08-09
 */
@Repository
public class UserDao {

    public void save() {
        System.out.println("保存成功");
    }

    public void update() {
        System.out.println("更新成功");
    }
}