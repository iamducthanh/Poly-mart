package com.polymart.service;

import com.polymart.model.ChiTietHoaDonNhapHangModel;
import com.polymart.model.ChiTietHoaDonThanhToanModel;
import com.polymart.model.ChiTietSanPhamModel;

import java.util.List;

public interface IChiTietSanPhamService {

	List<ChiTietSanPhamModel> findAll();

	List<ChiTietSanPhamModel> findByIdOrNameProduct(String input);

	void updateNhapHang(ChiTietHoaDonNhapHangModel chiTietHoaDonNhapHangModel);

	void updateThanhToan(ChiTietHoaDonThanhToanModel chiTietHoaDonThanhToanModel);

	Integer getIdProductById(Integer id);

	void reloadData();

	ChiTietSanPhamModel getById(Integer id);

}
