package com.polymart.dao;

import java.sql.ResultSet;
import java.util.List;

import com.polymart.mapper.RowMapper;

public interface GenericDAO<T> {
	<T> List<T> query(String sql, RowMapper<T> rowMapper, Object... parameters);

	Integer update(String sql, Object... parameters);

	// insert câu lệnh sql với tham số truyền vào parameters, trả về mã id
	Integer insert(String sql, Object... parameters);
	
	ResultSet queryBySql(String sql, Object... parameters);
	
}
