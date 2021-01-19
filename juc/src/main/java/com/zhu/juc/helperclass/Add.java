/**
 * Copyright 2008-2009. Chongqing Communications Industry Services Co.,Ltd Information Technology Branch. All rights reserved.
 * <a>http://www.crunii.com</a>
 */
package com.zhu.juc.helperclass;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * @author 朱桂林 create 2020/11/28 10:12
 */
public class Add {
	public static void main(String[] args) {
		CyclicBarrier cyclicBarrier=new CyclicBarrier(5,()-> System.out.println("计数达到5了"));
		for (int i = 1; i <= 10; i++) {
			int finalI = i;
			new Thread(()->{
				try {
					TimeUnit.MILLISECONDS.sleep((long)(Math.random()*10000));
					System.out.println("这是第"+ finalI +"个，还剩下"+(10-finalI)+"个");
					cyclicBarrier.await();//等待，必须要cyclicBarrier计数器达到5，如果cyclicBarrier总数多余线程数的话可能会卡死
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (BrokenBarrierException e) {
					e.printStackTrace();
				}
			}).start();
		}
	}
}
