package com.yubin.spring.ioc_anno.dao;

import com.yubin.spring.ioc_anno.bean.Teacher;
import org.springframework.stereotype.Repository;

/**
 * 教师持久层
 *
 * @author YUBIN
 * @create 2020-08-09
 */
@Repository
public class TeacherDao extends BaseDao<Teacher> {
    @Override
    public void save() {
        System.out.println("保存教师成功");
    }
}
