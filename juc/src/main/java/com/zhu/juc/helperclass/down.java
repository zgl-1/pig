/**
 * Copyright 2008-2009. Chongqing Communications Industry Services Co.,Ltd Information Technology Branch. All rights reserved.
 * <a>http://www.crunii.com</a>
 */
package com.zhu.juc.helperclass;

import java.util.concurrent.CountDownLatch;

/**
 * @author 朱桂林 create 2020/11/28 10:00
 */
public class down {
	public static void main(String[] args) throws InterruptedException {
		CountDownLatch countDownLatch=new CountDownLatch(10);
//		countDownLatch.countDown();//减一

		for (int i = 10; i > 0; i--) {
			int finalI = i;
			new Thread(()->{
				System.out.println("这是第"+ finalI +"个，还剩下"+(finalI +-1)+"个");
				countDownLatch.countDown();//减一
			}).start();
		}
		countDownLatch.await();
		System.out.println("减完了吗？");
	}
}
