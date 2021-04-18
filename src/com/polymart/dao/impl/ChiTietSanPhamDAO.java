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
                + "WHERE CTSP.ID LIKE ? OR SP.TEN LIKE ? AND TRANGTHAI = 1";
        return query(sql, new ChiTietSanPhamMapper(), "%" + input + "%", "%" + input + "%");
    }

    @Override
    public int save(ChiTietSanPhamModel chiTietSanPhamModel) {
        String sql = "INSERT INTO CHITIETSANPHAM (IDSANPHAM, MAUSAC, SIZE, GIABAN)\n" +
                "VALUES (?, ?, ?, ?)";
        return insert(sql, chiTietSanPhamModel.getIdSanPham(), chiTietSanPhamModel.getMauSac(),
                chiTietSanPhamModel.getSize(), chiTietSanPhamModel.getGiaBan());
    }

    @Override
    public boolean updatePrice(int id, Long giaBan, Long giaGiam) {
        String sql = "EXEC PROC_UPDATE_PRICE_PRODUCT ?, ?, ?";
        return update(sql, id, giaBan, giaGiam) > 0;
    }
}
