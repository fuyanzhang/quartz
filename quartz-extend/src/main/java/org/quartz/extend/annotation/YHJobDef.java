package org.quartz.extend.annotation;

/**
 * Author:yanzhang.fu
 * Date:2017/12/5
 * Description:  yoho注解方式创建Job
 * Modified By：
 **/
public @interface YHJobDef {

    //任务名称
    String jobname();

    //任务分组
    String jobGroup();

    //任务所在模块
    String module();

    //执行周期
    String cron() default "";

    //misfired 策略
    int misFiredPolicy() default 0;

    //任务执行上下文
    String context() default"";

    //任务类型 0-corntrigger ；1-simpleTrigger
    int jobType() default 0;

    //开始时间 格式为yyyy-MM-dd HH:mm:ss ,当类型为1时有效
    String startDate() default "";

    //重复次数，当任务类型为1时有效
    int repeatCount() default 0;

    //重复间隔 ，当任务类型为1时有效
    int interval() default 0;

}
