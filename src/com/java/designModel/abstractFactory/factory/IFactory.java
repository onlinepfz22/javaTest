package com.java.designModel.abstractFactory.factory;

import com.java.designModel.abstractFactory.vehicle.IVehicle;

/***
 * 
 * @ClassName: IFactory  
 * @Description: TODO	设计模式之工厂模式( 抽象工厂模式)：为创建一组相关或相互依赖的对象提供一个接口，而且无须指定它们的具体类
 * @author spring  
 * @date 2018年7月15日  
 *
 *	以建造汽车为例子：
 * 
 * 		抽象接口工厂：此工厂接口定义多个工厂具备的共性属性，那么不同的工厂可以建造不同的汽车，但是汽车的属性为共性，即
 * 		
 * 			建造出来的汽车都是具备相同的属性(都具有车轮，发动机和车门等，只不过建造的过程不一样而已)
 * 
 * 		汽车接口：定义记本的汽车属性以及汽车创造汽车的通用方法
 * 
 * 		汽车属性：发动机，轮胎，方向盘，车门，挡风玻璃，油箱等属性
 *	
 */
public interface IFactory {
	void createEngine();//创建引擎
	void createTyre();//创建轮胎
	void createSteeringWheel();//创建方向盘
	void createVehicleDoor();//创建车门
	void createWindShiedld();//创建挡风玻璃
	void createTank();//创建油箱
	IVehicle getVehicle();//得到汽车实例
}
