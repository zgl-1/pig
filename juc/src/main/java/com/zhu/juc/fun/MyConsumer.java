/**
 * Copyright 2008-2009. Chongqing Communications Industry Services Co.,Ltd Information Technology Branch. All rights reserved.
 * <a>http://www.crunii.com</a>
 */
package com.zhu.juc.fun;

import java.util.function.Consumer;

/**
 * @author 朱桂林 create 2020/11/30 9:50
 */
public class MyConsumer {
	public static void main(String[] args) {
		Consumer<String> sfasf = new Consumer<String>() {
			@Override
			public void accept(String s) {
				System.out.println(s);
			}
		};
		sfasf.accept("fdfdsf");
	}
}
