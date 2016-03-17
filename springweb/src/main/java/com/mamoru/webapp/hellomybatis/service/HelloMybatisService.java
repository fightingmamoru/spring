package com.mamoru.webapp.hellomybatis.service;

import java.sql.SQLException;
import java.util.List;

public interface HelloMybatisService
{
	// 사용자 테이블의 컬럼정보 조회
	public List<String> getColumns(String tableName) throws SQLException;
}
