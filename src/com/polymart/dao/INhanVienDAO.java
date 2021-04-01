package com.polymart.dao;

import java.util.List;

import com.polymart.model.NhanVienModel;

public interface INhanVienDAO {
	List<NhanVienModel> findAll();

	Integer save(NhanVienModel nhanVienModel);

	void update(NhanVienModel nhanVienModel);

	void delete(Integer id);

	NhanVienModel findOne(Integer id);

	List<NhanVienModel> filter(String idOrName);

	List<NhanVienModel> filterByChucVu(String chucVu);
	
	List<NhanVienModel> findByIdAndPassword(String id, String password);
}
