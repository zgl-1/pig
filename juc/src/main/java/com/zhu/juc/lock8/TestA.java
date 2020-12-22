/**
 * Copyright 2008-2009. Chongqing Communications Industry Services Co.,Ltd Information Technology Branch. All rights reserved.
 * <a>http://www.crunii.com</a>
 */
package com.zhu.juc.lock8;

import javax.crypto.interfaces.PBEKey;
import java.util.concurrent.TimeUnit;

/**
 * @author 朱桂林 create 2020/11/21 15:37
 */
public class TestA {
	public static void main(String[] args) throws InterruptedException {
		Phone phone = new Phone();

		new Thread(()->phone.send(),"A").start();
		TimeUnit.SECONDS.sleep(1);
		new Thread(()->phone.call(),"B").start();
	}
}
class Phone{
	public synchronized void send(){
		System.out.println("发短信");
	}
	public synchronized void call(){
		System.out.println("打电话");
	}
}