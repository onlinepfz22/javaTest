package com.java.callback.custom;

/**
 * @Auther: YSFY
 * @Date: 2018/8/9 15:12
 * @Pacage_name: com.java.callback
 * @Project_Name: javaTest
 * @Description:    测试java接口回调
 */
public class CallBackTest {
    public static void main(String[] args) {
        MainTopic mainTopic = new MainTopic(new VirtualTopic());
        mainTopic.executeBusiness();
    }
}
