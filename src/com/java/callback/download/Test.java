package com.java.callback.download;

import com.java.callback.CallBack;

public class Test {

	public static void main(String[] args) {

		MyThread myThread = new MyThread(new CallBack() {
			
			@Override
			public void callBack(String picture) {
				System.out.println(picture);
			}
		});
		
		myThread.start();
	}

}
