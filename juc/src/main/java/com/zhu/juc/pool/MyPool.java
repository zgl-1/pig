package com.zhu.juc.pool;

import java.util.concurrent.*;

/*
 *xiaozhu
 */

/**
 * new ThreadPoolExecutor.AbortPolicy()抛出异常
 * new ThreadPoolExecutor.CallerRunsPolicy()哪来的回哪去，一般main线程
 * new ThreadPoolExecutor.DiscardPolicy()队列满了会丢掉新来的任务
 * new ThreadPoolExecutor.DiscardOldestPolicy()队列满了会尝试获取第一个线程
 */
public class MyPool {
    public static void main(String[] args) {
        ExecutorService executorService = new ThreadPoolExecutor(
                2,//核心线程数
                5,//最大线程数
                3,//超时等待时间
                TimeUnit.SECONDS,//超时等待时间单位
                new LinkedBlockingDeque<Runnable>(3),//放任务的队列
                Executors.defaultThreadFactory(),//默认工厂
                new ThreadPoolExecutor.DiscardOldestPolicy()//拒绝策略
                );
        System.out.println(Runtime.getRuntime().availableProcessors());
        try {
            for (int i = 0; i < 9; i++) {
                executorService.execute(()->{
                    try {
                        TimeUnit.SECONDS.sleep(2);
                        System.out.println(Thread.currentThread().getName());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }
    }
}
