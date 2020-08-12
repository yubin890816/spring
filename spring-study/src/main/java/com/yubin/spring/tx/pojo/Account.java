package com.yubin.spring.tx.pojo;

/**
 * 账号实体类
 *
 * @author YUBIN
 * @create 2020-08-11
 */
public class Account {

    private String username;

    private Integer balance;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "username='" + username + '\'' +
                ", balance=" + balance +
                '}';
    }
}
