package org.quartz.extend.bootstrip.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * Author:yanzhang.fu
 * Date:2017/12/6
 * Description:
 * Modified By：
 **/
public class TestJob implements Job {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException, InterruptedException {
        System.out.println("haha");
    }
}
