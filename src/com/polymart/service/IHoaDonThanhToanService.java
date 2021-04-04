package com.polymart.service;

import com.polymart.model.HoaDonThanhToanModel;

public interface IHoaDonThanhToanService {

    HoaDonThanhToanModel save(HoaDonThanhToanModel hoaDonThanhToanModel);

    boolean remove(HoaDonThanhToanModel hoaDonThanhToanModel);

}
