package com.polymart.service;

import com.polymart.model.ChiTietHoaDonNhapHangModel;

import java.util.List;

public interface IChiTietHoaDonNhapHangService {

	List<ChiTietHoaDonNhapHangModel> findByIdHoaDonNhap(Integer idHoaDonNhap);

	boolean save(ChiTietHoaDonNhapHangModel chiTietHoaDonNhapHangModel);

	void reloadData();

}
