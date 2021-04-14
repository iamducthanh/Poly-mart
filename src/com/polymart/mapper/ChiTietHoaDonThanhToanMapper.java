package com.polymart.mapper;

import com.polymart.model.ChiTietHoaDonThanhToanModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ChiTietHoaDonThanhToanMapper implements RowMapper<ChiTietHoaDonThanhToanModel> {
	@Override
	public ChiTietHoaDonThanhToanModel mapRow(ResultSet rs) {
		try {
			ChiTietHoaDonThanhToanModel hoaDonThanhToanModel = new ChiTietHoaDonThanhToanModel();
			hoaDonThanhToanModel.setId(rs.getInt("ID"));
			hoaDonThanhToanModel.setChiTietSanPham(rs.getInt("IDCHITIETSANPHAM"));
			hoaDonThanhToanModel.setHoaDonThanhToan(rs.getInt("IDHOADONTHANHTOAN"));
			hoaDonThanhToanModel.setSoLuong(rs.getInt("SOLUONG"));
			hoaDonThanhToanModel.setGiamGiaThem(rs.getLong("GIAMGIATHEM"));
			hoaDonThanhToanModel.setTraHang(rs.getInt("TRAHANG"));
			return hoaDonThanhToanModel;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
