package com.java.designModel.abstractFactory;

import com.java.designModel.abstractFactory.factory.AudiVehicleFactory;
import com.java.designModel.abstractFactory.vehicle.IVehicle;
import com.java.designModel.abstractFactory.factory.VehicleFactory;

public class Test {

	public static void main(String[] args) {
		/*客户端需求：创建奥迪车,并测试其功能*/
		VehicleFactory vehicleFactory = new AudiVehicleFactory();
		vehicleFactory.createSimpleVehicle();//创建奥迪普通车辆
		IVehicle ivehicle = vehicleFactory.getVehicle();//得到车辆实例
		System.out.println("创建完成的车辆为:" + ivehicle);
		
		/*得到奥迪车的实例，开始测试其功能*/
		ivehicle.start();//测试启动功能
		ivehicle.accelerate();//测试加速功能
		ivehicle.stop();//测试制动功能
	}
}
