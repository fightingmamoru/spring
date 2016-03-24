package com.mamoru.common.database;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

// 테스트를 위한 설정 (with spring-test)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={
		"classpath*:spring/root-context.xml",
		"classpath*:spring/springwebServlet/servlet-context-common.xml",
		"classpath*:spring/springwebServlet/servlet-context-datasource.xml",
		"classpath*:spring/springwebServlet/servlet-context-mapper.xml"})
public class DBPoolManagerTest
{
	// LOGGER
	private static Logger LOGGER = LogManager.getLogger(DBPoolManagerTest.class);

	@Test
	public void selectTable()
	{
		Connection connection = null;
		PreparedStatement pstmt = null;

		try
		{
			DBPoolManager poolManager = DBPoolManager.getInstance();

			// DB 정보입력
			HashMap<String, String> dbInfo = new HashMap<String, String>();

			dbInfo.put("dbPoolName", "MOONLEAF_MYSQL");
			dbInfo.put("driverClassName", "com.mysql.jdbc.Driver");
			dbInfo.put("url", "jdbc:mysql://124.50.85.159:3307/fightingmamoru");
			dbInfo.put("username", "fightingmamoru");
			dbInfo.put("password", "mncd0218!");

			poolManager.addDBPool(dbInfo);

			connection = poolManager.getConnection("MOONLEAF_MYSQL");

//			String sql = "SELECT COLUMN_NAME \n" +
//						 "FROM COLS \n" +
//						 "WHERE TABLE_NAME = 'LINKS'";

			String sql = "SELECT USER_ID \n" +
						 "FROM TEST_USERS ";

			pstmt = connection.prepareStatement(sql);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next())
			{
				LOGGER.debug("[Data List] " + rs.getString("USER_ID"));
			}
		}
		catch (Exception e)
		{
			LOGGER.error(e);
		}
		finally
		{
			try
			{
				connection.close();
			}
			catch (SQLException e)
			{
				LOGGER.error(e);
			}

			try
			{
				pstmt.close();
			}
			catch (SQLException e)
			{
				LOGGER.error(e);
			}
		}
	}
}