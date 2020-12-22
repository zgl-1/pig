/**
 * Copyright 2008-2009. Chongqing Communications Industry Services Co.,Ltd Information Technology Branch. All rights reserved.
 * <a>http://www.crunii.com</a>
 */
package com.zhu.thread.service;

import com.sun.org.apache.bcel.internal.generic.BREAKPOINT;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;
import sun.misc.Lock;

import javax.swing.text.TabableView;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author 朱桂林 create 2020/11/9 18:14
 */
@Service
public class ThreadService {
	//核心线程池大小
	private final int poolSize = 10;
	//最大线程数
	private final int maxPoolSize = 18;
	//队列容量
	private final int queueCapacity = 30;
	//活跃时间/秒
	private final int keepAliveSeconds = 30;

	public void test() {
		ExecutorService esPool = Executors.newFixedThreadPool(10);
		for (int i = 0; i < 500; i++) {

			int finalI = i;
			esPool.submit(new Runnable() {
				@Override public void run() {
					System.out.println("这是第" + finalI + "个任务");

				}
			});
		}

		esPool.shutdown();
		while(true) {
			//只有当线程池中所有线程完成任务时才会返回true，并且需要先调用线程池的shutdown方法或者shutdownNow方法。
			if(esPool.isTerminated()) {
				System.out.println("All finished");
				break;
			}
		}
	}
}
