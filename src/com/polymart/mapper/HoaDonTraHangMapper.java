package com.polymart.mapper;

import com.polymart.model.HoaDonTraHangModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class HoaDonTraHangMapper implements RowMapper<HoaDonTraHangModel> {
	@Override
	public HoaDonTraHangModel mapRow(ResultSet rs) {
		try {
			HoaDonTraHangModel hoaDonTraHangModel = new HoaDonTraHangModel();
			hoaDonTraHangModel.setId(rs.getInt("ID"));
			hoaDonTraHangModel.setIdNhanVien(rs.getInt("IDNHANVIEN"));
			hoaDonTraHangModel.setNgayTraHang(rs.getTimestamp("NGAYTRAHANG"));
			hoaDonTraHangModel.setGhiChu(rs.getString("GHICHU"));
			hoaDonTraHangModel.setRemove(rs.getBoolean("TREMOVE"));
			return hoaDonTraHangModel;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
