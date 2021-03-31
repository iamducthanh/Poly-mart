package com.polymart.service;

import java.util.List;

import com.polymart.model.NhanVienModel;

public interface INhanVienService extends GenericService<NhanVienModel> {

    // hàm tìm kiếm người dùng theo Username và password
    NhanVienModel findNhanVienByIdAndPassword(Integer id, String password);

	boolean changePassword(Integer id, String newPassword);

}
