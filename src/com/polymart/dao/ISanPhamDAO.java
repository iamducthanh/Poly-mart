package com.polymart.dao;

import com.polymart.model.SanPhamModel;

import java.util.List;

public interface ISanPhamDAO extends GenericDAO<SanPhamModel> {

	List<SanPhamModel> findAll();

}
