package com.java.map;

import java.util.Iterator;

/**
 * created by Administrator on 2018/5/21/021
 * projectName  源码分析HashSet 实现了Set接口，底层实现为HashMap   HashSet线程不安全
 */
public class HashSet {

    public static void main(String[] args) {
        java.util.HashSet hashSet = new java.util.HashSet<>();

        /*hashSet中add进去的值是按照key的方式来存储的，所以add相同的数据，只能保存一个*/

        hashSet.add("123");
        hashSet.add(null);
        hashSet.add("123");


        Iterator iterator = new java.util.HashSet<>().iterator();
    }
}
