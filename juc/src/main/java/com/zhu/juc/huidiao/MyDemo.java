/**
 * Copyright 2008-2009. Chongqing Communications Industry Services Co.,Ltd Information Technology Branch. All rights reserved.
 * <a>http://www.crunii.com</a>
 */
package com.zhu.juc.huidiao;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @author 朱桂林 create 2020/12/2 10:44
 */
public class MyDemo {
	public static void main(String[] args) throws ExecutionException, InterruptedException {
		/*CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(()->{
			try {
				TimeUnit.SECONDS.sleep(2);
				System.out.println("1111");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		System.out.println("ssdadasda");
		completableFuture.get();//没有返回值*/

		CompletableFuture<String> supplyAsync = CompletableFuture.supplyAsync(() -> {
			int i =10/0;
			System.out.println("进入supplyAsync");
			return "sfsafasf";
		});
		System.out.println(supplyAsync.whenComplete((t, u) -> {
			System.out.println("t>>>" + t);//正常结果
			System.out.println("u>>>" + u);//错误的返回信息
		}).exceptionally((e) -> {
			System.out.println(e.getMessage());
			return "错了";
		}).get());

	}
}
