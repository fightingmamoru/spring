package com.mamoru.common.database;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import javax.annotation.PostConstruct;
import java.sql.Connection;
import java.sql.SQLException;

public class DBConnector
{
	private static Logger LOGGER = LogManager.getLogger(DBConnector.class);

	@Autowired
	protected ApplicationContext applicationContext;

	private BasicDataSource basicDataSource = null;

	private static DBConnector dbConnector = new DBConnector();

	private DBConnector()
	{
		LOGGER.debug("[DBConnector constructor load]");
	}

	public static DBConnector getInstance()
	{
		return dbConnector;
	}

	@PostConstruct
	public void init()
	{
		// 기본 DB 풀을 만들때는 dataSource Bean을 기반으로 곧 바로 생성 가능
		LOGGER.debug("[Init DB Connector] START ===========================================================");

		basicDataSource = (BasicDataSource) applicationContext.getBean("basicDataSource");

		LOGGER.debug("[BasicDataSource Info] " + basicDataSource.getDriverClassName());

		LOGGER.debug("[Init DB Connector] END =============================================================\n");

		// 추가로 데이터 풀을 만들기 위해서는 추가정보 필요. (DB에서 조회한 정보? 같은 것들)
		// 실제적으로 관리를 이해서는 따로 DB 풀을 관리하는 클래스를 만들고 제어하게 처리 필요

//		BasicDataSource dataSource = new BasicDataSource();
//
//		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
//		dataSource.setUrl("jdbc:oracle:thin:@//192.168.123.16:1521/ORA10");
//		dataSource.setUsername("openidm");
//		dataSource.setPassword("openidm");
//
//		basicDataSource = dataSource;
	}

	public synchronized Connection getConnection() throws SQLException
	{
		try
		{
			return basicDataSource.getConnection();
		}
		catch (SQLException e)
		{
			LOGGER.error(e);
			throw e;
		}
	}
}
