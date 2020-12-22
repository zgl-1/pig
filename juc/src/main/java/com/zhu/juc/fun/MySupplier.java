/**
 * Copyright 2008-2009. Chongqing Communications Industry Services Co.,Ltd Information Technology Branch. All rights reserved.
 * <a>http://www.crunii.com</a>
 */
package com.zhu.juc.fun;

import java.util.function.Supplier;

/**
 * @author 朱桂林 create 2020/11/30 9:46
 */
public class MySupplier {
	public static void main(String[] args) {
		Supplier<String> supplier = new Supplier<String>() {
			@Override
			public String get() {
				return "sjdd";
			}
		};
		System.out.println(supplier.get());
	}
}
