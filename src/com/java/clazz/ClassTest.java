package com.java.clazz;

/**
 * Created by YSFY on 2018/5/3.
 * projectName
 */

class Iphone {

    public Iphone() {}

}


public class ClassTest {

    public static void main(String[] args) {
        Iphone iphone = new Iphone();

        System.out.println(iphone.getClass());
        System.out.println(Iphone.class);
        System.out.println(iphone.getClass() == Iphone.class);

        String str1 = iphone.getClass().getResource("").getFile();  //输出当前路径是当前类所在目录,即ClassTest类所在路径
        String str2 = iphone.getClass().getClassLoader().getResource("").getFile(); //输出项目的根目录

        System.out.println(str1);
        System.out.println(str2);
    }
}
