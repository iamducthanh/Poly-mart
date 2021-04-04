package com.polymart.service;

import com.polymart.model.HoaDonThanhToanModel;

import java.sql.Timestamp;
import java.util.List;

public interface IHoaDonThanhToanService {

	List<HoaDonThanhToanModel> findAll();

	HoaDonThanhToanModel findById(int id);

	HoaDonThanhToanModel save(HoaDonThanhToanModel hoaDonThanhToanModel);

	boolean remove(HoaDonThanhToanModel hoaDonThanhToanModel);

	List<HoaDonThanhToanModel> filterByDate(Timestamp timestamp);

}
