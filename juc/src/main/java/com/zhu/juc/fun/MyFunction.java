/**
 * Copyright 2008-2009. Chongqing Communications Industry Services Co.,Ltd Information Technology Branch. All rights reserved.
 * <a>http://www.crunii.com</a>
 */
package com.zhu.juc.fun;

import java.util.function.Function;

/**
 * @author 朱桂林 create 2020/11/30 9:23
 */
public class MyFunction {
	public static void main(String[] args) {
		Function<String, String> function = new Function<String, String>() {
			@Override public String apply(String s) {
				return s;
			}
		};

		String hello = function.apply("hello");
		System.out.println(hello);
	}
}
