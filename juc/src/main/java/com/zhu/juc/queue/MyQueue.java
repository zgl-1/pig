package com.zhu.juc.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/*
 *xiaozhu
 */
public class MyQueue {
    public static void main(String[] args) throws InterruptedException {
        test4();
    }

    /**
     * 超时等待
     */
    public static void test4() throws InterruptedException {
        ArrayBlockingQueue blockingQueue = new ArrayBlockingQueue<>(3);

        System.out.println(blockingQueue.offer("1"));
        System.out.println(blockingQueue.offer("2"));
        System.out.println(blockingQueue.offer("3"));
        //超时等待
        System.out.println(blockingQueue.offer("4",2, TimeUnit.SECONDS));

        //判断首位
        System.out.println(blockingQueue.peek());

        System.out.println("-----------");

        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        //超时等待
        System.out.println(blockingQueue.poll(2,TimeUnit.SECONDS));
    }

    /**
     * 阻塞等待
     */
    public static void test3() throws InterruptedException {
        ArrayBlockingQueue blockingQueue = new ArrayBlockingQueue<>(3);

        blockingQueue.put("1");
        blockingQueue.put("2");
        blockingQueue.put("3");
        //blockingQueue.put("1");//一直等待



        //判断首位
        System.out.println(blockingQueue.peek());

        System.out.println("-----------");

        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        //System.out.println(blockingQueue.take());//一直等待
    }

    /**
     * 有返回值，不抛出异常
     */
    public static void test2(){
        ArrayBlockingQueue blockingQueue = new ArrayBlockingQueue<>(3);

        System.out.println(blockingQueue.offer("1"));
        System.out.println(blockingQueue.offer("2"));
        System.out.println(blockingQueue.offer("3"));
        //false,不抛出异常
        //System.out.println(blockingQueue.offer("4"));

        //判断首位
        System.out.println(blockingQueue.peek());

        System.out.println("-----------");

        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        //返回null
        //System.out.println(blockingQueue.poll());
    }


    /**
     * 抛出异常
     */
    public static void test1(){
        ArrayBlockingQueue blockingQueue = new ArrayBlockingQueue<>(3);
        //返回true或者false
        System.out.println(blockingQueue.add("1"));
        System.out.println(blockingQueue.add("2"));
        System.out.println(blockingQueue.add("3"));
        //java.lang.IllegalStateException: Queue full
        //System.out.println(blockingQueue.add("3"));

        System.out.println(blockingQueue.element());

        System.out.println("-----------");

        //qu去除的对象
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        //java.util.NoSuchElementException
        //System.out.println(blockingQueue.remove());
    }
}
