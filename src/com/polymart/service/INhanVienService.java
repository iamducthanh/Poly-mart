package com.polymart.service;

import com.polymart.model.NhanVienModel;

public interface INhanVien {

    // hàm tìm kiếm người dùng theo Username và password
    NhanVienModel findNhanVien(Long id, String password);

    boolean changePassword(Long id, String newPassword);

}
