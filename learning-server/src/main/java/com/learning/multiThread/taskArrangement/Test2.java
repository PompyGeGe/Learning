package com.learning.multiThread.taskArrangement;

import java.util.concurrent.*;

/**
 * @Description: 用普通的方式使用Future, 实现任务编排
 */
public class Test2 {


    /*** 小明需要等待厨师炒好菜 */
    void test() throws InterruptedException, ExecutionException {
        long start = System.currentTimeMillis();
        System.out.println(printThread("小明点餐"));

        //构造Future, Future接口的实现类是FutureTask, 这里FutureTask可写成Future
        FutureTask<String> future1 = new FutureTask(new Callable<String>(){
            @Override
            public String call() throws Exception {
                System.out.println(printThread("厨师开始炒菜"));
                Thread.sleep(2000);
                System.out.println(printThread("厨师炒好菜"));
                return "饭菜好了";
            }
        });

        FutureTask<String> future2 = new FutureTask(new Callable<String>(){
            @Override
            public String call() throws Exception {
                System.out.println(printThread("服务员开始准备酒水"));
                Thread.sleep(1000);
                System.out.println(printThread("服务员准备好了酒水"));
                return "酒水准备好了";
            }
        });

        new Thread(future1).start();
        new Thread(future2).start();

        //休眠5s，模拟其他业务代码执行【可以执行其他操作，而不受厨师炒菜的影响】
        System.out.println("小明开始打王者荣耀");
        //Thread.sleep(5000);
        System.out.println("小明开始打王者荣耀打完了");
        String result1 = future1.get();//这里是阻塞的，会一直等待任务的执行完成。
        String result2 = future2.get();//这里是阻塞的，会一直等待任务的执行完成。
        System.out.println(printThread(result1 + "," + result2 + ",小明开始吃饭"));
        long end = System.currentTimeMillis();
        long res = end - start;
        System.out.println("耗费时间：" + res);

        /**
         * 注：这里使用多线程执行的，多线程是并发执行的，所以纵耗费时间是2s(多一点)，而不是2s+1s(多一点)
         */
    }

    private String printThread(String message) {
        return Thread.currentThread().getName() + " " + message;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        new Test2().test();
    }
}
