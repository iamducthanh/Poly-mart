package com.polymart.dao.impl;

import com.polymart.dao.IHoaDonNhapHangDAO;
import com.polymart.mapper.HoaDonNhapHangMapper;
import com.polymart.mapper.NhanVienMapper;
import com.polymart.model.HoaDonNhapHangModel;
import com.polymart.model.NhanVienModel;

import java.util.List;

public class HoaDonNhapHangDAO extends AbstractDAO<HoaDonNhapHangModel> implements IHoaDonNhapHangDAO {

    @Override
    public Integer save(HoaDonNhapHangModel hoaDonNhapHangModel) {
        String sql = "INSERT INTO HOADONNHAPHANG (IDNHANVIEN, IDNGUONHANG, GHICHU)\n" +
                "VALUES (?, ?, ?)";
        int id = insert(sql, hoaDonNhapHangModel.getIdNhanVienNhap(),
                hoaDonNhapHangModel.getIdNguonHang(), hoaDonNhapHangModel.getGhiChu());
        return id;
    }

}
