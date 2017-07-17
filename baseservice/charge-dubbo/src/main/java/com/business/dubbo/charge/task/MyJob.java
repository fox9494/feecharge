package com.business.dubbo.charge.task;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * Created by chenll on 2017/7/11.
 */
public class MyJob implements Job {


    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("我正在执行定时任务的业务逻辑  " );
    }
}
