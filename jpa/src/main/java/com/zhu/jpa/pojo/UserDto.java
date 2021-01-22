/**
 * Copyright 2008-2009. Chongqing Communications Industry Services Co.,Ltd Information Technology Branch. All rights reserved.
 * <a>http://www.crunii.com</a>
 */
package com.zhu.jpa.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author 朱桂林 create 2021/1/22 15:39
 */
@Data
@AllArgsConstructor
public class UserDto {
	private String username;
}
