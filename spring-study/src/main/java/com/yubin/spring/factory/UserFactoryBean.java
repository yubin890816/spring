package com.yubin.spring.factory;

import com.yubin.spring.bean.User;
import org.springframework.beans.factory.FactoryBean;

/**
 * 创建user对象的factoryBean
 *  实现了FactoyBean接口的类是Spring中可以识别的工厂类,Spring会自动调用工厂方法创建实例
 *  此方式是Spring创建Bean方式的一种补充,用户可以按照需求创建对象
 *  创建的对象交由Spring IOC容器进行管理
 *  无论是否单例,都是在用到的时候才去创建对象(区别在于单例对象只在第一次使用的时候创建一次), 不用该对象不会创建
 * @author YUBIN
 * @create 2020-08-08
 */
public class UserFactoryBean implements FactoryBean<User> {

    /**
     * 工厂方法,返回需要创建的对象
     * @return
     * @throws Exception
     */
    public User getObject() throws Exception {
        User user = new User();
        user.setName("使用实现FactoryBean接口的方式创建bean对象");
        return user;
    }

    /**
     * 返回创建对象的类型,Spring会自动调用该方法返回对象的类型
     * @return
     */
    public Class<?> getObjectType() {
        return User.class;
    }

    /**
     * 创建的对象是否是单例对象
     * @return
     */
    public boolean isSingleton() {
        return true;
    }
}