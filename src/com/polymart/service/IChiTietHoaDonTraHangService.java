package com.polymart.service;

import com.polymart.model.ChiTietHoaDonTraHangModel;

import java.util.List;

public interface IChiTietHoaDonTraHangService {

    boolean save(ChiTietHoaDonTraHangModel chiTietHoaDonTraHangModel);

    List<ChiTietHoaDonTraHangModel> findByIdHoaDonTraHang(int idHoaDonTraHang);

    void reloadData();
}
