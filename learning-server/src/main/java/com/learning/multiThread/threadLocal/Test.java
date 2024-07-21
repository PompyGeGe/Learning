package com.learning.multiThread.threadLocal;

import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: 皮皮
 * @Date: 2022/11/26 11:11
 * @Description: 用自增长的i，循环1000次，打印日期。 理论上，不同的线程拥有的i不一样，打印的日期也不一样。
 * 【synchronized等锁和ThreadLocal区别】：锁是为了解决多线程对同一共享资源的合理使用(线程需要排队，通讯等)，ThreadLocal是为了让每一个线程有自己的一份资源，操作时互不影响。
 */
@Slf4j
public class Test {

    public static final ExecutorService executorService = Executors.newFixedThreadPool(8);

    /**
     * 【方案零： 每个线程在用到SimpleDateFormat时都new一个】
     * 分析：虽无线程安全问题，但每个线程在每个用到SimpleDateFormat的地方都要new一个，10个地方用到SimpleDateFormat就要new 10次，太浪费资源了。
     */

    /*
     * 【方案一： 使用成员变量】
     * 分析：定义一个成员变量， 让所有线程都可以操作这个变量； 但多线程一起用这个成员变量时，会发生线程安全问题。
     * 不安全的原因： 调用format方法时，多个线程会同时调用calender.setTime方法，导致time被别的线程修改，因此线程是不安全的。
     * 因此，SimpleDateFormat就不要被多线程使用啦！
     */
    /*public static final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {

            int j = i;
            executorService.execute(()->{
                log.info("j={}, thread={}, time={}", j, Thread.currentThread().getName(), format.format(new Date(j * 1000)));
            });
        }

        *//**
         * 结果： 日期有重复的。说明不同线程间互相影响了。
         *//*
    }*/


    /**
     * 【方案二： 使用ThreadLocal，ThreadLocal创建的变量只能被当前线程访问，其他线程无法访问和修改，解决了线程安全的问题】
     */
    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {

            int j = i;
            executorService.execute(()->{
                String date = ThreadLocalRepository.dateFormatThreadLocal.get().format(new Date(j * 1000));
                log.info("j={}, thread={}, time={}", j, Thread.currentThread().getName(), date);

            });
        }

        /**
         * 结果： 日期没有重复的。不同线程间不会影响。
         */

    }







}
