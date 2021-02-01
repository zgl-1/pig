/**
 * Copyright 2008-2009. Chongqing Communications Industry Services Co.,Ltd Information Technology Branch. All rights reserved.
 * <a>http://www.crunii.com</a>
 */
package com.zhu.jpa.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author 朱桂林 create 2021/1/25 11:17
 */
@Data
@AllArgsConstructor
public class UsersDto {
	private String username;
	private String address;
	private String card;
}
