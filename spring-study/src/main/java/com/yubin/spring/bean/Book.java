package com.yubin.spring.bean;

/**
 * 书籍的实体类
 *
 * @author YUBIN
 * @create 2020-08-07
 */
public class Book {

    private Integer id;

    private String name;

    public Book() {
        System.out.println("Book被创建了");
    }

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

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}