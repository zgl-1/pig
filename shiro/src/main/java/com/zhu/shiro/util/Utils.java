/**
 * Copyright 2008-2009. Chongqing Communications Industry Services Co.,Ltd Information Technology Branch. All rights reserved.
 * <a>http://www.crunii.com</a>
 */
package com.zhu.shiro.util;

import java.util.UUID;

/**
 * @author 朱桂林 create 2021/2/3 15:52
 */
public class Utils {
	public static String getSalt(){
		return UUID.randomUUID().toString().substring(4,8);
	}
}
