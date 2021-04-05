package com.polymart.entity;

import com.polymart.model.NhanVienModel;
import com.polymart.service.impl.NhanVienService;

public class EntityAuthorization {
	// biến lưu giữ giá trị tài khoản đăng nhập
//    public static NhanVienModel USER;

//  hàm lấy dữ liệu nhân viên mẫu không cần đăng nhập
//  Xoá đi khi cần đăng nhập
	public static NhanVienModel USER = new NhanVienService().findAll().get(0);
}
