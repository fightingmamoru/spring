package com.mamoru.common.thread;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

// 테스트를 위한 설정 (with spring-test)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={
		"classpath*:spring/root-context.xml",
		"classpath*:spring/springwebServlet/servlet-context-common.xml",
		"classpath*:spring/springwebServlet/servlet-context-datasource.xml",
		"classpath*:spring/springwebServlet/servlet-context-mapper.xml",
		"classpath*:spring/springwebServlet/servlet-context-batch.xml",
		"classpath*:spring/springwebServlet/servlet-context-taskexecutor.xml"})
public class HelloSpringThreadTaskTest
{
	@Autowired
	ApplicationContext context;

	@Test
	public void threadTest()
	{
		ThreadPoolTaskExecutor executor = (ThreadPoolTaskExecutor) context.getBean("taskExecutor");

		executor.execute(new HelloSpringThreadTask("TestThread-1", 10000));
		executor.execute(new HelloSpringThreadTask("TestThread-2", 5000));
		executor.execute(new HelloSpringThreadTask("TestThread-3", 3000));
		executor.execute(new HelloSpringThreadTask("TestThread-4", 12000));
		executor.execute(new HelloSpringThreadTask("TestThread-5", 8000));

		boolean endFlag = true;

		while ( endFlag )
		{
			int activeThreadCount = executor.getActiveCount();
			System.out.println("[Active Thread Count] " + activeThreadCount);

			try
			{
				Thread.sleep(1000);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}

			if ( activeThreadCount == 0 )
			{
				executor.shutdown();
				endFlag = false;
			}
		}
	}
}