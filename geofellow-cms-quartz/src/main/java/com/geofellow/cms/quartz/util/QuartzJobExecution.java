package com.geofellow.cms.quartz.util;

import org.quartz.JobExecutionContext;

import com.geofellow.cms.quartz.domain.SysJob;

import java.lang.reflect.InvocationTargetException;

/**
 * 定时任务处理（允许并发执行）
 *
 * @author 
 */
public class QuartzJobExecution extends AbstractQuartzJob {
    @Override
    protected void doExecute(JobExecutionContext context, SysJob sysJob) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException,
            InvocationTargetException {
        JobInvokeUtil.invokeMethod(sysJob);
    }
}
