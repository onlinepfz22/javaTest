package com.java.designModel.abstractFactory;

/***
 * 
 * @ClassName: ApproveTest 
 * @Description: 设计模式之工厂模式 (简单工厂模式)
 * @author spring  
 * @date 2018年7月15日  
 * 
 * 	以建造汽车为例子：
 * 
 * 		接口工厂：汽车工厂用于根据指定的品牌信息创建对应的汽车
 * 
 * 		汽车接口：定义记本的汽车属性以及汽车创造汽车的通用方法
 * 
 * 		汽车属性：发动机，轮胎，方向盘，车门，挡风玻璃，油箱等属性
 *	
*/	
/*汽车工厂*/
interface IVehicleFactory { 
	IVehiclei createVihicle(IVehiclei ivehicle);
}

/*汽车工厂实现类*/
class VehicleFactoryImpl implements IVehicleFactory {
	public static VehicleFactoryImpl vehicleFactory = null;
	public static VehicleFactoryImpl createVehicleFactory() {
		if(null == vehicleFactory) {
			vehicleFactory = new VehicleFactoryImpl();
			return vehicleFactory;
		}
		return vehicleFactory;
	}
	
	@Override
	public IVehiclei createVihicle(IVehiclei ivehicle) {
		return ivehicle.create();
	}
}

/*汽车接口*/
interface IVehiclei { IVehiclei create();}

class VehiclePropertiesi {
	String engine = "";//引擎
	String tyre = "";//轮胎
	String steeringWheel = "";//方向盘
	String vehicleDoor = "";//车门
	String windshield = "";//挡风玻璃
	String tank = "";//油箱
}

/*奔驰车制造商类,实现汽车接口*/
class Benz implements IVehiclei {
	private String name;
	private double price;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() { return "Benz [name=" + name + ", price=" + price + "]"; }
	@Override
	public IVehiclei create() {
		Benz benz = new Benz();benz.setName("奔驰梅赛德斯");benz.setPrice(1472438.45);
		return benz;
	}
}
/*奥迪制造商类,实现汽车接口*/
class Audi implements IVehiclei {
	private String name;
	private double price;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() { return "Audi [name=" + name + ", price=" + price + "]"; }
	@Override
	public IVehiclei create() {
		Audi audi = new Audi();audi.setName("奥迪A4L");audi.setPrice(308382.12);
		return audi;
	}
}

public class FactoryTest {
	public static void main(String[] args) {
		IVehicleFactory ivehicleFactory = VehicleFactoryImpl.createVehicleFactory();//创建工厂
		System.out.println("创建的汽车信息为：" + ivehicleFactory.createVihicle(new Benz()));//传递需要建造品牌的汽车
	}
}
