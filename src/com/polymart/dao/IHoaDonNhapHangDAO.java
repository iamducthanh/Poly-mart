package com.polymart.dao;

import com.polymart.model.HoaDonNhapHangModel;

import java.util.List;

public interface IHoaDonNhapHangDAO extends GenericDAO<HoaDonNhapHangModel> {

	List<HoaDonNhapHangModel> findAll();

	Integer save(HoaDonNhapHangModel hoaDonNhapHangModel);

	Integer remove(HoaDonNhapHangModel hoaDonNhapHangMode);

	HoaDonNhapHangModel findById(Integer id);
}
