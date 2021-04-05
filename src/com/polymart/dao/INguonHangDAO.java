package com.polymart.dao;

import com.polymart.model.NguonHangModel;

import java.util.List;

public interface INguonHangDAO extends GenericDAO<NguonHangModel> {

	List<NguonHangModel> findAll();

	Integer save(NguonHangModel nguonHangModel);

	void update(NguonHangModel nguonHangModel);

	void delete(Integer id);

	NguonHangModel findOne(Integer id);

	List<NguonHangModel> fillter(String nameOrPhone);

	String getNameById(Integer id);
}
