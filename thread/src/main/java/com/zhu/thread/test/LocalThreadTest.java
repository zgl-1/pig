/**
 * Copyright 2008-2009. Chongqing Communications Industry Services Co.,Ltd Information Technology Branch. All rights reserved.
 * <a>http://www.crunii.com</a>
 */
package com.zhu.thread.test;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author 朱桂林 create 2021/1/13 14:32
 */
public class LocalThreadTest {
	public static void main(String[] args) {
		ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 20, 5, TimeUnit.SECONDS, new LinkedBlockingQueue());
		for (int i = 0; i < 100; i++) {
			threadPoolExecutor.submit(()->{
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName()+"--"+LongLocal.longThreadLocal.get().hashCode());
			});
		}
		threadPoolExecutor.shutdown();
	}
}
