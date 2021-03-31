package com.polymart.dao.impl;

import com.polymart.dao.IChiTietSanPhamDAO;
import com.polymart.mapper.NguonHangMapper;
import com.polymart.model.ChiTietSanPhamModel;
import com.polymart.model.NguonHangModel;

import java.util.List;

public class ChiTietSanPhamDAO extends AbstractDAO<ChiTietSanPhamModel> implements IChiTietSanPhamDAO {

    @Override
    public List<ChiTietSanPhamModel> findAll() {
        String sql = "SELECT * FROM NGUONHANG";
        return query(sql, new NguonHangMapper());
    }

}
