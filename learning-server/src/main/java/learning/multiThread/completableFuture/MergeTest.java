package learning.multiThread.completableFuture;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * @Description: 开多个线程去执行任务，处理完后合并结果
 * 注：CompletableFuture底层代用ForkJoinPool这个默认的线程池去调度线程，虽然用户并没有指定使用线程池。里面的线程是守护线程，会随主线程的结束而结束。
 */
public class MergeTest {

    public static void main(String[] args) throws InterruptedException {

        List<String> strList = new ArrayList<>();
        strList.add("hello");
        strList.add("world");
        strList.add("java");

        long start = System.currentTimeMillis();
        List<CompletableFuture<String>> futures = new ArrayList<>();
        // 遍历每个元素，并将它们的处理结果封装成一个CompletableFuture对象
        for (String str : strList) {
            CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
                // 模拟异步任务的处理过程
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return str.toUpperCase();
            });
            futures.add(future);
        }

        // 等待所有异步任务完成，将它们的处理结果打印出来
        CompletableFuture<Void> allFutures = CompletableFuture.allOf(futures.toArray(new CompletableFuture[futures.size()]));
        allFutures.thenRun(() -> {
            System.out.println("所有异步任务已完成：");

            for (CompletableFuture<String> future : futures) {
                try {
                    String result = future.get();
                    System.out.println(result);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        Thread.sleep(2000);//让主线程晚点结束，不让子线程随主线程的结束而结束！
        long end = System.currentTimeMillis();
        System.out.println("耗费时间：" + (end - start));
        //三个子线程总共花费时间大概是1s，不是3s哦，因为是并发执行的！
    }
}
