package org.quartz.impl.zkjobstore.listener;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.cache.ChildData;
import org.apache.curator.framework.recipes.cache.TreeCacheEvent;
import org.apache.curator.framework.recipes.cache.TreeCacheListener;

/**
 * Author:yanzhang.fu
 * Date:2017/12/1
 * Description:
 * Modified By：
 **/
public class ClusterHeathListener implements TreeCacheListener {

    private String schedulerName;

    public ClusterHeathListener(String schedulerName) {
        this.schedulerName = schedulerName;
    }

    @Override
    public void childEvent(CuratorFramework client, TreeCacheEvent event) throws Exception {
        ChildData childData = event.getData();
        if (childData == null) {
            return;
        }
        String path = childData.getPath();
        if(!(path.startsWith(schedulerName+"/instances"))){
            return;
        }
        switch (event.getType()) {
            case NODE_REMOVED:
                //有实例下线，则需要获取本实例下的所有trigger，并将trigger状态还原

                break;
            default:
                break;
        }
    }
}
