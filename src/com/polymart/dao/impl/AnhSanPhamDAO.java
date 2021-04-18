package com.polymart.dao.impl;

import com.polymart.dao.IAnhSanPhamDAO;
import com.polymart.mapper.AnhSanPhamMapper;
import com.polymart.model.AnhSanPhamModel;

import java.util.List;

public class AnhSanPhamDAO extends AbstractDAO<AnhSanPhamModel> implements IAnhSanPhamDAO {
    @Override
    public List<AnhSanPhamModel> findAll() {
        String sql = "SELECT ANHSANPHAM.*, CHITIETSANPHAM.IDSANPHAM FROM ANHSANPHAM JOIN CHITIETSANPHAM" +
                " ON ANHSANPHAM.IDCHITIETSANPHAM = CHITIETSANPHAM.ID";
        return query(sql, new AnhSanPhamMapper());
    }

    @Override
    public boolean save(AnhSanPhamModel anhSanPhamModel) {
        String sql = "INSERT INTO ANHSANPHAM (IDCHITIETSANPHAM, TENANH)\n" +
                "VALUES (?, ?)";
        return insert(sql, anhSanPhamModel.getIdChiTietSanPham(), anhSanPhamModel.getTenAnh()) > -1;
    }
}
