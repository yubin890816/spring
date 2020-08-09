package com.yubin.spring.aop_anno;

import org.springframework.stereotype.Service;

/**
 * 计算器功能实现类
 *
 * @author YUBIN
 * @create 2020-08-09
 */
@Service
public class MyCalculator /*implements Calculator*/ {
    //@Override
    public int add(int i, int j) {
        int result = i + j;
        return result;
    }

    //@Override
    public int sub(int i, int j) {
        int result = i - j;
        return result;
    }

    //@Override
    public int mul(int i, int j) {
        int result = i * j;
        return result;
    }

    //@Override
    public int div(int i, int j) {
        int result = i / j;
        return result;
    }

    public void show() {

    }
}
