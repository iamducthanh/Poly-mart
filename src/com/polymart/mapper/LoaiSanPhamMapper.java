package com.polymart.mapper;

import com.polymart.model.LoaiSanPhamModel;
import com.polymart.model.NguonHangModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LoaiSanPhamMapper implements RowMapper<LoaiSanPhamModel> {
    @Override
    public LoaiSanPhamModel mapRow(ResultSet rs) {
        try {
            LoaiSanPhamModel loaiSanPhamModel = new LoaiSanPhamModel();
            loaiSanPhamModel.setId(rs.getInt("ID"));
            loaiSanPhamModel.setTenLoaiSP(rs.getString("TEN"));
            return loaiSanPhamModel;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
