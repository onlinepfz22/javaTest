package com.java.aop;

import com.java.aop.cglib.CGlibDynamicProxy;
import com.java.aop.jdk.JDKDynamicProxy;
import com.java.aop.service.UserService;
import com.java.aop.service.UserServiceImpl;

import java.lang.reflect.Proxy;

/**
 * @Auther: YSFY
 * @Date: 2018/7/22 00:17
 * @Pacage_name: com.java.aop
 * @Project_Name: javaTest
 * @Description:
 */
public class Test {

    public static void main(String[] args) {

        /**
         * 基于jdk的动态代理
         *  1、创建代理工厂，用于创建代理对象，需给代理工厂类的createProxy()方法传递真实主题角色，即代理工厂要给哪个类进行代理
         *  2、代理工厂中引入增强逻辑实现类对象，用于代理对象调用真实主题角色方法前后完成业务增强
         * */
        /*UserService userService = (UserService) JDKDynamicProxy.createProxy(new UserServiceImpl());
        System.out.println(userService.addUser());*/

        CGlibDynamicProxy cGlibDynamicProxy = new CGlibDynamicProxy();
        UserServiceImpl userServiceImpl = (UserServiceImpl) cGlibDynamicProxy.getProxy(UserServiceImpl.class);
        userServiceImpl.addUser();
    }
}
