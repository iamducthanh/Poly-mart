package com.polymart.dao;

import java.util.List;

import com.polymart.model.ChiTieuModel;

public interface IChiTieuDAO extends GenericDAO<ChiTieuModel> {
	List<ChiTieuModel> findAll();
	boolean save(ChiTieuModel chiTieuModel);
	
}
