package com.yubin.spring.jdk_proxy;

/**
 * 计算器功能实现类
 *
 * @author YUBIN
 * @create 2020-08-09
 */
public class MyCalculator implements Calculator {
    @Override
    public int add(int i, int j) {
        //System.out.println("add 方法开始执行，参数i：" + i + ",j:" + j);
        //LogUtil.start(i, j);
        int result = i + j;
        //System.out.println("add 方法执行完成结果为：" + result);
        //LogUtil.stop(result);
        return result;
    }

    @Override
    public int sub(int i, int j) {
        //System.out.println("sub 方法开始执行，参数i：" + i + ",j:" + j);
        //LogUtil.start(i, j);
        int result = i - j;
        //System.out.println("sub 方法执行完成结果为：" + result);
        //LogUtil.stop(result);
        return result;
    }

    @Override
    public int mul(int i, int j) {
        //System.out.println("mul 方法开始执行，参数i：" + i + ",j:" + j);
        //LogUtil.start(i, j);
        int result = i * j;
        //System.out.println("mul 方法执行完成结果为：" + result);
        //LogUtil.stop(result);
        return result;
    }

    @Override
    public int div(int i, int j) {
        //System.out.println("div 方法开始执行，参数i：" + i + ",j:" + j);
        //LogUtil.start(i, j);
        int result = i / j;
        //System.out.println("div 方法执行完成结果为：" + result);
        //LogUtil.stop(result);
        return result;
    }
}
