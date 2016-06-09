package com.mamoru.webapp.testasync.service.impl;

import com.mamoru.webapp.testasync.service.TestAsyncService;
import com.mamoru.webapp.testasync.service.TestAsyncSubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

@Service
public class TestAsyncServiceImpl implements TestAsyncService
{
	@Autowired
	private TestAsyncSubService testAsyncSubService;

	@Override
	public Boolean processAlpha(String param) throws InterruptedException
	{
		System.out.println("[TestAsyncService processAlpha()] START - param : " + param);

		testAsyncSubService.processBetaAsync(param);

		Thread.sleep(3000);

		System.out.println("[TestAsyncService processAlpha()] END   - param : " + param);

		return true;
	}

	@Async
	@Override
	public Future<Boolean> processAlphaAsync() throws InterruptedException
	{
		System.out.println("[TestAsyncService processAlphaAsync()] START");

		processAlpha("processAlphaAsync");

		System.out.println("[TestAsyncService processAlphaAsync()] END");

		return new AsyncResult<Boolean>(true);
	}

	@Async
	@Override
	public Boolean processDeltaAsync() throws InterruptedException
	{
		System.out.println("[processDeltaAsync()] START");

		Thread.sleep(10000);

		System.out.println("[processDeltaAsync()] END");

		return true;
	}

	@Override
	public Boolean processTotal() throws InterruptedException
	{
		System.out.println("[processTotal()] START");

		Thread.sleep(3000);

		processDeltaAsync();

		System.out.println("[processTotal()] END");

		return null;
	}
}
