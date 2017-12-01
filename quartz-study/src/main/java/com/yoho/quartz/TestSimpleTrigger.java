package com.yoho.quartz;

import com.yoho.quartz.Job.TestJob1;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

/**
 * @Author:yanzhang.fu
 * @Date:2017/11/27
 * @Description:
 * @Modified By：
 **/
public class TestSimpleTrigger {

    public static void main(String[] args) throws SchedulerException {
        SchedulerFactory sf = new StdSchedulerFactory();
        Scheduler sched = sf.getScheduler();

        sched.start();

        JobDetail _job = newJob(TestJob1.class)
                .withIdentity("myJob", "group1")
                .build();

        Trigger trigger = newTrigger().withIdentity("trigger", "group1").startAt(new Date()).withSchedule(simpleSchedule().withIntervalInSeconds(10).withRepeatCount(10)).forJob(_job).build();
        sched.scheduleJob(_job, trigger);
    }
}
