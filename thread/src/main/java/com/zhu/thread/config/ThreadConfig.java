/**
 * Copyright 2008-2009. Chongqing Communications Industry Services Co.,Ltd Information Technology Branch. All rights reserved.
 * <a>http://www.crunii.com</a>
 */
package com.zhu.thread.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author 朱桂林 create 2020/11/9 18:15
 */
@Configuration
public class ThreadConfig {
	//核心线程池大小
	private final int poolSize = 10;
	//最大线程数
	private final int maxPoolSize = 18;
	//队列容量
	private final int queueCapacity = 30;
	//活跃时间/秒
	private final int keepAliveSeconds = 30;

	@Bean("myThreadPoll")
	public Executor myThreadPool() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(poolSize);
		executor.setMaxPoolSize(maxPoolSize);
		executor.setQueueCapacity(queueCapacity);
		executor.setKeepAliveSeconds(keepAliveSeconds);
		executor.setThreadNamePrefix("myThread-zgl-");//前缀名
		//当池中的线程使用完时，新任务由调用者所在的线程执行
		executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
		executor.initialize();
		return  executor;
	}
}
