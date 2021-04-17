package com.polymart.service.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.polymart.dao.impl.AbstractDAO;
import com.polymart.service.IThongKeService;

public class ThongKeService implements IThongKeService{

	@Override
	public ResultSet findYear() {
		String sql = "select distinct year(NGAYTHANHTOAN) as nam from HOADONTHANHTOAN order by nam desc";
		ResultSet rsYear = excute(sql);
		return rsYear;
	}
	
	public ResultSet findMonth() {
		String sql = "select distinct month(NGAYTHANHTOAN) as thang from HOADONTHANHTOAN order by thang desc";
		ResultSet rsYear = excute(sql);
		return rsYear;
	}
	
	public ResultSet loadTableThongKeDoanhThu(String year, String month) {
		String sql = "EXEC THONG_KE_DOANH_THU " + year + ", " + month;
		ResultSet resultSet = excute(sql);
		return resultSet;
	}
	
	public ResultSet loadTableThongKeDoanhSo(String year, String month) {
		String sql = "EXEC THONG_KE_DOANH_SO " + year + ", " + month;
		ResultSet resultSet = excute(sql);
		return resultSet;
	}
	
	public ResultSet excute(String sql) {
		AbstractDAO<String> abstractDAO = new AbstractDAO<String>();
		ResultSet resultSet = null;
		Connection conn = abstractDAO.getConnection();

		try {
			Statement statement = conn.createStatement();
			resultSet = statement.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultSet;
	}

}
