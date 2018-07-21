package com.java.designModel.builder;

/***
 * 
 * @ClassName: BuilderTest  
 * @Description: TODO	设计模式之建造者模式
 * @author spring  
 * @date 2018年7月15日  
 * 
 * 		特点：
 * 			1、产品类：一般是一个较为复杂的对象，也就是说创建对象的过程比较复杂，一般会有比较多的代码量;
 * 			2、抽象建造者：引入抽象建造者的目的，是为了将建造的具体过程交与它的子类来实现。这样更容易扩展。
 * 				它规范了具体生产者有哪些部分需要建造;
 * 			3、建造者：具体建造产品的各个部分，最后返回一个产品;
 * 			4、导演类：不涉及产品的创建，只负责指导产品组件的创建和组装流程;
 * 
 * 		代码演示:以苹果手机为例子;
 * 			1、Product(产品类):苹果手机为产品(AppleMobilePhone);
 * 			2、AbstractBuilder(抽象建造者):抽象出具体的手机组装的过程
 * 			3、ConcreteBuilder(具体的建造者):富士康用于将苹果手机的各个部件组装成手机实体产品;
 * 			4、Direct(导演者)：苹果公司:指定将手机零部件按照一定的流程组装成手机
 * 			5、else(提供者,不是必须):用于生产苹果手机零部件的建造者
*/	

/*导演类:指定建造的流程*/
class Direct {
	
	/*定义组装手机产品的顺序,需要传入具体的建造者完成组装过程*/
	public void assembleMobile(Builder builder) {
		builder.addCPU();
		builder.addBattery();
		builder.addScreen();
		builder.getAppleMobilePhone();
	}
}

/*抽象建造者类*/
abstract class Builder {
	abstract void addScreen();//添加屏幕
	abstract void addBattery();//添加电池
	abstract void addCPU();//添加CPU
	
	abstract AppleMobilePhone getAppleMobilePhone();
}

/*具体建造者，按照导演类指定的手机组装顺序完成手机的组装*/
class ConcreteBuilder extends Builder {
	private AppleMobilePhone appleMobilePhone = new AppleMobilePhone();
	
	@Override
	void addScreen() {
		appleMobilePhone.setScreen("组装屏幕完成");
	}
	@Override
	void addBattery() {
		appleMobilePhone.setBattery("组装电池完成");
	}
	@Override
	void addCPU() {
		appleMobilePhone.setCPU("组装CPU完成");
	}
	@Override
	AppleMobilePhone getAppleMobilePhone() {
		return appleMobilePhone;
	}
}

/*产品类*/
class AppleMobilePhone {
	private String screen;
	private String battery;
	private String CPU;
	public String getScreen() {
		return screen;
	}
	public void setScreen(String screen) {
		this.screen = screen;
	}
	public String getBattery() {
		return battery;
	}
	public void setBattery(String battery) {
		this.battery = battery;
	}
	public String getCPU() {
		return CPU;
	}
	public void setCPU(String cPU) {
		CPU = cPU;
	}
	@Override
	public String toString() {
		return "AppleMobilePhone [screen=" + screen + ", battery=" + battery + ", CPU=" + CPU + "]";
	}
}

public class BuilderTest {
		
	public static void main(String[] args) {
		/*用户需求:获得苹果手机*/
		Builder builder = new ConcreteBuilder();//创建建造者类
		Direct direct = new Direct();//创建导演类
		direct.assembleMobile(builder);//组装手机
		System.out.println(builder.getAppleMobilePhone());//获得手机实例产品并输出
	}
}
