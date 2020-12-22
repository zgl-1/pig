/**
 * Copyright 2008-2009. Chongqing Communications Industry Services Co.,Ltd Information Technology Branch. All rights reserved.
 * <a>http://www.crunii.com</a>
 */
package com.zhu.juc.lock8;

import java.util.concurrent.TimeUnit;

/**
 * @author 朱桂林 create 2020/11/21 15:37
 */
public class TestB {
	public static void main(String[] args) throws InterruptedException {
		Phone2 phone = new Phone2();

		new Thread(()->phone.send(),"A").start();
		TimeUnit.SECONDS.sleep(1);
		new Thread(()->phone.call(),"B").start();
	}
}

class Phone2{
	public synchronized void send(){
		System.out.println("发短信");
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public synchronized void call(){
		System.out.println("打电话");
	}
}