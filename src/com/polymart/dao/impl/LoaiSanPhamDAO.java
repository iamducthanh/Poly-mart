package com.polymart.dao.impl;

import com.polymart.dao.ILoaiSanPhamDAO;
import com.polymart.mapper.LoaiSanPhamMapper;
import com.polymart.model.LoaiSanPhamModel;

import java.util.List;

public class LoaiSanPhamDAO extends AbstractDAO<LoaiSanPhamModel> implements ILoaiSanPhamDAO {

	@Override
	public List<LoaiSanPhamModel> findAll() {
		String sql = "SELECT * FROM LOAISANPHAM";
		return query(sql, new LoaiSanPhamMapper());
	}
}
