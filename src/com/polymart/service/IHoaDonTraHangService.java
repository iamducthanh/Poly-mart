package com.polymart.service;

import com.polymart.model.HoaDonTraHangModel;

import java.sql.Timestamp;
import java.util.List;

public interface IHoaDonTraHangService {

    Object[] getDataTableById(Integer id);

    List<HoaDonTraHangModel> findAll();

    HoaDonTraHangModel save(HoaDonTraHangModel hoaDonTraHangModel);

    boolean remove(HoaDonTraHangModel hoaDonTraHangModel);

    HoaDonTraHangModel findById(int id);

    List<HoaDonTraHangModel> filterByDate(Timestamp timestamp);

}
