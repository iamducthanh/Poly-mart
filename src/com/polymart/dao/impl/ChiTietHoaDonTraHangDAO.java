package com.polymart.dao.impl;

import com.polymart.dao.IChiTietHoaDonTraHangDAO;
import com.polymart.model.ChiTietHoaDonTraHangModel;

public class ChiTietHoaDonTraHangDAO extends AbstractDAO<ChiTietHoaDonTraHangModel>
        implements IChiTietHoaDonTraHangDAO {
    @Override
    public boolean save(ChiTietHoaDonTraHangModel chiTietHoaDonTraHangModel) {
        String sql = "INSERT INTO CHITIETHOADONTRAHANG (IDHOADONTRAHANG, IDCHITIETHOADONTHANHTOAN, SOLUONG)\n" +
                "VALUES (?, ?, ?)";
        return insert(sql, chiTietHoaDonTraHangModel.getIdHoaDonTraHang(),
                chiTietHoaDonTraHangModel.getIdHoaDonThanhToanChiTiet(), chiTietHoaDonTraHangModel.getSoLuong()) > -1;
    }
}
