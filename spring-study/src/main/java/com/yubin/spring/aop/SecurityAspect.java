package com.yubin.spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;

import java.util.Arrays;

/**
 * 权限认证相关切面类
 *
 * @author YUBIN
 * @create 2020-08-10
 */
public class SecurityAspect {

    public static void start(JoinPoint joinPoint) {
        // 获取签名信息, 即方法对象
        Signature signature = joinPoint.getSignature();

        // 获取参数列表
        Object[] args = joinPoint.getArgs();
        System.out.println("Security:" + signature.getName() + "方法开始执行(前置通知Before)...参数列表:" + Arrays.asList(args));
    }

    public static void stop(JoinPoint joinPoint, Object res) {
        // 获取签名信息, 即方法对象
        Signature signature = joinPoint.getSignature();

        // 获取参数列表
        Object[] args = joinPoint.getArgs();

        System.out.println("Security:" + signature.getName() + "方法正常执行结束(后置通知)...参数列表:" + Arrays.asList(args) + " ,返回值:" + res);
    }

    public static void logException(JoinPoint joinPoint, Exception ex) {
        // 获取签名信息, 即方法对象
        Signature signature = joinPoint.getSignature();

        // 获取参数列表
        Object[] args = joinPoint.getArgs();

        System.out.println("Security:" + signature.getName() + "方法执行抛出异常(异常通知), 参数列表:" + Arrays.asList(args) + ", 异常信息：" + ex.getMessage());
    }

    public static void end(JoinPoint joinPoint) {
        // 获取签名信息, 即方法对象
        Signature signature = joinPoint.getSignature();

        // 获取参数列表
        Object[] args = joinPoint.getArgs();

        System.out.println("Security:" + signature.getName() + "方法执行结束(最终通知)...over, 参数列表:" + Arrays.asList(args));
    }

    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        Object result = null;
        // 获取方法的签名,即方法对象
        Signature signature = joinPoint.getSignature();
        // 获取参数列表
        Object[] args = joinPoint.getArgs();
        try {
            System.out.println("Security:" + signature.getName() + "环绕通知目标方法执行前处理逻辑, 参数列表:" + Arrays.asList(args));
            // 利用反射调用目标方法,相当于method.invoke(args);
            result = joinPoint.proceed();
            System.out.println("Security:" + signature.getName() + "环绕通知目标方法执行后处理逻辑, 参数列表:" + Arrays.asList(args) + ",执行结果:" + result);
            return result;
        } catch (Throwable throwable) {
            System.out.println("Security:" + signature.getName() + "环绕通知目标方法执行异常处理逻辑, 参数列表:" + Arrays.asList(args) + ",异常信息:" + throwable.getMessage());
            // 如果此处不抛出异常,普通异常通知是接收不到的
            throw throwable;
        } finally {
            System.out.println("Security:" + signature.getName() + "环绕通知最终通知处理逻辑, 参数列表:" + Arrays.asList(args) + ",执行结果:" + result);
        }
    }
}
