/**
 * Copyright 2008-2009. Chongqing Communications Industry Services Co.,Ltd Information Technology Branch. All rights reserved.
 * <a>http://www.crunii.com</a>
 */
package com.zhu.juc.helperclass;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author 朱桂林 create 2020/11/28 10:24
 */
public class MySemaphore {
	public static void main(String[] args) {
		Semaphore semaphore=new Semaphore(5);
		for (int i = 1; i <= 10; i++) {
			int finalI = i;
			new Thread(()->{
				try {
					semaphore.acquire();//抢车位
					System.out.println(Thread.currentThread().getName()+"抢到了一个");
					TimeUnit.SECONDS.sleep(3);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}finally {
					System.out.println(Thread.currentThread().getName()+"离开");
					semaphore.release();//开走，释放车位
				}
			},"线程"+i).start();
		}
	}
}
