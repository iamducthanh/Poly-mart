package com.polymart.dao.impl;

import java.util.List;

import com.polymart.dao.IKhachHangDAO;
import com.polymart.mapper.KhachHangMapper;
import com.polymart.model.KhachHangModel;

public class KhachHangDAO extends AbstractDAO<KhachHangModel> implements IKhachHangDAO {
	@Override
	public List<KhachHangModel> findAll() {
		String sql = "SELECT * FROM KHACHHANG";
		return query(sql, new KhachHangMapper());
	}

	@Override
	public Integer save(KhachHangModel khachHangModel) {
		StringBuilder sql = new StringBuilder("INSERT INTO KHACHHANG (HOTEN,");
		sql.append(" SODIENTHOAI, DIACHI, TICHDIEM)");
		sql.append(" VALUES (?,?,?,?)");
		return insert(sql.toString(), khachHangModel.getHoTen(), khachHangModel.getSdt(), khachHangModel.getDiaChi(),
				khachHangModel.getTichDiem());
	}

	@Override
	public void update(KhachHangModel khachHangModel) {
		StringBuilder sql = new StringBuilder("UPDATE KHACHHANG SET HOTEN = ?,");
		sql.append(" SODIENTHOAI = ?, DIACHI = ?, TICHDIEM = ?");
		sql.append(" WHERE ID = ?");
		update(sql.toString(), khachHangModel.getHoTen(), khachHangModel.getSdt(), khachHangModel.getDiaChi(),
				khachHangModel.getTichDiem(), khachHangModel.getId());
	}

	
	@Override
	public void delete(Integer id) {
		String sql = "DELETE KHACHHANG WHERE ID = ?";
		update(sql, id);
	}

	@Override
	public KhachHangModel findOne(Integer id) {
		String sql = "SELECT*FROM KHACHHANG WHERE ID = ?";
		List<KhachHangModel> list = query(sql, new KhachHangMapper(), id);
		return list.isEmpty() ? null : list.get(0);
	}

	@Override
	public List<KhachHangModel> filter(String nameOrPhone) {
		String sql = "SELECT*FROM KHACHHANG WHERE HOTEN LIKE ? OR SODIENTHOAI LIKE ?";
		return query(sql, new KhachHangMapper(), "%" + nameOrPhone + "%", "%" + nameOrPhone + "%");
	}

//	public static void main(String[] args) {
//		IKhachHangService nv = new KhachHangService();
//		List<KhachHangModel> list = nv.filter("a");
//		if (list.isEmpty()) {
//			System.out.println("empty");
//		} else {
//			list.forEach(e -> System.out.println(e.getHoTen()));
//		}
//	}
}
