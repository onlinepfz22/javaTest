package com.java.callback.custom;

import com.java.callback.CallBack;

/**
 * @Auther: YSFY
 * @Date: 2018/8/9 15:05
 * @Pacage_name: com.java.callback
 * @Project_Name: javaTest
 * @Description:
 */
public class MainTopic implements CallBack{

    //持有虚拟主题的引用
    private VirtualTopic virtualTopic;

    public MainTopic(VirtualTopic virtualTopic) {
        this.virtualTopic = virtualTopic;
    }

    /**
     * 执行业务
     */
    public void executeBusiness() {
        this.virtualTopic.processBusiness(this);
    }

    /**
     * 实现接口回调函数
     * @param result
     */
    @Override
    public void callBack(String result) {
        System.out.println("接口回调结果为: " + result);
    }
}
