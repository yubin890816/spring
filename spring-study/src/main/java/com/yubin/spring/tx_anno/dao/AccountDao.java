package com.yubin.spring.tx_anno.dao;

import com.yubin.spring.tx_anno.pojo.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * 账号相关持久层
 *
 * @author YUBIN
 * @create 2020-08-11
 */
@Repository
public class AccountDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int save(Account account) {
        String sql = "insert into account(username,balance) values(?,?)";
        return jdbcTemplate.update(sql, account.getUsername(), account.getBalance());
    }
}
