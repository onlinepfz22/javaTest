package com.java.callback.custom;

import com.java.callback.CallBack;

/**
 * @Auther: YSFY
 * @Date: 2018/8/9 15:07
 * @Pacage_name: com.java.callback
 * @Project_Name: javaTest
 * @Description:    虚拟主题，在虚拟主题内的方法执行完后进行真实主题
 *  实现的接口中的回调接口函数调用，以返回结果
 */
public class VirtualTopic {

    public void processBusiness(CallBack callBack) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("正在执行和处理业务逻辑...");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                callBack.callBack("执行成功，返回结果为success");
            }
        }).start();
    }
}
