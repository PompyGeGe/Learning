package com.learning.multiThread.futureTask;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Description: 探究FutureTask的安全问题！
 */
public class SafeTest1 {

    class TicketC implements Callable {
        private int ticket = 100;

        @Override
        public Object call() throws Exception {
            while (true) {
                try {
                    Thread.sleep(200);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + ": 余票为: " + --ticket);
                }
            }
        }
    }



    public static void main(String[] args) throws ExecutionException, InterruptedException {

        /* "FutureTask本身利用了CAS实现了线程安全, 对临界资源的操作不需要加锁"， 这种想法是错的！原因：
        *     首先，线程安全问题不是在这种用法的场景上---多个线程用共同一个futureTask;
        *          安全问题的场景是在：只用一个异步线程去执行任务，而有多个其他线程去等待这个任务的执行结果(以等待队列的形式去组织，插入到队尾时要用CAS竞争);
        *          而且这多个线程中，有的线程想提前取消任务，就会改变FutureTask对象的state的状态为'取消'; 有的会改变FutureTask对象的state的状态为'异常'; 这得用CAS去解决并发问题！
        *     其次，即使多个线程共用同一个FutureTask，最后也只有一个线程执行到任务，其他线程执行不到任务;
        *          因为第一个线程执行完任务后就会立即修改FutureTask的state状态为完成，其他线程再获取到state状态时会发现已为完成状态，就不会再执行任务了！
        * */
        TicketC ticketC = new SafeTest1().new TicketC();
        FutureTask<Object> futureTask = new FutureTask<Object>(ticketC);
        new Thread(futureTask, "1号窗口").start();
        new Thread(futureTask, "2号窗口").start();
        new Thread(futureTask, "3号窗口").start();

        System.out.println("任务结束后，余票为：" + futureTask.get());
    }


}

