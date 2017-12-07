package com.yoho.quartz;

import com.yoho.quartz.Job.TestJob1;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

/**
 * @Author:yanzhang.fu
 * @Date:2017/11/20
 * @Description:
 * @Modified By：
 **/
public class TestMain {
    public static void main(String[] args) throws SchedulerException, InterruptedException {
        SchedulerFactory sf = new StdSchedulerFactory();
        Scheduler sched = sf.getScheduler();
//        sched.start();
//        JobDetail job = newJob(TestJob1.class)
//                .withIdentity("myJob1", "group1")
//                .build();
//
//        JobDetail job2 = newJob(TestJob1.class)
//                .withIdentity("myJob2", "group1")
//                .build();
//        Trigger trigger = newTrigger()
//                .withIdentity("myTrigger1", "group1")
//                .startNow()
//                .withSchedule(simpleSchedule()
//                        .withIntervalInSeconds(10)
//                        .repeatForever())
//                .build();

//        Trigger   trigger = newTrigger()
//                .withIdentity("trigger1", "group1")
//                .withSchedule(cronSchedule("0/5 * * * * ?"))
//                .forJob("myJob1", "group1")
//                .build();
//        Trigger   trigger2 = newTrigger()
//                .withIdentity("trigger2", "group1")
//                .withSchedule(cronSchedule("0/5 * * * * ?"))
//                .forJob("myJob2", "group1")
//                .build();

        for(int i = 0 ;i<2;i++){
            JobDetail _job = newJob(TestJob1.class)
                    .withIdentity("myJob"+i, "group1")
                    .build();
            _job.getJobDataMap().put("hello","world");
            Trigger   _trigger;
            if(i==0){
                _trigger =  newTrigger()
                        .withIdentity("trigger"+i, "group1")
                        .withSchedule(cronSchedule("0/20 * * * * ?").withMisfireHandlingInstructionDoNothing())
                        .forJob("myJob"+i, "group1")
                        .build();
            }else{
                _trigger =  newTrigger()
                        .withIdentity("trigger"+i, "group1")
                        .withSchedule(cronSchedule("0/20 * * * * ?"))
                        .forJob("myJob"+i, "group1")
                        .build();
            }
            sched.scheduleJob(_job, _trigger);
//            Thread.sleep(20000l);
        }

    }

}
