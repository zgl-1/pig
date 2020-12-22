/**
 * Copyright 2008-2009. Chongqing Communications Industry Services Co.,Ltd Information Technology Branch. All rights reserved.
 * <a>http://www.crunii.com</a>
 */
package com.zhu.juc.writereadlock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author 朱桂林 create 2020/11/28 10:38
 */
public class MyWriteAndReadLock {

	public static void main(String[] args) {
		Date2 date1=new Date2();

		for (int i = 1; i < 10; i++) {
			int finalI = i;
			new Thread(()->{
				date1.put(String.valueOf(finalI),String.valueOf(finalI));
			}).start();
		}
		for (int i = 1; i < 10; i++) {
			int finalI = i;
			new Thread(()->{
				date1.get(String.valueOf(finalI));
			}).start();
		}
	}
}
class Date2{
	private volatile Map<String,String> map=new HashMap<>();
	private ReadWriteLock lock=new ReentrantReadWriteLock();//读写锁，更加细粒度的操作，写入的时候同时只有一个线程，读取的时候可以有多个线程

	public void put(String key ,String value){
		lock.writeLock().lock();
		try {
			System.out.println("put"+key+"开始");
			map.put(key,value);
			System.out.println("put"+key+"完毕");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.writeLock().unlock();
		}
	}
	public String get(String key){
		lock.readLock().lock();
		String s=null;
		try {
			System.out.println("get"+key+"开始");
			s = map.get(key);
			System.out.println("get"+key+"完毕");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.readLock().unlock();
		}
		return s;
	}
}
class Date1{
	private volatile Map<String,String> map=new HashMap<>();

	public void put(String key ,String value){
		System.out.println("put"+key+"开始");
		map.put(key,value);
		System.out.println("put"+key+"完毕");
	}
	public String get(String key){
		System.out.println("get"+key+"开始");
		String s = map.get(key);
		System.out.println("get"+key+"完毕");
		return s;
	}
}