package com.mamoru.common.database;

import org.apache.commons.dbcp.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import javax.annotation.PostConstruct;
import java.sql.Connection;
import java.util.HashMap;

public class DBPoolManager
{
	// LOGGER
	private static Logger LOGGER = LoggerFactory.getLogger(DBPoolManager.class);

	// Spring ApplicationContext
	@Autowired
	private ApplicationContext applicationContext;

	// DB Pool
	private HashMap<String, BasicDataSource> DB_POOL = null;

	// ?
	private static DBPoolManager DB_POOL_MANAGER = new DBPoolManager();


	// Constructor
	private DBPoolManager()
	{
	}

	// Initialize
	@PostConstruct
	public void init()
	{
		// DB_POOL 초기화
		DB_POOL = new HashMap<String, BasicDataSource>();

		// 기본 DB Pool 정보를 저장 (BASIC_DB)
		String serverDBPoolName = "BASIC_DB";
		BasicDataSource BASIC_DB = (BasicDataSource) applicationContext.getBean("basicDataSource");

		// 정상적으로 생성되었는지 체크
		if ( true )
		{
			DB_POOL.put(serverDBPoolName, BASIC_DB);

			// BASIC_DB Pool 생성 로그 기록
			LOGGER.info("{} create success.", serverDBPoolName);
		}
		else
		{
			// BASIC_DB Pool 생성 로그 기록
			LOGGER.info("{} create fail.", serverDBPoolName);
		}
	}

	// Get DBPoolManager
	public static DBPoolManager getInstance()
	{
		return DB_POOL_MANAGER;
	}

	// 입력받은 정보로 DB Pool 생성
	public void addDBPool(HashMap<String, String> dbInfo)
	{
		String dBPoolName = dbInfo.get("dbPoolName");
		BasicDataSource dataSource = new BasicDataSource();

		dataSource.setDriverClassName(dbInfo.get("driverClassName"));
		dataSource.setUrl(dbInfo.get("url"));
		dataSource.setUsername(dbInfo.get("username"));
		dataSource.setPassword(dbInfo.get("password"));

		// 정상적으로 생성되었는지 체크
		if ( true )
		{
			DB_POOL.put(dBPoolName, dataSource);

			// BASIC_DB Pool 생성 로그 기록
			LOGGER.info("{} create success.", dBPoolName);
		}
		else
		{
			// BASIC_DB Pool 생성 로그 기록
			LOGGER.info("{} create fail.", dBPoolName);
		}
	}

	// Get Connection
	public synchronized Connection getConnection(String dbPoolName) throws Exception
	{
		try
		{
			// 입력 파라미터가 없을 경우 BASIC_DB pool 반환
			if ( dbPoolName == null || "".equals(dbPoolName) )
			{
				dbPoolName = "BASIC_DB";
			}

			// DB_POOL이 존재하는지 체크
			if ( DB_POOL.isEmpty() )
			{
				throw new RuntimeException(dbPoolName + " - DB Pool is Empty.");
			}

			return DB_POOL.get(dbPoolName).getConnection();
		}
		catch (Exception e)
		{
			// 실패 로그 기록
			LOGGER.error("{} - get Connection fail. : {}", dbPoolName, e.getMessage());
			throw e;
		}
	}
}
