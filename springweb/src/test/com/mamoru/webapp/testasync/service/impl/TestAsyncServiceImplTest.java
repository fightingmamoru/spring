package com.mamoru.webapp.testasync.service.impl;

import com.mamoru.webapp.testasync.service.TestAsyncService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

// 테스트를 위한 설정 (with spring-test)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={
		"classpath*:spring/root-context.xml",
		"classpath*:spring/springwebServlet/servlet-context-common.xml",
		"classpath*:spring/springwebServlet/servlet-context-datasource.xml",
		"classpath*:spring/springwebServlet/servlet-context-mapper.xml",
		"classpath*:spring/springwebServlet/servlet-context-batch.xml"})
public class TestAsyncServiceImplTest
{
	@Autowired
	private TestAsyncService testAsyncService;

	@Test
	public void test() throws InterruptedException
	{
		System.out.println("[Test] START");

		testAsyncService.processAlpha("TEST");

		Thread.sleep(20000);

		System.out.println("[Test] END");
	}
}