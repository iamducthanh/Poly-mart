package com.polymart.mapper;

import com.polymart.model.HoaDonThanhToanModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class HoaDonThanhToanMapper implements RowMapper<HoaDonThanhToanModel> {
	@Override
	public HoaDonThanhToanModel mapRow(ResultSet rs) {
		try {
			HoaDonThanhToanModel hoaDonThanhToanModel = new HoaDonThanhToanModel();
			hoaDonThanhToanModel.setId(rs.getInt("ID"));
			hoaDonThanhToanModel.setIdKhachHang(rs.getInt("IDKHACHHANG"));
			hoaDonThanhToanModel.setIdNhanVien(rs.getInt("IDNHANVIEN"));
			hoaDonThanhToanModel.setDiemDaDoi(rs.getInt("DIEMDADOI"));
			hoaDonThanhToanModel.setNgayThanhToan(rs.getTimestamp("NGAYTHANHTOAN"));
			hoaDonThanhToanModel.setGhiChu(rs.getString("GHICHU"));
			hoaDonThanhToanModel.setRemove(rs.getBoolean("TREMOVE"));
			return hoaDonThanhToanModel;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
