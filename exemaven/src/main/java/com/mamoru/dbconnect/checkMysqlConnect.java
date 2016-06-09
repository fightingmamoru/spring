package com.mamoru.dbconnect;

import org.apache.commons.dbcp.BasicDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CheckMysqlConnect
{
	// 실제 구동될 클래스
	public static void main(String[] args)
	{
		Connection connection = null;
		PreparedStatement pstmt = null;

		BasicDataSource dataSource = new BasicDataSource();

		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://124.50.85.159:3307/fightingmamoru");
		dataSource.setUsername("fightingmamoru");
		dataSource.setPassword("mncd0218!");

		try
		{
			connection = dataSource.getConnection();

			String sql = "SELECT USER_ID \n" +
						 "FROM TEST_USERS ";

			pstmt = connection.prepareStatement(sql);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next())
			{
				System.out.println("[Data List] USER_ID : " + rs.getString("USER_ID"));
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				connection.close();
				pstmt.close();
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
	}
}
