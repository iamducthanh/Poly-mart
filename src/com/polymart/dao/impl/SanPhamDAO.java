package com.polymart.dao.impl;

import com.polymart.dao.ISanPhamDAO;
import com.polymart.mapper.SanPhamMapper;
import com.polymart.model.SanPhamModel;

import java.util.List;

public class SanPhamDAO extends AbstractDAO<SanPhamModel> implements ISanPhamDAO {
    @Override
    public List<SanPhamModel> findAll() {
        String sql = "SELECT * FROM SANPHAM";
        return query(sql, new SanPhamMapper());
    }
}
