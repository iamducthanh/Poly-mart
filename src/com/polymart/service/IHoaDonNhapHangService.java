package com.polymart.service;

import com.polymart.model.HoaDonNhapHangModel;

import java.sql.Timestamp;
import java.util.List;

public interface IHoaDonNhapHangService {

	List<HoaDonNhapHangModel> findAll();

	HoaDonNhapHangModel save(HoaDonNhapHangModel hoaDonNhapHangModel);

	boolean remove(HoaDonNhapHangModel hoaDonNhapHangModel);

	HoaDonNhapHangModel findById(Integer id);

	List<HoaDonNhapHangModel> filterByDate(Timestamp timestamp);

}
