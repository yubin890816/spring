package com.yubin.spring.tx_anno.service;

import com.yubin.spring.tx_anno.dao.BookDao;
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

    /**
     * 结账：传入哪个用户买了哪本书
     *     timeout：事务超出指定执行时长后自动终止并回滚,单位是秒
     *     readOnly：设置事务是否为只读事务	, 如果配置事务为只读事务，那么在事务运行期间，不允许对数据进行修改，否则抛出异常(注意：其它事务还是可以修改数据的)
     *     noRollbackFor：那些异常事务可以不回滚
     *     noRollbackForClassName：填写的参数是全类名
     *     rollbackFor：哪些异常事务需要回滚
     *     rollbackForClassName：填写的参数是全类名
     *     isolation：设置事务的隔离级别
     *     propagation：事务的传播行为
     * @param username
     * @param id
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void checkout(String username, int id) throws FileNotFoundException {
        bookDao.updateStock(id);
        int price = bookDao.getPrice(id);
        //int i = 1 / 0;
        /*try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        //new FileInputStream("aaa.txt");
        bookDao.updateBalance(username, price);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void updatePrice(int id,int price){
        bookDao.updatePrice(id, price);
        //int i = 1/0;
    }
}