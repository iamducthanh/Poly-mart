package com.polymart.mapper;

import com.polymart.model.AnhSanPhamModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AnhSanPhamMapper implements RowMapper<AnhSanPhamModel> {
	@Override
	public AnhSanPhamModel mapRow(ResultSet rs) {
		try {
			AnhSanPhamModel anhSanPhamModel = new AnhSanPhamModel();
			anhSanPhamModel.setIdSanPham(rs.getInt("IDCHITIETSANPHAM"));
			anhSanPhamModel.setTenAnh(rs.getString("TENANH"));
			return anhSanPhamModel;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
