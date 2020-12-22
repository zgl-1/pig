/**
 * Copyright 2008-2009. Chongqing Communications Industry Services Co.,Ltd Information Technology Branch. All rights reserved.
 * <a>http://www.crunii.com</a>
 */
package com.zhu.juc.problem;

/**
 * @author 朱桂林 create 2020/11/21 10:44
 */
public class SelaPhone {
	public static void main(String[] args) {
		Phone phone=new Phone();
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

class Phone{
	public int number=200;//最开始有100部手机
	public synchronized void sela(){
		System.out.println("卖了一部手机，还剩下"+(--number)+"部手机");
	}
}
