package com.polymart.mapper;

import com.polymart.model.ChiTietHoaDonNhapHangModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ChiTietHoaDonNhapHangMapper implements RowMapper<ChiTietHoaDonNhapHangModel> {
	@Override
	public ChiTietHoaDonNhapHangModel mapRow(ResultSet rs) {
		try {
			ChiTietHoaDonNhapHangModel hoaDonNhapHangModel = new ChiTietHoaDonNhapHangModel();
			hoaDonNhapHangModel.setIdHoaDonNhapHang(rs.getInt("IDHOADONNHAPHANG"));
			hoaDonNhapHangModel.setIdChiTietSanPham(rs.getInt("IDCHITIETSANPHAM"));
			hoaDonNhapHangModel.setGiaNhap(rs.getLong("GIANHAP"));
			hoaDonNhapHangModel.setSoLuong(rs.getInt("SOLUONG"));
			return hoaDonNhapHangModel;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
