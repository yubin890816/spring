package com.yubin.spring.aop_anno;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 日志工具类
 *
 * @author YUBIN
 * @create 2020-08-09
 */
@Component
@Aspect
@Order(2)
public class LogUtil {

    /**
     * 表达式的抽取： 如果在实际使用过程中，多个方法的表达式是一致的话，那么可以考虑将切入点表达式抽取出来
     *      1、随便定义一个没有返回值的空方法(有返回值也没关系,方法中书写一些代码也没关系,不会执行)
     *      2、给方法上标注@Potintcut注解
     *      3、后续在使用的时候可以直接调用方法名称
     * 此方法只是起一个声明作用,能够供内部的其它通知方法进行调用
     */
    @Pointcut("execution(* com.yubin.spring.aop_anno.*.*(..))")
    public void myPoint() {
        System.out.println("切入点表达式");
    }

    /**
     * 设置下面方法什么时候运行
     * @Before: 在目标方法执行之前运行（前置通知）
     * @AfterReturning: 在目标方法正常返回之后运行（返回通知）
     * @AfterThrowing: 在目标方法抛出异常后开始运行（异常通知）
     * @After: 在目标方法之后运行（后置通知）
     *      通过JoinPoint可以获取Method的详细信息, 例如方法名、参数列表等
     * @Around: 环绕（环绕通知）
     *
     * Spring对通知方法的要求:
     *  Spring对应通知方法的要求并不是很高,你可以任意改变方法的返回值和方法的访问修饰符,但是唯一不能修改的就是方法的参数，会出现参数绑定的错误
     *  原因在于通知方法是Spring利用反射调用的，每次方法调用得确定这个方法的参数的值
     */

    @Before("myPoint()")
    public static void start(JoinPoint joinPoint) {
        // 获取签名信息, 即方法对象
        Signature signature = joinPoint.getSignature();

        // 获取参数列表
        Object[] args = joinPoint.getArgs();
        System.out.println("Log:" + signature.getName() + "方法开始执行(前置通知Before)...参数列表:" + Arrays.asList(args));
    }

    /**
     * 通过returning属性获取方法执行的结果
     * @param joinPoint
     * @param res 需要和通知方法的参数名称一直
     */
    @AfterReturning(value = "myPoint()", returning = "res")
    public static void stop(JoinPoint joinPoint, Object res) {
        // 获取签名信息, 即方法对象
        Signature signature = joinPoint.getSignature();

        // 获取参数列表
        Object[] args = joinPoint.getArgs();

        System.out.println("Log:" + signature.getName() + "方法正常执行结束(后置通知)...参数列表:" + Arrays.asList(args) + " ,返回值:" + res);
    }

    /**
     * 通过 throwing属性获取异常信息, throwing的属性值需要和异常通知的方法中的参数名称一致
     * @param joinPoint
     * @param ex
     */
    @AfterThrowing(value = "myPoint()", throwing = "ex")
    public static void logException(JoinPoint joinPoint, Exception ex) {
        // 获取签名信息, 即方法对象
        Signature signature = joinPoint.getSignature();

        // 获取参数列表
        Object[] args = joinPoint.getArgs();

        System.out.println("Log:" + signature.getName() + "方法执行抛出异常(异常通知), 参数列表:" + Arrays.asList(args) + ", 异常信息：" + ex.getMessage());
    }

    @After("myPoint()")
    public static void end(JoinPoint joinPoint) {
        // 获取签名信息, 即方法对象
        Signature signature = joinPoint.getSignature();

        // 获取参数列表
        Object[] args = joinPoint.getArgs();

        System.out.println("Log:" + signature.getName() + "方法执行结束(最终通知)...over, 参数列表:" + Arrays.asList(args));
    }

    @Around("myPoint()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        Object result = null;
        // 获取方法的签名,即方法对象
        Signature signature = joinPoint.getSignature();
        // 获取参数列表
        Object[] args = joinPoint.getArgs();
        try {
            System.out.println("Log:" + signature.getName() + "环绕通知目标方法执行前处理逻辑, 参数列表:" + Arrays.asList(args));
            // 利用反射调用目标方法,相当于method.invoke(args);
            result = joinPoint.proceed();
            System.out.println("Log:" + signature.getName() + "环绕通知目标方法执行后处理逻辑, 参数列表:" + Arrays.asList(args) + ",执行结果:" + result);
            return result;
        } catch (Throwable throwable) {
            System.out.println("Log:" + signature.getName() + "环绕通知目标方法执行异常处理逻辑, 参数列表:" + Arrays.asList(args) + ",异常信息:" + throwable.getMessage());
            // 如果此处不抛出异常,普通异常通知是接收不到的
            throw throwable;
        } finally {
            System.out.println("Log:" + signature.getName() + "环绕通知最终通知处理逻辑, 参数列表:" + Arrays.asList(args) + ",执行结果:" + result);
        }
    }
}
