package com.mamoru.common.batch;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
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
public class HelloSpringBatchTaskletTest
{
	@Autowired
	ApplicationContext context;

	@Test
	public void batchTest() throws Exception
	{
		System.out.println("[batchTest() ] START ===========================================================");

		JobLauncher jobLauncher = (JobLauncher) context.getBean("jobLauncher");
		Job job = (Job) context.getBean("helloSpringBatchJob");

		JobParameters jobParameters = new JobParameters();
		JobExecution execution = jobLauncher.run(job, jobParameters);

		System.out.println("[batchTest() Status] " + execution.getStatus());

		System.out.println("[batchTest() ] END =============================================================");
	}
}