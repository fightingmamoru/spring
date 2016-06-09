package com.mamoru.webapp.testasync.service;

import java.util.concurrent.Future;

public interface TestAsyncSubService
{
	Future<Boolean> processBetaAsync(String param) throws InterruptedException;
}
