package com.polymart.dao;

import com.polymart.model.ChiTietHoaDonNhapHangModel;
import com.polymart.model.ChiTietHoaDonThanhToanModel;
import com.polymart.model.ChiTietSanPhamModel;

import java.util.List;

public interface IChiTietSanPhamDAO extends GenericDAO<ChiTietSanPhamModel> {
    List<ChiTietSanPhamModel> findAll();

    List<ChiTietSanPhamModel> findByIdOrNameProduct(String input);
}
