package com.polymart.dao.impl;

import com.polymart.dao.IChiTietHoaDonThanhToanDAO;
import com.polymart.mapper.ChiTietHoaDonThanhToanMapper;
import com.polymart.model.ChiTietHoaDonThanhToanModel;

import java.util.List;

public class ChiTietHoaDonThanhToanDAO extends AbstractDAO<ChiTietHoaDonThanhToanModel>
        implements IChiTietHoaDonThanhToanDAO {
    @Override
    public List<ChiTietHoaDonThanhToanModel> findAll() {
        String sql = "SELECT * FROM CHITIETHOADONTHANHTOAN";
        return query(sql, new ChiTietHoaDonThanhToanMapper());
    }

    @Override
    public ChiTietHoaDonThanhToanModel save(ChiTietHoaDonThanhToanModel chiTietHoaDonThanhToanModel) {
        String sql = "INSERT INTO CHITIETHOADONTHANHTOAN (IDHOADONTHANHTOAN, IDCHITIETSANPHAM, SOLUONG, GIAMGIATHEM)\n"
                + "VALUES (?, ?, ?, ?)";
        int id = insert(sql, chiTietHoaDonThanhToanModel.getHoaDonThanhToan(),
                chiTietHoaDonThanhToanModel.getChiTietSanPham(), chiTietHoaDonThanhToanModel.getSoLuong(),
                chiTietHoaDonThanhToanModel.getGiamGiaThem());
        return findOne(id);
    }

    @Override
    public boolean update(ChiTietHoaDonThanhToanModel chiTietHoaDonThanhToanModel) {
        String sql = "UPDATE CHITIETHOADONTHANHTOAN SET IDCHITIETSANPHAM = ?, SOLUONG = ?, GIAMGIATHEM = ? WHERE ID = ?";
        return update(sql, chiTietHoaDonThanhToanModel.getChiTietSanPham(), chiTietHoaDonThanhToanModel.getSoLuong(),
                chiTietHoaDonThanhToanModel.getGiamGiaThem(), chiTietHoaDonThanhToanModel.getId()) > -1;
    }

    private ChiTietHoaDonThanhToanModel findOne(Integer id) {
        String sql = "SELECT * FROM CHITIETHOADONTHANHTOAN WHERE ID = ?";
        List<ChiTietHoaDonThanhToanModel> lstFind = query(sql, new ChiTietHoaDonThanhToanMapper(), id);
        return lstFind.isEmpty() ? null : lstFind.get(0);
    }
}
