/**
 * Copyright 2008-2009. Chongqing Communications Industry Services Co.,Ltd Information Technology Branch. All rights reserved.
 * <a>http://www.crunii.com</a>
 */
package com.zhu.jpa.repository;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

/**
 * @author 朱桂林 create 2021/1/26 10:41
 */
@Transactional(readOnly = true)
public class CustomizedUsersRepository<T,ID> extends SimpleJpaRepository<T, ID>{
	private final JpaEntityInformation<T, ?> entityInformation;
	private final EntityManager em;
	public CustomizedUsersRepository(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
		super(entityInformation, entityManager);
		this.entityInformation = entityInformation;
		this.em = entityManager;
	}
	public CustomizedUsersRepository(Class<T> domainClass, EntityManager em) {
		super(domainClass, em);
		entityInformation = null;
		this.em = em;
	}

	@Transactional
	@Override
	public void delete(T entity) {
		System.out.println(entity);
	}
}
