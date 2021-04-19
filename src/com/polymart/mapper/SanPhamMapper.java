package com.polymart.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.polymart.model.SanPhamModel;

public class SanPhamMapper implements RowMapper<SanPhamModel> {

    @Override
    public SanPhamModel mapRow(ResultSet rs) {
        try {
            SanPhamModel sanPham = new SanPhamModel();
            sanPham.setId(rs.getInt("ID"));
            sanPham.setIdLoaiSP(rs.getInt("IDLOAISANPHAM"));
            sanPham.setTenSP(rs.getString("TEN"));
            sanPham.setMoTa(rs.getString("MOTA"));
            sanPham.setStatusKinhDoanh(rs.getBoolean("TRANGTHAIKINHDOANH"));
            return sanPham;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}
