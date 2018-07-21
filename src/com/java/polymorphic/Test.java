package com.java.polymorphic;

/**
 * @Auther: YSFY
 * @Date: 2018/6/19 07:21
 * @Pacage_name: com.java.polymorphic
 * @Project_Name: javaTest
 * @Description:    测试多态
 */

enum Note {
    MUDDlE_C, C_CHARP, B_FLAT;
}

class Instrument {

    public String name = "abc";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private int a = 10;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    void play(Note note) {
        System.out.println("Instrument play():" + note);
    }

    String what() { return "Instrument"; }

    void adjust() {
        System.out.println("Adjusting Instrument");
    }
}

class Wind extends Instrument {

    public String name = "def";

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    private int a = 11;

    @Override
    public int getA() {
        return a;
    }

    @Override
    public void setA(int a) {
        this.a = a;
    }

    void play(Note note) {
        System.out.println("Wind play():" + note);
    }

    String what() { return "Wind"; }

    void adjust() {
        System.out.println("Adjusting Wind");
    }
}

class Percussion extends Instrument {
    void play(Note note) {
        System.out.println("Percussion play():" + note);
    }

    String what() { return "Percussion"; }

    void adjust() {
        System.out.println("Percussion Wind");
    }
}

class Stringed extends Instrument {
    void play(Note note) {
        System.out.println("Stringed play():" + note);
    }

    String what() { return "Stringed"; }

    void adjust() {
        System.out.println("Stringed Wind");
    }
}

public class Test {

    public static void main(String[] args) {
        /*Instrument instrument = new Wind();
        instrument.play(Note.MUDDlE_C);
        System.out.println(instrument.what());
        instrument.adjust();*/

        Instrument instrument = new Wind();
        System.out.println(instrument.getA());  //
        System.out.println(instrument.name);    //abc
        System.out.println(instrument.getName());//def

        Wind wind = new Wind();
        System.out.println(wind.getA());
        System.out.println(wind.name);
        System.out.println(wind.getName());
    }
}
