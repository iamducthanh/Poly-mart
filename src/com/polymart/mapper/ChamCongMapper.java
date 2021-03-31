package com.polymart.mapper;

import com.polymart.model.ChamCongModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ChamCongMapper implements RowMapper<ChamCongModel> {
    @Override
    public ChamCongModel mapRow(ResultSet rs) {
        try {
            ChamCongModel chamCongModel = new ChamCongModel();
            chamCongModel.setIdNhanVien(rs.getInt("IDNHANVIEN"));
            chamCongModel.setNgayChamCong(rs.getTimestamp("NGAYCHAMCONG"));
            return chamCongModel;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
