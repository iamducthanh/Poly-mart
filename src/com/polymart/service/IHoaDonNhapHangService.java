package com.polymart.service;

import com.polymart.model.ChiTietHoaDonNhapHangModel;
import com.polymart.model.HoaDonNhapHangModel;

import java.util.List;

public interface IHoaDonNhapHangService {

    boolean save(HoaDonNhapHangModel hoaDonNhapHangModel,
                 List<ChiTietHoaDonNhapHangModel> lstChiTietHoaDonNhapHangModel);

}
