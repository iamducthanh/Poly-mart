package com.polymart.service;

import java.util.List;

import com.polymart.model.NguonHangModel;

public interface INguonHangService {

	List<NguonHangModel> findAll();

	NguonHangModel save(NguonHangModel nguonHangModel);

	NguonHangModel update(NguonHangModel nguonHangModel);

	void delete(Integer[] ids);

	NguonHangModel findOne(Integer id);

	List<NguonHangModel> fillter(String nameOrPhone);

	String getNameById(Integer id);

}
