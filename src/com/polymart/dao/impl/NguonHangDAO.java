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
	public List<NguonHangModel> findByName(String name) {
		String sql = "SELECT * FROM NGUONHANG WHERE ten LIKE ?";
		String nameSQL = "N'%" + name + "%'";
		System.out.println(nameSQL);
		return query(sql, new NguonHangMapper(), nameSQL);
	}
}
