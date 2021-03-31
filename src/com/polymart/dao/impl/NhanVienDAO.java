package com.polymart.dao.impl;

import java.util.List;

import com.polymart.dao.INhanVienDAO;
import com.polymart.mapper.NhanVienMapper;
import com.polymart.model.NhanVienModel;

public class NhanVienDAO extends AbstractDAO<NhanVienModel> implements INhanVienDAO {

	@Override
	public List<NhanVienModel> findAll() {
		String sql = "SELECT*FROM NHANVIEN";
		return query(sql, new NhanVienMapper());
	}

	@Override
	public Integer save(NhanVienModel nhanVienModel) {
		StringBuilder sql = new StringBuilder("INSERT INTO NHANVIEN (HOTEN, ");
		sql.append("NGAYSINH, GIOITINH, DIACHI, SODIENTHOAI, EMAIL, CHUCVU, ");
		sql.append("MUCLUONG, ANHDAIDIEN, MATKHAU) ");
		sql.append("VALUES (?,?,?,?,?,?,?,?,?,?)");
		return insert(sql.toString(), nhanVienModel.getHoTen(), nhanVienModel.getNgaySinh(), nhanVienModel.isGioiTinh(),
				nhanVienModel.getDiaChi(), nhanVienModel.getSdt(), nhanVienModel.getEmail(), nhanVienModel.getChucVu(),
				nhanVienModel.getLuong(), nhanVienModel.getAnhDaiDien(), nhanVienModel.getMatKhau());
	}

	@Override
	public void update(NhanVienModel nhanVienModel) {
		StringBuilder sql = new StringBuilder("UPDATE NHANVIEN SET HOTEN = ?, ");
		sql.append("NGAYSINH = ?, GIOITINH = ?, DIACHI = ?, SODIENTHOAI = ?, ");
		sql.append("EMAIL = ?, CHUCVU = ?, MUCLUONG = ?, ANHDAIDIEN = ?, MATKHAU = ?");
		sql.append("WHERE ID = ?");
		update(sql.toString(), nhanVienModel.getHoTen(), nhanVienModel.getNgaySinh(), nhanVienModel.isGioiTinh(),
				nhanVienModel.getDiaChi(), nhanVienModel.getSdt(), nhanVienModel.getEmail(), nhanVienModel.getChucVu(),
				nhanVienModel.getLuong(), nhanVienModel.getAnhDaiDien(), nhanVienModel.getMatKhau(),
				nhanVienModel.getId());
	}

	@Override
	public void delete(Integer id) {
		String sql = "DELETE NHANVIEN WHERE ID = ?";
		update(sql, id);
	}

	@Override
	public NhanVienModel findOne(Integer id) {
		String sql = "SELECT*FROM NHANVIEN WHERE ID = ?";
		List<NhanVienModel> listNhanVien = query(sql, new NhanVienMapper(), id);
		return listNhanVien.isEmpty() ? null : listNhanVien.get(0);
	}
}
