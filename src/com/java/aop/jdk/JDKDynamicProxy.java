package com.java.aop.jdk;

import com.java.aop.aspect.CustomAspect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Auther: YSFY
 * @Date: 2018/7/22 07:43
 * @Pacage_name: com.java.aop.jdk
 * @Project_Name: javaTest
 * @Description:    基于jdk的动态代理，此代理方式必须代理实现了接口的类
 */
public class JDKDynamicProxy {

    private final static CustomAspect customAspect = new CustomAspect();

    /***
     *
     * @param obj   真实主题角色，即被代理类对象
     * @return  返回被代理类对象
     * @Description 通过创建代理类对象完成对真实业务类的代理，通过代理类对象调用真实业务类的方法，并在调用里完成业务增强处理
     */
    public static Object createProxy(Object obj) {

        Object tempObj = Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                customAspect.enhanceBefore();//前置增强
                Object result = method.invoke(obj,args);
                customAspect.enhanceAfter();//后置增强

                return result;
            }
        });

        return tempObj;
    }
}
