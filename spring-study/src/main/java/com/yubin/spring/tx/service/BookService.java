package com.yubin.spring.tx.service;

import com.yubin.spring.tx.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileNotFoundException;

/**
 * 书本相关业务层
 *
 * @author YUBIN
 * @create 2020-08-11
 */
@Service
public class BookService {

    @Autowired
    private BookDao bookDao;

    public void checkout(String username, int id) throws FileNotFoundException {
        bookDao.updateStock(id);
        int price = bookDao.getPrice(id);
        bookDao.updateBalance(username, price);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void updatePrice(int id,int price){
        bookDao.updatePrice(id, price);
    }
}