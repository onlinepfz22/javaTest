package com.java.aop.cglib;

import com.java.aop.aspect.CustomAspect;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Auther: YSFY
 * @Date: 2018/7/22 09:26
 * @Pacage_name: com.java.aop.cglib
 * @Project_Name: javaTest
 * @Description:    基于Cglib的动态代理，此代理方式可以直接代理实现类
 */
public class CGlibDynamicProxy implements MethodInterceptor {

    private CustomAspect customAspect = new CustomAspect();

    //创建代理类的属性
    private Enhancer enhancer = new Enhancer();

    /***
     *
     * @param clazz   需被代理的真是主题类对象
     * @return  产生代理类对象，代表是对哪个类进行代理
     */
    public Object getProxy(Class clazz) {
        //设置创建子类的类,也就是为哪个类来创建我们的代理类，参数为被代理类
        enhancer.setSuperclass(clazz);
        //设置回调
        enhancer.setCallback(this);

        //创建代理类实例并返回
        return enhancer.create();
    }

    /**
     * 此方法用于拦截所有目标类中方法的调用,只要目标类方法被调用就能触发该方法
     * @param obj 目标类实例
     * @param method 目标方法的反射对象
     * @param objects 目标类中方法的参数
     * @param methodProxy 代理类的实例
     *
     * @return 返回代理类实例
     * */
    @Override
    public Object intercept(Object obj, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        customAspect.enhanceBefore();

        //代理调用父类方法
        /**
         * 因为cglib采用继承的方式，所以产生的代理类的方式为父类的子类
         * */
        Object object = methodProxy.invokeSuper(obj, objects);
        customAspect.enhanceAfter();

        return object;
    }
}
