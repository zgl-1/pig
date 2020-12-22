/**
 * Copyright 2008-2009. Chongqing Communications Industry Services Co.,Ltd Information Technology Branch. All rights reserved.
 * <a>http://www.crunii.com</a>
 */
package com.zhu.juc.lock8;

import java.util.concurrent.TimeUnit;

/**
 * @author 朱桂林 create 2020/11/21 15:37
 */
public class TestH {
	public static void main(String[] args) throws InterruptedException {
		Phone8 phone = new Phone8();
		Phone8 phone1 = new Phone8();

		new Thread(()->phone.send(),"A").start();
		TimeUnit.SECONDS.sleep(1);
		new Thread(()->phone1.call(),"B").start();
	}
}

class Phone8{
	//静态的同步方法
	public static synchronized void send(){
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("发短信");
	}
	//普通的同步方法
	public synchronized void call(){
		System.out.println("打电话");
	}
}