package com.polymart.dao;

import java.util.List;

import com.polymart.model.NhanVienModel;

public interface INhanVienDAO extends GenericDAO<NhanVienModel> {
	List<NhanVienModel> findAll();

	Integer save(NhanVienModel nhanVienModel);
	
	void update(NhanVienModel nhanVienModel);
	
	void delete(Integer id);
	
	NhanVienModel findOne(Integer id);
}
