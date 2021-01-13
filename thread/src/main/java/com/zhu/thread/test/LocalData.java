/**
 * Copyright 2008-2009. Chongqing Communications Industry Services Co.,Ltd Information Technology Branch. All rights reserved.
 * <a>http://www.crunii.com</a>
 */
package com.zhu.thread.test;

/**
 * @author 朱桂林 create 2021/1/13 15:20
 */
public class LocalData {
	public String id;

	@Override
	public String toString() {
		return "LocalData{" +
				"id='" + id + '\'' +
				'}';
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
