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

// 테스트를 위한 설정 (with spring-test)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={
		"classpath*:spring/root-context.xml",
		"classpath*:spring/springwebServlet/servlet-context-common.xml",
		"classpath*:spring/springwebServlet/servlet-context-datasource.xml"})
public class DBConnectorTest
{
	private static Logger LOGGER = LogManager.getLogger(DBConnectorTest.class);

	@Test
	public void selectTable() throws SQLException
	{
		Connection connection = DBConnector.getInstance().getConnection();

		String sql = "SELECT COLUMN_NAME\n" +
					 "FROM COLS\n" +
					 "WHERE TABLE_NAME = 'LINKS'";

		PreparedStatement pstmt =connection.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();

		while ( rs.next() )
		{
			LOGGER.debug("[Data List] " + rs.getString("COLUMN_NAME"));
		}

		pstmt.close();
		connection.close();
	}
}