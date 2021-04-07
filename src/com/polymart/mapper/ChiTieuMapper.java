package com.polymart.mapper;

import com.polymart.model.ChiTieuModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ChiTieuMapper implements RowMapper<ChiTieuModel> {


    @Override
    public ChiTieuModel mapRow(ResultSet rs) {
        try {
            ChiTieuModel chiTieuModel=new ChiTieuModel();
            chiTieuModel.setMaCT(rs.getInt("MACT"));
            chiTieuModel.setHoTen(rs.getString("HoTen"));
            chiTieuModel.setMucDichChiTieu(rs.getString("MUCDICHCHITIEU"));
            chiTieuModel.setSoTien(rs.getLong("SOTIEN"));
            chiTieuModel.setSoTien(rs.getLong("SOTIEN"));
            chiTieuModel.setNgayChiTieu(rs.getTimestamp("NGAYCHITIEU"));
            chiTieuModel.setGhiChu(rs.getString("GHICHU"));
            return chiTieuModel;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}
