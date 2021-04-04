package com.polymart.mapper;

import com.polymart.model.NguonHangModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class NguonHangMapper implements RowMapper<NguonHangModel> {

	@Override
	public NguonHangModel mapRow(ResultSet rs) {
		try {
			NguonHangModel nguonHang = new NguonHangModel();
			nguonHang.setId(rs.getInt("ID"));
			nguonHang.setTenNguonHang(rs.getString("TEN"));
			nguonHang.setDiaChi(rs.getString("DIACHI"));
			nguonHang.setSdt(rs.getString("SODIENTHOAI"));
			return nguonHang;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
