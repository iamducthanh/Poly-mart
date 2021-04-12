package com.polymart.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.polymart.model.HoaDonNhapHangModel;

public class HoaDonNhapHangMapper implements RowMapper<HoaDonNhapHangModel> {
	@Override
	public HoaDonNhapHangModel mapRow(ResultSet rs) {
		try {
			HoaDonNhapHangModel hoaDonNhapHangModel = new HoaDonNhapHangModel();
			hoaDonNhapHangModel.setId(rs.getInt("ID"));
			hoaDonNhapHangModel.setIdNhanVienNhap(rs.getInt("IDNHANVIEN"));
			hoaDonNhapHangModel.setIdNguonHang(rs.getInt("IDNGUONHANG"));
			hoaDonNhapHangModel.setNgayNhap(rs.getTimestamp("NGAYNHAP"));
			hoaDonNhapHangModel.setGhiChu(rs.getString("GHICHU"));
			hoaDonNhapHangModel.setRemove(rs.getBoolean("TREMOVE"));
			return hoaDonNhapHangModel;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
