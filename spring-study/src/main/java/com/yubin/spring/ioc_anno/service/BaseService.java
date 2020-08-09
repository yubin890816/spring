package com.yubin.spring.ioc_anno.service;

import com.yubin.spring.ioc_anno.dao.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 基础业务层
 *
 * @author YUBIN
 * @create 2020-08-09
 */
public abstract class BaseService<T> {

    @Autowired
    private BaseDao<T> baseDao;

    public void save() {
        baseDao.save();
    }
}