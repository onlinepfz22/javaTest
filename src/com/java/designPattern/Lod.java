package com.java.designPattern;

/***
 * 迪米特法则
 */

interface IDepartment {
    void installSystem();
    void fixComputer();
}
//部门员工A进行电脑操作
class PersonA implements IDepartment {

    @Override
    public void installSystem() {
        System.out.println("部门A员工进行安装系统操作...");
    }

    @Override
    public void fixComputer() {
        System.out.println("部门A员工进行修复电脑操作...");
    }
}

class PersonB implements IDepartment {

    @Override
    public void installSystem() {
        System.out.println("部门B员工进行安装系统操作...");
    }

    @Override
    public void fixComputer() {
        System.out.println("部门B员工进行修复电脑操作...");
    }
}

//迪米特法则：通过引入第三方代理进行请求处理,客户段只需要
//关心administrator对象即可，传递需要部门哪位员工进行处理
//即可
class Administrator {
    public Administrator(IDepartment iDepartment) {
        iDepartment.installSystem();
        iDepartment.fixComputer();
    }
}

/**
 * 四种角色：教父，教父的心腹，杀手，被杀的人
 *    业务：教父需要杀掉对立的人
 *
 *    (1)、教父通过告诉心腹要解决掉与自己对立的人，教父只需要告知杀人即可，不用管谁去杀，怎么杀，知道结果就好
 *    (2)、心腹会通过联系具体筛选出来的杀手来完成刺杀任务，具体刺杀方式可以以心腹告知杀手具体的刺杀方式，也可以通过杀手提供具体的方式供
 *      心腹进行选择一种刺杀方式从而执行刺杀任务
 *    (3)、杀手根据商量好的刺杀方式执行具体的刺杀任务
 *
 *    四个角色四个类，教父类与心腹类为朋友类，心腹类与杀手类为朋友类，杀手类与被杀的人类为朋友类，
 *      迪米特法则为，只有朋友之间的类可以进行通信，陌生类之间无需进行通信，降低耦合，每个类负责
 *      完成自己的业务功能，减少自己类负责的业务功能侵入到朋友类中，自己类中只需朋友类的对象即可
 *
 * */
//被刺杀的人
class Person {
    private String name = "希特勒";
    public Person() {}
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}

//杀手
class Killer {
    private String name;
    private Person person = new Person();
    public Killer(String name) {
        this.name = name;
    }

    public String kill() {
        return !person.getName().equals(this.name)?"刺杀失败":"刺杀完成，刺杀的人为：" + person.getName();
    }
}

//心腹
class CoreMember {
    private String name;
    private Killer killer;
    public CoreMember(String name) {
        this.name = name;
        this.killer = new Killer(this.name);
    }
    public String invokeKill() {
        return this.killer.kill();
    }
}

public class Lod {

    public static void main(String[] args) {
        /*测试方法一*/
        Administrator administrator1 = new Administrator(new PersonA());
        Administrator administrator2 = new Administrator(new PersonB());

        System.out.println("********************************************************");

        /*测是方法二：Lod模拟教父类,教父类只需将自己的要杀的人的姓名告诉心腹就可以*/
        CoreMember coreMember = new CoreMember("希特勒");
        System.out.println("刺杀任务结果为: " + coreMember.invokeKill());
    }
}