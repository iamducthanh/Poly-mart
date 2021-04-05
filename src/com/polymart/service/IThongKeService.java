package com.polymart.service;

import java.sql.ResultSet;

public interface IThongKeService {
	
	ResultSet findYear();
	
	ResultSet loadTableThongKeDoanhThu(String year, String month);
	
	ResultSet excute(String sql);
	
}
