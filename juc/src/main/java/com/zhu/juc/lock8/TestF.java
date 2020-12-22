/**
 * Copyright 2008-2009. Chongqing Communications Industry Services Co.,Ltd Information Technology Branch. All rights reserved.
 * <a>http://www.crunii.com</a>
 */
package com.zhu.juc.lock8;

import java.util.concurrent.TimeUnit;

/**
 * @author 朱桂林 create 2020/11/21 15:37
 */
public class TestF {
	public static void main(String[] args) throws InterruptedException {
		Phone6 phone = new Phone6();
		Phone6 phone1 = new Phone6();

		new Thread(()->phone.send(),"A").start();
		TimeUnit.SECONDS.sleep(1);
		new Thread(()->phone1.call(),"B").start();
	}
}

class Phone6{
	public static synchronized void send(){
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("发短信");
	}
	public static synchronized void call(){
		System.out.println("打电话");
	}
}