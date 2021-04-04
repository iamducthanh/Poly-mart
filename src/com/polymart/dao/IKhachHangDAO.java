package com.polymart.dao;

import java.util.List;

import com.polymart.model.KhachHangModel;

public interface IKhachHangDAO extends GenericDAO<KhachHangModel> {

	List<KhachHangModel> findAll();

	Integer save(KhachHangModel khachHangModel);

	void update(KhachHangModel khachHangModel);

	void delete(Integer id);

	KhachHangModel findOne(Integer id);

	List<KhachHangModel> filter(String nameOrPhone);

}
