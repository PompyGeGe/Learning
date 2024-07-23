package com.learning.multiThread.completableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @Description:  CompletableFuture的回调函数
 */
public class CallBackTest {


    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + " ->supplyAsync");
            //如果任务正常执行返回666
            return 666;
        });

        //回调函数(上面的任务完成后，会在下面的whenComplete方法去对返回结果进行处理)，感觉这不像真正意义的回调，倒像是通过异步线程执行一个任务，任务完成时自动处理任务结果
        CompletableFuture<Integer> completeFuture = future.whenComplete((t, u) -> {
            //打印两个参数
            System.out.println("t->" + t * 2);
            System.out.println("u->" + u);
        }).exceptionally((e) -> {//任务执行异常处理
            System.out.println(e.getMessage());
            return 500;
        });

        System.out.println(completeFuture.get());//获取异步任务的结果
    }

}