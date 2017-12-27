package com.yoho.quartz;

import com.yoho.quartz.Job.TestJob1;
import org.quartz.*;
import org.quartz.impl.DirectSchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

/**
 * Author:yanzhang.fu
 * Date:2017/12/26
 * Description:
 * Modified By：
 **/
public class QuartzExample {
    public static void main(String[] args) throws SchedulerException {
        SchedulerFactory sf = new StdSchedulerFactory();
        DirectSchedulerFactory dsf = DirectSchedulerFactory.getInstance();
        dsf.createScheduler(1);
        //====启动调度器====
        Scheduler sched = sf.getScheduler();

        Scheduler dsched = dsf.getScheduler();
        sched.start();
        dsched.start();

        //====创建trigger ====
        //创建一个cron trigger
        Trigger cronTrigger = newTrigger()
                .withIdentity("cronTrigger", "group")
                .withSchedule(cronSchedule("0/20 * * * * ?").withMisfireHandlingInstructionFireAndProceed()).withPriority(5).endAt(new Date())
                .build();

        //创建一个simple trigger
        Trigger simpleTrigger = newTrigger().withIdentity("simpleTrigger","group").startAt(new Date()).withSchedule(simpleSchedule().withIntervalInSeconds(10).withRepeatCount(4)).build();
        //====创建job ====
        JobDetail job = newJob(TestJob1.class)
                .withIdentity("myJob", "group")
                .build();
        job.getJobDataMap().put("hello","world");

        //====将tirgger和job加入调度器进行调度
        sched.scheduleJob(job,cronTrigger);
        sched.scheduleJob(job,simpleTrigger);
    }
}
