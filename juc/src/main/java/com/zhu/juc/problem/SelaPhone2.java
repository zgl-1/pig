/**
 * Copyright 2008-2009. Chongqing Communications Industry Services Co.,Ltd Information Technology Branch. All rights reserved.
 * <a>http://www.crunii.com</a>
 */
package com.zhu.juc.problem;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 朱桂林 create 2020/11/21 10:44
 */
public class SelaPhone2 {
	public static void main(String[] args) {
		Phone2 phone=new Phone2();
		new Thread(()->{
			for (int i = 0; i < 50; i++) {
				phone.sela();
			}
		}).start();
		new Thread(()->{
			for (int i = 0; i < 50; i++) {
				phone.sela();
			}
		}).start();
		new Thread(()->{
			for (int i = 0; i < 50; i++) {
				phone.sela();
			}
		}).start();
		new Thread(()->{
			for (int i = 0; i < 50; i++) {
				phone.sela();
			}
		}).start();
	}



}
//使用lock做同步处理
class Phone2{
	public int number=200;//最开始有100部手机
	Lock lock = new ReentrantLock();
	public synchronized void sela(){
		lock.lock();
		try {
			System.out.println("卖了一部手机，还剩下"+(--number)+"部手机");
		} finally {
			lock.unlock();
		}
	}
}
