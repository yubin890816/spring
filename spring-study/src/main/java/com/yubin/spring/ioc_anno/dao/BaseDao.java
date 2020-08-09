package com.yubin.spring.ioc_anno.dao;

/**
 * 基础Dao层
 *
 * @author YUBIN
 * @create 2020-08-09
 */
public abstract class BaseDao<T> {

    public abstract void save();
}
