package com.mamoru.common.scheduler.job;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

// 테스트를 위한 설정 (with spring-test)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={
		"classpath*:spring/root-context.xml",
		"classpath*:spring/springwebServlet/servlet-context-common.xml",
		"classpath*:spring/springwebServlet/servlet-context-datasource.xml",
		"classpath*:spring/springwebServlet/servlet-context-mapper.xml",
		"classpath*:spring/springwebServlet/servlet-context-quartz.xml"})
public class TestJobTest
{
	@Test
	public void test() throws InterruptedException
	{
		System.out.println("[TestJobTest] START");

		Thread.sleep(30000);

		System.out.println("[TestJobTest] END");
	}
}