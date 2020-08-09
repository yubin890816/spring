package com.yubin.spring.aop_anno;

/**
 * 计算器功能接口
 *
 * @author YUBIN
 * @create 2020-08-09
 */
public interface Calculator {
    // 加法
    public int add(int i, int j);

    // 减法
    public int sub(int i, int j);

    // 乘法
    public int mul(int i, int j);

    // 除法
    public int div(int i, int j);
}
