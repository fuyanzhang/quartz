package org.quartz.extend.job;

import lombok.Setter;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.utils.DBConnectionManager;

/**
 * Author:yanzhang.fu
 * Date:2017/12/6
 * Description: 框架内部实现quartz的Job接口，实际上是YhJob的实现类的一个代理，不允许被扩展
 * Modified By：
 **/
public final class YohoInternalJob implements Job {

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException, InterruptedException {
        /**
         * 主要干如下几件事：
         * 1、根据jobkey查询表yh_job_detail,获取执行器及执行所需上下文
         * 2、是否指定了ip，指定ip则判断是否是该ip，是则执行，不是直接返回
         * 3、执行具体业务逻辑
         * 4、返回执行结果，入库job_run_log，有失败，上报告警。
         *5、若为重试操作，则删除trigger。
         */
        try{
            //如何获取数据库连接

            DBConnectionManager.getInstance().getConnection("myDS");
        }catch (Throwable e){
            //执行异常处理，包括runtimeexception


        }finally{
            //任务执行日志入库
            //若为重试，则删除trigger
        }

    }
}
