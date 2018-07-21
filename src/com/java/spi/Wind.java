package com.java.spi;

/**
 * @Auther: YSFY
 * @Date: 2018/6/20 15:11
 * @Pacage_name: com.java.spi
 * @Project_Name: javaTest
 * @Description:
 */
public class Wind implements Instrument {

    @Override
    public void getName(String name) {
        System.out.println(name);
    }

}
