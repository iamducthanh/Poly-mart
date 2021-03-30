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
}
