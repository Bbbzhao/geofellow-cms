package com.geofellow.cms.quartz.util;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;

import com.geofellow.cms.quartz.domain.SysJob;

import java.lang.reflect.InvocationTargetException;

/**
 * 定时任务处理（禁止并发执行）
 *
 * @author 
 */
@DisallowConcurrentExecution
public class QuartzDisallowConcurrentExecution extends AbstractQuartzJob {
    @Override
    protected void doExecute(JobExecutionContext context, SysJob sysJob) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException,
            InvocationTargetException {
        JobInvokeUtil.invokeMethod(sysJob);
    }
}
