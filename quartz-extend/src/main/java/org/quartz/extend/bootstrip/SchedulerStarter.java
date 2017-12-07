package org.quartz.extend.bootstrip;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;

/**
 * Author:yanzhang.fu
 * Date:2017/12/6
 * Description: job调度器的启动器，便于spring集成及优雅停机
 * Modified By：
 **/
public class SchedulerStarter {

    /**
     * 构造方法
     */
    private Scheduler sched =null;
    public SchedulerStarter(){

    }
    public void init(){
        //init config

        //init scheduler
        SchedulerFactory sf = new StdSchedulerFactory();
        try {
            sched = sf.getScheduler();
            sched.start();
        } catch (SchedulerException e) {
           //启动失败
        }

    }

    //优雅停机，等到所有任务都调度完成之后再停止调度器
    public void destory(){
        if(sched !=null){
            try {
                sched.shutdown(true);
            } catch (SchedulerException e) {
               //关闭失败，打印个日志

            }
        }
    }
}
