package com.yubin.spring.bean;

/**
 * 用户的实体类
 *
 * @author YUBIN
 * @create 2020-08-07
 */
public class User {

    private int id;

    private String name;

    private int age;

    private String gender;

    public User() {
        System.out.println("User被创建了");
    }

    public User(int id, String name, int age, String gender) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public User(int id, String name, String gender) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        System.out.println("gender...");
    }

    public User(int id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
        System.out.println("age...");
    }

    public void init() {
        System.out.println("初始化方法被调用...");
    }

    public void destroy() {
        System.out.println("销毁方法被调用了...");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }
}