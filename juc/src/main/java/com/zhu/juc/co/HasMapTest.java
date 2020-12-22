/**
 * Copyright 2008-2009. Chongqing Communications Industry Services Co.,Ltd Information Technology Branch. All rights reserved.
 * <a>http://www.crunii.com</a>
 */
package com.zhu.juc.co;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author 朱桂林 create 2020/11/21 16:25
 */
public class HasMapTest {
	public static void main(String[] args) throws InterruptedException {
		//Map<String,String> list = Collections.synchronizedMap(new HashMap<>());
		//Set<String> list =new CopyOnWriteArraySet<>();
		//Set<String> list =new HashMap<>();
		Map<String,String> list = new ConcurrentHashMap<>();
		for (int i = 0; i < 20; i++) {
			new Thread(()->{
				list.put(UUID.randomUUID().toString().substring(0,4),"23434");
				System.out.println(list);
			}).start();
		}
	}
}
