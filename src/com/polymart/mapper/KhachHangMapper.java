package com.polymart.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.polymart.model.KhachHangModel;

public class KhachHangMapper implements RowMapper<KhachHangModel> {

	@Override
	public KhachHangModel mapRow(ResultSet rs) {
		try {
			KhachHangModel khachHang = new KhachHangModel();
			khachHang.setId(rs.getInt("ID"));
			khachHang.setHoTen(rs.getString("HOTEN"));
			khachHang.setSdt(rs.getString("SODIENTHOAI"));
			khachHang.setDiaChi(rs.getString("DIACHI"));
			khachHang.setTichDiem(rs.getInt("TICHDIEM"));
			return khachHang;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
