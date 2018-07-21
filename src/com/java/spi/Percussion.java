package com.java.spi;

/**
 * @Auther: YSFY
 * @Date: 2018/6/20 15:12
 * @Pacage_name: com.java.spi
 * @Project_Name: javaTest
 * @Description:
 */
public class Percussion implements Instrument {

    @Override
    public void getName(String name) {
        System.out.println(name);
    }

}
