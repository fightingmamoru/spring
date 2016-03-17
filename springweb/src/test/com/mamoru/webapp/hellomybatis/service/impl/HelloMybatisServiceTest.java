package com.mamoru.webapp.hellomybatis.service.impl;

import com.mamoru.webapp.hellomybatis.service.HelloMybatisService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.SQLException;
import java.util.List;

// 테스트를 위한 설정 (with spring-test)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={
		"classpath*:spring/root-context.xml",
		"classpath*:spring/springwebServlet/servlet-context-common.xml",
		"classpath*:spring/springwebServlet/servlet-context-datasource.xml",
		"classpath*:spring/springwebServlet/servlet-context-mapper.xml"})
public class HelloMybatisServiceTest
{
	@Autowired
	private HelloMybatisService helloMybatisService;

	@Test
	public void getLinksTabelCols() throws SQLException
	{
		String tableName = "LINKS";

		List<String> cols = helloMybatisService.getColumns(tableName);

		for ( String col : cols )
		{
			System.out.println("[COLS] " + col);
		}
	}
}