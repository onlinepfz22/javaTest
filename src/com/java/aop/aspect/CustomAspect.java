package com.java.aop.aspect;

/**
 * @Auther: YSFY
 * @Date: 2018/7/22 07:45
 * @Pacage_name: com.java.aop.jdk
 * @Project_Name: javaTest
 * @Description:
 */
public class CustomAspect {

    public void enhanceBefore() {
        System.out.println("用户未注册，可以进行注册");
    }

    public void enhanceAfter() {
        System.out.println("用户注册成功");
    }
}
