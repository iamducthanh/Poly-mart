package com.polymart.dao;

import java.util.List;

import com.polymart.model.ChamCongModel;

public interface IChamCongDAO {
	List<ChamCongModel> findAll();

	Integer save(ChamCongModel chamCongModel);

	List<ChamCongModel> filterDay(String a, String b, String c);

	List<ChamCongModel> filterMonth(String a, String b);

	void delete(Integer id, String nam, String thang, String ngay);

}
