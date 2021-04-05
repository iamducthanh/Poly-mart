package com.polymart.service;

import com.polymart.model.HoaDonTraHangModel;

import java.util.List;

public interface IHoaDonTraHangService {

    Object[] getDataTableById(Integer id);

    List<HoaDonTraHangModel> findAll();

    HoaDonTraHangModel save(HoaDonTraHangModel hoaDonTraHangModel);

    boolean remove(HoaDonTraHangModel hoaDonTraHangModel);

}
