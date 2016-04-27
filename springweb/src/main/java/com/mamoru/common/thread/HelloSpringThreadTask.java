package com.mamoru.common.thread;

public class HelloSpringThreadTask implements Runnable
{
	private String threadName;
	private long sleepTime;

	public HelloSpringThreadTask(String threadName, long sleepTime)
	{
		this.threadName = threadName;
		this.sleepTime = sleepTime;
	}

	public void run()
	{
		System.out.println("[HelloSpringThreadTask START] " + threadName + "=================================");

		try
		{
			Thread.sleep(sleepTime);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}

		System.out.println("[HelloSpringThreadTask END] " + threadName + "===================================");
	}
}
