package com.java.designModel.adapter;

/***
 * 
 * @ClassName: BuilderTest  
 * @Description: TODO	设计模式之适配器模式
 * @author spring  
 * @date 2018年7月15日  
 * 
 * 		特点：将两个相互无法进行关联的类或接口进行关联,适配器模式由聚合方式和继承方式实现
 * 
 * 		代码演示:以苹果手机充电为例子;
 * 			Product(产品类):苹果手机为产品(AppleMobilePhone),其港行的充电器无法插入大陆的电源插孔进行充电，需要进行转换插头;
*/
/*定义充电接口,港版的苹果手机充电按照港版手机定义的充电接口进行充电*/
interface HongKongCharge {
	void executeHongKongCharge();
}

/*定义产品类，此产品的充电插口需要进行转换*/
class AppleMobilePhone {
	private HongKongCharge hongKongCharge;
	private String phoneName;
	
	public String getPhoneName() { return this.phoneName; }
	
	public void setPhoneName(String phoneName) { this.phoneName = phoneName; }
	
	public AppleMobilePhone(HongKongCharge hongKongCharge) {//给港行苹果手机绑定港行专门充电方式
		this.hongKongCharge = hongKongCharge;
	}
	
	/*执行港版手机充电，实际调用的是国行充电方式，充电适配器类就相当于引入了一个手机充电转换插头*/
	public void charge() {
		this.hongKongCharge.executeHongKongCharge();
	}
}

/*定义适配器类,通过实现港行充电接口的充电方法并继承国行版充电方式，
 * 也就是在实现了港行充电方法里(executeHongKongCharge)调用国行版方式进行实际充电*/
class HongKongChargeAdapter extends NationCharge implements HongKongCharge {
	private NationCharge nationCharge;//引入国行充电方式
	public HongKongChargeAdapter(NationCharge nationCharge) {
		this.nationCharge = nationCharge;
	}

	@Override
	public void executeHongKongCharge() {
		this.nationCharge.executeNationCharge();
	}
}

/*大陆充电插口，无法对港行的苹果手机进行充电*/
class NationCharge {
	
	public void executeNationCharge() {
		System.out.println("利用国行方式开始充电");
	}
}

public class AdapterTest {
	public static void main(String[] args) {
		NationCharge nationCharge = new NationCharge();//创建国行充电方式
		HongKongCharge hongKongCharge = new HongKongChargeAdapter(nationCharge);
		AppleMobilePhone appleMobilePhone = new AppleMobilePhone(hongKongCharge);
		appleMobilePhone.charge();
	}
}
