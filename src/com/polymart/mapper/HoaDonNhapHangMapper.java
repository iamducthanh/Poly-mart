package com.polymart.mapper;

import com.polymart.model.HoaDonNhapHangModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class HoaDonNhapHangMapper implements RowMapper<HoaDonNhapHangModel> {
    @Override
    public HoaDonNhapHangModel mapRow(ResultSet rs) {
        try {
            HoaDonNhapHangModel hoaDonNhapHangModel = new HoaDonNhapHangModel();
            hoaDonNhapHangModel.setId(rs.getInt("ID"));
            hoaDonNhapHangModel.setIdNhanVienNhap(rs.getInt("ID"));
            hoaDonNhapHangModel.setIdNguonHang(rs.getInt("ID"));
            hoaDonNhapHangModel.setNgayNhap(rs.getTimestamp("NGAYNHAP"));
            hoaDonNhapHangModel.setGhiChu(rs.getString("GHICHU"));
            return hoaDonNhapHangModel;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
