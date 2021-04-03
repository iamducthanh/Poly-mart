package com.polymart.dao.impl;

import com.polymart.dao.IChiTietHoaDonNhapHangDAO;
import com.polymart.model.ChiTietHoaDonNhapHangModel;

import java.util.List;

public class ChiTietHoaDonNhapHangDAO extends AbstractDAO<ChiTietHoaDonNhapHangModel>
        implements IChiTietHoaDonNhapHangDAO {
    @Override
    public boolean save(int id, List<ChiTietHoaDonNhapHangModel> lstChiTietHoaDonNhapHangModels) {
        if (lstChiTietHoaDonNhapHangModels != null && !lstChiTietHoaDonNhapHangModels.isEmpty()) {
            String sqlInsert = "INSERT INTO CHITIETHOADONNHAPHANG (IDHOADONNHAPHANG, IDCHITIETSANPHAM, GIANHAP, SOLUONG)\n"
                    + "VALUES (?, ?, ?, ?)";
            String sqlUpdate = "UPDATE CHITIETSANPHAM SET GIAVON = ((GIAVON * SOLUONG) + ?) / (SOLUONG + ?),\n"
                    + "SOLUONG = SOLUONG + ? WHERE ID = ?";
            int count = 0;
            for (ChiTietHoaDonNhapHangModel x : lstChiTietHoaDonNhapHangModels) {
                int index = insert(sqlInsert, id, x.getIdChiTietSanPham(), x.getGiaNhap(), x.getSoLuong());
                if (index > -1) {
                    System.out.println("gia nhap * so luong " + x.getGiaNhap() * x.getSoLuong());
                    System.out.println("soluong: " + x.getSoLuong());
                    System.out.println("id ctsp: " + x.getIdChiTietSanPham());
                    update(sqlUpdate, x.getGiaNhap() * x.getSoLuong(), x.getSoLuong(), x.getSoLuong(),
                            x.getIdChiTietSanPham());
                    count++;
                }
            }
            return count > 0;
        }
        return false;
    }
}
