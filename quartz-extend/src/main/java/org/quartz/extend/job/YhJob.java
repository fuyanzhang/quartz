package org.quartz.extend.job;

/**
 * Author:yanzhang.fu
 * Date:2017/12/5
 * Description: job封装，业务主要实现该接口
 * Modified By：
 **/
public interface YhJob {

    /**
     * 业务处理的逻辑
     * @param jobcontext : 为json串，业务自己解析
     */
     void process(String jobcontext);
}
