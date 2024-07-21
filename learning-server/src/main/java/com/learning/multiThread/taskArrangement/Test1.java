package com.learning.multiThread.taskArrangement;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @Description: 用线程池的方式使用Future, 实现任务编排
 */
public class Test1 {

    //使用Executors类创建线程池
    ExecutorService executorService = Executors.newFixedThreadPool(10);

    /*** 小明需要等待厨师炒好菜 */
    void test() throws InterruptedException, ExecutionException {
        long start = System.currentTimeMillis();
        System.out.println(printThread("小明点餐"));

        Future<String> future1 = executorService.submit(() -> {
            System.out.println(printThread("厨师开始炒菜"));
            Thread.sleep(2000);
            System.out.println(printThread("厨师炒好菜"));
            return "饭菜好了";
        });//submit里调用了线程的start(), 不需要用户自己写start()!

        Future<String> future2 = executorService.submit(() -> {
            System.out.println(printThread("服务员开始准备酒水"));
            Thread.sleep(1000);
            System.out.println(printThread("服务员准备好了酒水"));
            return "酒水准备好了";
        });

        //休眠5s，模拟其他业务代码执行【可以执行其他操作，而不受厨师炒菜的影响】
        System.out.println("小明开始打王者荣耀");
        //Thread.sleep(5000);
        System.out.println("小明开始打王者荣耀打完了");
        String result1 = future1.get();//这里是阻塞的，会一直等待任务的执行完成。
        String result2 = future2.get();//这里是阻塞的，会一直等待任务的执行完成。
        executorService.shutdown();
        System.out.println(printThread(result1 + "," + result2 + ",小明开始吃饭"));
        long end = System.currentTimeMillis();
        long res = end - start;
        System.out.println("耗费时间：" + res);

        /**
         * 注1：这里使用多线程执行的，多线程是并发执行的，所以纵耗费时间是2s(多一点)，而不是2s+1s(多一点)
         */
        /**
         * 注2：看源码发现线程池的submit(Callable c)方法会先把c封装成一个Runnable类型的FutureTask对象, 再把这个对象传入execute(Runnable r)方法去执行！
         * 说明：(1)FutureTask里使用callable的原理和线程池submit使用callable的原理是一样的，都是：把Callable对象封装成Runnable类型的FutureTask对象，再用这个Runnable对象作为线程的执行对象！
         *      (2)线程池的submit(Callable c)方法实际调用的是execute(Runnable r)方法
         */
    }

    private String printThread(String message) {
        return Thread.currentThread().getName() + " " + message;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        new Test1().test();
    }
}
