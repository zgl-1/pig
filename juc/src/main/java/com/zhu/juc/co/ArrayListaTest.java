/**
 * Copyright 2008-2009. Chongqing Communications Industry Services Co.,Ltd Information Technology Branch. All rights reserved.
 * <a>http://www.crunii.com</a>
 */
package com.zhu.juc.co;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;

/**
 * @author 朱桂林 create 2020/11/21 16:25
 */
public class ArrayListaTest {
	public static void main(String[] args) throws InterruptedException {
		//List<String> list =Collections.synchronizedList(new ArrayList<>());
		//List<String> list =new CopyOnWriteArrayList<>();
		//List<String> list =new Vector<>();
		List<String> list =new CopyOnWriteArrayList<>();
		for (int i = 0; i < 10; i++) {
			new Thread(()->{
				list.add(UUID.randomUUID().toString().substring(0,4));
				System.out.println(list);
			}).start();
		}
//		TimeUnit.SECONDS.sleep(2);
		System.out.println(list);
	}
}
