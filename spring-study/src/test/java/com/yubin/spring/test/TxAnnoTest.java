package com.yubin.spring.test;

import com.alibaba.druid.pool.DruidDataSource;
import com.yubin.spring.tx_anno.dao.AccountDao;
import com.yubin.spring.tx_anno.pojo.Account;
import com.yubin.spring.tx_anno.service.BookService;
import com.yubin.spring.tx_anno.service.MulService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 事务注解形式测试类
 *
 * @author YUBIN
 * @create 2020-08-11
 */
public class TxAnnoTest {

    /**
     * 验证数据源
     */
    @Test
    public void test1() throws SQLException {
        ApplicationContext context = new ClassPathXmlApplicationContext("tx_anno/spring-anno-tx01.xml");
        DataSource dataSource = context.getBean("dataSource", DruidDataSource.class);
        System.out.println(dataSource);
        System.out.println(dataSource.getConnection());
    }

    /**
     * 测试JdbcTemplate
     */
    @Test
    public void test2() {
        ApplicationContext context = new ClassPathXmlApplicationContext("tx_anno/spring-anno-tx01.xml");
        JdbcTemplate jdbcTemplate = context.getBean("jdbcTemplate", JdbcTemplate.class);
        System.out.println(jdbcTemplate);
    }

    /**
     * JdbcTemplate插入数据
     */
    @Test
    public void test3() {
        ApplicationContext context = new ClassPathXmlApplicationContext("tx_anno/spring-anno-tx01.xml");
        JdbcTemplate jdbcTemplate = context.getBean("jdbcTemplate", JdbcTemplate.class);
        String sql = "insert into account(username,balance) values(?,?)";
        int count = jdbcTemplate.update(sql, "wangwu", 1000);
        System.out.println(count);
    }

    /**
     * JdbcTemplate批量插入数据
     */
    @Test
    public void test4() {
        ApplicationContext context = new ClassPathXmlApplicationContext("tx_anno/spring-anno-tx01.xml");
        JdbcTemplate jdbcTemplate = context.getBean("jdbcTemplate", JdbcTemplate.class);
        String sql = "insert into account(username,balance) values(?,?)";
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"xiaohong", 100});
        list.add(new Object[]{"xiaozhang", 200});
        list.add(new Object[]{"xiaohua", 300});
        int[] result = jdbcTemplate.batchUpdate(sql, list);
        System.out.println(result);
    }

    /**
     * JdbcTemplate查询某个值并以对象返回
     */
    @Test
    public void test5() {
        ApplicationContext context = new ClassPathXmlApplicationContext("tx_anno/spring-anno-tx01.xml");
        JdbcTemplate jdbcTemplate = context.getBean("jdbcTemplate", JdbcTemplate.class);
        String sql = "select * from account where balance = ?";
        List<Account> accounts = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Account.class), 1000);
        System.out.println(accounts);
    }

    /**
     * JdbcTemplate查询组合函数的值
     */
    @Test
    public void test6() {
        ApplicationContext context = new ClassPathXmlApplicationContext("tx_anno/spring-anno-tx01.xml");
        JdbcTemplate jdbcTemplate = context.getBean("jdbcTemplate", JdbcTemplate.class);
        String sql = "select max(balance) from account";
        BigDecimal bigDecimal = jdbcTemplate.queryForObject(sql, BigDecimal.class);
        System.out.println(bigDecimal);
    }

    /**
     * JdbcTemplate 结合持久层测试
     */
    @Test
    public void test7() {
        ApplicationContext context = new ClassPathXmlApplicationContext("tx_anno/spring-anno-tx01.xml");
        AccountDao accountDao = context.getBean("accountDao", AccountDao.class);
        Account account = new Account();
        account.setUsername("小明");
        account.setBalance(600);
        accountDao.save(account);
    }

    /**
     * Spring事务测试
     */
    @Test
    public void test8() throws FileNotFoundException {
        ApplicationContext context = new ClassPathXmlApplicationContext("tx_anno/spring-anno-tx01.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        bookService.checkout("lisi", 1);
    }

    /**
     * 测试Spring事务的传播行为
     *   事务的传播特性指的是一个事务方法被另一个事务方法调用时,这个事务如何进行？
     *   Spring事务的传播行为一共有7种：
     *      REQUIRED：如果有事务在运行，当前的方法就在这个事务内运行，否则，就启动一个新的事务，并在自己的事务内运行
     *      REQUIRED_NEW：当前的方法必须启动新的事务，并在自己的事务内运行，如果有事务在运行，应该将它挂起
     *      SUPPORTS：如果有事务在运行，当前的方法就在这个事务内运行，否则它可以不运行在事务中
     *      NOT_SUPPORTED：当前的方法不应该运行在事务中，如果中运行的事务，则将它挂起
     *      MANDATORY：当前的方法必须运行在事务的内部，如果没有正在运行的事务，就抛出异常
     *      NEVER：当前的方法不应该运行在事务中，如果有运行的事务，就抛出异常
     *      NESTED：如果有实物在运行，当前的方法就应该在这个事务的嵌套事务内运行，否则，就启动一个新的事务，并在自己的事务内运行
     */
    @Test
    public void test9() throws FileNotFoundException {
        ApplicationContext context = new ClassPathXmlApplicationContext("tx_anno/spring-anno-tx01.xml");
        MulService mulService = context.getBean("mulService", MulService.class);
        mulService.mulTx();
    }
}
