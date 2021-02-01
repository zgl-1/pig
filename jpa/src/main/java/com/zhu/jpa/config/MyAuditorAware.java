/**
 * Copyright 2008-2009. Chongqing Communications Industry Services Co.,Ltd Information Technology Branch. All rights reserved.
 * <a>http://www.crunii.com</a>
 */
package com.zhu.jpa.config;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

/**
 * @author 朱桂林 create 2021/1/26 14:17
 */
public class MyAuditorAware implements AuditorAware<Integer> {
	@Override
	public Optional<Integer> getCurrentAuditor() {
		Optional<Integer> integer = Optional.of(2);
		return integer;
	}
}
