package com.java.designPattern;

/**
 * 里氏替换原则
 */
class BaseClass {
    private String baseClassName;

    public BaseClass() {}

    public void print() {
        System.out.println("父类的basePrint方法");
    }

    public void add(int a, int b) {
        System.out.println("父类中的加法计算结果为：" + (a+b));
    }

    public void test() {
        System.out.println("父类的test方法");
    }
}

class SubClass extends BaseClass {
    private String subClassName;

    public SubClass() {}

    public void print() {
        System.out.println("子类的subPrint方法");
    }

    public void add(int a, int b) {
        System.out.println("子类中的加法计算结果为：" + (a+b));
    }

    public void des(int a, int b) {
        System.out.println("子类中的减法计算结果为：" + (a-b));
    }
}

class Proxy {

    /**
     *  Operate方法中参数会有两种情况：
     *      第一种：采取基类BaseClass类对象作为形参；
     *          (1)、此参数可以接收BaseClass类型的实例对象，也可以接收继承自BaseClass类子类实例对象
     *          (2)、方法中调用的具体方法会根据传入参数的类型是基类还是基类的子类选择性的调用，但前提是调用的方法必须在基类和子类中都存在
     *      第二种：采取基类BaseClass类的子类SubClass作为形参；
     *          (1)、此时只能接收继承于BaseClass的特定子类SubClass的对象进行方法调用
     * */
    public void operate(BaseClass tempClass) {
        tempClass.print();
        tempClass.add(5, 3);
        tempClass.test();
    }
}

public class RichterReplacement {

    public static void main(String[] args) {
        Proxy proxyP = new Proxy();
        proxyP.operate(new SubClass());
    }
}