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

    @Override
    public List<ChiTietSanPhamModel> findByIdOrNameProduct(String input) {
        String sql = "SELECT CTSP.* FROM CHITIETSANPHAM AS CTSP JOIN SANPHAM AS SP\n" +
                "ON CTSP.IDSANPHAM = SP.ID\n" +
                "WHERE CTSP.ID LIKE ? OR SP.TEN LIKE ?";
        return query(sql, new ChiTietSanPhamMapper(), "%" + input + "%", "%" + input + "%");
    }
}
