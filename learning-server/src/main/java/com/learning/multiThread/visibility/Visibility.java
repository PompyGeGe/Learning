package com.learning.multiThread.visibility;

/**
 * 线程可见性
 * 本例概要：
 *    如果isShutdown不加volatile修饰，WatchThread线程改了isShutdown后（只刷到了工作内存），ReaderThread仍看不到，会一直循环，不会打印"循环结束"
 * (原文：https://www.jianshu.com/p/0008d846ca82)
 */
public class Visibility {

    public boolean isShutdown;

    public boolean getShutdown() {
        return isShutdown;
    }

    public void shutdown() {
        isShutdown = true;
    }

    public class ReaderThread extends Thread {
        @Override
        public void run() {
            try {
                System.out.println("开始循环");
                while (!isShutdown) {

                    //System.out.println("|");//若将此注释打开， System.out是个线程安全的，它会把数据刷回主存。发现Reader线程能看到isShutdown被改了，能跳出循环了。有个问题：为什么循环体外面也有System.out，但没能把数据刷回主存、无法跳出循环呢？ 原因很简单，请自行思考。

                }

                System.out.println("循环结束");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class WatchThread extends Thread {
        @Override
        public void run() {
            try {
                shutdown();
            } catch (Exception e) {

            }
        }
    }

    public static void main(String[] args) {
        try {
            Visibility demoController = new Visibility();

            demoController.new ReaderThread().start();
            //让主线程沉睡一秒，让出时间片给Reader线程去执行。确保Watch线程进来时，Reader线程已经进入循环
            Thread.sleep(1000);

            demoController.new WatchThread().start();
            //让主线程沉睡1s,确保watch线程中shutDown方法对变量的修改同步到主内存中
            Thread.sleep(1000);

            System.out.println("isShutdown---");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
