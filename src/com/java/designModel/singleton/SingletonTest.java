package com.java.designModel.singleton;

/***
 * 
 * @ClassName: SingletonTest  
 * @Description: TODO	设计模式之单例模式
 * @author spring  
 * @date 2018年7月15日  
 * 
 * 		特点：
 * 			1、单例类只能有一个实例;
 * 			2、单例类必须自己创建自己的唯一实例;
 * 			3、单例类必须给所有其他对象提供这一实例;
*/	

/**
 *	饿汉式单例模式(即以类的static方式创建,即无论会不会有其他类使用到单例类的实例都创建)
 *
 *	线程安全问题:线程安全，此方式再单例类被加载后初始化创建次单例类的实例
 * */
class SingletonHunger {
	private static SingletonHunger singletonHunger = new SingletonHunger();
	
	public static SingletonHunger getInstance() {
		return singletonHunger;
	}
}

/**
 *	懒汉式单例模式(添加私有构造，外部创建此单例类的实例无法通过构造函数进行创建,及必须按照单例类规定的以类的方式进行获取)
 *
 *	缺点：再多线程的环境下会产生多个单例类实例，存在线程安全问题
 *		分析:由于饿汉式单例模式中是在运行时才建立单例的实例，故多线程再并发调用SingletonLazy的getInstance()方法时，需要进行
 *
 *			加锁，保证同一时间下只能有一个线程可以进入getInstance方法内进行对象的创建,由于getInstance()方法为static方法，属于
 *
 *			类级别，故不能采用对象锁进行，可以再类的范围内进行加锁，这里选择加SingletonLazy的类锁
 * */
class SingletonLazy {
	private static SingletonLazy singletonLazy = null;
	
	private SingletonLazy() {}
	
	/*无并发情况下的饿汉式单例创建方式*/
	public static SingletonLazy getInstance1() {
		if(null == singletonLazy) {
			singletonLazy = new SingletonLazy();
		}
		return singletonLazy;
	}
	
	/*第一种方式：采取synchronized加类锁进行同步；缺点：运行方式效率低下*/
	public static SingletonLazy getInstance2() {
		synchronized (SingletonLazy.class) {
			if(null == singletonLazy) {
				singletonLazy = new SingletonLazy();
			}
		}
		return singletonLazy;
	}
	
	/*第二种方式(推荐):采取双重检查的方式进行加锁*/
	public static SingletonLazy getInstance3() {
		if(null == singletonLazy) {
			synchronized (SingletonLazy.class) {
				if(null == singletonLazy) {
					singletonLazy = new SingletonLazy();
				}
			}
		}		
		return singletonLazy;
	}
}

public class SingletonTest {
	public static void main(String[] args) {
		/*饿汉式单例模式测试*/
		System.out.println("饿汉式单例模式创建的单例为:" + SingletonHunger.getInstance());
		System.out.println("**********************************************************");
		/*懒汉式单例模式测试*/
		System.out.println("懒汉式单例模式创建的单例为:" + SingletonHunger.getInstance());
	}
}
