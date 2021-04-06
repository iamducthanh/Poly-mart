package com.polymart.dao.impl;

import com.polymart.dao.IChiTietHoaDonTraHangDAO;
import com.polymart.mapper.ChiTietHoaDonTraHangMapper;
import com.polymart.model.ChiTietHoaDonTraHangModel;

import java.util.List;

public class ChiTietHoaDonTraHangDAO extends AbstractDAO<ChiTietHoaDonTraHangModel>
        implements IChiTietHoaDonTraHangDAO {
    @Override
    public List<ChiTietHoaDonTraHangModel> findAll() {
        String sql = "SELECT * FROM CHITIETHOADONTRAHANG";
        return query(sql, new ChiTietHoaDonTraHangMapper());
    }

    @Override
    public boolean save(ChiTietHoaDonTraHangModel chiTietHoaDonTraHangModel) {
        String sql = "INSERT INTO CHITIETHOADONTRAHANG (IDHOADONTRAHANG, IDCHITIETHOADONTHANHTOAN, SOLUONG)\n" +
                "VALUES (?, ?, ?)";
        return insert(sql, chiTietHoaDonTraHangModel.getIdHoaDonTraHang(),
                chiTietHoaDonTraHangModel.getIdHoaDonThanhToanChiTiet(), chiTietHoaDonTraHangModel.getSoLuong()) > -1;
    }
}
