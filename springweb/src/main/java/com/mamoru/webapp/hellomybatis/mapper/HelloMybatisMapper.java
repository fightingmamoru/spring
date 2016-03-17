package com.mamoru.webapp.hellomybatis.mapper;

import java.sql.SQLException;
import java.util.List;

public interface HelloMybatisMapper
{
	public List<String> selectColumns(String tableName) throws SQLException;
}
