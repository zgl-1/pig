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
public class Test3 {
	public static void main(String[] args) {
		Phone3 phone = new Phone3();
		new Thread(() -> {
			for (int i = 0; i < 10; i++)
				phone.printA();
		}, "A").start();
		new Thread(() -> {
			for (int i = 0; i < 10; i++)
				phone.printB();
		}, "B").start();
		new Thread(() -> {
			for (int i = 0; i < 10; i++)
				phone.printC();
		}, "C").start();
		new Thread(() -> {
			for (int i = 0; i < 10; i++)
				phone.printD();
		}, "D").start();
	}
}

class Phone3 {
	Lock lock = new ReentrantLock();
	Condition condition1 = lock.newCondition();
	Condition condition2 = lock.newCondition();
	Condition condition3 = lock.newCondition();
	Condition condition4 = lock.newCondition();
	private int num = 1;

	public void printA() {
		try {
			lock.lock();
			while (num != 1) {
				try {
					condition1.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			num = 2;
			System.out.println(Thread.currentThread().getName() + "A");
			condition2.signal();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
	public void printB() {
		try {
			lock.lock();
			while (num != 2) {
				try {
					condition2.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			num = 3;
			System.out.println(Thread.currentThread().getName() + "B");
			condition3.signal();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
	public void printC() {
		try {
			lock.lock();
			while (num != 3) {
				try {
					condition3.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			num = 4;
			System.out.println(Thread.currentThread().getName() + "C");
			condition4.signal();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
	public void printD() {
		try {
			lock.lock();
			while (num != 4) {
				try {
					condition4.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			num = 1;
			System.out.println(Thread.currentThread().getName() + "D");
			condition1.signal();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
}