package com.yubin.spring.ioc_anno.service;

import com.yubin.spring.ioc_anno.bean.Student;
import org.springframework.stereotype.Service;

/**
 * 学生业务层
 *
 * @author YUBIN
 * @create 2020-08-09
 */
@Service
public class StudentService extends BaseService<Student> {

    /*@Autowired
    private StudentDao studentDao;

    public void save() {
        studentDao.save();
    }*/
}
