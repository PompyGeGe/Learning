package com.learning.multiThread.threadPool.noReturnValue;

/**
 * @Description: 没返回值的线程池的使用 ，有返回值的例子请参见taskArrangement包的Test1类
 */
public class Test{} /*{

    //使用ThreadPoolExecutor构造器创建线程池
    private ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 200, TimeUnit.MILLISECONDS,
            new ArrayBlockingQueue<Runnable>(5));

    void com.test(){
        for(int i=0;i<15;i++){

            int finalI = i;
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("正在执行task "+ finalI);
                    try {
                        Thread.currentThread().sleep(4000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("task "+taskNum+"执行完毕");
                }
            });

            System.out.println("线程池中线程数目："+executor.getPoolSize()+"，队列中等待执行的任务数目："+
                    executor.getQueue().size()+"，已执行玩别的任务数目："+executor.getCompletedTaskCount());
        }
        executor.shutdown();
    }

    public static void main(String[] args) {
        new Test.com.test();


        List<String> list=new ArrayList<>();
        for (String s : list) {

        }

    }





}*/
