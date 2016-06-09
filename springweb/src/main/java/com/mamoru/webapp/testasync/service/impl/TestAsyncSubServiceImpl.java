package com.mamoru.webapp.testasync.service.impl;

import com.mamoru.webapp.testasync.service.TestAsyncSubService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

@Service
public class TestAsyncSubServiceImpl implements TestAsyncSubService
{
	@Async
	@Override
	public Future<Boolean> processBetaAsync(String param) throws InterruptedException
	{
		System.out.println("[TestAsyncSubService processBetaAsync()] START - param : " + param);

		Thread.sleep(10000);

		System.out.println("[TestAsyncSubService processBetaAsync()] END   - param : " + param);

		return new AsyncResult<Boolean>(true);
	}
}
