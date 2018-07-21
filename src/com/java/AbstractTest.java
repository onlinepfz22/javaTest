package com.java;

/**
 * Created by YSFY on 2018/5/2.
 * projectName  一个类中如果包含有抽象方法,则此类必须是抽象类
 */
public abstract class AbstractTest implements InterfaceTest{

    @Override
    public void add() {
        System.out.println("only implement InterfaceTest method add");
    }

    /**
     *  抽象类普通方法,可以给出实现也可以不给出实现
     * */
    public void abstractMethod() {
        System.out.println("abstract class method");
    }

    /**
     *  抽象类中的static方法,实现交给子类
     * */
    public static void abstractStaticMethod() {}

    /**
     *  抽象类自定义普通方法,实现交给子类
     * */
    public void customMethod() {};

    /**
     *  抽象类中的final方法,不允许被覆写
     * */
    public final void finalMethod() {}
}
