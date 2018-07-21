package com.java.thread;

/**
 * @Auther: YSFY
 * @Date: 2018/5/31 19:23
 * @Pacage_name: com.java.thread
 * @Project_Name: javaTest
 * @Description:
 */
public class ManyThreadTest implements Runnable{

    private static volatile Integer i = 0;

    public ManyThreadTest() {}

    @Override
    public void run() {
        while(true) {
            synchronized (i) {
                if(i<100) {
                    i++;
                    System.out.println("i=" + i);
                }else {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {

        new Thread(new ManyThreadTest()).start();
        new Thread(new ManyThreadTest()).start();
    }
}
