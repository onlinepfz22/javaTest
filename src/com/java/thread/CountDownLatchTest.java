package com.java.thread;

import java.util.concurrent.CountDownLatch;

/**
 * @Auther: YSFY
 * @Date: 2018/6/15 09:59
 * @Pacage_name: com.java.thread
 * @Project_Name: javaTest
 * @Description:
 */
public class CountDownLatchTest {

    public static void main(String[] args) {
        final int count = 10; // 计数次数
        final CountDownLatch latch = new CountDownLatch(count);
        for (int i = 0; i < count; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        // do anything
                        System.out.println(Thread.currentThread().getName() + "完成任务");
                    } catch (Throwable e) {
                        // whatever
                    } finally {
                        // 很关键, 无论上面程序是否异常必须执行countDown,否则await无法释放
                        latch.countDown();
                    }
                }
            }).start();
        }
        try {
            // 10个线程countDown()都执行之后才会释放当前线程,程序才能继续往后执行
            latch.await();
        } catch (InterruptedException e) {
            // whatever
        }
        System.out.println("Finish");
    }
}
