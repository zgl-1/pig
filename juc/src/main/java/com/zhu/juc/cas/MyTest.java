/**
 * Copyright 2008-2009. Chongqing Communications Industry Services Co.,Ltd Information Technology Branch. All rights reserved.
 * <a>http://www.crunii.com</a>
 */
package com.zhu.juc.cas;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author 朱桂林 create 2020/12/9 15:34
 */
public class MyTest {
	public static void main(String[] args) {
		/*AtomicInteger atomicInteger = new AtomicInteger(1);
		//1改为2
		System.out.println(atomicInteger.compareAndSet(1, 2));
		System.out.println(atomicInteger.get());
		//2改为3
		System.out.println(atomicInteger.compareAndSet(2, 3));
		System.out.println(atomicInteger.get());
		//2改为4
		System.out.println(atomicInteger.compareAndSet(2, 4));
		System.out.println(atomicInteger.get());*/

		AtomicStampedReference<String> stringAtomicStampedReference = new AtomicStampedReference<String>("A",1);
		System.out.println(stringAtomicStampedReference.compareAndSet("A", "B", 1, 2));
		System.out.println(stringAtomicStampedReference.getReference());
		System.out.println(stringAtomicStampedReference.getStamp());


		System.out.println(stringAtomicStampedReference.compareAndSet("B", "A", 2, 3));
		System.out.println(stringAtomicStampedReference.getReference());
		System.out.println(stringAtomicStampedReference.getStamp());

		System.out.println(stringAtomicStampedReference.compareAndSet("A", "B", 1, 2));
		System.out.println(stringAtomicStampedReference.getReference());
		System.out.println(stringAtomicStampedReference.getStamp());
	}
}
