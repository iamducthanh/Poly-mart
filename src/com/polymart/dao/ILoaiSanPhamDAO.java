package com.polymart.dao;

import com.polymart.model.LoaiSanPhamModel;

import java.util.List;

public interface ILoaiSanPhamDAO extends GenericDAO<LoaiSanPhamModel> {

	List<LoaiSanPhamModel> findAll();

}
