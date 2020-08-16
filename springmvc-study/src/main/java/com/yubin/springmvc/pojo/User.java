package com.yubin.springmvc.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 用户实体类
 *
 * @author YUBIN
 * @create 2020-08-16
 */
public class User {

    private Integer id;

    private String name;

    private Integer age;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    private Address address;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                ", address=" + address +
                '}';
    }
}
