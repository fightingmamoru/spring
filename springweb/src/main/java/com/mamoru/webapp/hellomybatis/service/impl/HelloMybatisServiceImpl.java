package com.mamoru.webapp.hellomybatis.service.impl;

import com.mamoru.webapp.hellomybatis.mapper.HelloMybatisMapper;
import com.mamoru.webapp.hellomybatis.service.HelloMybatisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class HelloMybatisServiceImpl implements HelloMybatisService
{
	@Autowired
	private HelloMybatisMapper helloMybatisMapper;

	public List<String> getColumns(String tableName) throws SQLException
	{
		return helloMybatisMapper.selectColumns(tableName);
	}
}
