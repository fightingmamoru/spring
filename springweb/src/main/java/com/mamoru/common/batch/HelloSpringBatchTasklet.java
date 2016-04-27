package com.mamoru.common.batch;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

/**
 * 스프링 배치 - 기본
 */
public class HelloSpringBatchTasklet implements Tasklet
{
	private String message;

	public void setMessage(String message)
	{
		this.message = message;
	}

	public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception
	{
		System.out.println("[HelloSpringBatchTasklet execute()] message : " + message );

		// 10초를 Sleep
		Thread.sleep(10000);

		return RepeatStatus.FINISHED;
	}
}
