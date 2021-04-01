package com.polymart.dao.impl;

import com.polymart.dao.IChiTietSanPhamDAO;
import com.polymart.mapper.ChiTietSanPhamMapper;
import com.polymart.model.ChiTietSanPhamModel;

import java.util.List;

public class ChiTietSanPhamDAO extends AbstractDAO<ChiTietSanPhamModel> implements IChiTietSanPhamDAO {

    @Override
    public List<ChiTietSanPhamModel> findAll() {
        String sql = "SELECT * FROM CHITIETSANPHAM";
        return query(sql, new ChiTietSanPhamMapper());
    }
}
