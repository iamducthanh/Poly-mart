package com.polymart.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.polymart.model.NhanVienModel;

public class NhanVienMapper implements RowMapper<NhanVienModel> {

	@Override
	public NhanVienModel mapRow(ResultSet rs) {
		try {
			NhanVienModel nhanVien = new NhanVienModel();
			nhanVien.setId(rs.getInt("ID"));
			nhanVien.setHoTen(rs.getString("HOTEN"));
			nhanVien.setNgaySinh(rs.getDate("NGAYSINH"));
			nhanVien.setGioiTinh(rs.getBoolean("GIOITINH"));
			nhanVien.setDiaChi(rs.getString("DIACHI"));
			nhanVien.setSdt(rs.getString("SODIENTHOAI"));
			nhanVien.setEmail(rs.getString("EMAIL"));
			nhanVien.setChucVu(rs.getString("CHUCVU"));
			nhanVien.setLuong(rs.getLong("MUCLUONG"));
			nhanVien.setAnhDaiDien(rs.getString("ANHDAIDIEN"));
			nhanVien.setMatKhau(rs.getString("MATKHAU"));
			return nhanVien;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
