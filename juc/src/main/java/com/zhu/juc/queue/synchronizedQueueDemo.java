package com.zhu.juc.queue;


import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/*
 *xiaozhu
 */

/**
 * SynchronousQueue同步队列，不存储元素
 * 放入一个值就必须要取出一个值
 */
public class synchronizedQueueDemo {
    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new SynchronousQueue<String>();

        new Thread(()->{
            try {
                System.out.println(Thread.currentThread().getName()+"放入了第一个");
                blockingQueue.put("1");
                System.out.println(Thread.currentThread().getName()+"放入了第二个");
                blockingQueue.put("2");
                System.out.println(Thread.currentThread().getName()+"放入了第三个");
                blockingQueue.put("3");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"T1").start();
        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(2);
                System.out.println(Thread.currentThread().getName()+"->"+blockingQueue.take());
                System.out.println(Thread.currentThread().getName()+"->"+blockingQueue.take());
                System.out.println(Thread.currentThread().getName()+"->"+blockingQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"T2").start();
    }
}
