/**
 * Copyright 2008-2009. Chongqing Communications Industry Services Co.,Ltd Information Technology Branch. All rights reserved.
 * <a>http://www.crunii.com</a>
 */
package com.zhu.juc.test1;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.BeanUtils;

import java.beans.PropertyDescriptor;

/**
 * @author 朱桂林 create 2020/12/2 10:15
 */
public class MyTest {
	public static void main(String[] args) {
		PropertyDescriptor[] propertyDescriptors = BeanUtils.getPropertyDescriptors(Date.class);
		System.out.println(propertyDescriptors);
	}
}

@Getter
@Setter
@ToString
class Date{
	private String zAccountNo;//主（对）端专线号
	private String userName;//用户名称
}