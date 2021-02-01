/**
 * Copyright 2008-2009. Chongqing Communications Industry Services Co.,Ltd Information Technology Branch. All rights reserved.
 * <a>http://www.crunii.com</a>
 */
package com.zhu.jpa.repository;

import com.zhu.jpa.pojo.Users;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

/**
 * @author 朱桂林 create 2021/1/26 10:18
 */
public class CustomizedUserRepositoryImpl implements CustomizedUserRepository{
	private EntityManager entityManager;
	public CustomizedUserRepositoryImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	@Transactional
	@Override
	public void deleteUsers(Users users) {
		//还没有定义逻辑删除字段，用address代替一下
		users.setAddress("逻辑删除");
		entityManager.merge(users);
		entityManager.flush();
	}
}
