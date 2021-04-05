package com.polymart.mapper;

import com.polymart.model.ChiTietSanPhamModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ChiTietSanPhamMapper implements RowMapper<ChiTietSanPhamModel> {
	@Override
	public ChiTietSanPhamModel mapRow(ResultSet rs) {
		try {
			ChiTietSanPhamModel chiTietSanPhamModel = new ChiTietSanPhamModel();
			chiTietSanPhamModel.setId(rs.getInt("ID"));
			chiTietSanPhamModel.setIdSanPham(rs.getInt("IDSANPHAM"));
			chiTietSanPhamModel.setMauSac(rs.getString("MAUSAC"));
			chiTietSanPhamModel.setSize(rs.getString("SIZE"));
			chiTietSanPhamModel.setSoLuong(rs.getInt("SOLUONG"));
			chiTietSanPhamModel.setGiaBan(rs.getLong("GIABAN"));
			chiTietSanPhamModel.setGiaVon(rs.getLong("GIAVON"));
			chiTietSanPhamModel.setGiaGiam(rs.getLong("GIAGIAM"));
			chiTietSanPhamModel.setNgayCapNhat(rs.getTimestamp("NGAYCAPNHAT"));
			chiTietSanPhamModel.setStatus(rs.getBoolean("TRANGTHAI"));
			return chiTietSanPhamModel;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
