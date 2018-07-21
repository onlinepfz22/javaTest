package com.java.designModel.abstractFactory.factory;

import java.util.Date;
import com.java.designModel.abstractFactory.vehicle.IVehicle;
import com.java.designModel.abstractFactory.vehicle.Properties;
import com.java.designModel.abstractFactory.vehicle.Vehicle;
import com.java.designModel.abstractFactory.factory.VehicleFactory;

/***
 * 
 * @ClassName: AudiVehicleFactory  
 * @Description: TODO	实现了工厂接口的奥迪车辆生产工厂
 * @author spring  
 * @date 2018年7月15日  
 */
public class AudiVehicleFactory extends VehicleFactory{
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
		return this.vehicle==null?null:this.vehicle;
	}
	
	@Override
	public void createSimpleVehicle() {
		System.out.println("开始创建奥迪普通车辆...");
		this.vehicle = new Vehicle();
		
		this.createEngine();//创建引擎
		this.createTyre();//创建轮胎
		this.createSteeringWheel();//创建方向盘
		this.createVehicleDoor();//创建车门
		this.createWindShiedld();//创建挡风玻璃
		this.createTank();//创建油箱
		
		Properties properties = new Properties();
		properties.setFactoryName("一汽大众奥迪上海分公司");
		properties.setCreateDate(new Date());
		properties.setOrginPlace("上海宝山区奥迪制造第一分厂");
		properties.setVehicleBatch("2018年国产第一批次");
		properties.setVehicleBrand("奥迪A4L");
		properties.setVehicleName("奥迪A4L---越野型");
		properties.setVehicleWeight(2.32d);
		properties.setEngineModel("A4-1");
		properties.setVehicleColor("天空白");
		properties.setVehicleLife("20年");
		this.vehicle.setProperties(properties);//设置车辆登记信息
		
		this.registerVehicleInfo(properties);
		System.out.println("创建完成奥迪普通车辆...");
	}

	@Override
	public void createAutopilot() {
		this.vehicle = new Vehicle();
		
		this.createEngine();//创建引擎
		this.createTyre();//创建轮胎
		this.createSteeringWheel();//创建方向盘
		this.createVehicleDoor();//创建车门
		this.createWindShiedld();//创建挡风玻璃
		this.createTank();//创建油箱
		this.createAutopilot();//创建自动驾驶功能
		
		Properties properties = new Properties();
		properties.setFactoryName("一汽大众奥迪上海分公司");
		properties.setCreateDate(new Date());
		properties.setOrginPlace("上海宝山区奥迪制造第一分厂");
		properties.setVehicleBatch("2018年国产第一批次");
		properties.setVehicleBrand("奥迪A4L");
		properties.setVehicleName("奥迪A4L---越野型自动驾驶");
		properties.setVehicleWeight(2.12d);
		properties.setEngineModel("A4-1-auto");
		properties.setVehicleColor("天空白");
		properties.setVehicleLife("30年");
		
		this.vehicle.setProperties(properties);
		this.registerVehicleInfo(properties);
	}
}
