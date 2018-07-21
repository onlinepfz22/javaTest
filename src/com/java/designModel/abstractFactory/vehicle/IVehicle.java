package com.java.designModel.abstractFactory.vehicle;

/***
 * 
 * @ClassName: IVehicle  
 * @Description: TODO	汽车产品接口，用于定义测量具体车辆产品的功能
 * @author spring  
 * @date 2018年7月15日  
 */
public interface IVehicle {
	void start();//测试基本启动功能
	void accelerate();//测试加速功能
	void stop();//测试制动功能
}
