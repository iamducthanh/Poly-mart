package com.polymart.dao.impl;

import java.util.List;

import com.polymart.dao.INhanVienDAO;
import com.polymart.mapper.NhanVienMapper;
import com.polymart.model.NhanVienModel;

public class NhanVienDAO extends AbstractDAO<NhanVienModel> implements INhanVienDAO{

	@Override
	public List<NhanVienModel> findAll() {
		String sql = "SELECT*FROM NHANVIEN";
		return query(sql, new NhanVienMapper());
	}

	@Override
	public Integer save(NhanVienModel nhanVienModel) {
		StringBuilder sql = new StringBuilder("INSERT INTO NHANVIEN (HOTEN, NGAYSINH, GIOITINH, DIACHI, SODIENTHOAI, EMAIL, CHUCVU, MUCLUONG, ANHDAIDIEN, MATKHAU) ");
		sql.append("VALUES (?,?,?,?,?,?,?,?,?,?)");
		return insert(sql.toString(), nhanVienModel.getHoTen(), nhanVienModel.getNgaySinh(), nhanVienModel.isGioiTinh(), nhanVienModel.getDiaChi(), nhanVienModel.getSdt(), nhanVienModel.getEmail(), nhanVienModel.getChucVu(), nhanVienModel.getLuong(), nhanVienModel.getAnhDaiDien(), nhanVienModel.getMatKhau());
	}
}
