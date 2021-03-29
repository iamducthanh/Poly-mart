package com.polymart.controller;

import com.polymart.model.NhanVienModel;

public interface QuanLyNhanVien {
	
	//hàm set thông tin đăng nhập
	void setLogin(String username, String password);
	
	//hàm get thông tin đăng nhập
	NhanVienModel getLogin();
	
	//hàm kiểm Nhân viên tồn tại trong database
	boolean isContainsNhanVien(String username, String password);
}
