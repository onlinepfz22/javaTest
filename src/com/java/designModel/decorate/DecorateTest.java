package com.java.designModel.decorate;

/***
 * 
 * @ClassName: BuilderTest  
 * @Description: TODO	设计模式之装饰模式
 * @author spring  
 * @date 2018年7月15日  
 *
 *      总结：在原有抽象与实现类的组合模式中，为了扩展或增强接口的功能，另起定义一个中间装饰类继承并实现此抽象类，并通
 *          过继承中间装饰类的具体装饰类来增强原有接口的功能，具体查看代码
 *
 *
 * 		特点：1、需要扩展一个类的功能，或给一个类增加附加责任
 * 	          2、需要动态的给一个对象增加功能，这些功能可以再动态地撤销
 * 	          3、增强功能，四大角色：抽象构件(包含接口)、具体构件、装饰角色，具体装饰角色
 * 
 * 		代码演示:以销售汽车为例子;
 * 			1、抽象构件---汽车销售接口类(VehicleSale)：定义销售汽车的总流程，用于描述汽车销售的完整业务流程
 *          2、实现汽车销售抽象类(VehicleSaleProxy)：用于实现汽车销售的具体流程
 *              (包括汽车描述，签订合同，付款方式，登记备案，办理车牌，订购保险)
 *          3、具体构件---具体实现了汽车销售的类;
 * 	        3、客户类：用于了解汽车并签订汽车买卖合同；
*/

/*抽象构件：定义汽车销售的总流程接口,完成核心的两个实现目标，汽车的展示介绍和签订合同*/
abstract class VehicleSale {
    abstract void VehicleDescription();/*描述汽车基本情况*/
    abstract void signContract();/*签订汽车销售合同*/
}
/*实现了汽车销售抽象接口构件的具体实现类*/
class VehicleSaleImpl extends VehicleSale {
    @Override
    public void VehicleDescription() {//汽车描述
        System.out.println("日本丰田GTR");
        System.out.println("百公里加速1秒");
        System.out.println("油耗偏高");
        System.out.println("后驱涡轮增压");
        System.out.println("内饰豪华");
        System.out.println("发动机噪音偏大");
        System.out.println("不支持电动座椅，后视镜加热");
    }
    @Override
    public void signContract() {//签订销售合同
        System.out.println("完成汽车合同的签订，执行下级流程");
    }
}

/*定义汽车销售装饰类，即汽车销售接口的拓展业务类，用于增强汽车销售抽象类的功能*/
abstract class VehicleSaleDecorate extends VehicleSale{
    /*定义汽车销售签订合同后的付款方式选择，要么贷款，要么付现金*/
    public void choosePayment(VehicleSale vehicleSale) { System.out.println("选择贷款方式进行购车付款"); }
    abstract void orderInsurance(VehicleSale vehicleSale);/*车辆订购保险*/
    abstract void registerRecord(VehicleSale vehicleSale);/*车辆登记备案*/
    abstract void dealLicense(VehicleSale vehicleSale);/*办理车牌*/
}

/*对原有的vehicleSaleImpl实现类进行增强处理，并拓展更多的方法，保证原有实现类方法可调用的情况下，也能继续调用包装类扩展的方法*/
class VehicleSaleDecorateExtends extends VehicleSaleDecorate{
    private VehicleSale vehicleSale;
    public VehicleSaleDecorateExtends(VehicleSale vehicleSale) {
        this.vehicleSale = vehicleSale;
    }

    @Override
    public void VehicleDescription() {//汽车描述
        this.vehicleSale.VehicleDescription();
        System.out.println("这辆车已然成为您的量身定制");
    }
    @Override
    public void signContract() {//签订销售合同
        this.vehicleSale.signContract();
        /*在签订完合同后调用其他扩展功能完善购车流程*/
        super.choosePayment(this.vehicleSale);
        this.orderInsurance(this.vehicleSale);
        this.registerRecord(this.vehicleSale);
        this.dealLicense(this.vehicleSale);
    }
    @Override
    public void orderInsurance(VehicleSale vehicleSale) { //办理保险
        System.out.println("成功办理保险");
    }
    @Override
    public void registerRecord(VehicleSale vehicleSale) {//登记备案
        System.out.println("成功登记备案");
    }
    @Override
    public void dealLicense(VehicleSale vehicleSale) {//办理车牌
        System.out.println("成功办理车牌");
    }
}


public class DecorateTest {
    public static void main(String[] args) {
        /*客户需求：购买汽车，签订合同，完成后续一系列购车流程*/

        //初始化汽车销售抽象类的子类实现类的引用，将此对象引用传递给包装类具体子类，具体查看代码
        VehicleSale vehicleSale = new VehicleSaleImpl();
        /*通过装饰类进行购车额外功能的调用*/
        vehicleSale = new VehicleSaleDecorateExtends(vehicleSale);//包装实现了VehicleSale接口的类
        vehicleSale.VehicleDescription();
        vehicleSale.signContract();
    }
}
