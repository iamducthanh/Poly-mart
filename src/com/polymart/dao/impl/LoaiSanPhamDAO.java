package com.polymart.dao.impl;

import com.polymart.dao.ILoaiSanPhamDAO;
import com.polymart.mapper.LoaiSanPhamMapper;
import com.polymart.mapper.NguonHangMapper;
import com.polymart.model.LoaiSanPhamModel;
import com.polymart.model.NguonHangModel;

import java.util.List;

public class LoaiSanPhamDAO extends AbstractDAO<LoaiSanPhamModel> implements ILoaiSanPhamDAO {

    @Override
    public List<LoaiSanPhamModel> findAll() {
        String sql = "SELECT * FROM LOAISANPHAM";
        return query(sql, new LoaiSanPhamMapper());
    }

    public Integer save(LoaiSanPhamModel loaiSpModel) {
        StringBuilder sql = new StringBuilder("INSERT INTO LOAISANPHAM (TEN) VALUES (?)");
        return insert(sql.toString(), loaiSpModel.getTenLoaiSP());
    }

    public void update(LoaiSanPhamModel loaispModel) {
        StringBuilder sql = new StringBuilder("UPDATE LOAISANPHAM SET TEN = ?");
        sql.append(" WHERE ID = ?");
        update(sql.toString(), loaispModel.getTenLoaiSP(), loaispModel.getId());
    }

}
