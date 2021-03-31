package com.polymart.service;

import java.util.List;

import com.polymart.model.NhanVienModel;

public interface INhanVienService {

    // hàm tìm kiếm người dùng theo Username và password
    NhanVienModel findNhanVienByIdAndPassword(Integer id, String password);
    
    List<NhanVienModel> findAll();

	boolean changePassword(Integer id, String newPassword);

}
