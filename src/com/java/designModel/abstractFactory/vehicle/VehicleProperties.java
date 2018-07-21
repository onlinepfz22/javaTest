package com.java.designModel.abstractFactory.vehicle;

import com.java.designModel.abstractFactory.vehicle.Properties;

/***
 * 
 * @ClassName: VehicleProperties  
 * @Description: TODO	车辆组成信息抽象类
 * @author spring  
 * @date 2018年7月15日  
 */
public abstract class VehicleProperties implements IVehicle {
	/*用属性模拟车辆创建基本信息*/
	private String engine = "";//引擎
	private String tyre = "";//轮胎
	private String steeringWheel = "";//方向盘
	private String vehicleDoor = "";//车门
	private String windshield = "";//挡风玻璃
	private String tank = "";//油箱
	private String vehicleType = "";//车辆类型
	private String autoPilot = "";//自动驾驶功能
	private Properties properties;//车辆登记信息
	
	public Properties getProperties() {
		return properties;
	}
	public void setProperties(Properties properties) {
		this.properties = properties;
	}
	public String getEngine() {
		return engine;
	}
	public void setEngine(String engine) {
		this.engine = engine;
	}
	public String getTyre() {
		return tyre;
	}
	public void setTyre(String tyre) {
		this.tyre = tyre;
	}
	public String getSteeringWheel() {
		return steeringWheel;
	}
	public void setSteeringWheel(String steeringWheel) {
		this.steeringWheel = steeringWheel;
	}
	public String getVehicleDoor() {
		return vehicleDoor;
	}
	public void setVehicleDoor(String vehicleDoor) {
		this.vehicleDoor = vehicleDoor;
	}
	public String getWindshield() {
		return windshield;
	}
	public void setWindshield(String windshield) {
		this.windshield = windshield;
	}
	public String getTank() {
		return tank;
	}
	public void setTank(String tank) {
		this.tank = tank;
	}
	public String getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	public String getAutoPilot() {
		return autoPilot;
	}
	public void setAutoPilot(String autoPilot) {
		this.autoPilot = autoPilot;
	}

}
