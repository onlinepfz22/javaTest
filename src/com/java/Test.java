package com.java;

/**
 * Created by YSFY on 2018/5/2.
 * projectName  继承抽象类的子类不能覆写父类抽象类中的static和final修饰的方法
 */
public class Test extends AbstractTest{


    @Override
    public void customMethod() {

    }

    @Override
    public void delete() {
        System.out.println("only implement InterfaceTest method delete");
    }

    @Override
    public void query() {
        System.out.println("only implement InterfaceTest method query");
    }

    @Override
    public void update() {
        System.out.println("only implement InterfaceTest method update");
    }
}
