package com.polymart.service;

import java.util.List;
import java.util.Map;

import com.polymart.model.NhanVienModel;

public interface INhanVienService {

	List<NhanVienModel> findAll();

	// hàm tìm kiếm người dùng theo Username và password
	NhanVienModel findByIdAndPassword(Integer id, String password);

	NhanVienModel save(NhanVienModel nhanVienModel);

	NhanVienModel update(NhanVienModel newNhanVienModel);

	void delete(Integer[] ids);

	NhanVienModel findOne(Integer id);

	List<NhanVienModel> filter(String idOrName);

	List<NhanVienModel> filterByChucVu(String chucVu);

	Map<Integer, String> getNameNhanVien();

}
