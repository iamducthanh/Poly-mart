package com.polymart.service;

import java.util.List;

import com.polymart.model.KhachHangModel;

public interface IKhachHangService {
	List<KhachHangModel> findAll();

	KhachHangModel save(KhachHangModel khachHangModel);

	KhachHangModel update(KhachHangModel khachHangModel);

	void delete(Integer[] ids);

	KhachHangModel findOne(Integer id);

	List<KhachHangModel> filter(String nameOrPhone);

}
