package com.yubin.spring.tx_anno.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileNotFoundException;

/**
 * 验证事务传播行为的业务层
 *
 * @author YUBIN
 * @create 2020-08-12
 */
@Service
public class MulService {

    @Autowired
    private BookService bookService;

    @Transactional
    public void mulTx() throws FileNotFoundException {
        bookService.checkout("lisi",1);
        bookService.updatePrice(1,1000);
        int i = 1 / 0;
    }
}
