package com.java.designModel.abstractFactory.factory;

import java.util.Date;
import com.java.designModel.abstractFactory.vehicle.IVehicle;
import com.java.designModel.abstractFactory.vehicle.Properties;
import com.java.designModel.abstractFactory.vehicle.Vehicle;
import com.java.designModel.abstractFactory.factory.VehicleFactory;

/***
 * 
 * @ClassName: AudiVehicleFactory  
 * @Description: TODO	实现了工厂接口的宝马车辆生产工厂
 * @author spring  
 * @date 2018年7月15日  
 */
public class BMWVehicleFactory extends VehicleFactory {
private Vehicle vehicle = null;
	
	@Override
	public void createEngine() {//创建引擎
		this.vehicle.setEngine("建立引擎");
		System.out.println("创建引擎成功...");
	}

	@Override
	public void createTyre() {//创建轮胎
		this.vehicle.setTyre("建立轮胎");
		System.out.println("创建轮胎成功...");
	}

	@Override
	public void createSteeringWheel() {//创建方向盘
		this.vehicle.setSteeringWheel("建立方向盘");
		System.out.println("创建方向盘成功...");
	}

	@Override
	public void createVehicleDoor() {//创建车门
		this.vehicle.setVehicleDoor("建立车门");
		System.out.println("创建车门成功...");
	}

	@Override
	public void createWindShiedld() {//创建挡风玻璃
		this.vehicle.setWindshield("建立挡风玻璃");
		System.out.println("创建挡风玻璃成功...");
	}

	@Override
	public void createTank() {//创建油箱
		this.vehicle.setTank("建立油箱");
		System.out.println("创建油箱成功...");
	}
	
	public void createAutoPilot() {
		this.vehicle.setAutoPilot("建立自动驾驶系统");
		System.out.println("创建自动驾驶系统成功...");
	}

	@Override
	public IVehicle getVehicle() {
		return this.vehicle;
	}

	@Override
	public void createSimpleVehicle() {
		this.createEngine();//创建引擎
		this.createTyre();//创建轮胎
		this.createSteeringWheel();//创建方向盘
		this.createVehicleDoor();//创建车门
		this.createWindShiedld();//创建挡风玻璃
		this.createTank();//创建油箱
	}

	public void createAutopilot() {
		this.createEngine();//创建引擎
		this.createTyre();//创建轮胎
		this.createSteeringWheel();//创建方向盘
		this.createVehicleDoor();//创建车门
		this.createWindShiedld();//创建挡风玻璃
		this.createTank();//创建油箱
		this.createAutopilot();//创建自动驾驶功能
	}
}
