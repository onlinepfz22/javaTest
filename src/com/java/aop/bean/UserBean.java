package com.java.aop.bean;

/**
 * @Auther: YSFY
 * @Date: 2018/7/21 23:10
 * @Pacage_name: com.java.aop.jdk
 * @Project_Name: javaTest
 * @Description:    用户类
 */
public class UserBean {

    private String userName;

    private String password;

    private String sex;

    private Integer age;

    private String address;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
