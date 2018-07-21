package com.java.designModel.responsibility;

/***
 * 
 * @ClassName: ApproveTest 
 * @Description: 设计模式之责任链模式  
 * @author spring  
 * @date 2018年7月15日  
 *	
 *	开闭原则、依赖倒置原则，责任链模式：处在责任链上的每个责任类之间的责任关系形成链式对应，相互之间进行关联
 *	
 *	责任链模式分为纯的责任链模式和不纯的责任链模式
 *		纯责任链模式：一个请求的处理要么不处理，提交下一个责任类处理，要么处理完成，不存在处理一半后进行后续责任链处理，即不半途而废
 *		不纯的责任链模式：存在请求的处理可能处理一般交由责任链中的下家进行处理
 *
 *	优点：
 *		(1)、职责链模式使得一个对象无须知道是其他哪一个对象处理其请求，对象仅需知道该请求会被处理即可，接收者和发送者都没有对方的
 *			明确信息，且链中的对象不需要知道链的结构，由客户端负责链的创建，降低了系统的耦合度；
 *		(2)、请求处理对象仅需维持一个指向其后继者的引用，而不需要维持它对所有的候选处理者的引用，可简化对象的相互连接；
 *		(3)、在给对象分派职责时，职责链可以给我们更多的灵活性，可以通过在运行时对该链进行动态的增加或修改来增加或改变处理一个请求的职责
 *		(4)、在系统中增加一个新的具体请求处理者时无须修改原有系统的代码，只需要在客户端重新建链即可，从这一点来看是符合“开闭原则”的
 *	缺点：
 *		(1)、责任链过长，对象过多，难以维护，也会影响系统性能；
 *		(2)、责任链可能存在请求无法被任何链上的责任类所处理
 *		(3)、如果建链不当，可能存在死循环
 */	
abstract class Approve {

    private Approve approve;//审批后继对象

    private String name;//责任类名称

    public Approve(String name) { this.name = name; }

    public Approve getApprove() {
        return approve;
    }

    public void setApprove(Approve approve) {
        this.approve = approve;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /*具体审批对象的审批方法,交给实现了Approve的子类进行具体的实现*/
    public abstract void processRequest(PurchaseRequest purchaseRequest);
}

/*采购单请求类*/
class PurchaseRequest {
    private double amount;//采购单金额
    private int number;//采购单编号
    private String purpose;//采购单目的

    public PurchaseRequest(double amount, int number, String purpose) {
        this.amount = amount;
        this.number = number;
        this.purpose = purpose;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }
}

//主任审批小于5000的采购单
class Director extends Approve {

    public Director(String name) {
        super(name);
    }

    @Override
    public void processRequest(PurchaseRequest purchaseRequest) {
        if(purchaseRequest.getAmount() < 5000) {
            System.out.println("主任审批采购单：金额为" + purchaseRequest.getAmount() + ",采购单编号：" +
            purchaseRequest.getNumber() + ",采购单目的: " + purchaseRequest.getPurpose());
        } else { //转发请求
            this.getApprove().processRequest(purchaseRequest);
        }
    }
}

//副董事长审批小于10w的采购单
class VicePresident extends Approve {

    public VicePresident(String name) {
        super(name);
    }

    @Override
    public void processRequest(PurchaseRequest purchaseRequest) {
        if(purchaseRequest.getAmount() < 100000) {
            System.out.println("副董事长审批采购单：金额为" + purchaseRequest.getAmount() + ",采购单编号：" +
                    purchaseRequest.getNumber() + ",采购单目的: " + purchaseRequest.getPurpose());
        } else { //转发请求
            this.getApprove().processRequest(purchaseRequest);
        }
    }
}

//董事长审批小于50w的采购单
class President extends Approve {

    public President(String name) {
        super(name);
    }

    @Override
    public void processRequest(PurchaseRequest purchaseRequest) {
        if(purchaseRequest.getAmount() < 500000) {
            System.out.println("董事长审批采购单：金额为" + purchaseRequest.getAmount() + ",采购单编号：" +
                    purchaseRequest.getNumber() + ",采购单目的: " + purchaseRequest.getPurpose());
        } else { //转发请求
            this.getApprove().processRequest(purchaseRequest);
        }
    }
}

//董事会类
class Congress extends Approve {

    public Congress(String name) {
        super(name);
    }

    @Override
    public void processRequest(PurchaseRequest purchaseRequest) {
        System.out.println("董事会审批采购单：金额为" + purchaseRequest.getAmount() + ",采购单编号：" +
            purchaseRequest.getNumber() + ",采购单目的: " + purchaseRequest.getPurpose());
    }
}

//测试类
public class ApproveTest {

    public static void main(String[] args) {
    	//创建四个审批者
    	Approve director = new Director("主任");
    	Approve vicePresident = new VicePresident("副董事长");
    	Approve president = new President("董事长");
    	Approve congress = new Congress("董事会");
    	
    	//创建责任链,按照审批的级别，可以由高到低进行责任连的配置
    	director.setApprove(vicePresident);//如果主任审批不了的就转发给副董事长进行审批
    	vicePresident.setApprove(president);//副董事长审批不了的就转发给董事长进行审批
    	president.setApprove(congress);//董事长审批不了的就直接提交董事会
    	
    	//定义四个不同的采购单，采购单交由以上四个审批者进行审批，查看是否有权限进行审批
        //采购单金额
        //采购单编号
        //采购单目的
    	PurchaseRequest purchaseRequest1 = new PurchaseRequest(900500.23d, 1001, "购买联想高配置办公开发笔记本电脑");
    	director.processRequest(purchaseRequest1);
    }
}