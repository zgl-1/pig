/**
 * Copyright 2008-2009. Chongqing Communications Industry Services Co.,Ltd Information Technology Branch. All rights reserved.
 * <a>http://www.crunii.com</a>
 */
package com.zhu.juc.forkjoin;

import java.util.concurrent.RecursiveTask;
import java.util.concurrent.locks.Lock;

/**
 * @author 朱桂林 create 2020/11/30 9:56
 */
public class MyForkJoin extends RecursiveTask<Long> {
	private Long start;
	private Long end;
	private Long temp=5000L;

	public MyForkJoin(Long start, Long end) {
		this.start = start;
		this.end = end;
	}

	@Override
	protected Long compute() {
		if((end-start)<temp){//当差值小于temp时做累加
			Long sum=0L;
			for (Long i = start; i <= end; i++) {
				sum+=i;
			}
			return sum;
		}else {//当差值大于temp时做任务拆分
			Long mid = (end + start) / 2;
			MyForkJoin task1= new MyForkJoin(start,mid);
			task1.fork();
			MyForkJoin task2= new MyForkJoin(mid+1,end);
			task2.fork();

			return task1.join()+task2.join();
		}
	}
}
