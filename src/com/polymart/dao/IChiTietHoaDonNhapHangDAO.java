package com.polymart.dao;

import com.polymart.model.ChiTietHoaDonNhapHangModel;

import java.util.List;

public interface IChiTietHoaDonNhapHangDAO extends GenericDAO<ChiTietHoaDonNhapHangModel> {

	List<ChiTietHoaDonNhapHangModel> findAll();

	boolean save(ChiTietHoaDonNhapHangModel chiTietHoaDonNhapHangModel);

	List<ChiTietHoaDonNhapHangModel> findByIdHoaDonNhap(Integer idHoaDonNhap);

}
