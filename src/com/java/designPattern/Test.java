package com.java.designPattern;

class OutSide {

    private static OutSide outside;

    private String name = "outside";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private OutSide() {

    }

    /**
     * 私有的OutSide构造方法，外部类在通过new实例化
     * OutSide类的对象时将无法正确实例化，此种方式
     * 被用于使用在工厂模式中
     * */
    private OutSide(String name) {
        this.setName(name);
    }

    public static OutSide newInstance(String name) {

        if(null == outside) {
            outside = new OutSide(name);
        }

        return outside;
    }

    public void print() {
        System.out.println(this.getName());
    }
}

public class Test {
    public static void main(String[] args) {
        OutSide.newInstance("hello world").print();
    }
}