package learning.multiThread.futureTask;

import java.util.concurrent.*;

/**
 * @Description:
 * 本例的目的是：
 *   1.FutureTask的WaitNode到底是什么，等待队列到底是什么;
 *   2.并确定此结论：里面的多线程问题指的是多个线程里获取future.get任务结果时的线程安全问题，不是SafeTest1案例的线程安全问题
 * 得出具体结论：
 *   (1)WaitNode指的是等待future.get任务结果的一个线程; 多个线程进行等待要被组织成一个等待队列！任务完成时，这些等待队列节点也会被依次删掉。
 *   (2)首先，线程安全问题不是在这种用法的场景上---多个线程用共同一个futureTask;
 *         安全问题的场景是在：只用一个异步线程去执行任务，而有多个其他线程去等待这个任务的执行结果(以等待队列的形式去组织，插入到队尾时要用CAS竞争);
 *         而且这多个线程中，有的线程想提前取消任务，就会改变FutureTask对象的state的状态为'取消'; 有的会改变FutureTask对象的state的状态为'异常'; 这得用CAS去解决并发问题！
 *      其次，即使多个线程共用同一个FutureTask，最后也只有一个线程执行到任务，其他线程执行不到任务;
 *         因为第一个线程执行完任务后就会立即修改FutureTask的state状态为完成，其他线程再获取到state状态时会发现已为完成状态，就不会再执行任务了！
 */
public class SafeTest2 {

    public static void main(String[] args) throws InterruptedException {
        // 模拟任务运行
        FutureTask<String> future =  new FutureTask<String>(() -> {
            try {

                System.out.println("进入到callable方法了");
                //让任务执行时间非常长(长达70s)，这样好让后面的多个线程一直阻塞等待结果！
                TimeUnit.SECONDS.sleep(70);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return "哈哈哈";
        });

        //让一线程立刻执行长达70s的任务
        new Thread(future).start();

        // 在T1线程里调用future.get获取任务结果
        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName()+"获取的返回结果为--"+future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }, "T1").start();

        // 确保T1先于T2启动，达到在等待队列中按序排队的效果
        TimeUnit.SECONDS.sleep(1);

        // 在T2线程里调用future.get获取任务结果
        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName()+"获取的返回结果为--"+future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }, "T2").start();

        // 确保T2先于T3启动，达到在等待队列中按序排队的效果
        TimeUnit.SECONDS.sleep(1);

        // 在T3线程里调用future.get获取任务结果
        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName()+"获取的返回结果为--"+future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }, "T3").start();





    }

}

