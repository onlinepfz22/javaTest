package com.java.callback.download;

import com.java.callback.CallBack;

public class MyThread extends Thread{

	private CallBack callBack;

	public MyThread(CallBack callBack) {
		this.callBack = callBack;
	}

	@Override
	public void run() {
		super.run();
		
		for (int i = 0; i < 10; i++) {
			try {
				System.out.println("正在下载第" + (i+1) + "张图片...");
				Thread.sleep(1000);
				System.out.println("第" + (i+1) + "张图片下载完成");
				System.out.println();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		callBack.callBack("图片全部下载完成");
		
	}
	
}
