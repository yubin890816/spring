package com.yubin.spring.jdk_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * jdk动态代理工厂类
 *
 * @author YUBIN
 * @create 2020-08-09
 */
public class JdkProxyFactory implements InvocationHandler {

    // 目标对象
    private Object target;

    public JdkProxyFactory(Object target) {
        this.target = target;
    }

    /**
     * 获取目标对象的代理对象
     * @return
     */
    public Object getProxy() {
        /**
         * 参数1: 目标对象的类加载器
         * 参数2: 目标对象的接口列表
         * 参数3: 方法执行器. 执行被代理对象的方法
         */
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    /**
     * 执行目标方法的入口方法
     *
     * @param proxy  代理对象,给jdk使用, 任何时候都不要操作此对象
     * @param method 当前要执行的目标对象的方法
     * @param args   这个方法执行时外界传入的参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        try {
            System.out.println(method.getName() + "方法开始执行...");
            // 利用反射执行目标方法
            result = method.invoke(target, args);
            System.out.println(method.getName() + "方法执行完成, 结果是:" + result);
        } catch (Exception e) {
            System.out.println(method.getName() + "方法执行异常,异常信息:" + e);

        } finally {
            System.out.println(method.getName() + "方法执行结束了...");
        }
        return result;
    }
}
