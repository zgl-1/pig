/**
 * Copyright 2008-2009. Chongqing Communications Industry Services Co.,Ltd Information Technology Branch. All rights reserved.
 * <a>http://www.crunii.com</a>
 */
package com.zhu.jpa.pojo;

import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

/**
 * @author 朱桂林 create 2021/1/20 15:47
 */
@Entity
@Data
@EntityListeners(AuditingEntityListener.class)
public class Users {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long userid;
	private String username;
	private Integer age;
	private String address;

	@CreatedBy
	private Integer createid;
	@LastModifiedBy
	private Integer updateid;
	@CreatedDate
	private Date createtime;
	@LastModifiedDate
	private Date updatetime;
}
