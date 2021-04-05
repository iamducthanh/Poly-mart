package com.polymart.dao.impl;

import java.util.List;

import com.polymart.dao.IChiTietSanPhamDAO;
import com.polymart.mapper.ChiTietSanPhamMapper;
import com.polymart.model.ChiTietHoaDonNhapHangModel;
import com.polymart.model.ChiTietHoaDonThanhToanModel;
import com.polymart.model.ChiTietSanPhamModel;

public class ChiTietSanPhamDAO extends AbstractDAO<ChiTietSanPhamModel> implements IChiTietSanPhamDAO {

    @Override
    public List<ChiTietSanPhamModel> findAll() {
        String sql = "SELECT * FROM CHITIETSANPHAM";
        return query(sql, new ChiTietSanPhamMapper());
    }

    @Override
    public List<ChiTietSanPhamModel> findByIdOrNameProduct(String input) {
        String sql = "SELECT CTSP.* FROM CHITIETSANPHAM AS CTSP JOIN SANPHAM AS SP\n" + "ON CTSP.IDSANPHAM = SP.ID\n"
                + "WHERE CTSP.ID LIKE ? OR SP.TEN LIKE ?";
        return query(sql, new ChiTietSanPhamMapper(), "%" + input + "%", "%" + input + "%");
    }

    @Override
    public Integer updateSauKhiXoaHoaDonNhap(ChiTietHoaDonNhapHangModel chiTietHoaDonNhapHangModel) {
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE CHITIETSANPHAM\n");
        sql.append(" SET SOLUONG = SOLUONG - ? WHERE ID = ?");
        return update(sql.toString(), chiTietHoaDonNhapHangModel.getSoLuong(),
                chiTietHoaDonNhapHangModel.getIdChiTietSanPham());
    }

    @Override
    public Integer updateNhapHang(ChiTietHoaDonNhapHangModel chiTietHoaDonNhapHangModel) {
        String sqlUpdate = "UPDATE CHITIETSANPHAM SET GIAVON = ((GIAVON * SOLUONG) + ?) / (SOLUONG + ?),\n"
                + "SOLUONG = SOLUONG + ? WHERE ID = ?";
        return update(sqlUpdate, chiTietHoaDonNhapHangModel.getGiaNhap() * chiTietHoaDonNhapHangModel.getSoLuong(),
                chiTietHoaDonNhapHangModel.getSoLuong(), chiTietHoaDonNhapHangModel.getSoLuong(),
                chiTietHoaDonNhapHangModel.getIdChiTietSanPham());
    }

    @Override
    public Integer updateThanhToan(ChiTietHoaDonThanhToanModel chiTietHoaDonThanhToanModel) {
        String sqlUpdate = "UPDATE CHITIETSANPHAM SET SOLUONG = SOLUONG - ? WHERE ID = ?";
        return update(sqlUpdate, chiTietHoaDonThanhToanModel.getSoLuong(),
                chiTietHoaDonThanhToanModel.getChiTietSanPham());
    }

    @Override
    public Integer updateTraHang(int id, int soLuong) {
        String sqlUpdate = "UPDATE CHITIETSANPHAM SET SOLUONG = SOLUONG + ? WHERE ID = ?";
        return update(sqlUpdate, soLuong, id);
    }
}
