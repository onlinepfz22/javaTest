package com.java.designModel.abstractFactory.vehicle;

import java.util.Date;

/***
 * 
 * @ClassName: Properties  
 * @Description: TODO	车辆用于备案的登记模板信息
 * @author spring  
 * @date 2018年7月15日  
 */
public class Properties {
	private String factoryName;//生产厂商
	private Date createDate;//车辆生产日期
	private String orginPlace;//车辆产地
	private String vehicleBatch;//车辆批次
	private String vehicleBrand;//车辆所属品牌
	private String vehicleName;//车辆产品名称
	private Double vehicleWeight;//车辆重量
	private String engineModel;//车辆引擎型号
	private String vehicleColor;//车辆颜色
	private String vehicleLife;//车辆寿命
	public String getFactoryName() {
		return factoryName;
	}
	public void setFactoryName(String factoryName) {
		this.factoryName = factoryName;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getOrginPlace() {
		return orginPlace;
	}
	public void setOrginPlace(String orginPlace) {
		this.orginPlace = orginPlace;
	}
	public String getVehicleBatch() {
		return vehicleBatch;
	}
	public void setVehicleBatch(String vehicleBatch) {
		this.vehicleBatch = vehicleBatch;
	}
	public String getVehicleBrand() {
		return vehicleBrand;
	}
	public void setVehicleBrand(String vehicleBrand) {
		this.vehicleBrand = vehicleBrand;
	}
	public String getVehicleName() {
		return vehicleName;
	}
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
	public Double getVehicleWeight() {
		return vehicleWeight;
	}
	public void setVehicleWeight(Double vehicleWeight) {
		this.vehicleWeight = vehicleWeight;
	}
	public String getEngineModel() {
		return engineModel;
	}
	public void setEngineModel(String engineModel) {
		this.engineModel = engineModel;
	}
	public String getVehicleColor() {
		return vehicleColor;
	}
	public void setVehicleColor(String vehicleColor) {
		this.vehicleColor = vehicleColor;
	}
	public String getVehicleLife() {
		return vehicleLife;
	}
	public void setVehicleLife(String vehicleLife) {
		this.vehicleLife = vehicleLife;
	}
	@Override
	public String toString() {
		return "Properties [factoryName=" + factoryName + ", createDate=" + createDate + ", orginPlace=" + orginPlace
			+ ", vehicleBatch=" + vehicleBatch + ", vehicleBrand=" + vehicleBrand + ", vehicleName=" + vehicleName
			+ ", vehicleWeight=" + vehicleWeight + ", engineModel=" + engineModel + ", vehicleColor=" + vehicleColor
			+ ", vehicleLife=" + vehicleLife + "]";
	}
}
