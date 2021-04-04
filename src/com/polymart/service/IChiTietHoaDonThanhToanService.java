package com.polymart.service;

import com.polymart.model.ChiTietHoaDonThanhToanModel;

import java.util.List;

public interface IChiTietHoaDonThanhToanService {

    List<ChiTietHoaDonThanhToanModel> findByIdHoaDonThanhToan(Integer idHoaDonThanhToan);

    boolean save(ChiTietHoaDonThanhToanModel chiTietHoaDonThanhToanModel);

    void reloadData();
}
