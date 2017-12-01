package org.quartz.impl.zkjobstore;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.cache.TreeCache;
import org.apache.curator.framework.recipes.cache.TreeCacheEvent;
import org.apache.curator.framework.recipes.cache.TreeCacheListener;
import org.quartz.*;
import org.quartz.impl.DefaultThreadExecutor;
import org.quartz.impl.jdbcjobstore.SchedulerStateRecord;
import org.quartz.impl.matchers.GroupMatcher;
import org.quartz.spi.*;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Author:yanzhang.fu
 * Date:2017/12/1
 * Description: 用于支持任务在zk上持久化的场景
 * Modified By：
 **/
public class JobZkStoreSupport implements JobStore {

    private CuratorFramework client;

    private ThreadExecutor threadExecutor = new DefaultThreadExecutor();

    protected  String instanceName;

    public  void setThreadExecutor(ThreadExecutor threadExecutor) {
        this.threadExecutor = threadExecutor;
    }

    public ThreadExecutor getThreadExecutor() {
        return threadExecutor;
    }

    @Override
    public void initialize(ClassLoadHelper loadHelper, SchedulerSignaler signaler) throws SchedulerConfigException {

    }

    @Override
    public void schedulerStarted() throws SchedulerException {
        //treeCache，建立监听
        TreeCache cache = new TreeCache(client, this.instanceName);
        try {
            cache.start();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void schedulerPaused() {

    }

    @Override
    public void schedulerResumed() {

    }

    @Override
    public void shutdown() {

    }

    @Override
    public boolean supportsPersistence() {
        return false;
    }

    @Override
    public long getEstimatedTimeToReleaseAndAcquireTrigger() {
        return 0;
    }

    @Override
    public boolean isClustered() {
        return false;
    }

    @Override
    public void storeJobAndTrigger(JobDetail newJob, OperableTrigger newTrigger) throws ObjectAlreadyExistsException, JobPersistenceException {

    }

    @Override
    public void storeJob(JobDetail newJob, boolean replaceExisting) throws ObjectAlreadyExistsException, JobPersistenceException {

    }

    @Override
    public void storeJobsAndTriggers(Map<JobDetail, Set<? extends Trigger>> triggersAndJobs, boolean replace) throws ObjectAlreadyExistsException, JobPersistenceException {

    }

    @Override
    public boolean removeJob(JobKey jobKey) throws JobPersistenceException {
        return false;
    }

    @Override
    public boolean removeJobs(List<JobKey> jobKeys) throws JobPersistenceException {
        return false;
    }

    @Override
    public JobDetail retrieveJob(JobKey jobKey) throws JobPersistenceException {
        return null;
    }

    @Override
    public void storeTrigger(OperableTrigger newTrigger, boolean replaceExisting) throws ObjectAlreadyExistsException, JobPersistenceException {

    }

    @Override
    public boolean removeTrigger(TriggerKey triggerKey) throws JobPersistenceException {
        return false;
    }

    @Override
    public boolean removeTriggers(List<TriggerKey> triggerKeys) throws JobPersistenceException {
        return false;
    }

    @Override
    public boolean replaceTrigger(TriggerKey triggerKey, OperableTrigger newTrigger) throws JobPersistenceException {
        return false;
    }

    @Override
    public OperableTrigger retrieveTrigger(TriggerKey triggerKey) throws JobPersistenceException {
        return null;
    }

    @Override
    public boolean checkExists(JobKey jobKey) throws JobPersistenceException {
        return false;
    }

    @Override
    public boolean checkExists(TriggerKey triggerKey) throws JobPersistenceException {
        return false;
    }

    @Override
    public void clearAllSchedulingData() throws JobPersistenceException {

    }

    @Override
    public void storeCalendar(String name, Calendar calendar, boolean replaceExisting, boolean updateTriggers) throws ObjectAlreadyExistsException, JobPersistenceException {

    }

    @Override
    public boolean removeCalendar(String calName) throws JobPersistenceException {
        return false;
    }

    @Override
    public Calendar retrieveCalendar(String calName) throws JobPersistenceException {
        return null;
    }

    @Override
    public int getNumberOfJobs() throws JobPersistenceException {
        return 0;
    }

    @Override
    public int getNumberOfTriggers() throws JobPersistenceException {
        return 0;
    }

    @Override
    public int getNumberOfCalendars() throws JobPersistenceException {
        return 0;
    }

    @Override
    public Set<JobKey> getJobKeys(GroupMatcher<JobKey> matcher) throws JobPersistenceException {
        return null;
    }

    @Override
    public Set<TriggerKey> getTriggerKeys(GroupMatcher<TriggerKey> matcher) throws JobPersistenceException {
        return null;
    }

    @Override
    public List<String> getJobGroupNames() throws JobPersistenceException {
        return null;
    }

    @Override
    public List<String> getTriggerGroupNames() throws JobPersistenceException {
        return null;
    }

    @Override
    public List<String> getCalendarNames() throws JobPersistenceException {
        return null;
    }

    @Override
    public List<OperableTrigger> getTriggersForJob(JobKey jobKey) throws JobPersistenceException {
        return null;
    }

    @Override
    public Trigger.TriggerState getTriggerState(TriggerKey triggerKey) throws JobPersistenceException {
        return null;
    }

    @Override
    public void resetTriggerFromErrorState(TriggerKey triggerKey) throws JobPersistenceException {

    }

    @Override
    public void pauseTrigger(TriggerKey triggerKey) throws JobPersistenceException {

    }

    @Override
    public Collection<String> pauseTriggers(GroupMatcher<TriggerKey> matcher) throws JobPersistenceException {
        return null;
    }

    @Override
    public void pauseJob(JobKey jobKey) throws JobPersistenceException {

    }

    @Override
    public Collection<String> pauseJobs(GroupMatcher<JobKey> groupMatcher) throws JobPersistenceException {
        return null;
    }

    @Override
    public void resumeTrigger(TriggerKey triggerKey) throws JobPersistenceException {

    }

    @Override
    public Collection<String> resumeTriggers(GroupMatcher<TriggerKey> matcher) throws JobPersistenceException {
        return null;
    }

    @Override
    public Set<String> getPausedTriggerGroups() throws JobPersistenceException {
        return null;
    }

    @Override
    public void resumeJob(JobKey jobKey) throws JobPersistenceException {

    }

    @Override
    public Collection<String> resumeJobs(GroupMatcher<JobKey> matcher) throws JobPersistenceException {
        return null;
    }

    @Override
    public void pauseAll() throws JobPersistenceException {

    }

    @Override
    public void resumeAll() throws JobPersistenceException {

    }

    @Override
    public List<OperableTrigger> acquireNextTriggers(long noLaterThan, int maxCount, long timeWindow) throws JobPersistenceException {
        return null;
    }

    @Override
    public void releaseAcquiredTrigger(OperableTrigger trigger) {

    }

    @Override
    public List<TriggerFiredResult> triggersFired(List<OperableTrigger> triggers) throws JobPersistenceException {
        return null;
    }

    @Override
    public void triggeredJobComplete(OperableTrigger trigger, JobDetail jobDetail, Trigger.CompletedExecutionInstruction triggerInstCode) {

    }

    @Override
    public void setInstanceId(String schedInstId) {

    }

    @Override
    public void setInstanceName(String schedName) {
        this.instanceName = schedName;
    }

    @Override
    public void setThreadPoolSize(int poolSize) {

    }

    @Override
    public long getAcquireRetryDelay(int failureCount) {
        return 0;
    }

    public CuratorFramework getClient() {
        return client;
    }

    public void setClient(CuratorFramework client) {
        this.client = client;
    }


    //判断调度器实例状态
    protected List<SchedulerStateRecord> clusterCheckIn(){
        return null;
    }
}
