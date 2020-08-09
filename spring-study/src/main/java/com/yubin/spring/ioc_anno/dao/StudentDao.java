package com.yubin.spring.ioc_anno.dao;

import com.yubin.spring.ioc_anno.bean.Student;
import org.springframework.stereotype.Repository;

/**
 * 学生持久层
 *
 * @author YUBIN
 * @create 2020-08-09
 */
@Repository
public class StudentDao extends BaseDao<Student> {

    @Override
    public void save() {
        System.out.println("保存学生成功");
    }
}
