package com.java.thread;

/**
 * Created by YSFY on 2018/5/16.
 * projectName
 */


class Emp {
    public int age;
}

public class ThreadTest{


    static Thread thread1 = new Thread(new Runnable() {
        @Override
        public void run() {
            System.out.println("thread1");
        }
    });

    static Thread thread2 = new Thread(new Runnable() {
        @Override
        public void run() {
            System.out.println("thread2");
        }
    });

    static Thread thread3 = new Thread(new Runnable() {
        @Override
        public void run() {
            System.out.println("thread3");
        }
    });

    public static void main(String[] args) {
        /*ExecutorService executorService = Executors.newSingleThreadExecutor();

        executorService.submit(thread1);
        executorService.submit(thread2);
        executorService.submit(thread3);*/
/*        thread1.start();
        thread2.start();
        thread3.start();*/

        /*Integer值传递*/
        /*Integer a = new Integer(1),b = new Integer(2);
        System.out.println("before: a = " + a + ", b = " + b);

        swap(a,b);

        System.out.println("before: a = " + a + ", b = " + b);*/

        Emp emp = new Emp();
        emp.age = 100;
        System.out.println(emp.age);
        change(emp);
        System.out.println(emp.age);
        System.out.println(emp.age);
    }

    public static void change(Emp emp) {
        emp.age = 50;
        emp = new Emp();//再创建一个对象
        emp.age=100;
    }

    /**
     * 这里看似a,b传递的是引用传递,实则传递的是主方法a,b引用对象的副本,也就是在
     * swap方法中对a,b操作时副本操作而不是主本操作
     * */
    public static void swap(Integer a, Integer b) {
        Integer swap = a;
        a = b;
        b = swap;

        System.out.println("inner: a = " + a + ", b = " + b);
    }

}
