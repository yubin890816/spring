package com.yubin.springmvc.pojo;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.util.Date;

/**
 * 用户实体类
 *
 * @author YUBIN
 * @create 2020-08-16
 */
public class User {

    @NotNull(message = "编号不能为空")
    private Integer id;

    @Length(min = 3,max = 10, message = "姓名长度在3~10")
    private String name;

    private Integer age;

    @NotNull(message = "日期不能为空")
    @Past(message = "生日参数不合法")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    @Length(min = 1, message = "邮箱不能为空")
    @Email(message = "邮箱格式不正确")
    private String email;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
                ", email='" + email + '\'' +
                ", address=" + address +
                '}';
    }
}
