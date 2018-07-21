package com.java.designPattern;

/**
 * 依赖倒置 面向接口编程(代理模式)
 */
interface ICar {
    void start();
    void stop();
}
class BenChi implements ICar {
    @Override
    public void start() {
        System.out.println("奔驰车开始自动驾驶....");
    }
    @Override
    public void stop() {
        System.out.println("奔驰车开始自动停止...");
    }
}
class Audi implements ICar {
    @Override
    public void start() {
        System.out.println("奥迪车开始自动驾驶....");
    }
    @Override
    public void stop() {
        System.out.println("奥迪车开始自动停止....");
    }
}
class BaoMa implements ICar {
    @Override
    public void start() { System.out.println("宝马车开始自动驾驶...."); }
    @Override
    public void stop() {
        System.out.println("宝马车开始自动停止....");
    }
}
//自动驾驶控制类
class AutoRunControl {
    private ICar icar;
    public AutoRunControl(ICar icar) { this.icar = icar; }
    public void autoRun() { icar.start(); }
    public void autoStop() { icar.stop(); }
}

public class DependencyInversion {
    public static void main(String[] args) {
        AutoRunControl autoRunControl1 = new AutoRunControl(new BenChi());
        autoRunControl1.autoRun();
        autoRunControl1.autoStop();

        AutoRunControl autoRunControl2 = new AutoRunControl(new Audi());
        autoRunControl2.autoRun();
        autoRunControl2.autoStop();
     }
}