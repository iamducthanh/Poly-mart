package com.polymart.dao.impl;

import java.util.List;

import com.polymart.dao.INhanVienDAO;
import com.polymart.mapper.NhanVienMapper;
import com.polymart.model.NhanVienModel;

public class NhanVienDAO extends AbstractDAO<NhanVienModel> implements INhanVienDAO {

	@Override
	public List<NhanVienModel> findAll() {
		String sql = "SELECT*FROM NHANVIEN where MATKHAU !=1";
		return query(sql, new NhanVienMapper());
	}
	public List<NhanVienModel> findAllNhanVien() {
		String sql = "SELECT*FROM NHANVIEN ";
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
		StringBuilder sql = new StringBuilder("UPDATE NHANVIEN SET HOTEN = ?,");
		sql.append(" NGAYSINH = ?, GIOITINH = ?, DIACHI = ?, SODIENTHOAI = ?,");
		sql.append(" EMAIL = ?, CHUCVU = ?, MUCLUONG = ?, ANHDAIDIEN = ?, MATKHAU = ?");
		sql.append(" WHERE ID = ?");
		update(sql.toString(), nhanVienModel.getHoTen(), nhanVienModel.getNgaySinh(), nhanVienModel.isGioiTinh(),
				nhanVienModel.getDiaChi(), nhanVienModel.getSdt(), nhanVienModel.getEmail(), nhanVienModel.getChucVu(),
				nhanVienModel.getLuong(), nhanVienModel.getAnhDaiDien(), nhanVienModel.getMatKhau(),
				nhanVienModel.getId());
	}
	public void khoaTaiKhoanNhanVien(String id) {
		String sql = "update NHANVIEN set MATKHAU ='1' where ID =?";
		update(sql,id);
	}
	@Override
	public void delete(Integer id) {
		String sql = "DELETE NHANVIEN WHERE ID = ?";
		update(sql, id);
	}

	@Override
	public NhanVienModel findOne(Integer id) {
		String sql = "SELECT*FROM NHANVIEN WHERE ID = ?";
		List<NhanVienModel> list = query(sql, new NhanVienMapper(), id);
		return list.isEmpty() ? null : list.get(0);
	}

	@Override
	public List<NhanVienModel> filter(String idOrName) {
		String sql = "SELECT*FROM NHANVIEN WHERE MATKHAU !=1 and (ID LIKE ? OR HOTEN LIKE ?) ";
		return query(sql, new NhanVienMapper(), "%" + idOrName + "%", "%" + idOrName + "%");
	}

	@Override
	public List<NhanVienModel> findByIdAndPassword(String id, String password) {
		String sql = "SELECT*FROM NHANVIEN WHERE ID = ? AND MATKHAU = ?";
		return query(sql, new NhanVienMapper(), id, password);
	}

	@Override
	public List<NhanVienModel> filterByChucVu(String chucVu) {
		String sql = "SELECT*FROM NHANVIEN WHERE CHUCVU = ? and MATKHAU !='1'";
		return query(sql, new NhanVienMapper(), chucVu);
	}
}
