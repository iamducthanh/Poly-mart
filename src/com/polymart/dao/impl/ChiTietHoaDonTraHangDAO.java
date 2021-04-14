package com.polymart.dao.impl;

import com.polymart.dao.IChiTietHoaDonTraHangDAO;
import com.polymart.mapper.ChiTietHoaDonTraHangMapper;
import com.polymart.model.ChiTietHoaDonTraHangModel;

import java.util.List;

public class ChiTietHoaDonTraHangDAO extends AbstractDAO<ChiTietHoaDonTraHangModel>
        implements IChiTietHoaDonTraHangDAO {
    @Override
    public List<ChiTietHoaDonTraHangModel> findAll() {
        String sql = "SELECT * FROM CHITIETHOADONTRAHANG JOIN HOADONTRAHANG\n" +
                "ON HOADONTRAHANG.ID = CHITIETHOADONTRAHANG.IDHOADONTRAHANG\n" +
                "WHERE HOADONTRAHANG.TREMOVE = 1";
        return query(sql, new ChiTietHoaDonTraHangMapper());
    }

    @Override
    public boolean save(ChiTietHoaDonTraHangModel chiTietHoaDonTraHangModel) {
        String sql = "EXEC PROC_INSERT_CTHOADONTRAHANG ?, ?, ?";
        return update(sql, chiTietHoaDonTraHangModel.getIdHoaDonTraHang(),
                chiTietHoaDonTraHangModel.getIdHoaDonThanhToanChiTiet(), chiTietHoaDonTraHangModel.getSoLuong()) > 0;
    }
}
