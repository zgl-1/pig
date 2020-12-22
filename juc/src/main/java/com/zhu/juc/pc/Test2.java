/**
 * Copyright 2008-2009. Chongqing Communications Industry Services Co.,Ltd Information Technology Branch. All rights reserved.
 * <a>http://www.crunii.com</a>
 */
package com.zhu.juc.pc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 朱桂林 create 2020/11/21 14:09
 */
public class Test2 {
	public static void main(String[] args) {
		Phone2 phone = new Phone2();
		new Thread(()-> {for (int i = 0; i <10 ; i++) phone.increment();},"A").start();
		new Thread(()-> {for (int i = 0; i <10 ; i++) phone.decrement();},"B").start();
		new Thread(()-> {for (int i = 0; i <10 ; i++) phone.increment();},"C").start();
		new Thread(()-> {for (int i = 0; i <10 ; i++) phone.decrement();},"D").start();
	}
}

class Phone2{
	private int number=1;
	Lock lock = new ReentrantLock();
	Condition condition = lock.newCondition();

	public void increment() {
		//这里不能使用if做判断，如果使用if做判断，现在同时有两个线程执行这个方法，会导致虚假唤醒问题

		try {
			lock.lock();
			while (number!=0){
				//等待消费
				try {
					condition.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			number++;
			System.out.println(Thread.currentThread().getName()+"生产了一个手机，还剩下"+number+"个手机");
			condition.signalAll();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
	public void decrement() {
		try {
			lock.lock();
			while (number==0){
				//等待生产
				try {
					condition.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			number--;
			System.out.println(Thread.currentThread().getName()+"消费了一个手机，还剩下"+number+"个手机");
			condition.signalAll();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
}