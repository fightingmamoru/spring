package com.mamoru.common.scheduler.job;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class TestJob extends QuartzJobBean
{
	// LOGGER
	private static Logger LOGGER = LogManager.getLogger(TestJob.class);

	@Override
	protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException
	{
		LOGGER.debug("[TestJob] START : " + System.currentTimeMillis());

		try
		{
			Thread.sleep(5000);
		}
		catch (InterruptedException e)
		{
			LOGGER.error("[TestJob InterruptedException] ", e);
		}

		LOGGER.debug("[TestJob] END   : " + System.currentTimeMillis());
	}
}
