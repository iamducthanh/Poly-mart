package com.polymart.mapper;

import com.polymart.model.ChiTietHoaDonTraHangModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ChiTietHoaDonTraHangMapper implements RowMapper<ChiTietHoaDonTraHangModel> {
	@Override
	public ChiTietHoaDonTraHangModel mapRow(ResultSet rs) {
		try {
			ChiTietHoaDonTraHangModel hoaDonTraHangModel = new ChiTietHoaDonTraHangModel();
			hoaDonTraHangModel.setIdHoaDonTraHang(rs.getInt("IDHOADONTRAHANG"));
			hoaDonTraHangModel.setIdHoaDonThanhToanChiTiet(rs.getInt("IDCHITIETHOADONTHANHTOAN"));
			hoaDonTraHangModel.setSoLuong(rs.getInt("SOLUONG"));
			return hoaDonTraHangModel;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
