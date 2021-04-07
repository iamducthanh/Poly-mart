package com.polymart.dao;

import java.util.List;

import com.polymart.model.ChiTieuModel;

public interface IChiTieuDAO  {
	List<ChiTieuModel> findAll();
	void save(ChiTieuModel chiTieuModel);
	List<ChiTieuModel> findTheoNgay(int nam , int thang, int ngay);
	
}
