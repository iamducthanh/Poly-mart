package com.polymart.service;

import com.polymart.model.ChiTietHoaDonNhapHangModel;
import com.polymart.model.HoaDonNhapHangModel;

import java.util.List;

public interface IHoaDonNhapHangService {

    List<HoaDonNhapHangModel> findAll();

    boolean save(HoaDonNhapHangModel hoaDonNhapHangModel,
                 List<ChiTietHoaDonNhapHangModel> lstChiTietHoaDonNhapHangModel);

    boolean remove(HoaDonNhapHangModel hoaDonNhapHangModel);

    HoaDonNhapHangModel findById(Integer id);

}
