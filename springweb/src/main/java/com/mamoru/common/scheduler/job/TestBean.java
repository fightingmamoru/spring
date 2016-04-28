package com.mamoru.common.scheduler.job;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TestBean
{
	// LOGGER
	private static Logger LOGGER = LogManager.getLogger(TestBean.class);

	public void doCallingOne()
	{
		LOGGER.debug("[doCallingOne() - called]");
	}

	public void doCallingTwo()
	{
		LOGGER.debug("[doCallingTwo() - called]");
	}
}
