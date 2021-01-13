/**
 * Copyright 2008-2009. Chongqing Communications Industry Services Co.,Ltd Information Technology Branch. All rights reserved.
 * <a>http://www.crunii.com</a>
 */
package com.zhu.thread.test;

/**
 * @author 朱桂林 create 2021/1/13 15:06
 */
public class LongLocal {
	public static ThreadLocal<LocalData> longThreadLocal=new ThreadLocal<LocalData>(){
		@Override
		protected LocalData initialValue() {
			LocalData localData = new LocalData();
			System.out.println("初始化的hashcode："+localData.hashCode());
			return localData;
		}
	};
}
