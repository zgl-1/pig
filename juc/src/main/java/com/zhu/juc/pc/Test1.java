/**
 * Copyright 2008-2009. Chongqing Communications Industry Services Co.,Ltd Information Technology Branch. All rights reserved.
 * <a>http://www.crunii.com</a>
 */
package com.zhu.juc.pc;

/**
 * @author 朱桂林 create 2020/11/21 14:09
 */
public class Test1 {
	public static void main(String[] args) {
		Phone phone = new Phone();
		new Thread(()-> {for (int i = 0; i <10 ; i++) phone.increment();},"A").start();
		new Thread(()-> {for (int i = 0; i <10 ; i++) phone.decrement();},"B").start();
		new Thread(()-> {for (int i = 0; i <10 ; i++) phone.increment();},"C").start();
		new Thread(()-> {for (int i = 0; i <10 ; i++) phone.decrement();},"D").start();
	}
}
class Phone{
	private int number=1;
	public synchronized void increment() {
		//这里不能使用if做判断，如果使用if做判断，现在同时有两个线程执行这个方法，会导致虚假唤醒问题
		while (number!=0){
			//等待消费
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		number++;
		System.out.println(Thread.currentThread().getName()+"生产了一个手机，还剩下"+number+"个手机");
		this.notifyAll();
	}
	public synchronized void decrement() {
		while (number==0){
			//等待生产
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		number--;
		System.out.println(Thread.currentThread().getName()+"消费了一个手机，还剩下"+number+"个手机");
		this.notifyAll();
	}
}