package com.yubin.spring.bean;

/**
 * 地址实体类
 *
 * @author YUBIN
 * @create 2020-08-07
 */
public class Address {

    private String province;

    private String city;

    private String town;

    public Address() {
        System.out.println("Address被创建");
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    @Override
    public String toString() {
        return "Address{" +
                "province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", town='" + town + '\'' +
                '}';
    }
}