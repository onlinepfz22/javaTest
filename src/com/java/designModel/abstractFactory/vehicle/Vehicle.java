package com.java.designModel.abstractFactory.vehicle;

import com.java.designModel.abstractFactory.vehicle.VehicleProperties;

/***
 * 
 * @ClassName: Vehicle  
 * @Description: TODO	汽车产品类,用于实现具体的车辆产品测试功能
 * @author spring  
 * @date 2018年7月15日  
 */
public class Vehicle extends VehicleProperties {
	@Override
	public void start() { System.out.println("汽车启动成功..."); }

	@Override
	public void accelerate() { System.out.println("汽车加速成功...");}

	@Override
	public void stop() { System.out.println("汽车制动成功...");}
}
