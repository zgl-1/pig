/**
 * Copyright 2008-2009. Chongqing Communications Industry Services Co.,Ltd Information Technology Branch. All rights reserved.
 * <a>http://www.crunii.com</a>
 */
package com.zhu.juc.forkjoin;

import javax.lang.model.type.ErrorType;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

/**
 * @author 朱桂林 create 2020/11/30 10:39
 */
public class Test1 {
	public static void main(String[] args) throws ExecutionException, InterruptedException {
		Long start=System.currentTimeMillis();
		System.out.println(test4(1L,1000000000L));
		Long end=System.currentTimeMillis();
		System.out.println(end-start);
	}
	public static Long test2(Long start,Long end){
		Long sum=0L;
		for (Long i = start; i <= end; i++) {
			sum+=i;
		}
		return sum;
	}

	public static Long test3(Long start,Long end) throws ExecutionException, InterruptedException {
		ForkJoinPool forkJoinPool=new ForkJoinPool();
		MyForkJoin myForkJoin=new MyForkJoin(start,end);
		ForkJoinTask<Long> submit = forkJoinPool.submit(myForkJoin);
		return submit.get();
	}
	public static Long test4(Long start,Long end) {
		return LongStream.rangeClosed(start,end).parallel().reduce(0,Long::sum);
	}
}
