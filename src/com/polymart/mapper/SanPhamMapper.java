package com.polymart.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.polymart.model.SanPhamModel;

public class SanPhamMapper implements RowMapper<SanPhamModel> {

	@Override
	public SanPhamModel mapRow(ResultSet rs) {
		try {
			SanPhamModel sanPham = new SanPhamModel();
			sanPham.setId(rs.getLong("ID"));
			sanPham.setIdLoaiSP(rs.getInt(""));
			return sanPham;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
