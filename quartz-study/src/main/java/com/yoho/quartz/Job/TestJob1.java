package com.yoho.quartz.Job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @Author:yanzhang.fu
 * @Date:2017/11/20
 * @Description:
 * @Modified By：
 **/
public class TestJob1 implements Job {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException, InterruptedException {
//        System.out.println("HAHA----"+context.getJobDetail().getKey()+"////////////"+context.getFireTime());
        System.out.println(context.getJobDetail().getKey()+"紧张的处理任务中。。。"+context.getFireTime());
        Thread.sleep(100l);
//       if( context.getJobDetail().getKey().equals("myJob10")){
//            throw new JobExecutionException("failed");
//       }
//        throw new JobExecutionException("任务执行失败");
//        throw new RuntimeException();
    }
}
