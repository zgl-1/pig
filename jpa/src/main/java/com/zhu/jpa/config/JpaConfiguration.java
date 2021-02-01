/**
 * Copyright 2008-2009. Chongqing Communications Industry Services Co.,Ltd Information Technology Branch. All rights reserved.
 * <a>http://www.crunii.com</a>
 */
package com.zhu.jpa.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * @author 朱桂林 create 2021/1/26 14:25
 */
@Configuration
@EnableJpaAuditing
public class JpaConfiguration {
	@Bean
	@ConditionalOnMissingBean(name = "myAuditorAware")
	MyAuditorAware myAuditorAware() {
		return new MyAuditorAware();
	}
}
