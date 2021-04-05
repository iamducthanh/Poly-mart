package com.polymart.dao.impl;

import com.polymart.dao.IHoaDonTraHangDAO;
import com.polymart.mapper.HoaDonTraHangMapper;
import com.polymart.model.HoaDonTraHangModel;

import java.sql.ResultSet;
import java.util.List;

public class HoaDonTraHangDAO extends AbstractDAO<HoaDonTraHangModel> implements IHoaDonTraHangDAO {

    @Override
    public List<Object[]> getDataTableTraHang() {
        return null;
    }

    @Override
    public List<HoaDonTraHangModel> findAll() {
        String sql = "SELECT * FROM HOADONTRAHANG";
        return query(sql, new HoaDonTraHangMapper());
    }

    @Override
    public int save(HoaDonTraHangModel hoaDonTraHangModel) {
        String sql = "INSERT INTO HOADONTRAHANG (IDNHANVIEN, GHICHU) VALUES (?, ?)";
        return insert(sql, hoaDonTraHangModel.getIdNhanVien(), hoaDonTraHangModel.getGhiChu());
    }

    @Override
    public boolean remove(HoaDonTraHangModel hoaDonTraHangModel) {
        String sql = "EXEC PROC_DELETE_HOADONTRAHANG ?";
        return update(sql, hoaDonTraHangModel.getId()) > -1;
    }

    @Override
    public HoaDonTraHangModel findById(Integer id) {
        String sql = "SELECT * FROM HOADONTRAHANG WHERE ID = ?";
        List<HoaDonTraHangModel> lstTim = query(sql, new HoaDonTraHangMapper(), id);
        return lstTim.isEmpty() ? null : lstTim.get(0);
    }
}
