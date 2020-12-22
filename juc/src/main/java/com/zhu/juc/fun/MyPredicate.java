/**
 * Copyright 2008-2009. Chongqing Communications Industry Services Co.,Ltd Information Technology Branch. All rights reserved.
 * <a>http://www.crunii.com</a>
 */
package com.zhu.juc.fun;

import org.springframework.util.StringUtils;

import java.util.function.Predicate;

/**
 * @author 朱桂林 create 2020/11/30 9:41
 */
public class MyPredicate {
	public static void main(String[] args) {
		Predicate<String> predicate = new Predicate<String>() {
			@Override
			public boolean test(String s) {
				return StringUtils.hasText(s);
			}
		};
		System.out.println(predicate.test("fjasf"));
	}
}
