package com.polymart.service;

import com.polymart.model.HoaDonThanhToanModel;

import java.util.List;

public interface IHoaDonThanhToanService {

	List<HoaDonThanhToanModel> findAll();

	HoaDonThanhToanModel save(HoaDonThanhToanModel hoaDonThanhToanModel);

	boolean remove(HoaDonThanhToanModel hoaDonThanhToanModel);

}
