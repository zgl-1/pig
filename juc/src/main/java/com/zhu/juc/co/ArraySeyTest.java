/**
 * Copyright 2008-2009. Chongqing Communications Industry Services Co.,Ltd Information Technology Branch. All rights reserved.
 * <a>http://www.crunii.com</a>
 */
package com.zhu.juc.co;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.TimeUnit;

/**
 * @author 朱桂林 create 2020/11/21 16:25
 */
public class ArraySeyTest {
	public static void main(String[] args) throws InterruptedException {
		//Set<String> list = Collections.synchronizedSet(new HashSet<>());
		//Set<String> list =new CopyOnWriteArraySet<>();
		//Set<String> list =new HashSet<>();
		Set<String> list = Collections.synchronizedSet(new HashSet<>());
		for (int i = 0; i < 20; i++) {
			new Thread(()->{
				list.add(UUID.randomUUID().toString().substring(0,4));
				System.out.println(list);
			}).start();
		}
	}
}
