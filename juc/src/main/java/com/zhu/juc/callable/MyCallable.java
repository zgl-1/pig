/**
 * Copyright 2008-2009. Chongqing Communications Industry Services Co.,Ltd Information Technology Branch. All rights reserved.
 * <a>http://www.crunii.com</a>
 */
package com.zhu.juc.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author 朱桂林 create 2020/11/28 9:32
 */
public class MyCallable {
	public static void main(String[] args) throws ExecutionException, InterruptedException {
		FutureTask futureTask = new FutureTask(new Data1());
		new Thread(futureTask).start();
		new Thread(futureTask).start();
		String o = (String) futureTask.get();
		System.out.println(o);
	}
}
class Data1 implements Callable<String> {
	@Override
	public String call() throws Exception {
		System.out.println("hehehhe");
		return "aiyowei";
	}
}