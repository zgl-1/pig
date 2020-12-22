package com.zhu.juc.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
 *xiaozhu
 */
public class PoolDemo {
    public static void main(String[] args) {
        //ExecutorService executorService = Executors.newSingleThreadExecutor();//单个线程执行任务
        ExecutorService executorService = Executors.newFixedThreadPool(3);//创建固定线程执行任务
        //ExecutorService executorService = Executors.newCachedThreadPool();//可缓存线程


        try {
            for (int i = 0; i < 10; i++) {
                executorService.execute(()->{
                    System.out.println(Thread.currentThread().getName());
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }


    }
}
