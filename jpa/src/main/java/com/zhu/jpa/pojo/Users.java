/**
 * Copyright 2008-2009. Chongqing Communications Industry Services Co.,Ltd Information Technology Branch. All rights reserved.
 * <a>http://www.crunii.com</a>
 */
package com.zhu.jpa.pojo;

import lombok.Data;

import javax.persistence.*;

/**
 * @author 朱桂林 create 2021/1/20 15:47
 */
@Entity
@Data
public class Users {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long userid;
	private String username;
	private Integer age;
	private String address;
}
