package com.business.dubbo.charge.utils;

import java.util.concurrent.*;

/**
 * Created by chenlile on 17-3-9.
 * 线池管理工具，统一管理线程任务
 *
 * 调用:
 * threadPoolManager = ThreadPoolManager.getInstance();
 * threadPoolManager.execute(task);
 */
public class ThreadPoolManager {

    private static final  int corePoolSize=400;

    private static final int maximumPoolSize=600;

    private static final long keepAliveTime=30;  //当线程数超过coresize,如果没有任务，线程的存活时间

    //ArrayBlockingQueue有界队列，任务超过coresize则加入队列等待，超过队列数则新生成线程执行，超过maxsize则根据handle执行
    //SynchronousQueue, 新加任务不超过maxsize，则立即分配线程运行，不会进入队列等待
    //LinkedBlockingQueue,无界队列，新加入的任务加入队列等待，maxsize在此情况无效
    private static final BlockingQueue workQueue = new ArrayBlockingQueue<Runnable>(1000);


    //可以自己定义ThreadFactory，自己生成线程，这样可以定义线程名字
    private  ThreadPoolExecutor threadPool = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, TimeUnit.SECONDS,
            workQueue, Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());


    private static ThreadPoolManager threadPoolManager;


    public static ThreadPoolManager getInstance(){
         synchronized (ThreadPoolManager.class){
             if (threadPoolManager==null){
                 threadPoolManager = new ThreadPoolManager();
             }
         }
        return threadPoolManager;
    }


    public void execute(Runnable task){
        threadPool.execute(task);
    }

    public <T> Future<T>  submit(Callable<T> task){
       return threadPool.submit(task);
    }


    public void stop(){
        threadPool.shutdown();
    }






}
