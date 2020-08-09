package com.yubin.spring.ioc_anno.service;

import com.yubin.spring.ioc_anno.bean.Teacher;
import org.springframework.stereotype.Service;

/**
 * 教师业务层
 *
 * @author YUBIN
 * @create 2020-08-09
 */
@Service
public class TeacherService extends BaseService<Teacher> {

    /*@Autowired
    private TeacherDao teacherDao;

    public void save() {
        teacherDao.save();
    }*/
}
