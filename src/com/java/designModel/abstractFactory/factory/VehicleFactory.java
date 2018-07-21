package com.java.designModel.abstractFactory.factory;

import com.java.designModel.abstractFactory.factory.IFactory;
import com.java.designModel.abstractFactory.vehicle.Properties;

/***
 * 
 * @ClassName: VehicleFactory  
 * @Description: TODO	汽车工厂抽象类,定义不同车辆生产工厂公共操作方法
 * @author spring  
 * @date 2018年7月15日  
 */
public abstract class VehicleFactory implements IFactory {
	/***
    * @Title: registerVehicleInfo  
    * @Description: TODO汽车工厂抽象类的公共抽象方法;此方法用于注册生产完成后车辆的信息登记,不管什么产品的汽车，其登记信息都为公共的属性
    * @param     参数  
    * @return void    返回类型  
    * @throws
	*/
	void registerVehicleInfo(Properties properties) { System.out.println("车辆创建完成，待提交审核的备案信息为: " + properties);}
	public abstract void createSimpleVehicle();//创建普通车辆
	public abstract void createAutopilot();//创建自动驾驶车辆
}
