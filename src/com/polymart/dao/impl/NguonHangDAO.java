package com.polymart.dao.impl;

import com.polymart.dao.INguonHangDAO;
import com.polymart.mapper.NguonHangMapper;
import com.polymart.model.NguonHangModel;

import java.util.List;

public class NguonHangDAO extends AbstractDAO<NguonHangModel> implements INguonHangDAO {

	@Override
	public List<NguonHangModel> findAll() {
		String sql = "SELECT * FROM NGUONHANG";
		return query(sql, new NguonHangMapper());
	}

	@Override
	public Integer save(NguonHangModel nguonHangModel) {
		StringBuilder sql = new StringBuilder("INSERT INTO NGUONHANG (TEN,");
		sql.append(" SODIENTHOAI, DIACHI)");
		sql.append(" VALUES (?,?,?)");
		return insert(sql.toString(), nguonHangModel.getTenNguonHang(), nguonHangModel.getSdt(),
				nguonHangModel.getDiaChi());
	}

	@Override
	public void update(NguonHangModel nguonHangModel) {
		StringBuilder sql = new StringBuilder("UPDATE NGUONHANG SET TEN = ?,");
		sql.append(" SODIENTHOAI = ?, DIACHI = ?");
		sql.append(" WHERE ID = ?");
		update(sql.toString(), nguonHangModel.getTenNguonHang(), nguonHangModel.getSdt(), nguonHangModel.getDiaChi(),
				nguonHangModel.getId());
	}

	@Override
	public void delete(Integer id) {
		String sql = "DELETE NGUONHANG WHERE ID = ?";
		update(sql, id);
	}

	@Override
	public List<NguonHangModel> fillter(String nameOrPhone) {
		String sql = "SELECT*FROM NGUONHANG WHERE TEN LIKE ? OR SODIENTHOAI LIKE ?";
		return query(sql, new NguonHangMapper(), "%" + nameOrPhone + "%", "%" + nameOrPhone + "%");
	}

	@Override
	public NguonHangModel findOne(Integer id) {
		String sql = "SELECT*FROM NGUONHANG WHERE ID = ?";
		List<NguonHangModel> list = query(sql, new NguonHangMapper(), id);
		return list.isEmpty() ? null : list.get(0);
	}

	@Override
	public String getNameById(Integer id) {
		String sql = "SELECT TEN FROM NGUONHANG WHERE ID = ?";
		List<NguonHangModel> list = query(sql, new NguonHangMapper(), id);
		return list.isEmpty() ? null : list.get(0).getTenNguonHang();
	}
}
