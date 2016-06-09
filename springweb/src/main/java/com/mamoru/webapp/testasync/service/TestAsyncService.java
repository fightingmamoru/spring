package com.mamoru.webapp.testasync.service;

import java.util.concurrent.Future;

public interface TestAsyncService
{
	Boolean processAlpha(String param) throws InterruptedException;

	Future<Boolean> processAlphaAsync() throws InterruptedException;
}
